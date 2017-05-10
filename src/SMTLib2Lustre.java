import skolem.*;
import visitors.JKindToJSynIds;
import visitors.SMTLibToLustreVisitor;
import ast.*;
import jkind.slicing.DependencyMap;
import jkind.slicing.LustreSlicer;
import jkind.translation.RemoveEnumTypes;

import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SMTLib2Lustre {
	
	public static boolean debug = false;
	
    public static void main(String[] args) {
        try {
            SMTLib2LustreSettings settings = SMTLib2LustreArgumentParser.parse(args);
            Scratch scratch = Main.parseSkolems(settings.filename);
            jkind.lustre.Program impl = translateToLustre(scratch);
            jkind.lustre.Node contractNodeOpt = null; 
            
            if (settings.observer != null) {
            	contractNodeOpt = createContractNode(settings);
            }
            
            jkind.lustre.Program program = createMainNode(impl, contractNodeOpt);
            
            String truename = settings.filename.substring(0, settings.filename.lastIndexOf("_"));
            PrintWriter writerImplementation = new PrintWriter(new FileOutputStream(truename+".lus"));
            writerImplementation.print(program.toString());
            writerImplementation.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
    
    public static final String MAIN_NODE = "__TOPLEVEL";
    public static final String CONTRACT_NODE = "__CONTRACT";
    public static final String IMPL_NODE = "__IMPL";
    public static final String ALL_ASSERTS = "__ASSERTS";
    
    
    protected static jkind.lustre.Program createMainNode(jkind.lustre.Program impl, jkind.lustre.Node contractNodeOpt) {
		jkind.lustre.Node implMain = impl.getMainNode(); 
    	
    	// create main node
		jkind.lustre.builders.NodeBuilder nb = new jkind.lustre.builders.NodeBuilder(MAIN_NODE);
		nb.addInputs(implMain.inputs);
		nb.addOutputs(implMain.outputs);
		
		// create call to implementation
		jkind.lustre.builders.EquationBuilder eb = new jkind.lustre.builders.EquationBuilder();
		jkind.lustre.Expr implCall = 
				new jkind.lustre.NodeCallExpr(impl.main, 
						implMain.inputs.stream().map(i -> new jkind.lustre.IdExpr(i.id))
							.collect(Collectors.toList()));
		eb.setExpr(implCall);
		implMain.outputs.forEach(o -> {eb.addLhs(o.id); });
		nb.addEquation(eb.build());
		
		// create call to monitor (if it exists)
		if (contractNodeOpt != null) {
			// add variable for asserts
			nb.addLocals(contractNodeOpt.outputs);

			jkind.lustre.builders.EquationBuilder ceb = new jkind.lustre.builders.EquationBuilder();
			
			// make sure the interfaces match up...
			contractNodeOpt.inputs.forEach(i -> { 
				if (!Stream.concat(implMain.inputs.stream(), implMain.outputs.stream())
						.anyMatch(e -> i.id.equals(e.id))) {
					throw new Error("Error: contract input " + i.id + " not found in implementation.");
				}
			}  );

			// build contract call & assert
			jkind.lustre.Expr contractCall = 
					new jkind.lustre.NodeCallExpr(CONTRACT_NODE, 
						contractNodeOpt.inputs.stream().map(i -> new jkind.lustre.IdExpr(i.id))
							.collect(Collectors.toList()));
			ceb.setExpr(contractCall);
			contractNodeOpt.outputs.stream().forEach(i -> { ceb.addLhs(i.id); });
			nb.addEquation(ceb.build());
			nb.addAssertion(new jkind.lustre.IdExpr(ALL_ASSERTS));
		}

		jkind.lustre.Node mainNode = nb.build();
		
		// construct program
		jkind.lustre.builders.ProgramBuilder pb = new jkind.lustre.builders.ProgramBuilder();
		pb.addNodes(impl.nodes);
		if (contractNodeOpt != null) {
			pb.addNode(contractNodeOpt);
		}
		pb.addNode(mainNode);
		pb.setMain(mainNode.id);
		jkind.lustre.Program lustre = pb.build();
		
		if (debug) {
			System.out.println("Main program: ");
			System.out.println(lustre.toString());
		}
		return lustre;

    }
    
    
    protected static jkind.lustre.Node createContractNode(SMTLib2LustreSettings settings) {
    	String filename = settings.observer;
    	String mainNode = settings.main;

    	try {
	    	jkind.lustre.Program program = jkind.Main.parseLustre(filename);
			jkind.lustre.Node main = jkind.translation.Translate.translate(program);
			main = RemoveEnumTypes.node(main);
			DependencyMap dependencyMap = new DependencyMap(main, main.properties);
			main = LustreSlicer.slice(main, dependencyMap);
			main = JKindToJSynIds.node(main);
			
			jkind.lustre.builders.NodeBuilder nb = new jkind.lustre.builders.NodeBuilder("__CONTRACT");
			nb.addInputs(main.inputs);
			nb.addOutput(new jkind.lustre.VarDecl(ALL_ASSERTS, jkind.lustre.NamedType.BOOL));
			nb.addOutputs(main.outputs);
			nb.addLocals(main.locals);
			nb.addEquations(main.equations);
			nb.addProperties(main.properties);
			nb.addIvcs(main.ivc);
			
			// do lift of assertions here...
			jkind.lustre.Expr assertExpr = main.assertions.stream().reduce(
					new jkind.lustre.BoolExpr(true), 
					(s, t) -> new jkind.lustre.BinaryExpr(s, jkind.lustre.BinaryOp.AND, t)); 
			jkind.lustre.builders.EquationBuilder eb = new jkind.lustre.builders.EquationBuilder();
			eb.addLhs("__ASSERTS");
			eb.setExpr(assertExpr);
			nb.addEquation(eb.build());
			
			jkind.lustre.Node contract = nb.build();
			
			if (debug) {
			System.out.println("Contract node: ");
			System.out.println(contract.toString());
			}
			
			return contract;
    	} catch (IOException e) {
    		e.printStackTrace();
    		System.exit(0);
        	return null;
    	}
    }
    
    protected static jkind.lustre.Program translateToLustre(Scratch scratch) {
    	
    	if (debug) {
	    	visitors.SMTLibPrettyPrintVisitor ppv = new visitors.SMTLibPrettyPrintVisitor();
	        ppv.scratch(scratch);
	        System.out.println("!!! ORIGINAL !!!");
	        System.out.println(ppv.toString());
    	}
    	
        visitors.SMTLibLiftAssignments liftv = new visitors.SMTLibLiftAssignments();
        Scratch lifted = liftv.scratch(scratch);

        if (debug) {
            System.out.println("!!! LIFTED ASSIGNMENTS !!!");
	    	visitors.SMTLibPrettyPrintVisitor ppv = new visitors.SMTLibPrettyPrintVisitor();
	        ppv.scratch(lifted);
	        System.out.println(ppv.toString());
	        System.out.println("!!! Translating to Lustre !!!");
        }
        SMTLibToLustreVisitor slv = new SMTLibToLustreVisitor();
        jkind.lustre.Program program = slv.scratch(lifted);

        if (debug) {// MWW TEMPORARY
			System.out.println("Main program: ");
			System.out.println(program.toString());
        } // END MWW TEMPORARY
        return program;
    }
}


