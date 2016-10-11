package skolem;

import visitors.AstVisitor;

public class VarDecl extends Ast {
    public final String id;
    public final Type type;

    public VarDecl(Location location, String id, Type type) {
        super(location);
        this.id = id;
        this.type = type;
    }

    public VarDecl(String id, Type type) {
        this(Location.NULL, id, type);
    }

    @Override
    public <T, S extends T> T accept(AstVisitor<T, S> visitor) {
        return visitor.visit(this);
    }
}
