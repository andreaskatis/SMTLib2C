package skolem;

import visitors.ExprVisitor;

public class UnaryExpr extends Expr {
    public final UnaryOp op;
    public final Expr expr;

    public UnaryExpr(Location location, UnaryOp op, Expr expr) {
        super(location);
        this.op = op;
        this.expr = expr;
    }

    public UnaryExpr(UnaryOp op, Expr expr) {
        this(Location.NULL, op, expr);
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expr == null) ? 0 : expr.hashCode());
		result = prime * result + ((op == null) ? 0 : op.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnaryExpr other = (UnaryExpr) obj;
		if (expr == null) {
			if (other.expr != null)
				return false;
		} else if (!expr.equals(other.expr))
			return false;
		if (op != other.op)
			return false;
		return true;
	}

	@Override
    public <T> T accept(ExprVisitor<T> visitor) {
        return visitor.visit(this);
    }
}