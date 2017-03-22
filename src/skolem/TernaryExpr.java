package skolem;

import java.util.List;

public class TernaryExpr extends Expr {
    public final Expr cond;
    public final List<Expr> thenExpr;
    public final List<Expr> elseExpr;

    public TernaryExpr(Location location, Expr cond, List<Expr> thenExpr, List<Expr> elseExpr) {
        super(location);
        this.cond = cond;
        this.thenExpr = thenExpr;
        this.elseExpr = elseExpr;
    }

    public TernaryExpr(Expr cond, List<Expr> thenExpr, List<Expr> elseExpr) {
        this(Location.NULL, cond, thenExpr, elseExpr);
    }

    @Override
    public <T> T accept(visitors.ExprVisitor<T> visitor) {
        return visitor.visit(this);
    }
}