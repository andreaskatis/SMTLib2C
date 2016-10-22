package ast;

import visitors.CExprVisitor;

import java.util.List;

//class to handle expressions that only contain a function call
public class CFunctionCallExpr extends CExpr {
	public final String name;
    public final List<CExpr> args;

    public CFunctionCallExpr(String name, List<CExpr> args) {
        this.name = name;
        this.args = args;
    }

    public CFunctionCallExpr(String name) {
        this.name = name;
        this.args = null;
    }

    @Override
    public <T> T accept(CExprVisitor<T> visitor) {
        return visitor.visit(this);
    }
}