import skolem.*;
import visitors.SMTLibToLustreVisitor;
import ast.*;

import java.io.*;

public class SMTLib2Lustre {
    public static void main(String[] args) {
        try {
            SMTLib2CSettings settings = SMTLib2CArgumentParser.parse(args);
            Scratch scratch = Main.parseSkolems(settings.filename);
            
            // MWW: temporary
            System.out.println("!!! ORIGINAL !!!");
            visitors.SMTLibPrettyPrintVisitor ppv = new visitors.SMTLibPrettyPrintVisitor();
            ppv.scratch(scratch);
            System.out.println(ppv.toString());
            
            visitors.SMTLibLiftAssignments liftv = new visitors.SMTLibLiftAssignments();
            Scratch lifted = liftv.scratch(scratch);
            System.out.println("!!! LIFTED ASSIGNMENTS !!!");

            ppv = new visitors.SMTLibPrettyPrintVisitor();
            ppv.scratch(lifted);
            System.out.println(ppv.toString());
            // MWW: end temporary
            
            System.out.println("!!! Translating to Lustre !!!");
            String truename = settings.filename.substring(0, settings.filename.lastIndexOf("_"));
            SMTLibToLustreVisitor slv = new SMTLibToLustreVisitor();
            jkind.lustre.Program program = slv.scratch(lifted);

            PrintWriter writerImplementation = new PrintWriter(new FileOutputStream(truename+".lus"));
            writerImplementation.print(program.toString());
            writerImplementation.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}


