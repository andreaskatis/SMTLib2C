package ast;
import java.util.List;

import visitors.*;

public class CProgram extends CAst {
	public final CVarDecl init;
	public final String filename;
	public final List<CArrayDecl> vars;
	public final List<CFunction> functions;

	public CProgram(CVarDecl init, String filename, List<CArrayDecl> vars, List<CFunction> functions) {
		this.init = init;
		this.filename = filename;
		this.vars = vars;
		this.functions = functions;
	}

	@Override
	public <T, S extends T> T accept(CAstVisitor<T, S> visitor) {
		return visitor.visit(this);
	}
}