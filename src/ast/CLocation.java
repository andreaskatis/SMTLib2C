package ast;

public class CLocation {
	public final int line;
	public final int charPositionInLine;

	public CLocation(int line, int charPositionInLine) {
		this.line = line;
		this.charPositionInLine = charPositionInLine;
	}
	
	@Override
	public String toString() {
		return line + ":" + charPositionInLine;
	}
	
	public static final CLocation NULL = new CLocation(0, 0);
}
