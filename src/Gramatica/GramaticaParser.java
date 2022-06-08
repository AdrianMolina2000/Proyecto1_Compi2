// Generated from C:/Users/adria/OneDrive/Escritorio/Compi2/Proyecto1/src\Gramatica.g4 by ANTLR 4.10.1
package Gramatica;

    import java.util.List;
    import java.util.ArrayList;
    import Abstract.*;
    import Expresiones.*;
    import Instrucciones.*;
    import Other.*;
    import Symbols.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GramaticaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, INT=8, REAL=9, 
		COMPLEX=10, IDEN=11, CHAR=12, WS=13, COMENTARIO=14;
	public static final int
		RULE_start = 0, RULE_instrucciones = 1, RULE_instrucciones2 = 2, RULE_print = 3, 
		RULE_expresion = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "instrucciones", "instrucciones2", "print", "expresion"
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

	@Override
	public String getGrammarFileName() { return "Gramatica.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GramaticaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public InstruccionesContext instrucciones;
		public List<InstruccionesContext> instrucciones() {
			return getRuleContexts(InstruccionesContext.class);
		}
		public InstruccionesContext instrucciones(int i) {
			return getRuleContext(InstruccionesContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(10);
				((StartContext)_localctx).instrucciones = instrucciones();
				Gramatica.Globales.tree.instrucciones.add(((StartContext)_localctx).instrucciones.nodo);
				}
				}
				setState(17);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class InstruccionesContext extends ParserRuleContext {
		public Nodo nodo;
		public Token id1;
		public Instrucciones2Context instrucciones2;
		public Token id2;
		public List<TerminalNode> IDEN() { return getTokens(GramaticaParser.IDEN); }
		public TerminalNode IDEN(int i) {
			return getToken(GramaticaParser.IDEN, i);
		}
		public List<Instrucciones2Context> instrucciones2() {
			return getRuleContexts(Instrucciones2Context.class);
		}
		public Instrucciones2Context instrucciones2(int i) {
			return getRuleContext(Instrucciones2Context.class,i);
		}
		public InstruccionesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instrucciones; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitInstrucciones(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstruccionesContext instrucciones() throws RecognitionException {
		InstruccionesContext _localctx = new InstruccionesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_instrucciones);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			match(T__0);
			setState(19);
			((InstruccionesContext)_localctx).id1 = match(IDEN);
			setState(20);
			match(T__1);
			setState(21);
			match(T__2);
			ArrayList<Nodo> instr = new ArrayList<Nodo>();
			setState(28);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(23);
				((InstruccionesContext)_localctx).instrucciones2 = instrucciones2();
				instr.add(((InstruccionesContext)_localctx).instrucciones2.nodo);
				}
				}
				setState(30);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(31);
			match(T__3);
			setState(32);
			match(T__0);
			setState(33);
			((InstruccionesContext)_localctx).id2 = match(IDEN);
			((InstruccionesContext)_localctx).nodo =  new Program(instr,(((InstruccionesContext)_localctx).id1!=null?((InstruccionesContext)_localctx).id1.getText():null),(((InstruccionesContext)_localctx).id2!=null?((InstruccionesContext)_localctx).id2.getText():null),(((InstruccionesContext)_localctx).id1!=null?((InstruccionesContext)_localctx).id1.getLine():0), (((InstruccionesContext)_localctx).id1!=null?((InstruccionesContext)_localctx).id1.getCharPositionInLine():0));
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

	public static class Instrucciones2Context extends ParserRuleContext {
		public Nodo nodo;
		public PrintContext print;
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public Instrucciones2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instrucciones2; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitInstrucciones2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Instrucciones2Context instrucciones2() throws RecognitionException {
		Instrucciones2Context _localctx = new Instrucciones2Context(_ctx, getState());
		enterRule(_localctx, 4, RULE_instrucciones2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			((Instrucciones2Context)_localctx).print = print();
			((Instrucciones2Context)_localctx).nodo = ((Instrucciones2Context)_localctx).print.nodo;
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

	public static class PrintContext extends ParserRuleContext {
		public Nodo nodo;
		public Token p;
		public ExpresionContext expresion;
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			((PrintContext)_localctx).p = match(T__4);
			setState(40);
			match(T__5);
			setState(41);
			((PrintContext)_localctx).expresion = expresion();
			setState(42);
			match(T__6);
			((PrintContext)_localctx).nodo =  new Print(((PrintContext)_localctx).expresion.nodo, (((PrintContext)_localctx).p!=null?((PrintContext)_localctx).p.getLine():0), (((PrintContext)_localctx).p!=null?((PrintContext)_localctx).p.getCharPositionInLine():0));
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

	public static class ExpresionContext extends ParserRuleContext {
		public Nodo nodo;
		public Token REAL;
		public Token INT;
		public TerminalNode REAL() { return getToken(GramaticaParser.REAL, 0); }
		public TerminalNode INT() { return getToken(GramaticaParser.INT, 0); }
		public ExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExpresion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpresionContext expresion() throws RecognitionException {
		ExpresionContext _localctx = new ExpresionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expresion);
		try {
			setState(49);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case REAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(45);
				((ExpresionContext)_localctx).REAL = match(REAL);
				((ExpresionContext)_localctx).nodo =  new Primitivo(Tipo.Tipos.REAL, (((ExpresionContext)_localctx).REAL!=null?((ExpresionContext)_localctx).REAL.getText():null), (((ExpresionContext)_localctx).REAL!=null?((ExpresionContext)_localctx).REAL.getLine():0), (((ExpresionContext)_localctx).REAL!=null?((ExpresionContext)_localctx).REAL.getCharPositionInLine():0));
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				((ExpresionContext)_localctx).INT = match(INT);
				((ExpresionContext)_localctx).nodo =  new Primitivo(Tipo.Tipos.INTEGER, (((ExpresionContext)_localctx).INT!=null?((ExpresionContext)_localctx).INT.getText():null), (((ExpresionContext)_localctx).INT!=null?((ExpresionContext)_localctx).INT.getLine():0), (((ExpresionContext)_localctx).INT!=null?((ExpresionContext)_localctx).INT.getCharPositionInLine():0));
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

	public static final String _serializedATN =
		"\u0004\u0001\u000e4\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0005\u0000\u000e\b\u0000\n\u0000\f\u0000"+
		"\u0011\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001\u001b\b\u0001\n\u0001"+
		"\f\u0001\u001e\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u00042\b\u0004\u0001\u0004\u0000\u0000"+
		"\u0005\u0000\u0002\u0004\u0006\b\u0000\u00001\u0000\u000f\u0001\u0000"+
		"\u0000\u0000\u0002\u0012\u0001\u0000\u0000\u0000\u0004$\u0001\u0000\u0000"+
		"\u0000\u0006\'\u0001\u0000\u0000\u0000\b1\u0001\u0000\u0000\u0000\n\u000b"+
		"\u0003\u0002\u0001\u0000\u000b\f\u0006\u0000\uffff\uffff\u0000\f\u000e"+
		"\u0001\u0000\u0000\u0000\r\n\u0001\u0000\u0000\u0000\u000e\u0011\u0001"+
		"\u0000\u0000\u0000\u000f\r\u0001\u0000\u0000\u0000\u000f\u0010\u0001\u0000"+
		"\u0000\u0000\u0010\u0001\u0001\u0000\u0000\u0000\u0011\u000f\u0001\u0000"+
		"\u0000\u0000\u0012\u0013\u0005\u0001\u0000\u0000\u0013\u0014\u0005\u000b"+
		"\u0000\u0000\u0014\u0015\u0005\u0002\u0000\u0000\u0015\u0016\u0005\u0003"+
		"\u0000\u0000\u0016\u001c\u0006\u0001\uffff\uffff\u0000\u0017\u0018\u0003"+
		"\u0004\u0002\u0000\u0018\u0019\u0006\u0001\uffff\uffff\u0000\u0019\u001b"+
		"\u0001\u0000\u0000\u0000\u001a\u0017\u0001\u0000\u0000\u0000\u001b\u001e"+
		"\u0001\u0000\u0000\u0000\u001c\u001a\u0001\u0000\u0000\u0000\u001c\u001d"+
		"\u0001\u0000\u0000\u0000\u001d\u001f\u0001\u0000\u0000\u0000\u001e\u001c"+
		"\u0001\u0000\u0000\u0000\u001f \u0005\u0004\u0000\u0000 !\u0005\u0001"+
		"\u0000\u0000!\"\u0005\u000b\u0000\u0000\"#\u0006\u0001\uffff\uffff\u0000"+
		"#\u0003\u0001\u0000\u0000\u0000$%\u0003\u0006\u0003\u0000%&\u0006\u0002"+
		"\uffff\uffff\u0000&\u0005\u0001\u0000\u0000\u0000\'(\u0005\u0005\u0000"+
		"\u0000()\u0005\u0006\u0000\u0000)*\u0003\b\u0004\u0000*+\u0005\u0007\u0000"+
		"\u0000+,\u0006\u0003\uffff\uffff\u0000,\u0007\u0001\u0000\u0000\u0000"+
		"-.\u0005\t\u0000\u0000.2\u0006\u0004\uffff\uffff\u0000/0\u0005\b\u0000"+
		"\u000002\u0006\u0004\uffff\uffff\u00001-\u0001\u0000\u0000\u00001/\u0001"+
		"\u0000\u0000\u00002\t\u0001\u0000\u0000\u0000\u0003\u000f\u001c1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}