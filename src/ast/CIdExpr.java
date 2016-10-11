package ast;

import visitors.*;


public class CIdExpr extends CExpr {
	public final String id;
	
	public CIdExpr(String id) {
		this.id = id;
	}
	

	@Override
	public <T> T accept(CExprVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
