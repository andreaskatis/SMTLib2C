package visitors;

import skolem.*;

public interface ExprVisitor<T> {
    T visit(AssignExpr e);
    T visit(BinaryExpr e);
    T visit(BoolExpr e);
    T visit(CastExpr e);
    T visit(IdExpr e);
    T visit(IfThenElseExpr e);
    T visit(IntExpr e);
    T visit(RealExpr e);
    T visit(TernaryExpr e);
    T visit(UnaryExpr e);
    T visit(ExitExpr e);
}
