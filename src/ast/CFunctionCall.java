package ast;

import visitors.CExprVisitor;

import java.util.List;

public class CFunctionCall extends CExpr {
    public final String name;
//    public final List<CExpr> args;

//    public CFunctionCall(String name, List<CExpr> args) {
//        this.name = name;
//        this.args = args;
//    }

    public CFunctionCall(String name) {
        this.name = name;
//        this.args = null;
    }

    @Override
    public <T> T accept(CExprVisitor<T> visitor) {
        return visitor.visit(this);
    }
}