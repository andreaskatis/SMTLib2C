package ast;

import visitors.CAstVisitor;

/**
 * Created by dr41k on 10/7/16.
 */
public class CClockFunction extends CFunction{
    public final String name;

    public CClockFunction() {
        this.name = "clock";
    }


    @Override
    public <T, S extends T> T accept(CAstVisitor<T, S> visitor) {
        return visitor.visit(this);
    }
}