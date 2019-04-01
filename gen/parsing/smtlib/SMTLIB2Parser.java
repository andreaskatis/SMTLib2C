// Generated from /home/dr41k/git/SMTLib2C/src/parsing/smtlib/SMTLIB2.g4 by ANTLR 4.7
package parsing.smtlib;
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
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		REAL=32, BOOL=33, INT=34, ID=35, WS=36, SL_COMMENT=37, CS=38, ERROR=39;
	public static final int
		RULE_scratch = 0, RULE_skolem = 1, RULE_check = 2, RULE_declare = 3, RULE_letexp = 4, 
		RULE_body = 5, RULE_local = 6, RULE_type = 7, RULE_inputs = 8, RULE_properties = 9, 
		RULE_expr = 10;
	public static final String[] ruleNames = {
		"scratch", "skolem", "check", "declare", "letexp", "body", "local", "type", 
		"inputs", "properties", "expr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "'assert'", "')'", "'declare-fun'", "'let'", "'Int'", "'Bool'", 
		"'Real'", "';-- INPUTS: '", "','", "';-- PROPERTIES: '", "'to_real'", 
		"'to_int'", "'not'", "'-'", "'/'", "'div'", "'mod'", "'*'", "'+'", "'<'", 
		"'<='", "'>'", "'>='", "'='", "'and'", "'or'", "'xor'", "'=>'", "'->'", 
		"'ite'", null, null, null, null, null, null, "'(check-sat)'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, "REAL", "BOOL", "INT", 
		"ID", "WS", "SL_COMMENT", "CS", "ERROR"
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
		public List<InputsContext> inputs() {
			return getRuleContexts(InputsContext.class);
		}
		public InputsContext inputs(int i) {
			return getRuleContext(InputsContext.class,i);
		}
		public List<PropertiesContext> properties() {
			return getRuleContexts(PropertiesContext.class);
		}
		public PropertiesContext properties(int i) {
			return getRuleContext(PropertiesContext.class,i);
		}
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
			while (_la==T__8) {
				{
				{
				setState(22);
				inputs();
				}
				}
				setState(27);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(28);
				properties();
				}
				}
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0 || _la==CS) {
				{
				setState(36);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(34);
					skolem();
					}
					break;
				case CS:
					{
					setState(35);
					check();
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
			setState(41);
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
					setState(43);
					declare();
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
			setState(48);
			match(T__0);
			setState(49);
			match(T__1);
			setState(50);
			match(T__0);
			setState(53);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				{
				setState(51);
				letexp();
				}
				break;
			case T__0:
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
			case T__28:
			case T__29:
			case T__30:
			case REAL:
			case BOOL:
			case INT:
			case ID:
				{
				setState(52);
				expr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(55);
			match(T__2);
			setState(56);
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
	}

	public final CheckContext check() throws RecognitionException {
		CheckContext _localctx = new CheckContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_check);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
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
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
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
	}

	public final DeclareContext declare() throws RecognitionException {
		DeclareContext _localctx = new DeclareContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declare);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(T__0);
			setState(61);
			match(T__3);
			setState(62);
			match(ID);
			setState(63);
			match(T__0);
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7))) != 0)) {
				{
				{
				setState(64);
				type();
				}
				}
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(70);
			match(T__2);
			setState(71);
			type();
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
	}

	public final LetexpContext letexp() throws RecognitionException {
		LetexpContext _localctx = new LetexpContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_letexp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(T__4);
			setState(75);
			match(T__0);
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(76);
				local();
				}
				}
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(82);
			match(T__2);
			setState(83);
			match(T__0);
			setState(84);
			body();
			setState(85);
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
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_body);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				{
				setState(87);
				letexp();
				}
				break;
			case T__0:
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
			case T__28:
			case T__29:
			case T__30:
			case REAL:
			case BOOL:
			case INT:
			case ID:
				{
				setState(88);
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
	}

	public final LocalContext local() throws RecognitionException {
		LocalContext _localctx = new LocalContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_local);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(T__0);
			setState(92);
			match(ID);
			setState(93);
			expr();
			setState(94);
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
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_type);
		try {
			setState(99);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				match(T__5);
				}
				break;
			case T__6:
				_localctx = new BoolTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
				match(T__6);
				}
				break;
			case T__7:
				_localctx = new RealTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(98);
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
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).enterInputs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).exitInputs(this);
		}
	}

	public final InputsContext inputs() throws RecognitionException {
		InputsContext _localctx = new InputsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_inputs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(T__8);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(102);
				match(ID);
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(103);
					match(T__9);
					setState(104);
					match(ID);
					}
					}
					setState(109);
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
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).enterProperties(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).exitProperties(this);
		}
	}

	public final PropertiesContext properties() throws RecognitionException {
		PropertiesContext _localctx = new PropertiesContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_properties);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(T__10);
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(113);
				match(ID);
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(114);
					match(T__9);
					setState(115);
					match(ID);
					}
					}
					setState(120);
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
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).enterNegateExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMTLIB2Listener ) ((SMTLIB2Listener)listener).exitNegateExpr(this);
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
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expr);
		int _la;
		try {
			int _alt;
			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				_localctx = new IdExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(123);
				match(ID);
				}
				break;
			case 2:
				_localctx = new IntExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				match(INT);
				}
				break;
			case 3:
				_localctx = new RealExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(125);
				match(REAL);
				}
				break;
			case 4:
				_localctx = new BoolExprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(126);
				match(BOOL);
				}
				break;
			case 5:
				_localctx = new CastExprContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(127);
				((CastExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__11 || _la==T__12) ) {
					((CastExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(128);
				expr();
				}
				break;
			case 6:
				_localctx = new NotExprContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(129);
				match(T__13);
				setState(130);
				expr();
				}
				break;
			case 7:
				_localctx = new NegateExprContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(131);
				match(T__14);
				setState(132);
				expr();
				}
				break;
			case 8:
				_localctx = new BinaryExprContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(133);
				((BinaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__16) | (1L << T__17))) != 0)) ) {
					((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(134);
				expr();
				setState(135);
				expr();
				}
				break;
			case 9:
				_localctx = new BinaryExprContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(137);
				((BinaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__18) | (1L << T__19))) != 0)) ) {
					((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(138);
				expr();
				setState(140); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(139);
						expr();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(142); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 10:
				_localctx = new BinaryExprContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(144);
				((BinaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24))) != 0)) ) {
					((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(145);
				expr();
				setState(146);
				expr();
				}
				break;
			case 11:
				_localctx = new BinaryExprContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(148);
				((BinaryExprContext)_localctx).op = match(T__25);
				setState(149);
				expr();
				setState(151); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(150);
						expr();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(153); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 12:
				_localctx = new BinaryExprContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(155);
				((BinaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__26 || _la==T__27) ) {
					((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(156);
				expr();
				setState(158); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(157);
						expr();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(160); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 13:
				_localctx = new BinaryExprContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(162);
				((BinaryExprContext)_localctx).op = match(T__28);
				setState(163);
				expr();
				setState(164);
				expr();
				}
				break;
			case 14:
				_localctx = new BinaryExprContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(166);
				((BinaryExprContext)_localctx).op = match(T__29);
				setState(167);
				expr();
				setState(168);
				expr();
				}
				break;
			case 15:
				_localctx = new ParenExprContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(170);
				match(T__0);
				setState(171);
				expr();
				setState(172);
				match(T__2);
				}
				break;
			case 16:
				_localctx = new IfThenElseExprContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(174);
				match(T__30);
				setState(175);
				expr();
				setState(176);
				expr();
				setState(177);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3)\u00b8\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\7\2\32\n\2\f\2\16\2\35\13\2\3\2\7\2 \n\2\f\2\16\2#\13"+
		"\2\3\2\3\2\7\2\'\n\2\f\2\16\2*\13\2\3\2\3\2\3\3\6\3/\n\3\r\3\16\3\60\3"+
		"\3\3\3\3\3\3\3\3\3\5\38\n\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\7"+
		"\5D\n\5\f\5\16\5G\13\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\7\6P\n\6\f\6\16\6S"+
		"\13\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\5\7\\\n\7\3\b\3\b\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\5\tf\n\t\3\n\3\n\3\n\3\n\7\nl\n\n\f\n\16\no\13\n\5\nq\n\n\3\13"+
		"\3\13\3\13\3\13\7\13w\n\13\f\13\16\13z\13\13\5\13|\n\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\6\f\u008f\n\f\r"+
		"\f\16\f\u0090\3\f\3\f\3\f\3\f\3\f\3\f\3\f\6\f\u009a\n\f\r\f\16\f\u009b"+
		"\3\f\3\f\3\f\6\f\u00a1\n\f\r\f\16\f\u00a2\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00b6\n\f\3\f\2\2\r\2\4\6"+
		"\b\n\f\16\20\22\24\26\2\7\3\2\16\17\3\2\22\24\4\2\21\21\25\26\3\2\27\33"+
		"\3\2\35\36\2\u00cd\2\33\3\2\2\2\4.\3\2\2\2\6<\3\2\2\2\b>\3\2\2\2\nL\3"+
		"\2\2\2\f[\3\2\2\2\16]\3\2\2\2\20e\3\2\2\2\22g\3\2\2\2\24r\3\2\2\2\26\u00b5"+
		"\3\2\2\2\30\32\5\22\n\2\31\30\3\2\2\2\32\35\3\2\2\2\33\31\3\2\2\2\33\34"+
		"\3\2\2\2\34!\3\2\2\2\35\33\3\2\2\2\36 \5\24\13\2\37\36\3\2\2\2 #\3\2\2"+
		"\2!\37\3\2\2\2!\"\3\2\2\2\"(\3\2\2\2#!\3\2\2\2$\'\5\4\3\2%\'\5\6\4\2&"+
		"$\3\2\2\2&%\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2)+\3\2\2\2*(\3\2\2\2"+
		"+,\7\2\2\3,\3\3\2\2\2-/\5\b\5\2.-\3\2\2\2/\60\3\2\2\2\60.\3\2\2\2\60\61"+
		"\3\2\2\2\61\62\3\2\2\2\62\63\7\3\2\2\63\64\7\4\2\2\64\67\7\3\2\2\658\5"+
		"\n\6\2\668\5\26\f\2\67\65\3\2\2\2\67\66\3\2\2\289\3\2\2\29:\7\5\2\2:;"+
		"\7\5\2\2;\5\3\2\2\2<=\7(\2\2=\7\3\2\2\2>?\7\3\2\2?@\7\6\2\2@A\7%\2\2A"+
		"E\7\3\2\2BD\5\20\t\2CB\3\2\2\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2FH\3\2\2\2"+
		"GE\3\2\2\2HI\7\5\2\2IJ\5\20\t\2JK\7\5\2\2K\t\3\2\2\2LM\7\7\2\2MQ\7\3\2"+
		"\2NP\5\16\b\2ON\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2RT\3\2\2\2SQ\3\2"+
		"\2\2TU\7\5\2\2UV\7\3\2\2VW\5\f\7\2WX\7\5\2\2X\13\3\2\2\2Y\\\5\n\6\2Z\\"+
		"\5\26\f\2[Y\3\2\2\2[Z\3\2\2\2\\\r\3\2\2\2]^\7\3\2\2^_\7%\2\2_`\5\26\f"+
		"\2`a\7\5\2\2a\17\3\2\2\2bf\7\b\2\2cf\7\t\2\2df\7\n\2\2eb\3\2\2\2ec\3\2"+
		"\2\2ed\3\2\2\2f\21\3\2\2\2gp\7\13\2\2hm\7%\2\2ij\7\f\2\2jl\7%\2\2ki\3"+
		"\2\2\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2nq\3\2\2\2om\3\2\2\2ph\3\2\2\2pq\3"+
		"\2\2\2q\23\3\2\2\2r{\7\r\2\2sx\7%\2\2tu\7\f\2\2uw\7%\2\2vt\3\2\2\2wz\3"+
		"\2\2\2xv\3\2\2\2xy\3\2\2\2y|\3\2\2\2zx\3\2\2\2{s\3\2\2\2{|\3\2\2\2|\25"+
		"\3\2\2\2}\u00b6\7%\2\2~\u00b6\7$\2\2\177\u00b6\7\"\2\2\u0080\u00b6\7#"+
		"\2\2\u0081\u0082\t\2\2\2\u0082\u00b6\5\26\f\2\u0083\u0084\7\20\2\2\u0084"+
		"\u00b6\5\26\f\2\u0085\u0086\7\21\2\2\u0086\u00b6\5\26\f\2\u0087\u0088"+
		"\t\3\2\2\u0088\u0089\5\26\f\2\u0089\u008a\5\26\f\2\u008a\u00b6\3\2\2\2"+
		"\u008b\u008c\t\4\2\2\u008c\u008e\5\26\f\2\u008d\u008f\5\26\f\2\u008e\u008d"+
		"\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091"+
		"\u00b6\3\2\2\2\u0092\u0093\t\5\2\2\u0093\u0094\5\26\f\2\u0094\u0095\5"+
		"\26\f\2\u0095\u00b6\3\2\2\2\u0096\u0097\7\34\2\2\u0097\u0099\5\26\f\2"+
		"\u0098\u009a\5\26\f\2\u0099\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u0099"+
		"\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u00b6\3\2\2\2\u009d\u009e\t\6\2\2\u009e"+
		"\u00a0\5\26\f\2\u009f\u00a1\5\26\f\2\u00a0\u009f\3\2\2\2\u00a1\u00a2\3"+
		"\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00b6\3\2\2\2\u00a4"+
		"\u00a5\7\37\2\2\u00a5\u00a6\5\26\f\2\u00a6\u00a7\5\26\f\2\u00a7\u00b6"+
		"\3\2\2\2\u00a8\u00a9\7 \2\2\u00a9\u00aa\5\26\f\2\u00aa\u00ab\5\26\f\2"+
		"\u00ab\u00b6\3\2\2\2\u00ac\u00ad\7\3\2\2\u00ad\u00ae\5\26\f\2\u00ae\u00af"+
		"\7\5\2\2\u00af\u00b6\3\2\2\2\u00b0\u00b1\7!\2\2\u00b1\u00b2\5\26\f\2\u00b2"+
		"\u00b3\5\26\f\2\u00b3\u00b4\5\26\f\2\u00b4\u00b6\3\2\2\2\u00b5}\3\2\2"+
		"\2\u00b5~\3\2\2\2\u00b5\177\3\2\2\2\u00b5\u0080\3\2\2\2\u00b5\u0081\3"+
		"\2\2\2\u00b5\u0083\3\2\2\2\u00b5\u0085\3\2\2\2\u00b5\u0087\3\2\2\2\u00b5"+
		"\u008b\3\2\2\2\u00b5\u0092\3\2\2\2\u00b5\u0096\3\2\2\2\u00b5\u009d\3\2"+
		"\2\2\u00b5\u00a4\3\2\2\2\u00b5\u00a8\3\2\2\2\u00b5\u00ac\3\2\2\2\u00b5"+
		"\u00b0\3\2\2\2\u00b6\27\3\2\2\2\24\33!&(\60\67EQ[empx{\u0090\u009b\u00a2"+
		"\u00b5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}