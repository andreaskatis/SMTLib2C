package skolem;

import visitors.ExprVisitor;

public class CastExpr extends Expr {
    public final Type type;
    public final Expr expr;

    public CastExpr(Location location, Type type, Expr expr) {
        super(location);
        this.type = type;
        this.expr = expr;
    }

    public CastExpr(Type type, Expr expr) {
        this(Location.NULL, type, expr);
    }

    
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expr == null) ? 0 : expr.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		CastExpr other = (CastExpr) obj;
		if (expr == null) {
			if (other.expr != null)
				return false;
		} else if (!expr.equals(other.expr))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
    public <T> T accept(ExprVisitor<T> visitor) {
        return (T) visitor.visit(this);
    }
}

