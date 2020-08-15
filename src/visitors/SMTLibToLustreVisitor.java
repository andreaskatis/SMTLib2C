package visitors;

import ast.*;
import jkind.lustre.*;
import jkind.lustre.Ast;
import skolem.*;
import skolem.BinaryExpr;
import skolem.BoolExpr;
import skolem.CastExpr;
import skolem.Equation;
import skolem.Expr;
import skolem.IdExpr;
import skolem.IfThenElseExpr;
import skolem.IntExpr;
import skolem.NamedType;
import skolem.RealExpr;
import skolem.UnaryExpr;
import skolem.VarDecl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SMTLibToLustreVisitor implements AstVisitor<jkind.lustre.Ast, jkind.lustre.Expr> {

        public SMTLibToLustreVisitor() {
        }

        @Override
        public jkind.lustre.Expr visit(BinaryExpr e){
            jkind.lustre.Expr leftExpr = e.left.accept(this);
            String opName = e.op.toString();
            jkind.lustre.BinaryOp op = jkind.lustre.BinaryOp.fromString(opName);
            jkind.lustre.Expr rightExpr = e.right.accept(this);
            return new jkind.lustre.BinaryExpr(leftExpr, op, rightExpr);
        }

        @Override
        public jkind.lustre.Expr visit(AssertExpr e) {
            return new jkind.lustre.BoolExpr(true);
        }

        @Override
        public jkind.lustre.Expr visit(AssignExpr e) {
        	throw new Error("Error: encountered AssignExpr [" + e + "] during translation to Lustre");
        }

        @Override
        public jkind.lustre.Expr visit(BoolExpr e) {
            return new jkind.lustre.BoolExpr(e.value);
        }

        @Override
        public jkind.lustre.Expr visit(CastExpr e) {
            SMTLibToLustreTypeVisitor typeVisitor = new SMTLibToLustreTypeVisitor();
            return new jkind.lustre.CastExpr(e.type.accept(typeVisitor), e.expr.accept(this));
        }

        @Override
        public jkind.lustre.Expr visit(FunAppExpr e) {
            List <jkind.lustre.Expr> funArgExprs = new ArrayList<>();
            for (Expr funArg : e.funArgExprs) {
                funArgExprs.add(funArg.accept(this));
            }
            return new jkind.lustre.FunctionCallExpr(e.funNameExpr.id, funArgExprs);
        }


        /* We need to assign init to zero initially and 1 thereafter; 
         * For now, this procedure only works for the fixpoint Skolem function */
        @Override
        public jkind.lustre.Expr visit(IdExpr e) {
            String id = e.id;
            if (id.contains("$")) {
                String[] trunc = id.split("[$]");
                String name = trunc[1].replaceAll("[~.]","_");
                String index = trunc[2].replaceAll("~1", "-1");
                Integer ind = Integer.valueOf(index);
                if (ind == 0 || ind == 2) {
                	return new jkind.lustre.IdExpr(name);
                } else if (ind == -1) {
                	return new jkind.lustre.UnaryExpr(
                		jkind.lustre.UnaryOp.PRE, new jkind.lustre.IdExpr(name));
                } else {
                	throw new Error("SMTLibToLustreExprVisitor: unexpected index when translating Id expression: " + e);
                }
            } else {
            	return new jkind.lustre.IdExpr(e.id);
            }
        }

        @Override
        public jkind.lustre.Expr visit(IfThenElseExpr e) {
            List<jkind.lustre.Expr> thenbd = new ArrayList<>();
            List<jkind.lustre.Expr> elsebd = new ArrayList<>();

            jkind.lustre.Expr cond = e.cond.accept(this);
            for (Expr tln : e.thenExpr) {
                thenbd.add(tln.accept(this));
            }

            for (Expr eln : e.elseExpr) {
                elsebd.add(eln.accept(this));
            }
            
            assert(thenbd.size() == 1);
            assert(elsebd.size() == 1);

            return new jkind.lustre.IfThenElseExpr(cond, thenbd.get(0), elsebd.get(0));
        }

        @Override
        public jkind.lustre.Expr visit(TernaryExpr e) {
            List<jkind.lustre.Expr> thenbd = new ArrayList<>();
            List<jkind.lustre.Expr> elsebd = new ArrayList<>();

            jkind.lustre.Expr cond = e.cond.accept(this);
            for (Expr tln : e.thenExpr) {
                thenbd.add(tln.accept(this));
            }

            for (Expr eln : e.elseExpr) {
                elsebd.add(eln.accept(this));
            }
            
            assert(thenbd.size() == 1);
            assert(elsebd.size() == 1); 
            return new jkind.lustre.IfThenElseExpr(cond, thenbd.get(0), elsebd.get(0));
        }

        @Override
        public jkind.lustre.Expr visit(IntExpr e) {
            return new jkind.lustre.IntExpr(e.value);
        }


        @Override
        public jkind.lustre.Expr visit(RealExpr e) {
        	return new jkind.lustre.RealExpr(e.value);
        }


        @Override
        public jkind.lustre.Expr visit(UnaryExpr e) {
        	jkind.lustre.Expr expr = e.expr.accept(this);
            String opName = e.op.toString();
            jkind.lustre.UnaryOp op = jkind.lustre.UnaryOp.fromString(opName);
            return new jkind.lustre.UnaryExpr(op, expr);
        }

        @Override
        public jkind.lustre.Expr visit(ExitExpr e) {
        	throw new Error("Error: encountered ExitExpr [" + e + "] during translation to Lustre");
        }

        @Override
        public jkind.lustre.Expr visit(WhileExpr e) {
            throw new Error("Error: encountered WhileExpr [" + e + "] during translation to Lustre");
        }

        public jkind.lustre.Expr visit(Expr expr) {
            return expr.accept(this);
        }

		@Override
		public Ast visit(Equation equation) {
        	throw new Error("Error: encountered Equation [" + equation + "] during translation to Lustre");
		}

		List<jkind.lustre.VarDecl> inputs; 
		List<jkind.lustre.VarDecl> outputs;

		@Override
		public Ast visit(VarDecl varDecl) {
            SMTLibToLustreTypeVisitor typeVisitor = new SMTLibToLustreTypeVisitor();
			return new jkind.lustre.VarDecl(varDecl.id, varDecl.type.accept(typeVisitor));
		}

//        public jkind.lustre.Expr assertExpr(Expr e) {
//            assert (e instanceof AssertExpr);
//            AssertExpr ae = (AssertExpr) e;
//            return ae.expr.accept(this);
//        }
		
		public jkind.lustre.Equation assignExpr(Expr e) {
            //Skolems may now contain assignments and assertions
			assert(e instanceof AssignExpr);
			AssignExpr ae = (AssignExpr)e;
			
			jkind.lustre.Expr lhs = ae.lhs.accept(this);
			jkind.lustre.Expr rhs = ae.expr.accept(this);
			
			assert(lhs instanceof jkind.lustre.IdExpr);
			jkind.lustre.IdExpr lhsId = (jkind.lustre.IdExpr)lhs;
			
			jkind.lustre.builders.EquationBuilder eb = new jkind.lustre.builders.EquationBuilder();
			eb.addLhs(lhsId);
			eb.setExpr(rhs);
			return eb.build();
		}
		
		public jkind.lustre.VarDecl buildInitVarDecl() {
			return new jkind.lustre.VarDecl("init", jkind.lustre.NamedType.INT);
		}
		
		public jkind.lustre.Equation buildInitEquation() {
			jkind.lustre.builders.EquationBuilder eb = new jkind.lustre.builders.EquationBuilder();
			eb.addLhs("init");
			jkind.lustre.Expr rhs = 
				new jkind.lustre.BinaryExpr(
					new jkind.lustre.IntExpr(0), 
					jkind.lustre.BinaryOp.ARROW, 
					new jkind.lustre.IntExpr(1));
			eb.setExpr(rhs);
			return eb.build();
		}

		public jkind.lustre.Node skolem(Skolem s, String id) {
			jkind.lustre.builders.NodeBuilder nb = new jkind.lustre.builders.NodeBuilder(id);
			nb.addInputs(inputs);
			nb.addOutputs(outputs);
			nb.addLocal(buildInitVarDecl());
			List<jkind.lustre.Equation> eqs = new ArrayList<>();
//					s.body.stream().map(e -> assignExpr(e)).collect(Collectors.toList());

//            List<jkind.lustre.Expr> assertionExprs =
//                    s.body.stream().map(e -> assertExpr(e)).collect(Collectors.toList());
            for (Expr bexpr : s.body) {
                if (bexpr instanceof AssertExpr) {
                    AssertExpr assertionExpr = (AssertExpr) bexpr;
                    nb.addAssertion(assertionExpr.expr.accept(this));
                } else if (bexpr instanceof AssignExpr) {
                    AssignExpr aexpr = (AssignExpr) bexpr;
                    eqs.add(assignExpr(aexpr));
                }
            }
            nb.addEquations(eqs);
            nb.addEquation(buildInitEquation());
//            nb.addAssertions(assertionExprs);
			return nb.build();
		}
				
		@Override
		public Ast visit(Skolem sk) {
			return skolem(sk, "Skolem_main");
		}

		@Override
		public Ast visit(Scratch scratch) {
			inputs = scratch.inputs.stream().map(
				s -> (jkind.lustre.VarDecl)s.accept(this)).collect(Collectors.toList());
			outputs = scratch.outputs.stream().map(
				s -> (jkind.lustre.VarDecl)s.accept(this)).collect(Collectors.toList());
			
			List<jkind.lustre.Node> nodes;
			nodes = scratch.skolems.stream().map(
				s -> (jkind.lustre.Node)s.accept(this)).collect(Collectors.toList());
			
			jkind.lustre.builders.ProgramBuilder builder = 
					new jkind.lustre.builders.ProgramBuilder();
			
			// for now, only compile single node programs.
			assert(nodes.size() == 1);
			builder.addNodes(nodes);
//            Node oldnode = nodes.get(0);
//            System.out.println(assertions);
//            builder.addNode(new Node(oldnode.id, oldnode.inputs, oldnode.outputs, oldnode.locals,
//                    oldnode.equations, oldnode.properties, assertions, oldnode.realizabilityInputs,
//                    oldnode.contract, oldnode.ivc));
			builder.setMain(nodes.get(0).id);

            List<jkind.lustre.VarDecl> rngArgs = new ArrayList<>();
            rngArgs.add(new jkind.lustre.VarDecl("lflag", jkind.lustre.NamedType.BOOL));
            rngArgs.add(new jkind.lustre.VarDecl("uflag", jkind.lustre.NamedType.BOOL));
            jkind.lustre.Type rngType;
            for (jkind.lustre.VarDecl out : outputs) {
                if (out.id.startsWith("_aeval_tmp_rand")) {
                    rngType = out.type;
                    rngArgs.add(new jkind.lustre.VarDecl("lbound", rngType));
                    rngArgs.add(new jkind.lustre.VarDecl("ubound", rngType));
                    builder.addFunction(new Function("generateRandomValue", rngArgs,
                            new jkind.lustre.VarDecl("randomValue", rngType)));
                    break;
                }
            }

			return builder.build();
		}

		public jkind.lustre.Program scratch(Scratch s) {
			return (jkind.lustre.Program)s.accept(this);
		}
		
    }

