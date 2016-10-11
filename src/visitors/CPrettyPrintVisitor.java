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
		newline();
		varDecl(program.init);
		arrayDecls(program.vars);
		newline();
		funs(program.functions);
		newline();
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
		write("#include \""+harness.filename+".h\"");
		newline();
		write("#include \""+harness.filename+"_alloc.h\"");
		newline();
		write("#include <stdio.h>");
		newline();
		write("#include <time.h>");
		newline();
		newline();
		varDecls(harness.inputs);
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
			write("  return;");
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
			e.body.accept(this);
			write("  return;");
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
	public Void visit(LustreCHarnessMain e) {
		write("int "+e.main+"()");
		write(" {");
		newline();
		varDecls(e.vars);
		structDecl(e.struct);
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
	public Void visit(CSkolemFunction e) {
		write("void "+e.name+"()");
		if(e.body!=null) {
			write(" {");
			newline();
			for (CExpr ln : e.body) {
				expr(ln);
			}
			newline();
			write("  return;");
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
		write("  for (");
		e.iterassign.accept(this);
		write(" ");
		e.cond.accept(this);
		write("; ");
		e.diff.accept(this);
		write(") {");
		newline();

		Iterator<CExpr> iterator = e.body.iterator();

		while(iterator.hasNext()) {
			write("    ");
			iterator.next().accept(this);
			newline();
		}
		write("  }");
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
		expr(e.left);
		write(" ");
		write(e.op);
		write(" ");
		expr(e.right);
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
		expr(e.expr);
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
		write("  if ");
		write("(");
		expr(e.cond);
		write(")");
		write(" {");
		newline();
		for (CExpr thenln : e.thenExpr) {
			write("    ");
			expr(thenln);
			newline();
		}
		write("  }");
		write(" else ");
		write("{");
		newline();

		for (CExpr elseln : e.elseExpr) {
			write("    ");
			expr(elseln);
			newline();
		}
		write("}");
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
		write(e.name+"()");
		return null;
	}

	@Override
	public Void visit(CRealExpr e) {
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
			write(e.op);
			expr(e.expr);
		}
		return null;
	}

	@Override
	public Void visit(CExitExpr e) {
		write("exit(0);");
		return null;
	}




}