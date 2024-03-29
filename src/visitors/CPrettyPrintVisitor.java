package visitors;


import java.util.Iterator;
import java.util.List;

import ast.*;
import ast.types.CNamedType;
import ast.types.CType;


public class CPrettyPrintVisitor implements CAstVisitor<Void, Void> {
	private StringBuilder sb = new StringBuilder();

	@Override
	public String toString() {
		return sb.toString();
	}

	protected void write(Object o) {
		sb.append(o);
	}

	private static final String seperator = System.getProperty("line.separator");

	private void newline() {
		write(seperator);
	}

	@Override
	public Void visit(CProgram program) {
		write("#include \""+program.filename+".h\"");
        newline();
        write("#include <assert.h>");
		newline();
		newline();
		if (program.init != null) {
			varDecl(program.init);
		}
		arrayDecls(program.vars);
		newline();
		funs(program.functions);
		return null;
	}

	@Override
	public Void visit(CHeader header) {
		write("#ifndef _"+header.filename.toUpperCase());
		newline();
		write("#define _"+header.filename.toUpperCase());
		newline();
		newline();
		write("#include <stdlib.h>");
		newline();
        newline();
		externDecls(header.ins);
		newline();
		externDecls(header.outs);
		newline();
		externfun(header.functions);
		write("#endif");
		newline();
		return null;
	}

	@Override
	public Void visit(CHarness harness) {
		write("#include \""+harness.filename+".h\"");
		newline();
		write("#include <stdio.h>");
		newline();
		write("#include <time.h>");
		newline();
		newline();
		fun(harness.main);
		return null;
	}

	@Override
	public Void visit(LustreCHarness harness) {
		write("#include \""+harness.filename+"_opt_top.h\"");
		newline();
		newline();
		write("#include <stdio.h>");
		newline();
		write("#include <stdlib.h>");
		newline();
		write("#include <unistd.h>");
		newline();
		write("#include <time.h>");
		newline();
		newline();
		newline();
		newline();
		fun(harness.main);
		return null;
	}

	private void varDecls(List<CVarDecl> varDecls) {
		for (CVarDecl v : varDecls) {
			varDecl(v);
		}
	}

	private void varDecl(CVarDecl varDecl) {
		varDecl.accept(this);
		write(";");
		newline();
	}

	private void structDecl(CStructDecl structDecl) {
		structDecl.accept(this);
		write(";");
		newline();
	}

	private void arrayDecls(List<CArrayDecl> decls) {
		Iterator<CArrayDecl> iterator = decls.iterator();
		while (iterator.hasNext()) {
			iterator.next().accept(this);
			write(";");
			newline();
		}
	}

	private void externDecls(List<CArrayDecl> decls) {
		Iterator<CArrayDecl> iterator = decls.iterator();
		while (iterator.hasNext()) {
			write("extern ");
			iterator.next().accept(this);
			write(";");
			newline();
		}
	}

	private void funs(List<CFunction> functions) {
		Iterator<CFunction> iterator = functions.iterator();
		while (iterator.hasNext()) {
			fun(iterator.next());
			newline();
		}
	}

	private void fun(CFunction function) {
		function.accept(this);
		newline();
	}

	private void externfun(List<CFunction> functions) {
		Iterator<CFunction> iterator = functions.iterator();
		while (iterator.hasNext()) {
			write("extern ");
			iterator.next().accept(this);
			newline();
		}
	}

	private void updates(CExpr loop) {
			loop.accept(this);
	}

	public void expr(CExpr e) {
		e.accept(this);
	}


	@Override
	public Void visit(CVarDecl varDecl) {
		write(varDecl.type);
		write(" ");
		write(varDecl.id);
		if (varDecl.init != null) {
			write(" = ");
			write(varDecl.init);
		}
		return null;
	}

	@Override
	public Void visit(CStructDecl structDecl) {
		write("struct ");
		write(structDecl.type);
		write(" ");
		write(structDecl.id);
		return null;
	}

	@Override
	public Void visit(CMoveHistory e) {
		write("void "+e.name+"()");
		if (e.loop !=null) {
			write(" {");
			newline();
			updates(e.loop);
			write("return;");
			newline();
			write("}");
		} else {
			write(";");
		}
		newline();
		return null;
	}

	@Override
	public Void visit(CUpdateFunction e) {
		write("void "+e.name+"()");
		if (e.body !=null) {
			write(" {");
			newline();
			e.body.accept(this);
			write("return;");
			newline();
			write("}");
		} else {
			write(";");
		}
		newline();
		return null;
	}

