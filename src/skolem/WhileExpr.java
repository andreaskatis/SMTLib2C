package skolem;

import visitors.*;

public class WhileExpr extends Expr {
    public final Expr condExpr;
    public final Expr bodyExpr;

    public WhileExpr(Location location, Expr cond, Expr body) {
        super(location);
        this.condExpr = cond;
        this.bodyExpr = body;
    }

    public WhileExpr(Expr cond, Expr body) {
        this(Location.NULL, cond, body);
    }

    @Override
    public <T> T accept(visitors.ExprVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
