import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import com.sun.org.apache.regexp.internal.RE;
import jkind.lustre.*;
import jkind.lustre.NamedType;
import jkind.lustre.VarDecl;
import skolem.*;
import visitors.JKindToJSynIds;
import visitors.SMTLibToLustreVisitor;
import ast.*;
import jkind.slicing.DependencyMap;
import jkind.slicing.LustreSlicer;
import jkind.translation.RemoveEnumTypes;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SMTLib2Lustre {
	
	public static boolean debug = false;

    public static void main(String[] args) {
        try {
            SMTLib2LustreSettings settings = SMTLib2LustreArgumentParser.parse(args);
            Scratch scratch = Main.parseSkolems(settings.filename);
            String truename = settings.filename.substring(0, settings.filename.lastIndexOf("_"));
            
            jkind.lustre.Program impl = translateToLustre(truename, scratch);
            jkind.lustre.Node contractNodeOpt = null; 
            
            if (settings.observer != null) {
            	contractNodeOpt = createContractNode(settings);
            }
            
            jkind.lustre.Program program = createMainNode(impl, contractNodeOpt);

            printToFile(truename+".new.lus", program.toString());

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
    
    public static void printToFile(String fileName, String result) {
    	try {
    		PrintWriter writerImplementation = new PrintWriter(new FileOutputStream(fileName));
	        writerImplementation.print(result.toString());
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
    
    
    protected static boolean inputMatches (jkind.lustre.Node implMain, jkind.lustre.VarDecl i) { 
		return (Stream.concat(implMain.inputs.stream(), implMain.outputs.stream())
				.anyMatch(e -> i.id.equals(e.id))); 
    }
    

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
	
			// build contract call & assert
			jkind.lustre.Expr contractCall = 
					new jkind.lustre.NodeCallExpr(CONTRACT_NODE, 
						contractNodeOpt.inputs.stream().map(i -> {
							if (inputMatches(implMain, i)) {
								return new jkind.lustre.IdExpr(i.id);
							} else {
								System.out.println("WARNING: using default value for contract input: " + i.id);							
								jkind.translation.DefaultValueVisitor dvv = new jkind.translation.DefaultValueVisitor();
								return i.type.accept(dvv);
							}})
							.collect(Collectors.toList()));
			ceb.setExpr(contractCall);
			contractNodeOpt.outputs.stream().forEach(i -> { ceb.addLhs(i.id); });
			nb.addEquation(ceb.build());
			nb.addAssertion(new jkind.lustre.IdExpr(ALL_ASSERTS));
            nb.addAssertions(impl.getMainNode().assertions);
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


        List<jkind.lustre.VarDecl> rngArgs = new ArrayList<>();
        rngArgs.add(new jkind.lustre.VarDecl("lflag", jkind.lustre.NamedType.BOOL));
        rngArgs.add(new jkind.lustre.VarDecl("uflag", jkind.lustre.NamedType.BOOL));
        jkind.lustre.Type rngType;
        for (jkind.lustre.VarDecl out : implMain.outputs) {
            if (out.id.startsWith("_aeval_tmp_rand")) {
                rngType = out.type;
                rngArgs.add(new jkind.lustre.VarDecl("lbound", rngType));
                rngArgs.add(new jkind.lustre.VarDecl("ubound", rngType));
                pb.addFunction(new Function("generateRandomValue", rngArgs,
                        new jkind.lustre.VarDecl("randomValue", rngType)));
                break;
            }
        }

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
            jkind.lustre.Program translatedProgram = jkind.translation.Translate.translate(program);
//			jkind.lustre.Node main = jkind.translation.Translate.translate(program);
//			main = RemoveEnumTypes.node(main);
            translatedProgram = RemoveEnumTypes.program(translatedProgram);
            jkind.lustre.Node main = translatedProgram.getMainNode();
            DependencyMap dependencyMap = new DependencyMap(main, main.properties, translatedProgram.functions);
            main = LustreSlicer.slice(main, dependencyMap);
            main = JKindToJSynIds.node(main);
//
//            DependencyMap dependencyMap = new DependencyMap(main, main.properties);
//			main = LustreSlicer.slice(main, dependencyMap);
//			main = JKindToJSynIds.node(main);
			
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
			printToFile(filename + ".contract.lus.kind", contract.toString());
						
			return contract;
    	} catch (Exception e) {
    		e.printStackTrace();
    		System.exit(0);
        	return null;
    	}
    }
    
    protected static jkind.lustre.Program translateToLustre(String fileName, Scratch scratch) {
    	
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
		printToFile(fileName + ".impl.lus.kind", program.toString());
        return program;
    }
}


