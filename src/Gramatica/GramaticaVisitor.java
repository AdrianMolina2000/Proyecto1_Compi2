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
	 * Visit a parse tree produced by the {@code instrucciones2Asignacion}
	 * labeled alternative in {@link GramaticaParser#instrucciones2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrucciones2Asignacion(GramaticaParser.Instrucciones2AsignacionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code instrucciones2Allocate}
	 * labeled alternative in {@link GramaticaParser#instrucciones2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrucciones2Allocate(GramaticaParser.Instrucciones2AllocateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code instrucciones2Print}
	 * labeled alternative in {@link GramaticaParser#instrucciones2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrucciones2Print(GramaticaParser.Instrucciones2PrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code instrucciones2If}
	 * labeled alternative in {@link GramaticaParser#instrucciones2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrucciones2If(GramaticaParser.Instrucciones2IfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declaracionArray2Dim}
	 * labeled alternative in {@link GramaticaParser#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionArray2Dim(GramaticaParser.DeclaracionArray2DimContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declaracionArray1Dim}
	 * labeled alternative in {@link GramaticaParser#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionArray1Dim(GramaticaParser.DeclaracionArray1DimContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declaracionAllocatable2Dim}
	 * labeled alternative in {@link GramaticaParser#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionAllocatable2Dim(GramaticaParser.DeclaracionAllocatable2DimContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declaracionAllocatable1Dim}
	 * labeled alternative in {@link GramaticaParser#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionAllocatable1Dim(GramaticaParser.DeclaracionAllocatable1DimContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declaracionArray2Dim2}
	 * labeled alternative in {@link GramaticaParser#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionArray2Dim2(GramaticaParser.DeclaracionArray2Dim2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code declaracionArray1Dim2}
	 * labeled alternative in {@link GramaticaParser#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionArray1Dim2(GramaticaParser.DeclaracionArray1Dim2Context ctx);
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
	 * Visit a parse tree produced by the {@code asignacionId}
	 * labeled alternative in {@link GramaticaParser#asignacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignacionId(GramaticaParser.AsignacionIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code asignacionArray1}
	 * labeled alternative in {@link GramaticaParser#asignacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignacionArray1(GramaticaParser.AsignacionArray1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code asignacionArray2}
	 * labeled alternative in {@link GramaticaParser#asignacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignacionArray2(GramaticaParser.AsignacionArray2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code allocate2Dim}
	 * labeled alternative in {@link GramaticaParser#allocate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllocate2Dim(GramaticaParser.Allocate2DimContext ctx);
	/**
	 * Visit a parse tree produced by the {@code allocate1Dim}
	 * labeled alternative in {@link GramaticaParser#allocate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllocate1Dim(GramaticaParser.Allocate1DimContext ctx);
	/**
	 * Visit a parse tree produced by the {@code deallocate}
	 * labeled alternative in {@link GramaticaParser#allocate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeallocate(GramaticaParser.DeallocateContext ctx);
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
	 * Visit a parse tree produced by the {@code ifNormal}
	 * labeled alternative in {@link GramaticaParser#if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfNormal(GramaticaParser.IfNormalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifElse}
	 * labeled alternative in {@link GramaticaParser#if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElse(GramaticaParser.IfElseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifElseIf}
	 * labeled alternative in {@link GramaticaParser#if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElseIf(GramaticaParser.IfElseIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifElseIfElse}
	 * labeled alternative in {@link GramaticaParser#if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElseIfElse(GramaticaParser.IfElseIfElseContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#elseif}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseif(GramaticaParser.ElseifContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionFalse}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionFalse(GramaticaParser.ExpresionFalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionLt}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionLt(GramaticaParser.ExpresionLtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionResta}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionResta(GramaticaParser.ExpresionRestaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionParentesis}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionParentesis(GramaticaParser.ExpresionParentesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionSize}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionSize(GramaticaParser.ExpresionSizeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionInt}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionInt(GramaticaParser.ExpresionIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionNegativo}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionNegativo(GramaticaParser.ExpresionNegativoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionMultiplicacion}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionMultiplicacion(GramaticaParser.ExpresionMultiplicacionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionDivision}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionDivision(GramaticaParser.ExpresionDivisionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionIdentificador}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionIdentificador(GramaticaParser.ExpresionIdentificadorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionChar}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionChar(GramaticaParser.ExpresionCharContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionTrue}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionTrue(GramaticaParser.ExpresionTrueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionOr}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionOr(GramaticaParser.ExpresionOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionArray2}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionArray2(GramaticaParser.ExpresionArray2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionNot}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionNot(GramaticaParser.ExpresionNotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionArray1}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionArray1(GramaticaParser.ExpresionArray1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionReal}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionReal(GramaticaParser.ExpresionRealContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionGe}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionGe(GramaticaParser.ExpresionGeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionNe}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionNe(GramaticaParser.ExpresionNeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionLe}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionLe(GramaticaParser.ExpresionLeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionSuma}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionSuma(GramaticaParser.ExpresionSumaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionAnd}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionAnd(GramaticaParser.ExpresionAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionListaExpresion}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionListaExpresion(GramaticaParser.ExpresionListaExpresionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionPotencia}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionPotencia(GramaticaParser.ExpresionPotenciaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionString}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionString(GramaticaParser.ExpresionStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionEq}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionEq(GramaticaParser.ExpresionEqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionGt}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionGt(GramaticaParser.ExpresionGtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#listaExpresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListaExpresion(GramaticaParser.ListaExpresionContext ctx);
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