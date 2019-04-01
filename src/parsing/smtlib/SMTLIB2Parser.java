package parsing.smtlib;// Generated from /home/dr41k/git/SMTLib2C/src/parsing/smtlib/SMTLIB2.g4 by ANTLR 4.4

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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).enterScratch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).exitScratch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor) return ((SMTLIB2Visitor<? extends T>)visitor).visitScratch(this);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).enterSkolem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).exitSkolem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor) return ((SMTLIB2Visitor<? extends T>)visitor).visitSkolem(this);
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
			} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
			setState(48); match(T__24);
			setState(49); match(T__12);
			setState(52);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(50); letexp();
				}
				break;
			case 2:
				{
				setState(51); expr();
				}
				break;
			}
			setState(54); match(T__5);
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
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).enterCheck(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).exitCheck(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor) return ((SMTLIB2Visitor<? extends T>)visitor).visitCheck(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CheckContext check() throws RecognitionException {
		CheckContext _localctx = new CheckContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_check);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56); match(CS);
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
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public DeclareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declare; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).enterDeclare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).exitDeclare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor) return ((SMTLIB2Visitor<? extends T>)visitor).visitDeclare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclareContext declare() throws RecognitionException {
		DeclareContext _localctx = new DeclareContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declare);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58); match(T__24);
			setState(59); match(T__3);
			setState(60); match(ID);
			setState(61); match(T__24);
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__28) | (1L << T__18) | (1L << T__16))) != 0)) {
				{
				{
				setState(62); type();
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(68); match(T__5);
			setState(69); type();
			setState(70); match(T__5);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).enterLetexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).exitLetexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor) return ((SMTLIB2Visitor<? extends T>)visitor).visitLetexp(this);
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
			setState(72); match(T__24);
			setState(73); match(T__7);
			setState(74); match(T__24);
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__24) {
				{
				{
				setState(75); local();
				}
				}
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(81); match(T__5);
			setState(82); body();
			setState(83); match(T__5);
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
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor) return ((SMTLIB2Visitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_body);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(85); letexp();
				}
				break;
			case 2:
				{
				setState(86); expr();
				}
				break;
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
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).enterLocal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).exitLocal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor) return ((SMTLIB2Visitor<? extends T>)visitor).visitLocal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalContext local() throws RecognitionException {
		LocalContext _localctx = new LocalContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_local);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89); match(T__24);
			setState(90); match(ID);
			setState(91); expr();
			setState(92); match(T__5);
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
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).enterRealType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).exitRealType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor) return ((SMTLIB2Visitor<? extends T>)visitor).visitRealType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntTypeContext extends TypeContext {
		public IntTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).enterIntType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).exitIntType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor) return ((SMTLIB2Visitor<? extends T>)visitor).visitIntType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolTypeContext extends TypeContext {
		public BoolTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).enterBoolType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).exitBoolType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor) return ((SMTLIB2Visitor<? extends T>)visitor).visitBoolType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_type);
		try {
			setState(97);
			switch (_input.LA(1)) {
			case T__16:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(94); match(T__16);
				}
				break;
			case T__28:
				_localctx = new BoolTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(95); match(T__28);
				}
				break;
			case T__18:
				_localctx = new RealTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(96); match(T__18);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).enterInputs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).exitInputs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor) return ((SMTLIB2Visitor<? extends T>)visitor).visitInputs(this);
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
			setState(99); match(T__17);
			setState(108);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(100); match(ID);
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__20) {
					{
					{
					setState(101); match(T__20);
					setState(102); match(ID);
					}
					}
					setState(107);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).enterProperties(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).exitProperties(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor) return ((SMTLIB2Visitor<? extends T>)visitor).visitProperties(this);
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
			setState(110); match(T__27);
			setState(119);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(111); match(ID);
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__20) {
					{
					{
					setState(112); match(T__20);
					setState(113); match(ID);
					}
					}
					setState(118);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).enterNegateExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).exitNegateExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor) return ((SMTLIB2Visitor<? extends T>)visitor).visitNegateExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntExprContext extends ExprContext {
		public TerminalNode INT() { return getToken(SMTLIB2Parser.INT, 0); }
		public IntExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).enterIntExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).exitIntExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor) return ((SMTLIB2Visitor<? extends T>)visitor).visitIntExpr(this);
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
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).enterNotExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).exitNotExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor) return ((SMTLIB2Visitor<? extends T>)visitor).visitNotExpr(this);
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
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).enterCastExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).exitCastExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor) return ((SMTLIB2Visitor<? extends T>)visitor).visitCastExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RealExprContext extends ExprContext {
		public TerminalNode REAL() { return getToken(SMTLIB2Parser.REAL, 0); }
		public RealExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).enterRealExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).exitRealExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor) return ((SMTLIB2Visitor<? extends T>)visitor).visitRealExpr(this);
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
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).enterIfThenElseExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).exitIfThenElseExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor) return ((SMTLIB2Visitor<? extends T>)visitor).visitIfThenElseExpr(this);
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
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).enterBinaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).exitBinaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor) return ((SMTLIB2Visitor<? extends T>)visitor).visitBinaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolExprContext extends ExprContext {
		public TerminalNode BOOL() { return getToken(SMTLIB2Parser.BOOL, 0); }
		public BoolExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).enterBoolExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).exitBoolExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor) return ((SMTLIB2Visitor<? extends T>)visitor).visitBoolExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunAppExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(SMTLIB2Parser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FunAppExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).enterFunAppExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).exitFunAppExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor) return ((SMTLIB2Visitor<? extends T>)visitor).visitFunAppExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(SMTLIB2Parser.ID, 0); }
		public IdExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).enterIdExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener) ((SMTLIB2Listener)listener).exitIdExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMTLIB2Visitor) return ((SMTLIB2Visitor<? extends T>)visitor).visitIdExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expr);
		int _la;
		try {
			setState(210);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new IdExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(121); match(ID);
				}
				break;
			case 2:
				_localctx = new IntExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(122); match(INT);
				}
				break;
			case 3:
				_localctx = new RealExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(123); match(REAL);
				}
				break;
			case 4:
				_localctx = new BoolExprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(124); match(BOOL);
				}
				break;
			case 5:
				_localctx = new CastExprContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(125); match(T__24);
				setState(126);
				((CastExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__29 || _la==T__21) ) {
					((CastExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(127); expr();
				setState(128); match(T__5);
				}
				break;
			case 6:
				_localctx = new BinaryExprContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(130); match(T__24);
				setState(131);
				((BinaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__30) | (1L << T__15) | (1L << T__6))) != 0)) ) {
					((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(132); expr();
				setState(133); expr();
				setState(134); match(T__5);
				}
				break;
			case 7:
				_localctx = new BinaryExprContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(136); match(T__24);
				setState(137);
				((BinaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__23) | (1L << T__2) | (1L << T__0))) != 0)) ) {
					((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(138); expr();
				setState(140); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(139); expr();
					}
					}
					setState(142); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__24) | (1L << REAL) | (1L << BOOL) | (1L << INT) | (1L << ID))) != 0) );
				setState(144); match(T__5);
				}
				break;
			case 8:
				_localctx = new BinaryExprContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(146); match(T__24);
				setState(147);
				((BinaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__25) | (1L << T__14) | (1L << T__13) | (1L << T__11))) != 0)) ) {
					((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(148); expr();
				setState(149); expr();
				setState(150); match(T__5);
				}
				break;
			case 9:
				_localctx = new BinaryExprContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(152); match(T__24);
				setState(153); ((BinaryExprContext)_localctx).op = match(T__4);
				setState(154); expr();
				setState(156); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(155); expr();
					}
					}
					setState(158); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__24) | (1L << REAL) | (1L << BOOL) | (1L << INT) | (1L << ID))) != 0) );
				setState(160); match(T__5);
				}
				break;
			case 10:
				_localctx = new BinaryExprContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(162); match(T__24);
				setState(163);
				((BinaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__10 || _la==T__9) ) {
					((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(164); expr();
				setState(166); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(165); expr();
					}
					}
					setState(168); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__24) | (1L << REAL) | (1L << BOOL) | (1L << INT) | (1L << ID))) != 0) );
				setState(170); match(T__5);
				}
				break;
			case 11:
				_localctx = new NotExprContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(172); match(T__24);
				setState(173); match(T__1);
				setState(174); expr();
				setState(175); match(T__5);
				}
				break;
			case 12:
				_localctx = new NegateExprContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(177); match(T__24);
				setState(178); match(T__0);
				setState(179); expr();
				setState(180); match(T__5);
				}
				break;
			case 13:
				_localctx = new BinaryExprContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(182); match(T__24);
				setState(183); ((BinaryExprContext)_localctx).op = match(T__8);
				setState(184); expr();
				setState(185); expr();
				setState(186); match(T__5);
				}
				break;
			case 14:
				_localctx = new BinaryExprContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(188); match(T__24);
				setState(189); ((BinaryExprContext)_localctx).op = match(T__19);
				setState(190); expr();
				setState(191); expr();
				setState(192); match(T__5);
				}
				break;
			case 15:
				_localctx = new IfThenElseExprContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(194); match(T__24);
				setState(195); match(T__22);
				setState(196); expr();
				setState(197); expr();
				setState(198); expr();
				setState(199); match(T__5);
				}
				break;
			case 16:
				_localctx = new FunAppExprContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(201); match(T__24);
				setState(202); match(ID);
				setState(204); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(203); expr();
					}
					}
					setState(206); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__24) | (1L << REAL) | (1L << BOOL) | (1L << INT) | (1L << ID))) != 0) );
				setState(208); match(T__5);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3)\u00d7\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\7\2\32\n\2\f\2\16\2\35\13\2\3\2\7\2 \n\2\f\2\16\2#\13"+
		"\2\3\2\3\2\7\2\'\n\2\f\2\16\2*\13\2\3\2\3\2\3\3\6\3/\n\3\r\3\16\3\60\3"+
		"\3\3\3\3\3\3\3\5\3\67\n\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\7\5B\n\5"+
		"\f\5\16\5E\13\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\7\6O\n\6\f\6\16\6R\13"+
		"\6\3\6\3\6\3\6\3\6\3\7\3\7\5\7Z\n\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\5"+
		"\td\n\t\3\n\3\n\3\n\3\n\7\nj\n\n\f\n\16\nm\13\n\5\no\n\n\3\13\3\13\3\13"+
		"\3\13\7\13u\n\13\f\13\16\13x\13\13\5\13z\n\13\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\6\f\u008f\n\f\r\f"+
		"\16\f\u0090\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\6\f\u009f"+
		"\n\f\r\f\16\f\u00a0\3\f\3\f\3\f\3\f\3\f\3\f\6\f\u00a9\n\f\r\f\16\f\u00aa"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\6\f"+
		"\u00cf\n\f\r\f\16\f\u00d0\3\f\3\f\5\f\u00d5\n\f\3\f\2\2\r\2\4\6\b\n\f"+
		"\16\20\22\24\26\2\7\4\2\4\4\f\f\5\2\3\3\22\22\33\33\5\2\n\n\37\37!!\5"+
		"\2\7\b\23\24\26\26\3\2\27\30\u00ed\2\33\3\2\2\2\4.\3\2\2\2\6:\3\2\2\2"+
		"\b<\3\2\2\2\nJ\3\2\2\2\fY\3\2\2\2\16[\3\2\2\2\20c\3\2\2\2\22e\3\2\2\2"+
		"\24p\3\2\2\2\26\u00d4\3\2\2\2\30\32\5\22\n\2\31\30\3\2\2\2\32\35\3\2\2"+
		"\2\33\31\3\2\2\2\33\34\3\2\2\2\34!\3\2\2\2\35\33\3\2\2\2\36 \5\24\13\2"+
		"\37\36\3\2\2\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"(\3\2\2\2#!\3\2\2\2$"+
		"\'\5\4\3\2%\'\5\6\4\2&$\3\2\2\2&%\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2"+
		"\2)+\3\2\2\2*(\3\2\2\2+,\7\2\2\3,\3\3\2\2\2-/\5\b\5\2.-\3\2\2\2/\60\3"+
		"\2\2\2\60.\3\2\2\2\60\61\3\2\2\2\61\62\3\2\2\2\62\63\7\t\2\2\63\66\7\25"+
		"\2\2\64\67\5\n\6\2\65\67\5\26\f\2\66\64\3\2\2\2\66\65\3\2\2\2\678\3\2"+
		"\2\289\7\34\2\29\5\3\2\2\2:;\7(\2\2;\7\3\2\2\2<=\7\t\2\2=>\7\36\2\2>?"+
		"\7%\2\2?C\7\t\2\2@B\5\20\t\2A@\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2D"+
		"F\3\2\2\2EC\3\2\2\2FG\7\34\2\2GH\5\20\t\2HI\7\34\2\2I\t\3\2\2\2JK\7\t"+
		"\2\2KL\7\32\2\2LP\7\t\2\2MO\5\16\b\2NM\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3"+
		"\2\2\2QS\3\2\2\2RP\3\2\2\2ST\7\34\2\2TU\5\f\7\2UV\7\34\2\2V\13\3\2\2\2"+
		"WZ\5\n\6\2XZ\5\26\f\2YW\3\2\2\2YX\3\2\2\2Z\r\3\2\2\2[\\\7\t\2\2\\]\7%"+
		"\2\2]^\5\26\f\2^_\7\34\2\2_\17\3\2\2\2`d\7\21\2\2ad\7\5\2\2bd\7\17\2\2"+
		"c`\3\2\2\2ca\3\2\2\2cb\3\2\2\2d\21\3\2\2\2en\7\20\2\2fk\7%\2\2gh\7\r\2"+
		"\2hj\7%\2\2ig\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2lo\3\2\2\2mk\3\2\2"+
		"\2nf\3\2\2\2no\3\2\2\2o\23\3\2\2\2py\7\6\2\2qv\7%\2\2rs\7\r\2\2su\7%\2"+
		"\2tr\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2wz\3\2\2\2xv\3\2\2\2yq\3\2\2"+
		"\2yz\3\2\2\2z\25\3\2\2\2{\u00d5\7%\2\2|\u00d5\7$\2\2}\u00d5\7\"\2\2~\u00d5"+
		"\7#\2\2\177\u0080\7\t\2\2\u0080\u0081\t\2\2\2\u0081\u0082\5\26\f\2\u0082"+
		"\u0083\7\34\2\2\u0083\u00d5\3\2\2\2\u0084\u0085\7\t\2\2\u0085\u0086\t"+
		"\3\2\2\u0086\u0087\5\26\f\2\u0087\u0088\5\26\f\2\u0088\u0089\7\34\2\2"+
		"\u0089\u00d5\3\2\2\2\u008a\u008b\7\t\2\2\u008b\u008c\t\4\2\2\u008c\u008e"+
		"\5\26\f\2\u008d\u008f\5\26\f\2\u008e\u008d\3\2\2\2\u008f\u0090\3\2\2\2"+
		"\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093"+
		"\7\34\2\2\u0093\u00d5\3\2\2\2\u0094\u0095\7\t\2\2\u0095\u0096\t\5\2\2"+
		"\u0096\u0097\5\26\f\2\u0097\u0098\5\26\f\2\u0098\u0099\7\34\2\2\u0099"+
		"\u00d5\3\2\2\2\u009a\u009b\7\t\2\2\u009b\u009c\7\35\2\2\u009c\u009e\5"+
		"\26\f\2\u009d\u009f\5\26\f\2\u009e\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0"+
		"\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\7\34"+
		"\2\2\u00a3\u00d5\3\2\2\2\u00a4\u00a5\7\t\2\2\u00a5\u00a6\t\6\2\2\u00a6"+
		"\u00a8\5\26\f\2\u00a7\u00a9\5\26\f\2\u00a8\u00a7\3\2\2\2\u00a9\u00aa\3"+
		"\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac"+
		"\u00ad\7\34\2\2\u00ad\u00d5\3\2\2\2\u00ae\u00af\7\t\2\2\u00af\u00b0\7"+
		" \2\2\u00b0\u00b1\5\26\f\2\u00b1\u00b2\7\34\2\2\u00b2\u00d5\3\2\2\2\u00b3"+
		"\u00b4\7\t\2\2\u00b4\u00b5\7!\2\2\u00b5\u00b6\5\26\f\2\u00b6\u00b7\7\34"+
		"\2\2\u00b7\u00d5\3\2\2\2\u00b8\u00b9\7\t\2\2\u00b9\u00ba\7\31\2\2\u00ba"+
		"\u00bb\5\26\f\2\u00bb\u00bc\5\26\f\2\u00bc\u00bd\7\34\2\2\u00bd\u00d5"+
		"\3\2\2\2\u00be\u00bf\7\t\2\2\u00bf\u00c0\7\16\2\2\u00c0\u00c1\5\26\f\2"+
		"\u00c1\u00c2\5\26\f\2\u00c2\u00c3\7\34\2\2\u00c3\u00d5\3\2\2\2\u00c4\u00c5"+
		"\7\t\2\2\u00c5\u00c6\7\13\2\2\u00c6\u00c7\5\26\f\2\u00c7\u00c8\5\26\f"+
		"\2\u00c8\u00c9\5\26\f\2\u00c9\u00ca\7\34\2\2\u00ca\u00d5\3\2\2\2\u00cb"+
		"\u00cc\7\t\2\2\u00cc\u00ce\7%\2\2\u00cd\u00cf\5\26\f\2\u00ce\u00cd\3\2"+
		"\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1"+
		"\u00d2\3\2\2\2\u00d2\u00d3\7\34\2\2\u00d3\u00d5\3\2\2\2\u00d4{\3\2\2\2"+
		"\u00d4|\3\2\2\2\u00d4}\3\2\2\2\u00d4~\3\2\2\2\u00d4\177\3\2\2\2\u00d4"+
		"\u0084\3\2\2\2\u00d4\u008a\3\2\2\2\u00d4\u0094\3\2\2\2\u00d4\u009a\3\2"+
		"\2\2\u00d4\u00a4\3\2\2\2\u00d4\u00ae\3\2\2\2\u00d4\u00b3\3\2\2\2\u00d4"+
		"\u00b8\3\2\2\2\u00d4\u00be\3\2\2\2\u00d4\u00c4\3\2\2\2\u00d4\u00cb\3\2"+
		"\2\2\u00d5\27\3\2\2\2\25\33!&(\60\66CPYcknvy\u0090\u00a0\u00aa\u00d0\u00d4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}