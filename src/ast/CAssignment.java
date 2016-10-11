package ast;

import visitors.*;

public class CAssignment extends CExpr {
	public final CExpr varToAssign;
	public final CExpr expr;

	public CAssignment(CExpr varExpr, CExpr expr) {
		this.varToAssign = varExpr;
		this.expr = expr;
	}


	@Override
	public <T> T accept(CExprVisitor<T> visitor) {
		return visitor.visit(this);
	}
}