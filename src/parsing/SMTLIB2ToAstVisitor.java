package parsing;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import parsing.SMTLIB2Parser.*;




import skolem.*;

public class SMTLIB2ToAstVisitor extends SMTLIB2BaseVisitor<Object> {

    public Scratch scratch(ScratchContext ctx) {

        List<Skolem> skolems = skolems(ctx.skolem());
        return new Scratch(loc(ctx), skolems);
    }

    private List<Skolem> skolems(List<SkolemContext> ctxs) {
        List<Skolem> skolems = new ArrayList<>();
        for (SkolemContext ctx : ctxs) {
            skolems.add(skolem(ctx));
        }
        return skolems;
    }

    public Skolem skolem(SkolemContext ctx) {
        List<DeclareContext> dctx = ctx.declare();
        List<VarDecl> inputs = inputs(dctx);
        List<VarDecl> outputs = outputs(dctx);
        List<Equation> locals = locals(ctx.letexp());
        List<Expr> body = body(ctx.letexp().body());
        List<Expr> finalbody = inlinelocals(locals,body);
        return new Skolem(loc(ctx), inputs, outputs, locals, finalbody);
    }

    private List<Expr> inlinelocals(List<Equation> locals, List<Expr> body) {
        List<Expr> inlined = new ArrayList<>();

        for (Expr b : body) {
            if (b instanceof IfThenElseExpr) {
                IfThenElseExpr bd = (IfThenElseExpr) b;
                inlined.add(new IfThenElseExpr(inlinelocs(locals,bd.cond),
                        inlinelocals(locals, bd.thenExpr), inlinelocals(locals, bd.elseExpr)));
            } else if (b instanceof IdExpr) {
                IdExpr bd = (IdExpr) b;
                for (Equation loc : locals) {
                    if(bd.id.toString().equals(loc.lhs.id.toString())) {
                        List<Expr> temp = new ArrayList<>();
                        temp.add(loc.expr);
                        inlined.addAll(inlinelocals(locals,temp));
                    }
                }
            } else {
               inlined.add(b);
            }
        }
        return inlined;
    }

    private Expr inlinelocs(List<Equation> locals, Expr cond) {
        if (cond instanceof IdExpr) {
            IdExpr cd = (IdExpr) cond;
            for (Equation loc : locals) {
                if(cd.id.toString().equals(loc.lhs.id.toString())) {
                    return(loc.expr);
                }
            }
        }
        return cond;
    }


    private List<VarDecl> inputs(List<DeclareContext> listCtx) {
        List<VarDecl> decls = new ArrayList<>();
        if (listCtx == null) {
            return decls;
        }

        for (DeclareContext dCtx : listCtx) {
            String id = dCtx.ID().getText();
            if(id.endsWith("$0")) {
                Type type = type(dCtx.type());
                decls.add(new VarDecl(loc(dCtx), rename(id), type));
            }
        }
        return decls;
    }

    private List<VarDecl> outputs(List<DeclareContext> listCtx) {
        List<VarDecl> decls = new ArrayList<>();
        if (listCtx == null) {
            return decls;
        }

        for (DeclareContext dCtx : listCtx) {
            String id = dCtx.ID().getText();
            if(!(id.endsWith("$0") || id.equals("%init"))) {
                Type type = type(dCtx.type());
                decls.add(new VarDecl(loc(dCtx), rename(id), type));
            }
        }
        return decls;
    }

    private List<Equation> locals(LetexpContext letCtx) {
        List<Equation> locs = new ArrayList<>();
        if (letCtx == null) {
            return locs;
        }

        for (LocalContext loc : letCtx.local()) {
            ExprContext locctx = loc.expr();
            if (isAssignmentBlock(locctx)) {
                for (Expr e : splitassignments(locctx)) {
                    //Expr renamedexpr = renamevars(e);
                    locs.add(new Equation(loc(loc), new IdExpr(loc(loc), loc.ID().getText()), e));
                }
            } else {
                locs.add(new Equation(loc(loc), new IdExpr(loc(loc), loc.ID().getText()), expr(loc.expr())));
            }
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

    private boolean isAssignmentBlock(ExprContext locctx) {
        if (locctx instanceof ParenExprContext) {
            ParenExprContext pctx = (ParenExprContext) locctx;
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

    public Expr expr(ExprContext ctx) {
        return (Expr) ctx.accept(this);
    }

    @Override
    public Expr visitIdExpr(IdExprContext ctx) {
        if (ctx.ID().getText().equals("%init")) {
            return new BoolExpr(loc(ctx),false);
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
    public Expr visitBinaryExpr(BinaryExprContext ctx) {
        String op = ctx.op.getText();
        Expr left = expr(ctx.expr(0));
        Expr right = expr(ctx.expr(1));
        return new BinaryExpr(loc(ctx.op), left, BinaryOp.fromString(op), right);
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
                for (ExprContext ctxs : tbctx.expr()) {
                    thenbd.add(expr(ctxs));
                }
            }else {
                thenbd.add(expr(pctx.expr()));
            }
        } else if (thenectx instanceof BoolExprContext) {
            thenbd.add(new ExitExpr());
        }   else {
            thenbd.add(expr(thenectx));
        }
        if (elseectx instanceof ParenExprContext) {
            ParenExprContext pctx = (ParenExprContext) elseectx;
            if (pctx.expr() instanceof BinaryExprContext) {
                BinaryExprContext ebctx = (BinaryExprContext) pctx.expr();
                for (ExprContext ctxs : ebctx.expr()) {
                    elsebd.add(expr(ctxs));
                }
            } else {
                elsebd.add(expr(pctx.expr()));
            }
        } else if (elseectx instanceof BoolExprContext) {
            elsebd.add(new ExitExpr());
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