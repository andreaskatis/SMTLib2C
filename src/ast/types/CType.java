package ast.types;
import ast.CLocation;
import visitors.*;

public abstract class CType {
	public final CLocation location;
	
	protected CType(CLocation location) {
		this.location = location;
	}

	public abstract <T> T accept(CTypeVisitor<T> visitor);
}
