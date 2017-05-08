package skolem;

import visitors.ExprVisitor;

import java.util.List;

public class IfThenElseExpr extends Expr {
    public final Expr cond;
    public final List<Expr> thenExpr;
    public final List<Expr> elseExpr;

    public IfThenElseExpr(Location location, Expr cond, List<Expr> thenExpr, List<Expr> elseExpr) {
        super(location);
        this.cond = cond;
        this.thenExpr = thenExpr;
        this.elseExpr = elseExpr;
    }

    public IfThenElseExpr(Expr cond, List<Expr> thenExpr, List<Expr> elseExpr) {
        this(Location.NULL, cond, thenExpr, elseExpr);
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cond == null) ? 0 : cond.hashCode());
		result = prime * result + ((elseExpr == null) ? 0 : elseExpr.hashCode());
		result = prime * result + ((thenExpr == null) ? 0 : thenExpr.hashCode());
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
		IfThenElseExpr other = (IfThenElseExpr) obj;
		if (cond == null) {
			if (other.cond != null)
				return false;
		} else if (!cond.equals(other.cond))
			return false;
		if (elseExpr == null) {
			if (other.elseExpr != null)
				return false;
		} else if (!elseExpr.equals(other.elseExpr))
			return false;
		if (thenExpr == null) {
			if (other.thenExpr != null)
				return false;
		} else if (!thenExpr.equals(other.thenExpr))
			return false;
		return true;
	}

	@Override
    public <T> T accept(ExprVisitor<T> visitor) {
        return visitor.visit(this);
    }
}