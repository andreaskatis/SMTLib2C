package ast;

import visitors.*;

public class CUnaryExpr extends CExpr {
	public final CUnaryOp op;
	public final CExpr expr;

	public CUnaryExpr(CUnaryOp op, CExpr expr) {
		this.op = op;
		this.expr = expr;
	}

	@Override
	public <T> T accept(CExprVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
