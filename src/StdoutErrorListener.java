import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import skolem.Location;

public class StdoutErrorListener extends BaseErrorListener {
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line,
                            int charPositionInLine, String msg, RecognitionException e) {
        Output.println("Parse error line " + line + ":" + charPositionInLine + " " + msg);
        Output.showLocation(new Location(line, charPositionInLine));
    }
}