	@Override
	public Void visit(CHarnessMain e) {
		write("int "+e.main+"()");
		write(" {");
		newline();
		varDecls(e.vars);
		for (CExpr b : e.body) {
			b.accept(this);
			newline();
		}
		write("  return 0;");
		newline();
		write("}");
		return null;
	}

    @Override
    public Void visit(CRNGFunction e) {
        write(e.type + " " + e.name + "(");
        int numArgs = e.numOfArgs - 4;
        if (numArgs >= 0) {
            int i;
            for (i = 0; i < numArgs - 1; i++) {
                write(e.type + " " + "excl" + i + ", ");
            }
            write(e.type + " " + "excl" + i + ", ");
        }
        write(CNamedType.BOOL + " " + "lflag, ");
        write(CNamedType.BOOL + " " + "uflag, ");
        write(e.type + " " + "lbound, ");
        write(e.type + " " + "ubound");
        write(");");
        newline();

        return null;
    }

	@Override
	public Void visit(LustreCHarnessMain e) {
		write("int "+e.main+"()");
		write(" {");
		newline();
		varDecls(e.vars);
		for (CExpr b : e.body) {
			b.accept(this);
			newline();
		}
		write("  return 1;");
		newline();
		write("}");

		return null;
	}

	@Override
	public Void visit(CSkolemFunction e) {
		write("void "+e.name+"()");
		if(e.body!=null) {
			write(" {");
			newline();
			for (CExpr ln : e.body) {
				write("  ");
				expr(ln);
				newline();
			}
			write("  ");
			write("return;");
			newline();
			write("}");
		} else {
			write(";");
		}
		newline();
		return null;
	}

	@Override
	public Void visit(CRandFunction e) {
		//maybey change this to write(e.name?)
		e.accept(this);
		return null;
	}

	@Override
	public Void visit(CClockFunction e) {
		//maybey change this to write(e.name?)
		e.accept(this);
		return null;
	}

	@Override
	public Void visit(CPrintFunction e) {
		e.accept(this);
		return null;
	}

    //Currently assertions are being pushed at the outermost scope level.
    //This causes issues in C as it shouldn't always be the case that all
    //of the generated assertions hold.
    //The corresponding expressions are not being generated, but it might
    //prove useful to do so in the future.
    @Override
    public Void visit(CAssertExpr assertionExpr) {
//        write("assert(");
//        expr(assertionExpr.expr);
//        write(");");
//        newline();
        return null;
    }

	@Override
	public Void visit(CAssignment equation) {
		write(equation.varToAssign);
		write(" = ");
		expr(equation.expr);
		write(";");
		return null;
	}

	@Override
	public Void visit(CForExpr e) {
		varDecl(e.iter);
		write("for (");
		e.iterassign.accept(this);
		write(" ");
		e.cond.accept(this);
		write("; ");
		e.diff.accept(this);
		write(") {");
		newline();

		Iterator<CExpr> iterator = e.body.iterator();

		while(iterator.hasNext()) {
			write("  ");
			iterator.next().accept(this);
			newline();
		}
		write("}");
		newline();
		return null;
	}

	@Override
	public Void visit(CArrayAccessExpr e) {
		write(e.name);
		write("[");
		expr(e.index);
		write("]");
		return null;
	}

	@Override
	public Void visit(CArrayDecl e) {
		if (!e.id.equals("init")) {
			write(e.type);
			write(" ");
			write(e.id);
			write("[" + e.size.toString() + "]");
		}
		return null;
	}

	@Override
	public Void visit(CArrayUpdateExpr e) {
		write(e.id);
		write("[");
		write(e.index);
		write("]");
		write(" = ");
		expr(e.value);
		write(";");
		return null;
	}

	@Override
	public Void visit(CBinaryExpr e) {
		if (!(e.left instanceof CIdExpr) && !(e.left instanceof CIntExpr)
				&& !(e.left instanceof CBoolExpr) && !(e.left instanceof CDoubleExpr)
				&& !(e.left instanceof CFunctionCall)) {
			write("(");
		}
		expr(e.left);
		if (!(e.left instanceof CIdExpr) && !(e.left instanceof CIntExpr)
				&& !(e.left instanceof CBoolExpr) && !(e.left instanceof CDoubleExpr)
				&& !(e.left instanceof CFunctionCall)) {
			write(")");
		}
		write(" ");
		write(e.op);
		write(" ");
		if (!(e.right instanceof CIdExpr) && !(e.right instanceof CIntExpr)
				&& !(e.right instanceof CBoolExpr) && !(e.right instanceof CDoubleExpr)
				&& !(e.right instanceof CFunctionCall)) {
			write("(");
		}
		expr(e.right);
		if (!(e.right instanceof CIdExpr) && !(e.right instanceof CIntExpr)
				&& !(e.right instanceof CBoolExpr) && !(e.right instanceof CDoubleExpr)
				&& !(e.right instanceof CFunctionCall)) {
			write(")");
		}
		return null;
	}

