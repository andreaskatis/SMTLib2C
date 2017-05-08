package visitors;

import skolem.NamedType;

public class SMTLibToLustreTypeVisitor implements TypeVisitor<jkind.lustre.NamedType> {

	
	
    @Override
    public jkind.lustre.NamedType visit(NamedType e) {
        if (e.name.equals("Bool")) {
            return jkind.lustre.NamedType.BOOL;
        } else if (e.name.equals("Int")) {
            return jkind.lustre.NamedType.INT;
        } else {
            return jkind.lustre.NamedType.REAL;
        }
    }
}
