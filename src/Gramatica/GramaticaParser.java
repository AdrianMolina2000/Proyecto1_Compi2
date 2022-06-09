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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, INT=15, REAL=16, COMPLEX=17, 
		IDEN=18, CHAR=19, WS=20, COMENTARIO=21;
	public static final int
		RULE_start = 0, RULE_instrucciones = 1, RULE_instrucciones2 = 2, RULE_declaracion = 3, 
		RULE_listaDeclaracion = 4, RULE_print = 5, RULE_expresion = 6, RULE_tipo = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "instrucciones", "instrucciones2", "declaracion", "listaDeclaracion", 
			"print", "expresion", "tipo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'program'", "'implicit'", "'none'", "'end'", "'::'", "'='", "','", 
			"'print'", "'*'", "'integer'", "'real'", "'complex'", "'character'", 
			"'logical'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "INT", "REAL", "COMPLEX", "IDEN", "CHAR", "WS", "COMENTARIO"
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
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(16);
				((StartContext)_localctx).instrucciones = instrucciones();
				Gramatica.Globales.tree.instrucciones.add(((StartContext)_localctx).instrucciones.nodo);
				}
				}
				setState(23);
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
			setState(24);
			match(T__0);
			setState(25);
			((InstruccionesContext)_localctx).id1 = match(IDEN);
			setState(26);
			match(T__1);
			setState(27);
			match(T__2);
			ArrayList<Nodo> instr = new ArrayList<Nodo>();
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13))) != 0)) {
				{
				{
				setState(29);
				((InstruccionesContext)_localctx).instrucciones2 = instrucciones2();
				instr.add(((InstruccionesContext)_localctx).instrucciones2.nodo);
				}
				}
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(37);
			match(T__3);
			setState(38);
			match(T__0);
			setState(39);
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
		public DeclaracionContext declaracion;
		public PrintContext print;
		public DeclaracionContext declaracion() {
			return getRuleContext(DeclaracionContext.class,0);
		}
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
			setState(48);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				((Instrucciones2Context)_localctx).declaracion = declaracion();
				((Instrucciones2Context)_localctx).nodo = ((Instrucciones2Context)_localctx).declaracion.nodo;
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				((Instrucciones2Context)_localctx).print = print();
				((Instrucciones2Context)_localctx).nodo = ((Instrucciones2Context)_localctx).print.nodo;
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
		public Nodo nodo;
		public TipoContext tipo;
		public Token IDEN;
		public ExpresionContext expresion;
		public ListaDeclaracionContext listaDeclaracion;
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public List<ListaDeclaracionContext> listaDeclaracion() {
			return getRuleContexts(ListaDeclaracionContext.class);
		}
		public ListaDeclaracionContext listaDeclaracion(int i) {
			return getRuleContext(ListaDeclaracionContext.class,i);
		}
		public DeclaracionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDeclaracion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracionContext declaracion() throws RecognitionException {
		DeclaracionContext _localctx = new DeclaracionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaracion);

		            ArrayList<Nodo> listDec = new ArrayList<Nodo>();
		        
		int _la;
		try {
			setState(80);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				((DeclaracionContext)_localctx).tipo = tipo();
				setState(51);
				match(T__4);
				setState(52);
				((DeclaracionContext)_localctx).IDEN = match(IDEN);
				setState(53);
				match(T__5);
				setState(54);
				((DeclaracionContext)_localctx).expresion = expresion();
				listDec.add(new Declaracion(((DeclaracionContext)_localctx).tipo.nodo.tipo, (((DeclaracionContext)_localctx).IDEN!=null?((DeclaracionContext)_localctx).IDEN.getText():null), ((DeclaracionContext)_localctx).expresion.nodo, (((DeclaracionContext)_localctx).IDEN!=null?((DeclaracionContext)_localctx).IDEN.getLine():0), (((DeclaracionContext)_localctx).IDEN!=null?((DeclaracionContext)_localctx).IDEN.getCharPositionInLine():0)));
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(56);
					((DeclaracionContext)_localctx).listaDeclaracion = listaDeclaracion(((DeclaracionContext)_localctx).tipo.nodo);
					listDec.add(((DeclaracionContext)_localctx).listaDeclaracion.nodo);
					}
					}
					setState(63);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}

				            ((DeclaracionContext)_localctx).nodo =  new ListaDeclaraciones(listDec, (((DeclaracionContext)_localctx).IDEN!=null?((DeclaracionContext)_localctx).IDEN.getLine():0), (((DeclaracionContext)_localctx).IDEN!=null?((DeclaracionContext)_localctx).IDEN.getCharPositionInLine():0));
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				((DeclaracionContext)_localctx).tipo = tipo();
				setState(67);
				match(T__4);
				setState(68);
				((DeclaracionContext)_localctx).IDEN = match(IDEN);
				listDec.add(new Declaracion(((DeclaracionContext)_localctx).tipo.nodo.tipo, (((DeclaracionContext)_localctx).IDEN!=null?((DeclaracionContext)_localctx).IDEN.getText():null), Globales.defal(((DeclaracionContext)_localctx).tipo.nodo.tipo, (((DeclaracionContext)_localctx).IDEN!=null?((DeclaracionContext)_localctx).IDEN.getLine():0), (((DeclaracionContext)_localctx).IDEN!=null?((DeclaracionContext)_localctx).IDEN.getCharPositionInLine():0)), (((DeclaracionContext)_localctx).IDEN!=null?((DeclaracionContext)_localctx).IDEN.getLine():0), (((DeclaracionContext)_localctx).IDEN!=null?((DeclaracionContext)_localctx).IDEN.getCharPositionInLine():0)));
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(70);
					((DeclaracionContext)_localctx).listaDeclaracion = listaDeclaracion(((DeclaracionContext)_localctx).tipo.nodo);
					listDec.add(((DeclaracionContext)_localctx).listaDeclaracion.nodo);
					}
					}
					setState(77);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}

				            ((DeclaracionContext)_localctx).nodo =  new ListaDeclaraciones(listDec, (((DeclaracionContext)_localctx).IDEN!=null?((DeclaracionContext)_localctx).IDEN.getLine():0), (((DeclaracionContext)_localctx).IDEN!=null?((DeclaracionContext)_localctx).IDEN.getCharPositionInLine():0));
				        
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
		public Tipo type;
		public Nodo nodo;
		public Token IDEN;
		public ExpresionContext expresion;
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public ListaDeclaracionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ListaDeclaracionContext(ParserRuleContext parent, int invokingState, Tipo type) {
			super(parent, invokingState);
			this.type = type;
		}
		@Override public int getRuleIndex() { return RULE_listaDeclaracion; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitListaDeclaracion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListaDeclaracionContext listaDeclaracion(Tipo type) throws RecognitionException {
		ListaDeclaracionContext _localctx = new ListaDeclaracionContext(_ctx, getState(), type);
		enterRule(_localctx, 8, RULE_listaDeclaracion);
		try {
			setState(91);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(82);
				match(T__6);
				setState(83);
				((ListaDeclaracionContext)_localctx).IDEN = match(IDEN);
				setState(84);
				match(T__5);
				setState(85);
				((ListaDeclaracionContext)_localctx).expresion = expresion();
				((ListaDeclaracionContext)_localctx).nodo =  new Declaracion(_localctx.type.tipo, (((ListaDeclaracionContext)_localctx).IDEN!=null?((ListaDeclaracionContext)_localctx).IDEN.getText():null), ((ListaDeclaracionContext)_localctx).expresion.nodo, (((ListaDeclaracionContext)_localctx).IDEN!=null?((ListaDeclaracionContext)_localctx).IDEN.getLine():0), (((ListaDeclaracionContext)_localctx).IDEN!=null?((ListaDeclaracionContext)_localctx).IDEN.getCharPositionInLine():0));
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				match(T__6);
				setState(89);
				((ListaDeclaracionContext)_localctx).IDEN = match(IDEN);
				((ListaDeclaracionContext)_localctx).nodo =  new Declaracion(_localctx.type.tipo, (((ListaDeclaracionContext)_localctx).IDEN!=null?((ListaDeclaracionContext)_localctx).IDEN.getText():null), Globales.defal(_localctx.type.tipo, (((ListaDeclaracionContext)_localctx).IDEN!=null?((ListaDeclaracionContext)_localctx).IDEN.getLine():0), (((ListaDeclaracionContext)_localctx).IDEN!=null?((ListaDeclaracionContext)_localctx).IDEN.getCharPositionInLine():0)), (((ListaDeclaracionContext)_localctx).IDEN!=null?((ListaDeclaracionContext)_localctx).IDEN.getLine():0), (((ListaDeclaracionContext)_localctx).IDEN!=null?((ListaDeclaracionContext)_localctx).IDEN.getCharPositionInLine():0));
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
		enterRule(_localctx, 10, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			((PrintContext)_localctx).p = match(T__7);
			setState(94);
			match(T__8);
			setState(95);
			match(T__6);
			setState(96);
			((PrintContext)_localctx).expresion = expresion();
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
		enterRule(_localctx, 12, RULE_expresion);
		try {
			setState(103);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case REAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				((ExpresionContext)_localctx).REAL = match(REAL);
				((ExpresionContext)_localctx).nodo =  new Primitivo(Tipo.Tipos.REAL, (((ExpresionContext)_localctx).REAL!=null?((ExpresionContext)_localctx).REAL.getText():null), (((ExpresionContext)_localctx).REAL!=null?((ExpresionContext)_localctx).REAL.getLine():0), (((ExpresionContext)_localctx).REAL!=null?((ExpresionContext)_localctx).REAL.getCharPositionInLine():0));
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
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

	public static class TipoContext extends ParserRuleContext {
		public Tipo nodo;
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitTipo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_tipo);
		try {
			setState(115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				match(T__9);
				((TipoContext)_localctx).nodo =  new Tipo(Tipo.Tipos.INTEGER);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				match(T__10);
				((TipoContext)_localctx).nodo =  new Tipo(Tipo.Tipos.REAL);
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 3);
				{
				setState(109);
				match(T__11);
				((TipoContext)_localctx).nodo =  new Tipo(Tipo.Tipos.COMPLEX);
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 4);
				{
				setState(111);
				match(T__12);
				((TipoContext)_localctx).nodo =  new Tipo(Tipo.Tipos.CHARACTER);
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 5);
				{
				setState(113);
				match(T__13);
				((TipoContext)_localctx).nodo =  new Tipo(Tipo.Tipos.LOGICAL);
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
		"\u0004\u0001\u0015v\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0005\u0000\u0014\b\u0000\n\u0000\f\u0000"+
		"\u0017\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001!\b\u0001\n\u0001\f\u0001"+
		"$\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u00021\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003"+
		"<\b\u0003\n\u0003\f\u0003?\t\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0005\u0003J\b\u0003\n\u0003\f\u0003M\t\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003Q\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"\\\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006"+
		"h\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007"+
		"t\b\u0007\u0001\u0007\u0000\u0000\b\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0000\u0000y\u0000\u0015\u0001\u0000\u0000\u0000\u0002\u0018\u0001\u0000"+
		"\u0000\u0000\u00040\u0001\u0000\u0000\u0000\u0006P\u0001\u0000\u0000\u0000"+
		"\b[\u0001\u0000\u0000\u0000\n]\u0001\u0000\u0000\u0000\fg\u0001\u0000"+
		"\u0000\u0000\u000es\u0001\u0000\u0000\u0000\u0010\u0011\u0003\u0002\u0001"+
		"\u0000\u0011\u0012\u0006\u0000\uffff\uffff\u0000\u0012\u0014\u0001\u0000"+
		"\u0000\u0000\u0013\u0010\u0001\u0000\u0000\u0000\u0014\u0017\u0001\u0000"+
		"\u0000\u0000\u0015\u0013\u0001\u0000\u0000\u0000\u0015\u0016\u0001\u0000"+
		"\u0000\u0000\u0016\u0001\u0001\u0000\u0000\u0000\u0017\u0015\u0001\u0000"+
		"\u0000\u0000\u0018\u0019\u0005\u0001\u0000\u0000\u0019\u001a\u0005\u0012"+
		"\u0000\u0000\u001a\u001b\u0005\u0002\u0000\u0000\u001b\u001c\u0005\u0003"+
		"\u0000\u0000\u001c\"\u0006\u0001\uffff\uffff\u0000\u001d\u001e\u0003\u0004"+
		"\u0002\u0000\u001e\u001f\u0006\u0001\uffff\uffff\u0000\u001f!\u0001\u0000"+
		"\u0000\u0000 \u001d\u0001\u0000\u0000\u0000!$\u0001\u0000\u0000\u0000"+
		"\" \u0001\u0000\u0000\u0000\"#\u0001\u0000\u0000\u0000#%\u0001\u0000\u0000"+
		"\u0000$\"\u0001\u0000\u0000\u0000%&\u0005\u0004\u0000\u0000&\'\u0005\u0001"+
		"\u0000\u0000\'(\u0005\u0012\u0000\u0000()\u0006\u0001\uffff\uffff\u0000"+
		")\u0003\u0001\u0000\u0000\u0000*+\u0003\u0006\u0003\u0000+,\u0006\u0002"+
		"\uffff\uffff\u0000,1\u0001\u0000\u0000\u0000-.\u0003\n\u0005\u0000./\u0006"+
		"\u0002\uffff\uffff\u0000/1\u0001\u0000\u0000\u00000*\u0001\u0000\u0000"+
		"\u00000-\u0001\u0000\u0000\u00001\u0005\u0001\u0000\u0000\u000023\u0003"+
		"\u000e\u0007\u000034\u0005\u0005\u0000\u000045\u0005\u0012\u0000\u0000"+
		"56\u0005\u0006\u0000\u000067\u0003\f\u0006\u00007=\u0006\u0003\uffff\uffff"+
		"\u000089\u0003\b\u0004\u00009:\u0006\u0003\uffff\uffff\u0000:<\u0001\u0000"+
		"\u0000\u0000;8\u0001\u0000\u0000\u0000<?\u0001\u0000\u0000\u0000=;\u0001"+
		"\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>@\u0001\u0000\u0000\u0000"+
		"?=\u0001\u0000\u0000\u0000@A\u0006\u0003\uffff\uffff\u0000AQ\u0001\u0000"+
		"\u0000\u0000BC\u0003\u000e\u0007\u0000CD\u0005\u0005\u0000\u0000DE\u0005"+
		"\u0012\u0000\u0000EK\u0006\u0003\uffff\uffff\u0000FG\u0003\b\u0004\u0000"+
		"GH\u0006\u0003\uffff\uffff\u0000HJ\u0001\u0000\u0000\u0000IF\u0001\u0000"+
		"\u0000\u0000JM\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000KL\u0001"+
		"\u0000\u0000\u0000LN\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000"+
		"NO\u0006\u0003\uffff\uffff\u0000OQ\u0001\u0000\u0000\u0000P2\u0001\u0000"+
		"\u0000\u0000PB\u0001\u0000\u0000\u0000Q\u0007\u0001\u0000\u0000\u0000"+
		"RS\u0005\u0007\u0000\u0000ST\u0005\u0012\u0000\u0000TU\u0005\u0006\u0000"+
		"\u0000UV\u0003\f\u0006\u0000VW\u0006\u0004\uffff\uffff\u0000W\\\u0001"+
		"\u0000\u0000\u0000XY\u0005\u0007\u0000\u0000YZ\u0005\u0012\u0000\u0000"+
		"Z\\\u0006\u0004\uffff\uffff\u0000[R\u0001\u0000\u0000\u0000[X\u0001\u0000"+
		"\u0000\u0000\\\t\u0001\u0000\u0000\u0000]^\u0005\b\u0000\u0000^_\u0005"+
		"\t\u0000\u0000_`\u0005\u0007\u0000\u0000`a\u0003\f\u0006\u0000ab\u0006"+
		"\u0005\uffff\uffff\u0000b\u000b\u0001\u0000\u0000\u0000cd\u0005\u0010"+
		"\u0000\u0000dh\u0006\u0006\uffff\uffff\u0000ef\u0005\u000f\u0000\u0000"+
		"fh\u0006\u0006\uffff\uffff\u0000gc\u0001\u0000\u0000\u0000ge\u0001\u0000"+
		"\u0000\u0000h\r\u0001\u0000\u0000\u0000ij\u0005\n\u0000\u0000jt\u0006"+
		"\u0007\uffff\uffff\u0000kl\u0005\u000b\u0000\u0000lt\u0006\u0007\uffff"+
		"\uffff\u0000mn\u0005\f\u0000\u0000nt\u0006\u0007\uffff\uffff\u0000op\u0005"+
		"\r\u0000\u0000pt\u0006\u0007\uffff\uffff\u0000qr\u0005\u000e\u0000\u0000"+
		"rt\u0006\u0007\uffff\uffff\u0000si\u0001\u0000\u0000\u0000sk\u0001\u0000"+
		"\u0000\u0000sm\u0001\u0000\u0000\u0000so\u0001\u0000\u0000\u0000sq\u0001"+
		"\u0000\u0000\u0000t\u000f\u0001\u0000\u0000\u0000\t\u0015\"0=KP[gs";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}