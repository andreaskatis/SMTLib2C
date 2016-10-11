package ast;

import visitors.CAstVisitor;

public class CMoveHistory extends CFunction{

    public final String name;
    public final CExpr loop;

    public CMoveHistory(CExpr loop) {
        this.name = "moveHistory";
        this.loop = loop;
    }

    public CMoveHistory() {
        this.name = "moveHistory";
        this.loop = null;
    }

    @Override
    public <T, S extends T> T accept(CAstVisitor<T, S> visitor) {
        return visitor.visit(this);
    }
}
