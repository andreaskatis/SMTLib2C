package ast;

import visitors.CExprVisitor;

import java.util.List;

public class CForExpr extends CExpr{
    public final CVarDecl iter;
    public final CAssignment iterassign;
    public final CExpr cond;
    public final CExpr diff;
    public final List<CExpr> body;

    public CForExpr(CVarDecl iter, CAssignment iterassign, CExpr cond, CExpr diff, List<CExpr> body) {
        this.iter = iter;
        this.iterassign = iterassign;
        this.cond = cond;
        this.diff = diff;
        this.body = body;
    }

    @Override
    public <T> T accept(CExprVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
