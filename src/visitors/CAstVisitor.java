package visitors;

import ast.*;

public interface CAstVisitor<T, S extends T> extends CExprVisitor<S> {
	T visit(CProgram program);
	T visit(CVarDecl varDecl);
	T visit(CStructDecl structDecl);
	T visit(CHeader header);
	T visit(CHarness harnessC);
	T visit(LustreCHarness harnessLustreC);
}