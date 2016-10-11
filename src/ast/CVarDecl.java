package ast;

import ast.types.CType;
import visitors.*;


public class CVarDecl extends CAst {
	public final String id;
	public final CType type;
	public final CExpr init;

	public CVarDecl(String id, CType type, CExpr init) {
		this.id = id;
		this.type = type;
		this.init = init;
	}

	public CVarDecl(String id, CType type) {
		this.id = id;
		this.type = type;
		this.init = null;
	}

	@Override
	public <T, S extends T> T accept(CAstVisitor<T, S> visitor) {
		return visitor.visit(this);
	}
}