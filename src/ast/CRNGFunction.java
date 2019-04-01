package ast;

import ast.types.CNamedType;
import visitors.CAstVisitor;

/**
 * Created by dr41k on 10/25/18.
 */
public class CRNGFunction extends CFunction {

    public final String name;
    public final CNamedType type;
    public final CExpr body;
    public final int numOfArgs;

    public CRNGFunction(String name, CNamedType type, CExpr body, int numOfArgs) {
        this.name = name;
        this.type = type;
        this.body = body;
        this.numOfArgs = numOfArgs;
    }

    public CRNGFunction(String name, CNamedType type, int numOfArgs) {
        this.name = name;
        this.type = type;
        this.body = null;
        this.numOfArgs = numOfArgs;
    }

    public CRNGFunction(String name, CNamedType type) {
        this.name = name;
        this.type = type;
        this.body = null;
        this.numOfArgs = 0;
    }



    @Override
    public <T, S extends T> T accept(CAstVisitor<T, S> visitor) {
        return visitor.visit(this);
    }
}
