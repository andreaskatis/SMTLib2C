package ast;

import visitors.CAstVisitor;

public class CUpdateFunction extends CFunction{
    public final String name;
    public final CExpr body;

    public CUpdateFunction(CExpr body) {
        this.name = "updateFunction";
        this.body = body;
    }

    public CUpdateFunction() {
        this.name = "updateFunction";
        this.body = null;
    }


    @Override
    public <T, S extends T> T accept(CAstVisitor<T, S> visitor) {
        return visitor.visit(this);
    }
}
