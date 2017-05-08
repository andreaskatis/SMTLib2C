package visitors;

import java.util.Iterator;
import java.util.List;

import skolem.AssignExpr;
import skolem.BinaryExpr;
import skolem.BoolExpr;
import skolem.CastExpr;
import skolem.Equation;
import skolem.ExitExpr;
import skolem.Expr;
import skolem.IdExpr;
import skolem.IfThenElseExpr;
import skolem.IntExpr;
import skolem.NamedType;
import skolem.RealExpr;
import skolem.Scratch;
import skolem.Skolem;
import skolem.TernaryExpr;
import skolem.Type;
import skolem.UnaryExpr;
import skolem.UnaryOp;
import skolem.VarDecl;

public class SMTLibPrettyPrintVisitor implements AstVisitor<Void, Void>, TypeVisitor<Void> {

	private StringBuilder sb = new StringBuilder();

	@Override
	public String toString() {
		return sb.toString();
	}

	protected void write(Object o) {
		sb.append(o);
	}

	private static final String seperator = System.getProperty("line.separator");
	
	
	private int indentLevel = 0;
	private String indentString = "   ";
	
	public void setIndentString(String i) { 
		indentString = i; 
	}
	
	private void pushIndent() {
		indentLevel++;
	}
	
	private void popIndent() {
		if (indentLevel > 0)
			indentLevel--;
	}
	
	private void indent() {
		int indenter;
		for (indenter = 0; indenter < indentLevel; indenter++) {
			sb.append(indentString);
		}
	}
	
	private void newline() {
		write(seperator);
		indent();
	}

	public void expr(Expr e) {
		e.accept(this);
	}
	
	public void exprList(List<Expr> el) {
		pushIndent();
		newline();
		write("[");
		if (el.size() == 1) { 
			expr(el.get(0)); 
			write("]");
			popIndent();
			newline();
		}
		else {
			el.forEach(e -> { expr(e); newline(); }); 
			write("]");
			popIndent();
		}
	}
	
	@Override
    public Void visit(NamedType e) {
    	write(e.name);
    	return null;
    }

	@Override
	public Void visit(AssignExpr e) {
		write("(");
		expr(e.lhs);
		write(" := ");
		expr(e.expr);
		write(")");
		return null;
	}

	@Override
	public Void visit(BinaryExpr e) {
		write("(");
		expr(e.left);
		write(" ");
		write(e.op);
		write(" ");
		expr(e.right);
		write(")");
		return null;
	}

	@Override
	public Void visit(BoolExpr e) {
		write(Boolean.toString(e.value));
		return null;
	}

	@Override
	public Void visit(CastExpr e) {
		write(getCastFunction(e.type));
		write("(");
		expr(e.expr);
		write(")");
		return null;
	}

	private String getCastFunction(Type type) {
		if (type == NamedType.REAL) {
			return "real";
		} else if (type == NamedType.INT) {
			return "floor";
		} else {
			throw new IllegalArgumentException("Unable to cast to type: " + type);
		}
	}


	@Override
	public Void visit(IdExpr e) {
		write(e.id);
		return null;
	}

	@Override
	public Void visit(IfThenElseExpr e) {
		write("(if ");
		expr(e.cond);
		write(" then ");
		exprList(e.thenExpr);
		write(" else ");
		exprList(e.elseExpr);
		write(")");
		return null;
	}

	@Override
	public Void visit(IntExpr e) {
		write(e.value);
		return null;
	}

	@Override
	public Void visit(RealExpr e) {
		String str = e.value.toPlainString();
		write(str);
		if (!str.contains(".")) {
			write(".0");
		}
		return null;
	}

	@Override
	public Void visit(TernaryExpr e) {
		write("((");
		expr(e.cond);
		write(") ? ");
		exprList(e.thenExpr);
		write(" : ");
		exprList(e.elseExpr);
		write(")");
		return null;
	}

	@Override
	public Void visit(UnaryExpr e) {
		write("(");
		write(e.op);
		if (e.op != UnaryOp.NEGATIVE) {
			write(" ");
		}
		expr(e.expr);
		write(")");
		return null;
	}

	@Override
	public Void visit(ExitExpr e) {
		write("EXIT");
		return null;
	}

	@Override
	public Void visit(Equation e) {
		expr(e.lhs);
		write(" = ");
		expr(e.expr);
		write("; ");
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitors.AstVisitor#visit(skolem.Scratch)
	 *     public final List<VarDecl> inputs;
    public final List<VarDecl> outputs;

    public final List<Skolem> skolems;

	 */
	@Override
	public Void visit(Scratch scratch) {
		write("inputs: ");
		pushIndent();
		newline();
		varDecls(scratch.inputs);
		popIndent();
		newline();
		write("outputs: ");
		pushIndent();
		newline();
		varDecls(scratch.outputs);
		popIndent();
		newline();
		scratch.skolems.forEach(sk -> sk.accept(this));
		return null;
	}

	public void scratch(Scratch scratch) {
		scratch.accept(this);
	}
	
	private void varDecls(List<VarDecl> varDecls) {
		Iterator<VarDecl> iterator = varDecls.iterator();
		while (iterator.hasNext()) {
			iterator.next().accept(this);
			if (iterator.hasNext()) {
				write(";");
				newline();
			}
		}
	}
	
	@Override
	public Void visit(VarDecl varDecl) {
		write(varDecl.id);
		write(" : ");
		write(varDecl.type);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitors.AstVisitor#visit(skolem.Skolem)
	 *     public final List<Equation> equations;
    public final List<Expr> body;

	 */
	@Override
	public Void visit(Skolem skolem) {
		write("skolem: ");
		pushIndent();
			newline();
			write("equations: ");
			pushIndent();
				newline();
				skolem.equations.forEach(eq -> { eq.accept(this); newline(); } );
			popIndent();
			newline();
			write("body: ");
			exprList(skolem.body);
		popIndent();
		newline();
		return null;
	}
}
