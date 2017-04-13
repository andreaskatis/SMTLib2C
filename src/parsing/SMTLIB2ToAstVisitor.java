package parsing;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.TerminalNode;
import parsing.SMTLIB2Parser.*;




import skolem.*;

public class SMTLIB2ToAstVisitor extends SMTLIB2BaseVisitor<Object> {

    public Scratch scratch(ScratchContext ctx) {
        List<String> insprops = realizabilityInputs(ctx.inputs());
        List<SkolemContext> skolemctx = ctx.skolem();
        List<VarDecl> inputs = inputvars(skolemctx, insprops);
        insprops.addAll(properties(ctx.properties()));
        List<VarDecl> outputs = outputvars(skolemctx, insprops);
        List<Skolem> skolems = skolems(skolemctx, insprops);
        return new Scratch(loc(ctx), inputs, outputs, skolems);
    }

    private List<String> realizabilityInputs(List<InputsContext> inputsctx) {
        List<String> ids = new ArrayList<>();
        for (InputsContext ictx : inputsctx) {
            for (TerminalNode idctx : ictx.ID()) {
                ids.add(idctx.getText());
            }
        }
        return ids;
    }

    private List<String> properties(List<PropertiesContext> propertiesctx) {
        List<String> ids = new ArrayList<>();
        for (PropertiesContext pctx : propertiesctx) {
            for (TerminalNode idctx : pctx.ID()) {
                ids.add(idctx.getText());
            }
        }
        return ids;
    }

    //it may be enough to use only the 0-th skolem
    private List<VarDecl> inputvars(List<SkolemContext> skolems, List<String> inputs) {

        List<VarDecl> decls = new ArrayList<>();
        List<String> names = new ArrayList<>();

        for (SkolemContext skolem : skolems) {
            List<DeclareContext> declares = skolem.declare();
            for (DeclareContext declare : declares) {
                String id = removeDelimiters(declare.ID().getText());
//                String prefix = id;
//                if (id.contains(".")) {
//                    prefix = id.substring(0, id.indexOf("."));
//                }
//                if (ids.contains(prefix) && !(names.contains(id))) {
//                    Type type = type(declare.type());
//                    //replacingSymbols should happen after receing the IR, to support multiple outputs
//                    decls.add(new VarDecl(loc(declare), replaceSymbols(id), type));
//                    names.add(id);
//                }
                if (inputs.contains(id) && !(names.contains(id))) {
                    Type type = type(declare.type());
                    //replacingSymbols should happen after receing the IR, to support multiple outputs
                    decls.add(new VarDecl(loc(declare), replaceSymbols(id), type));
                    names.add(id);
                }
            }
        }

        return decls;
    }



    private String replaceSymbols(String str) {
        return str.replaceAll("[~.]","_");
    }

    private String removeDelimiters(String str) {
        if (str.startsWith("$")) {
            str = str.substring(str.indexOf("$")+1, str.lastIndexOf("$"));
        }
        return str;
    }

//    private List<VarDecl> inputvars(List<SkolemContext> ctxs) {
//        List<VarDecl> decls = new ArrayList<>();
//        List<String> names = new ArrayList<>();
//        int skolem_index = 0;
//        if (ctxs == null) {
//            return decls;
//        }
//        for (SkolemContext ctx : ctxs) {
//            List<DeclareContext> dctxs = ctx.declare();
//            for (DeclareContext dctx : dctxs) {
//                String id = dctx.ID().getText();
//                if (id.endsWith("$"+Integer.toString(skolem_index))) {
//                    Type type = type(dctx.type());
//                    boolean contains = false;
//                    for (String name : names) {
//                        if (id.substring(0,id.length()-2).equals(name.substring(0,name.length()-2))) {
//                            contains = true;
//                            break;
//                        }
//                    }
//                    if (contains) {
//                        continue;
//                    } else {
//                        names.add(id);
//                        decls.add(new VarDecl(loc(dctx), rename(id), type));
//                    }
//
//                }
//            }
//            skolem_index++;
//        }
//        return decls;
//    }

