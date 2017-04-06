import ast.types.CNamedType;
import skolem.*;
import ast.*;
import visitors.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class SkolemstoCtranslator {
    private static CVarDecl init = new CVarDecl("init",new CNamedType("static "+CNamedType.INT), new CIntExpr(BigInteger.valueOf(0)));

    public static CProgram translate(Scratch scratch, String filename){
        String[] path = filename.split("[/]");
        String truename = path[path.length-1];

        List<CArrayDecl> vars = new ArrayList<>();
        List<CArrayDecl> outputs = new ArrayList<>();
        List<CAssignment> equations = new ArrayList<>();
        List<CFunction> functions = new ArrayList<>();
        List<CFunctionCallExpr> funcalls = new ArrayList<>();


        int arraysize = scratch.skolems.size();

        SMTLibToCExprVisitor exprVisitor = new SMTLibToCExprVisitor();
        SMTLibToCTypeVisitor typeVisitor = new SMTLibToCTypeVisitor();

        String functionName = "skolem_";

        for (VarDecl var : scratch.inputs) {
            NamedType vartype = (NamedType) var.type;
            CArrayDecl variable =
                    new CArrayDecl(new CIdExpr(truncate(var.id)),typeVisitor.visit(vartype), arraysize);
            vars.add(variable);
        }

        for (VarDecl var : scratch.outputs) {
            NamedType vartype = (NamedType) var.type;
            CArrayDecl variable =
                    new CArrayDecl(new CIdExpr(truncate(var.id)),typeVisitor.visit(vartype), arraysize);
            outputs.add(variable);
            vars.add(variable);
        }

        int i = 0;

        for (Skolem sk : scratch.skolems) {
            List<CExpr> body = new ArrayList<>();
            for (Expr e : sk.body) {
                CExpr expr = exprVisitor.visit(e);
                CExpr renamed = rename(expr, i);
                body.add(renamed);
            }
            String name = functionName+Integer.toString(i);
            functions.add(new CSkolemFunction(name, body));
            funcalls.add(new CFunctionCallExpr(name));
            equations.clear();
            i++;
        }
        if (arraysize > 1) {
            CMoveHistory mh = addMoveHistory(arraysize, outputs);
            functions.add(mh);
            functions.add(addUpdateFunction(init, funcalls, mh));
            return new CProgram(init, truename, vars, functions);

        } else {
            functions.add(addSingleSkolemUpdateFunction(init, funcalls));
            return new CProgram(init, truename, vars, functions);
        }
    }


    public static CHeader addHeader(Scratch scratch, String filename) {
        String[] path = filename.split("[/]");
        String truename = path[path.length-1];
        List<CArrayDecl> inputs = new ArrayList<>();
        List<CArrayDecl> outputs = new ArrayList<>();
        List<CFunction> functions = new ArrayList<>();


        int arraysize = scratch.skolems.size();

        SMTLibToCTypeVisitor typeVisitor = new SMTLibToCTypeVisitor();

        String functionName = "skolem_";


        for (VarDecl var : scratch.inputs) {
            NamedType vartype = (NamedType) var.type;
            CArrayDecl arr = new CArrayDecl(
                    new CIdExpr(truncate(var.id)),typeVisitor.visit(vartype), arraysize);
            inputs.add(arr);
        }

        for (VarDecl var : scratch.outputs) {
            NamedType vartype = (NamedType) var.type;
            CArrayDecl variable = new CArrayDecl(
                    new CIdExpr(truncate(var.id)),typeVisitor.visit(vartype), arraysize);
            outputs.add(variable);
        }

        for (int i = 0; i < arraysize; i++) {
            String name = functionName+Integer.toString(i);
            functions.add(new CSkolemFunction(name));
        }
        functions.add(new CMoveHistory());
        functions.add(new CUpdateFunction());
        CHeader header = new CHeader(truename, inputs, outputs, functions);
        return header;
    }

    public static CHarness addHarnessC(Scratch scratch, String filename, int iter) {
        String[] path = filename.split("[/]");
        String truename = path[path.length-1];
        List<CExpr> body = new ArrayList<>();
        List<CVarDecl> vars = new ArrayList<>();
        List<CExpr> pbody = new ArrayList<>();


        SMTLibToCTypeVisitor typeVisitor = new SMTLibToCTypeVisitor();
        CVarDecl start = new CVarDecl("smtlib2c_start", new CNamedType("clock_t"),
                new CFunctionCall(new CClockFunction().name));
        CVarDecl diff = new CVarDecl("smtlib2c_clock_diff", new CNamedType("clock_t"));
        CVarDecl sec = new CVarDecl("smtlib2c_sec", CNamedType.DOUBLE);
        vars.add(start);
        vars.add(diff);
        vars.add(sec);

        body.add(createHarnessCbody(scratch, typeVisitor, iter));

        CBinaryExpr diffexp = new CBinaryExpr(new CFunctionCall(new CClockFunction().name),
                CBinaryOp.MINUS, new CIdExpr(start.id));
        CIdExpr diffid = new CIdExpr(diff.id);
        CAssignment diffassign = new CAssignment(diffid, diffexp);
        body.add(diffassign);

        CIntExpr thousexp = new CIntExpr(BigInteger.valueOf(1000));

        CIdExpr secid = new CIdExpr(sec.id);
        CCastExpr secexp = new CCastExpr(CNamedType.DOUBLE, diffid);
        CBinaryExpr exp = new CBinaryExpr(secexp, CBinaryOp.DIVIDE, new CIdExpr("CLOCKS_PER_SEC"));
        CAssignment secassign = new CAssignment(secid, exp);
        body.add(secassign);

        CIdExpr text = new CIdExpr("\""+ truename+" %f\\n\"");
        CBinaryExpr msec = new CBinaryExpr(secid, CBinaryOp.MULTIPLY, thousexp);
        pbody.add(text);
        pbody.add(msec);

        CPrintFunction print = new CPrintFunction(pbody);
        CFunctionCallExpr printcall = new CFunctionCallExpr(print.name, print.args);
        body.add(printcall);

        CHarnessMain main = new CHarnessMain(vars, body);
        CHarness harness = new CHarness(main, truename);
        return harness;
    }

    private static CExpr createHarnessCbody(Scratch scratch, SMTLibToCTypeVisitor visitor, int iter) {
        List<CExpr> updates = new ArrayList<>();
        List<CExpr> forbody = new ArrayList<>();
        int arraysize = scratch.skolems.size();
        String functionName = "skolem_";
        CVarDecl iterexp = new CVarDecl("mainiterator", CNamedType.INT);
        CIdExpr iterid = new CIdExpr(iterexp.id);
        CAssignment iterassign = new CAssignment(iterid, new CIntExpr(BigInteger.valueOf(0)));
        CBinaryExpr cond = new CBinaryExpr(iterid, CBinaryOp.LESS, new CIntExpr(BigInteger.valueOf(iter)));
        CUnaryExpr incr = new CUnaryExpr(CUnaryOp.PLUSPLUS, iterid);
        for (VarDecl var : scratch.inputs) {
            NamedType vartype = (NamedType) var.type;
            CExpr rand = createrandcall((CNamedType) visitor.visit(vartype));
            updates.add(new CArrayUpdateExpr(new CIdExpr(truncate(var.id)),
                    new CIntExpr(BigInteger.valueOf(0)), rand));
        }
        forbody.addAll(updates);
        forbody.add(new CFunctionCallExpr(new CUpdateFunction().name));

//        if (arraysize > 1) {
//            forbody.add(new CFunctionCallExpr(new CUpdateFunction().name));
//        } else {
//            forbody.add(new CFunctionCallExpr(functionName+Integer.toString(0)));
//        }
        CForExpr loop = new CForExpr(iterexp, iterassign, cond, incr, forbody);
        return loop;
    }

    private static CExpr createrandcall(CNamedType type) {
        String name = type.name;
        if (name.equals("_Bool")) {
            CBinaryExpr bexp = new CBinaryExpr(new CFunctionCall(new CRandFunction().name),
                    CBinaryOp.MODULUS, new CIntExpr(BigInteger.valueOf(2)));
            return new CCastExpr(type, bexp);
        } else if (name.equals("Int")) {
            return new CFunctionCall(new CRandFunction().name);
        } else {
            return new CFunctionCall(new CRandFunction().name);
        }
    }

    public static LustreCHarness addHarnessLustreC(Scratch scratch, String filename, String nodename, int iter) {
        String[] path = filename.split("[/]");
        String truename = path[path.length-1];
        List<CVarDecl> inputs = new ArrayList<>();
        List<CExpr> body = new ArrayList<>();
        List<CVarDecl> vars = new ArrayList<>();
        List<CExpr> pbody = new ArrayList<>();
        List<CExpr> resetargs = new ArrayList<>();


        SMTLibToCTypeVisitor typeVisitor = new SMTLibToCTypeVisitor();
        CVarDecl start = new CVarDecl("start", new CNamedType("clock_t"),
                new CFunctionCall(new CClockFunction().name));
        CVarDecl diff = new CVarDecl("clock_diff", new CNamedType("clock_t"));
        CVarDecl sec = new CVarDecl("sec", CNamedType.DOUBLE);
        vars.add(start);
        vars.add(diff);
        vars.add(sec);

        CVarDecl ctx = new CVarDecl("ctx", new CNamedType(truename+"_top_bbb_ctx_type*"),
                new CIdExpr(truename+"_top_bbb_ctx_new_ctx(NULL)"));
        vars.add(ctx);
        
//        for (VarDecl var : scratch.skolems.get(0).inputs){
        for (VarDecl var : scratch.inputs){
            NamedType vartype = (NamedType) var.type;
            CIdExpr truncated = new CIdExpr(truncate(var.id));
            inputs.add(new CVarDecl(truncated.id, typeVisitor.visit(vartype)));
        }

        //We do not add the return variables to the step function
        //automatically. This has to be done manually for now.


//        CIdExpr structid = new CIdExpr("mem");
//        CIdExpr structptr = new CIdExpr("&mem");
//        resetargs.add(structptr);
//        CStructDecl memstruct = new CStructDecl(structid.id , new CNamedType(nodename+"_mem"));
//        CFunctionCallExpr resetfun = new CFunctionCallExpr(nodename+"_reset", resetargs);
//        body.add(resetfun);

        body.add(createHarnessLustreCbody(scratch, typeVisitor, truename, iter, resetargs));

        CBinaryExpr diffexp = new CBinaryExpr(new CFunctionCall(new CClockFunction().name),
                CBinaryOp.MINUS, new CIdExpr(start.id));
        CIdExpr diffid = new CIdExpr(diff.id);
        CAssignment diffassign = new CAssignment(diffid, diffexp);
        body.add(diffassign);

        CIntExpr thousexp = new CIntExpr(BigInteger.valueOf(1000));

        CIdExpr secid = new CIdExpr(sec.id);
        CCastExpr secexp = new CCastExpr(CNamedType.DOUBLE, diffid);
        CBinaryExpr exp = new CBinaryExpr(secexp, CBinaryOp.DIVIDE, new CIdExpr("CLOCKS_PER_SEC"));
        CAssignment secassign = new CAssignment(secid, exp);
        body.add(secassign);

        CIdExpr text = new CIdExpr("\""+ truename+" %f\\n\"");
        CBinaryExpr msec = new CBinaryExpr(secid, CBinaryOp.MULTIPLY, thousexp);
        pbody.add(text);
//        pbody.add(secid);
        pbody.add(msec);

        CPrintFunction print = new CPrintFunction(pbody);
        CFunctionCallExpr printcall = new CFunctionCallExpr(print.name, print.args);
        body.add(printcall);
        LustreCHarnessMain main = new LustreCHarnessMain(vars, body);
//        LustreCHarnessMain main = new LustreCHarnessMain(vars, memstruct, body);
        LustreCHarness harness = new LustreCHarness(inputs, main, truename);
        return harness;
    }

    private static CExpr createHarnessLustreCbody(Scratch scratch, SMTLibToCTypeVisitor visitor, String truename, int iter, List<CExpr> args) {
        List<CExpr> updates = new ArrayList<>();
        List<CExpr> forbody = new ArrayList<>();
        List<CExpr> stepargs = new ArrayList<>();

        CVarDecl iterexp = new CVarDecl("mainiterator", CNamedType.INT);
        CIdExpr iterid = new CIdExpr(iterexp.id);
        CAssignment iterassign = new CAssignment(iterid, new CIntExpr(BigInteger.valueOf(0)));
        CBinaryExpr cond = new CBinaryExpr(iterid, CBinaryOp.LESS, new CIntExpr(BigInteger.valueOf(iter)));
        CUnaryExpr incr = new CUnaryExpr(CUnaryOp.PLUSPLUS, iterid);

        for (VarDecl var : scratch.inputs){
            NamedType vartype = (NamedType) var.type;
            CExpr rand = createrandcall((CNamedType) visitor.visit(vartype));
            CIdExpr truncated = new CIdExpr("ctx->"+truncate(var.id));
            updates.add(new CAssignment(truncated, rand));
//            stepargs.add(truncated);
        }
        forbody.addAll(updates);

//        stepargs.addAll(args);
        stepargs.add(new CIdExpr("ctx"));
        forbody.add(new CFunctionCallExpr(truename+"_top_bbb_step", stepargs));
        CForExpr loop = new CForExpr(iterexp, iterassign, cond, incr, forbody);
        return loop;
    }


    private static String truncate(String id) {
        String truncated = id.split("[$]")[0];
        return truncated;
    }

    private static CExpr rename(CExpr exp, int i) {
        if (exp instanceof CIdExpr) {
            CIdExpr idexp = (CIdExpr) exp;
            String id = idexp.id;
            if (id.equals("%init")) {
                return new CBoolExpr(false);
            } else if (id.contains("$")) {
                String[] trunc = id.split("[$]");
                String name = trunc[1].replaceAll("[~.]","_");
                String index = trunc[2].replaceAll("~1", Integer.toString(i - 1));
                if (index.equals("-1))")) {
                    System.out.println(index);
                }
                Integer ind = Integer.valueOf(index);
                if (ind >= i) {
                    return new CArrayAccessExpr(new CIdExpr(name), new CIntExpr(BigInteger.valueOf(i)));
                } else if (ind == -1) {
                    return new CArrayAccessExpr(new CIdExpr(name), new CIntExpr(BigInteger.valueOf(0)));
                }else {
                    return new CArrayAccessExpr(new CIdExpr(name), new CIntExpr(BigInteger.valueOf(ind)));
                }
            } else {
                return exp;
            }
        } else if (exp instanceof CBinaryExpr) {
            CBinaryExpr bexp = (CBinaryExpr) exp;
            return new CBinaryExpr(rename(bexp.left, i), bexp.op, rename(bexp.right, i));
        } else if (exp instanceof CAssignment) {
            CAssignment aexp = (CAssignment) exp;
            return new CAssignment(rename(aexp.varToAssign, i), rename(aexp.expr, i));
        } else if (exp instanceof CArrayAccessExpr) {
            CArrayAccessExpr aexp = (CArrayAccessExpr) exp;
            return new CArrayAccessExpr((CIdExpr) rename(aexp.name, i), rename(aexp.index, i));
        } else if (exp instanceof CArrayUpdateExpr) {
            CArrayUpdateExpr aexp = (CArrayUpdateExpr) exp;
            return new CArrayUpdateExpr((CIdExpr) rename(aexp.id, i), rename(aexp.index, i), aexp.value);
        } else if (exp instanceof CCastExpr) {
            CCastExpr cexp = (CCastExpr) exp;
            return new CCastExpr(cexp.type, rename(cexp.expr, i));
        } else if (exp instanceof CUnaryExpr) {
            CUnaryExpr uexp = (CUnaryExpr) exp;
            return new CUnaryExpr(uexp.op, rename(uexp.expr, i));
        } else if (exp instanceof CIfThenElseExpr) {
            CIfThenElseExpr iexp = (CIfThenElseExpr) exp;
            List<CExpr> texp = new ArrayList<>();
            List<CExpr> elexp = new ArrayList<>();

            for (CExpr t : iexp.thenExpr) {
                texp.add(rename(t, i));
            }

            for (CExpr e : iexp.elseExpr) {
                elexp.add(rename(e, i));
            }

            return new CIfThenElseExpr(rename(iexp.cond, i), texp, elexp);
        }  else if (exp instanceof CTernaryExpr) {
            CTernaryExpr iexp = (CTernaryExpr) exp;
            List<CExpr> texp = new ArrayList<>();
            List<CExpr> elexp = new ArrayList<>();

            for (CExpr t : iexp.thenExpr) {
                texp.add(rename(t, i));
            }

            for (CExpr e : iexp.elseExpr) {
                elexp.add(rename(e, i));
            }

            return new CTernaryExpr(rename(iexp.cond, i), texp, elexp);
        } else if (exp instanceof CForExpr) {
            CForExpr fexp = (CForExpr) exp;
            List<CExpr> bexp = new ArrayList<>();

            for (CExpr b : fexp.body) {
                bexp.add(rename(b, i));
            }
            return new CForExpr(fexp.iter, (CAssignment) rename(fexp.iterassign, i),
                    rename(fexp.cond, i), rename(fexp.diff, i), bexp);
        } else {
            return exp;
        }
    }

    private static CMoveHistory addMoveHistory(int k, List<CArrayDecl> outs){
        List<CExpr> updates= new ArrayList<>();
        CVarDecl iter = new CVarDecl("iterator", CNamedType.INT);
        CIdExpr iterid = new CIdExpr(iter.id);
        CAssignment iterassign = new CAssignment(iterid, new CIntExpr(BigInteger.valueOf(k)));
        CBinaryExpr cond = new CBinaryExpr(iterid, CBinaryOp.GREATER, new CIntExpr(BigInteger.valueOf(0)));
        CUnaryExpr incr = new CUnaryExpr(CUnaryOp.MINUSMINUS, iterid);
        CBinaryExpr next = new CBinaryExpr(iterid, CBinaryOp.MINUS, new CIntExpr(BigInteger.valueOf(1)));
        for (CArrayDecl out : outs) {
            updates.add(new CArrayUpdateExpr(out.id,
                    iterid, new CArrayAccessExpr(out.id, next)));
        }
        CForExpr loop = new CForExpr(iter, iterassign, cond, incr, updates);
        return new CMoveHistory(loop);
    }

    private static CUpdateFunction addUpdateFunction(CVarDecl init, List<CFunctionCallExpr> calls, CMoveHistory mh){
        CIdExpr initvar = new CIdExpr(init.id);
        CFunctionCallExpr mhcall = new CFunctionCallExpr(mh.name);
        CExpr body = createUpdateBody(initvar, mhcall, calls, 0).get(0);
        return new CUpdateFunction(body);
    }

    private static CUpdateFunction addSingleSkolemUpdateFunction(CVarDecl init, List<CFunctionCallExpr> calls){
        CIdExpr initvar = new CIdExpr(init.id);
        CExpr body = createSingleSkolemUpdateBody(initvar, calls, 0).get(0);
        return new CUpdateFunction(body);
    }


    private static List<CExpr> createUpdateBody(CIdExpr init, CFunctionCallExpr mhcall, List<CFunctionCallExpr> calls, int value) {
        List<CExpr> body = new ArrayList<>();

        if (calls.size() > 1) {
            List<CExpr> thenbody = new ArrayList<>();
            List<CExpr> elsebody = new ArrayList<>();

            CAssignment initassign = new CAssignment(init,
                    new CBinaryExpr(init, CBinaryOp.PLUS, new CIntExpr(BigInteger.valueOf(1))));

            thenbody.add(calls.get(0));
            thenbody.add(mhcall);
            thenbody.add(initassign);

            BigInteger val = BigInteger.valueOf(value);
            elsebody.addAll(createUpdateBody(init, mhcall, calls.subList(1, calls.size()), value + 1));
            CExpr cond = new CBinaryExpr(init, CBinaryOp.EQUAL, new CIntExpr(val));
            body.add(new CIfThenElseExpr(cond, thenbody, elsebody));
            return body;
        } else {
            body.add(calls.get(0));
            body.add(mhcall);
            return body;
        }
    }

    private static List<CExpr> createSingleSkolemUpdateBody(CIdExpr init, List<CFunctionCallExpr> calls, int value) {
        List<CExpr> body = new ArrayList<>();
        List<CExpr> thenbody = new ArrayList<>();
        List<CExpr> elsebody = new ArrayList<>();

        CAssignment initassign = new CAssignment(init,
                new CBinaryExpr(init, CBinaryOp.PLUS, new CIntExpr(BigInteger.valueOf(1))));


        BigInteger val = BigInteger.valueOf(value);
        CExpr cond = new CBinaryExpr(init, CBinaryOp.EQUAL, new CIntExpr(val));

        thenbody.add(calls.get(0));
        thenbody.add(initassign);

        elsebody.add(calls.get(0));
        body.add(new CIfThenElseExpr(cond, thenbody, elsebody));

        return body;
    }
}
