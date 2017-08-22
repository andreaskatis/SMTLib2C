// Generated from SMTLIB2.g4 by ANTLR 4.4
package parsing.smtlib;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SMTLIB2Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SMTLIB2Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code realType}
	 * labeled alternative in {@link SMTLIB2Parser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealType(@NotNull SMTLIB2Parser.RealTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntExpr(@NotNull SMTLIB2Parser.IntExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMTLIB2Parser#declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclare(@NotNull SMTLIB2Parser.DeclareContext ctx);
	/**
	 * Visit a parse tree produced by the {@code castExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastExpr(@NotNull SMTLIB2Parser.CastExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMTLIB2Parser#inputs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInputs(@NotNull SMTLIB2Parser.InputsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link SMTLIB2Parser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntType(@NotNull SMTLIB2Parser.IntTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code realExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealExpr(@NotNull SMTLIB2Parser.RealExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMTLIB2Parser#skolem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkolem(@NotNull SMTLIB2Parser.SkolemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifThenElseExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThenElseExpr(@NotNull SMTLIB2Parser.IfThenElseExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExpr(@NotNull SMTLIB2Parser.BinaryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMTLIB2Parser#scratch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScratch(@NotNull SMTLIB2Parser.ScratchContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMTLIB2Parser#check}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheck(@NotNull SMTLIB2Parser.CheckContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMTLIB2Parser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(@NotNull SMTLIB2Parser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMTLIB2Parser#local}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocal(@NotNull SMTLIB2Parser.LocalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link SMTLIB2Parser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolType(@NotNull SMTLIB2Parser.BoolTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(@NotNull SMTLIB2Parser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negateExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegateExpr(@NotNull SMTLIB2Parser.NegateExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMTLIB2Parser#letexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetexp(@NotNull SMTLIB2Parser.LetexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(@NotNull SMTLIB2Parser.NotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpr(@NotNull SMTLIB2Parser.BoolExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMTLIB2Parser#properties}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperties(@NotNull SMTLIB2Parser.PropertiesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExpr(@NotNull SMTLIB2Parser.IdExprContext ctx);
}