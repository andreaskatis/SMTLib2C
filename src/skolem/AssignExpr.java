package skolem;

public class AssignExpr extends Expr {
    public final Expr lhs;
    public final Expr expr;

    public AssignExpr(Location location, Expr lhs, Expr expr) {
        super(location);
        this.lhs = lhs;
        this.expr = expr;
    }

    public AssignExpr(Expr lhs, Expr expr) {
        this(Location.NULL, lhs, expr);
    }


    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expr == null) ? 0 : expr.hashCode());
		result = prime * result + ((lhs == null) ? 0 : lhs.hashCode());
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
		AssignExpr other = (AssignExpr) obj;
		if (expr == null) {
			if (other.expr != null)
				return false;
		} else if (!expr.equals(other.expr))
			return false;
		if (lhs == null) {
			if (other.lhs != null)
				return false;
		} else if (!lhs.equals(other.lhs))
			return false;
		return true;
	}

	@Override
    public <T> T accept(visitors.ExprVisitor<T> visitor) {
        return (T) visitor.visit(this);
    }
}
