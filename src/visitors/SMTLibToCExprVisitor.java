package visitors;

import ast.*;
import skolem.*;

import java.util.ArrayList;
import java.util.List;

public class SMTLibToCExprVisitor implements ExprVisitor<CExpr> {

        public SMTLibToCExprVisitor() {
        }

        @Override
        public CExpr visit(BinaryExpr e){
            CExpr leftExpr = e.left.accept(this);
            String opName = e.op.name();
            CBinaryOp op = CBinaryOp.fromString(opName);
            CExpr rightExpr = e.right.accept(this);
                return new CBinaryExpr(leftExpr, op, rightExpr);
        }

        @Override
        public CExpr visit(AssignExpr e) {
            CExpr leftExpr = e.lhs.accept(this);
            CExpr rightExpr = e.expr.accept(this);
            return new CAssignment(leftExpr, rightExpr);
        }

        @Override
        public CExpr visit(BoolExpr e) {
            return new CBoolExpr(e.value);
        }

        @Override
        public CExpr visit(CastExpr e) {
            SMTLibToCTypeVisitor typeVisitor = new SMTLibToCTypeVisitor();
            return new CCastExpr(e.type.accept(typeVisitor), e.expr.accept(this));
        }

        @Override
        public CExpr visit(IdExpr e) {
            return new CIdExpr(e.id);
        }

        @Override
        public CExpr visit(IfThenElseExpr e) {
            List<CExpr> thenbd = new ArrayList<>();
            List<CExpr> elsebd = new ArrayList<>();

            CExpr cond = e.cond.accept(this);
            for (Expr tln : e.thenExpr) {
                thenbd.add(tln.accept(this));
            }

            for (Expr eln : e.elseExpr) {
                elsebd.add(eln.accept(this));
            }
            return new CIfThenElseExpr(cond, thenbd, elsebd);
        }

        @Override
        public CExpr visit(TernaryExpr e) {
            List<CExpr> thenbd = new ArrayList<>();
            List<CExpr> elsebd = new ArrayList<>();

            CExpr cond = e.cond.accept(this);
            for (Expr tln : e.thenExpr) {
                thenbd.add(tln.accept(this));
            }

            for (Expr eln : e.elseExpr) {
                elsebd.add(eln.accept(this));
            }
            return new CTernaryExpr(cond, thenbd, elsebd);
        }

        @Override
        public CExpr visit(IntExpr e) {
            return new CIntExpr(e.value);
        }


        @Override
        public CExpr visit(RealExpr e) {
            return new CDoubleExpr(e.value.doubleValue());
        }


        @Override
        public CExpr visit(UnaryExpr e) {
            CExpr expr = e.expr.accept(this);
            String opName = e.op.name();
            CUnaryOp op = CUnaryOp.fromString(opName);
            return new CUnaryExpr(op, expr);
        }

        @Override
        public CExpr visit(ExitExpr e) {
            return new CExitExpr();
        }

        public CExpr visit(Expr expr) {
            return expr.accept(this);
        }

    }

