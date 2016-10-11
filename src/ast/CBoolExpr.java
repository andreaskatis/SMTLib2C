package ast;

import visitors.*;

public class CBoolExpr extends CExpr {
	public final boolean value;

	public CBoolExpr(boolean value) {
		this.value = value;
	}
	
	@Override
	public <T> T accept(CExprVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
