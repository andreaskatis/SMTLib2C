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
    public <T> T accept(ExprVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
