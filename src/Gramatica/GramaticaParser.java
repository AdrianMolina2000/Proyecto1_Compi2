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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, INT=21, REAL=22, COMPLEX=23, IDEN=24, CHAR=25, 
		STRING=26, WS=27, COMENTARIO=28;
	public static final int
		RULE_start = 0, RULE_listaInstrucciones = 1, RULE_instrucciones = 2, RULE_instrucciones2 = 3, 
		RULE_declaracion = 4, RULE_listaDeclaracion = 5, RULE_asignacion = 6, 
		RULE_print = 7, RULE_listaPrint = 8, RULE_expresion = 9, RULE_tipo = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "listaInstrucciones", "instrucciones", "instrucciones2", "declaracion", 
			"listaDeclaracion", "asignacion", "print", "listaPrint", "expresion", 
			"tipo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'program'", "'implicit'", "'none'", "'end'", "'::'", "'='", "','", 
			"'print'", "'*'", "'-'", "'**'", "'/'", "'+'", "'.true.'", "'.false.'", 
			"'integer'", "'real'", "'complex'", "'character'", "'logical'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "INT", "REAL", 
			"COMPLEX", "IDEN", "CHAR", "STRING", "WS", "COMENTARIO"
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
		public ListaInstruccionesContext listaInstrucciones() {
			return getRuleContext(ListaInstruccionesContext.class,0);
		}
		public TerminalNode EOF() { return getToken(GramaticaParser.EOF, 0); }
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			listaInstrucciones();
			setState(23);
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

	public static class ListaInstruccionesContext extends ParserRuleContext {
		public InstruccionesContext instrucciones;
		public List<InstruccionesContext> e = new ArrayList<InstruccionesContext>();
		public List<InstruccionesContext> instrucciones() {
			return getRuleContexts(InstruccionesContext.class);
		}
		public InstruccionesContext instrucciones(int i) {
			return getRuleContext(InstruccionesContext.class,i);
		}
		public ListaInstruccionesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaInstrucciones; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitListaInstrucciones(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListaInstruccionesContext listaInstrucciones() throws RecognitionException {
		ListaInstruccionesContext _localctx = new ListaInstruccionesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_listaInstrucciones);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(25);
				((ListaInstruccionesContext)_localctx).instrucciones = instrucciones();
				((ListaInstruccionesContext)_localctx).e.add(((ListaInstruccionesContext)_localctx).instrucciones);
				}
				}
				setState(30);
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
		public InstruccionesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instrucciones; }
	 
		public InstruccionesContext() { }
		public void copyFrom(InstruccionesContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class InstruccionesProgramContext extends InstruccionesContext {
		public Token id1;
		public Instrucciones2Context instrucciones2;
		public List<Instrucciones2Context> e = new ArrayList<Instrucciones2Context>();
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
		public InstruccionesProgramContext(InstruccionesContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitInstruccionesProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstruccionesContext instrucciones() throws RecognitionException {
		InstruccionesContext _localctx = new InstruccionesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_instrucciones);
		int _la;
		try {
			_localctx = new InstruccionesProgramContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			match(T__0);
			setState(32);
			((InstruccionesProgramContext)_localctx).id1 = match(IDEN);
			setState(33);
			match(T__1);
			setState(34);
			match(T__2);
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << IDEN))) != 0)) {
				{
				{
				setState(35);
				((InstruccionesProgramContext)_localctx).instrucciones2 = instrucciones2();
				((InstruccionesProgramContext)_localctx).e.add(((InstruccionesProgramContext)_localctx).instrucciones2);
				}
				}
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(41);
			match(T__3);
			setState(42);
			match(T__0);
			setState(43);
			((InstruccionesProgramContext)_localctx).id2 = match(IDEN);
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
		public Instrucciones2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instrucciones2; }
	 
		public Instrucciones2Context() { }
		public void copyFrom(Instrucciones2Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Instrucciones2PrintContext extends Instrucciones2Context {
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public Instrucciones2PrintContext(Instrucciones2Context ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitInstrucciones2Print(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Instrucciones2AsignacionContext extends Instrucciones2Context {
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public Instrucciones2AsignacionContext(Instrucciones2Context ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitInstrucciones2Asignacion(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Instrucciones2DeclaracionContext extends Instrucciones2Context {
		public DeclaracionContext declaracion() {
			return getRuleContext(DeclaracionContext.class,0);
		}
		public Instrucciones2DeclaracionContext(Instrucciones2Context ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitInstrucciones2Declaracion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Instrucciones2Context instrucciones2() throws RecognitionException {
		Instrucciones2Context _localctx = new Instrucciones2Context(_ctx, getState());
		enterRule(_localctx, 6, RULE_instrucciones2);
		try {
			setState(48);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__15:
			case T__16:
			case T__17:
			case T__18:
			case T__19:
				_localctx = new Instrucciones2DeclaracionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(45);
				declaracion();
				}
				break;
			case T__7:
				_localctx = new Instrucciones2PrintContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(46);
				print();
				}
				break;
			case IDEN:
				_localctx = new Instrucciones2AsignacionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(47);
				asignacion();
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

	public static class DeclaracionContext extends ParserRuleContext {
		public DeclaracionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion; }
	 
		public DeclaracionContext() { }
		public void copyFrom(DeclaracionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DeclaracionAsigContext extends DeclaracionContext {
		public Token id;
		public ListaDeclaracionContext listaDeclaracion;
		public List<ListaDeclaracionContext> e = new ArrayList<ListaDeclaracionContext>();
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public List<ListaDeclaracionContext> listaDeclaracion() {
			return getRuleContexts(ListaDeclaracionContext.class);
		}
		public ListaDeclaracionContext listaDeclaracion(int i) {
			return getRuleContext(ListaDeclaracionContext.class,i);
		}
		public DeclaracionAsigContext(DeclaracionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDeclaracionAsig(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeclaracionUniqContext extends DeclaracionContext {
		public Token id;
		public ListaDeclaracionContext listaDeclaracion;
		public List<ListaDeclaracionContext> e = new ArrayList<ListaDeclaracionContext>();
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public List<ListaDeclaracionContext> listaDeclaracion() {
			return getRuleContexts(ListaDeclaracionContext.class);
		}
		public ListaDeclaracionContext listaDeclaracion(int i) {
			return getRuleContext(ListaDeclaracionContext.class,i);
		}
		public DeclaracionUniqContext(DeclaracionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDeclaracionUniq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracionContext declaracion() throws RecognitionException {
		DeclaracionContext _localctx = new DeclaracionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declaracion);
		int _la;
		try {
			setState(70);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new DeclaracionAsigContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				tipo();
				setState(51);
				match(T__4);
				setState(52);
				((DeclaracionAsigContext)_localctx).id = match(IDEN);
				setState(53);
				match(T__5);
				setState(54);
				expresion(0);
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(55);
					((DeclaracionAsigContext)_localctx).listaDeclaracion = listaDeclaracion();
					((DeclaracionAsigContext)_localctx).e.add(((DeclaracionAsigContext)_localctx).listaDeclaracion);
					}
					}
					setState(60);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				_localctx = new DeclaracionUniqContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(61);
				tipo();
				setState(62);
				match(T__4);
				setState(63);
				((DeclaracionUniqContext)_localctx).id = match(IDEN);
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(64);
					((DeclaracionUniqContext)_localctx).listaDeclaracion = listaDeclaracion();
					((DeclaracionUniqContext)_localctx).e.add(((DeclaracionUniqContext)_localctx).listaDeclaracion);
					}
					}
					setState(69);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class ListaDeclaracionContext extends ParserRuleContext {
		public ListaDeclaracionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaDeclaracion; }
	 
		public ListaDeclaracionContext() { }
		public void copyFrom(ListaDeclaracionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ListaDeclaracionAsigContext extends ListaDeclaracionContext {
		public Token id;
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public ListaDeclaracionAsigContext(ListaDeclaracionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitListaDeclaracionAsig(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ListaDeclaracionUniqContext extends ListaDeclaracionContext {
		public Token id;
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public ListaDeclaracionUniqContext(ListaDeclaracionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitListaDeclaracionUniq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListaDeclaracionContext listaDeclaracion() throws RecognitionException {
		ListaDeclaracionContext _localctx = new ListaDeclaracionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_listaDeclaracion);
		try {
			setState(78);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new ListaDeclaracionAsigContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				match(T__6);
				setState(73);
				((ListaDeclaracionAsigContext)_localctx).id = match(IDEN);
				setState(74);
				match(T__5);
				setState(75);
				expresion(0);
				}
				break;
			case 2:
				_localctx = new ListaDeclaracionUniqContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				match(T__6);
				setState(77);
				((ListaDeclaracionUniqContext)_localctx).id = match(IDEN);
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

	public static class AsignacionContext extends ParserRuleContext {
		public Token id;
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public AsignacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asignacion; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitAsignacion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsignacionContext asignacion() throws RecognitionException {
		AsignacionContext _localctx = new AsignacionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_asignacion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			((AsignacionContext)_localctx).id = match(IDEN);
			setState(81);
			match(T__5);
			setState(82);
			expresion(0);
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
		public Token p;
		public ExpresionContext val;
		public ListaPrintContext listaPrint;
		public List<ListaPrintContext> e = new ArrayList<ListaPrintContext>();
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public List<ListaPrintContext> listaPrint() {
			return getRuleContexts(ListaPrintContext.class);
		}
		public ListaPrintContext listaPrint(int i) {
			return getRuleContext(ListaPrintContext.class,i);
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
		enterRule(_localctx, 14, RULE_print);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			((PrintContext)_localctx).p = match(T__7);
			setState(85);
			match(T__8);
			setState(86);
			match(T__6);
			setState(87);
			((PrintContext)_localctx).val = expresion(0);
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(88);
				((PrintContext)_localctx).listaPrint = listaPrint();
				((PrintContext)_localctx).e.add(((PrintContext)_localctx).listaPrint);
				}
				}
				setState(93);
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

	public static class ListaPrintContext extends ParserRuleContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public ListaPrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaPrint; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitListaPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListaPrintContext listaPrint() throws RecognitionException {
		ListaPrintContext _localctx = new ListaPrintContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_listaPrint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(T__6);
			setState(95);
			expresion(0);
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
		public ExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion; }
	 
		public ExpresionContext() { }
		public void copyFrom(ExpresionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExpresionFalseContext extends ExpresionContext {
		public Token val;
		public ExpresionFalseContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExpresionFalse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpresionRestaContext extends ExpresionContext {
		public ExpresionContext val1;
		public Token op;
		public ExpresionContext val2;
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public ExpresionRestaContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExpresionResta(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpresionRealContext extends ExpresionContext {
		public Token val;
		public TerminalNode REAL() { return getToken(GramaticaParser.REAL, 0); }
		public ExpresionRealContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExpresionReal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpresionIntContext extends ExpresionContext {
		public Token val;
		public TerminalNode INT() { return getToken(GramaticaParser.INT, 0); }
		public ExpresionIntContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExpresionInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpresionNegativoContext extends ExpresionContext {
		public Token op;
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public ExpresionNegativoContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExpresionNegativo(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpresionMultiplicacionContext extends ExpresionContext {
		public ExpresionContext val1;
		public Token op;
		public ExpresionContext val2;
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public ExpresionMultiplicacionContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExpresionMultiplicacion(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpresionSumaContext extends ExpresionContext {
		public ExpresionContext val1;
		public Token op;
		public ExpresionContext val2;
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public ExpresionSumaContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExpresionSuma(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpresionDivisionContext extends ExpresionContext {
		public ExpresionContext val1;
		public Token op;
		public ExpresionContext val2;
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public ExpresionDivisionContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExpresionDivision(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpresionPotenciaContext extends ExpresionContext {
		public ExpresionContext val1;
		public Token op;
		public ExpresionContext val2;
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public ExpresionPotenciaContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExpresionPotencia(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpresionStringContext extends ExpresionContext {
		public Token val;
		public TerminalNode STRING() { return getToken(GramaticaParser.STRING, 0); }
		public ExpresionStringContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExpresionString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpresionIdentificadorContext extends ExpresionContext {
		public Token val;
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public ExpresionIdentificadorContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExpresionIdentificador(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpresionCharContext extends ExpresionContext {
		public Token val;
		public TerminalNode CHAR() { return getToken(GramaticaParser.CHAR, 0); }
		public ExpresionCharContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExpresionChar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpresionTrueContext extends ExpresionContext {
		public Token val;
		public ExpresionTrueContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExpresionTrue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpresionContext expresion() throws RecognitionException {
		return expresion(0);
	}

	private ExpresionContext expresion(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpresionContext _localctx = new ExpresionContext(_ctx, _parentState);
		ExpresionContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_expresion, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				{
				_localctx = new ExpresionNegativoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(98);
				((ExpresionNegativoContext)_localctx).op = match(T__9);
				setState(99);
				expresion(13);
				}
				break;
			case IDEN:
				{
				_localctx = new ExpresionIdentificadorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(100);
				((ExpresionIdentificadorContext)_localctx).val = match(IDEN);
				}
				break;
			case REAL:
				{
				_localctx = new ExpresionRealContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(101);
				((ExpresionRealContext)_localctx).val = match(REAL);
				}
				break;
			case INT:
				{
				_localctx = new ExpresionIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(102);
				((ExpresionIntContext)_localctx).val = match(INT);
				}
				break;
			case CHAR:
				{
				_localctx = new ExpresionCharContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(103);
				((ExpresionCharContext)_localctx).val = match(CHAR);
				}
				break;
			case STRING:
				{
				_localctx = new ExpresionStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(104);
				((ExpresionStringContext)_localctx).val = match(STRING);
				}
				break;
			case T__13:
				{
				_localctx = new ExpresionTrueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(105);
				((ExpresionTrueContext)_localctx).val = match(T__13);
				}
				break;
			case T__14:
				{
				_localctx = new ExpresionFalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(106);
				((ExpresionFalseContext)_localctx).val = match(T__14);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(126);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(124);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new ExpresionPotenciaContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionPotenciaContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(109);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(110);
						((ExpresionPotenciaContext)_localctx).op = match(T__10);
						setState(111);
						((ExpresionPotenciaContext)_localctx).val2 = expresion(13);
						}
						break;
					case 2:
						{
						_localctx = new ExpresionMultiplicacionContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionMultiplicacionContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(112);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(113);
						((ExpresionMultiplicacionContext)_localctx).op = match(T__8);
						setState(114);
						((ExpresionMultiplicacionContext)_localctx).val2 = expresion(12);
						}
						break;
					case 3:
						{
						_localctx = new ExpresionDivisionContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionDivisionContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(115);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(116);
						((ExpresionDivisionContext)_localctx).op = match(T__11);
						setState(117);
						((ExpresionDivisionContext)_localctx).val2 = expresion(11);
						}
						break;
					case 4:
						{
						_localctx = new ExpresionSumaContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionSumaContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(118);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(119);
						((ExpresionSumaContext)_localctx).op = match(T__12);
						setState(120);
						((ExpresionSumaContext)_localctx).val2 = expresion(10);
						}
						break;
					case 5:
						{
						_localctx = new ExpresionRestaContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionRestaContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(121);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(122);
						((ExpresionRestaContext)_localctx).op = match(T__9);
						setState(123);
						((ExpresionRestaContext)_localctx).val2 = expresion(9);
						}
						break;
					}
					} 
				}
				setState(128);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
	 
		public TipoContext() { }
		public void copyFrom(TipoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TipoLogicalContext extends TipoContext {
		public TipoLogicalContext(TipoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitTipoLogical(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TipoRealContext extends TipoContext {
		public TipoRealContext(TipoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitTipoReal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TipoCharacterContext extends TipoContext {
		public TipoCharacterContext(TipoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitTipoCharacter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TipoIntegerContext extends TipoContext {
		public TipoIntegerContext(TipoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitTipoInteger(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TipoComplexContext extends TipoContext {
		public TipoComplexContext(TipoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitTipoComplex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_tipo);
		try {
			setState(134);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__15:
				_localctx = new TipoIntegerContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				match(T__15);
				}
				break;
			case T__16:
				_localctx = new TipoRealContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				match(T__16);
				}
				break;
			case T__17:
				_localctx = new TipoComplexContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(131);
				match(T__17);
				}
				break;
			case T__18:
				_localctx = new TipoCharacterContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(132);
				match(T__18);
				}
				break;
			case T__19:
				_localctx = new TipoLogicalContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(133);
				match(T__19);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9:
			return expresion_sempred((ExpresionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expresion_sempred(ExpresionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 12);
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 9);
		case 4:
			return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001c\u0089\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0005\u0001\u001b\b\u0001\n\u0001\f\u0001\u001e"+
		"\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005"+
		"\u0002%\b\u0002\n\u0002\f\u0002(\t\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u00031\b"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0005\u00049\b\u0004\n\u0004\f\u0004<\t\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0005\u0004B\b\u0004\n\u0004\f\u0004E\t"+
		"\u0004\u0003\u0004G\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0003\u0005O\b\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0005\u0007Z\b\u0007\n\u0007\f\u0007]\t\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0003\tl\b\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0005\t}\b\t\n\t\f\t\u0080\t\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0003\n\u0087\b\n\u0001\n\u0000\u0001\u0012\u000b\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0000\u0000\u0096\u0000"+
		"\u0016\u0001\u0000\u0000\u0000\u0002\u001c\u0001\u0000\u0000\u0000\u0004"+
		"\u001f\u0001\u0000\u0000\u0000\u00060\u0001\u0000\u0000\u0000\bF\u0001"+
		"\u0000\u0000\u0000\nN\u0001\u0000\u0000\u0000\fP\u0001\u0000\u0000\u0000"+
		"\u000eT\u0001\u0000\u0000\u0000\u0010^\u0001\u0000\u0000\u0000\u0012k"+
		"\u0001\u0000\u0000\u0000\u0014\u0086\u0001\u0000\u0000\u0000\u0016\u0017"+
		"\u0003\u0002\u0001\u0000\u0017\u0018\u0005\u0000\u0000\u0001\u0018\u0001"+
		"\u0001\u0000\u0000\u0000\u0019\u001b\u0003\u0004\u0002\u0000\u001a\u0019"+
		"\u0001\u0000\u0000\u0000\u001b\u001e\u0001\u0000\u0000\u0000\u001c\u001a"+
		"\u0001\u0000\u0000\u0000\u001c\u001d\u0001\u0000\u0000\u0000\u001d\u0003"+
		"\u0001\u0000\u0000\u0000\u001e\u001c\u0001\u0000\u0000\u0000\u001f \u0005"+
		"\u0001\u0000\u0000 !\u0005\u0018\u0000\u0000!\"\u0005\u0002\u0000\u0000"+
		"\"&\u0005\u0003\u0000\u0000#%\u0003\u0006\u0003\u0000$#\u0001\u0000\u0000"+
		"\u0000%(\u0001\u0000\u0000\u0000&$\u0001\u0000\u0000\u0000&\'\u0001\u0000"+
		"\u0000\u0000\')\u0001\u0000\u0000\u0000(&\u0001\u0000\u0000\u0000)*\u0005"+
		"\u0004\u0000\u0000*+\u0005\u0001\u0000\u0000+,\u0005\u0018\u0000\u0000"+
		",\u0005\u0001\u0000\u0000\u0000-1\u0003\b\u0004\u0000.1\u0003\u000e\u0007"+
		"\u0000/1\u0003\f\u0006\u00000-\u0001\u0000\u0000\u00000.\u0001\u0000\u0000"+
		"\u00000/\u0001\u0000\u0000\u00001\u0007\u0001\u0000\u0000\u000023\u0003"+
		"\u0014\n\u000034\u0005\u0005\u0000\u000045\u0005\u0018\u0000\u000056\u0005"+
		"\u0006\u0000\u00006:\u0003\u0012\t\u000079\u0003\n\u0005\u000087\u0001"+
		"\u0000\u0000\u00009<\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000"+
		":;\u0001\u0000\u0000\u0000;G\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000"+
		"\u0000=>\u0003\u0014\n\u0000>?\u0005\u0005\u0000\u0000?C\u0005\u0018\u0000"+
		"\u0000@B\u0003\n\u0005\u0000A@\u0001\u0000\u0000\u0000BE\u0001\u0000\u0000"+
		"\u0000CA\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000\u0000DG\u0001\u0000"+
		"\u0000\u0000EC\u0001\u0000\u0000\u0000F2\u0001\u0000\u0000\u0000F=\u0001"+
		"\u0000\u0000\u0000G\t\u0001\u0000\u0000\u0000HI\u0005\u0007\u0000\u0000"+
		"IJ\u0005\u0018\u0000\u0000JK\u0005\u0006\u0000\u0000KO\u0003\u0012\t\u0000"+
		"LM\u0005\u0007\u0000\u0000MO\u0005\u0018\u0000\u0000NH\u0001\u0000\u0000"+
		"\u0000NL\u0001\u0000\u0000\u0000O\u000b\u0001\u0000\u0000\u0000PQ\u0005"+
		"\u0018\u0000\u0000QR\u0005\u0006\u0000\u0000RS\u0003\u0012\t\u0000S\r"+
		"\u0001\u0000\u0000\u0000TU\u0005\b\u0000\u0000UV\u0005\t\u0000\u0000V"+
		"W\u0005\u0007\u0000\u0000W[\u0003\u0012\t\u0000XZ\u0003\u0010\b\u0000"+
		"YX\u0001\u0000\u0000\u0000Z]\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000"+
		"\u0000[\\\u0001\u0000\u0000\u0000\\\u000f\u0001\u0000\u0000\u0000][\u0001"+
		"\u0000\u0000\u0000^_\u0005\u0007\u0000\u0000_`\u0003\u0012\t\u0000`\u0011"+
		"\u0001\u0000\u0000\u0000ab\u0006\t\uffff\uffff\u0000bc\u0005\n\u0000\u0000"+
		"cl\u0003\u0012\t\rdl\u0005\u0018\u0000\u0000el\u0005\u0016\u0000\u0000"+
		"fl\u0005\u0015\u0000\u0000gl\u0005\u0019\u0000\u0000hl\u0005\u001a\u0000"+
		"\u0000il\u0005\u000e\u0000\u0000jl\u0005\u000f\u0000\u0000ka\u0001\u0000"+
		"\u0000\u0000kd\u0001\u0000\u0000\u0000ke\u0001\u0000\u0000\u0000kf\u0001"+
		"\u0000\u0000\u0000kg\u0001\u0000\u0000\u0000kh\u0001\u0000\u0000\u0000"+
		"ki\u0001\u0000\u0000\u0000kj\u0001\u0000\u0000\u0000l~\u0001\u0000\u0000"+
		"\u0000mn\n\f\u0000\u0000no\u0005\u000b\u0000\u0000o}\u0003\u0012\t\rp"+
		"q\n\u000b\u0000\u0000qr\u0005\t\u0000\u0000r}\u0003\u0012\t\fst\n\n\u0000"+
		"\u0000tu\u0005\f\u0000\u0000u}\u0003\u0012\t\u000bvw\n\t\u0000\u0000w"+
		"x\u0005\r\u0000\u0000x}\u0003\u0012\t\nyz\n\b\u0000\u0000z{\u0005\n\u0000"+
		"\u0000{}\u0003\u0012\t\t|m\u0001\u0000\u0000\u0000|p\u0001\u0000\u0000"+
		"\u0000|s\u0001\u0000\u0000\u0000|v\u0001\u0000\u0000\u0000|y\u0001\u0000"+
		"\u0000\u0000}\u0080\u0001\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000"+
		"~\u007f\u0001\u0000\u0000\u0000\u007f\u0013\u0001\u0000\u0000\u0000\u0080"+
		"~\u0001\u0000\u0000\u0000\u0081\u0087\u0005\u0010\u0000\u0000\u0082\u0087"+
		"\u0005\u0011\u0000\u0000\u0083\u0087\u0005\u0012\u0000\u0000\u0084\u0087"+
		"\u0005\u0013\u0000\u0000\u0085\u0087\u0005\u0014\u0000\u0000\u0086\u0081"+
		"\u0001\u0000\u0000\u0000\u0086\u0082\u0001\u0000\u0000\u0000\u0086\u0083"+
		"\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0086\u0085"+
		"\u0001\u0000\u0000\u0000\u0087\u0015\u0001\u0000\u0000\u0000\f\u001c&"+
		"0:CFN[k|~\u0086";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}