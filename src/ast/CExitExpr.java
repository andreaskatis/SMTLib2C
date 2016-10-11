package ast;

import visitors.CExprVisitor;

public class CExitExpr extends CExpr {
    @Override
    public <T> T accept(CExprVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
