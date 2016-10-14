package skolem;

import visitors.AstVisitor;
import java.util.List;

public class Scratch extends Ast {
    public final List<VarDecl> inputs;
    public final List<VarDecl> outputs;

    public final List<Skolem> skolems;

    public Scratch(Location location, List<VarDecl> inputs, List<VarDecl> outputs,
                   List<Skolem> skolems) {
        super(location);
        this.inputs = inputs;
        this.outputs = outputs;
        this.skolems = skolems;
    }

    public Scratch(List<VarDecl> inputs, List<VarDecl> outputs, List<Skolem> skolems) {
        this(Location.NULL, inputs, outputs, skolems);
    }

    @Override
    public <T, S extends T> T accept(AstVisitor<T, S> visitor) {
        return visitor.visit(this);
    }
}
