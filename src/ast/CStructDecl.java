package ast;
import ast.types.CType;
import visitors.CAstVisitor;


public class CStructDecl extends CAst{

    public final String id;
    public final CType type;

    public CStructDecl(String id, CType type) {
        this.id = id;
        this.type = type;
    }

    @Override
    public <T, S extends T> T accept(CAstVisitor<T, S> visitor) {
        return visitor.visit(this);
    }
}