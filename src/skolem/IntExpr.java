package skolem;

import visitors.ExprVisitor;

import java.math.BigInteger;

public class IntExpr extends Expr {
    public final BigInteger value;

    public IntExpr(Location location, BigInteger value) {
        super(location);
        this.value = value;
    }

    @Override
    public <T> T accept(ExprVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
