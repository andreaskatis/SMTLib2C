package visitors;

import jkind.lustre.visitors.AstMapVisitor;
import jkind.lustre.Equation;
import jkind.lustre.IdExpr;
import jkind.lustre.Node;
import jkind.lustre.VarDecl;

public class JKindToJSynIds extends AstMapVisitor {
	@Override
	public VarDecl visit(VarDecl e) {
		return new VarDecl(e.location, encode(e.id), e.type);
	}

	@Override
	public Equation visit(Equation e) {
		return super.visit(new Equation(e.location, map(this::visit, e.lhs), e.expr));
	}

	@Override
	public IdExpr visit(IdExpr e) {
		return new IdExpr(e.location, encode(e.id));
	}

	@Override
	protected String visitProperty(String e) {
		return encode(e);
	}

	private String encode(String str) {
		str = str.replaceAll("\\.", "_");
		str = str.replaceAll("\\[", "_");
		str = str.replaceAll("\\]", "_");
		str = str.replaceAll("\\~", "_");
		return str;
	}
	
	public static Node node(Node n) {
		JKindToJSynIds visitor = new JKindToJSynIds();
		return (Node)n.accept(visitor);
	}
}
