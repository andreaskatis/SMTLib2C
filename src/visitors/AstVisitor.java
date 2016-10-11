package visitors;

import skolem.*;

public interface AstVisitor<T, S extends T> extends ExprVisitor<S> {
    T visit(Equation equation);
    T visit(Scratch scratch);
    T visit(VarDecl varDecl);
    T visit(Skolem skolem);
}
