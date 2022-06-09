// Generated from C:/Users/adria/OneDrive/Escritorio/Compi2/Proyecto1/src\Gramatica.g4 by ANTLR 4.10.1
package Gramatica;

    import java.util.List;
    import java.util.ArrayList;
    import Abstract.*;
    import Expresiones.*;
    import Instrucciones.*;
    import Other.*;
    import Symbols.*;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GramaticaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GramaticaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(GramaticaParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#listaInstrucciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListaInstrucciones(GramaticaParser.ListaInstruccionesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code instruccionesProgram}
	 * labeled alternative in {@link GramaticaParser#instrucciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruccionesProgram(GramaticaParser.InstruccionesProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code instrucciones2Declaracion}
	 * labeled alternative in {@link GramaticaParser#instrucciones2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrucciones2Declaracion(GramaticaParser.Instrucciones2DeclaracionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code instrucciones2Print}
	 * labeled alternative in {@link GramaticaParser#instrucciones2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrucciones2Print(GramaticaParser.Instrucciones2PrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code instrucciones2Asignacion}
	 * labeled alternative in {@link GramaticaParser#instrucciones2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrucciones2Asignacion(GramaticaParser.Instrucciones2AsignacionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declaracionAsig}
	 * labeled alternative in {@link GramaticaParser#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionAsig(GramaticaParser.DeclaracionAsigContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declaracionUniq}
	 * labeled alternative in {@link GramaticaParser#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionUniq(GramaticaParser.DeclaracionUniqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code listaDeclaracionAsig}
	 * labeled alternative in {@link GramaticaParser#listaDeclaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListaDeclaracionAsig(GramaticaParser.ListaDeclaracionAsigContext ctx);
	/**
	 * Visit a parse tree produced by the {@code listaDeclaracionUniq}
	 * labeled alternative in {@link GramaticaParser#listaDeclaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListaDeclaracionUniq(GramaticaParser.ListaDeclaracionUniqContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#asignacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignacion(GramaticaParser.AsignacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(GramaticaParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#listaPrint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListaPrint(GramaticaParser.ListaPrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionReal}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionReal(GramaticaParser.ExpresionRealContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionInt}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionInt(GramaticaParser.ExpresionIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionChar}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionChar(GramaticaParser.ExpresionCharContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionString}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionString(GramaticaParser.ExpresionStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionTrue}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionTrue(GramaticaParser.ExpresionTrueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionFalse}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionFalse(GramaticaParser.ExpresionFalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tipoInteger}
	 * labeled alternative in {@link GramaticaParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipoInteger(GramaticaParser.TipoIntegerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tipoReal}
	 * labeled alternative in {@link GramaticaParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipoReal(GramaticaParser.TipoRealContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tipoComplex}
	 * labeled alternative in {@link GramaticaParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipoComplex(GramaticaParser.TipoComplexContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tipoCharacter}
	 * labeled alternative in {@link GramaticaParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipoCharacter(GramaticaParser.TipoCharacterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tipoLogical}
	 * labeled alternative in {@link GramaticaParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipoLogical(GramaticaParser.TipoLogicalContext ctx);
}