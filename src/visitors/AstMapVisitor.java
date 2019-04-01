package visitors;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import skolem.Ast;
import skolem.Equation;
import skolem.Expr;
import skolem.IdExpr;
import skolem.Scratch;
import skolem.Skolem;
import skolem.VarDecl;

public class AstMapVisitor extends ExprMapVisitor implements AstVisitor<Ast, Expr> {

	public Expr expr(Expr e) {
		return e.accept(this);
	}
	

	@Override
	public Equation visit(Equation equation) {
		return new Equation(equation.location, (IdExpr)equation.lhs.accept(this), (Expr)equation.expr.accept(this));
	}

	public List<Equation> equationList(List<Equation> l) {
		return map(e -> (Equation)e.accept(this), l);
	}

	public List<VarDecl> varDeclList(List<VarDecl> l) {
		return map(e -> (VarDecl)e.accept(this), l);
	}
	
	public List<Skolem> skolemList(List<Skolem> l) {
		return map(e -> (Skolem)e.accept(this), l);
	}
	
	@Override
	public Scratch visit(Scratch scratch) {
        Map<String, List<Expr>> rngNames = new HashMap<>();
		return new Scratch(scratch.location, varDeclList(scratch.inputs), varDeclList(scratch.outputs), skolemList(scratch.skolems), rngNames);
	}

	@Override
	public VarDecl visit(VarDecl varDecl) {
		return new VarDecl(varDecl.location, varDecl.id, varDecl.type);
	}

	@Override
	public Skolem visit(Skolem skolem) {
		return new Skolem(skolem.location, equationList(skolem.equations), exprList(skolem.body));
	}

}
