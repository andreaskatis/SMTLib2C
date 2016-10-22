package ast;

import visitors.CExprVisitor;

import java.util.List;

//Class to handle function calls inside other expressions
public class CFunctionCall extends CExpr {
    public final String name;

    public CFunctionCall(String name) {
        this.name = name;
    }

    @Override
    public <T> T accept(CExprVisitor<T> visitor) {
        return visitor.visit(this);
    }
}