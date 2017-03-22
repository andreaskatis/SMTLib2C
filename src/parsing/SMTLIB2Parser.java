// Generated from /home/dr41k/git/SMTLib2C/src/parsing/SMTLIB2.g4 by ANTLR 4.5.3
package parsing;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SMTLIB2Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, REAL=29, BOOL=30, INT=31, ID=32, 
		WS=33, SL_COMMENT=34, ML_COMMENT=35, CS=36, ERROR=37;
	public static final int
		RULE_scratch = 0, RULE_skolem = 1, RULE_check = 2, RULE_declare = 3, RULE_letexp = 4, 
		RULE_body = 5, RULE_local = 6, RULE_type = 7, RULE_expr = 8;
	public static final String[] ruleNames = {
		"scratch", "skolem", "check", "declare", "letexp", "body", "local", "type", 
		"expr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "'assert'", "')'", "'declare-fun'", "'let'", "'Int'", "'Bool'", 
		"'Real'", "'to_real'", "'to_int'", "'not'", "'-'", "'*'", "'/'", "'div'", 
		"'mod'", "'+'", "'<'", "'<='", "'>'", "'>='", "'='", "'and'", "'or'", 
		"'xor'", "'=>'", "'->'", "'ite'", null, null, null, null, null, null, 
		null, "'(check-sat)'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, "REAL", "BOOL", "INT", "ID", "WS", "SL_COMMENT", 
		"ML_COMMENT", "CS", "ERROR"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SMTLIB2.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SMTLIB2Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ScratchContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(SMTLIB2Parser.EOF, 0); }
		public List<SkolemContext> skolem() {
			return getRuleContexts(SkolemContext.class);
		}
		public SkolemContext skolem(int i) {
			return getRuleContext(SkolemContext.class,i);
		}
		public List<CheckContext> check() {
			return getRuleContexts(CheckContext.class);
		}
		public CheckContext check(int i) {
			return getRuleContext(CheckContext.class,i);
		}
		public ScratchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scratch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).enterScratch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).exitScratch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor ) return ((SMTLIB2Visitor<? extends T>)visitor).visitScratch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScratchContext scratch() throws RecognitionException {
		ScratchContext _localctx = new ScratchContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_scratch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0 || _la==CS) {
				{
				setState(20);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(18);
					skolem();
					}
					break;
				case CS:
					{
					setState(19);
					check();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(24);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(25);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SkolemContext extends ParserRuleContext {
		public LetexpContext letexp() {
			return getRuleContext(LetexpContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<DeclareContext> declare() {
			return getRuleContexts(DeclareContext.class);
		}
		public DeclareContext declare(int i) {
			return getRuleContext(DeclareContext.class,i);
		}
		public SkolemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skolem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).enterSkolem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).exitSkolem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor ) return ((SMTLIB2Visitor<? extends T>)visitor).visitSkolem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SkolemContext skolem() throws RecognitionException {
		SkolemContext _localctx = new SkolemContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_skolem);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(28); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(27);
					declare();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(30); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
			setState(32);
			match(T__0);
			setState(33);
			match(T__1);
			setState(34);
			match(T__0);
			setState(37);
			switch (_input.LA(1)) {
			case T__4:
				{
				setState(35);
				letexp();
				}
				break;
			case T__0:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__14:
			case T__15:
			case T__16:
			case T__17:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case REAL:
			case BOOL:
			case INT:
			case ID:
				{
				setState(36);
				expr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(39);
			match(T__2);
			setState(40);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CheckContext extends ParserRuleContext {
		public TerminalNode CS() { return getToken(SMTLIB2Parser.CS, 0); }
		public CheckContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_check; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).enterCheck(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).exitCheck(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor ) return ((SMTLIB2Visitor<? extends T>)visitor).visitCheck(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CheckContext check() throws RecognitionException {
		CheckContext _localctx = new CheckContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_check);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(CS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclareContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SMTLIB2Parser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public DeclareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declare; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).enterDeclare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).exitDeclare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor ) return ((SMTLIB2Visitor<? extends T>)visitor).visitDeclare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclareContext declare() throws RecognitionException {
		DeclareContext _localctx = new DeclareContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declare);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(T__0);
			setState(45);
			match(T__3);
			setState(46);
			match(ID);
			setState(47);
			match(T__0);
			setState(48);
			match(T__2);
			setState(49);
			type();
			setState(50);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LetexpContext extends ParserRuleContext {
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public List<LocalContext> local() {
			return getRuleContexts(LocalContext.class);
		}
		public LocalContext local(int i) {
			return getRuleContext(LocalContext.class,i);
		}
		public LetexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).enterLetexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).exitLetexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor ) return ((SMTLIB2Visitor<? extends T>)visitor).visitLetexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetexpContext letexp() throws RecognitionException {
		LetexpContext _localctx = new LetexpContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_letexp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(T__4);
			setState(53);
			match(T__0);
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(54);
				local();
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(60);
			match(T__2);
			setState(61);
			match(T__0);
			setState(62);
			body();
			setState(63);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BodyContext extends ParserRuleContext {
		public LetexpContext letexp() {
			return getRuleContext(LetexpContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor ) return ((SMTLIB2Visitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_body);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			switch (_input.LA(1)) {
			case T__4:
				{
				setState(65);
				letexp();
				}
				break;
			case T__0:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__14:
			case T__15:
			case T__16:
			case T__17:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case REAL:
			case BOOL:
			case INT:
			case ID:
				{
				setState(66);
				expr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocalContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SMTLIB2Parser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LocalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_local; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).enterLocal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).exitLocal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor ) return ((SMTLIB2Visitor<? extends T>)visitor).visitLocal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalContext local() throws RecognitionException {
		LocalContext _localctx = new LocalContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_local);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(T__0);
			setState(70);
			match(ID);
			setState(71);
			expr();
			setState(72);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }

		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RealTypeContext extends TypeContext {
		public RealTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).enterRealType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).exitRealType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor ) return ((SMTLIB2Visitor<? extends T>)visitor).visitRealType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntTypeContext extends TypeContext {
		public IntTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).enterIntType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).exitIntType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor ) return ((SMTLIB2Visitor<? extends T>)visitor).visitIntType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolTypeContext extends TypeContext {
		public BoolTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).enterBoolType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).exitBoolType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor ) return ((SMTLIB2Visitor<? extends T>)visitor).visitBoolType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_type);
		try {
			setState(77);
			switch (_input.LA(1)) {
			case T__5:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				match(T__5);
				}
				break;
			case T__6:
				_localctx = new BoolTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				match(T__6);
				}
				break;
			case T__7:
				_localctx = new RealTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(76);
				match(T__7);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }

		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NegateExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NegateExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).enterNegateExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).exitNegateExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor ) return ((SMTLIB2Visitor<? extends T>)visitor).visitNegateExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntExprContext extends ExprContext {
		public TerminalNode INT() { return getToken(SMTLIB2Parser.INT, 0); }
		public IntExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).enterIntExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).exitIntExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor ) return ((SMTLIB2Visitor<? extends T>)visitor).visitIntExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).enterNotExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).exitNotExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor ) return ((SMTLIB2Visitor<? extends T>)visitor).visitNotExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CastExprContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public CastExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).enterCastExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).exitCastExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor ) return ((SMTLIB2Visitor<? extends T>)visitor).visitCastExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RealExprContext extends ExprContext {
		public TerminalNode REAL() { return getToken(SMTLIB2Parser.REAL, 0); }
		public RealExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).enterRealExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).exitRealExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor ) return ((SMTLIB2Visitor<? extends T>)visitor).visitRealExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfThenElseExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public IfThenElseExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).enterIfThenElseExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).exitIfThenElseExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor ) return ((SMTLIB2Visitor<? extends T>)visitor).visitIfThenElseExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BinaryExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).enterBinaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).exitBinaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor ) return ((SMTLIB2Visitor<? extends T>)visitor).visitBinaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolExprContext extends ExprContext {
		public TerminalNode BOOL() { return getToken(SMTLIB2Parser.BOOL, 0); }
		public BoolExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).enterBoolExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).exitBoolExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor ) return ((SMTLIB2Visitor<? extends T>)visitor).visitBoolExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).enterParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).exitParenExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor ) return ((SMTLIB2Visitor<? extends T>)visitor).visitParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(SMTLIB2Parser.ID, 0); }
		public IdExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).enterIdExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).exitIdExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor ) return ((SMTLIB2Visitor<? extends T>)visitor).visitIdExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expr);
		int _la;
		try {
			int _alt;
			setState(135);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new IdExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				match(ID);
				}
				break;
			case 2:
				_localctx = new IntExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				match(INT);
				}
				break;
			case 3:
				_localctx = new RealExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(81);
				match(REAL);
				}
				break;
			case 4:
				_localctx = new BoolExprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(82);
				match(BOOL);
				}
				break;
			case 5:
				_localctx = new CastExprContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(83);
				((CastExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__8 || _la==T__9) ) {
					((CastExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(84);
				expr();
				}
				break;
			case 6:
				_localctx = new NotExprContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(85);
				match(T__10);
				setState(86);
				expr();
				}
				break;
			case 7:
				_localctx = new NegateExprContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(87);
				match(T__11);
				setState(88);
				expr();
				}
				break;
			case 8:
				_localctx = new BinaryExprContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(89);
				((BinaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15))) != 0)) ) {
					((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(90);
				expr();
				setState(91);
				expr();
				}
				break;
			case 9:
				_localctx = new BinaryExprContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(93);
				((BinaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__11 || _la==T__16) ) {
					((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(94);
				expr();
				setState(96);
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(95);
						expr();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(98);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 10:
				_localctx = new BinaryExprContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(100);
				((BinaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21))) != 0)) ) {
					((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(101);
				expr();
				setState(102);
				expr();
				}
				break;
			case 11:
				_localctx = new BinaryExprContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(104);
				((BinaryExprContext)_localctx).op = match(T__22);
				setState(105);
				expr();
				setState(107);
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(106);
						expr();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(109);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 12:
				_localctx = new BinaryExprContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(111);
				((BinaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__23 || _la==T__24) ) {
					((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(112);
				expr();
				setState(114);
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(113);
						expr();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(116);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 13:
				_localctx = new BinaryExprContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(118);
				((BinaryExprContext)_localctx).op = match(T__25);
				setState(119);
				expr();
				setState(120);
				expr();
				}
				break;
			case 14:
				_localctx = new BinaryExprContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(122);
				((BinaryExprContext)_localctx).op = match(T__26);
				setState(123);
				expr();
				setState(124);
				expr();
				}
				break;
			case 15:
				_localctx = new ParenExprContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(126);
				match(T__0);
				setState(127);
				expr();
				setState(128);
				match(T__2);
				}
				break;
			case 16:
				_localctx = new IfThenElseExprContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(130);
				match(T__27);
				setState(131);
				expr();
				setState(132);
				expr();
				setState(133);
				expr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\'\u008c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2"+
		"\7\2\27\n\2\f\2\16\2\32\13\2\3\2\3\2\3\3\6\3\37\n\3\r\3\16\3 \3\3\3\3"+
		"\3\3\3\3\3\3\5\3(\n\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\6\3\6\3\6\7\6:\n\6\f\6\16\6=\13\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\5"+
		"\7F\n\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\5\tP\n\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\6\nc\n\n\r\n\16\nd\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\6\nn\n\n\r\n\16\no\3\n\3\n\3\n\6\nu\n\n\r\n\16"+
		"\nv\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\5\n\u008a\n\n\3\n\2\2\13\2\4\6\b\n\f\16\20\22\2\7\3\2\13\f\3\2\17\22"+
		"\4\2\16\16\23\23\3\2\24\30\3\2\32\33\u009c\2\30\3\2\2\2\4\36\3\2\2\2\6"+
		",\3\2\2\2\b.\3\2\2\2\n\66\3\2\2\2\fE\3\2\2\2\16G\3\2\2\2\20O\3\2\2\2\22"+
		"\u0089\3\2\2\2\24\27\5\4\3\2\25\27\5\6\4\2\26\24\3\2\2\2\26\25\3\2\2\2"+
		"\27\32\3\2\2\2\30\26\3\2\2\2\30\31\3\2\2\2\31\33\3\2\2\2\32\30\3\2\2\2"+
		"\33\34\7\2\2\3\34\3\3\2\2\2\35\37\5\b\5\2\36\35\3\2\2\2\37 \3\2\2\2 \36"+
		"\3\2\2\2 !\3\2\2\2!\"\3\2\2\2\"#\7\3\2\2#$\7\4\2\2$\'\7\3\2\2%(\5\n\6"+
		"\2&(\5\22\n\2\'%\3\2\2\2\'&\3\2\2\2()\3\2\2\2)*\7\5\2\2*+\7\5\2\2+\5\3"+
		"\2\2\2,-\7&\2\2-\7\3\2\2\2./\7\3\2\2/\60\7\6\2\2\60\61\7\"\2\2\61\62\7"+
		"\3\2\2\62\63\7\5\2\2\63\64\5\20\t\2\64\65\7\5\2\2\65\t\3\2\2\2\66\67\7"+
		"\7\2\2\67;\7\3\2\28:\5\16\b\298\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2"+
		"<>\3\2\2\2=;\3\2\2\2>?\7\5\2\2?@\7\3\2\2@A\5\f\7\2AB\7\5\2\2B\13\3\2\2"+
		"\2CF\5\n\6\2DF\5\22\n\2EC\3\2\2\2ED\3\2\2\2F\r\3\2\2\2GH\7\3\2\2HI\7\""+
		"\2\2IJ\5\22\n\2JK\7\5\2\2K\17\3\2\2\2LP\7\b\2\2MP\7\t\2\2NP\7\n\2\2OL"+
		"\3\2\2\2OM\3\2\2\2ON\3\2\2\2P\21\3\2\2\2Q\u008a\7\"\2\2R\u008a\7!\2\2"+
		"S\u008a\7\37\2\2T\u008a\7 \2\2UV\t\2\2\2V\u008a\5\22\n\2WX\7\r\2\2X\u008a"+
		"\5\22\n\2YZ\7\16\2\2Z\u008a\5\22\n\2[\\\t\3\2\2\\]\5\22\n\2]^\5\22\n\2"+
		"^\u008a\3\2\2\2_`\t\4\2\2`b\5\22\n\2ac\5\22\n\2ba\3\2\2\2cd\3\2\2\2db"+
		"\3\2\2\2de\3\2\2\2e\u008a\3\2\2\2fg\t\5\2\2gh\5\22\n\2hi\5\22\n\2i\u008a"+
		"\3\2\2\2jk\7\31\2\2km\5\22\n\2ln\5\22\n\2ml\3\2\2\2no\3\2\2\2om\3\2\2"+
		"\2op\3\2\2\2p\u008a\3\2\2\2qr\t\6\2\2rt\5\22\n\2su\5\22\n\2ts\3\2\2\2"+
		"uv\3\2\2\2vt\3\2\2\2vw\3\2\2\2w\u008a\3\2\2\2xy\7\34\2\2yz\5\22\n\2z{"+
		"\5\22\n\2{\u008a\3\2\2\2|}\7\35\2\2}~\5\22\n\2~\177\5\22\n\2\177\u008a"+
		"\3\2\2\2\u0080\u0081\7\3\2\2\u0081\u0082\5\22\n\2\u0082\u0083\7\5\2\2"+
		"\u0083\u008a\3\2\2\2\u0084\u0085\7\36\2\2\u0085\u0086\5\22\n\2\u0086\u0087"+
		"\5\22\n\2\u0087\u0088\5\22\n\2\u0088\u008a\3\2\2\2\u0089Q\3\2\2\2\u0089"+
		"R\3\2\2\2\u0089S\3\2\2\2\u0089T\3\2\2\2\u0089U\3\2\2\2\u0089W\3\2\2\2"+
		"\u0089Y\3\2\2\2\u0089[\3\2\2\2\u0089_\3\2\2\2\u0089f\3\2\2\2\u0089j\3"+
		"\2\2\2\u0089q\3\2\2\2\u0089x\3\2\2\2\u0089|\3\2\2\2\u0089\u0080\3\2\2"+
		"\2\u0089\u0084\3\2\2\2\u008a\23\3\2\2\2\r\26\30 \';EOdov\u0089";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}