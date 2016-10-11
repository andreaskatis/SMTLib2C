package visitors;

import ast.types.*;
import skolem.NamedType;

public class SMTLibToCTypeVisitor implements TypeVisitor<CType> {

    @Override
    public CType visit(NamedType e) {
        if (e.name.equals("Bool")) {
            return new CNamedType("_Bool");
        } else if (e.name.equals("Int")) {
            return new CNamedType("int");
        } else {
            return new CNamedType("double");
        }
    }
}
