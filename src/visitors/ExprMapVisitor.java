package visitors;

import java.util.List;
import java.util.stream.Collectors;

import skolem.AssignExpr;
import skolem.BinaryExpr;
import skolem.BoolExpr;
import skolem.CastExpr;
import skolem.ExitExpr;
import skolem.Expr;
import skolem.IdExpr;
import skolem.IfThenElseExpr;
import skolem.IntExpr;
import skolem.RealExpr;
import skolem.TernaryExpr;
import skolem.UnaryExpr;

public class ExprMapVisitor implements ExprVisitor<Expr> {

	public Expr expr(Expr e) {
		return e.accept(this);
	}
	
	public List<Expr> exprList(List<Expr> el) {
		return el.stream().map(e -> expr(e)).collect(Collectors.toList());
	}
	
	@Override
	public Expr visit(AssignExpr e) {
		return new AssignExpr(e.location, expr(e.lhs), expr(e.expr));
	}

	@Override
	public Expr visit(BinaryExpr e) {
		return new BinaryExpr(e.location, expr(e.left), e.op, expr(e.right));
	}

	@Override
	public Expr visit(BoolExpr e) {
		return new BoolExpr(e.location, e.value);
	}

	@Override
	public Expr visit(CastExpr e) {
		return new CastExpr(e.location, e.type, expr(e.expr));
	}

	@Override
	public Expr visit(IdExpr e) {
		return new IdExpr(e.location, e.id);
	}

	@Override
	public Expr visit(IfThenElseExpr e) {
		return new IfThenElseExpr(e.location, e.cond, exprList(e.thenExpr), exprList(e.elseExpr));
	}

	@Override
	public Expr visit(IntExpr e) {
		return new IntExpr(e.location, e.value);
	}

	@Override
	public Expr visit(RealExpr e) {
		return new RealExpr(e.location, e.value);
	}

	@Override
	public Expr visit(TernaryExpr e) {
		return new TernaryExpr(e.location, e.cond, exprList(e.thenExpr), exprList(e.elseExpr));
	}

	@Override
	public Expr visit(UnaryExpr e) {
		return new UnaryExpr(e.location, e.op, e.expr);
	}

	@Override
	public Expr visit(ExitExpr e) {
		return new ExitExpr(e.location);
	}

}
