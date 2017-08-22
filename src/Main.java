import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;

import parsing.smtlib.SMTLIB2Lexer;
import parsing.smtlib.SMTLIB2Parser;
import parsing.smtlib.SMTLIB2ToAstVisitor;
import skolem.*;
import parsing.smtlib.SMTLIB2Parser.*;

public class Main {
    public static final String VERSION = "1.0";

    public static void main(String[] args) {
        if (args == null) {
            Output.println("SMTLIB2C " + VERSION);
            System.exit(0);
        }

        SMTLib2C.main(args);

        //SMTLib2Lustre.main(args);
    }

    public static Scratch parseSkolems(String filename) throws IOException, RecognitionException {
        File file = new File(filename);
        if (!file.exists() || !file.isFile()) {
            Output.fatal(ExitCodes.FILE_NOT_FOUND, "cannot find file " + filename);
        }
        if (!file.canRead()) {
            Output.fatal(ExitCodes.FILE_NOT_READABLE, "cannot read file " + filename);
        }

        Output.setLocationReference(readAllLines(filename));
        return parseSkolems(new ANTLRFileStream(filename));
    }

    private static List<String> readAllLines(String filename) {
        Path path = FileSystems.getDefault().getPath(filename);
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    public static Scratch parseSkolems(CharStream stream) throws RecognitionException {
        SMTLIB2Lexer lexer = new SMTLIB2Lexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SMTLIB2Parser parser = new SMTLIB2Parser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new StdoutErrorListener());
        ScratchContext scratch = parser.scratch();

        if (parser.getNumberOfSyntaxErrors() > 0) {
            System.exit(ExitCodes.PARSE_ERROR);
        }

        return new SMTLIB2ToAstVisitor().scratch(scratch);
    }
}
