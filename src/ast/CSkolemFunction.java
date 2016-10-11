package ast;

import visitors.CAstVisitor;

import java.util.List;

public class CSkolemFunction extends CFunction{
    public final String name;
    public List<CExpr> body;

    public CSkolemFunction(String name, List<CExpr> body) {
        this.name = name;
        this.body = body;
    }

    public CSkolemFunction(String name) {
        this.name = name;
        this.body = null;
    }

    @Override
    public <T, S extends T> T accept(CAstVisitor<T, S> visitor) {
        return visitor.visit(this);
    }
}
