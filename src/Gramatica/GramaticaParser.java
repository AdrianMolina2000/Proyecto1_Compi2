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
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, INT=55, REAL=56, COMPLEX=57, IDEN=58, CHAR=59, STRING=60, 
		WS=61, COMENTARIO=62;
	public static final int
		RULE_start = 0, RULE_listaInstrucciones = 1, RULE_instrucciones = 2, RULE_instrucciones2 = 3, 
		RULE_declaracion = 4, RULE_listaDeclaracion = 5, RULE_asignacion = 6, 
		RULE_allocate = 7, RULE_print = 8, RULE_listaPrint = 9, RULE_if = 10, 
		RULE_elseif = 11, RULE_do = 12, RULE_exit = 13, RULE_cycle = 14, RULE_expresion = 15, 
		RULE_listaExpresion = 16, RULE_tipo = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "listaInstrucciones", "instrucciones", "instrucciones2", "declaracion", 
			"listaDeclaracion", "asignacion", "allocate", "print", "listaPrint", 
			"if", "elseif", "do", "exit", "cycle", "expresion", "listaExpresion", 
			"tipo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'program'", "'implicit'", "'none'", "'end'", "','", "'dimension'", 
			"'('", "')'", "'::'", "'allocatable'", "':'", "'='", "'['", "']'", "'allocate'", 
			"'deallocate'", "'print'", "'*'", "'if'", "'then'", "'else'", "'do'", 
			"'while'", "'exit'", "'cycle'", "'-'", "'.not.'", "'**'", "'/'", "'+'", 
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
			null, null, null, null, null, null, null, "INT", "REAL", "COMPLEX", "IDEN", 
			"CHAR", "STRING", "WS", "COMENTARIO"
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
			setState(36);
			listaInstrucciones();
			setState(37);
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
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(39);
				((ListaInstruccionesContext)_localctx).instrucciones = instrucciones();
				((ListaInstruccionesContext)_localctx).e.add(((ListaInstruccionesContext)_localctx).instrucciones);
				}
				}
				setState(44);
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
			setState(45);
			match(T__0);
			setState(46);
			((InstruccionesProgramContext)_localctx).id1 = match(IDEN);
			setState(47);
			match(T__1);
			setState(48);
			match(T__2);
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << IDEN))) != 0)) {
				{
				{
				setState(49);
				((InstruccionesProgramContext)_localctx).instrucciones2 = instrucciones2();
				((InstruccionesProgramContext)_localctx).e.add(((InstruccionesProgramContext)_localctx).instrucciones2);
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(55);
			match(T__3);
			setState(56);
			match(T__0);
			setState(57);
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
	public static class Instrucciones2IfContext extends Instrucciones2Context {
		public IfContext if_() {
			return getRuleContext(IfContext.class,0);
		}
		public Instrucciones2IfContext(Instrucciones2Context ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitInstrucciones2If(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Instrucciones2ExitContext extends Instrucciones2Context {
		public ExitContext exit() {
			return getRuleContext(ExitContext.class,0);
		}
		public Instrucciones2ExitContext(Instrucciones2Context ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitInstrucciones2Exit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Instrucciones2DoContext extends Instrucciones2Context {
		public DoContext do_() {
			return getRuleContext(DoContext.class,0);
		}
		public Instrucciones2DoContext(Instrucciones2Context ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitInstrucciones2Do(this);
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
	public static class Instrucciones2CycleContext extends Instrucciones2Context {
		public CycleContext cycle() {
			return getRuleContext(CycleContext.class,0);
		}
		public Instrucciones2CycleContext(Instrucciones2Context ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitInstrucciones2Cycle(this);
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
			setState(67);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new Instrucciones2DeclaracionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				declaracion();
				}
				break;
			case 2:
				_localctx = new Instrucciones2AsignacionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				asignacion();
				}
				break;
			case 3:
				_localctx = new Instrucciones2AllocateContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(61);
				allocate();
				}
				break;
			case 4:
				_localctx = new Instrucciones2PrintContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(62);
				print();
				}
				break;
			case 5:
				_localctx = new Instrucciones2IfContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(63);
				if_();
				}
				break;
			case 6:
				_localctx = new Instrucciones2DoContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(64);
				do_();
				}
				break;
			case 7:
				_localctx = new Instrucciones2ExitContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(65);
				exit();
				}
				break;
			case 8:
				_localctx = new Instrucciones2CycleContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(66);
				cycle();
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
		public ExpresionContext dim1;
		public ExpresionContext dim2;
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
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
		public ExpresionContext dim1;
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public DeclaracionArray1Dim2Context(DeclaracionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDeclaracionArray1Dim2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeclaracionArray2DimContext extends DeclaracionContext {
		public ExpresionContext dim1;
		public ExpresionContext dim2;
		public Token id;
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
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
		public ExpresionContext dim1;
		public Token id;
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
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
			setState(145);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new DeclaracionArray2DimContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				tipo();
				setState(70);
				match(T__4);
				setState(71);
				match(T__5);
				setState(72);
				match(T__6);
				setState(73);
				((DeclaracionArray2DimContext)_localctx).dim1 = expresion(0);
				setState(74);
				match(T__4);
				setState(75);
				((DeclaracionArray2DimContext)_localctx).dim2 = expresion(0);
				setState(76);
				match(T__7);
				setState(77);
				match(T__8);
				setState(78);
				((DeclaracionArray2DimContext)_localctx).id = match(IDEN);
				}
				break;
			case 2:
				_localctx = new DeclaracionArray1DimContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				tipo();
				setState(81);
				match(T__4);
				setState(82);
				match(T__5);
				setState(83);
				match(T__6);
				setState(84);
				((DeclaracionArray1DimContext)_localctx).dim1 = expresion(0);
				setState(85);
				match(T__7);
				setState(86);
				match(T__8);
				setState(87);
				((DeclaracionArray1DimContext)_localctx).id = match(IDEN);
				}
				break;
			case 3:
				_localctx = new DeclaracionAllocatable2DimContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(89);
				tipo();
				setState(90);
				match(T__4);
				setState(91);
				match(T__9);
				setState(92);
				match(T__8);
				setState(93);
				((DeclaracionAllocatable2DimContext)_localctx).id = match(IDEN);
				setState(94);
				match(T__6);
				setState(95);
				match(T__10);
				setState(96);
				match(T__4);
				setState(97);
				match(T__10);
				setState(98);
				match(T__7);
				}
				break;
			case 4:
				_localctx = new DeclaracionAllocatable1DimContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(100);
				tipo();
				setState(101);
				match(T__4);
				setState(102);
				match(T__9);
				setState(103);
				match(T__8);
				setState(104);
				((DeclaracionAllocatable1DimContext)_localctx).id = match(IDEN);
				setState(105);
				match(T__6);
				setState(106);
				match(T__10);
				setState(107);
				match(T__7);
				}
				break;
			case 5:
				_localctx = new DeclaracionArray2Dim2Context(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(109);
				tipo();
				setState(110);
				match(T__8);
				setState(111);
				((DeclaracionArray2Dim2Context)_localctx).id = match(IDEN);
				setState(112);
				match(T__6);
				setState(113);
				((DeclaracionArray2Dim2Context)_localctx).dim1 = expresion(0);
				setState(114);
				match(T__4);
				setState(115);
				((DeclaracionArray2Dim2Context)_localctx).dim2 = expresion(0);
				setState(116);
				match(T__7);
				}
				break;
			case 6:
				_localctx = new DeclaracionArray1Dim2Context(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(118);
				tipo();
				setState(119);
				match(T__8);
				setState(120);
				((DeclaracionArray1Dim2Context)_localctx).id = match(IDEN);
				setState(121);
				match(T__6);
				setState(122);
				((DeclaracionArray1Dim2Context)_localctx).dim1 = expresion(0);
				setState(123);
				match(T__7);
				}
				break;
			case 7:
				_localctx = new DeclaracionAsigContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(125);
				tipo();
				setState(126);
				match(T__8);
				setState(127);
				((DeclaracionAsigContext)_localctx).id = match(IDEN);
				setState(128);
				match(T__11);
				setState(129);
				expresion(0);
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(130);
					((DeclaracionAsigContext)_localctx).listaDeclaracion = listaDeclaracion();
					((DeclaracionAsigContext)_localctx).e.add(((DeclaracionAsigContext)_localctx).listaDeclaracion);
					}
					}
					setState(135);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 8:
				_localctx = new DeclaracionUniqContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(136);
				tipo();
				setState(137);
				match(T__8);
				setState(138);
				((DeclaracionUniqContext)_localctx).id = match(IDEN);
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(139);
					((DeclaracionUniqContext)_localctx).listaDeclaracion = listaDeclaracion();
					((DeclaracionUniqContext)_localctx).e.add(((DeclaracionUniqContext)_localctx).listaDeclaracion);
					}
					}
					setState(144);
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
			setState(153);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new ListaDeclaracionAsigContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(147);
				match(T__4);
				setState(148);
				((ListaDeclaracionAsigContext)_localctx).id = match(IDEN);
				setState(149);
				match(T__11);
				setState(150);
				expresion(0);
				}
				break;
			case 2:
				_localctx = new ListaDeclaracionUniqContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(151);
				match(T__4);
				setState(152);
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
			setState(174);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new AsignacionIdContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				((AsignacionIdContext)_localctx).id = match(IDEN);
				setState(156);
				match(T__11);
				setState(157);
				expresion(0);
				}
				break;
			case 2:
				_localctx = new AsignacionArray1Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				((AsignacionArray1Context)_localctx).id = match(IDEN);
				setState(159);
				match(T__12);
				setState(160);
				((AsignacionArray1Context)_localctx).num = expresion(0);
				setState(161);
				match(T__13);
				setState(162);
				match(T__11);
				setState(163);
				((AsignacionArray1Context)_localctx).val = expresion(0);
				}
				break;
			case 3:
				_localctx = new AsignacionArray2Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(165);
				((AsignacionArray2Context)_localctx).id = match(IDEN);
				setState(166);
				match(T__12);
				setState(167);
				((AsignacionArray2Context)_localctx).num1 = expresion(0);
				setState(168);
				match(T__4);
				setState(169);
				((AsignacionArray2Context)_localctx).num2 = expresion(0);
				setState(170);
				match(T__13);
				setState(171);
				match(T__11);
				setState(172);
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
			setState(198);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new Allocate2DimContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(176);
				match(T__14);
				setState(177);
				match(T__6);
				setState(178);
				((Allocate2DimContext)_localctx).id = match(IDEN);
				setState(179);
				match(T__6);
				setState(180);
				((Allocate2DimContext)_localctx).val1 = expresion(0);
				setState(181);
				match(T__4);
				setState(182);
				((Allocate2DimContext)_localctx).val2 = expresion(0);
				setState(183);
				match(T__7);
				setState(184);
				match(T__7);
				}
				break;
			case 2:
				_localctx = new Allocate1DimContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(186);
				match(T__14);
				setState(187);
				match(T__6);
				setState(188);
				((Allocate1DimContext)_localctx).id = match(IDEN);
				setState(189);
				match(T__6);
				setState(190);
				((Allocate1DimContext)_localctx).val1 = expresion(0);
				setState(191);
				match(T__7);
				setState(192);
				match(T__7);
				}
				break;
			case 3:
				_localctx = new DeallocateContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(194);
				match(T__15);
				setState(195);
				match(T__6);
				setState(196);
				((DeallocateContext)_localctx).id = match(IDEN);
				setState(197);
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
			setState(200);
			((PrintContext)_localctx).p = match(T__16);
			setState(201);
			match(T__17);
			setState(202);
			match(T__4);
			setState(203);
			((PrintContext)_localctx).val = expresion(0);
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(204);
				((PrintContext)_localctx).listaPrint = listaPrint();
				((PrintContext)_localctx).e.add(((PrintContext)_localctx).listaPrint);
				}
				}
				setState(209);
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
			setState(210);
			match(T__4);
			setState(211);
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

	public static class IfContext extends ParserRuleContext {
		public IfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if; }
	 
		public IfContext() { }
		public void copyFrom(IfContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IfNormalContext extends IfContext {
		public Token id;
		public ExpresionContext cond;
		public Instrucciones2Context instrucciones2;
		public List<Instrucciones2Context> e = new ArrayList<Instrucciones2Context>();
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public List<Instrucciones2Context> instrucciones2() {
			return getRuleContexts(Instrucciones2Context.class);
		}
		public Instrucciones2Context instrucciones2(int i) {
			return getRuleContext(Instrucciones2Context.class,i);
		}
		public IfNormalContext(IfContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitIfNormal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfElseContext extends IfContext {
		public Token id;
		public ExpresionContext cond;
		public Instrucciones2Context instrucciones2;
		public List<Instrucciones2Context> e = new ArrayList<Instrucciones2Context>();
		public List<Instrucciones2Context> e2 = new ArrayList<Instrucciones2Context>();
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public List<Instrucciones2Context> instrucciones2() {
			return getRuleContexts(Instrucciones2Context.class);
		}
		public Instrucciones2Context instrucciones2(int i) {
			return getRuleContext(Instrucciones2Context.class,i);
		}
		public IfElseContext(IfContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitIfElse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfElseIfContext extends IfContext {
		public Token id;
		public ExpresionContext cond;
		public Instrucciones2Context instrucciones2;
		public List<Instrucciones2Context> e = new ArrayList<Instrucciones2Context>();
		public ElseifContext elseif;
		public List<ElseifContext> e2 = new ArrayList<ElseifContext>();
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public List<Instrucciones2Context> instrucciones2() {
			return getRuleContexts(Instrucciones2Context.class);
		}
		public Instrucciones2Context instrucciones2(int i) {
			return getRuleContext(Instrucciones2Context.class,i);
		}
		public List<ElseifContext> elseif() {
			return getRuleContexts(ElseifContext.class);
		}
		public ElseifContext elseif(int i) {
			return getRuleContext(ElseifContext.class,i);
		}
		public IfElseIfContext(IfContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitIfElseIf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfElseIfElseContext extends IfContext {
		public Token id;
		public ExpresionContext cond;
		public Instrucciones2Context instrucciones2;
		public List<Instrucciones2Context> e = new ArrayList<Instrucciones2Context>();
		public ElseifContext elseif;
		public List<ElseifContext> e2 = new ArrayList<ElseifContext>();
		public List<Instrucciones2Context> e3 = new ArrayList<Instrucciones2Context>();
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public List<Instrucciones2Context> instrucciones2() {
			return getRuleContexts(Instrucciones2Context.class);
		}
		public Instrucciones2Context instrucciones2(int i) {
			return getRuleContext(Instrucciones2Context.class,i);
		}
		public List<ElseifContext> elseif() {
			return getRuleContexts(ElseifContext.class);
		}
		public ElseifContext elseif(int i) {
			return getRuleContext(ElseifContext.class,i);
		}
		public IfElseIfElseContext(IfContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitIfElseIfElse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfContext if_() throws RecognitionException {
		IfContext _localctx = new IfContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_if);
		int _la;
		try {
			int _alt;
			setState(295);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new IfNormalContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(213);
				((IfNormalContext)_localctx).id = match(T__18);
				setState(214);
				match(T__6);
				setState(215);
				((IfNormalContext)_localctx).cond = expresion(0);
				setState(216);
				match(T__7);
				setState(217);
				match(T__19);
				setState(221);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << IDEN))) != 0)) {
					{
					{
					setState(218);
					((IfNormalContext)_localctx).instrucciones2 = instrucciones2();
					((IfNormalContext)_localctx).e.add(((IfNormalContext)_localctx).instrucciones2);
					}
					}
					setState(223);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(224);
				match(T__3);
				setState(225);
				match(T__18);
				}
				break;
			case 2:
				_localctx = new IfElseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(227);
				((IfElseContext)_localctx).id = match(T__18);
				setState(228);
				match(T__6);
				setState(229);
				((IfElseContext)_localctx).cond = expresion(0);
				setState(230);
				match(T__7);
				setState(231);
				match(T__19);
				setState(235);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << IDEN))) != 0)) {
					{
					{
					setState(232);
					((IfElseContext)_localctx).instrucciones2 = instrucciones2();
					((IfElseContext)_localctx).e.add(((IfElseContext)_localctx).instrucciones2);
					}
					}
					setState(237);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(238);
				match(T__20);
				setState(242);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << IDEN))) != 0)) {
					{
					{
					setState(239);
					((IfElseContext)_localctx).instrucciones2 = instrucciones2();
					((IfElseContext)_localctx).e2.add(((IfElseContext)_localctx).instrucciones2);
					}
					}
					setState(244);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(245);
				match(T__3);
				setState(246);
				match(T__18);
				}
				break;
			case 3:
				_localctx = new IfElseIfContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(248);
				((IfElseIfContext)_localctx).id = match(T__18);
				setState(249);
				match(T__6);
				setState(250);
				((IfElseIfContext)_localctx).cond = expresion(0);
				setState(251);
				match(T__7);
				setState(252);
				match(T__19);
				setState(256);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << IDEN))) != 0)) {
					{
					{
					setState(253);
					((IfElseIfContext)_localctx).instrucciones2 = instrucciones2();
					((IfElseIfContext)_localctx).e.add(((IfElseIfContext)_localctx).instrucciones2);
					}
					}
					setState(258);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(262);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__20) {
					{
					{
					setState(259);
					((IfElseIfContext)_localctx).elseif = elseif();
					((IfElseIfContext)_localctx).e2.add(((IfElseIfContext)_localctx).elseif);
					}
					}
					setState(264);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(265);
				match(T__3);
				setState(266);
				match(T__18);
				}
				break;
			case 4:
				_localctx = new IfElseIfElseContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(268);
				((IfElseIfElseContext)_localctx).id = match(T__18);
				setState(269);
				match(T__6);
				setState(270);
				((IfElseIfElseContext)_localctx).cond = expresion(0);
				setState(271);
				match(T__7);
				setState(272);
				match(T__19);
				setState(276);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << IDEN))) != 0)) {
					{
					{
					setState(273);
					((IfElseIfElseContext)_localctx).instrucciones2 = instrucciones2();
					((IfElseIfElseContext)_localctx).e.add(((IfElseIfElseContext)_localctx).instrucciones2);
					}
					}
					setState(278);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(282);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(279);
						((IfElseIfElseContext)_localctx).elseif = elseif();
						((IfElseIfElseContext)_localctx).e2.add(((IfElseIfElseContext)_localctx).elseif);
						}
						} 
					}
					setState(284);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				}
				setState(285);
				match(T__20);
				setState(289);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << IDEN))) != 0)) {
					{
					{
					setState(286);
					((IfElseIfElseContext)_localctx).instrucciones2 = instrucciones2();
					((IfElseIfElseContext)_localctx).e3.add(((IfElseIfElseContext)_localctx).instrucciones2);
					}
					}
					setState(291);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(292);
				match(T__3);
				setState(293);
				match(T__18);
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

	public static class ElseifContext extends ParserRuleContext {
		public Token id;
		public ExpresionContext cond;
		public Instrucciones2Context instrucciones2;
		public List<Instrucciones2Context> e = new ArrayList<Instrucciones2Context>();
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public List<Instrucciones2Context> instrucciones2() {
			return getRuleContexts(Instrucciones2Context.class);
		}
		public Instrucciones2Context instrucciones2(int i) {
			return getRuleContext(Instrucciones2Context.class,i);
		}
		public ElseifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseif; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitElseif(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseifContext elseif() throws RecognitionException {
		ElseifContext _localctx = new ElseifContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_elseif);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			((ElseifContext)_localctx).id = match(T__20);
			setState(298);
			match(T__18);
			setState(299);
			match(T__6);
			setState(300);
			((ElseifContext)_localctx).cond = expresion(0);
			setState(301);
			match(T__7);
			setState(302);
			match(T__19);
			setState(306);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << IDEN))) != 0)) {
				{
				{
				setState(303);
				((ElseifContext)_localctx).instrucciones2 = instrucciones2();
				((ElseifContext)_localctx).e.add(((ElseifContext)_localctx).instrucciones2);
				}
				}
				setState(308);
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

	public static class DoContext extends ParserRuleContext {
		public DoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_do; }
	 
		public DoContext() { }
		public void copyFrom(DoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DoWhileEtiquetaContext extends DoContext {
		public Token id1;
		public ExpresionContext condicion;
		public Instrucciones2Context instrucciones2;
		public List<Instrucciones2Context> e = new ArrayList<Instrucciones2Context>();
		public Token id2;
		public List<TerminalNode> IDEN() { return getTokens(GramaticaParser.IDEN); }
		public TerminalNode IDEN(int i) {
			return getToken(GramaticaParser.IDEN, i);
		}
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public List<Instrucciones2Context> instrucciones2() {
			return getRuleContexts(Instrucciones2Context.class);
		}
		public Instrucciones2Context instrucciones2(int i) {
			return getRuleContext(Instrucciones2Context.class,i);
		}
		public DoWhileEtiquetaContext(DoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDoWhileEtiqueta(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DoEtiquetaContext extends DoContext {
		public Token id1;
		public AsignacionContext inicio;
		public ExpresionContext fin;
		public ExpresionContext paso;
		public Instrucciones2Context instrucciones2;
		public List<Instrucciones2Context> e = new ArrayList<Instrucciones2Context>();
		public Token id2;
		public List<TerminalNode> IDEN() { return getTokens(GramaticaParser.IDEN); }
		public TerminalNode IDEN(int i) {
			return getToken(GramaticaParser.IDEN, i);
		}
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public List<Instrucciones2Context> instrucciones2() {
			return getRuleContexts(Instrucciones2Context.class);
		}
		public Instrucciones2Context instrucciones2(int i) {
			return getRuleContext(Instrucciones2Context.class,i);
		}
		public DoEtiquetaContext(DoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDoEtiqueta(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DoWhileContext extends DoContext {
		public Token id;
		public ExpresionContext condicion;
		public Instrucciones2Context instrucciones2;
		public List<Instrucciones2Context> e = new ArrayList<Instrucciones2Context>();
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public List<Instrucciones2Context> instrucciones2() {
			return getRuleContexts(Instrucciones2Context.class);
		}
		public Instrucciones2Context instrucciones2(int i) {
			return getRuleContext(Instrucciones2Context.class,i);
		}
		public DoWhileContext(DoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDoWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DoNormalContext extends DoContext {
		public Token id;
		public AsignacionContext inicio;
		public ExpresionContext fin;
		public ExpresionContext paso;
		public Instrucciones2Context instrucciones2;
		public List<Instrucciones2Context> e = new ArrayList<Instrucciones2Context>();
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public List<Instrucciones2Context> instrucciones2() {
			return getRuleContexts(Instrucciones2Context.class);
		}
		public Instrucciones2Context instrucciones2(int i) {
			return getRuleContext(Instrucciones2Context.class,i);
		}
		public DoNormalContext(DoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDoNormal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoContext do_() throws RecognitionException {
		DoContext _localctx = new DoContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_do);
		int _la;
		try {
			setState(373);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				_localctx = new DoNormalContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(309);
				((DoNormalContext)_localctx).id = match(T__21);
				setState(310);
				((DoNormalContext)_localctx).inicio = asignacion();
				setState(311);
				match(T__4);
				setState(312);
				((DoNormalContext)_localctx).fin = expresion(0);
				setState(313);
				match(T__4);
				setState(314);
				((DoNormalContext)_localctx).paso = expresion(0);
				setState(318);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << IDEN))) != 0)) {
					{
					{
					setState(315);
					((DoNormalContext)_localctx).instrucciones2 = instrucciones2();
					((DoNormalContext)_localctx).e.add(((DoNormalContext)_localctx).instrucciones2);
					}
					}
					setState(320);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(321);
				match(T__3);
				setState(322);
				match(T__21);
				}
				break;
			case 2:
				_localctx = new DoEtiquetaContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(324);
				((DoEtiquetaContext)_localctx).id1 = match(IDEN);
				setState(325);
				match(T__10);
				setState(326);
				match(T__21);
				setState(327);
				((DoEtiquetaContext)_localctx).inicio = asignacion();
				setState(328);
				match(T__4);
				setState(329);
				((DoEtiquetaContext)_localctx).fin = expresion(0);
				setState(330);
				match(T__4);
				setState(331);
				((DoEtiquetaContext)_localctx).paso = expresion(0);
				setState(335);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << IDEN))) != 0)) {
					{
					{
					setState(332);
					((DoEtiquetaContext)_localctx).instrucciones2 = instrucciones2();
					((DoEtiquetaContext)_localctx).e.add(((DoEtiquetaContext)_localctx).instrucciones2);
					}
					}
					setState(337);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(338);
				match(T__3);
				setState(339);
				match(T__21);
				setState(340);
				((DoEtiquetaContext)_localctx).id2 = match(IDEN);
				}
				break;
			case 3:
				_localctx = new DoWhileContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(342);
				((DoWhileContext)_localctx).id = match(T__21);
				setState(343);
				match(T__22);
				setState(344);
				match(T__6);
				setState(345);
				((DoWhileContext)_localctx).condicion = expresion(0);
				setState(346);
				match(T__7);
				setState(350);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << IDEN))) != 0)) {
					{
					{
					setState(347);
					((DoWhileContext)_localctx).instrucciones2 = instrucciones2();
					((DoWhileContext)_localctx).e.add(((DoWhileContext)_localctx).instrucciones2);
					}
					}
					setState(352);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(353);
				match(T__3);
				setState(354);
				match(T__21);
				}
				break;
			case 4:
				_localctx = new DoWhileEtiquetaContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(356);
				((DoWhileEtiquetaContext)_localctx).id1 = match(IDEN);
				setState(357);
				match(T__10);
				setState(358);
				match(T__21);
				setState(359);
				match(T__22);
				setState(360);
				match(T__6);
				setState(361);
				((DoWhileEtiquetaContext)_localctx).condicion = expresion(0);
				setState(362);
				match(T__7);
				setState(366);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << IDEN))) != 0)) {
					{
					{
					setState(363);
					((DoWhileEtiquetaContext)_localctx).instrucciones2 = instrucciones2();
					((DoWhileEtiquetaContext)_localctx).e.add(((DoWhileEtiquetaContext)_localctx).instrucciones2);
					}
					}
					setState(368);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(369);
				match(T__3);
				setState(370);
				match(T__21);
				setState(371);
				((DoWhileEtiquetaContext)_localctx).id2 = match(IDEN);
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

	public static class ExitContext extends ParserRuleContext {
		public ExitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exit; }
	 
		public ExitContext() { }
		public void copyFrom(ExitContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExitNormalContext extends ExitContext {
		public Token id;
		public ExitNormalContext(ExitContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExitNormal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExitEtiquetaContext extends ExitContext {
		public Token id1;
		public Token id2;
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public ExitEtiquetaContext(ExitContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExitEtiqueta(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExitContext exit() throws RecognitionException {
		ExitContext _localctx = new ExitContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_exit);
		try {
			setState(378);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				_localctx = new ExitNormalContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(375);
				((ExitNormalContext)_localctx).id = match(T__23);
				}
				break;
			case 2:
				_localctx = new ExitEtiquetaContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(376);
				((ExitEtiquetaContext)_localctx).id1 = match(T__23);
				setState(377);
				((ExitEtiquetaContext)_localctx).id2 = match(IDEN);
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

	public static class CycleContext extends ParserRuleContext {
		public CycleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cycle; }
	 
		public CycleContext() { }
		public void copyFrom(CycleContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CycleNormalContext extends CycleContext {
		public Token id;
		public CycleNormalContext(CycleContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitCycleNormal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CycleEtiquetaContext extends CycleContext {
		public Token id1;
		public Token id2;
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public CycleEtiquetaContext(CycleContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitCycleEtiqueta(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CycleContext cycle() throws RecognitionException {
		CycleContext _localctx = new CycleContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_cycle);
		try {
			setState(383);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				_localctx = new CycleNormalContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(380);
				((CycleNormalContext)_localctx).id = match(T__24);
				}
				break;
			case 2:
				_localctx = new CycleEtiquetaContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(381);
				((CycleEtiquetaContext)_localctx).id1 = match(T__24);
				setState(382);
				((CycleEtiquetaContext)_localctx).id2 = match(IDEN);
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
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_expresion, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(427);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				_localctx = new ExpresionNegativoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(386);
				((ExpresionNegativoContext)_localctx).op = match(T__25);
				setState(387);
				expresion(27);
				}
				break;
			case 2:
				{
				_localctx = new ExpresionNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(388);
				((ExpresionNotContext)_localctx).op = match(T__26);
				setState(389);
				expresion(26);
				}
				break;
			case 3:
				{
				_localctx = new ExpresionSizeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(390);
				((ExpresionSizeContext)_localctx).si = match(T__44);
				setState(391);
				match(T__6);
				setState(392);
				((ExpresionSizeContext)_localctx).val = match(IDEN);
				setState(393);
				match(T__7);
				}
				break;
			case 4:
				{
				_localctx = new ExpresionArray1Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(394);
				((ExpresionArray1Context)_localctx).val = match(IDEN);
				setState(395);
				match(T__12);
				setState(396);
				((ExpresionArray1Context)_localctx).pos = expresion(0);
				setState(397);
				match(T__13);
				}
				break;
			case 5:
				{
				_localctx = new ExpresionArray2Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(399);
				((ExpresionArray2Context)_localctx).val = match(IDEN);
				setState(400);
				match(T__12);
				setState(401);
				((ExpresionArray2Context)_localctx).pos1 = expresion(0);
				setState(402);
				match(T__4);
				setState(403);
				((ExpresionArray2Context)_localctx).pos2 = expresion(0);
				setState(404);
				match(T__13);
				}
				break;
			case 6:
				{
				_localctx = new ExpresionIdentificadorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(406);
				((ExpresionIdentificadorContext)_localctx).val = match(IDEN);
				}
				break;
			case 7:
				{
				_localctx = new ExpresionRealContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(407);
				((ExpresionRealContext)_localctx).val = match(REAL);
				}
				break;
			case 8:
				{
				_localctx = new ExpresionIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(408);
				((ExpresionIntContext)_localctx).val = match(INT);
				}
				break;
			case 9:
				{
				_localctx = new ExpresionCharContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(409);
				((ExpresionCharContext)_localctx).val = match(CHAR);
				}
				break;
			case 10:
				{
				_localctx = new ExpresionStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(410);
				((ExpresionStringContext)_localctx).val = match(STRING);
				}
				break;
			case 11:
				{
				_localctx = new ExpresionTrueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(411);
				((ExpresionTrueContext)_localctx).val = match(T__45);
				}
				break;
			case 12:
				{
				_localctx = new ExpresionFalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(412);
				((ExpresionFalseContext)_localctx).val = match(T__46);
				}
				break;
			case 13:
				{
				_localctx = new ExpresionListaExpresionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(413);
				match(T__47);
				setState(414);
				((ExpresionListaExpresionContext)_localctx).val = expresion(0);
				setState(418);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(415);
					((ExpresionListaExpresionContext)_localctx).listaExpresion = listaExpresion();
					((ExpresionListaExpresionContext)_localctx).e.add(((ExpresionListaExpresionContext)_localctx).listaExpresion);
					}
					}
					setState(420);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(421);
				match(T__48);
				}
				break;
			case 14:
				{
				_localctx = new ExpresionParentesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(423);
				match(T__6);
				setState(424);
				((ExpresionParentesisContext)_localctx).val = expresion(0);
				setState(425);
				match(T__7);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(470);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(468);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
					case 1:
						{
						_localctx = new ExpresionPotenciaContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionPotenciaContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(429);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(430);
						((ExpresionPotenciaContext)_localctx).op = match(T__27);
						setState(431);
						((ExpresionPotenciaContext)_localctx).val2 = expresion(26);
						}
						break;
					case 2:
						{
						_localctx = new ExpresionMultiplicacionContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionMultiplicacionContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(432);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(433);
						((ExpresionMultiplicacionContext)_localctx).op = match(T__17);
						setState(434);
						((ExpresionMultiplicacionContext)_localctx).val2 = expresion(25);
						}
						break;
					case 3:
						{
						_localctx = new ExpresionDivisionContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionDivisionContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(435);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(436);
						((ExpresionDivisionContext)_localctx).op = match(T__28);
						setState(437);
						((ExpresionDivisionContext)_localctx).val2 = expresion(24);
						}
						break;
					case 4:
						{
						_localctx = new ExpresionSumaContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionSumaContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(438);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(439);
						((ExpresionSumaContext)_localctx).op = match(T__29);
						setState(440);
						((ExpresionSumaContext)_localctx).val2 = expresion(23);
						}
						break;
					case 5:
						{
						_localctx = new ExpresionRestaContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionRestaContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(441);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(442);
						((ExpresionRestaContext)_localctx).op = match(T__25);
						setState(443);
						((ExpresionRestaContext)_localctx).val2 = expresion(22);
						}
						break;
					case 6:
						{
						_localctx = new ExpresionEqContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionEqContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(444);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(445);
						((ExpresionEqContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__30 || _la==T__31) ) {
							((ExpresionEqContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(446);
						((ExpresionEqContext)_localctx).val2 = expresion(21);
						}
						break;
					case 7:
						{
						_localctx = new ExpresionNeContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionNeContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(447);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(448);
						((ExpresionNeContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__32 || _la==T__33) ) {
							((ExpresionNeContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(449);
						((ExpresionNeContext)_localctx).val2 = expresion(20);
						}
						break;
					case 8:
						{
						_localctx = new ExpresionGeContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionGeContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(450);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(451);
						((ExpresionGeContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__34 || _la==T__35) ) {
							((ExpresionGeContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(452);
						((ExpresionGeContext)_localctx).val2 = expresion(19);
						}
						break;
					case 9:
						{
						_localctx = new ExpresionGtContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionGtContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(453);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(454);
						((ExpresionGtContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__36 || _la==T__37) ) {
							((ExpresionGtContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(455);
						((ExpresionGtContext)_localctx).val2 = expresion(18);
						}
						break;
					case 10:
						{
						_localctx = new ExpresionLeContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionLeContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(456);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(457);
						((ExpresionLeContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__38 || _la==T__39) ) {
							((ExpresionLeContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(458);
						((ExpresionLeContext)_localctx).val2 = expresion(17);
						}
						break;
					case 11:
						{
						_localctx = new ExpresionLtContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionLtContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(459);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(460);
						((ExpresionLtContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__40 || _la==T__41) ) {
							((ExpresionLtContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(461);
						((ExpresionLtContext)_localctx).val2 = expresion(16);
						}
						break;
					case 12:
						{
						_localctx = new ExpresionAndContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionAndContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(462);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(463);
						((ExpresionAndContext)_localctx).op = match(T__42);
						setState(464);
						((ExpresionAndContext)_localctx).val2 = expresion(15);
						}
						break;
					case 13:
						{
						_localctx = new ExpresionOrContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionOrContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(465);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(466);
						((ExpresionOrContext)_localctx).op = match(T__43);
						setState(467);
						((ExpresionOrContext)_localctx).val2 = expresion(14);
						}
						break;
					}
					} 
				}
				setState(472);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
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
		enterRule(_localctx, 32, RULE_listaExpresion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(473);
			match(T__4);
			setState(474);
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
		enterRule(_localctx, 34, RULE_tipo);
		try {
			setState(481);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__49:
				_localctx = new TipoIntegerContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(476);
				match(T__49);
				}
				break;
			case T__50:
				_localctx = new TipoRealContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(477);
				match(T__50);
				}
				break;
			case T__51:
				_localctx = new TipoComplexContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(478);
				match(T__51);
				}
				break;
			case T__52:
				_localctx = new TipoCharacterContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(479);
				match(T__52);
				}
				break;
			case T__53:
				_localctx = new TipoLogicalContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(480);
				match(T__53);
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
		case 15:
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
		"\u0004\u0001>\u01e4\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0005\u0001)\b\u0001\n\u0001\f\u0001,\t\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"3\b\u0002\n\u0002\f\u00026\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003D\b\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0005\u0004\u0084\b\u0004\n\u0004\f\u0004\u0087\t\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004\u008d\b\u0004\n"+
		"\u0004\f\u0004\u0090\t\u0004\u0003\u0004\u0092\b\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u009a"+
		"\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0003\u0006\u00af\b\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007\u00c7\b\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0005\b\u00ce\b\b\n\b\f\b\u00d1\t\b\u0001\t\u0001\t\u0001\t"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u00dc\b\n\n\n"+
		"\f\n\u00df\t\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0005\n\u00ea\b\n\n\n\f\n\u00ed\t\n\u0001\n\u0001\n\u0005"+
		"\n\u00f1\b\n\n\n\f\n\u00f4\t\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u00ff\b\n\n\n\f\n\u0102\t\n\u0001"+
		"\n\u0005\n\u0105\b\n\n\n\f\n\u0108\t\n\u0001\n\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u0113\b\n\n\n\f\n\u0116"+
		"\t\n\u0001\n\u0005\n\u0119\b\n\n\n\f\n\u011c\t\n\u0001\n\u0001\n\u0005"+
		"\n\u0120\b\n\n\n\f\n\u0123\t\n\u0001\n\u0001\n\u0001\n\u0003\n\u0128\b"+
		"\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0005\u000b\u0131\b\u000b\n\u000b\f\u000b\u0134\t\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u013d\b\f\n"+
		"\f\f\f\u0140\t\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u014e\b\f\n\f\f\f\u0151"+
		"\t\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0005\f\u015d\b\f\n\f\f\f\u0160\t\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005"+
		"\f\u016d\b\f\n\f\f\f\u0170\t\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f"+
		"\u0176\b\f\u0001\r\u0001\r\u0001\r\u0003\r\u017b\b\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0003\u000e\u0180\b\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u01a1"+
		"\b\u000f\n\u000f\f\u000f\u01a4\t\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u01ac\b\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0005\u000f\u01d5\b\u000f\n\u000f\f\u000f\u01d8"+
		"\t\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u01e2\b\u0011\u0001\u0011\u0000"+
		"\u0001\u001e\u0012\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e \"\u0000\u0006\u0001\u0000\u001f \u0001"+
		"\u0000!\"\u0001\u0000#$\u0001\u0000%&\u0001\u0000\'(\u0001\u0000)*\u021d"+
		"\u0000$\u0001\u0000\u0000\u0000\u0002*\u0001\u0000\u0000\u0000\u0004-"+
		"\u0001\u0000\u0000\u0000\u0006C\u0001\u0000\u0000\u0000\b\u0091\u0001"+
		"\u0000\u0000\u0000\n\u0099\u0001\u0000\u0000\u0000\f\u00ae\u0001\u0000"+
		"\u0000\u0000\u000e\u00c6\u0001\u0000\u0000\u0000\u0010\u00c8\u0001\u0000"+
		"\u0000\u0000\u0012\u00d2\u0001\u0000\u0000\u0000\u0014\u0127\u0001\u0000"+
		"\u0000\u0000\u0016\u0129\u0001\u0000\u0000\u0000\u0018\u0175\u0001\u0000"+
		"\u0000\u0000\u001a\u017a\u0001\u0000\u0000\u0000\u001c\u017f\u0001\u0000"+
		"\u0000\u0000\u001e\u01ab\u0001\u0000\u0000\u0000 \u01d9\u0001\u0000\u0000"+
		"\u0000\"\u01e1\u0001\u0000\u0000\u0000$%\u0003\u0002\u0001\u0000%&\u0005"+
		"\u0000\u0000\u0001&\u0001\u0001\u0000\u0000\u0000\')\u0003\u0004\u0002"+
		"\u0000(\'\u0001\u0000\u0000\u0000),\u0001\u0000\u0000\u0000*(\u0001\u0000"+
		"\u0000\u0000*+\u0001\u0000\u0000\u0000+\u0003\u0001\u0000\u0000\u0000"+
		",*\u0001\u0000\u0000\u0000-.\u0005\u0001\u0000\u0000./\u0005:\u0000\u0000"+
		"/0\u0005\u0002\u0000\u000004\u0005\u0003\u0000\u000013\u0003\u0006\u0003"+
		"\u000021\u0001\u0000\u0000\u000036\u0001\u0000\u0000\u000042\u0001\u0000"+
		"\u0000\u000045\u0001\u0000\u0000\u000057\u0001\u0000\u0000\u000064\u0001"+
		"\u0000\u0000\u000078\u0005\u0004\u0000\u000089\u0005\u0001\u0000\u0000"+
		"9:\u0005:\u0000\u0000:\u0005\u0001\u0000\u0000\u0000;D\u0003\b\u0004\u0000"+
		"<D\u0003\f\u0006\u0000=D\u0003\u000e\u0007\u0000>D\u0003\u0010\b\u0000"+
		"?D\u0003\u0014\n\u0000@D\u0003\u0018\f\u0000AD\u0003\u001a\r\u0000BD\u0003"+
		"\u001c\u000e\u0000C;\u0001\u0000\u0000\u0000C<\u0001\u0000\u0000\u0000"+
		"C=\u0001\u0000\u0000\u0000C>\u0001\u0000\u0000\u0000C?\u0001\u0000\u0000"+
		"\u0000C@\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000CB\u0001\u0000"+
		"\u0000\u0000D\u0007\u0001\u0000\u0000\u0000EF\u0003\"\u0011\u0000FG\u0005"+
		"\u0005\u0000\u0000GH\u0005\u0006\u0000\u0000HI\u0005\u0007\u0000\u0000"+
		"IJ\u0003\u001e\u000f\u0000JK\u0005\u0005\u0000\u0000KL\u0003\u001e\u000f"+
		"\u0000LM\u0005\b\u0000\u0000MN\u0005\t\u0000\u0000NO\u0005:\u0000\u0000"+
		"O\u0092\u0001\u0000\u0000\u0000PQ\u0003\"\u0011\u0000QR\u0005\u0005\u0000"+
		"\u0000RS\u0005\u0006\u0000\u0000ST\u0005\u0007\u0000\u0000TU\u0003\u001e"+
		"\u000f\u0000UV\u0005\b\u0000\u0000VW\u0005\t\u0000\u0000WX\u0005:\u0000"+
		"\u0000X\u0092\u0001\u0000\u0000\u0000YZ\u0003\"\u0011\u0000Z[\u0005\u0005"+
		"\u0000\u0000[\\\u0005\n\u0000\u0000\\]\u0005\t\u0000\u0000]^\u0005:\u0000"+
		"\u0000^_\u0005\u0007\u0000\u0000_`\u0005\u000b\u0000\u0000`a\u0005\u0005"+
		"\u0000\u0000ab\u0005\u000b\u0000\u0000bc\u0005\b\u0000\u0000c\u0092\u0001"+
		"\u0000\u0000\u0000de\u0003\"\u0011\u0000ef\u0005\u0005\u0000\u0000fg\u0005"+
		"\n\u0000\u0000gh\u0005\t\u0000\u0000hi\u0005:\u0000\u0000ij\u0005\u0007"+
		"\u0000\u0000jk\u0005\u000b\u0000\u0000kl\u0005\b\u0000\u0000l\u0092\u0001"+
		"\u0000\u0000\u0000mn\u0003\"\u0011\u0000no\u0005\t\u0000\u0000op\u0005"+
		":\u0000\u0000pq\u0005\u0007\u0000\u0000qr\u0003\u001e\u000f\u0000rs\u0005"+
		"\u0005\u0000\u0000st\u0003\u001e\u000f\u0000tu\u0005\b\u0000\u0000u\u0092"+
		"\u0001\u0000\u0000\u0000vw\u0003\"\u0011\u0000wx\u0005\t\u0000\u0000x"+
		"y\u0005:\u0000\u0000yz\u0005\u0007\u0000\u0000z{\u0003\u001e\u000f\u0000"+
		"{|\u0005\b\u0000\u0000|\u0092\u0001\u0000\u0000\u0000}~\u0003\"\u0011"+
		"\u0000~\u007f\u0005\t\u0000\u0000\u007f\u0080\u0005:\u0000\u0000\u0080"+
		"\u0081\u0005\f\u0000\u0000\u0081\u0085\u0003\u001e\u000f\u0000\u0082\u0084"+
		"\u0003\n\u0005\u0000\u0083\u0082\u0001\u0000\u0000\u0000\u0084\u0087\u0001"+
		"\u0000\u0000\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0085\u0086\u0001"+
		"\u0000\u0000\u0000\u0086\u0092\u0001\u0000\u0000\u0000\u0087\u0085\u0001"+
		"\u0000\u0000\u0000\u0088\u0089\u0003\"\u0011\u0000\u0089\u008a\u0005\t"+
		"\u0000\u0000\u008a\u008e\u0005:\u0000\u0000\u008b\u008d\u0003\n\u0005"+
		"\u0000\u008c\u008b\u0001\u0000\u0000\u0000\u008d\u0090\u0001\u0000\u0000"+
		"\u0000\u008e\u008c\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000"+
		"\u0000\u008f\u0092\u0001\u0000\u0000\u0000\u0090\u008e\u0001\u0000\u0000"+
		"\u0000\u0091E\u0001\u0000\u0000\u0000\u0091P\u0001\u0000\u0000\u0000\u0091"+
		"Y\u0001\u0000\u0000\u0000\u0091d\u0001\u0000\u0000\u0000\u0091m\u0001"+
		"\u0000\u0000\u0000\u0091v\u0001\u0000\u0000\u0000\u0091}\u0001\u0000\u0000"+
		"\u0000\u0091\u0088\u0001\u0000\u0000\u0000\u0092\t\u0001\u0000\u0000\u0000"+
		"\u0093\u0094\u0005\u0005\u0000\u0000\u0094\u0095\u0005:\u0000\u0000\u0095"+
		"\u0096\u0005\f\u0000\u0000\u0096\u009a\u0003\u001e\u000f\u0000\u0097\u0098"+
		"\u0005\u0005\u0000\u0000\u0098\u009a\u0005:\u0000\u0000\u0099\u0093\u0001"+
		"\u0000\u0000\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u009a\u000b\u0001"+
		"\u0000\u0000\u0000\u009b\u009c\u0005:\u0000\u0000\u009c\u009d\u0005\f"+
		"\u0000\u0000\u009d\u00af\u0003\u001e\u000f\u0000\u009e\u009f\u0005:\u0000"+
		"\u0000\u009f\u00a0\u0005\r\u0000\u0000\u00a0\u00a1\u0003\u001e\u000f\u0000"+
		"\u00a1\u00a2\u0005\u000e\u0000\u0000\u00a2\u00a3\u0005\f\u0000\u0000\u00a3"+
		"\u00a4\u0003\u001e\u000f\u0000\u00a4\u00af\u0001\u0000\u0000\u0000\u00a5"+
		"\u00a6\u0005:\u0000\u0000\u00a6\u00a7\u0005\r\u0000\u0000\u00a7\u00a8"+
		"\u0003\u001e\u000f\u0000\u00a8\u00a9\u0005\u0005\u0000\u0000\u00a9\u00aa"+
		"\u0003\u001e\u000f\u0000\u00aa\u00ab\u0005\u000e\u0000\u0000\u00ab\u00ac"+
		"\u0005\f\u0000\u0000\u00ac\u00ad\u0003\u001e\u000f\u0000\u00ad\u00af\u0001"+
		"\u0000\u0000\u0000\u00ae\u009b\u0001\u0000\u0000\u0000\u00ae\u009e\u0001"+
		"\u0000\u0000\u0000\u00ae\u00a5\u0001\u0000\u0000\u0000\u00af\r\u0001\u0000"+
		"\u0000\u0000\u00b0\u00b1\u0005\u000f\u0000\u0000\u00b1\u00b2\u0005\u0007"+
		"\u0000\u0000\u00b2\u00b3\u0005:\u0000\u0000\u00b3\u00b4\u0005\u0007\u0000"+
		"\u0000\u00b4\u00b5\u0003\u001e\u000f\u0000\u00b5\u00b6\u0005\u0005\u0000"+
		"\u0000\u00b6\u00b7\u0003\u001e\u000f\u0000\u00b7\u00b8\u0005\b\u0000\u0000"+
		"\u00b8\u00b9\u0005\b\u0000\u0000\u00b9\u00c7\u0001\u0000\u0000\u0000\u00ba"+
		"\u00bb\u0005\u000f\u0000\u0000\u00bb\u00bc\u0005\u0007\u0000\u0000\u00bc"+
		"\u00bd\u0005:\u0000\u0000\u00bd\u00be\u0005\u0007\u0000\u0000\u00be\u00bf"+
		"\u0003\u001e\u000f\u0000\u00bf\u00c0\u0005\b\u0000\u0000\u00c0\u00c1\u0005"+
		"\b\u0000\u0000\u00c1\u00c7\u0001\u0000\u0000\u0000\u00c2\u00c3\u0005\u0010"+
		"\u0000\u0000\u00c3\u00c4\u0005\u0007\u0000\u0000\u00c4\u00c5\u0005:\u0000"+
		"\u0000\u00c5\u00c7\u0005\b\u0000\u0000\u00c6\u00b0\u0001\u0000\u0000\u0000"+
		"\u00c6\u00ba\u0001\u0000\u0000\u0000\u00c6\u00c2\u0001\u0000\u0000\u0000"+
		"\u00c7\u000f\u0001\u0000\u0000\u0000\u00c8\u00c9\u0005\u0011\u0000\u0000"+
		"\u00c9\u00ca\u0005\u0012\u0000\u0000\u00ca\u00cb\u0005\u0005\u0000\u0000"+
		"\u00cb\u00cf\u0003\u001e\u000f\u0000\u00cc\u00ce\u0003\u0012\t\u0000\u00cd"+
		"\u00cc\u0001\u0000\u0000\u0000\u00ce\u00d1\u0001\u0000\u0000\u0000\u00cf"+
		"\u00cd\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0"+
		"\u0011\u0001\u0000\u0000\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d2"+
		"\u00d3\u0005\u0005\u0000\u0000\u00d3\u00d4\u0003\u001e\u000f\u0000\u00d4"+
		"\u0013\u0001\u0000\u0000\u0000\u00d5\u00d6\u0005\u0013\u0000\u0000\u00d6"+
		"\u00d7\u0005\u0007\u0000\u0000\u00d7\u00d8\u0003\u001e\u000f\u0000\u00d8"+
		"\u00d9\u0005\b\u0000\u0000\u00d9\u00dd\u0005\u0014\u0000\u0000\u00da\u00dc"+
		"\u0003\u0006\u0003\u0000\u00db\u00da\u0001\u0000\u0000\u0000\u00dc\u00df"+
		"\u0001\u0000\u0000\u0000\u00dd\u00db\u0001\u0000\u0000\u0000\u00dd\u00de"+
		"\u0001\u0000\u0000\u0000\u00de\u00e0\u0001\u0000\u0000\u0000\u00df\u00dd"+
		"\u0001\u0000\u0000\u0000\u00e0\u00e1\u0005\u0004\u0000\u0000\u00e1\u00e2"+
		"\u0005\u0013\u0000\u0000\u00e2\u0128\u0001\u0000\u0000\u0000\u00e3\u00e4"+
		"\u0005\u0013\u0000\u0000\u00e4\u00e5\u0005\u0007\u0000\u0000\u00e5\u00e6"+
		"\u0003\u001e\u000f\u0000\u00e6\u00e7\u0005\b\u0000\u0000\u00e7\u00eb\u0005"+
		"\u0014\u0000\u0000\u00e8\u00ea\u0003\u0006\u0003\u0000\u00e9\u00e8\u0001"+
		"\u0000\u0000\u0000\u00ea\u00ed\u0001\u0000\u0000\u0000\u00eb\u00e9\u0001"+
		"\u0000\u0000\u0000\u00eb\u00ec\u0001\u0000\u0000\u0000\u00ec\u00ee\u0001"+
		"\u0000\u0000\u0000\u00ed\u00eb\u0001\u0000\u0000\u0000\u00ee\u00f2\u0005"+
		"\u0015\u0000\u0000\u00ef\u00f1\u0003\u0006\u0003\u0000\u00f0\u00ef\u0001"+
		"\u0000\u0000\u0000\u00f1\u00f4\u0001\u0000\u0000\u0000\u00f2\u00f0\u0001"+
		"\u0000\u0000\u0000\u00f2\u00f3\u0001\u0000\u0000\u0000\u00f3\u00f5\u0001"+
		"\u0000\u0000\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000\u00f5\u00f6\u0005"+
		"\u0004\u0000\u0000\u00f6\u00f7\u0005\u0013\u0000\u0000\u00f7\u0128\u0001"+
		"\u0000\u0000\u0000\u00f8\u00f9\u0005\u0013\u0000\u0000\u00f9\u00fa\u0005"+
		"\u0007\u0000\u0000\u00fa\u00fb\u0003\u001e\u000f\u0000\u00fb\u00fc\u0005"+
		"\b\u0000\u0000\u00fc\u0100\u0005\u0014\u0000\u0000\u00fd\u00ff\u0003\u0006"+
		"\u0003\u0000\u00fe\u00fd\u0001\u0000\u0000\u0000\u00ff\u0102\u0001\u0000"+
		"\u0000\u0000\u0100\u00fe\u0001\u0000\u0000\u0000\u0100\u0101\u0001\u0000"+
		"\u0000\u0000\u0101\u0106\u0001\u0000\u0000\u0000\u0102\u0100\u0001\u0000"+
		"\u0000\u0000\u0103\u0105\u0003\u0016\u000b\u0000\u0104\u0103\u0001\u0000"+
		"\u0000\u0000\u0105\u0108\u0001\u0000\u0000\u0000\u0106\u0104\u0001\u0000"+
		"\u0000\u0000\u0106\u0107\u0001\u0000\u0000\u0000\u0107\u0109\u0001\u0000"+
		"\u0000\u0000\u0108\u0106\u0001\u0000\u0000\u0000\u0109\u010a\u0005\u0004"+
		"\u0000\u0000\u010a\u010b\u0005\u0013\u0000\u0000\u010b\u0128\u0001\u0000"+
		"\u0000\u0000\u010c\u010d\u0005\u0013\u0000\u0000\u010d\u010e\u0005\u0007"+
		"\u0000\u0000\u010e\u010f\u0003\u001e\u000f\u0000\u010f\u0110\u0005\b\u0000"+
		"\u0000\u0110\u0114\u0005\u0014\u0000\u0000\u0111\u0113\u0003\u0006\u0003"+
		"\u0000\u0112\u0111\u0001\u0000\u0000\u0000\u0113\u0116\u0001\u0000\u0000"+
		"\u0000\u0114\u0112\u0001\u0000\u0000\u0000\u0114\u0115\u0001\u0000\u0000"+
		"\u0000\u0115\u011a\u0001\u0000\u0000\u0000\u0116\u0114\u0001\u0000\u0000"+
		"\u0000\u0117\u0119\u0003\u0016\u000b\u0000\u0118\u0117\u0001\u0000\u0000"+
		"\u0000\u0119\u011c\u0001\u0000\u0000\u0000\u011a\u0118\u0001\u0000\u0000"+
		"\u0000\u011a\u011b\u0001\u0000\u0000\u0000\u011b\u011d\u0001\u0000\u0000"+
		"\u0000\u011c\u011a\u0001\u0000\u0000\u0000\u011d\u0121\u0005\u0015\u0000"+
		"\u0000\u011e\u0120\u0003\u0006\u0003\u0000\u011f\u011e\u0001\u0000\u0000"+
		"\u0000\u0120\u0123\u0001\u0000\u0000\u0000\u0121\u011f\u0001\u0000\u0000"+
		"\u0000\u0121\u0122\u0001\u0000\u0000\u0000\u0122\u0124\u0001\u0000\u0000"+
		"\u0000\u0123\u0121\u0001\u0000\u0000\u0000\u0124\u0125\u0005\u0004\u0000"+
		"\u0000\u0125\u0126\u0005\u0013\u0000\u0000\u0126\u0128\u0001\u0000\u0000"+
		"\u0000\u0127\u00d5\u0001\u0000\u0000\u0000\u0127\u00e3\u0001\u0000\u0000"+
		"\u0000\u0127\u00f8\u0001\u0000\u0000\u0000\u0127\u010c\u0001\u0000\u0000"+
		"\u0000\u0128\u0015\u0001\u0000\u0000\u0000\u0129\u012a\u0005\u0015\u0000"+
		"\u0000\u012a\u012b\u0005\u0013\u0000\u0000\u012b\u012c\u0005\u0007\u0000"+
		"\u0000\u012c\u012d\u0003\u001e\u000f\u0000\u012d\u012e\u0005\b\u0000\u0000"+
		"\u012e\u0132\u0005\u0014\u0000\u0000\u012f\u0131\u0003\u0006\u0003\u0000"+
		"\u0130\u012f\u0001\u0000\u0000\u0000\u0131\u0134\u0001\u0000\u0000\u0000"+
		"\u0132\u0130\u0001\u0000\u0000\u0000\u0132\u0133\u0001\u0000\u0000\u0000"+
		"\u0133\u0017\u0001\u0000\u0000\u0000\u0134\u0132\u0001\u0000\u0000\u0000"+
		"\u0135\u0136\u0005\u0016\u0000\u0000\u0136\u0137\u0003\f\u0006\u0000\u0137"+
		"\u0138\u0005\u0005\u0000\u0000\u0138\u0139\u0003\u001e\u000f\u0000\u0139"+
		"\u013a\u0005\u0005\u0000\u0000\u013a\u013e\u0003\u001e\u000f\u0000\u013b"+
		"\u013d\u0003\u0006\u0003\u0000\u013c\u013b\u0001\u0000\u0000\u0000\u013d"+
		"\u0140\u0001\u0000\u0000\u0000\u013e\u013c\u0001\u0000\u0000\u0000\u013e"+
		"\u013f\u0001\u0000\u0000\u0000\u013f\u0141\u0001\u0000\u0000\u0000\u0140"+
		"\u013e\u0001\u0000\u0000\u0000\u0141\u0142\u0005\u0004\u0000\u0000\u0142"+
		"\u0143\u0005\u0016\u0000\u0000\u0143\u0176\u0001\u0000\u0000\u0000\u0144"+
		"\u0145\u0005:\u0000\u0000\u0145\u0146\u0005\u000b\u0000\u0000\u0146\u0147"+
		"\u0005\u0016\u0000\u0000\u0147\u0148\u0003\f\u0006\u0000\u0148\u0149\u0005"+
		"\u0005\u0000\u0000\u0149\u014a\u0003\u001e\u000f\u0000\u014a\u014b\u0005"+
		"\u0005\u0000\u0000\u014b\u014f\u0003\u001e\u000f\u0000\u014c\u014e\u0003"+
		"\u0006\u0003\u0000\u014d\u014c\u0001\u0000\u0000\u0000\u014e\u0151\u0001"+
		"\u0000\u0000\u0000\u014f\u014d\u0001\u0000\u0000\u0000\u014f\u0150\u0001"+
		"\u0000\u0000\u0000\u0150\u0152\u0001\u0000\u0000\u0000\u0151\u014f\u0001"+
		"\u0000\u0000\u0000\u0152\u0153\u0005\u0004\u0000\u0000\u0153\u0154\u0005"+
		"\u0016\u0000\u0000\u0154\u0155\u0005:\u0000\u0000\u0155\u0176\u0001\u0000"+
		"\u0000\u0000\u0156\u0157\u0005\u0016\u0000\u0000\u0157\u0158\u0005\u0017"+
		"\u0000\u0000\u0158\u0159\u0005\u0007\u0000\u0000\u0159\u015a\u0003\u001e"+
		"\u000f\u0000\u015a\u015e\u0005\b\u0000\u0000\u015b\u015d\u0003\u0006\u0003"+
		"\u0000\u015c\u015b\u0001\u0000\u0000\u0000\u015d\u0160\u0001\u0000\u0000"+
		"\u0000\u015e\u015c\u0001\u0000\u0000\u0000\u015e\u015f\u0001\u0000\u0000"+
		"\u0000\u015f\u0161\u0001\u0000\u0000\u0000\u0160\u015e\u0001\u0000\u0000"+
		"\u0000\u0161\u0162\u0005\u0004\u0000\u0000\u0162\u0163\u0005\u0016\u0000"+
		"\u0000\u0163\u0176\u0001\u0000\u0000\u0000\u0164\u0165\u0005:\u0000\u0000"+
		"\u0165\u0166\u0005\u000b\u0000\u0000\u0166\u0167\u0005\u0016\u0000\u0000"+
		"\u0167\u0168\u0005\u0017\u0000\u0000\u0168\u0169\u0005\u0007\u0000\u0000"+
		"\u0169\u016a\u0003\u001e\u000f\u0000\u016a\u016e\u0005\b\u0000\u0000\u016b"+
		"\u016d\u0003\u0006\u0003\u0000\u016c\u016b\u0001\u0000\u0000\u0000\u016d"+
		"\u0170\u0001\u0000\u0000\u0000\u016e\u016c\u0001\u0000\u0000\u0000\u016e"+
		"\u016f\u0001\u0000\u0000\u0000\u016f\u0171\u0001\u0000\u0000\u0000\u0170"+
		"\u016e\u0001\u0000\u0000\u0000\u0171\u0172\u0005\u0004\u0000\u0000\u0172"+
		"\u0173\u0005\u0016\u0000\u0000\u0173\u0174\u0005:\u0000\u0000\u0174\u0176"+
		"\u0001\u0000\u0000\u0000\u0175\u0135\u0001\u0000\u0000\u0000\u0175\u0144"+
		"\u0001\u0000\u0000\u0000\u0175\u0156\u0001\u0000\u0000\u0000\u0175\u0164"+
		"\u0001\u0000\u0000\u0000\u0176\u0019\u0001\u0000\u0000\u0000\u0177\u017b"+
		"\u0005\u0018\u0000\u0000\u0178\u0179\u0005\u0018\u0000\u0000\u0179\u017b"+
		"\u0005:\u0000\u0000\u017a\u0177\u0001\u0000\u0000\u0000\u017a\u0178\u0001"+
		"\u0000\u0000\u0000\u017b\u001b\u0001\u0000\u0000\u0000\u017c\u0180\u0005"+
		"\u0019\u0000\u0000\u017d\u017e\u0005\u0019\u0000\u0000\u017e\u0180\u0005"+
		":\u0000\u0000\u017f\u017c\u0001\u0000\u0000\u0000\u017f\u017d\u0001\u0000"+
		"\u0000\u0000\u0180\u001d\u0001\u0000\u0000\u0000\u0181\u0182\u0006\u000f"+
		"\uffff\uffff\u0000\u0182\u0183\u0005\u001a\u0000\u0000\u0183\u01ac\u0003"+
		"\u001e\u000f\u001b\u0184\u0185\u0005\u001b\u0000\u0000\u0185\u01ac\u0003"+
		"\u001e\u000f\u001a\u0186\u0187\u0005-\u0000\u0000\u0187\u0188\u0005\u0007"+
		"\u0000\u0000\u0188\u0189\u0005:\u0000\u0000\u0189\u01ac\u0005\b\u0000"+
		"\u0000\u018a\u018b\u0005:\u0000\u0000\u018b\u018c\u0005\r\u0000\u0000"+
		"\u018c\u018d\u0003\u001e\u000f\u0000\u018d\u018e\u0005\u000e\u0000\u0000"+
		"\u018e\u01ac\u0001\u0000\u0000\u0000\u018f\u0190\u0005:\u0000\u0000\u0190"+
		"\u0191\u0005\r\u0000\u0000\u0191\u0192\u0003\u001e\u000f\u0000\u0192\u0193"+
		"\u0005\u0005\u0000\u0000\u0193\u0194\u0003\u001e\u000f\u0000\u0194\u0195"+
		"\u0005\u000e\u0000\u0000\u0195\u01ac\u0001\u0000\u0000\u0000\u0196\u01ac"+
		"\u0005:\u0000\u0000\u0197\u01ac\u00058\u0000\u0000\u0198\u01ac\u00057"+
		"\u0000\u0000\u0199\u01ac\u0005;\u0000\u0000\u019a\u01ac\u0005<\u0000\u0000"+
		"\u019b\u01ac\u0005.\u0000\u0000\u019c\u01ac\u0005/\u0000\u0000\u019d\u019e"+
		"\u00050\u0000\u0000\u019e\u01a2\u0003\u001e\u000f\u0000\u019f\u01a1\u0003"+
		" \u0010\u0000\u01a0\u019f\u0001\u0000\u0000\u0000\u01a1\u01a4\u0001\u0000"+
		"\u0000\u0000\u01a2\u01a0\u0001\u0000\u0000\u0000\u01a2\u01a3\u0001\u0000"+
		"\u0000\u0000\u01a3\u01a5\u0001\u0000\u0000\u0000\u01a4\u01a2\u0001\u0000"+
		"\u0000\u0000\u01a5\u01a6\u00051\u0000\u0000\u01a6\u01ac\u0001\u0000\u0000"+
		"\u0000\u01a7\u01a8\u0005\u0007\u0000\u0000\u01a8\u01a9\u0003\u001e\u000f"+
		"\u0000\u01a9\u01aa\u0005\b\u0000\u0000\u01aa\u01ac\u0001\u0000\u0000\u0000"+
		"\u01ab\u0181\u0001\u0000\u0000\u0000\u01ab\u0184\u0001\u0000\u0000\u0000"+
		"\u01ab\u0186\u0001\u0000\u0000\u0000\u01ab\u018a\u0001\u0000\u0000\u0000"+
		"\u01ab\u018f\u0001\u0000\u0000\u0000\u01ab\u0196\u0001\u0000\u0000\u0000"+
		"\u01ab\u0197\u0001\u0000\u0000\u0000\u01ab\u0198\u0001\u0000\u0000\u0000"+
		"\u01ab\u0199\u0001\u0000\u0000\u0000\u01ab\u019a\u0001\u0000\u0000\u0000"+
		"\u01ab\u019b\u0001\u0000\u0000\u0000\u01ab\u019c\u0001\u0000\u0000\u0000"+
		"\u01ab\u019d\u0001\u0000\u0000\u0000\u01ab\u01a7\u0001\u0000\u0000\u0000"+
		"\u01ac\u01d6\u0001\u0000\u0000\u0000\u01ad\u01ae\n\u0019\u0000\u0000\u01ae"+
		"\u01af\u0005\u001c\u0000\u0000\u01af\u01d5\u0003\u001e\u000f\u001a\u01b0"+
		"\u01b1\n\u0018\u0000\u0000\u01b1\u01b2\u0005\u0012\u0000\u0000\u01b2\u01d5"+
		"\u0003\u001e\u000f\u0019\u01b3\u01b4\n\u0017\u0000\u0000\u01b4\u01b5\u0005"+
		"\u001d\u0000\u0000\u01b5\u01d5\u0003\u001e\u000f\u0018\u01b6\u01b7\n\u0016"+
		"\u0000\u0000\u01b7\u01b8\u0005\u001e\u0000\u0000\u01b8\u01d5\u0003\u001e"+
		"\u000f\u0017\u01b9\u01ba\n\u0015\u0000\u0000\u01ba\u01bb\u0005\u001a\u0000"+
		"\u0000\u01bb\u01d5\u0003\u001e\u000f\u0016\u01bc\u01bd\n\u0014\u0000\u0000"+
		"\u01bd\u01be\u0007\u0000\u0000\u0000\u01be\u01d5\u0003\u001e\u000f\u0015"+
		"\u01bf\u01c0\n\u0013\u0000\u0000\u01c0\u01c1\u0007\u0001\u0000\u0000\u01c1"+
		"\u01d5\u0003\u001e\u000f\u0014\u01c2\u01c3\n\u0012\u0000\u0000\u01c3\u01c4"+
		"\u0007\u0002\u0000\u0000\u01c4\u01d5\u0003\u001e\u000f\u0013\u01c5\u01c6"+
		"\n\u0011\u0000\u0000\u01c6\u01c7\u0007\u0003\u0000\u0000\u01c7\u01d5\u0003"+
		"\u001e\u000f\u0012\u01c8\u01c9\n\u0010\u0000\u0000\u01c9\u01ca\u0007\u0004"+
		"\u0000\u0000\u01ca\u01d5\u0003\u001e\u000f\u0011\u01cb\u01cc\n\u000f\u0000"+
		"\u0000\u01cc\u01cd\u0007\u0005\u0000\u0000\u01cd\u01d5\u0003\u001e\u000f"+
		"\u0010\u01ce\u01cf\n\u000e\u0000\u0000\u01cf\u01d0\u0005+\u0000\u0000"+
		"\u01d0\u01d5\u0003\u001e\u000f\u000f\u01d1\u01d2\n\r\u0000\u0000\u01d2"+
		"\u01d3\u0005,\u0000\u0000\u01d3\u01d5\u0003\u001e\u000f\u000e\u01d4\u01ad"+
		"\u0001\u0000\u0000\u0000\u01d4\u01b0\u0001\u0000\u0000\u0000\u01d4\u01b3"+
		"\u0001\u0000\u0000\u0000\u01d4\u01b6\u0001\u0000\u0000\u0000\u01d4\u01b9"+
		"\u0001\u0000\u0000\u0000\u01d4\u01bc\u0001\u0000\u0000\u0000\u01d4\u01bf"+
		"\u0001\u0000\u0000\u0000\u01d4\u01c2\u0001\u0000\u0000\u0000\u01d4\u01c5"+
		"\u0001\u0000\u0000\u0000\u01d4\u01c8\u0001\u0000\u0000\u0000\u01d4\u01cb"+
		"\u0001\u0000\u0000\u0000\u01d4\u01ce\u0001\u0000\u0000\u0000\u01d4\u01d1"+
		"\u0001\u0000\u0000\u0000\u01d5\u01d8\u0001\u0000\u0000\u0000\u01d6\u01d4"+
		"\u0001\u0000\u0000\u0000\u01d6\u01d7\u0001\u0000\u0000\u0000\u01d7\u001f"+
		"\u0001\u0000\u0000\u0000\u01d8\u01d6\u0001\u0000\u0000\u0000\u01d9\u01da"+
		"\u0005\u0005\u0000\u0000\u01da\u01db\u0003\u001e\u000f\u0000\u01db!\u0001"+
		"\u0000\u0000\u0000\u01dc\u01e2\u00052\u0000\u0000\u01dd\u01e2\u00053\u0000"+
		"\u0000\u01de\u01e2\u00054\u0000\u0000\u01df\u01e2\u00055\u0000\u0000\u01e0"+
		"\u01e2\u00056\u0000\u0000\u01e1\u01dc\u0001\u0000\u0000\u0000\u01e1\u01dd"+
		"\u0001\u0000\u0000\u0000\u01e1\u01de\u0001\u0000\u0000\u0000\u01e1\u01df"+
		"\u0001\u0000\u0000\u0000\u01e1\u01e0\u0001\u0000\u0000\u0000\u01e2#\u0001"+
		"\u0000\u0000\u0000 *4C\u0085\u008e\u0091\u0099\u00ae\u00c6\u00cf\u00dd"+
		"\u00eb\u00f2\u0100\u0106\u0114\u011a\u0121\u0127\u0132\u013e\u014f\u015e"+
		"\u016e\u0175\u017a\u017f\u01a2\u01ab\u01d4\u01d6\u01e1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}