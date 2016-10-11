package ast;

import visitors.*;

public class CArrayAccessExpr extends CExpr {
	public final CIdExpr name;
	public final CExpr index;
	
	public CArrayAccessExpr(CIdExpr name, CExpr index) {
		this.name = name;
		this.index = index;
	}

	@Override
	public <T> T accept(CExprVisitor<T> visitor) {
		return visitor.visit(this);
	}
}