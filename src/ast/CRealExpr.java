package ast;

import visitors.*;

public class CRealExpr extends CExpr {
	public final double value;

	public CRealExpr(double value) {
		this.value = value;
	}

	@Override
	public <T> T accept(CExprVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
