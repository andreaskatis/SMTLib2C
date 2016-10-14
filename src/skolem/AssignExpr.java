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
    public <T> T accept(visitors.ExprVisitor<T> visitor) {
        return (T) visitor.visit(this);
    }
}
