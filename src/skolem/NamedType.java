package skolem;

import visitors.TypeVisitor;

public class NamedType extends Type {
    public final String name;

    public NamedType(Location location, String name) {
        super(location);
        this.name = name;
    }

    public NamedType(String name) {
        this(Location.NULL, name);
    }

    /*
     * Private constructor for built-in types
     */
    private NamedType(String name, @SuppressWarnings("unused") Object unused) {
        super(Location.NULL);
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static final NamedType BOOL = new NamedType("Bool", null);
    public static final NamedType INT = new NamedType("Int", null);
    public static final NamedType REAL = new NamedType("Real", null);

    public boolean isBuiltin() {
        return this == REAL || this == BOOL || this == INT;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof NamedType)) {
            return false;
        }
        NamedType other = (NamedType) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public <T> T accept(TypeVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

