package ast;

import visitors.*;

public class CDoubleExpr extends CExpr {
	public final double value;

	public CDoubleExpr(double value) {
		this.value = value;
	}

	@Override
	public <T> T accept(CExprVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
