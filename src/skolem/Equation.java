package skolem;

import visitors.*;

public class Equation extends Ast {
    public final IdExpr lhs;
    public final Expr expr;

    public Equation(Location location, IdExpr lhs, Expr expr) {
        super(location);
        this.lhs = lhs;
        this.expr = expr;
    }

    @Override
    public <T, S extends T> T accept(AstVisitor<T, S> visitor) {
        return visitor.visit(this);
    }
}
