package ast;

import visitors.CAstVisitor;

import java.util.List;


public class LustreCHarness extends CAst {
    public final List<CVarDecl> inputs;
    public final CFunction main;
    public final String filename;


    public LustreCHarness(List<CVarDecl> inputs, CFunction main, String filename) {
        this.inputs = inputs;
        this.main = main;
        this.filename = filename;
    }

    @Override
    public <T, S extends T> T accept(CAstVisitor<T, S> visitor) {
        return visitor.visit(this);
    }
}