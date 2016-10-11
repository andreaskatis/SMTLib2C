package ast;

import visitors.*;

import java.util.List;


public class CIfThenElseExpr extends CExpr {
	public final CExpr cond;
	public final List<CExpr> thenExpr;
	public final List<CExpr> elseExpr;
	
	public CIfThenElseExpr(CExpr cond, List<CExpr> thenExpr, List<CExpr> elseExpr) {
		this.cond = cond;
		this.thenExpr = thenExpr;
		this.elseExpr = elseExpr;
	}

	@Override
	public <T> T accept(CExprVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
