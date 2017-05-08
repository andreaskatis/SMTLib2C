package skolem;
import visitors.ExprVisitor;

public class BinaryExpr extends Expr {
    public final Expr left;
    public final BinaryOp op;
    public final Expr right;

    public BinaryExpr(Location location, Expr left, BinaryOp op, Expr right) {
        super(location);
        this.left = left;
        this.op = op;
        this.right = right;
    }

    public BinaryExpr(Expr left, BinaryOp op, Expr right) {
        this(Location.NULL, left, op, right);
    }

    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((op == null) ? 0 : op.hashCode());
		result = prime * result + ((right == null) ? 0 : right.hashCode());
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
		BinaryExpr other = (BinaryExpr) obj;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (op != other.op)
			return false;
		if (right == null) {
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right))
			return false;
		return true;
	}

	@Override
    public <T> T accept(ExprVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
