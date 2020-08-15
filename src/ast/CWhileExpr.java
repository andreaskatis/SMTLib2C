package ast;

import visitors.CExprVisitor;

public class CWhileExpr extends CExpr {
    public final CExpr condExpr;
    public final CExpr bodyExpr;

    public CWhileExpr(CExpr cond, CExpr body) {
        this.condExpr = cond;
        this.bodyExpr = body;
    }

    @Override
    public <T> T accept(CExprVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
