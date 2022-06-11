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
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, INT=52, REAL=53, 
		COMPLEX=54, IDEN=55, CHAR=56, STRING=57, WS=58, COMENTARIO=59;
	public static final int
		RULE_start = 0, RULE_listaInstrucciones = 1, RULE_instrucciones = 2, RULE_instrucciones2 = 3, 
		RULE_declaracion = 4, RULE_listaDeclaracion = 5, RULE_asignacion = 6, 
		RULE_allocate = 7, RULE_print = 8, RULE_listaPrint = 9, RULE_if = 10, 
		RULE_elseif = 11, RULE_do = 12, RULE_expresion = 13, RULE_listaExpresion = 14, 
		RULE_tipo = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "listaInstrucciones", "instrucciones", "instrucciones2", "declaracion", 
			"listaDeclaracion", "asignacion", "allocate", "print", "listaPrint", 
			"if", "elseif", "do", "expresion", "listaExpresion", "tipo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'program'", "'implicit'", "'none'", "'end'", "','", "'dimension'", 
			"'('", "')'", "'::'", "'allocatable'", "':'", "'='", "'['", "']'", "'allocate'", 
			"'deallocate'", "'print'", "'*'", "'if'", "'then'", "'else'", "'do'", 
			"'-'", "'.not.'", "'**'", "'/'", "'+'", "'=='", "'.eq.'", "'/='", "'.ne.'", 
			"'>='", "'.ge.'", "'>'", "'.gt.'", "'<='", "'.le.'", "'<'", "'.lt.'", 
			"'.and.'", "'.or.'", "'size'", "'.true.'", "'.false.'", "'[/'", "'/]'", 
			"'integer'", "'real'", "'complex'", "'character'", "'logical'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "INT", "REAL", "COMPLEX", "IDEN", "CHAR", "STRING", 
			"WS", "COMENTARIO"
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
			setState(32);
			listaInstrucciones();
			setState(33);
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
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(35);
				((ListaInstruccionesContext)_localctx).instrucciones = instrucciones();
				((ListaInstruccionesContext)_localctx).e.add(((ListaInstruccionesContext)_localctx).instrucciones);
				}
				}
				setState(40);
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
			setState(41);
			match(T__0);
			setState(42);
			((InstruccionesProgramContext)_localctx).id1 = match(IDEN);
			setState(43);
			match(T__1);
			setState(44);
			match(T__2);
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__21) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << IDEN))) != 0)) {
				{
				{
				setState(45);
				((InstruccionesProgramContext)_localctx).instrucciones2 = instrucciones2();
				((InstruccionesProgramContext)_localctx).e.add(((InstruccionesProgramContext)_localctx).instrucciones2);
				}
				}
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(51);
			match(T__3);
			setState(52);
			match(T__0);
			setState(53);
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
			setState(61);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__46:
			case T__47:
			case T__48:
			case T__49:
			case T__50:
				_localctx = new Instrucciones2DeclaracionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				declaracion();
				}
				break;
			case IDEN:
				_localctx = new Instrucciones2AsignacionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(56);
				asignacion();
				}
				break;
			case T__14:
			case T__15:
				_localctx = new Instrucciones2AllocateContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(57);
				allocate();
				}
				break;
			case T__16:
				_localctx = new Instrucciones2PrintContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(58);
				print();
				}
				break;
			case T__18:
				_localctx = new Instrucciones2IfContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(59);
				if_();
				}
				break;
			case T__21:
				_localctx = new Instrucciones2DoContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(60);
				do_();
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
			setState(139);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new DeclaracionArray2DimContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				tipo();
				setState(64);
				match(T__4);
				setState(65);
				match(T__5);
				setState(66);
				match(T__6);
				setState(67);
				((DeclaracionArray2DimContext)_localctx).dim1 = match(INT);
				setState(68);
				match(T__4);
				setState(69);
				((DeclaracionArray2DimContext)_localctx).dim2 = match(INT);
				setState(70);
				match(T__7);
				setState(71);
				match(T__8);
				setState(72);
				((DeclaracionArray2DimContext)_localctx).id = match(IDEN);
				}
				break;
			case 2:
				_localctx = new DeclaracionArray1DimContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				tipo();
				setState(75);
				match(T__4);
				setState(76);
				match(T__5);
				setState(77);
				match(T__6);
				setState(78);
				((DeclaracionArray1DimContext)_localctx).dim1 = match(INT);
				setState(79);
				match(T__7);
				setState(80);
				match(T__8);
				setState(81);
				((DeclaracionArray1DimContext)_localctx).id = match(IDEN);
				}
				break;
			case 3:
				_localctx = new DeclaracionAllocatable2DimContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(83);
				tipo();
				setState(84);
				match(T__4);
				setState(85);
				match(T__9);
				setState(86);
				match(T__8);
				setState(87);
				((DeclaracionAllocatable2DimContext)_localctx).id = match(IDEN);
				setState(88);
				match(T__6);
				setState(89);
				match(T__10);
				setState(90);
				match(T__4);
				setState(91);
				match(T__10);
				setState(92);
				match(T__7);
				}
				break;
			case 4:
				_localctx = new DeclaracionAllocatable1DimContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(94);
				tipo();
				setState(95);
				match(T__4);
				setState(96);
				match(T__9);
				setState(97);
				match(T__8);
				setState(98);
				((DeclaracionAllocatable1DimContext)_localctx).id = match(IDEN);
				setState(99);
				match(T__6);
				setState(100);
				match(T__10);
				setState(101);
				match(T__7);
				}
				break;
			case 5:
				_localctx = new DeclaracionArray2Dim2Context(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(103);
				tipo();
				setState(104);
				match(T__8);
				setState(105);
				((DeclaracionArray2Dim2Context)_localctx).id = match(IDEN);
				setState(106);
				match(T__6);
				setState(107);
				((DeclaracionArray2Dim2Context)_localctx).dim1 = match(INT);
				setState(108);
				match(T__4);
				setState(109);
				((DeclaracionArray2Dim2Context)_localctx).dim2 = match(INT);
				setState(110);
				match(T__7);
				}
				break;
			case 6:
				_localctx = new DeclaracionArray1Dim2Context(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(112);
				tipo();
				setState(113);
				match(T__8);
				setState(114);
				((DeclaracionArray1Dim2Context)_localctx).id = match(IDEN);
				setState(115);
				match(T__6);
				setState(116);
				((DeclaracionArray1Dim2Context)_localctx).dim1 = match(INT);
				setState(117);
				match(T__7);
				}
				break;
			case 7:
				_localctx = new DeclaracionAsigContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(119);
				tipo();
				setState(120);
				match(T__8);
				setState(121);
				((DeclaracionAsigContext)_localctx).id = match(IDEN);
				setState(122);
				match(T__11);
				setState(123);
				expresion(0);
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(124);
					((DeclaracionAsigContext)_localctx).listaDeclaracion = listaDeclaracion();
					((DeclaracionAsigContext)_localctx).e.add(((DeclaracionAsigContext)_localctx).listaDeclaracion);
					}
					}
					setState(129);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 8:
				_localctx = new DeclaracionUniqContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(130);
				tipo();
				setState(131);
				match(T__8);
				setState(132);
				((DeclaracionUniqContext)_localctx).id = match(IDEN);
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(133);
					((DeclaracionUniqContext)_localctx).listaDeclaracion = listaDeclaracion();
					((DeclaracionUniqContext)_localctx).e.add(((DeclaracionUniqContext)_localctx).listaDeclaracion);
					}
					}
					setState(138);
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
			setState(147);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new ListaDeclaracionAsigContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(141);
				match(T__4);
				setState(142);
				((ListaDeclaracionAsigContext)_localctx).id = match(IDEN);
				setState(143);
				match(T__11);
				setState(144);
				expresion(0);
				}
				break;
			case 2:
				_localctx = new ListaDeclaracionUniqContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(145);
				match(T__4);
				setState(146);
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
			setState(168);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new AsignacionIdContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(149);
				((AsignacionIdContext)_localctx).id = match(IDEN);
				setState(150);
				match(T__11);
				setState(151);
				expresion(0);
				}
				break;
			case 2:
				_localctx = new AsignacionArray1Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(152);
				((AsignacionArray1Context)_localctx).id = match(IDEN);
				setState(153);
				match(T__12);
				setState(154);
				((AsignacionArray1Context)_localctx).num = expresion(0);
				setState(155);
				match(T__13);
				setState(156);
				match(T__11);
				setState(157);
				((AsignacionArray1Context)_localctx).val = expresion(0);
				}
				break;
			case 3:
				_localctx = new AsignacionArray2Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(159);
				((AsignacionArray2Context)_localctx).id = match(IDEN);
				setState(160);
				match(T__12);
				setState(161);
				((AsignacionArray2Context)_localctx).num1 = expresion(0);
				setState(162);
				match(T__4);
				setState(163);
				((AsignacionArray2Context)_localctx).num2 = expresion(0);
				setState(164);
				match(T__13);
				setState(165);
				match(T__11);
				setState(166);
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
			setState(192);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new Allocate2DimContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				match(T__14);
				setState(171);
				match(T__6);
				setState(172);
				((Allocate2DimContext)_localctx).id = match(IDEN);
				setState(173);
				match(T__6);
				setState(174);
				((Allocate2DimContext)_localctx).val1 = expresion(0);
				setState(175);
				match(T__4);
				setState(176);
				((Allocate2DimContext)_localctx).val2 = expresion(0);
				setState(177);
				match(T__7);
				setState(178);
				match(T__7);
				}
				break;
			case 2:
				_localctx = new Allocate1DimContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(180);
				match(T__14);
				setState(181);
				match(T__6);
				setState(182);
				((Allocate1DimContext)_localctx).id = match(IDEN);
				setState(183);
				match(T__6);
				setState(184);
				((Allocate1DimContext)_localctx).val1 = expresion(0);
				setState(185);
				match(T__7);
				setState(186);
				match(T__7);
				}
				break;
			case 3:
				_localctx = new DeallocateContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(188);
				match(T__15);
				setState(189);
				match(T__6);
				setState(190);
				((DeallocateContext)_localctx).id = match(IDEN);
				setState(191);
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
			setState(194);
			((PrintContext)_localctx).p = match(T__16);
			setState(195);
			match(T__17);
			setState(196);
			match(T__4);
			setState(197);
			((PrintContext)_localctx).val = expresion(0);
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(198);
				((PrintContext)_localctx).listaPrint = listaPrint();
				((PrintContext)_localctx).e.add(((PrintContext)_localctx).listaPrint);
				}
				}
				setState(203);
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
			setState(204);
			match(T__4);
			setState(205);
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
			setState(289);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new IfNormalContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(207);
				((IfNormalContext)_localctx).id = match(T__18);
				setState(208);
				match(T__6);
				setState(209);
				((IfNormalContext)_localctx).cond = expresion(0);
				setState(210);
				match(T__7);
				setState(211);
				match(T__19);
				setState(215);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__21) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << IDEN))) != 0)) {
					{
					{
					setState(212);
					((IfNormalContext)_localctx).instrucciones2 = instrucciones2();
					((IfNormalContext)_localctx).e.add(((IfNormalContext)_localctx).instrucciones2);
					}
					}
					setState(217);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(218);
				match(T__3);
				setState(219);
				match(T__18);
				}
				break;
			case 2:
				_localctx = new IfElseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(221);
				((IfElseContext)_localctx).id = match(T__18);
				setState(222);
				match(T__6);
				setState(223);
				((IfElseContext)_localctx).cond = expresion(0);
				setState(224);
				match(T__7);
				setState(225);
				match(T__19);
				setState(229);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__21) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << IDEN))) != 0)) {
					{
					{
					setState(226);
					((IfElseContext)_localctx).instrucciones2 = instrucciones2();
					((IfElseContext)_localctx).e.add(((IfElseContext)_localctx).instrucciones2);
					}
					}
					setState(231);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(232);
				match(T__20);
				setState(236);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__21) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << IDEN))) != 0)) {
					{
					{
					setState(233);
					((IfElseContext)_localctx).instrucciones2 = instrucciones2();
					((IfElseContext)_localctx).e2.add(((IfElseContext)_localctx).instrucciones2);
					}
					}
					setState(238);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(239);
				match(T__3);
				setState(240);
				match(T__18);
				}
				break;
			case 3:
				_localctx = new IfElseIfContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(242);
				((IfElseIfContext)_localctx).id = match(T__18);
				setState(243);
				match(T__6);
				setState(244);
				((IfElseIfContext)_localctx).cond = expresion(0);
				setState(245);
				match(T__7);
				setState(246);
				match(T__19);
				setState(250);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__21) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << IDEN))) != 0)) {
					{
					{
					setState(247);
					((IfElseIfContext)_localctx).instrucciones2 = instrucciones2();
					((IfElseIfContext)_localctx).e.add(((IfElseIfContext)_localctx).instrucciones2);
					}
					}
					setState(252);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(256);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__20) {
					{
					{
					setState(253);
					((IfElseIfContext)_localctx).elseif = elseif();
					((IfElseIfContext)_localctx).e2.add(((IfElseIfContext)_localctx).elseif);
					}
					}
					setState(258);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(259);
				match(T__3);
				setState(260);
				match(T__18);
				}
				break;
			case 4:
				_localctx = new IfElseIfElseContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(262);
				((IfElseIfElseContext)_localctx).id = match(T__18);
				setState(263);
				match(T__6);
				setState(264);
				((IfElseIfElseContext)_localctx).cond = expresion(0);
				setState(265);
				match(T__7);
				setState(266);
				match(T__19);
				setState(270);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__21) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << IDEN))) != 0)) {
					{
					{
					setState(267);
					((IfElseIfElseContext)_localctx).instrucciones2 = instrucciones2();
					((IfElseIfElseContext)_localctx).e.add(((IfElseIfElseContext)_localctx).instrucciones2);
					}
					}
					setState(272);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(276);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(273);
						((IfElseIfElseContext)_localctx).elseif = elseif();
						((IfElseIfElseContext)_localctx).e2.add(((IfElseIfElseContext)_localctx).elseif);
						}
						} 
					}
					setState(278);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				}
				setState(279);
				match(T__20);
				setState(283);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__21) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << IDEN))) != 0)) {
					{
					{
					setState(280);
					((IfElseIfElseContext)_localctx).instrucciones2 = instrucciones2();
					((IfElseIfElseContext)_localctx).e3.add(((IfElseIfElseContext)_localctx).instrucciones2);
					}
					}
					setState(285);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(286);
				match(T__3);
				setState(287);
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
			setState(291);
			((ElseifContext)_localctx).id = match(T__20);
			setState(292);
			match(T__18);
			setState(293);
			match(T__6);
			setState(294);
			((ElseifContext)_localctx).cond = expresion(0);
			setState(295);
			match(T__7);
			setState(296);
			match(T__19);
			setState(300);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__21) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << IDEN))) != 0)) {
				{
				{
				setState(297);
				((ElseifContext)_localctx).instrucciones2 = instrucciones2();
				((ElseifContext)_localctx).e.add(((ElseifContext)_localctx).instrucciones2);
				}
				}
				setState(302);
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
		public DoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_do; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoContext do_() throws RecognitionException {
		DoContext _localctx = new DoContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_do);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			((DoContext)_localctx).id = match(T__21);
			setState(304);
			((DoContext)_localctx).inicio = asignacion();
			setState(305);
			match(T__4);
			setState(306);
			((DoContext)_localctx).fin = expresion(0);
			setState(307);
			match(T__4);
			setState(308);
			((DoContext)_localctx).paso = expresion(0);
			setState(312);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__21) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << IDEN))) != 0)) {
				{
				{
				setState(309);
				((DoContext)_localctx).instrucciones2 = instrucciones2();
				((DoContext)_localctx).e.add(((DoContext)_localctx).instrucciones2);
				}
				}
				setState(314);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(315);
			match(T__3);
			setState(316);
			match(T__21);
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
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_expresion, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				_localctx = new ExpresionNegativoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(319);
				((ExpresionNegativoContext)_localctx).op = match(T__22);
				setState(320);
				expresion(27);
				}
				break;
			case 2:
				{
				_localctx = new ExpresionNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(321);
				((ExpresionNotContext)_localctx).op = match(T__23);
				setState(322);
				expresion(26);
				}
				break;
			case 3:
				{
				_localctx = new ExpresionSizeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(323);
				((ExpresionSizeContext)_localctx).si = match(T__41);
				setState(324);
				match(T__6);
				setState(325);
				((ExpresionSizeContext)_localctx).val = match(IDEN);
				setState(326);
				match(T__7);
				}
				break;
			case 4:
				{
				_localctx = new ExpresionArray1Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(327);
				((ExpresionArray1Context)_localctx).val = match(IDEN);
				setState(328);
				match(T__12);
				setState(329);
				((ExpresionArray1Context)_localctx).pos = expresion(0);
				setState(330);
				match(T__13);
				}
				break;
			case 5:
				{
				_localctx = new ExpresionArray2Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(332);
				((ExpresionArray2Context)_localctx).val = match(IDEN);
				setState(333);
				match(T__12);
				setState(334);
				((ExpresionArray2Context)_localctx).pos1 = expresion(0);
				setState(335);
				match(T__4);
				setState(336);
				((ExpresionArray2Context)_localctx).pos2 = expresion(0);
				setState(337);
				match(T__13);
				}
				break;
			case 6:
				{
				_localctx = new ExpresionIdentificadorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(339);
				((ExpresionIdentificadorContext)_localctx).val = match(IDEN);
				}
				break;
			case 7:
				{
				_localctx = new ExpresionRealContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(340);
				((ExpresionRealContext)_localctx).val = match(REAL);
				}
				break;
			case 8:
				{
				_localctx = new ExpresionIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(341);
				((ExpresionIntContext)_localctx).val = match(INT);
				}
				break;
			case 9:
				{
				_localctx = new ExpresionCharContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(342);
				((ExpresionCharContext)_localctx).val = match(CHAR);
				}
				break;
			case 10:
				{
				_localctx = new ExpresionStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(343);
				((ExpresionStringContext)_localctx).val = match(STRING);
				}
				break;
			case 11:
				{
				_localctx = new ExpresionTrueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(344);
				((ExpresionTrueContext)_localctx).val = match(T__42);
				}
				break;
			case 12:
				{
				_localctx = new ExpresionFalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(345);
				((ExpresionFalseContext)_localctx).val = match(T__43);
				}
				break;
			case 13:
				{
				_localctx = new ExpresionListaExpresionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(346);
				match(T__44);
				setState(347);
				((ExpresionListaExpresionContext)_localctx).val = expresion(0);
				setState(351);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(348);
					((ExpresionListaExpresionContext)_localctx).listaExpresion = listaExpresion();
					((ExpresionListaExpresionContext)_localctx).e.add(((ExpresionListaExpresionContext)_localctx).listaExpresion);
					}
					}
					setState(353);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(354);
				match(T__45);
				}
				break;
			case 14:
				{
				_localctx = new ExpresionParentesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(356);
				match(T__6);
				setState(357);
				((ExpresionParentesisContext)_localctx).val = expresion(0);
				setState(358);
				match(T__7);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(403);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(401);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
					case 1:
						{
						_localctx = new ExpresionPotenciaContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionPotenciaContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(362);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(363);
						((ExpresionPotenciaContext)_localctx).op = match(T__24);
						setState(364);
						((ExpresionPotenciaContext)_localctx).val2 = expresion(26);
						}
						break;
					case 2:
						{
						_localctx = new ExpresionMultiplicacionContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionMultiplicacionContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(365);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(366);
						((ExpresionMultiplicacionContext)_localctx).op = match(T__17);
						setState(367);
						((ExpresionMultiplicacionContext)_localctx).val2 = expresion(25);
						}
						break;
					case 3:
						{
						_localctx = new ExpresionDivisionContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionDivisionContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(368);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(369);
						((ExpresionDivisionContext)_localctx).op = match(T__25);
						setState(370);
						((ExpresionDivisionContext)_localctx).val2 = expresion(24);
						}
						break;
					case 4:
						{
						_localctx = new ExpresionSumaContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionSumaContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(371);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(372);
						((ExpresionSumaContext)_localctx).op = match(T__26);
						setState(373);
						((ExpresionSumaContext)_localctx).val2 = expresion(23);
						}
						break;
					case 5:
						{
						_localctx = new ExpresionRestaContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionRestaContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(374);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(375);
						((ExpresionRestaContext)_localctx).op = match(T__22);
						setState(376);
						((ExpresionRestaContext)_localctx).val2 = expresion(22);
						}
						break;
					case 6:
						{
						_localctx = new ExpresionEqContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionEqContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(377);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(378);
						((ExpresionEqContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__27 || _la==T__28) ) {
							((ExpresionEqContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(379);
						((ExpresionEqContext)_localctx).val2 = expresion(21);
						}
						break;
					case 7:
						{
						_localctx = new ExpresionNeContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionNeContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(380);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(381);
						((ExpresionNeContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__29 || _la==T__30) ) {
							((ExpresionNeContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(382);
						((ExpresionNeContext)_localctx).val2 = expresion(20);
						}
						break;
					case 8:
						{
						_localctx = new ExpresionGeContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionGeContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(383);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(384);
						((ExpresionGeContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__31 || _la==T__32) ) {
							((ExpresionGeContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(385);
						((ExpresionGeContext)_localctx).val2 = expresion(19);
						}
						break;
					case 9:
						{
						_localctx = new ExpresionGtContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionGtContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(386);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(387);
						((ExpresionGtContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__33 || _la==T__34) ) {
							((ExpresionGtContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(388);
						((ExpresionGtContext)_localctx).val2 = expresion(18);
						}
						break;
					case 10:
						{
						_localctx = new ExpresionLeContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionLeContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(389);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(390);
						((ExpresionLeContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__35 || _la==T__36) ) {
							((ExpresionLeContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(391);
						((ExpresionLeContext)_localctx).val2 = expresion(17);
						}
						break;
					case 11:
						{
						_localctx = new ExpresionLtContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionLtContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(392);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(393);
						((ExpresionLtContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__37 || _la==T__38) ) {
							((ExpresionLtContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(394);
						((ExpresionLtContext)_localctx).val2 = expresion(16);
						}
						break;
					case 12:
						{
						_localctx = new ExpresionAndContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionAndContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(395);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(396);
						((ExpresionAndContext)_localctx).op = match(T__39);
						setState(397);
						((ExpresionAndContext)_localctx).val2 = expresion(15);
						}
						break;
					case 13:
						{
						_localctx = new ExpresionOrContext(new ExpresionContext(_parentctx, _parentState));
						((ExpresionOrContext)_localctx).val1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(398);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(399);
						((ExpresionOrContext)_localctx).op = match(T__40);
						setState(400);
						((ExpresionOrContext)_localctx).val2 = expresion(14);
						}
						break;
					}
					} 
				}
				setState(405);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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
		enterRule(_localctx, 28, RULE_listaExpresion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(406);
			match(T__4);
			setState(407);
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
		enterRule(_localctx, 30, RULE_tipo);
		try {
			setState(414);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__46:
				_localctx = new TipoIntegerContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(409);
				match(T__46);
				}
				break;
			case T__47:
				_localctx = new TipoRealContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(410);
				match(T__47);
				}
				break;
			case T__48:
				_localctx = new TipoComplexContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(411);
				match(T__48);
				}
				break;
			case T__49:
				_localctx = new TipoCharacterContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(412);
				match(T__49);
				}
				break;
			case T__50:
				_localctx = new TipoLogicalContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(413);
				match(T__50);
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
		case 13:
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
		"\u0004\u0001;\u01a1\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0005\u0001%\b\u0001"+
		"\n\u0001\f\u0001(\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0005\u0002/\b\u0002\n\u0002\f\u00022\t\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003>\b\u0003\u0001\u0004"+
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
		"\u0001\u0004\u0005\u0004~\b\u0004\n\u0004\f\u0004\u0081\t\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004\u0087\b\u0004\n"+
		"\u0004\f\u0004\u008a\t\u0004\u0003\u0004\u008c\b\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u0094"+
		"\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0003\u0006\u00a9\b\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007\u00c1\b\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0005\b\u00c8\b\b\n\b\f\b\u00cb\t\b\u0001\t\u0001\t\u0001\t"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u00d6\b\n\n\n"+
		"\f\n\u00d9\t\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0005\n\u00e4\b\n\n\n\f\n\u00e7\t\n\u0001\n\u0001\n\u0005"+
		"\n\u00eb\b\n\n\n\f\n\u00ee\t\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u00f9\b\n\n\n\f\n\u00fc\t\n\u0001"+
		"\n\u0005\n\u00ff\b\n\n\n\f\n\u0102\t\n\u0001\n\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u010d\b\n\n\n\f\n\u0110"+
		"\t\n\u0001\n\u0005\n\u0113\b\n\n\n\f\n\u0116\t\n\u0001\n\u0001\n\u0005"+
		"\n\u011a\b\n\n\n\f\n\u011d\t\n\u0001\n\u0001\n\u0001\n\u0003\n\u0122\b"+
		"\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0005\u000b\u012b\b\u000b\n\u000b\f\u000b\u012e\t\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u0137\b\f\n"+
		"\f\f\f\u013a\t\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0005\r\u015e\b\r\n\r\f\r\u0161\t\r\u0001\r\u0001\r\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0003\r\u0169\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u0192"+
		"\b\r\n\r\f\r\u0195\t\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u019f\b\u000f"+
		"\u0001\u000f\u0000\u0001\u001a\u0010\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e\u0000\u0006\u0001\u0000"+
		"\u001c\u001d\u0001\u0000\u001e\u001f\u0001\u0000 !\u0001\u0000\"#\u0001"+
		"\u0000$%\u0001\u0000&\'\u01d2\u0000 \u0001\u0000\u0000\u0000\u0002&\u0001"+
		"\u0000\u0000\u0000\u0004)\u0001\u0000\u0000\u0000\u0006=\u0001\u0000\u0000"+
		"\u0000\b\u008b\u0001\u0000\u0000\u0000\n\u0093\u0001\u0000\u0000\u0000"+
		"\f\u00a8\u0001\u0000\u0000\u0000\u000e\u00c0\u0001\u0000\u0000\u0000\u0010"+
		"\u00c2\u0001\u0000\u0000\u0000\u0012\u00cc\u0001\u0000\u0000\u0000\u0014"+
		"\u0121\u0001\u0000\u0000\u0000\u0016\u0123\u0001\u0000\u0000\u0000\u0018"+
		"\u012f\u0001\u0000\u0000\u0000\u001a\u0168\u0001\u0000\u0000\u0000\u001c"+
		"\u0196\u0001\u0000\u0000\u0000\u001e\u019e\u0001\u0000\u0000\u0000 !\u0003"+
		"\u0002\u0001\u0000!\"\u0005\u0000\u0000\u0001\"\u0001\u0001\u0000\u0000"+
		"\u0000#%\u0003\u0004\u0002\u0000$#\u0001\u0000\u0000\u0000%(\u0001\u0000"+
		"\u0000\u0000&$\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000\'\u0003"+
		"\u0001\u0000\u0000\u0000(&\u0001\u0000\u0000\u0000)*\u0005\u0001\u0000"+
		"\u0000*+\u00057\u0000\u0000+,\u0005\u0002\u0000\u0000,0\u0005\u0003\u0000"+
		"\u0000-/\u0003\u0006\u0003\u0000.-\u0001\u0000\u0000\u0000/2\u0001\u0000"+
		"\u0000\u00000.\u0001\u0000\u0000\u000001\u0001\u0000\u0000\u000013\u0001"+
		"\u0000\u0000\u000020\u0001\u0000\u0000\u000034\u0005\u0004\u0000\u0000"+
		"45\u0005\u0001\u0000\u000056\u00057\u0000\u00006\u0005\u0001\u0000\u0000"+
		"\u00007>\u0003\b\u0004\u00008>\u0003\f\u0006\u00009>\u0003\u000e\u0007"+
		"\u0000:>\u0003\u0010\b\u0000;>\u0003\u0014\n\u0000<>\u0003\u0018\f\u0000"+
		"=7\u0001\u0000\u0000\u0000=8\u0001\u0000\u0000\u0000=9\u0001\u0000\u0000"+
		"\u0000=:\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000=<\u0001\u0000"+
		"\u0000\u0000>\u0007\u0001\u0000\u0000\u0000?@\u0003\u001e\u000f\u0000"+
		"@A\u0005\u0005\u0000\u0000AB\u0005\u0006\u0000\u0000BC\u0005\u0007\u0000"+
		"\u0000CD\u00054\u0000\u0000DE\u0005\u0005\u0000\u0000EF\u00054\u0000\u0000"+
		"FG\u0005\b\u0000\u0000GH\u0005\t\u0000\u0000HI\u00057\u0000\u0000I\u008c"+
		"\u0001\u0000\u0000\u0000JK\u0003\u001e\u000f\u0000KL\u0005\u0005\u0000"+
		"\u0000LM\u0005\u0006\u0000\u0000MN\u0005\u0007\u0000\u0000NO\u00054\u0000"+
		"\u0000OP\u0005\b\u0000\u0000PQ\u0005\t\u0000\u0000QR\u00057\u0000\u0000"+
		"R\u008c\u0001\u0000\u0000\u0000ST\u0003\u001e\u000f\u0000TU\u0005\u0005"+
		"\u0000\u0000UV\u0005\n\u0000\u0000VW\u0005\t\u0000\u0000WX\u00057\u0000"+
		"\u0000XY\u0005\u0007\u0000\u0000YZ\u0005\u000b\u0000\u0000Z[\u0005\u0005"+
		"\u0000\u0000[\\\u0005\u000b\u0000\u0000\\]\u0005\b\u0000\u0000]\u008c"+
		"\u0001\u0000\u0000\u0000^_\u0003\u001e\u000f\u0000_`\u0005\u0005\u0000"+
		"\u0000`a\u0005\n\u0000\u0000ab\u0005\t\u0000\u0000bc\u00057\u0000\u0000"+
		"cd\u0005\u0007\u0000\u0000de\u0005\u000b\u0000\u0000ef\u0005\b\u0000\u0000"+
		"f\u008c\u0001\u0000\u0000\u0000gh\u0003\u001e\u000f\u0000hi\u0005\t\u0000"+
		"\u0000ij\u00057\u0000\u0000jk\u0005\u0007\u0000\u0000kl\u00054\u0000\u0000"+
		"lm\u0005\u0005\u0000\u0000mn\u00054\u0000\u0000no\u0005\b\u0000\u0000"+
		"o\u008c\u0001\u0000\u0000\u0000pq\u0003\u001e\u000f\u0000qr\u0005\t\u0000"+
		"\u0000rs\u00057\u0000\u0000st\u0005\u0007\u0000\u0000tu\u00054\u0000\u0000"+
		"uv\u0005\b\u0000\u0000v\u008c\u0001\u0000\u0000\u0000wx\u0003\u001e\u000f"+
		"\u0000xy\u0005\t\u0000\u0000yz\u00057\u0000\u0000z{\u0005\f\u0000\u0000"+
		"{\u007f\u0003\u001a\r\u0000|~\u0003\n\u0005\u0000}|\u0001\u0000\u0000"+
		"\u0000~\u0081\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u007f"+
		"\u0080\u0001\u0000\u0000\u0000\u0080\u008c\u0001\u0000\u0000\u0000\u0081"+
		"\u007f\u0001\u0000\u0000\u0000\u0082\u0083\u0003\u001e\u000f\u0000\u0083"+
		"\u0084\u0005\t\u0000\u0000\u0084\u0088\u00057\u0000\u0000\u0085\u0087"+
		"\u0003\n\u0005\u0000\u0086\u0085\u0001\u0000\u0000\u0000\u0087\u008a\u0001"+
		"\u0000\u0000\u0000\u0088\u0086\u0001\u0000\u0000\u0000\u0088\u0089\u0001"+
		"\u0000\u0000\u0000\u0089\u008c\u0001\u0000\u0000\u0000\u008a\u0088\u0001"+
		"\u0000\u0000\u0000\u008b?\u0001\u0000\u0000\u0000\u008bJ\u0001\u0000\u0000"+
		"\u0000\u008bS\u0001\u0000\u0000\u0000\u008b^\u0001\u0000\u0000\u0000\u008b"+
		"g\u0001\u0000\u0000\u0000\u008bp\u0001\u0000\u0000\u0000\u008bw\u0001"+
		"\u0000\u0000\u0000\u008b\u0082\u0001\u0000\u0000\u0000\u008c\t\u0001\u0000"+
		"\u0000\u0000\u008d\u008e\u0005\u0005\u0000\u0000\u008e\u008f\u00057\u0000"+
		"\u0000\u008f\u0090\u0005\f\u0000\u0000\u0090\u0094\u0003\u001a\r\u0000"+
		"\u0091\u0092\u0005\u0005\u0000\u0000\u0092\u0094\u00057\u0000\u0000\u0093"+
		"\u008d\u0001\u0000\u0000\u0000\u0093\u0091\u0001\u0000\u0000\u0000\u0094"+
		"\u000b\u0001\u0000\u0000\u0000\u0095\u0096\u00057\u0000\u0000\u0096\u0097"+
		"\u0005\f\u0000\u0000\u0097\u00a9\u0003\u001a\r\u0000\u0098\u0099\u0005"+
		"7\u0000\u0000\u0099\u009a\u0005\r\u0000\u0000\u009a\u009b\u0003\u001a"+
		"\r\u0000\u009b\u009c\u0005\u000e\u0000\u0000\u009c\u009d\u0005\f\u0000"+
		"\u0000\u009d\u009e\u0003\u001a\r\u0000\u009e\u00a9\u0001\u0000\u0000\u0000"+
		"\u009f\u00a0\u00057\u0000\u0000\u00a0\u00a1\u0005\r\u0000\u0000\u00a1"+
		"\u00a2\u0003\u001a\r\u0000\u00a2\u00a3\u0005\u0005\u0000\u0000\u00a3\u00a4"+
		"\u0003\u001a\r\u0000\u00a4\u00a5\u0005\u000e\u0000\u0000\u00a5\u00a6\u0005"+
		"\f\u0000\u0000\u00a6\u00a7\u0003\u001a\r\u0000\u00a7\u00a9\u0001\u0000"+
		"\u0000\u0000\u00a8\u0095\u0001\u0000\u0000\u0000\u00a8\u0098\u0001\u0000"+
		"\u0000\u0000\u00a8\u009f\u0001\u0000\u0000\u0000\u00a9\r\u0001\u0000\u0000"+
		"\u0000\u00aa\u00ab\u0005\u000f\u0000\u0000\u00ab\u00ac\u0005\u0007\u0000"+
		"\u0000\u00ac\u00ad\u00057\u0000\u0000\u00ad\u00ae\u0005\u0007\u0000\u0000"+
		"\u00ae\u00af\u0003\u001a\r\u0000\u00af\u00b0\u0005\u0005\u0000\u0000\u00b0"+
		"\u00b1\u0003\u001a\r\u0000\u00b1\u00b2\u0005\b\u0000\u0000\u00b2\u00b3"+
		"\u0005\b\u0000\u0000\u00b3\u00c1\u0001\u0000\u0000\u0000\u00b4\u00b5\u0005"+
		"\u000f\u0000\u0000\u00b5\u00b6\u0005\u0007\u0000\u0000\u00b6\u00b7\u0005"+
		"7\u0000\u0000\u00b7\u00b8\u0005\u0007\u0000\u0000\u00b8\u00b9\u0003\u001a"+
		"\r\u0000\u00b9\u00ba\u0005\b\u0000\u0000\u00ba\u00bb\u0005\b\u0000\u0000"+
		"\u00bb\u00c1\u0001\u0000\u0000\u0000\u00bc\u00bd\u0005\u0010\u0000\u0000"+
		"\u00bd\u00be\u0005\u0007\u0000\u0000\u00be\u00bf\u00057\u0000\u0000\u00bf"+
		"\u00c1\u0005\b\u0000\u0000\u00c0\u00aa\u0001\u0000\u0000\u0000\u00c0\u00b4"+
		"\u0001\u0000\u0000\u0000\u00c0\u00bc\u0001\u0000\u0000\u0000\u00c1\u000f"+
		"\u0001\u0000\u0000\u0000\u00c2\u00c3\u0005\u0011\u0000\u0000\u00c3\u00c4"+
		"\u0005\u0012\u0000\u0000\u00c4\u00c5\u0005\u0005\u0000\u0000\u00c5\u00c9"+
		"\u0003\u001a\r\u0000\u00c6\u00c8\u0003\u0012\t\u0000\u00c7\u00c6\u0001"+
		"\u0000\u0000\u0000\u00c8\u00cb\u0001\u0000\u0000\u0000\u00c9\u00c7\u0001"+
		"\u0000\u0000\u0000\u00c9\u00ca\u0001\u0000\u0000\u0000\u00ca\u0011\u0001"+
		"\u0000\u0000\u0000\u00cb\u00c9\u0001\u0000\u0000\u0000\u00cc\u00cd\u0005"+
		"\u0005\u0000\u0000\u00cd\u00ce\u0003\u001a\r\u0000\u00ce\u0013\u0001\u0000"+
		"\u0000\u0000\u00cf\u00d0\u0005\u0013\u0000\u0000\u00d0\u00d1\u0005\u0007"+
		"\u0000\u0000\u00d1\u00d2\u0003\u001a\r\u0000\u00d2\u00d3\u0005\b\u0000"+
		"\u0000\u00d3\u00d7\u0005\u0014\u0000\u0000\u00d4\u00d6\u0003\u0006\u0003"+
		"\u0000\u00d5\u00d4\u0001\u0000\u0000\u0000\u00d6\u00d9\u0001\u0000\u0000"+
		"\u0000\u00d7\u00d5\u0001\u0000\u0000\u0000\u00d7\u00d8\u0001\u0000\u0000"+
		"\u0000\u00d8\u00da\u0001\u0000\u0000\u0000\u00d9\u00d7\u0001\u0000\u0000"+
		"\u0000\u00da\u00db\u0005\u0004\u0000\u0000\u00db\u00dc\u0005\u0013\u0000"+
		"\u0000\u00dc\u0122\u0001\u0000\u0000\u0000\u00dd\u00de\u0005\u0013\u0000"+
		"\u0000\u00de\u00df\u0005\u0007\u0000\u0000\u00df\u00e0\u0003\u001a\r\u0000"+
		"\u00e0\u00e1\u0005\b\u0000\u0000\u00e1\u00e5\u0005\u0014\u0000\u0000\u00e2"+
		"\u00e4\u0003\u0006\u0003\u0000\u00e3\u00e2\u0001\u0000\u0000\u0000\u00e4"+
		"\u00e7\u0001\u0000\u0000\u0000\u00e5\u00e3\u0001\u0000\u0000\u0000\u00e5"+
		"\u00e6\u0001\u0000\u0000\u0000\u00e6\u00e8\u0001\u0000\u0000\u0000\u00e7"+
		"\u00e5\u0001\u0000\u0000\u0000\u00e8\u00ec\u0005\u0015\u0000\u0000\u00e9"+
		"\u00eb\u0003\u0006\u0003\u0000\u00ea\u00e9\u0001\u0000\u0000\u0000\u00eb"+
		"\u00ee\u0001\u0000\u0000\u0000\u00ec\u00ea\u0001\u0000\u0000\u0000\u00ec"+
		"\u00ed\u0001\u0000\u0000\u0000\u00ed\u00ef\u0001\u0000\u0000\u0000\u00ee"+
		"\u00ec\u0001\u0000\u0000\u0000\u00ef\u00f0\u0005\u0004\u0000\u0000\u00f0"+
		"\u00f1\u0005\u0013\u0000\u0000\u00f1\u0122\u0001\u0000\u0000\u0000\u00f2"+
		"\u00f3\u0005\u0013\u0000\u0000\u00f3\u00f4\u0005\u0007\u0000\u0000\u00f4"+
		"\u00f5\u0003\u001a\r\u0000\u00f5\u00f6\u0005\b\u0000\u0000\u00f6\u00fa"+
		"\u0005\u0014\u0000\u0000\u00f7\u00f9\u0003\u0006\u0003\u0000\u00f8\u00f7"+
		"\u0001\u0000\u0000\u0000\u00f9\u00fc\u0001\u0000\u0000\u0000\u00fa\u00f8"+
		"\u0001\u0000\u0000\u0000\u00fa\u00fb\u0001\u0000\u0000\u0000\u00fb\u0100"+
		"\u0001\u0000\u0000\u0000\u00fc\u00fa\u0001\u0000\u0000\u0000\u00fd\u00ff"+
		"\u0003\u0016\u000b\u0000\u00fe\u00fd\u0001\u0000\u0000\u0000\u00ff\u0102"+
		"\u0001\u0000\u0000\u0000\u0100\u00fe\u0001\u0000\u0000\u0000\u0100\u0101"+
		"\u0001\u0000\u0000\u0000\u0101\u0103\u0001\u0000\u0000\u0000\u0102\u0100"+
		"\u0001\u0000\u0000\u0000\u0103\u0104\u0005\u0004\u0000\u0000\u0104\u0105"+
		"\u0005\u0013\u0000\u0000\u0105\u0122\u0001\u0000\u0000\u0000\u0106\u0107"+
		"\u0005\u0013\u0000\u0000\u0107\u0108\u0005\u0007\u0000\u0000\u0108\u0109"+
		"\u0003\u001a\r\u0000\u0109\u010a\u0005\b\u0000\u0000\u010a\u010e\u0005"+
		"\u0014\u0000\u0000\u010b\u010d\u0003\u0006\u0003\u0000\u010c\u010b\u0001"+
		"\u0000\u0000\u0000\u010d\u0110\u0001\u0000\u0000\u0000\u010e\u010c\u0001"+
		"\u0000\u0000\u0000\u010e\u010f\u0001\u0000\u0000\u0000\u010f\u0114\u0001"+
		"\u0000\u0000\u0000\u0110\u010e\u0001\u0000\u0000\u0000\u0111\u0113\u0003"+
		"\u0016\u000b\u0000\u0112\u0111\u0001\u0000\u0000\u0000\u0113\u0116\u0001"+
		"\u0000\u0000\u0000\u0114\u0112\u0001\u0000\u0000\u0000\u0114\u0115\u0001"+
		"\u0000\u0000\u0000\u0115\u0117\u0001\u0000\u0000\u0000\u0116\u0114\u0001"+
		"\u0000\u0000\u0000\u0117\u011b\u0005\u0015\u0000\u0000\u0118\u011a\u0003"+
		"\u0006\u0003\u0000\u0119\u0118\u0001\u0000\u0000\u0000\u011a\u011d\u0001"+
		"\u0000\u0000\u0000\u011b\u0119\u0001\u0000\u0000\u0000\u011b\u011c\u0001"+
		"\u0000\u0000\u0000\u011c\u011e\u0001\u0000\u0000\u0000\u011d\u011b\u0001"+
		"\u0000\u0000\u0000\u011e\u011f\u0005\u0004\u0000\u0000\u011f\u0120\u0005"+
		"\u0013\u0000\u0000\u0120\u0122\u0001\u0000\u0000\u0000\u0121\u00cf\u0001"+
		"\u0000\u0000\u0000\u0121\u00dd\u0001\u0000\u0000\u0000\u0121\u00f2\u0001"+
		"\u0000\u0000\u0000\u0121\u0106\u0001\u0000\u0000\u0000\u0122\u0015\u0001"+
		"\u0000\u0000\u0000\u0123\u0124\u0005\u0015\u0000\u0000\u0124\u0125\u0005"+
		"\u0013\u0000\u0000\u0125\u0126\u0005\u0007\u0000\u0000\u0126\u0127\u0003"+
		"\u001a\r\u0000\u0127\u0128\u0005\b\u0000\u0000\u0128\u012c\u0005\u0014"+
		"\u0000\u0000\u0129\u012b\u0003\u0006\u0003\u0000\u012a\u0129\u0001\u0000"+
		"\u0000\u0000\u012b\u012e\u0001\u0000\u0000\u0000\u012c\u012a\u0001\u0000"+
		"\u0000\u0000\u012c\u012d\u0001\u0000\u0000\u0000\u012d\u0017\u0001\u0000"+
		"\u0000\u0000\u012e\u012c\u0001\u0000\u0000\u0000\u012f\u0130\u0005\u0016"+
		"\u0000\u0000\u0130\u0131\u0003\f\u0006\u0000\u0131\u0132\u0005\u0005\u0000"+
		"\u0000\u0132\u0133\u0003\u001a\r\u0000\u0133\u0134\u0005\u0005\u0000\u0000"+
		"\u0134\u0138\u0003\u001a\r\u0000\u0135\u0137\u0003\u0006\u0003\u0000\u0136"+
		"\u0135\u0001\u0000\u0000\u0000\u0137\u013a\u0001\u0000\u0000\u0000\u0138"+
		"\u0136\u0001\u0000\u0000\u0000\u0138\u0139\u0001\u0000\u0000\u0000\u0139"+
		"\u013b\u0001\u0000\u0000\u0000\u013a\u0138\u0001\u0000\u0000\u0000\u013b"+
		"\u013c\u0005\u0004\u0000\u0000\u013c\u013d\u0005\u0016\u0000\u0000\u013d"+
		"\u0019\u0001\u0000\u0000\u0000\u013e\u013f\u0006\r\uffff\uffff\u0000\u013f"+
		"\u0140\u0005\u0017\u0000\u0000\u0140\u0169\u0003\u001a\r\u001b\u0141\u0142"+
		"\u0005\u0018\u0000\u0000\u0142\u0169\u0003\u001a\r\u001a\u0143\u0144\u0005"+
		"*\u0000\u0000\u0144\u0145\u0005\u0007\u0000\u0000\u0145\u0146\u00057\u0000"+
		"\u0000\u0146\u0169\u0005\b\u0000\u0000\u0147\u0148\u00057\u0000\u0000"+
		"\u0148\u0149\u0005\r\u0000\u0000\u0149\u014a\u0003\u001a\r\u0000\u014a"+
		"\u014b\u0005\u000e\u0000\u0000\u014b\u0169\u0001\u0000\u0000\u0000\u014c"+
		"\u014d\u00057\u0000\u0000\u014d\u014e\u0005\r\u0000\u0000\u014e\u014f"+
		"\u0003\u001a\r\u0000\u014f\u0150\u0005\u0005\u0000\u0000\u0150\u0151\u0003"+
		"\u001a\r\u0000\u0151\u0152\u0005\u000e\u0000\u0000\u0152\u0169\u0001\u0000"+
		"\u0000\u0000\u0153\u0169\u00057\u0000\u0000\u0154\u0169\u00055\u0000\u0000"+
		"\u0155\u0169\u00054\u0000\u0000\u0156\u0169\u00058\u0000\u0000\u0157\u0169"+
		"\u00059\u0000\u0000\u0158\u0169\u0005+\u0000\u0000\u0159\u0169\u0005,"+
		"\u0000\u0000\u015a\u015b\u0005-\u0000\u0000\u015b\u015f\u0003\u001a\r"+
		"\u0000\u015c\u015e\u0003\u001c\u000e\u0000\u015d\u015c\u0001\u0000\u0000"+
		"\u0000\u015e\u0161\u0001\u0000\u0000\u0000\u015f\u015d\u0001\u0000\u0000"+
		"\u0000\u015f\u0160\u0001\u0000\u0000\u0000\u0160\u0162\u0001\u0000\u0000"+
		"\u0000\u0161\u015f\u0001\u0000\u0000\u0000\u0162\u0163\u0005.\u0000\u0000"+
		"\u0163\u0169\u0001\u0000\u0000\u0000\u0164\u0165\u0005\u0007\u0000\u0000"+
		"\u0165\u0166\u0003\u001a\r\u0000\u0166\u0167\u0005\b\u0000\u0000\u0167"+
		"\u0169\u0001\u0000\u0000\u0000\u0168\u013e\u0001\u0000\u0000\u0000\u0168"+
		"\u0141\u0001\u0000\u0000\u0000\u0168\u0143\u0001\u0000\u0000\u0000\u0168"+
		"\u0147\u0001\u0000\u0000\u0000\u0168\u014c\u0001\u0000\u0000\u0000\u0168"+
		"\u0153\u0001\u0000\u0000\u0000\u0168\u0154\u0001\u0000\u0000\u0000\u0168"+
		"\u0155\u0001\u0000\u0000\u0000\u0168\u0156\u0001\u0000\u0000\u0000\u0168"+
		"\u0157\u0001\u0000\u0000\u0000\u0168\u0158\u0001\u0000\u0000\u0000\u0168"+
		"\u0159\u0001\u0000\u0000\u0000\u0168\u015a\u0001\u0000\u0000\u0000\u0168"+
		"\u0164\u0001\u0000\u0000\u0000\u0169\u0193\u0001\u0000\u0000\u0000\u016a"+
		"\u016b\n\u0019\u0000\u0000\u016b\u016c\u0005\u0019\u0000\u0000\u016c\u0192"+
		"\u0003\u001a\r\u001a\u016d\u016e\n\u0018\u0000\u0000\u016e\u016f\u0005"+
		"\u0012\u0000\u0000\u016f\u0192\u0003\u001a\r\u0019\u0170\u0171\n\u0017"+
		"\u0000\u0000\u0171\u0172\u0005\u001a\u0000\u0000\u0172\u0192\u0003\u001a"+
		"\r\u0018\u0173\u0174\n\u0016\u0000\u0000\u0174\u0175\u0005\u001b\u0000"+
		"\u0000\u0175\u0192\u0003\u001a\r\u0017\u0176\u0177\n\u0015\u0000\u0000"+
		"\u0177\u0178\u0005\u0017\u0000\u0000\u0178\u0192\u0003\u001a\r\u0016\u0179"+
		"\u017a\n\u0014\u0000\u0000\u017a\u017b\u0007\u0000\u0000\u0000\u017b\u0192"+
		"\u0003\u001a\r\u0015\u017c\u017d\n\u0013\u0000\u0000\u017d\u017e\u0007"+
		"\u0001\u0000\u0000\u017e\u0192\u0003\u001a\r\u0014\u017f\u0180\n\u0012"+
		"\u0000\u0000\u0180\u0181\u0007\u0002\u0000\u0000\u0181\u0192\u0003\u001a"+
		"\r\u0013\u0182\u0183\n\u0011\u0000\u0000\u0183\u0184\u0007\u0003\u0000"+
		"\u0000\u0184\u0192\u0003\u001a\r\u0012\u0185\u0186\n\u0010\u0000\u0000"+
		"\u0186\u0187\u0007\u0004\u0000\u0000\u0187\u0192\u0003\u001a\r\u0011\u0188"+
		"\u0189\n\u000f\u0000\u0000\u0189\u018a\u0007\u0005\u0000\u0000\u018a\u0192"+
		"\u0003\u001a\r\u0010\u018b\u018c\n\u000e\u0000\u0000\u018c\u018d\u0005"+
		"(\u0000\u0000\u018d\u0192\u0003\u001a\r\u000f\u018e\u018f\n\r\u0000\u0000"+
		"\u018f\u0190\u0005)\u0000\u0000\u0190\u0192\u0003\u001a\r\u000e\u0191"+
		"\u016a\u0001\u0000\u0000\u0000\u0191\u016d\u0001\u0000\u0000\u0000\u0191"+
		"\u0170\u0001\u0000\u0000\u0000\u0191\u0173\u0001\u0000\u0000\u0000\u0191"+
		"\u0176\u0001\u0000\u0000\u0000\u0191\u0179\u0001\u0000\u0000\u0000\u0191"+
		"\u017c\u0001\u0000\u0000\u0000\u0191\u017f\u0001\u0000\u0000\u0000\u0191"+
		"\u0182\u0001\u0000\u0000\u0000\u0191\u0185\u0001\u0000\u0000\u0000\u0191"+
		"\u0188\u0001\u0000\u0000\u0000\u0191\u018b\u0001\u0000\u0000\u0000\u0191"+
		"\u018e\u0001\u0000\u0000\u0000\u0192\u0195\u0001\u0000\u0000\u0000\u0193"+
		"\u0191\u0001\u0000\u0000\u0000\u0193\u0194\u0001\u0000\u0000\u0000\u0194"+
		"\u001b\u0001\u0000\u0000\u0000\u0195\u0193\u0001\u0000\u0000\u0000\u0196"+
		"\u0197\u0005\u0005\u0000\u0000\u0197\u0198\u0003\u001a\r\u0000\u0198\u001d"+
		"\u0001\u0000\u0000\u0000\u0199\u019f\u0005/\u0000\u0000\u019a\u019f\u0005"+
		"0\u0000\u0000\u019b\u019f\u00051\u0000\u0000\u019c\u019f\u00052\u0000"+
		"\u0000\u019d\u019f\u00053\u0000\u0000\u019e\u0199\u0001\u0000\u0000\u0000"+
		"\u019e\u019a\u0001\u0000\u0000\u0000\u019e\u019b\u0001\u0000\u0000\u0000"+
		"\u019e\u019c\u0001\u0000\u0000\u0000\u019e\u019d\u0001\u0000\u0000\u0000"+
		"\u019f\u001f\u0001\u0000\u0000\u0000\u001a&0=\u007f\u0088\u008b\u0093"+
		"\u00a8\u00c0\u00c9\u00d7\u00e5\u00ec\u00fa\u0100\u010e\u0114\u011b\u0121"+
		"\u012c\u0138\u015f\u0168\u0191\u0193\u019e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}