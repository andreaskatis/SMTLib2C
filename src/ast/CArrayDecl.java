package ast;


import ast.types.CType;
import visitors.*;

public class CArrayDecl extends CAst {
	public final CIdExpr id;
	public final CType type;
	public final Integer size;

	public CArrayDecl(CIdExpr id, CType type, Integer size) {
		this.id = id;
		this.type = type;
		this.size = size;
	}

	@Override
	public <T, S extends T> T accept(CAstVisitor<T, S> visitor) {
		return visitor.visit(this);
	}
}
