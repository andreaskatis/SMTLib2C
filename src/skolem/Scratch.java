package skolem;

import visitors.AstVisitor;
import java.util.List;

public class Scratch extends Ast {
    public final List<Skolem> skolems;

    public Scratch(Location location,
                   List<Skolem> skolems) {
        super(location);
        this.skolems = skolems;
    }

    public Scratch(List<Skolem> skolems) {
        this(Location.NULL, skolems);
    }

    @Override
    public <T, S extends T> T accept(AstVisitor<T, S> visitor) {
        return visitor.visit(this);
    }
}
