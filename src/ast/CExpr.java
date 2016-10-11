package ast;

import visitors.*;


public abstract class CExpr extends CAst {
	@SuppressWarnings("unchecked")
	@Override
	public <T, S extends T> S accept(CAstVisitor<T, S> visitor) {
		return accept((CExprVisitor<S>) visitor);
	}

	public abstract <T> T accept(CExprVisitor<T> visitor);

}