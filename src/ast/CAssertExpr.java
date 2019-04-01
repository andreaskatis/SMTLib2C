package ast;

import visitors.CExprVisitor;

public class CAssertExpr extends CExpr {

    public final CExpr expr;

    public CAssertExpr(CExpr expr) {
        this.expr = expr;
    }

    @Override
    public <T> T accept(CExprVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
