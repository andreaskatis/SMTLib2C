package visitors;

import ast.types.*;

public interface CTypeVisitor<T> {
	public T visit(CArrayType e);
	public T visit(CNamedType e);
}
