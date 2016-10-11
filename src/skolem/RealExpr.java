package skolem;

import visitors.ExprVisitor;

import java.math.BigDecimal;

public class RealExpr extends Expr {
    public final BigDecimal value;

    public RealExpr(Location location, BigDecimal value) {
        super(location);
        this.value = value;
    }

    public RealExpr(BigDecimal value) {
        this(Location.NULL, value);
    }

    @Override
    public <T> T accept(ExprVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