    private List<VarDecl> outputvars(List<SkolemContext> skolems, List<String> insprops) {

        List<VarDecl> decls = new ArrayList<>();
        List<String> names = new ArrayList<>();

        for (SkolemContext skolem : skolems) {
            List<DeclareContext> declares = skolem.declare();
            for (DeclareContext declare : declares) {
                String id = removeDelimiters(declare.ID().getText());
//                String prefix = id;
//                if (id.contains(".")) {
//                    prefix = id.substring(0, id.indexOf("."));
//                }
//                if (ids.contains(prefix) && !(names.contains(id))) {
//                    Type type = type(declare.type());
//                    //replacingSymbols should happen after receing the IR, to support multiple outputs
//                    decls.add(new VarDecl(loc(declare), replaceSymbols(id), type));
//                    names.add(id);
//                }
                if (!insprops.contains(id) && !(names.contains(id)) && !id.equals("%init")) {
                    Type type = type(declare.type());
                    //replacingSymbols should happen after receing the IR, to support multiple outputs
                    decls.add(new VarDecl(loc(declare), replaceSymbols(id), type));
                    names.add(id);
                }
            }
        }

        return decls;
    }

//    private List<VarDecl> outputvars(List<SkolemContext> ctxs) {
//        List<VarDecl> decls = new ArrayList<>();
//        List<String> names = new ArrayList<>();
//        int skolem_index = 0;
//        if (ctxs == null) {
//            return decls;
//        }
//        for (SkolemContext ctx : ctxs) {
//            List<DeclareContext> dctxs = ctx.declare();
//            for (DeclareContext dctx : dctxs) {
//                String id = dctx.ID().getText();
//                if((id.endsWith("$"+Integer.toString(skolem_index+2)) ||
//                        id.endsWith("$~1"))) {
//                    Type type = type(dctx.type());
//                    String[] trunc = id.split("[$]");
//                    boolean contains = false;
//                    for (String name : names) {
//                        String[] truncname = name.split("[$]");
//                        if (trunc[1].equals(truncname[1])) {
//                            contains = true;
//                            break;
//                        }
//                    }
//                    if (contains) {
//                        continue;
//                    } else {
//                        names.add(id);
//                        decls.add(new VarDecl(loc(dctx), rename(id), type));
//                    }
//
//                }
//            }
//        }
//        return decls;
//    }


        private List<Skolem> skolems(List<SkolemContext> ctxs, List<String> insprops) {
        List<Skolem> skolems = new ArrayList<>();
        for (SkolemContext ctx : ctxs) {
            skolems.add(skolem(ctx, insprops));
        }
        return skolems;
    }

    public Skolem skolem(SkolemContext ctx, List<String> insprops) {
        List<Equation> locals = new ArrayList<>();
        if (ctx.letexp() !=null) {
            locals.addAll(locals(ctx.letexp()));
            List<Equation> inlinedlocals = inlinelocals(locals, locals);
            List<Expr> body = body(ctx.letexp().body());
            body = inlinelocalstoexprs(body, inlinedlocals);
            body = convertEqualitiesToAssignments(body, insprops);
            body = convertIfThenElsesToTernary(body);
            body = convertBooleanValuesToExitExprs(body);
            return new Skolem(loc(ctx), locals, body);
        } else {
            List<Expr> body = new ArrayList<>();
            body.add(expr(ctx.expr()));
            body = convertEqualitiesToAssignments(body, insprops);
            body = convertIfThenElsesToTernary(body);
            body = convertBooleanValuesToExitExprs(body);
            return new Skolem(loc(ctx), locals, body);
        }
    }

    private List<Expr> convertBooleanValuesToExitExprs(List<Expr> tempbody) {
        List<Expr> converted = new ArrayList<>();
        for (Expr expr : tempbody) {
            if (expr instanceof IfThenElseExpr) {
                IfThenElseExpr iteexpr = (IfThenElseExpr) expr;
                IfThenElseExpr iteconv = new IfThenElseExpr(iteexpr.cond,
                        iteexpr.thenExpr, convertBooleanValuesToExitExprs(iteexpr.elseExpr));
                converted.add(iteconv);
            } else {
                converted.add(convertBooleanValueToExitExpr(expr));
            }
        }
        return converted;
    }

