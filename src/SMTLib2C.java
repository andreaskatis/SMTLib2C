import skolem.*;
import ast.*;

import java.io.*;

public class SMTLib2C {
    public static void main(String[] args) {
        try {
            SMTLib2CSettings settings = SMTLib2CArgumentParser.parse(args);
            Scratch scratch = Main.parseSkolems(settings.filename);
                        
            String truename = settings.filename.substring(0, settings.filename.lastIndexOf("_"));
            CHeader header = SkolemstoCtranslator.addHeader(scratch, truename, settings.rngvalues);
            CProgram program = SkolemstoCtranslator.translate(scratch, truename, settings.rngvalues);

            PrintWriter writerHeader = new PrintWriter(new FileOutputStream(truename+".h"));
            writerHeader.print(header.toString());
            writerHeader.close();

            PrintWriter writerImplementation = new PrintWriter(new FileOutputStream(truename+".c"));
            writerImplementation.print(program.toString());
            writerImplementation.close();

            if (settings.harnessC) {
                CHarness harnessc = SkolemstoCtranslator.addHarnessC(scratch, truename, settings.iteration);
                PrintWriter writerHarnessC = new PrintWriter(new FileOutputStream(truename+"_harness.c"));
                writerHarnessC.print(harnessc.toString());
                writerHarnessC.close();
            }

            if (settings.harnessLustreC) {
                LustreCHarness harnessLustreC = SkolemstoCtranslator.addHarnessLustreC(scratch, truename, settings.lustrecnode, settings.iteration);
                PrintWriter writerHarnessLustreC = new PrintWriter(new FileOutputStream(truename+"_opt_harness_lus2lic.c"));
                writerHarnessLustreC.print(harnessLustreC.toString());
                writerHarnessLustreC.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}


