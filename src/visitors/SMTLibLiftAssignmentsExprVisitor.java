package visitors;

import ast.*;
import skolem.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SMTLibLiftAssignmentsExprVisitor implements ExprVisitor<List<Expr>> {
		
        public SMTLibLiftAssignmentsExprVisitor() {
        }

        public List<Expr> exprList(List<Expr> original) {
        	Map<Boolean, List<Expr>> partition = partitionThenElseExprLists(original);
        	
        	// MWW: temporary
/*        	List<Expr> el = partition.get(Boolean.FALSE); 
        	if (!el.isEmpty()) {
        		System.out.println("Non-empty non-assignment partition for SMTLibLiftAssignmentsExprVisitor: ");
        		SMTLibPrettyPrintVisitor ppv = new SMTLibPrettyPrintVisitor(); 
        		ppv.exprList(el); 
        		System.out.println(ppv.toString());
        	}
        	*/
        	// MWW: end temporary
//        	Andreas: the following is not always true (assertions might exist for rand values for fuzzer synthesis)
//        	assert(partition.get(Boolean.FALSE).isEmpty());
        	
        	return partition.get(Boolean.TRUE);
        }

        public List<Expr> AssertExprList(List<Expr> original) {
            Map<Boolean, List<Expr>> partition = partitionThenElseExprLists(original);
            return partition.get(Boolean.FALSE);
        }
        
        // MWW: How do I do a zip operation in Java?
        @Override
        public List<Expr> visit(BinaryExpr e){
            List<Expr> zipList = new ArrayList<Expr>();
            List<Expr> leftExprs = e.left.accept(this);
            List<Expr> rightExprs = e.right.accept(this);
            assert (leftExprs.size() == rightExprs.size());
            
            for (int i = 0; i < leftExprs.size(); i++) {
            	zipList.add(new BinaryExpr(e.location, leftExprs.get(i), e.op, rightExprs.get(i)));
            }
            return zipList;
        }

        List<Expr> mkList(Expr e) {
        	List<Expr> l = new ArrayList<>();
        	l.add(e);
        	return l;
        }

        @Override
        public List<Expr> visit(AssertExpr e) {
//            List<Expr> assertlist = new ArrayList<>();
//            assertlist.add(new BoolExpr(true));
//            return assertlist;
            return mkList(e);
        }

        @Override
        public List<Expr> visit(AssignExpr e) {
        	return mkList(e);
        }

        @Override
        public List<Expr> visit(BoolExpr e) {
            return mkList(e);
        }

        @Override
        public List<Expr> visit(CastExpr e) {
        	List<Expr> subs = e.expr.accept(this); 
        	return subs.stream().map(
        		s -> new CastExpr(e.location, e.type, s)).collect(Collectors.toList());
        }

        @Override
        public List<Expr> visit(FunAppExpr e) { return mkList(e); }

        @Override
        public List<Expr> visit(IdExpr e) {
        	return mkList(e);
        }

        // Apply transform recursively, then partition into ASSIGN exprs and non-ASSIGN exprs
        protected Map<Boolean, List<Expr>> partitionThenElseExprLists(List<Expr> e) {
        	Map<Boolean, List<Expr>> result = e.stream().map(
                	s -> s.accept(this)).flatMap(s -> s.stream()).
        			collect(Collectors.partitioningBy(s -> s instanceof AssignExpr));
        	return result;
        }

        public Expr mkConditional(Boolean ternary, Location l1, Expr cond, List<Expr> thenList, List<Expr> elseList) {
        	if (ternary) {
        		return new TernaryExpr(l1, cond, thenList, elseList);
        	} else {
        		return new IfThenElseExpr(l1, cond, thenList, elseList);
        	}
        }
        
        boolean isExitCase(List<Expr> elseAssigns) {
            return (elseAssigns.size() == 1 && (elseAssigns.get(0) instanceof ExitExpr));  
        	
        }
        
        public List<Expr> liftAssignmentsStdCase(Boolean ternary, Location l1, Expr cond, List<Expr> thenList, List<Expr> elseList) {
        	Map<Boolean, List<Expr>> thenExprs = partitionThenElseExprLists(thenList);
        	Map<Boolean, List<Expr>> elseExprs = partitionThenElseExprLists(elseList);
            List<Expr> result = new ArrayList<>();
            
        	// lists should be the same size
        	assert(thenExprs.get(Boolean.TRUE).size() == elseExprs.get(Boolean.TRUE).size());
        	assert(thenExprs.get(Boolean.FALSE).size() == elseExprs.get(Boolean.FALSE).size());
            
        	// knit together assignments with special case for EXIT
            for (Expr th: thenExprs.get(Boolean.TRUE)) {
            	AssignExpr thenAssign = (AssignExpr)th;
            	AssignExpr elseAssign = (AssignExpr)elseExprs.get(Boolean.TRUE).stream().
            			filter(sub -> thenAssign.lhs.equals(((AssignExpr)sub).lhs)).findFirst().get();
            	
        		assert(elseAssign != null);
            	
            	result.add(new AssignExpr(l1, thenAssign.lhs, 
            			mkConditional(ternary, l1, cond, mkList(thenAssign.expr),
            				mkList(elseAssign.expr))));
            }
            
            // Add other expressions
            result.add(mkConditional(ternary, l1, cond, 
            		thenExprs.get(Boolean.FALSE),
            		elseExprs.get(Boolean.FALSE)));
            
            return result;
        }

        public List<Expr> liftAssignmentsExitCase(List<Expr> thenList) {
        	Map<Boolean, List<Expr>> thenExprs = partitionThenElseExprLists(thenList);
        	assert (thenExprs.get(Boolean.FALSE).isEmpty());
        	return thenExprs.get(Boolean.TRUE);
        }
        
        public List<Expr> liftAssignmentFromConditional(Boolean ternary, Location l1, Expr cond, List<Expr> thenList, List<Expr> elseList) {
        	if (isExitCase(elseList)) {
        		return liftAssignmentsExitCase(thenList);
        	} else {
        		return liftAssignmentsStdCase(ternary, l1, cond, thenList, elseList); 
        	}
        }
        
        @Override
        public List<Expr> visit(IfThenElseExpr e) {
        	return liftAssignmentFromConditional(false, e.location, e.cond, e.thenExpr, e.elseExpr);
        }

        @Override
        public List<Expr> visit(TernaryExpr e) {
        	return liftAssignmentFromConditional(true, e.location, e.cond, e.thenExpr, e.elseExpr);
        }

        @Override
        public List<Expr> visit(IntExpr e) {
            return mkList(e);
        }


        @Override
        public List<Expr> visit(RealExpr e) {
        	return mkList(e);
        }


        @Override
        public List<Expr> visit(UnaryExpr e) {
        	List<Expr> subs = e.expr.accept(this); 
        	return subs.stream().map(
        		s -> new UnaryExpr(e.location, e.op, s)).collect(Collectors.toList());
        }

        @Override
        public List<Expr> visit(ExitExpr e) {
        	return mkList(e); 
        }

        public List<Expr> visit(Expr expr) {
            return expr.accept(this);
        }

    }