    private Expr convertBooleanValueToExitExpr(Expr expr) {
        if (expr instanceof BoolExpr) {
            return new ExitExpr();
        } else {
            return expr;
        }
    }

    private List<Expr> convertIfThenElsesToTernary(List<Expr> tempbody) {
        List<Expr> converted = new ArrayList<>();
        for (Expr expr : tempbody) {
            if (expr instanceof IfThenElseExpr) {
                IfThenElseExpr itebody = (IfThenElseExpr) expr;
                Expr condexp = itebody.cond;
                List<Expr> thenexp = itebody.thenExpr;
                List<Expr> elsexp = itebody.elseExpr;
                IfThenElseExpr iteconv = new IfThenElseExpr(convertIfThenElseToTernaryExpr(condexp),
                        convertIfThenElsesToTernaryExprs(thenexp), convertIfThenElsesToTernaryExprs(elsexp));
                converted.add(iteconv);
            } else {
                converted.add(convertIfThenElseToTernaryExpr(expr));
            }
        }
        return converted;
    }

    private List<Expr> convertIfThenElsesToTernaryExprs(List<Expr> exprs) {
        List<Expr> converted = new ArrayList<>();
        for (Expr expr : exprs) {
            if (expr instanceof AssignExpr) {
                AssignExpr aexpr = (AssignExpr) expr;
                AssignExpr aconv = new AssignExpr(aexpr.lhs, convertIfThenElseToTernaryExpr(aexpr.expr));
                converted.add(aconv);
            }  else if (expr instanceof IfThenElseExpr) {
                IfThenElseExpr itexp = (IfThenElseExpr) expr;
                IfThenElseExpr iteconv = new IfThenElseExpr(convertIfThenElseToTernaryExpr(itexp.cond),
                        convertIfThenElsesToTernaryExprs(itexp.thenExpr), convertIfThenElsesToTernaryExprs(itexp.elseExpr));
                converted.add(iteconv);
            } else {
                converted.add(convertIfThenElseToTernaryExpr(expr));
            }
        }
        return converted;
    }

    private Expr convertIfThenElseToTernaryExpr(Expr expr) {
        if (expr instanceof IfThenElseExpr) {
            IfThenElseExpr iteexpr = (IfThenElseExpr) expr;
            return new TernaryExpr(convertIfThenElseToTernaryExpr(iteexpr.cond),convertNestedIfThenElsesToTernaryExprs(iteexpr.thenExpr),convertNestedIfThenElsesToTernaryExprs(iteexpr.elseExpr));
        } else if (expr instanceof BinaryExpr) {
            BinaryExpr binexp = (BinaryExpr) expr;
            return new BinaryExpr(convertIfThenElseToTernaryExpr(binexp.left),
                binexp.op, convertIfThenElseToTernaryExpr(binexp.right));
        } else if (expr instanceof UnaryExpr) {
            UnaryExpr unexp = (UnaryExpr) expr;
            return new UnaryExpr(unexp.op, convertIfThenElseToTernaryExpr(unexp.expr));
        } else if (expr instanceof CastExpr) {
            CastExpr castexp = (CastExpr) expr;
            return new CastExpr(castexp.type, convertIfThenElseToTernaryExpr(castexp.expr));
        } else if (expr instanceof AssignExpr) {
            AssignExpr assignexp = (AssignExpr) expr;
            return new AssignExpr(assignexp.lhs, convertIfThenElseToTernaryExpr(assignexp.expr));
        } else {
            return expr;
        }
    }

    private List<Expr> convertNestedIfThenElsesToTernaryExprs(List<Expr> exprs) {
        List<Expr> converted = new ArrayList<>();
        for (Expr expr : exprs) {
            if (expr instanceof IfThenElseExpr) {
                IfThenElseExpr itexp = (IfThenElseExpr) expr;
                TernaryExpr iteconv = new TernaryExpr(convertIfThenElseToTernaryExpr(itexp.cond),
                        convertNestedIfThenElsesToTernaryExprs(itexp.thenExpr), convertNestedIfThenElsesToTernaryExprs(itexp.elseExpr));
                converted.add(iteconv);
            } else {
                converted.add(convertIfThenElseToTernaryExpr(expr));
            }
        }
        return converted;
    }

