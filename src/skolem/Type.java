package skolem;

import visitors.TypeVisitor;

public abstract class Type {
    public final Location location;

    protected Type(Location location) {
        this.location = location;
    }

    public abstract <T> T accept(TypeVisitor<T> visitor);
}