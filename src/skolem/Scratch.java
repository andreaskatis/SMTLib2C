package skolem;

import visitors.AstVisitor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scratch extends Ast {
    public final List<VarDecl> inputs;
    public final List<VarDecl> outputs;
    public final List<Skolem> skolems;
    public final Map<String, List<Expr>> rngNames;

    public Scratch(Location location, List<VarDecl> inputs, List<VarDecl> outputs,
                   List<Skolem> skolems, Map<String, List<Expr>> rngNames) {
        super(location);
        this.inputs = inputs;
        this.outputs = outputs;
        this.skolems = skolems;
        this.rngNames = rngNames;
    }

    public Scratch(List<VarDecl> inputs, List<VarDecl> outputs, List<Skolem> skolems, Map<String, List<Expr>> rngNames) {
        this(Location.NULL, inputs, outputs, skolems, rngNames);
    }

    @Override
    public <T, S extends T> T accept(AstVisitor<T, S> visitor) {
        return visitor.visit(this);
    }
}
