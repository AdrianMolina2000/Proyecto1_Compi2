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
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, INT=48, REAL=49, COMPLEX=50, IDEN=51, CHAR=52, STRING=53, 
		WS=54, COMENTARIO=55;
	public static final int
		RULE_start = 0, RULE_listaInstrucciones = 1, RULE_instrucciones = 2, RULE_instrucciones2 = 3, 
		RULE_declaracion = 4, RULE_listaDeclaracion = 5, RULE_asignacion = 6, 
		RULE_allocate = 7, RULE_print = 8, RULE_listaPrint = 9, RULE_expresion = 10, 
		RULE_listaExpresion = 11, RULE_tipo = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "listaInstrucciones", "instrucciones", "instrucciones2", "declaracion", 
			"listaDeclaracion", "asignacion", "allocate", "print", "listaPrint", 
			"expresion", "listaExpresion", "tipo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'program'", "'implicit'", "'none'", "'end'", "','", "'dimension'", 
			"'('", "')'", "'::'", "'allocatable'", "':'", "'='", "'['", "']'", "'allocate'", 
			"'deallocate'", "'print'", "'*'", "'-'", "'.not.'", "'**'", "'/'", "'+'", 
			"'=='", "'.eq.'", "'/='", "'.ne.'", "'>='", "'.ge.'", "'>'", "'.gt.'", 
			"'<='", "'.le.'", "'<'", "'.lt.'", "'.and.'", "'.or.'", "'size'", "'.true.'", 
			"'.false.'", "'[/'", "'/]'", "'integer'", "'real'", "'complex'", "'character'", 
			"'logical'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"INT", "REAL", "COMPLEX", "IDEN", "CHAR", "STRING", "WS", "COMENTARIO"
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
			setState(26);
			listaInstrucciones();
			setState(27);
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
			setState(32);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(29);
				((ListaInstruccionesContext)_localctx).instrucciones = instrucciones();
				((ListaInstruccionesContext)_localctx).e.add(((ListaInstruccionesContext)_localctx).instrucciones);
				}
				}
				setState(34);
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
			setState(35);
			match(T__0);
			setState(36);
			((InstruccionesProgramContext)_localctx).id1 = match(IDEN);
			setState(37);
			match(T__1);
			setState(38);
			match(T__2);
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << IDEN))) != 0)) {
				{
				{
				setState(39);
				((InstruccionesProgramContext)_localctx).instrucciones2 = instrucciones2();
				((InstruccionesProgramContext)_localctx).e.add(((InstruccionesProgramContext)_localctx).instrucciones2);
				}
				}
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(45);
			match(T__3);
			setState(46);
			match(T__0);
			setState(47);
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
	public static class Instrucciones2AllocateContext extends Instrucciones2Context {
		public AllocateContext allocate() {
			return getRuleContext(AllocateContext.class,0);
		}
		public Instrucciones2AllocateContext(Instrucciones2Context ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitInstrucciones2Allocate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Instrucciones2Context instrucciones2() throws RecognitionException {
		Instrucciones2Context _localctx = new Instrucciones2Context(_ctx, getState());
		enterRule(_localctx, 6, RULE_instrucciones2);
		try {
			setState(53);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__42:
			case T__43:
			case T__44:
			case T__45:
			case T__46:
				_localctx = new Instrucciones2DeclaracionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				declaracion();
				}
				break;
			case IDEN:
				_localctx = new Instrucciones2AsignacionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(50);
				asignacion();
				}
				break;
			case T__14:
			case T__15:
				_localctx = new Instrucciones2AllocateContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(51);
				allocate();
				}
				break;
			case T__16:
				_localctx = new Instrucciones2PrintContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(52);
				print();
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
	public static class DeclaracionArray2Dim2Context extends DeclaracionContext {
		public Token id;
		public Token dim1;
		public Token dim2;
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public List<TerminalNode> INT() { return getTokens(GramaticaParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(GramaticaParser.INT, i);
		}
		public DeclaracionArray2Dim2Context(DeclaracionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDeclaracionArray2Dim2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeclaracionArray1Dim2Context extends DeclaracionContext {
		public Token id;
		public Token dim1;
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public TerminalNode INT() { return getToken(GramaticaParser.INT, 0); }
		public DeclaracionArray1Dim2Context(DeclaracionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDeclaracionArray1Dim2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeclaracionArray2DimContext extends DeclaracionContext {
		public Token dim1;
		public Token dim2;
		public Token id;
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<TerminalNode> INT() { return getTokens(GramaticaParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(GramaticaParser.INT, i);
		}
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public DeclaracionArray2DimContext(DeclaracionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDeclaracionArray2Dim(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeclaracionAllocatable2DimContext extends DeclaracionContext {
		public Token id;
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public DeclaracionAllocatable2DimContext(DeclaracionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDeclaracionAllocatable2Dim(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeclaracionAllocatable1DimContext extends DeclaracionContext {
		public Token id;
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public DeclaracionAllocatable1DimContext(DeclaracionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDeclaracionAllocatable1Dim(this);
			else return visitor.visitChildren(this);
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
	public static class DeclaracionArray1DimContext extends DeclaracionContext {
		public Token dim1;
		public Token id;
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode INT() { return getToken(GramaticaParser.INT, 0); }
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public DeclaracionArray1DimContext(DeclaracionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDeclaracionArray1Dim(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracionContext declaracion() throws RecognitionException {
		DeclaracionContext _localctx = new DeclaracionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declaracion);
		int _la;
		try {
			setState(131);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new DeclaracionArray2DimContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				tipo();
				setState(56);
				match(T__4);
				setState(57);
				match(T__5);
				setState(58);
				match(T__6);
				setState(59);
				((DeclaracionArray2DimContext)_localctx).dim1 = match(INT);
				setState(60);
				match(T__4);
				setState(61);
				((DeclaracionArray2DimContext)_localctx).dim2 = match(INT);
				setState(62);
				match(T__7);
				setState(63);
				match(T__8);
				setState(64);
				((DeclaracionArray2DimContext)_localctx).id = match(IDEN);
				}
				break;
			case 2:
				_localctx = new DeclaracionArray1DimContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				tipo();
				setState(67);
				match(T__4);
				setState(68);
				match(T__5);
				setState(69);
				match(T__6);
				setState(70);
				((DeclaracionArray1DimContext)_localctx).dim1 = match(INT);
				setState(71);
				match(T__7);
				setState(72);
				match(T__8);
				setState(73);
				((DeclaracionArray1DimContext)_localctx).id = match(IDEN);
				}
				break;
			case 3:
				_localctx = new DeclaracionAllocatable2DimContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(75);
				tipo();
				setState(76);
				match(T__4);
				setState(77);
				match(T__9);
				setState(78);
				match(T__8);
				setState(79);
				((DeclaracionAllocatable2DimContext)_localctx).id = match(IDEN);
				setState(80);
				match(T__6);
				setState(81);
				match(T__10);
				setState(82);
				match(T__4);
				setState(83);
				match(T__10);
				setState(84);
				match(T__7);
				}
				break;
			case 4:
				_localctx = new DeclaracionAllocatable1DimContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(86);
				tipo();
				setState(87);
				match(T__4);
				setState(88);
				match(T__9);
				setState(89);
				match(T__8);
				setState(90);
				((DeclaracionAllocatable1DimContext)_localctx).id = match(IDEN);
				setState(91);
				match(T__6);
				setState(92);
				match(T__10);
				setState(93);
				match(T__7);
				}
				break;
			case 5:
				_localctx = new DeclaracionArray2Dim2Context(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(95);
				tipo();
				setState(96);
				match(T__8);
				setState(97);
				((DeclaracionArray2Dim2Context)_localctx).id = match(IDEN);
				setState(98);
				match(T__6);
				setState(99);
				((DeclaracionArray2Dim2Context)_localctx).dim1 = match(INT);
				setState(100);
				match(T__4);
				setState(101);
				((DeclaracionArray2Dim2Context)_localctx).dim2 = match(INT);
				setState(102);
				match(T__7);
				}
				break;
			case 6:
				_localctx = new DeclaracionArray1Dim2Context(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(104);
				tipo();
				setState(105);
				match(T__8);
				setState(106);
				((DeclaracionArray1Dim2Context)_localctx).id = match(IDEN);
				setState(107);
				match(T__6);
				setState(108);
				((DeclaracionArray1Dim2Context)_localctx).dim1 = match(INT);
				setState(109);
				match(T__7);
				}
				break;
			case 7:
				_localctx = new DeclaracionAsigContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(111);
				tipo();
				setState(112);
				match(T__8);
				setState(113);
				((DeclaracionAsigContext)_localctx).id = match(IDEN);
				setState(114);
				match(T__11);
				setState(115);
				expresion(0);
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(116);
					((DeclaracionAsigContext)_localctx).listaDeclaracion = listaDeclaracion();
					((DeclaracionAsigContext)_localctx).e.add(((DeclaracionAsigContext)_localctx).listaDeclaracion);
					}
					}
					setState(121);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 8:
				_localctx = new DeclaracionUniqContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(122);
				tipo();
				setState(123);
				match(T__8);
				setState(124);
				((DeclaracionUniqContext)_localctx).id = match(IDEN);
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(125);
					((DeclaracionUniqContext)_localctx).listaDeclaracion = listaDeclaracion();
					((DeclaracionUniqContext)_localctx).e.add(((DeclaracionUniqContext)_localctx).listaDeclaracion);
					}
					}
					setState(130);
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
			setState(139);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new ListaDeclaracionAsigContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(133);
				match(T__4);
				setState(134);
				((ListaDeclaracionAsigContext)_localctx).id = match(IDEN);
				setState(135);
				match(T__11);
				setState(136);
				expresion(0);
				}
				break;
			case 2:
				_localctx = new ListaDeclaracionUniqContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
				match(T__4);
				setState(138);
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
		public AsignacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asignacion; }
	 
		public AsignacionContext() { }
		public void copyFrom(AsignacionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AsignacionArray1Context extends AsignacionContext {
		public Token id;
		public ExpresionContext num;
		public ExpresionContext val;
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public AsignacionArray1Context(AsignacionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitAsignacionArray1(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AsignacionArray2Context extends AsignacionContext {
		public Token id;
		public ExpresionContext num1;
		public ExpresionContext num2;
		public ExpresionContext val;
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public AsignacionArray2Context(AsignacionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitAsignacionArray2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AsignacionIdContext extends AsignacionContext {
		public Token id;
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public AsignacionIdContext(AsignacionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitAsignacionId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsignacionContext asignacion() throws RecognitionException {
		AsignacionContext _localctx = new AsignacionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_asignacion);
		try {
			setState(160);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new AsignacionIdContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(141);
				((AsignacionIdContext)_localctx).id = match(IDEN);
				setState(142);
				match(T__11);
				setState(143);
				expresion(0);
				}
				break;
			case 2:
				_localctx = new AsignacionArray1Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(144);
				((AsignacionArray1Context)_localctx).id = match(IDEN);
				setState(145);
				match(T__12);
				setState(146);
				((AsignacionArray1Context)_localctx).num = expresion(0);
				setState(147);
				match(T__13);
				setState(148);
				match(T__11);
				setState(149);
				((AsignacionArray1Context)_localctx).val = expresion(0);
				}
				break;
			case 3:
				_localctx = new AsignacionArray2Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(151);
				((AsignacionArray2Context)_localctx).id = match(IDEN);
				setState(152);
				match(T__12);
				setState(153);
				((AsignacionArray2Context)_localctx).num1 = expresion(0);
				setState(154);
				match(T__4);
				setState(155);
				((AsignacionArray2Context)_localctx).num2 = expresion(0);
				setState(156);
				match(T__13);
				setState(157);
				match(T__11);
				setState(158);
				((AsignacionArray2Context)_localctx).val = expresion(0);
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

	public static class AllocateContext extends ParserRuleContext {
		public AllocateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_allocate; }
	 
		public AllocateContext() { }
		public void copyFrom(AllocateContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DeallocateContext extends AllocateContext {
		public Token id;
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public DeallocateContext(AllocateContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDeallocate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Allocate1DimContext extends AllocateContext {
		public Token id;
		public ExpresionContext val1;
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public Allocate1DimContext(AllocateContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitAllocate1Dim(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Allocate2DimContext extends AllocateContext {
		public Token id;
		public ExpresionContext val1;
		public ExpresionContext val2;
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public Allocate2DimContext(AllocateContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitAllocate2Dim(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AllocateContext allocate() throws RecognitionException {
		AllocateContext _localctx = new AllocateContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_allocate);
		try {
			setState(184);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new Allocate2DimContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				match(T__14);
				setState(163);
				match(T__6);
				setState(164);
				((Allocate2DimContext)_localctx).id = match(IDEN);
				setState(165);
				match(T__6);
				setState(166);
				((Allocate2DimContext)_localctx).val1 = expresion(0);
				setState(167);
				match(T__4);
				setState(168);
				((Allocate2DimContext)_localctx).val2 = expresion(0);
				setState(169);
				match(T__7);
				setState(170);
				match(T__7);
				}
				break;
			case 2:
				_localctx = new Allocate1DimContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
				match(T__14);
				setState(173);
				match(T__6);
				setState(174);
				((Allocate1DimContext)_localctx).id = match(IDEN);
				setState(175);
				match(T__6);
				setState(176);
				((Allocate1DimContext)_localctx).val1 = expresion(0);
				setState(177);
				match(T__7);
				setState(178);
				match(T__7);
				}
				break;
			case 3:
				_localctx = new DeallocateContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(180);
				match(T__15);
				setState(181);
				match(T__6);
				setState(182);
				((DeallocateContext)_localctx).id = match(IDEN);
				setState(183);
				match(T__7);
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
		enterRule(_localctx, 16, RULE_print);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			((PrintContext)_localctx).p = match(T__16);
			setState(187);
			match(T__17);
			setState(188);
			match(T__4);
			setState(189);
			((PrintContext)_localctx).val = expresion(0);
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(190);
				((PrintContext)_localctx).listaPrint = listaPrint();
				((PrintContext)_localctx).e.add(((PrintContext)_localctx).listaPrint);
				}
				}
				setState(195);
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
		enterRule(_localctx, 18, RULE_listaPrint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(T__4);
			setState(197);
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
	public static class ExpresionLtContext extends ExpresionContext {
		public ExpresionContext val1;
		public Token op;
		public ExpresionContext val2;
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public ExpresionLtContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExpresionLt(this);
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
	public static class ExpresionParentesisContext extends ExpresionContext {
		public ExpresionContext val;
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public ExpresionParentesisContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExpresionParentesis(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpresionSizeContext extends ExpresionContext {
		public Token si;
		public Token val;
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public ExpresionSizeContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExpresionSize(this);
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
	public static class ExpresionOrContext extends ExpresionContext {
		public ExpresionContext val1;
		public Token op;
		public ExpresionContext val2;
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public ExpresionOrContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExpresionOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpresionArray2Context extends ExpresionContext {
		public Token val;
		public ExpresionContext pos1;
		public ExpresionContext pos2;
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public ExpresionArray2Context(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExpresionArray2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpresionNotContext extends ExpresionContext {
		public Token op;
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public ExpresionNotContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExpresionNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpresionArray1Context extends ExpresionContext {
		public Token val;
		public ExpresionContext pos;
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public ExpresionArray1Context(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExpresionArray1(this);
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
	public static class ExpresionGeContext extends ExpresionContext {
		public ExpresionContext val1;
		public Token op;
		public ExpresionContext val2;
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public ExpresionGeContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExpresionGe(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpresionNeContext extends ExpresionContext {
		public ExpresionContext val1;
		public Token op;
		public ExpresionContext val2;
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public ExpresionNeContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExpresionNe(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpresionLeContext extends ExpresionContext {
		public ExpresionContext val1;
		public Token op;
		public ExpresionContext val2;
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public ExpresionLeContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExpresionLe(this);
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
	public static class ExpresionAndContext extends ExpresionContext {
		public ExpresionContext val1;
		public Token op;
		public ExpresionContext val2;
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public ExpresionAndContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExpresionAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpresionListaExpresionContext extends ExpresionContext {
		public ExpresionContext val;
		public ListaExpresionContext listaExpresion;
		public List<ListaExpresionContext> e = new ArrayList<ListaExpresionContext>();
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public List<ListaExpresionContext> listaExpresion() {
			return getRuleContexts(ListaExpresionContext.class);
		}
		public ListaExpresionContext listaExpresion(int i) {
			return getRuleContext(ListaExpresionContext.class,i);
		}
		public ExpresionListaExpresionContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExpresionListaExpresion(this);
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
	public static class ExpresionEqContext extends ExpresionContext {
		public ExpresionContext val1;
		public Token op;
		public ExpresionContext val2;
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public ExpresionEqContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExpresionEq(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpresionGtContext extends ExpresionContext {
		public ExpresionContext val1;
		public Token op;
		public ExpresionContext val2;
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public ExpresionGtContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExpresionGt(this);
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
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_expresion, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				_localctx = new ExpresionNegativoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(200);
				((ExpresionNegativoContext)_localctx).op = match(T__18);
				setState(201);
				expresion(27);
				}
				break;
			case 2:
				{
				_localctx = new ExpresionNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(202);
				((ExpresionNotContext)_localctx).op = match(T__19);
				setState(203);
				expresion(26);
				}
				break;
			case 3:
				{
				_localctx = new ExpresionSizeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(204);
				((ExpresionSizeContext)_localctx).si = match(T__37);
				setState(205);
				match(T__6);
				setState(206);
				((ExpresionSizeContext)_localctx).val = match(IDEN);
				setState(207);
				match(T__7);
				}
				break;
			case 4:
				{
				_localctx = new ExpresionArray1Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(208);
				((ExpresionArray1Context)_localctx).val = match(IDEN);
				setState(209);
				match(T__12);
				setState(210);
				((ExpresionArray1Context)_localctx).pos = expresion(0);
				setState(211);
				match(T__13);
				}
				break;
			case 5:
				{
				_localctx = new ExpresionArray2Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(213);
				((ExpresionArray2Context)_localctx).val = match(IDEN);
				setState(214);
				match(T__12);
				setState(215);
				((ExpresionArray2Context)_localctx).pos1 = expresion(0);
				setState(216);
				match(T__4);
				setState(217);
				((ExpresionArray2Context)_localctx).pos2 = expresion(0);
				setState(218);
				match(T__13);
				}
				break;
			case 6:
				{
				_localctx = new ExpresionIdentificadorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(220);
				((ExpresionIdentificadorContext)_localctx).val = match(IDEN);
				}
				break;
			case 7:
				{
				_localctx = new ExpresionRealContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(221);
				((ExpresionRealContext)_localctx).val = match(REAL);
				}
				break;
			case 8:
				{
				_localctx = new ExpresionIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(222);
				((ExpresionIntContext)_localctx).val = match(INT);
				}
				break;
			case 9:
				{
				_localctx = new ExpresionCharContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(223);
				((ExpresionCharContext)_localctx).val = match(CHAR);
				}
				break;
			case 10:
				{
				_localctx = new ExpresionStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(224);
				((ExpresionStringContext)_localctx).val = match(STRING);
				}
				break;
			case 11:
				{
				_localctx = new ExpresionTrueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(225);
				((ExpresionTrueContext)_localctx).val = match(T__38);
				}
				break;
			case 12:
				{
				_localctx = new ExpresionFalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(226);
				((ExpresionFalseContext)_localctx).val = match(T__39);
				}
				break;
			case 13:
				{
				_localctx = new ExpresionListaExpresionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(227);
				match(T__40);
				setState(228);
				((ExpresionListaExpresionContext)_localctx).val = expresion(0);
				setState(232);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(229);
					((ExpresionListaExpresionContext)_localctx).listaExpresion = listaExpresion();
					((ExpresionListaExpresionContext)_localctx).e.add(((ExpresionListaExpresionContext)_localctx).listaExpresion);
					}
					}
					setState(234);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(235);
				match(T__41);
				}
				break;
			case 14:
				{
				_localctx = new ExpresionParentesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(237);
				match(T__6);
				setState(238);
				((ExpresionParentesisContext)_localctx).val = expresion(0);
				setState(239);
				match(T__7);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(284);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(282);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new ExpresionPotenciaContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionPotenciaContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(243);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(244);
						((ExpresionPotenciaContext)_localctx).op = match(T__20);
						setState(245);
						((ExpresionPotenciaContext)_localctx).val2 = expresion(26);
						}
						break;
					case 2:
						{
						_localctx = new ExpresionMultiplicacionContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionMultiplicacionContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(246);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(247);
						((ExpresionMultiplicacionContext)_localctx).op = match(T__17);
						setState(248);
						((ExpresionMultiplicacionContext)_localctx).val2 = expresion(25);
						}
						break;
					case 3:
						{
						_localctx = new ExpresionDivisionContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionDivisionContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(249);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(250);
						((ExpresionDivisionContext)_localctx).op = match(T__21);
						setState(251);
						((ExpresionDivisionContext)_localctx).val2 = expresion(24);
						}
						break;
					case 4:
						{
						_localctx = new ExpresionSumaContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionSumaContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(252);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(253);
						((ExpresionSumaContext)_localctx).op = match(T__22);
						setState(254);
						((ExpresionSumaContext)_localctx).val2 = expresion(23);
						}
						break;
					case 5:
						{
						_localctx = new ExpresionRestaContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionRestaContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(255);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(256);
						((ExpresionRestaContext)_localctx).op = match(T__18);
						setState(257);
						((ExpresionRestaContext)_localctx).val2 = expresion(22);
						}
						break;
					case 6:
						{
						_localctx = new ExpresionEqContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionEqContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(258);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(259);
						((ExpresionEqContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__23 || _la==T__24) ) {
							((ExpresionEqContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(260);
						((ExpresionEqContext)_localctx).val2 = expresion(21);
						}
						break;
					case 7:
						{
						_localctx = new ExpresionNeContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionNeContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(261);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(262);
						((ExpresionNeContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__25 || _la==T__26) ) {
							((ExpresionNeContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(263);
						((ExpresionNeContext)_localctx).val2 = expresion(20);
						}
						break;
					case 8:
						{
						_localctx = new ExpresionGeContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionGeContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(264);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(265);
						((ExpresionGeContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__27 || _la==T__28) ) {
							((ExpresionGeContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(266);
						((ExpresionGeContext)_localctx).val2 = expresion(19);
						}
						break;
					case 9:
						{
						_localctx = new ExpresionGtContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionGtContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(267);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(268);
						((ExpresionGtContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__29 || _la==T__30) ) {
							((ExpresionGtContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(269);
						((ExpresionGtContext)_localctx).val2 = expresion(18);
						}
						break;
					case 10:
						{
						_localctx = new ExpresionLeContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionLeContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(270);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(271);
						((ExpresionLeContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__31 || _la==T__32) ) {
							((ExpresionLeContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(272);
						((ExpresionLeContext)_localctx).val2 = expresion(17);
						}
						break;
					case 11:
						{
						_localctx = new ExpresionLtContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionLtContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(273);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(274);
						((ExpresionLtContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__33 || _la==T__34) ) {
							((ExpresionLtContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(275);
						((ExpresionLtContext)_localctx).val2 = expresion(16);
						}
						break;
					case 12:
						{
						_localctx = new ExpresionAndContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionAndContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(276);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(277);
						((ExpresionAndContext)_localctx).op = match(T__35);
						setState(278);
						((ExpresionAndContext)_localctx).val2 = expresion(15);
						}
						break;
					case 13:
						{
						_localctx = new ExpresionOrContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionOrContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(279);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(280);
						((ExpresionOrContext)_localctx).op = match(T__36);
						setState(281);
						((ExpresionOrContext)_localctx).val2 = expresion(14);
						}
						break;
					}
					} 
				}
				setState(286);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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

	public static class ListaExpresionContext extends ParserRuleContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public ListaExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaExpresion; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitListaExpresion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListaExpresionContext listaExpresion() throws RecognitionException {
		ListaExpresionContext _localctx = new ListaExpresionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_listaExpresion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			match(T__4);
			setState(288);
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
		enterRule(_localctx, 24, RULE_tipo);
		try {
			setState(295);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__42:
				_localctx = new TipoIntegerContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(290);
				match(T__42);
				}
				break;
			case T__43:
				_localctx = new TipoRealContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(291);
				match(T__43);
				}
				break;
			case T__44:
				_localctx = new TipoComplexContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(292);
				match(T__44);
				}
				break;
			case T__45:
				_localctx = new TipoCharacterContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(293);
				match(T__45);
				}
				break;
			case T__46:
				_localctx = new TipoLogicalContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(294);
				match(T__46);
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
		case 10:
			return expresion_sempred((ExpresionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expresion_sempred(ExpresionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 25);
		case 1:
			return precpred(_ctx, 24);
		case 2:
			return precpred(_ctx, 23);
		case 3:
			return precpred(_ctx, 22);
		case 4:
			return precpred(_ctx, 21);
		case 5:
			return precpred(_ctx, 20);
		case 6:
			return precpred(_ctx, 19);
		case 7:
			return precpred(_ctx, 18);
		case 8:
			return precpred(_ctx, 17);
		case 9:
			return precpred(_ctx, 16);
		case 10:
			return precpred(_ctx, 15);
		case 11:
			return precpred(_ctx, 14);
		case 12:
			return precpred(_ctx, 13);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00017\u012a\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0005\u0001"+
		"\u001f\b\u0001\n\u0001\f\u0001\"\t\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0005\u0002)\b\u0002\n\u0002\f\u0002,\t"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u00036\b\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0005\u0004v\b\u0004\n\u0004\f\u0004y\t\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0005\u0004\u007f\b\u0004\n\u0004\f\u0004"+
		"\u0082\t\u0004\u0003\u0004\u0084\b\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u008c\b\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0003\u0006\u00a1\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007\u00b9\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0005\b\u00c0\b\b\n\b\f\b\u00c3\t\b\u0001\t\u0001\t\u0001\t\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0005\n\u00e7\b\n\n\n\f\n\u00ea\t\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00f2\b\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0005\n\u011b\b\n\n\n\f\n\u011e\t\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u0128\b\f"+
		"\u0001\f\u0000\u0001\u0014\r\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u0000\u0006\u0001\u0000\u0018\u0019\u0001\u0000"+
		"\u001a\u001b\u0001\u0000\u001c\u001d\u0001\u0000\u001e\u001f\u0001\u0000"+
		" !\u0001\u0000\"#\u014f\u0000\u001a\u0001\u0000\u0000\u0000\u0002 \u0001"+
		"\u0000\u0000\u0000\u0004#\u0001\u0000\u0000\u0000\u00065\u0001\u0000\u0000"+
		"\u0000\b\u0083\u0001\u0000\u0000\u0000\n\u008b\u0001\u0000\u0000\u0000"+
		"\f\u00a0\u0001\u0000\u0000\u0000\u000e\u00b8\u0001\u0000\u0000\u0000\u0010"+
		"\u00ba\u0001\u0000\u0000\u0000\u0012\u00c4\u0001\u0000\u0000\u0000\u0014"+
		"\u00f1\u0001\u0000\u0000\u0000\u0016\u011f\u0001\u0000\u0000\u0000\u0018"+
		"\u0127\u0001\u0000\u0000\u0000\u001a\u001b\u0003\u0002\u0001\u0000\u001b"+
		"\u001c\u0005\u0000\u0000\u0001\u001c\u0001\u0001\u0000\u0000\u0000\u001d"+
		"\u001f\u0003\u0004\u0002\u0000\u001e\u001d\u0001\u0000\u0000\u0000\u001f"+
		"\"\u0001\u0000\u0000\u0000 \u001e\u0001\u0000\u0000\u0000 !\u0001\u0000"+
		"\u0000\u0000!\u0003\u0001\u0000\u0000\u0000\" \u0001\u0000\u0000\u0000"+
		"#$\u0005\u0001\u0000\u0000$%\u00053\u0000\u0000%&\u0005\u0002\u0000\u0000"+
		"&*\u0005\u0003\u0000\u0000\')\u0003\u0006\u0003\u0000(\'\u0001\u0000\u0000"+
		"\u0000),\u0001\u0000\u0000\u0000*(\u0001\u0000\u0000\u0000*+\u0001\u0000"+
		"\u0000\u0000+-\u0001\u0000\u0000\u0000,*\u0001\u0000\u0000\u0000-.\u0005"+
		"\u0004\u0000\u0000./\u0005\u0001\u0000\u0000/0\u00053\u0000\u00000\u0005"+
		"\u0001\u0000\u0000\u000016\u0003\b\u0004\u000026\u0003\f\u0006\u00003"+
		"6\u0003\u000e\u0007\u000046\u0003\u0010\b\u000051\u0001\u0000\u0000\u0000"+
		"52\u0001\u0000\u0000\u000053\u0001\u0000\u0000\u000054\u0001\u0000\u0000"+
		"\u00006\u0007\u0001\u0000\u0000\u000078\u0003\u0018\f\u000089\u0005\u0005"+
		"\u0000\u00009:\u0005\u0006\u0000\u0000:;\u0005\u0007\u0000\u0000;<\u0005"+
		"0\u0000\u0000<=\u0005\u0005\u0000\u0000=>\u00050\u0000\u0000>?\u0005\b"+
		"\u0000\u0000?@\u0005\t\u0000\u0000@A\u00053\u0000\u0000A\u0084\u0001\u0000"+
		"\u0000\u0000BC\u0003\u0018\f\u0000CD\u0005\u0005\u0000\u0000DE\u0005\u0006"+
		"\u0000\u0000EF\u0005\u0007\u0000\u0000FG\u00050\u0000\u0000GH\u0005\b"+
		"\u0000\u0000HI\u0005\t\u0000\u0000IJ\u00053\u0000\u0000J\u0084\u0001\u0000"+
		"\u0000\u0000KL\u0003\u0018\f\u0000LM\u0005\u0005\u0000\u0000MN\u0005\n"+
		"\u0000\u0000NO\u0005\t\u0000\u0000OP\u00053\u0000\u0000PQ\u0005\u0007"+
		"\u0000\u0000QR\u0005\u000b\u0000\u0000RS\u0005\u0005\u0000\u0000ST\u0005"+
		"\u000b\u0000\u0000TU\u0005\b\u0000\u0000U\u0084\u0001\u0000\u0000\u0000"+
		"VW\u0003\u0018\f\u0000WX\u0005\u0005\u0000\u0000XY\u0005\n\u0000\u0000"+
		"YZ\u0005\t\u0000\u0000Z[\u00053\u0000\u0000[\\\u0005\u0007\u0000\u0000"+
		"\\]\u0005\u000b\u0000\u0000]^\u0005\b\u0000\u0000^\u0084\u0001\u0000\u0000"+
		"\u0000_`\u0003\u0018\f\u0000`a\u0005\t\u0000\u0000ab\u00053\u0000\u0000"+
		"bc\u0005\u0007\u0000\u0000cd\u00050\u0000\u0000de\u0005\u0005\u0000\u0000"+
		"ef\u00050\u0000\u0000fg\u0005\b\u0000\u0000g\u0084\u0001\u0000\u0000\u0000"+
		"hi\u0003\u0018\f\u0000ij\u0005\t\u0000\u0000jk\u00053\u0000\u0000kl\u0005"+
		"\u0007\u0000\u0000lm\u00050\u0000\u0000mn\u0005\b\u0000\u0000n\u0084\u0001"+
		"\u0000\u0000\u0000op\u0003\u0018\f\u0000pq\u0005\t\u0000\u0000qr\u0005"+
		"3\u0000\u0000rs\u0005\f\u0000\u0000sw\u0003\u0014\n\u0000tv\u0003\n\u0005"+
		"\u0000ut\u0001\u0000\u0000\u0000vy\u0001\u0000\u0000\u0000wu\u0001\u0000"+
		"\u0000\u0000wx\u0001\u0000\u0000\u0000x\u0084\u0001\u0000\u0000\u0000"+
		"yw\u0001\u0000\u0000\u0000z{\u0003\u0018\f\u0000{|\u0005\t\u0000\u0000"+
		"|\u0080\u00053\u0000\u0000}\u007f\u0003\n\u0005\u0000~}\u0001\u0000\u0000"+
		"\u0000\u007f\u0082\u0001\u0000\u0000\u0000\u0080~\u0001\u0000\u0000\u0000"+
		"\u0080\u0081\u0001\u0000\u0000\u0000\u0081\u0084\u0001\u0000\u0000\u0000"+
		"\u0082\u0080\u0001\u0000\u0000\u0000\u00837\u0001\u0000\u0000\u0000\u0083"+
		"B\u0001\u0000\u0000\u0000\u0083K\u0001\u0000\u0000\u0000\u0083V\u0001"+
		"\u0000\u0000\u0000\u0083_\u0001\u0000\u0000\u0000\u0083h\u0001\u0000\u0000"+
		"\u0000\u0083o\u0001\u0000\u0000\u0000\u0083z\u0001\u0000\u0000\u0000\u0084"+
		"\t\u0001\u0000\u0000\u0000\u0085\u0086\u0005\u0005\u0000\u0000\u0086\u0087"+
		"\u00053\u0000\u0000\u0087\u0088\u0005\f\u0000\u0000\u0088\u008c\u0003"+
		"\u0014\n\u0000\u0089\u008a\u0005\u0005\u0000\u0000\u008a\u008c\u00053"+
		"\u0000\u0000\u008b\u0085\u0001\u0000\u0000\u0000\u008b\u0089\u0001\u0000"+
		"\u0000\u0000\u008c\u000b\u0001\u0000\u0000\u0000\u008d\u008e\u00053\u0000"+
		"\u0000\u008e\u008f\u0005\f\u0000\u0000\u008f\u00a1\u0003\u0014\n\u0000"+
		"\u0090\u0091\u00053\u0000\u0000\u0091\u0092\u0005\r\u0000\u0000\u0092"+
		"\u0093\u0003\u0014\n\u0000\u0093\u0094\u0005\u000e\u0000\u0000\u0094\u0095"+
		"\u0005\f\u0000\u0000\u0095\u0096\u0003\u0014\n\u0000\u0096\u00a1\u0001"+
		"\u0000\u0000\u0000\u0097\u0098\u00053\u0000\u0000\u0098\u0099\u0005\r"+
		"\u0000\u0000\u0099\u009a\u0003\u0014\n\u0000\u009a\u009b\u0005\u0005\u0000"+
		"\u0000\u009b\u009c\u0003\u0014\n\u0000\u009c\u009d\u0005\u000e\u0000\u0000"+
		"\u009d\u009e\u0005\f\u0000\u0000\u009e\u009f\u0003\u0014\n\u0000\u009f"+
		"\u00a1\u0001\u0000\u0000\u0000\u00a0\u008d\u0001\u0000\u0000\u0000\u00a0"+
		"\u0090\u0001\u0000\u0000\u0000\u00a0\u0097\u0001\u0000\u0000\u0000\u00a1"+
		"\r\u0001\u0000\u0000\u0000\u00a2\u00a3\u0005\u000f\u0000\u0000\u00a3\u00a4"+
		"\u0005\u0007\u0000\u0000\u00a4\u00a5\u00053\u0000\u0000\u00a5\u00a6\u0005"+
		"\u0007\u0000\u0000\u00a6\u00a7\u0003\u0014\n\u0000\u00a7\u00a8\u0005\u0005"+
		"\u0000\u0000\u00a8\u00a9\u0003\u0014\n\u0000\u00a9\u00aa\u0005\b\u0000"+
		"\u0000\u00aa\u00ab\u0005\b\u0000\u0000\u00ab\u00b9\u0001\u0000\u0000\u0000"+
		"\u00ac\u00ad\u0005\u000f\u0000\u0000\u00ad\u00ae\u0005\u0007\u0000\u0000"+
		"\u00ae\u00af\u00053\u0000\u0000\u00af\u00b0\u0005\u0007\u0000\u0000\u00b0"+
		"\u00b1\u0003\u0014\n\u0000\u00b1\u00b2\u0005\b\u0000\u0000\u00b2\u00b3"+
		"\u0005\b\u0000\u0000\u00b3\u00b9\u0001\u0000\u0000\u0000\u00b4\u00b5\u0005"+
		"\u0010\u0000\u0000\u00b5\u00b6\u0005\u0007\u0000\u0000\u00b6\u00b7\u0005"+
		"3\u0000\u0000\u00b7\u00b9\u0005\b\u0000\u0000\u00b8\u00a2\u0001\u0000"+
		"\u0000\u0000\u00b8\u00ac\u0001\u0000\u0000\u0000\u00b8\u00b4\u0001\u0000"+
		"\u0000\u0000\u00b9\u000f\u0001\u0000\u0000\u0000\u00ba\u00bb\u0005\u0011"+
		"\u0000\u0000\u00bb\u00bc\u0005\u0012\u0000\u0000\u00bc\u00bd\u0005\u0005"+
		"\u0000\u0000\u00bd\u00c1\u0003\u0014\n\u0000\u00be\u00c0\u0003\u0012\t"+
		"\u0000\u00bf\u00be\u0001\u0000\u0000\u0000\u00c0\u00c3\u0001\u0000\u0000"+
		"\u0000\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000"+
		"\u0000\u00c2\u0011\u0001\u0000\u0000\u0000\u00c3\u00c1\u0001\u0000\u0000"+
		"\u0000\u00c4\u00c5\u0005\u0005\u0000\u0000\u00c5\u00c6\u0003\u0014\n\u0000"+
		"\u00c6\u0013\u0001\u0000\u0000\u0000\u00c7\u00c8\u0006\n\uffff\uffff\u0000"+
		"\u00c8\u00c9\u0005\u0013\u0000\u0000\u00c9\u00f2\u0003\u0014\n\u001b\u00ca"+
		"\u00cb\u0005\u0014\u0000\u0000\u00cb\u00f2\u0003\u0014\n\u001a\u00cc\u00cd"+
		"\u0005&\u0000\u0000\u00cd\u00ce\u0005\u0007\u0000\u0000\u00ce\u00cf\u0005"+
		"3\u0000\u0000\u00cf\u00f2\u0005\b\u0000\u0000\u00d0\u00d1\u00053\u0000"+
		"\u0000\u00d1\u00d2\u0005\r\u0000\u0000\u00d2\u00d3\u0003\u0014\n\u0000"+
		"\u00d3\u00d4\u0005\u000e\u0000\u0000\u00d4\u00f2\u0001\u0000\u0000\u0000"+
		"\u00d5\u00d6\u00053\u0000\u0000\u00d6\u00d7\u0005\r\u0000\u0000\u00d7"+
		"\u00d8\u0003\u0014\n\u0000\u00d8\u00d9\u0005\u0005\u0000\u0000\u00d9\u00da"+
		"\u0003\u0014\n\u0000\u00da\u00db\u0005\u000e\u0000\u0000\u00db\u00f2\u0001"+
		"\u0000\u0000\u0000\u00dc\u00f2\u00053\u0000\u0000\u00dd\u00f2\u00051\u0000"+
		"\u0000\u00de\u00f2\u00050\u0000\u0000\u00df\u00f2\u00054\u0000\u0000\u00e0"+
		"\u00f2\u00055\u0000\u0000\u00e1\u00f2\u0005\'\u0000\u0000\u00e2\u00f2"+
		"\u0005(\u0000\u0000\u00e3\u00e4\u0005)\u0000\u0000\u00e4\u00e8\u0003\u0014"+
		"\n\u0000\u00e5\u00e7\u0003\u0016\u000b\u0000\u00e6\u00e5\u0001\u0000\u0000"+
		"\u0000\u00e7\u00ea\u0001\u0000\u0000\u0000\u00e8\u00e6\u0001\u0000\u0000"+
		"\u0000\u00e8\u00e9\u0001\u0000\u0000\u0000\u00e9\u00eb\u0001\u0000\u0000"+
		"\u0000\u00ea\u00e8\u0001\u0000\u0000\u0000\u00eb\u00ec\u0005*\u0000\u0000"+
		"\u00ec\u00f2\u0001\u0000\u0000\u0000\u00ed\u00ee\u0005\u0007\u0000\u0000"+
		"\u00ee\u00ef\u0003\u0014\n\u0000\u00ef\u00f0\u0005\b\u0000\u0000\u00f0"+
		"\u00f2\u0001\u0000\u0000\u0000\u00f1\u00c7\u0001\u0000\u0000\u0000\u00f1"+
		"\u00ca\u0001\u0000\u0000\u0000\u00f1\u00cc\u0001\u0000\u0000\u0000\u00f1"+
		"\u00d0\u0001\u0000\u0000\u0000\u00f1\u00d5\u0001\u0000\u0000\u0000\u00f1"+
		"\u00dc\u0001\u0000\u0000\u0000\u00f1\u00dd\u0001\u0000\u0000\u0000\u00f1"+
		"\u00de\u0001\u0000\u0000\u0000\u00f1\u00df\u0001\u0000\u0000\u0000\u00f1"+
		"\u00e0\u0001\u0000\u0000\u0000\u00f1\u00e1\u0001\u0000\u0000\u0000\u00f1"+
		"\u00e2\u0001\u0000\u0000\u0000\u00f1\u00e3\u0001\u0000\u0000\u0000\u00f1"+
		"\u00ed\u0001\u0000\u0000\u0000\u00f2\u011c\u0001\u0000\u0000\u0000\u00f3"+
		"\u00f4\n\u0019\u0000\u0000\u00f4\u00f5\u0005\u0015\u0000\u0000\u00f5\u011b"+
		"\u0003\u0014\n\u001a\u00f6\u00f7\n\u0018\u0000\u0000\u00f7\u00f8\u0005"+
		"\u0012\u0000\u0000\u00f8\u011b\u0003\u0014\n\u0019\u00f9\u00fa\n\u0017"+
		"\u0000\u0000\u00fa\u00fb\u0005\u0016\u0000\u0000\u00fb\u011b\u0003\u0014"+
		"\n\u0018\u00fc\u00fd\n\u0016\u0000\u0000\u00fd\u00fe\u0005\u0017\u0000"+
		"\u0000\u00fe\u011b\u0003\u0014\n\u0017\u00ff\u0100\n\u0015\u0000\u0000"+
		"\u0100\u0101\u0005\u0013\u0000\u0000\u0101\u011b\u0003\u0014\n\u0016\u0102"+
		"\u0103\n\u0014\u0000\u0000\u0103\u0104\u0007\u0000\u0000\u0000\u0104\u011b"+
		"\u0003\u0014\n\u0015\u0105\u0106\n\u0013\u0000\u0000\u0106\u0107\u0007"+
		"\u0001\u0000\u0000\u0107\u011b\u0003\u0014\n\u0014\u0108\u0109\n\u0012"+
		"\u0000\u0000\u0109\u010a\u0007\u0002\u0000\u0000\u010a\u011b\u0003\u0014"+
		"\n\u0013\u010b\u010c\n\u0011\u0000\u0000\u010c\u010d\u0007\u0003\u0000"+
		"\u0000\u010d\u011b\u0003\u0014\n\u0012\u010e\u010f\n\u0010\u0000\u0000"+
		"\u010f\u0110\u0007\u0004\u0000\u0000\u0110\u011b\u0003\u0014\n\u0011\u0111"+
		"\u0112\n\u000f\u0000\u0000\u0112\u0113\u0007\u0005\u0000\u0000\u0113\u011b"+
		"\u0003\u0014\n\u0010\u0114\u0115\n\u000e\u0000\u0000\u0115\u0116\u0005"+
		"$\u0000\u0000\u0116\u011b\u0003\u0014\n\u000f\u0117\u0118\n\r\u0000\u0000"+
		"\u0118\u0119\u0005%\u0000\u0000\u0119\u011b\u0003\u0014\n\u000e\u011a"+
		"\u00f3\u0001\u0000\u0000\u0000\u011a\u00f6\u0001\u0000\u0000\u0000\u011a"+
		"\u00f9\u0001\u0000\u0000\u0000\u011a\u00fc\u0001\u0000\u0000\u0000\u011a"+
		"\u00ff\u0001\u0000\u0000\u0000\u011a\u0102\u0001\u0000\u0000\u0000\u011a"+
		"\u0105\u0001\u0000\u0000\u0000\u011a\u0108\u0001\u0000\u0000\u0000\u011a"+
		"\u010b\u0001\u0000\u0000\u0000\u011a\u010e\u0001\u0000\u0000\u0000\u011a"+
		"\u0111\u0001\u0000\u0000\u0000\u011a\u0114\u0001\u0000\u0000\u0000\u011a"+
		"\u0117\u0001\u0000\u0000\u0000\u011b\u011e\u0001\u0000\u0000\u0000\u011c"+
		"\u011a\u0001\u0000\u0000\u0000\u011c\u011d\u0001\u0000\u0000\u0000\u011d"+
		"\u0015\u0001\u0000\u0000\u0000\u011e\u011c\u0001\u0000\u0000\u0000\u011f"+
		"\u0120\u0005\u0005\u0000\u0000\u0120\u0121\u0003\u0014\n\u0000\u0121\u0017"+
		"\u0001\u0000\u0000\u0000\u0122\u0128\u0005+\u0000\u0000\u0123\u0128\u0005"+
		",\u0000\u0000\u0124\u0128\u0005-\u0000\u0000\u0125\u0128\u0005.\u0000"+
		"\u0000\u0126\u0128\u0005/\u0000\u0000\u0127\u0122\u0001\u0000\u0000\u0000"+
		"\u0127\u0123\u0001\u0000\u0000\u0000\u0127\u0124\u0001\u0000\u0000\u0000"+
		"\u0127\u0125\u0001\u0000\u0000\u0000\u0127\u0126\u0001\u0000\u0000\u0000"+
		"\u0128\u0019\u0001\u0000\u0000\u0000\u000f *5w\u0080\u0083\u008b\u00a0"+
		"\u00b8\u00c1\u00e8\u00f1\u011a\u011c\u0127";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}