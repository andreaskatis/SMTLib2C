package skolem;

import visitors.ExprVisitor;

public class IdExpr extends Expr {
    public final String id;

    public IdExpr(Location location, String id) {
        super(location);
        this.id = id;
    }

    public IdExpr(String id) {
        this(Location.NULL, id);
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		IdExpr other = (IdExpr) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
    public <T> T accept(ExprVisitor<T> visitor) {
        return visitor.visit(this);
    }
}