package ast;

public enum CUnaryOp {
	NEGATIVE ("-"),
	MINUSMINUS ("--"),
	PLUSPLUS ("++"),
	NOT ("!");
	
	private String str;
	
	private CUnaryOp(String str) {
		this.str = str;
	}
	
	@Override
	public String toString() {
		return str;
	}
	
	public static CUnaryOp fromString(String string) {
		for (CUnaryOp op : CUnaryOp.values()) {
			if (op.name().equals(string)) {
				return op;
			}
		}
		return null;
	}
}
