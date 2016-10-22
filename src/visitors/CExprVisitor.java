package visitors;

import ast.*;

public interface CExprVisitor<T> {
	T visit(CAssignment e);
	T visit(CArrayAccessExpr e);
	T visit(CArrayDecl e);
	T visit(CArrayUpdateExpr e);
	T visit(CBinaryExpr e);
	T visit(CBoolExpr e);
	T visit(CCastExpr e);
	T visit(CIdExpr e);
	T visit(CIntExpr e);
	T visit(CDoubleExpr e);
	T visit(CUnaryExpr e);
	T visit(CIfThenElseExpr e);
	T visit(CForExpr e);
	T visit(CMoveHistory e);
	T visit(CUpdateFunction e);
	T visit(CSkolemFunction e);
	T visit(CRandFunction e);
	T visit(CClockFunction e);
	T visit(CPrintFunction e);
	T visit(CFunctionCall e);
	T visit(CFunctionCallExpr e);
	T visit(CExitExpr e);
	T visit(CHarnessMain e);
	T visit(LustreCHarnessMain e);
}
