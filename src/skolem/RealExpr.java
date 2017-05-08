package skolem;

import visitors.ExprVisitor;

import java.math.BigDecimal;

public class RealExpr extends Expr {
    public final BigDecimal value;

    public RealExpr(Location location, BigDecimal value) {
        super(location);
        this.value = value;
    }

    public RealExpr(BigDecimal value) {
        this(Location.NULL, value);
    }
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		RealExpr other = (RealExpr) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
    public <T> T accept(ExprVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
