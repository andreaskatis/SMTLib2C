package ast;

import visitors.CAstVisitor;

import java.util.List;

public class CHarnessMain extends CFunction {
    public final String main;
    public final List<CVarDecl> vars;
    public final List<CExpr> body;

    public CHarnessMain(List<CVarDecl> vars, List<CExpr> body) {
        this.main = "main";
        this.vars = vars;
        this.body = body;
    }

    @Override
    public <T, S extends T> T accept(CAstVisitor<T, S> visitor) {
        return visitor.visit(this);
    }

}
