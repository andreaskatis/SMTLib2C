package parsing.smtlib;// Generated from /home/dr41k/git/SMTLib2C/src/parsing/smtlib/SMTLIB2.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SMTLIB2Parser}.
 */
public interface SMTLIB2Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code realType}
	 * labeled alternative in {@link SMTLIB2Parser#type}.
	 * @param ctx the parse tree
	 */
	void enterRealType(@NotNull SMTLIB2Parser.RealTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code realType}
	 * labeled alternative in {@link SMTLIB2Parser#type}.
	 * @param ctx the parse tree
	 */
	void exitRealType(@NotNull SMTLIB2Parser.RealTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIntExpr(@NotNull SMTLIB2Parser.IntExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIntExpr(@NotNull SMTLIB2Parser.IntExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMTLIB2Parser#declare}.
	 * @param ctx the parse tree
	 */
	void enterDeclare(@NotNull SMTLIB2Parser.DeclareContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMTLIB2Parser#declare}.
	 * @param ctx the parse tree
	 */
	void exitDeclare(@NotNull SMTLIB2Parser.DeclareContext ctx);
	/**
	 * Enter a parse tree produced by the {@code castExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCastExpr(@NotNull SMTLIB2Parser.CastExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code castExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCastExpr(@NotNull SMTLIB2Parser.CastExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMTLIB2Parser#inputs}.
	 * @param ctx the parse tree
	 */
	void enterInputs(@NotNull SMTLIB2Parser.InputsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMTLIB2Parser#inputs}.
	 * @param ctx the parse tree
	 */
	void exitInputs(@NotNull SMTLIB2Parser.InputsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intType}
	 * labeled alternative in {@link SMTLIB2Parser#type}.
	 * @param ctx the parse tree
	 */
	void enterIntType(@NotNull SMTLIB2Parser.IntTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link SMTLIB2Parser#type}.
	 * @param ctx the parse tree
	 */
	void exitIntType(@NotNull SMTLIB2Parser.IntTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code realExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterRealExpr(@NotNull SMTLIB2Parser.RealExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code realExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitRealExpr(@NotNull SMTLIB2Parser.RealExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMTLIB2Parser#skolem}.
	 * @param ctx the parse tree
	 */
	void enterSkolem(@NotNull SMTLIB2Parser.SkolemContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMTLIB2Parser#skolem}.
	 * @param ctx the parse tree
	 */
	void exitSkolem(@NotNull SMTLIB2Parser.SkolemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifThenElseExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIfThenElseExpr(@NotNull SMTLIB2Parser.IfThenElseExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifThenElseExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIfThenElseExpr(@NotNull SMTLIB2Parser.IfThenElseExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpr(@NotNull SMTLIB2Parser.BinaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpr(@NotNull SMTLIB2Parser.BinaryExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMTLIB2Parser#scratch}.
	 * @param ctx the parse tree
	 */
	void enterScratch(@NotNull SMTLIB2Parser.ScratchContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMTLIB2Parser#scratch}.
	 * @param ctx the parse tree
	 */
	void exitScratch(@NotNull SMTLIB2Parser.ScratchContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMTLIB2Parser#check}.
	 * @param ctx the parse tree
	 */
	void enterCheck(@NotNull SMTLIB2Parser.CheckContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMTLIB2Parser#check}.
	 * @param ctx the parse tree
	 */
	void exitCheck(@NotNull SMTLIB2Parser.CheckContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMTLIB2Parser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(@NotNull SMTLIB2Parser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMTLIB2Parser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(@NotNull SMTLIB2Parser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMTLIB2Parser#local}.
	 * @param ctx the parse tree
	 */
	void enterLocal(@NotNull SMTLIB2Parser.LocalContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMTLIB2Parser#local}.
	 * @param ctx the parse tree
	 */
	void exitLocal(@NotNull SMTLIB2Parser.LocalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link SMTLIB2Parser#type}.
	 * @param ctx the parse tree
	 */
	void enterBoolType(@NotNull SMTLIB2Parser.BoolTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link SMTLIB2Parser#type}.
	 * @param ctx the parse tree
	 */
	void exitBoolType(@NotNull SMTLIB2Parser.BoolTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negateExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNegateExpr(@NotNull SMTLIB2Parser.NegateExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negateExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNegateExpr(@NotNull SMTLIB2Parser.NegateExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMTLIB2Parser#letexp}.
	 * @param ctx the parse tree
	 */
	void enterLetexp(@NotNull SMTLIB2Parser.LetexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMTLIB2Parser#letexp}.
	 * @param ctx the parse tree
	 */
	void exitLetexp(@NotNull SMTLIB2Parser.LetexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(@NotNull SMTLIB2Parser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(@NotNull SMTLIB2Parser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(@NotNull SMTLIB2Parser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(@NotNull SMTLIB2Parser.BoolExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funAppExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFunAppExpr(@NotNull SMTLIB2Parser.FunAppExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funAppExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFunAppExpr(@NotNull SMTLIB2Parser.FunAppExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMTLIB2Parser#properties}.
	 * @param ctx the parse tree
	 */
	void enterProperties(@NotNull SMTLIB2Parser.PropertiesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMTLIB2Parser#properties}.
	 * @param ctx the parse tree
	 */
	void exitProperties(@NotNull SMTLIB2Parser.PropertiesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(@NotNull SMTLIB2Parser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(@NotNull SMTLIB2Parser.IdExprContext ctx);
}