package ast;

import visitors.*;

public abstract class CAst {
	@Override
	public String toString() {
		CPrettyPrintVisitor visitor = new CPrettyPrintVisitor();
		accept(visitor);
		return visitor.toString();
	}

	/**
	 * Accept.
	 *
	 * @param <T> the generic type
	 * @param <S> the generic type
	 * @param visitor the visitor
	 * @return the t
	 */
	public abstract <T, S extends T> T accept(CAstVisitor<T, S> visitor);
}
