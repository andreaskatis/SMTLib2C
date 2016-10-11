package ast.types;

import ast.CLocation;
import visitors.*;

public class CNamedType extends CType {
	public final String name;

	public CNamedType(CLocation location, String name) {
		super(location);
		this.name = name;
	}

	public CNamedType(String name) {
		this(CLocation.NULL, name);
	}
	
	/*
	 * Private constructor for built-in types
	 */
	private CNamedType(String name, @SuppressWarnings("unused") Object unused) {
		super(CLocation.NULL);
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}

	public static final CNamedType BOOL = new CNamedType("_Bool", null);
	public static final CNamedType INT = new CNamedType("int", null);
	public static final CNamedType DOUBLE = new CNamedType("double", null);

	public boolean isBuiltin() {
		return this == DOUBLE || this == BOOL || this == INT;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof CNamedType)) {
			return false;
		}
		CNamedType other = (CNamedType) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

	@Override
	public <T> T accept(CTypeVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
