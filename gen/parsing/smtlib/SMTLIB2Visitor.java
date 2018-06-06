// Generated from /home/dr41k/git/SMTLib2C/src/parsing/smtlib/SMTLIB2.g4 by ANTLR 4.7
package parsing.smtlib;
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
	 * Visit a parse tree produced by {@link SMTLIB2Parser#scratch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScratch(SMTLIB2Parser.ScratchContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMTLIB2Parser#skolem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkolem(SMTLIB2Parser.SkolemContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMTLIB2Parser#check}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheck(SMTLIB2Parser.CheckContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMTLIB2Parser#declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclare(SMTLIB2Parser.DeclareContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMTLIB2Parser#letexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetexp(SMTLIB2Parser.LetexpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMTLIB2Parser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(SMTLIB2Parser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMTLIB2Parser#local}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocal(SMTLIB2Parser.LocalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link SMTLIB2Parser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntType(SMTLIB2Parser.IntTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link SMTLIB2Parser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolType(SMTLIB2Parser.BoolTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code realType}
	 * labeled alternative in {@link SMTLIB2Parser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealType(SMTLIB2Parser.RealTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMTLIB2Parser#inputs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInputs(SMTLIB2Parser.InputsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMTLIB2Parser#properties}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperties(SMTLIB2Parser.PropertiesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExpr(SMTLIB2Parser.IdExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntExpr(SMTLIB2Parser.IntExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code realExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealExpr(SMTLIB2Parser.RealExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpr(SMTLIB2Parser.BoolExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code castExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastExpr(SMTLIB2Parser.CastExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(SMTLIB2Parser.NotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negateExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegateExpr(SMTLIB2Parser.NegateExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExpr(SMTLIB2Parser.BinaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(SMTLIB2Parser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifThenElseExpr}
	 * labeled alternative in {@link SMTLIB2Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThenElseExpr(SMTLIB2Parser.IfThenElseExprContext ctx);
}