    private List<Expr> convertEqualitiesToAssignments(List<Expr> tempbody, List<String> insprops) {
        List<Expr> converted = new ArrayList<>();
        for (Expr expr : tempbody) {
            if (expr instanceof IfThenElseExpr) {
                IfThenElseExpr itebody = (IfThenElseExpr) expr;
                List<Expr> thenexp = itebody.thenExpr;
                List<Expr> elsexp = itebody.elseExpr;
                IfThenElseExpr iteconv = new IfThenElseExpr(itebody.cond,
                        convertAssignmentsinExprs(thenexp, insprops), convertAssignmentsinExprs(elsexp, insprops));
                converted.add(iteconv);
            } else {
                converted.addAll(convertAssignmentinExpr(expr, insprops));
            }
        }
        return converted;
    }

    private List<Expr> convertAssignmentsinExprs(List<Expr> exprs, List<String> insprops) {
        List<Expr> converted = new ArrayList<>();
        for (Expr expr : exprs) {
            if (expr instanceof BinaryExpr) {
                BinaryExpr binexp = (BinaryExpr) expr;
                if (binexp.op.name().equals(BinaryOp.EQUAL.name())) {
                    if (binexp.left instanceof IdExpr) {
                        IdExpr leftexp = (IdExpr) binexp.left;
                        String id = removeDelimiters(leftexp.id);
                        if (!insprops.contains(id)) {
                            converted.add(new AssignExpr(binexp.left, binexp.right));
                        }
                    }
                } else {
                    converted.addAll(convertAssignmentinExpr(binexp.left, insprops));
                    converted.addAll(convertAssignmentinExpr(binexp.right, insprops));
                }
            } else if (expr instanceof IfThenElseExpr) {
                IfThenElseExpr itexp = (IfThenElseExpr) expr;
                IfThenElseExpr iteconv = new IfThenElseExpr(itexp.cond,
                        convertAssignmentsinExprs(itexp.thenExpr, insprops), convertAssignmentsinExprs(itexp.elseExpr, insprops));
                converted.add(iteconv);
            } else {
                converted.add(expr);
            }
        }
        return converted;
    }

    private List<Expr> convertAssignmentinExpr(Expr expr, List<String> insprops) {
        List<Expr> converted = new ArrayList<>();
        if (expr instanceof BinaryExpr) {
            BinaryExpr binexp = (BinaryExpr) expr;
            if (binexp.op.name().equals(BinaryOp.EQUAL.name())) {
                if (binexp.left instanceof IdExpr) {
                    IdExpr leftexp = (IdExpr) binexp.left;
                    String id = removeDelimiters(leftexp.id);
                    if (!insprops.contains(id)) {
                        converted.add(new AssignExpr(binexp.left, binexp.right));
                    }
                }
            } else {
                converted.addAll(convertAssignmentinExpr(binexp.left, insprops));
                converted.addAll(convertAssignmentinExpr(binexp.right, insprops));
            }
        }
        return converted;
    }

    private List<Equation> inlinelocals(List<Equation> locals, List<Equation> lookup) {
        List<Equation> inlined = new ArrayList<>();
        for (Equation loc : locals) {
            Expr locexpr = loc.expr;
            if (locexpr instanceof IfThenElseExpr) {
                IfThenElseExpr itexp = (IfThenElseExpr) locexpr;
                IfThenElseExpr inlinedexp = new IfThenElseExpr(inlinelocalstoexp(itexp.cond, lookup).get(0),
                        inlinelocalstoexprs(itexp.thenExpr, lookup), inlinelocalstoexprs(itexp.elseExpr, lookup));
                inlined.add(new Equation(loc.location, loc.lhs, inlinedexp));
            } else if (locexpr instanceof BinaryExpr) {
                BinaryExpr binexp = (BinaryExpr) locexpr;
                BinaryExpr inlinedexp = new BinaryExpr(inlinelocalstoexp(binexp.left, lookup).get(0),
                        binexp.op, inlinelocalstoexp(binexp.right, lookup).get(0));
                inlined.add(new Equation(loc.location, loc.lhs, inlinedexp));
            } else if (locexpr instanceof UnaryExpr) {
                UnaryExpr unexp = (UnaryExpr) locexpr;
                UnaryExpr inlinedexp = new UnaryExpr(unexp.op, inlinelocalstoexp(unexp.expr, lookup).get(0));
                inlined.add(new Equation(loc.location, loc.lhs, inlinedexp));
            } else if (locexpr instanceof CastExpr) {
                CastExpr castexp = (CastExpr) locexpr;
                CastExpr inlinedexp = new CastExpr(castexp.type, inlinelocalstoexp(castexp.expr, lookup).get(0));
                inlined.add(new Equation(loc.location, loc.lhs, inlinedexp));
            } else {
                inlined.add(loc);
            }
        }
        return inlined;
    }

