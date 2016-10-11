package ast;

import visitors.CAstVisitor;

import java.util.List;

public class CHeader  extends CAst {
    public final String filename;
    public final List<CArrayDecl> ins;
    public final List<CArrayDecl> outs;
    public final List<CFunction> functions;

    public CHeader(String filename, List<CArrayDecl> ins, List<CArrayDecl> outs,
                    List<CFunction> functions) {
        this.filename = filename;
        this.ins = ins;
        this.outs = outs;
        this.functions = functions;
    }

    @Override
    public <T, S extends T> T accept(CAstVisitor<T, S> visitor) {
        return visitor.visit(this);
    }
}