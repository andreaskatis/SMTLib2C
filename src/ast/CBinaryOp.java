package ast;

public enum CBinaryOp {
	PLUS ("+"),
	MINUS ("-"),
	MULTIPLY ("*"),
	DIVIDE ("/"),
	MODULUS ("%"),
	EQUAL ("=="),
	NOTEQUAL ("<>"),
	GREATER (">"),
	LESS ("<"),
	GREATEREQUAL (">="),
	LESSEQUAL ("<="),
	OR ("||"),
	AND ("&&"),
	XOR ("^");
	
	private String str;
	
	private CBinaryOp(String str) {
		this.str = str;
	}
	
	@Override
	public String toString() {
		return str;
	}
	
	public static CBinaryOp fromString(String string) {
		for (CBinaryOp op : CBinaryOp.values()) {
			if (op.name().equals(string)) {
				return op;
			}
		}
		throw new IllegalArgumentException("Unknown binary operator: " + string);
	}
}