    private List<Expr> inlinelocalstoexprs(List<Expr> exprs, List<Equation> lookup) {
        List<Expr> inlined = new ArrayList<>();
        for (Expr exp : exprs) {
            inlined.addAll(inlinelocalstoexp(exp, lookup));
        }
        return inlined;
    }

    private List<Expr> inlinelocalstoexp(Expr expr, List<Equation> lookup) {
        List<Expr> exprs = new ArrayList<>();
        if (expr instanceof IdExpr) {
            IdExpr idexp = (IdExpr) expr;
            if (idexp.id.startsWith("a!")) {
                for (Equation loc : lookup) {
                    if (idexp.id.toString().equals(loc.lhs.id.toString())) {
                        exprs.addAll((inlinelocalstoexp(loc.expr, lookup)));
                    }
                }
            } else {
                exprs.add(expr);
            }
        } else if (expr instanceof BinaryExpr) {
            BinaryExpr binexp = (BinaryExpr) expr;
            exprs.add(new BinaryExpr(inlinelocalstoexp(binexp.left, lookup).get(0), binexp.op, inlinelocalstoexp(binexp.right, lookup).get(0)));
        } else if (expr instanceof UnaryExpr) {
            UnaryExpr unexp = (UnaryExpr) expr;
            exprs.add(new UnaryExpr(unexp.op, inlinelocalstoexp(unexp.expr, lookup).get(0)));

        } else if (expr instanceof CastExpr) {
            CastExpr castexp = (CastExpr) expr;
            exprs.add(new CastExpr(castexp.type, inlinelocalstoexp(castexp.expr, lookup).get(0)));
        } else if (expr instanceof IfThenElseExpr) {
            IfThenElseExpr itexp = (IfThenElseExpr) expr;
            exprs.add(new IfThenElseExpr(inlinelocalstoexp(itexp.cond, lookup).get(0),
                    inlinelocalstoexprs(itexp.thenExpr, lookup),
                    inlinelocalstoexprs(itexp.elseExpr, lookup)));
        } else {
            exprs.add(expr);
        }
        return exprs;
    }




    private List<Equation> locals(LetexpContext letCtx) {
        List<Equation> locs = new ArrayList<>();
        if (letCtx == null) {
            return locs;
        }
        for (LocalContext loc : letCtx.local()) {
            ExprContext locctx = loc.expr();
//            if (isAssignmentBlock(loc)) {
//                ExprContext locctx = loc.expr();
//                for (Expr e : splitassignments(locctx)) {
//                    locs.add(new Equation(loc(loc), new IdExpr(loc(loc), loc.ID().getText()), e));
//                }
//            } else {
//                locs.add(new Equation(loc(loc), new IdExpr(loc(loc), loc.ID().getText()), expr(loc.expr())));
//            }
            locs.add(new Equation(loc(loc), new IdExpr(loc(loc),loc.ID().getText()), expr(locctx)));
        }
        if (letCtx.body().letexp() !=null) {
            locs.addAll(locals(letCtx.body().letexp()));
        }
        return locs;
    }

    private List<Expr> splitassignments(ExprContext ctx) {
        List<Expr> assignments = new ArrayList<>();
        if (ctx instanceof ParenExprContext) {
            ParenExprContext pctx = (ParenExprContext) ctx;
            ExprContext epctx = pctx.expr();
            if (epctx instanceof BinaryExprContext) {
                BinaryExprContext bpctx = (BinaryExprContext) epctx;
                for (ExprContext ctxs : bpctx.expr()) {
                    assignments.add(expr(ctxs));
                }
            }
        }
        return assignments;
    }

