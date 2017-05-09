// Generated from SMTLIB2.g4 by ANTLR 4.4
package parsing;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SMTLIB2Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__30=1, T__29=2, T__28=3, T__27=4, T__26=5, T__25=6, T__24=7, T__23=8, 
		T__22=9, T__21=10, T__20=11, T__19=12, T__18=13, T__17=14, T__16=15, T__15=16, 
		T__14=17, T__13=18, T__12=19, T__11=20, T__10=21, T__9=22, T__8=23, T__7=24, 
		T__6=25, T__5=26, T__4=27, T__3=28, T__2=29, T__1=30, T__0=31, REAL=32, 
		BOOL=33, INT=34, ID=35, WS=36, SL_COMMENT=37, CS=38, ERROR=39;
	public static final String[] tokenNames = {
		"<INVALID>", "'/'", "'to_real'", "'Bool'", "';-- PROPERTIES: '", "'='", 
		"'<='", "'('", "'*'", "'ite'", "'to_int'", "','", "'->'", "'Real'", "';-- INPUTS: '", 
		"'Int'", "'mod'", "'>='", "'<'", "'assert'", "'>'", "'xor'", "'or'", "'=>'", 
		"'let'", "'div'", "')'", "'and'", "'declare-fun'", "'+'", "'not'", "'-'", 
		"REAL", "BOOL", "INT", "ID", "WS", "SL_COMMENT", "'(check-sat)'", "ERROR"
	};
	public static final int
		RULE_scratch = 0, RULE_skolem = 1, RULE_check = 2, RULE_declare = 3, RULE_letexp = 4, 
		RULE_body = 5, RULE_local = 6, RULE_type = 7, RULE_inputs = 8, RULE_properties = 9, 
		RULE_expr = 10;
	public static final String[] ruleNames = {
		"scratch", "skolem", "check", "declare", "letexp", "body", "local", "type", 
		"inputs", "properties", "expr"
	};

	@Override
	public String getGrammarFileName() { return "SMTLIB2.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

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
		public CheckContext check(int i) {
			return getRuleContext(CheckContext.class,i);
		}
		public PropertiesContext properties(int i) {
			return getRuleContext(PropertiesContext.class,i);
		}
		public TerminalNode EOF() { return getToken(SMTLIB2Parser.EOF, 0); }
		public SkolemContext skolem(int i) {
			return getRuleContext(SkolemContext.class,i);
		}
		public InputsContext inputs(int i) {
			return getRuleContext(InputsContext.class,i);
		}
		public List<PropertiesContext> properties() {
			return getRuleContexts(PropertiesContext.class);
		}
		public List<SkolemContext> skolem() {
			return getRuleContexts(SkolemContext.class);
		}
		public List<CheckContext> check() {
			return getRuleContexts(CheckContext.class);
		}
		public List<InputsContext> inputs() {
			return getRuleContexts(InputsContext.class);
		}
		public ScratchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scratch; }
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
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__17) {
				{
				{
				setState(22); inputs();
				}
				}
				setState(27);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__27) {
				{
				{
				setState(28); properties();
				}
				}
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__24 || _la==CS) {
				{
				setState(36);
				switch (_input.LA(1)) {
				case T__24:
					{
					setState(34); skolem();
					}
					break;
				case CS:
					{
					setState(35); check();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(41); match(EOF);
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
			setState(44); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(43); declare();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(46); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(48); match(T__24);
			setState(49); match(T__12);
			setState(50); match(T__24);
			setState(53);
			switch (_input.LA(1)) {
			case T__7:
				{
				setState(51); letexp();
				}
				break;
			case T__30:
			case T__29:
			case T__26:
			case T__25:
			case T__24:
			case T__23:
			case T__22:
			case T__21:
			case T__19:
			case T__15:
			case T__14:
			case T__13:
			case T__11:
			case T__10:
			case T__9:
			case T__8:
			case T__6:
			case T__4:
			case T__2:
			case T__1:
			case T__0:
			case REAL:
			case BOOL:
			case INT:
			case ID:
				{
				setState(52); expr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(55); match(T__5);
			setState(56); match(T__5);
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
			setState(58); match(CS);
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
			setState(60); match(T__24);
			setState(61); match(T__3);
			setState(62); match(ID);
			setState(63); match(T__24);
			setState(64); match(T__5);
			setState(65); type();
			setState(66); match(T__5);
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
		public LocalContext local(int i) {
			return getRuleContext(LocalContext.class,i);
		}
		public List<LocalContext> local() {
			return getRuleContexts(LocalContext.class);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public LetexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letexp; }
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
			setState(68); match(T__7);
			setState(69); match(T__24);
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__24) {
				{
				{
				setState(70); local();
				}
				}
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(76); match(T__5);
			setState(77); match(T__24);
			setState(78); body();
			setState(79); match(T__5);
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
			setState(83);
			switch (_input.LA(1)) {
			case T__7:
				{
				setState(81); letexp();
				}
				break;
			case T__30:
			case T__29:
			case T__26:
			case T__25:
			case T__24:
			case T__23:
			case T__22:
			case T__21:
			case T__19:
			case T__15:
			case T__14:
			case T__13:
			case T__11:
			case T__10:
			case T__9:
			case T__8:
			case T__6:
			case T__4:
			case T__2:
			case T__1:
			case T__0:
			case REAL:
			case BOOL:
			case INT:
			case ID:
				{
				setState(82); expr();
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
			setState(85); match(T__24);
			setState(86); match(ID);
			setState(87); expr();
			setState(88); match(T__5);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor ) return ((SMTLIB2Visitor<? extends T>)visitor).visitRealType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntTypeContext extends TypeContext {
		public IntTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor ) return ((SMTLIB2Visitor<? extends T>)visitor).visitIntType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolTypeContext extends TypeContext {
		public BoolTypeContext(TypeContext ctx) { copyFrom(ctx); }
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
			setState(93);
			switch (_input.LA(1)) {
			case T__16:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(90); match(T__16);
				}
				break;
			case T__28:
				_localctx = new BoolTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(91); match(T__28);
				}
				break;
			case T__18:
				_localctx = new RealTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(92); match(T__18);
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

	public static class InputsContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(SMTLIB2Parser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SMTLIB2Parser.ID, i);
		}
		public InputsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inputs; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor ) return ((SMTLIB2Visitor<? extends T>)visitor).visitInputs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputsContext inputs() throws RecognitionException {
		InputsContext _localctx = new InputsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_inputs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95); match(T__17);
			setState(104);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(96); match(ID);
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__20) {
					{
					{
					setState(97); match(T__20);
					setState(98); match(ID);
					}
					}
					setState(103);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
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

	public static class PropertiesContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(SMTLIB2Parser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SMTLIB2Parser.ID, i);
		}
		public PropertiesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_properties; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor ) return ((SMTLIB2Visitor<? extends T>)visitor).visitProperties(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertiesContext properties() throws RecognitionException {
		PropertiesContext _localctx = new PropertiesContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_properties);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106); match(T__27);
			setState(115);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(107); match(ID);
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__20) {
					{
					{
					setState(108); match(T__20);
					setState(109); match(ID);
					}
					}
					setState(114);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor ) return ((SMTLIB2Visitor<? extends T>)visitor).visitNegateExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntExprContext extends ExprContext {
		public TerminalNode INT() { return getToken(SMTLIB2Parser.INT, 0); }
		public IntExprContext(ExprContext ctx) { copyFrom(ctx); }
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor ) return ((SMTLIB2Visitor<? extends T>)visitor).visitCastExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RealExprContext extends ExprContext {
		public TerminalNode REAL() { return getToken(SMTLIB2Parser.REAL, 0); }
		public RealExprContext(ExprContext ctx) { copyFrom(ctx); }
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor ) return ((SMTLIB2Visitor<? extends T>)visitor).visitBinaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolExprContext extends ExprContext {
		public TerminalNode BOOL() { return getToken(SMTLIB2Parser.BOOL, 0); }
		public BoolExprContext(ExprContext ctx) { copyFrom(ctx); }
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor ) return ((SMTLIB2Visitor<? extends T>)visitor).visitParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(SMTLIB2Parser.ID, 0); }
		public IdExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor ) return ((SMTLIB2Visitor<? extends T>)visitor).visitIdExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expr);
		int _la;
		try {
			int _alt;
			setState(173);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				_localctx = new IdExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(117); match(ID);
				}
				break;
			case 2:
				_localctx = new IntExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(118); match(INT);
				}
				break;
			case 3:
				_localctx = new RealExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(119); match(REAL);
				}
				break;
			case 4:
				_localctx = new BoolExprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(120); match(BOOL);
				}
				break;
			case 5:
				_localctx = new CastExprContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(121);
				((CastExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__29 || _la==T__21) ) {
					((CastExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(122); expr();
				}
				break;
			case 6:
				_localctx = new NotExprContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(123); match(T__1);
				setState(124); expr();
				}
				break;
			case 7:
				_localctx = new NegateExprContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(125); match(T__0);
				setState(126); expr();
				}
				break;
			case 8:
				_localctx = new BinaryExprContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(127);
				((BinaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__30) | (1L << T__23) | (1L << T__15) | (1L << T__6))) != 0)) ) {
					((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(128); expr();
				setState(129); expr();
				}
				break;
			case 9:
				_localctx = new BinaryExprContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(131);
				((BinaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__2 || _la==T__0) ) {
					((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(132); expr();
				setState(134); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(133); expr();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(136); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 10:
				_localctx = new BinaryExprContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(138);
				((BinaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__25) | (1L << T__14) | (1L << T__13) | (1L << T__11))) != 0)) ) {
					((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(139); expr();
				setState(140); expr();
				}
				break;
			case 11:
				_localctx = new BinaryExprContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(142); ((BinaryExprContext)_localctx).op = match(T__4);
				setState(143); expr();
				setState(145); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(144); expr();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(147); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 12:
				_localctx = new BinaryExprContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(149);
				((BinaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__10 || _la==T__9) ) {
					((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(150); expr();
				setState(152); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(151); expr();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(154); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 13:
				_localctx = new BinaryExprContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(156); ((BinaryExprContext)_localctx).op = match(T__8);
				setState(157); expr();
				setState(158); expr();
				}
				break;
			case 14:
				_localctx = new BinaryExprContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(160); ((BinaryExprContext)_localctx).op = match(T__19);
				setState(161); expr();
				setState(162); expr();
				}
				break;
			case 15:
				_localctx = new ParenExprContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(164); match(T__24);
				setState(165); expr();
				setState(166); match(T__5);
				}
				break;
			case 16:
				_localctx = new IfThenElseExprContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(168); match(T__22);
				setState(169); expr();
				setState(170); expr();
				setState(171); expr();
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3)\u00b2\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\7\2\32\n\2\f\2\16\2\35\13\2\3\2\7\2 \n\2\f\2\16\2#\13"+
		"\2\3\2\3\2\7\2\'\n\2\f\2\16\2*\13\2\3\2\3\2\3\3\6\3/\n\3\r\3\16\3\60\3"+
		"\3\3\3\3\3\3\3\3\3\5\38\n\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\7\6J\n\6\f\6\16\6M\13\6\3\6\3\6\3\6\3\6\3\6\3\7"+
		"\3\7\5\7V\n\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\5\t`\n\t\3\n\3\n\3\n\3\n"+
		"\7\nf\n\n\f\n\16\ni\13\n\5\nk\n\n\3\13\3\13\3\13\3\13\7\13q\n\13\f\13"+
		"\16\13t\13\13\5\13v\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\6\f\u0089\n\f\r\f\16\f\u008a\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\6\f\u0094\n\f\r\f\16\f\u0095\3\f\3\f\3\f\6\f\u009b\n\f\r\f"+
		"\16\f\u009c\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\5\f\u00b0\n\f\3\f\2\2\r\2\4\6\b\n\f\16\20\22\24\26\2\7\4\2"+
		"\4\4\f\f\6\2\3\3\n\n\22\22\33\33\4\2\37\37!!\5\2\7\b\23\24\26\26\3\2\27"+
		"\30\u00c6\2\33\3\2\2\2\4.\3\2\2\2\6<\3\2\2\2\b>\3\2\2\2\nF\3\2\2\2\fU"+
		"\3\2\2\2\16W\3\2\2\2\20_\3\2\2\2\22a\3\2\2\2\24l\3\2\2\2\26\u00af\3\2"+
		"\2\2\30\32\5\22\n\2\31\30\3\2\2\2\32\35\3\2\2\2\33\31\3\2\2\2\33\34\3"+
		"\2\2\2\34!\3\2\2\2\35\33\3\2\2\2\36 \5\24\13\2\37\36\3\2\2\2 #\3\2\2\2"+
		"!\37\3\2\2\2!\"\3\2\2\2\"(\3\2\2\2#!\3\2\2\2$\'\5\4\3\2%\'\5\6\4\2&$\3"+
		"\2\2\2&%\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2)+\3\2\2\2*(\3\2\2\2+,"+
		"\7\2\2\3,\3\3\2\2\2-/\5\b\5\2.-\3\2\2\2/\60\3\2\2\2\60.\3\2\2\2\60\61"+
		"\3\2\2\2\61\62\3\2\2\2\62\63\7\t\2\2\63\64\7\25\2\2\64\67\7\t\2\2\658"+
		"\5\n\6\2\668\5\26\f\2\67\65\3\2\2\2\67\66\3\2\2\289\3\2\2\29:\7\34\2\2"+
		":;\7\34\2\2;\5\3\2\2\2<=\7(\2\2=\7\3\2\2\2>?\7\t\2\2?@\7\36\2\2@A\7%\2"+
		"\2AB\7\t\2\2BC\7\34\2\2CD\5\20\t\2DE\7\34\2\2E\t\3\2\2\2FG\7\32\2\2GK"+
		"\7\t\2\2HJ\5\16\b\2IH\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2LN\3\2\2\2"+
		"MK\3\2\2\2NO\7\34\2\2OP\7\t\2\2PQ\5\f\7\2QR\7\34\2\2R\13\3\2\2\2SV\5\n"+
		"\6\2TV\5\26\f\2US\3\2\2\2UT\3\2\2\2V\r\3\2\2\2WX\7\t\2\2XY\7%\2\2YZ\5"+
		"\26\f\2Z[\7\34\2\2[\17\3\2\2\2\\`\7\21\2\2]`\7\5\2\2^`\7\17\2\2_\\\3\2"+
		"\2\2_]\3\2\2\2_^\3\2\2\2`\21\3\2\2\2aj\7\20\2\2bg\7%\2\2cd\7\r\2\2df\7"+
		"%\2\2ec\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2\2\2hk\3\2\2\2ig\3\2\2\2jb\3"+
		"\2\2\2jk\3\2\2\2k\23\3\2\2\2lu\7\6\2\2mr\7%\2\2no\7\r\2\2oq\7%\2\2pn\3"+
		"\2\2\2qt\3\2\2\2rp\3\2\2\2rs\3\2\2\2sv\3\2\2\2tr\3\2\2\2um\3\2\2\2uv\3"+
		"\2\2\2v\25\3\2\2\2w\u00b0\7%\2\2x\u00b0\7$\2\2y\u00b0\7\"\2\2z\u00b0\7"+
		"#\2\2{|\t\2\2\2|\u00b0\5\26\f\2}~\7 \2\2~\u00b0\5\26\f\2\177\u0080\7!"+
		"\2\2\u0080\u00b0\5\26\f\2\u0081\u0082\t\3\2\2\u0082\u0083\5\26\f\2\u0083"+
		"\u0084\5\26\f\2\u0084\u00b0\3\2\2\2\u0085\u0086\t\4\2\2\u0086\u0088\5"+
		"\26\f\2\u0087\u0089\5\26\f\2\u0088\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a"+
		"\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u00b0\3\2\2\2\u008c\u008d\t\5"+
		"\2\2\u008d\u008e\5\26\f\2\u008e\u008f\5\26\f\2\u008f\u00b0\3\2\2\2\u0090"+
		"\u0091\7\35\2\2\u0091\u0093\5\26\f\2\u0092\u0094\5\26\f\2\u0093\u0092"+
		"\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096"+
		"\u00b0\3\2\2\2\u0097\u0098\t\6\2\2\u0098\u009a\5\26\f\2\u0099\u009b\5"+
		"\26\f\2\u009a\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009a\3\2\2\2\u009c"+
		"\u009d\3\2\2\2\u009d\u00b0\3\2\2\2\u009e\u009f\7\31\2\2\u009f\u00a0\5"+
		"\26\f\2\u00a0\u00a1\5\26\f\2\u00a1\u00b0\3\2\2\2\u00a2\u00a3\7\16\2\2"+
		"\u00a3\u00a4\5\26\f\2\u00a4\u00a5\5\26\f\2\u00a5\u00b0\3\2\2\2\u00a6\u00a7"+
		"\7\t\2\2\u00a7\u00a8\5\26\f\2\u00a8\u00a9\7\34\2\2\u00a9\u00b0\3\2\2\2"+
		"\u00aa\u00ab\7\13\2\2\u00ab\u00ac\5\26\f\2\u00ac\u00ad\5\26\f\2\u00ad"+
		"\u00ae\5\26\f\2\u00ae\u00b0\3\2\2\2\u00afw\3\2\2\2\u00afx\3\2\2\2\u00af"+
		"y\3\2\2\2\u00afz\3\2\2\2\u00af{\3\2\2\2\u00af}\3\2\2\2\u00af\177\3\2\2"+
		"\2\u00af\u0081\3\2\2\2\u00af\u0085\3\2\2\2\u00af\u008c\3\2\2\2\u00af\u0090"+
		"\3\2\2\2\u00af\u0097\3\2\2\2\u00af\u009e\3\2\2\2\u00af\u00a2\3\2\2\2\u00af"+
		"\u00a6\3\2\2\2\u00af\u00aa\3\2\2\2\u00b0\27\3\2\2\2\23\33!&(\60\67KU_"+
		"gjru\u008a\u0095\u009c\u00af";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}