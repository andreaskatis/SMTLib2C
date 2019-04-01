package skolem;

public class AssertExpr extends Expr {
    public final Expr expr;

    public AssertExpr(Location location, Expr expr) {
        super(location);
        this.expr = expr;
    }

    public AssertExpr(Expr expr) {
        this(Location.NULL, expr);
    }

    @Override
    public <T> T accept(visitors.ExprVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
