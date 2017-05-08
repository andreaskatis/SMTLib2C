package skolem;

import visitors.ExprVisitor;

public class BoolExpr extends Expr {
    public final boolean value;

    public BoolExpr(Location location, boolean value) {
        super(location);
        this.value = value;
    }

    public BoolExpr(boolean value) {
        this(Location.NULL, value);
    }
    
    
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (value ? 1231 : 1237);
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
		BoolExpr other = (BoolExpr) obj;
		if (value != other.value)
			return false;
		return true;
	}

	@Override
    public <T> T accept(ExprVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
