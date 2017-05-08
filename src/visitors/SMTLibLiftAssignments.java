package visitors;

import java.util.List;
import java.util.stream.Collectors;
import skolem.*;

public class SMTLibLiftAssignments {

	public SMTLibLiftAssignments() {
		
	}
	
	public Skolem skolem(Skolem s) {
		SMTLibLiftAssignmentsExprVisitor visitor = new SMTLibLiftAssignmentsExprVisitor();
		List<Expr> liftedExprs = visitor.exprList(s.body);
		return new Skolem(s.location, s.equations, liftedExprs);
	}
	
	public Scratch scratch(Scratch s) {
		List<Skolem> skolems = s.skolems.stream().map(sk -> skolem(sk)).collect(Collectors.toList());
		return new Scratch(s.location, s.inputs, s.outputs, skolems);
	}
}
