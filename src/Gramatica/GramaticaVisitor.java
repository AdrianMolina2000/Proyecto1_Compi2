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
	 * Visit a parse tree produced by {@link GramaticaParser#instrucciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrucciones(GramaticaParser.InstruccionesContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#instrucciones2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrucciones2(GramaticaParser.Instrucciones2Context ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(GramaticaParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresion(GramaticaParser.ExpresionContext ctx);
}