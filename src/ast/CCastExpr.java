package ast;

import ast.types.CType;
import visitors.*;

public class CCastExpr extends CExpr {
	public final CType type;
	public final CExpr expr;

	public CCastExpr(CType type, CExpr expr) {
		this.type = type;
		this.expr = expr;
	}

	@Override
	public <T> T accept(CExprVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
