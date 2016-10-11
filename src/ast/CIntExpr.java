package ast;

import java.math.BigInteger;

import visitors.*;

public class CIntExpr extends CExpr {
	public final BigInteger value;

	public CIntExpr(BigInteger value) {
		this.value = value;
	}

	@Override
	public <T> T accept(CExprVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