	@Override
	public Void visit(CBoolExpr e) {
		if (Boolean.toString(e.value).equals("true")) {
			write("1");
		} else {
			write("0");
		}
		return null;
	}

	@Override
	public Void visit(CCastExpr e) {
		write("(");
		write(getCastFunction(e.type));
		write(") ");
		if (!(e.expr instanceof CIdExpr) && !(e.expr instanceof CIntExpr)
				&& !(e.expr instanceof CBoolExpr) && !(e.expr instanceof CDoubleExpr)
				&& !(e.expr instanceof CFunctionCall)) {
			write("(");
		}
		expr(e.expr);
		if (!(e.expr instanceof CIdExpr) && !(e.expr instanceof CIntExpr)
				&& !(e.expr instanceof CBoolExpr) && !(e.expr instanceof CDoubleExpr)
				&& !(e.expr instanceof CFunctionCall)) {
			write(")");
		}
		return null;
	}

	private String getCastFunction(CType type) {
		if (type.equals(CNamedType.DOUBLE)) {
			return "double";
		} else if (type.equals(CNamedType.INT)) {
			return "int";
		} else {
			return "_Bool";
		}
	}

	@Override
	public Void visit(CIdExpr e) {
		write(e.id);
		return null;
	}

	@Override
	public Void visit(CIfThenElseExpr e) {
		write("if ");
		write("(");
		expr(e.cond);
		write(")");
		write(" {");
		newline();
		for (CExpr thenln : e.thenExpr) {
			write("  ");
			expr(thenln);
			newline();
		}
		write("}");
		write(" else ");
		write("{");
		newline();

		for (CExpr elseln : e.elseExpr) {
			write("  ");
			expr(elseln);
			newline();
		}
		write("}");
		newline();
		return null;
	}

	@Override
	public Void visit(CTernaryExpr e) {
		write("(");
		expr(e.cond);
		write(")");
		write(" ? ");
		write("(");
		for (CExpr thenln : e.thenExpr) {
			expr(thenln);
		}
		write(")");
		write(" : ");
		write("(");
		for (CExpr elseln : e.elseExpr) {
			expr(elseln);
		}
		write(")");

		return null;
	}
	@Override
	public Void visit(CIntExpr e) {
		write(e.value);
		return null;
	}
	//change names to function.
	@Override
	public Void visit(CFunctionCallExpr e) {
		write(e.name+"(");
		if (e.args !=null) {
			for (int i = 0; i < e.args.size(); i++) {
				e.args.get(i).accept(this);
				if (i < e.args.size() - 1) {
					write(", ");
				}
			}

		}
		write(");");
		return null;
	}

	@Override
	public Void visit(CFunctionCall e) {
		write(e.name);
        write("(");
        if (e.funArgExprs != null) {
            for (int i = 0; i < e.funArgExprs.size(); i++) {
                expr(e.funArgExprs.get(i));
                if (i < e.funArgExprs.size() - 1) {
                    write(", ");
                }
            }
        }
        write(")");
		return null;
	}

	@Override
	public Void visit(CDoubleExpr e) {
		write(e.value);
//		if (!str.contains(".")) {
//			write(".0");
//		}
		return null;
	}

	@Override
	public Void visit(CUnaryExpr e) {
		if (e.op == CUnaryOp.NOT) {
			write(e.op);
			write("(");
			expr(e.expr);
			write(")");
		}
		else if (e.op == CUnaryOp.MINUSMINUS || e.op == CUnaryOp.PLUSPLUS) {
			expr(e.expr);
			write(e.op);
		}
		else {
			write("(");
			write(e.op);
            write("(");
			expr(e.expr);
			write(")");
            write(")");
		}
		return null;
	}

	@Override
	public Void visit(CExitExpr e) {
		write("return;");
		return null;
	}

    @Override
    public Void visit(CWhileExpr e) {
        write("while ");
        write("(");
        expr(e.condExpr);
        write(")");
        write(" {");
        newline();
        write("    ");
        expr(e.bodyExpr);
        newline();
        write("  }");
        newline();

        return null;
    }




}