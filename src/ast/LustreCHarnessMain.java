package ast;

import visitors.CAstVisitor;

import java.util.List;

public class LustreCHarnessMain extends CFunction {
    public final String main;
    public final List<CVarDecl> vars;
    public final CStructDecl struct;
    public final List<CExpr> body;

    public LustreCHarnessMain(List<CVarDecl> vars, CStructDecl struct, List<CExpr> body) {
        this.main = "main";
        this.vars = vars;
        this.struct = struct;
        this.body = body;
    }

    @Override
    public <T, S extends T> T accept(CAstVisitor<T, S> visitor) {
        return visitor.visit(this);
    }

}
