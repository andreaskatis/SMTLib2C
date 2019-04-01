package skolem;

import java.util.List;
import visitors.ExprVisitor;

public class FunAppExpr extends  Expr {
    public final IdExpr funNameExpr;
    public final List<Expr> funArgExprs;

    public FunAppExpr(Location location, IdExpr funNameExpr, List<Expr> funArgExprs) {
        super(location);
        this.funNameExpr = funNameExpr;
        this.funArgExprs = funArgExprs;
    }

    public FunAppExpr(IdExpr funNameExpr, List<Expr> funArgExprs) {
        this(Location.NULL, funNameExpr, funArgExprs);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((funNameExpr == null) ? 0 : funNameExpr.hashCode());
        result = prime * result + ((funArgExprs == null) ? 0 : funArgExprs.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FunAppExpr other = (FunAppExpr) obj;
        if (funNameExpr == null) {
            if (other.funNameExpr != null)
                return false;
        } else if (!funNameExpr.equals(other.funNameExpr))
            return false;
        if (funArgExprs == null) {
            if (other.funArgExprs != null)
                return false;
        } else if (!funArgExprs.equals(other.funArgExprs))
            return false;
        return true;
    }

    @Override
    public <T> T accept(visitors.ExprVisitor<T> visitor) {
        return visitor.visit(this);
    }
}