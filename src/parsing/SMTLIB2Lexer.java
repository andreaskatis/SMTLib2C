// Generated from /home/dr41k/git/SMTLib2C/src/parsing/SMTLIB2.g4 by ANTLR 4.5.3
package parsing;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SMTLIB2Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		REAL=32, BOOL=33, INT=34, ID=35, WS=36, SL_COMMENT=37, CS=38, ERROR=39;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "REAL", "BOOL", 
		"INT", "ID", "WS", "SL_COMMENT", "CS", "ERROR"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "'assert'", "')'", "'declare-fun'", "'let'", "'Int'", "'Bool'", 
		"'Real'", "';-- INPUTS: '", "','", "';-- PROPERTIES: '", "'to_real'", 
		"'to_int'", "'not'", "'-'", "'*'", "'/'", "'div'", "'mod'", "'+'", "'<'", 
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


	public SMTLIB2Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SMTLIB2.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2)\u0123\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t"+
		"\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24"+
		"\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\31"+
		"\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36"+
		"\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3\"\3\"\3\"\5\"\u00ec\n\"\3#\6#\u00ef\n#\r#\16#\u00f0\3$\3$\7$\u00f5"+
		"\n$\f$\16$\u00f8\13$\3%\6%\u00fb\n%\r%\16%\u00fc\3%\3%\3&\3&\3&\7&\u0104"+
		"\n&\f&\16&\u0107\13&\3&\5&\u010a\n&\3&\5&\u010d\n&\3&\5&\u0110\n&\3&\3"+
		"&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\2\2)\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37="+
		" ?!A\"C#E$G%I&K\'M(O)\3\2\7\3\2\62;\t\2##&\'\60\60C\\aac|\u0080\u0080"+
		"\n\2##&\'\60\60\62;C\\aac|\u0080\u0080\5\2\13\f\16\17\"\"\5\2\f\f\17\17"+
		"//\u012a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\3Q\3\2\2\2\5S"+
		"\3\2\2\2\7Z\3\2\2\2\t\\\3\2\2\2\13h\3\2\2\2\rl\3\2\2\2\17p\3\2\2\2\21"+
		"u\3\2\2\2\23z\3\2\2\2\25\u0087\3\2\2\2\27\u0089\3\2\2\2\31\u009a\3\2\2"+
		"\2\33\u00a2\3\2\2\2\35\u00a9\3\2\2\2\37\u00ad\3\2\2\2!\u00af\3\2\2\2#"+
		"\u00b1\3\2\2\2%\u00b3\3\2\2\2\'\u00b7\3\2\2\2)\u00bb\3\2\2\2+\u00bd\3"+
		"\2\2\2-\u00bf\3\2\2\2/\u00c2\3\2\2\2\61\u00c4\3\2\2\2\63\u00c7\3\2\2\2"+
		"\65\u00c9\3\2\2\2\67\u00cd\3\2\2\29\u00d0\3\2\2\2;\u00d4\3\2\2\2=\u00d7"+
		"\3\2\2\2?\u00da\3\2\2\2A\u00de\3\2\2\2C\u00eb\3\2\2\2E\u00ee\3\2\2\2G"+
		"\u00f2\3\2\2\2I\u00fa\3\2\2\2K\u0100\3\2\2\2M\u0113\3\2\2\2O\u0121\3\2"+
		"\2\2QR\7*\2\2R\4\3\2\2\2ST\7c\2\2TU\7u\2\2UV\7u\2\2VW\7g\2\2WX\7t\2\2"+
		"XY\7v\2\2Y\6\3\2\2\2Z[\7+\2\2[\b\3\2\2\2\\]\7f\2\2]^\7g\2\2^_\7e\2\2_"+
		"`\7n\2\2`a\7c\2\2ab\7t\2\2bc\7g\2\2cd\7/\2\2de\7h\2\2ef\7w\2\2fg\7p\2"+
		"\2g\n\3\2\2\2hi\7n\2\2ij\7g\2\2jk\7v\2\2k\f\3\2\2\2lm\7K\2\2mn\7p\2\2"+
		"no\7v\2\2o\16\3\2\2\2pq\7D\2\2qr\7q\2\2rs\7q\2\2st\7n\2\2t\20\3\2\2\2"+
		"uv\7T\2\2vw\7g\2\2wx\7c\2\2xy\7n\2\2y\22\3\2\2\2z{\7=\2\2{|\7/\2\2|}\7"+
		"/\2\2}~\7\"\2\2~\177\7K\2\2\177\u0080\7P\2\2\u0080\u0081\7R\2\2\u0081"+
		"\u0082\7W\2\2\u0082\u0083\7V\2\2\u0083\u0084\7U\2\2\u0084\u0085\7<\2\2"+
		"\u0085\u0086\7\"\2\2\u0086\24\3\2\2\2\u0087\u0088\7.\2\2\u0088\26\3\2"+
		"\2\2\u0089\u008a\7=\2\2\u008a\u008b\7/\2\2\u008b\u008c\7/\2\2\u008c\u008d"+
		"\7\"\2\2\u008d\u008e\7R\2\2\u008e\u008f\7T\2\2\u008f\u0090\7Q\2\2\u0090"+
		"\u0091\7R\2\2\u0091\u0092\7G\2\2\u0092\u0093\7T\2\2\u0093\u0094\7V\2\2"+
		"\u0094\u0095\7K\2\2\u0095\u0096\7G\2\2\u0096\u0097\7U\2\2\u0097\u0098"+
		"\7<\2\2\u0098\u0099\7\"\2\2\u0099\30\3\2\2\2\u009a\u009b\7v\2\2\u009b"+
		"\u009c\7q\2\2\u009c\u009d\7a\2\2\u009d\u009e\7t\2\2\u009e\u009f\7g\2\2"+
		"\u009f\u00a0\7c\2\2\u00a0\u00a1\7n\2\2\u00a1\32\3\2\2\2\u00a2\u00a3\7"+
		"v\2\2\u00a3\u00a4\7q\2\2\u00a4\u00a5\7a\2\2\u00a5\u00a6\7k\2\2\u00a6\u00a7"+
		"\7p\2\2\u00a7\u00a8\7v\2\2\u00a8\34\3\2\2\2\u00a9\u00aa\7p\2\2\u00aa\u00ab"+
		"\7q\2\2\u00ab\u00ac\7v\2\2\u00ac\36\3\2\2\2\u00ad\u00ae\7/\2\2\u00ae "+
		"\3\2\2\2\u00af\u00b0\7,\2\2\u00b0\"\3\2\2\2\u00b1\u00b2\7\61\2\2\u00b2"+
		"$\3\2\2\2\u00b3\u00b4\7f\2\2\u00b4\u00b5\7k\2\2\u00b5\u00b6\7x\2\2\u00b6"+
		"&\3\2\2\2\u00b7\u00b8\7o\2\2\u00b8\u00b9\7q\2\2\u00b9\u00ba\7f\2\2\u00ba"+
		"(\3\2\2\2\u00bb\u00bc\7-\2\2\u00bc*\3\2\2\2\u00bd\u00be\7>\2\2\u00be,"+
		"\3\2\2\2\u00bf\u00c0\7>\2\2\u00c0\u00c1\7?\2\2\u00c1.\3\2\2\2\u00c2\u00c3"+
		"\7@\2\2\u00c3\60\3\2\2\2\u00c4\u00c5\7@\2\2\u00c5\u00c6\7?\2\2\u00c6\62"+
		"\3\2\2\2\u00c7\u00c8\7?\2\2\u00c8\64\3\2\2\2\u00c9\u00ca\7c\2\2\u00ca"+
		"\u00cb\7p\2\2\u00cb\u00cc\7f\2\2\u00cc\66\3\2\2\2\u00cd\u00ce\7q\2\2\u00ce"+
		"\u00cf\7t\2\2\u00cf8\3\2\2\2\u00d0\u00d1\7z\2\2\u00d1\u00d2\7q\2\2\u00d2"+
		"\u00d3\7t\2\2\u00d3:\3\2\2\2\u00d4\u00d5\7?\2\2\u00d5\u00d6\7@\2\2\u00d6"+
		"<\3\2\2\2\u00d7\u00d8\7/\2\2\u00d8\u00d9\7@\2\2\u00d9>\3\2\2\2\u00da\u00db"+
		"\7k\2\2\u00db\u00dc\7v\2\2\u00dc\u00dd\7g\2\2\u00dd@\3\2\2\2\u00de\u00df"+
		"\5E#\2\u00df\u00e0\7\60\2\2\u00e0\u00e1\5E#\2\u00e1B\3\2\2\2\u00e2\u00e3"+
		"\7v\2\2\u00e3\u00e4\7t\2\2\u00e4\u00e5\7w\2\2\u00e5\u00ec\7g\2\2\u00e6"+
		"\u00e7\7h\2\2\u00e7\u00e8\7c\2\2\u00e8\u00e9\7n\2\2\u00e9\u00ea\7u\2\2"+
		"\u00ea\u00ec\7g\2\2\u00eb\u00e2\3\2\2\2\u00eb\u00e6\3\2\2\2\u00ecD\3\2"+
		"\2\2\u00ed\u00ef\t\2\2\2\u00ee\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0"+
		"\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1F\3\2\2\2\u00f2\u00f6\t\3\2\2"+
		"\u00f3\u00f5\t\4\2\2\u00f4\u00f3\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6\u00f4"+
		"\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7H\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f9"+
		"\u00fb\t\5\2\2\u00fa\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fa\3\2"+
		"\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u00ff\b%\2\2\u00ff"+
		"J\3\2\2\2\u0100\u0109\7=\2\2\u0101\u0105\n\6\2\2\u0102\u0104\n\6\2\2\u0103"+
		"\u0102\3\2\2\2\u0104\u0107\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2"+
		"\2\2\u0106\u010a\3\2\2\2\u0107\u0105\3\2\2\2\u0108\u010a\3\2\2\2\u0109"+
		"\u0101\3\2\2\2\u0109\u0108\3\2\2\2\u010a\u010f\3\2\2\2\u010b\u010d\7\17"+
		"\2\2\u010c\u010b\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010e\3\2\2\2\u010e"+
		"\u0110\7\f\2\2\u010f\u010c\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0111\3\2"+
		"\2\2\u0111\u0112\b&\2\2\u0112L\3\2\2\2\u0113\u0114\7*\2\2\u0114\u0115"+
		"\7e\2\2\u0115\u0116\7j\2\2\u0116\u0117\7g\2\2\u0117\u0118\7e\2\2\u0118"+
		"\u0119\7m\2\2\u0119\u011a\7/\2\2\u011a\u011b\7u\2\2\u011b\u011c\7c\2\2"+
		"\u011c\u011d\7v\2\2\u011d\u011e\7+\2\2\u011e\u011f\3\2\2\2\u011f\u0120"+
		"\b\'\2\2\u0120N\3\2\2\2\u0121\u0122\13\2\2\2\u0122P\3\2\2\2\13\2\u00eb"+
		"\u00f0\u00f6\u00fc\u0105\u0109\u010c\u010f\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}