package ast.types;

import ast.CLocation;
import visitors.*;

public class CArrayType extends CType {
	public final CType base;
	public final int size;

	public CArrayType(CLocation location, CType base, int size) {
		super(location);
		this.base = base;
		this.size = size;
	}

	public CArrayType(CType base, int size) {
		this(CLocation.NULL, base, size);
	}

	@Override
	public String toString() {
		return base + "[" + size + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((base == null) ? 0 : base.hashCode());
		result = prime * result + size;
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
		if (!(obj instanceof CArrayType)) {
			return false;
		}
		CArrayType other = (CArrayType) obj;
		if (base == null) {
			if (other.base != null) {
				return false;
			}
		} else if (!base.equals(other.base)) {
			return false;
		}
		if (size != other.size) {
			return false;
		}
		return true;
	}

	@Override
	public <T> T accept(CTypeVisitor<T> visitor) {
		return visitor.visit(this);
	}
}