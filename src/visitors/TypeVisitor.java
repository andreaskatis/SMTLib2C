package visitors;

import skolem.*;

public interface TypeVisitor<T> {
    public T visit(NamedType e);
}
