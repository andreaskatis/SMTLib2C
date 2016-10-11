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
    public <T> T accept(ExprVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
