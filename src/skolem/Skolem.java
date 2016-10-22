package skolem;

import java.util.List;

import visitors.AstVisitor;

public class Skolem extends Ast {
    public final List<Equation> equations;
    public final List<Expr> body;

    public Skolem(Location location, List<Equation> equations, List<Expr> body) {
        super(location);
        this.equations = equations;
        this.body = body;
    }

    @Override
    public <T, S extends T> T accept(AstVisitor<T, S> visitor) {
        return visitor.visit(this);
    }
}
