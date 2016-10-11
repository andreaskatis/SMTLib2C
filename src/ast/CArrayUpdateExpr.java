package ast;

import visitors.*;

public class CArrayUpdateExpr extends CExpr {
	public final CIdExpr id;
	public final CExpr index;
	public final CExpr value;
	
	public CArrayUpdateExpr(CIdExpr id, CExpr index, CExpr value) {
		this.id = id;
		this.index = index;
		this.value = value;
	}

	@Override
	public <T> T accept(CExprVisitor<T> visitor) {
		return visitor.visit(this);
	}
}