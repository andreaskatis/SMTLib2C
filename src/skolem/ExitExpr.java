package skolem;

import visitors.*;

/**
 * Created by dr41k on 9/29/16.
 */
public class ExitExpr extends Expr {

    public ExitExpr(Location location) {
        super(location);
    }

    public ExitExpr() {
        this(Location.NULL);
    }

    @Override
    public <T> T accept(visitors.ExprVisitor<T> visitor) {
        return visitor.visit(this);
    }
}