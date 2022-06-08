// Generated from C:/Users/adria/OneDrive/Escritorio/Compi2/Proyecto1/src\Gramatica.g4 by ANTLR 4.10.1
package Gramatica;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GramaticaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, INT=8, REAL=9, 
		COMPLEX=10, IDEN=11, CHAR=12, WS=13, COMENTARIO=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "INT", "REAL", 
			"COMPLEX", "IDEN", "CHAR", "WS", "COMENTARIO"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'program'", "'implicit'", "'none'", "'end'", "'print'", "'('", 
			"')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "INT", "REAL", "COMPLEX", 
			"IDEN", "CHAR", "WS", "COMENTARIO"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public GramaticaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Gramatica.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u000ez\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0004\u0007C\b"+
		"\u0007\u000b\u0007\f\u0007D\u0001\b\u0004\bH\b\b\u000b\b\f\bI\u0001\b"+
		"\u0001\b\u0004\bN\b\b\u000b\b\f\bO\u0001\t\u0001\t\u0004\tT\b\t\u000b"+
		"\t\f\tU\u0001\t\u0001\t\u0004\tZ\b\t\u000b\t\f\t[\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0005\nb\b\n\n\n\f\ne\t\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0004\fl\b\f\u000b\f\f\fm\u0001\f\u0001\f\u0001\r"+
		"\u0001\r\u0005\rt\b\r\n\r\f\rw\t\r\u0001\r\u0001\r\u0000\u0000\u000e\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u0001"+
		"\u0000\u0005\u0001\u000009\u0002\u0000AZaz\u0004\u000009AZ__az\u0003\u0000"+
		"\t\n\r\r  \u0002\u0000\n\n\r\r\u0081\u0000\u0001\u0001\u0000\u0000\u0000"+
		"\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000"+
		"\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000"+
		"\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f"+
		"\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013"+
		"\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017"+
		"\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b"+
		"\u0001\u0000\u0000\u0000\u0001\u001d\u0001\u0000\u0000\u0000\u0003%\u0001"+
		"\u0000\u0000\u0000\u0005.\u0001\u0000\u0000\u0000\u00073\u0001\u0000\u0000"+
		"\u0000\t7\u0001\u0000\u0000\u0000\u000b=\u0001\u0000\u0000\u0000\r?\u0001"+
		"\u0000\u0000\u0000\u000fB\u0001\u0000\u0000\u0000\u0011G\u0001\u0000\u0000"+
		"\u0000\u0013Q\u0001\u0000\u0000\u0000\u0015_\u0001\u0000\u0000\u0000\u0017"+
		"f\u0001\u0000\u0000\u0000\u0019k\u0001\u0000\u0000\u0000\u001bq\u0001"+
		"\u0000\u0000\u0000\u001d\u001e\u0005p\u0000\u0000\u001e\u001f\u0005r\u0000"+
		"\u0000\u001f \u0005o\u0000\u0000 !\u0005g\u0000\u0000!\"\u0005r\u0000"+
		"\u0000\"#\u0005a\u0000\u0000#$\u0005m\u0000\u0000$\u0002\u0001\u0000\u0000"+
		"\u0000%&\u0005i\u0000\u0000&\'\u0005m\u0000\u0000\'(\u0005p\u0000\u0000"+
		"()\u0005l\u0000\u0000)*\u0005i\u0000\u0000*+\u0005c\u0000\u0000+,\u0005"+
		"i\u0000\u0000,-\u0005t\u0000\u0000-\u0004\u0001\u0000\u0000\u0000./\u0005"+
		"n\u0000\u0000/0\u0005o\u0000\u000001\u0005n\u0000\u000012\u0005e\u0000"+
		"\u00002\u0006\u0001\u0000\u0000\u000034\u0005e\u0000\u000045\u0005n\u0000"+
		"\u000056\u0005d\u0000\u00006\b\u0001\u0000\u0000\u000078\u0005p\u0000"+
		"\u000089\u0005r\u0000\u00009:\u0005i\u0000\u0000:;\u0005n\u0000\u0000"+
		";<\u0005t\u0000\u0000<\n\u0001\u0000\u0000\u0000=>\u0005(\u0000\u0000"+
		">\f\u0001\u0000\u0000\u0000?@\u0005)\u0000\u0000@\u000e\u0001\u0000\u0000"+
		"\u0000AC\u0007\u0000\u0000\u0000BA\u0001\u0000\u0000\u0000CD\u0001\u0000"+
		"\u0000\u0000DB\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000E\u0010"+
		"\u0001\u0000\u0000\u0000FH\u0007\u0000\u0000\u0000GF\u0001\u0000\u0000"+
		"\u0000HI\u0001\u0000\u0000\u0000IG\u0001\u0000\u0000\u0000IJ\u0001\u0000"+
		"\u0000\u0000JK\u0001\u0000\u0000\u0000KM\u0005.\u0000\u0000LN\u0007\u0000"+
		"\u0000\u0000ML\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000OM\u0001"+
		"\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000P\u0012\u0001\u0000\u0000"+
		"\u0000QS\u0005(\u0000\u0000RT\u0007\u0000\u0000\u0000SR\u0001\u0000\u0000"+
		"\u0000TU\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000UV\u0001\u0000"+
		"\u0000\u0000VW\u0001\u0000\u0000\u0000WY\u0005,\u0000\u0000XZ\u0007\u0000"+
		"\u0000\u0000YX\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[Y\u0001"+
		"\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000"+
		"]^\u0005)\u0000\u0000^\u0014\u0001\u0000\u0000\u0000_c\u0007\u0001\u0000"+
		"\u0000`b\u0007\u0002\u0000\u0000a`\u0001\u0000\u0000\u0000be\u0001\u0000"+
		"\u0000\u0000ca\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000d\u0016"+
		"\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000fg\u0005\"\u0000\u0000"+
		"gh\t\u0000\u0000\u0000hi\u0005\"\u0000\u0000i\u0018\u0001\u0000\u0000"+
		"\u0000jl\u0007\u0003\u0000\u0000kj\u0001\u0000\u0000\u0000lm\u0001\u0000"+
		"\u0000\u0000mk\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000no\u0001"+
		"\u0000\u0000\u0000op\u0006\f\u0000\u0000p\u001a\u0001\u0000\u0000\u0000"+
		"qu\u0005!\u0000\u0000rt\b\u0004\u0000\u0000sr\u0001\u0000\u0000\u0000"+
		"tw\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000"+
		"\u0000vx\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000\u0000xy\u0006\r\u0000"+
		"\u0000y\u001c\u0001\u0000\u0000\u0000\t\u0000DIOU[cmu\u0001\u0006\u0000"+
		"\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}