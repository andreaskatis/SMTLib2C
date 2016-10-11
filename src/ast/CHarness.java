package ast;

import visitors.CAstVisitor;


public class CHarness extends CAst {
    public final CFunction main;
    public final String filename;


    public CHarness(CFunction main, String filename) {
        this.main = main;
        this.filename = filename;
    }

    @Override
    public <T, S extends T> T accept(CAstVisitor<T, S> visitor) {
        return visitor.visit(this);
    }
}