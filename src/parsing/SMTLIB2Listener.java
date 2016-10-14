// Generated from /home/dr41k/git/SMTLib2C/src/parsing/SMTLIB2.g4 by ANTLR 4.5.3
package parsing;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SMTLIB2Parser}.
 */
public interface SMTLIB2Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SMTLIB2Parser#scratch}.
	 * @param ctx the parse tree
	 */
	void enterScratch(SMTLIB2Parser.ScratchContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMTLIB2Parser#scratch}.
	 * @param ctx the parse tree
	 */
	void exitScratch(SMTLIB2Parser.ScratchContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMTLIB2Parser#skolem}.
	 * @param ctx the parse tree
	 */
	void enterSkolem(SMTLIB2Parser.SkolemContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMTLIB2Parser#skolem}.
	 * @param ctx the parse tree
	 */
	void exitSkolem(SMTLIB2Parser.SkolemContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMTLIB2Parser#check}.
	 * @param ctx the parse tree
	 */
	void enterCheck(SMTLIB2Parser.CheckContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMTLIB2Parser#check}.
	 * @param ctx the parse tree
	 */
	void exitCheck(SMTLIB2Parser.CheckContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMTLIB2Parser#declare}.
	 * @param ctx the parse tree
	 */
	void enterDeclare(SMTLIB2Parser.DeclareContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMTLIB2Parser#declare}.
	 * @param ctx the parse tree
	 */
	void exitDeclare(SMTLIB2Parser.DeclareContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMTLIB2Parser#letexp}.
	 * @param ctx the parse tree
	 */
	void enterLetexp(SMTLIB2Parser.LetexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMTLIB2Parser#letexp}.
	 * @param ctx the parse tree
	 */
	void exitLetexp(SMTLIB2Parser.LetexpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMTLIB2Parser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(SMTLIB2Parser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMTLIB2Parser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(SMTLIB2Parser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMTLIB2Parser#local}.
	 * @param ctx the parse tree
	 */
	void enterLocal(SMTLIB2Parser.LocalContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMTLIB2Parser#local}.
	 * @param ctx the parse tree
	 */
	void exitLocal(SMTLIB2Parser.LocalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intType}
	 * labeled alternative in {@link SMTLIB2Parser#type}.
	 * @param ctx the parse tree
	 */
	void enterIntType(SMTLIB2Parser.IntTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link SMTLIB2Parser#type}.
	 * @param ctx the parse tree
	 */
	void exitIntType(SMTLIB2Parser.IntTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link SMTLIB2Parser#type}.
	 * @param ctx the parse tree
	 */
	void enterBoolType(SMTLIB2Parser.BoolTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link SMTLIB2Parser#type}.
	 * @param ctx the parse tree
	 */
	void exitBoolType(SMTLIB2Parser.BoolTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code realType}
	 * labeled alternative in {@link SMTLIB2Parser#type}.
	 * @param ctx the parse tree
	 */
	void enterRealType(SMTLIB2Parser.RealTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code realType}
	 * labeled alternative in {@link SMTLIB2Parser#type}.
	 * @param ctx the parse tree
	 */
	void exitRealType(SMTLIB2Parser.RealTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(SMTLIB2Parser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(SMTLIB2Parser.IdExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIntExpr(SMTLIB2Parser.IntExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIntExpr(SMTLIB2Parser.IntExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code realExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterRealExpr(SMTLIB2Parser.RealExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code realExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitRealExpr(SMTLIB2Parser.RealExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(SMTLIB2Parser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(SMTLIB2Parser.BoolExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code castExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCastExpr(SMTLIB2Parser.CastExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code castExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCastExpr(SMTLIB2Parser.CastExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(SMTLIB2Parser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(SMTLIB2Parser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negateExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNegateExpr(SMTLIB2Parser.NegateExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negateExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNegateExpr(SMTLIB2Parser.NegateExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpr(SMTLIB2Parser.BinaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpr(SMTLIB2Parser.BinaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(SMTLIB2Parser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(SMTLIB2Parser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifThenElseExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIfThenElseExpr(SMTLIB2Parser.IfThenElseExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifThenElseExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIfThenElseExpr(SMTLIB2Parser.IfThenElseExprContext ctx);
}