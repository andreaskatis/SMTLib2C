package ast;

import visitors.CAstVisitor;

import java.util.List;

public class CPrintFunction extends CFunction{
    public final String name;
    public final List<CExpr> args;

    public CPrintFunction(List<CExpr> args) {
        this.name = "printf";
        this.args = args;
    }


    @Override
    public <T, S extends T> T accept(CAstVisitor<T, S> visitor) {
        return visitor.visit(this);
    }
}