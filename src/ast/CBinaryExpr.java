package ast;

import visitors.*;

public class CBinaryExpr extends CExpr {
	public final CExpr left;
	public final CBinaryOp op;
	public final CExpr right;
	
	public CBinaryExpr(CExpr left, CBinaryOp op, CExpr right) {
		this.left = left;
		this.op = op;
		this.right = right;
	}

	@Override
	public <T> T accept(CExprVisitor<T> visitor) {
		return visitor.visit(this);
	}
}