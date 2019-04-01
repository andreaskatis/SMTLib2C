package ast;

import visitors.CExprVisitor;

import java.util.List;

//Class to handle function calls inside other expressions
public class CFunctionCall extends CExpr {
    public final String name;
    public final List<CExpr> funArgExprs;

    public CFunctionCall(String name, List<CExpr> funArgExprs) {
        this.name = name;
        this.funArgExprs = funArgExprs;
    }


    public CFunctionCall(String name) {
        this.name = name;
        this.funArgExprs = null;
    }

    @Override
    public <T> T accept(CExprVisitor<T> visitor) {
        return visitor.visit(this);
    }
}