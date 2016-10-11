package skolem;

import visitors.AstVisitor;

public abstract class Ast {
    public final Location location;

    public Ast(Location location) {
        this.location = location;
    }

    public abstract <T, S extends T> T accept(AstVisitor<T, S> var1);
}