    private boolean isAssignmentBlock(LocalContext locctx) {
        ExprContext elocctx = locctx.expr();
        if (elocctx instanceof ParenExprContext) {
            ParenExprContext pctx = (ParenExprContext) elocctx;
            if (pctx.expr() instanceof BinaryExprContext) {
                BinaryExprContext bpctx = (BinaryExprContext) pctx.expr();
                if (bpctx.op.getText().equals("and")) {
                    for (ExprContext ectx : bpctx.expr()) {
                        if (ectx instanceof ParenExprContext && ((ParenExprContext) ectx).expr() instanceof BinaryExprContext) {
                            ParenExprContext ppctx = (ParenExprContext) ectx;
                            BinaryExprContext bbpctx = (BinaryExprContext) ppctx.expr();
                            if (bbpctx.op.getText().equals("=")) {
                                continue;
                            } else {
                                return false;
                            }
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private List<Expr> body(BodyContext letCtx) {
        List<Expr> assignments = new ArrayList<>();
        if (letCtx.letexp() != null) {
            return body(letCtx.letexp().body());
        } else {
            ExprContext ctx = letCtx.expr();
            if (ctx instanceof BinaryExprContext) {
                BinaryExprContext bctx = (BinaryExprContext) ctx;
                for (ExprContext ectx : bctx.expr()) {
                    assignments.add(expr(ectx));
                }
            } else if (ctx instanceof BoolExprContext) {
                assignments.add(new ExitExpr());
            } else {
                assignments.add(expr(letCtx.expr()));
            }
            return assignments;
        }
    }


    private Type type(TypeContext ctx) {
        return (Type) ctx.accept(this);
    }

    @Override
    public Type visitIntType(IntTypeContext ctx) {
        return NamedType.INT;
    }

    @Override
    public Type visitBoolType(BoolTypeContext ctx) {
        return NamedType.BOOL;
    }

    @Override
    public Type visitRealType(RealTypeContext ctx) {
        return NamedType.REAL;
    }

    public Expr expr(ExprContext ctx) {
        return (Expr) ctx.accept(this);
    }

    @Override
    public Expr visitIdExpr(IdExprContext ctx) {
        if (ctx.ID().getText().equals("%init")) {
            return new BinaryExpr(loc(ctx), new IdExpr(loc(ctx), "init"), BinaryOp.EQUAL, new IntExpr(loc(ctx), BigInteger.valueOf(0)));
        } else {
            return new IdExpr(loc(ctx), ctx.ID().getText());
        }

    }

    @Override
    public Expr visitIntExpr(IntExprContext ctx) {
        return new IntExpr(loc(ctx), new BigInteger(ctx.INT().getText()));
    }

    @Override
    public Expr visitRealExpr(RealExprContext ctx) {
        return new RealExpr(loc(ctx), new BigDecimal(ctx.REAL().getText()));
    }

    @Override
    public Expr visitBoolExpr(BoolExprContext ctx) {
        return new BoolExpr(loc(ctx), ctx.BOOL().getText().equals("true"));
    }

    @Override
    public Expr visitCastExpr(CastExprContext ctx) {
        return new CastExpr(loc(ctx), getCastType(ctx.op.getText()), expr(ctx.expr()));
    }

    private Type getCastType(String cast) {
        switch (cast) {
            case "to_real":
                return NamedType.REAL;
            case "to_int":
                return NamedType.INT;
            default:
                throw new IllegalArgumentException("Unknown cast: " + cast);
        }
    }

    @Override
    public Expr visitNotExpr(NotExprContext ctx) {
        return new UnaryExpr(loc(ctx), UnaryOp.NOT, expr(ctx.expr()));
    }

    @Override
    public Expr visitNegateExpr(NegateExprContext ctx) {return new UnaryExpr(loc(ctx),UnaryOp.NEGATIVE, expr(ctx.expr()));}

    @Override
    public Expr visitBinaryExpr(BinaryExprContext ctx) {
        String op = ctx.op.getText();
        Expr left = expr(ctx.expr(0));
        List<Expr> right = new ArrayList<>();
        for (ExprContext ectx : ctx.expr().subList(1,ctx.expr().size())) {
            right.add(expr(ectx));
        }
        return new BinaryExpr(loc(ctx.op), left, BinaryOp.fromString(op), rewriteBExpr(BinaryOp.fromString(op), right));
    }

    private Expr rewriteBExpr(BinaryOp binaryOp, List<Expr> right) {
        if (right.size() > 1) {
            return new BinaryExpr(right.get(0), binaryOp, rewriteBExpr(binaryOp, right.subList(1, right.size())));
        } else {
            return right.get(0);
        }
    }

    @Override
    public Expr visitParenExpr(ParenExprContext ctx) {
        return (Expr) ctx.expr().accept(this);
    }


    @Override
    public Expr visitIfThenElseExpr(IfThenElseExprContext ctx) {
        List<Expr> thenbd = new ArrayList<>();
        List<Expr> elsebd = new ArrayList<>();
        ExprContext thenectx = ctx.expr(1);
        ExprContext elseectx = ctx.expr(2);
        if (thenectx instanceof ParenExprContext) {
            ParenExprContext pctx = (ParenExprContext) thenectx;
            if (pctx.expr() instanceof BinaryExprContext) {
                BinaryExprContext tbctx = (BinaryExprContext) pctx.expr();
                if (tbctx.op.getText().equals("and") && tbctx.expr().get(0) instanceof ParenExprContext) {
                    ParenExprContext ppctx = (ParenExprContext) tbctx.expr().get(0);
                    if (ppctx.expr() instanceof BinaryExprContext) {
                        BinaryExprContext bctx = (BinaryExprContext) ppctx.expr();
                        if(bctx.op.getText().equals("=")) {
                            for (ExprContext ctxs : tbctx.expr()) {
                                thenbd.add(expr(ctxs));
                            }
                        } else {
                            thenbd.add(expr(tbctx));
                        }
                    } else {
                        thenbd.add(expr(tbctx));
                    }
                } else {
                    thenbd.add(expr(tbctx));
                }
            } else {
                thenbd.add(expr(pctx.expr()));
            }
//        } else if (thenectx instanceof BoolExprContext) {
//            thenbd.add(new ExitExpr());
        }   else {
            thenbd.add(expr(thenectx));
        }

        if (elseectx instanceof ParenExprContext) {
            ParenExprContext pctx = (ParenExprContext) elseectx;
            if (pctx.expr() instanceof BinaryExprContext) {
                BinaryExprContext tbctx = (BinaryExprContext) pctx.expr();
                if (tbctx.op.getText().equals("and") && tbctx.expr().get(0) instanceof ParenExprContext) {
                    ParenExprContext ppctx = (ParenExprContext) tbctx.expr().get(0);
                    if (ppctx.expr() instanceof BinaryExprContext) {
                        BinaryExprContext bctx = (BinaryExprContext) ppctx.expr();
                        if(bctx.op.getText().equals("=")) {
                            for (ExprContext ctxs : tbctx.expr()) {
                                elsebd.add(expr(ctxs));
                            }
                        } else {
                            elsebd.add(expr(tbctx));
                        }
                    } else {
                        elsebd.add(expr(tbctx));
                    }
                } else {
                    elsebd.add(expr(tbctx));
                }
            }else {
                elsebd.add(expr(pctx.expr()));
            }
//        } else if (elseectx instanceof BoolExprContext) {
//            elsebd.add(new ExitExpr());
        } else {
            elsebd.add(expr(elseectx));
        }
        return new IfThenElseExpr(loc(ctx), expr(ctx.expr(0)), thenbd, elsebd);
    }

    private static Location loc(ParserRuleContext ctx) {
        return loc(ctx.getStart());
    }

    private static Location loc(Token token) {
        return new Location(token.getLine(), token.getCharPositionInLine());
    }

    private static String rename(String id) {
        if (id.startsWith("$")) {
            String renamed = id.substring(1).replaceAll("[~.]","_");
            return renamed;
        } else {
            String renamed = id.replaceAll("[%~.]","_");
            return renamed;
        }
    }
}