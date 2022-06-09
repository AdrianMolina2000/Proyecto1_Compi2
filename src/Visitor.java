import Gramatica.*;
import Abstract.*;
import Expresiones.*;
import Instrucciones.*;
import Other.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;

public class Visitor extends GramaticaBaseVisitor<Object> {

    @Override public Object visitStart(GramaticaParser.StartContext ctx) {
        return visit(ctx.listaInstrucciones());
    }


    @Override public Object visitListaInstrucciones(GramaticaParser.ListaInstruccionesContext ctx) {
        ArrayList<Nodo> instrucciones = new ArrayList<>();
        for(ParseTree item: ctx.e){
            instrucciones.add((Nodo)visit(item));
        }
        return instrucciones;
    }


    @Override public Object visitInstruccionesProgram(GramaticaParser.InstruccionesProgramContext ctx) {
        ArrayList<Nodo> instrucciones = new ArrayList<>();
        for(ParseTree item: ctx.e){
            instrucciones.add((Nodo)visit(item));
        }

        return new Program(instrucciones, ctx.id1.getText(), ctx.id2.getText(), ctx.id1.getLine(), ctx.id1.getCharPositionInLine());
    }


    @Override public Object visitInstrucciones2Print(GramaticaParser.Instrucciones2PrintContext ctx) {
        return visit(ctx.print());
    }
    @Override public Object visitInstrucciones2Declaracion(GramaticaParser.Instrucciones2DeclaracionContext ctx) {
        return visit(ctx.declaracion());
    }
    @Override public Object visitInstrucciones2Asignacion(GramaticaParser.Instrucciones2AsignacionContext ctx) {
        return visit(ctx.asignacion());
    }


    @Override public Object visitDeclaracionAsig(GramaticaParser.DeclaracionAsigContext ctx) {
        ArrayList<Nodo> listDec = new ArrayList<Nodo>();
        listDec.add(new Declaracion(((Tipo)visit(ctx.tipo())).tipo, ctx.id.getText(), (Nodo)visit(ctx.expresion()), ctx.id.getLine(), ctx.id.getCharPositionInLine()));

        for(ParseTree item: ctx.e){
            Declaracion decla = (Declaracion)visit(item);
            decla.tipo = ((Tipo)visit(ctx.tipo())).tipo;
            if(decla.valor == null){
                decla.valor = Globales.defal(((Tipo)visit(ctx.tipo())).tipo, ctx.id.getLine(), ctx.id.getCharPositionInLine());
            }
            listDec.add(decla);
        }

        return new ListaDeclaraciones(listDec, ctx.id.getLine(), ctx.id.getCharPositionInLine());
    }
    @Override public Object visitDeclaracionUniq(GramaticaParser.DeclaracionUniqContext ctx) {
        ArrayList<Nodo> listDec = new ArrayList<Nodo>();
        listDec.add(new Declaracion(((Tipo)visit(ctx.tipo())).tipo, ctx.id.getText(), Globales.defal(((Tipo)visit(ctx.tipo())).tipo, ctx.id.getLine(), ctx.id.getCharPositionInLine()), ctx.id.getLine(), ctx.id.getCharPositionInLine()));

        for(ParseTree item: ctx.e){
            Declaracion decla = (Declaracion)visit(item);
            decla.tipo = ((Tipo)visit(ctx.tipo())).tipo;
            if(decla.valor == null){
                decla.valor = Globales.defal(((Tipo)visit(ctx.tipo())).tipo, ctx.id.getLine(), ctx.id.getCharPositionInLine());
            }
            listDec.add(decla);
        }

        return new ListaDeclaraciones(listDec, ctx.id.getLine(), ctx.id.getCharPositionInLine());
    }


    @Override public Object visitListaDeclaracionAsig(GramaticaParser.ListaDeclaracionAsigContext ctx) {
        return new Declaracion(null, ctx.id.getText(), (Nodo)visit(ctx.expresion()), ctx.id.getLine(), ctx.id.getCharPositionInLine());
    }
    @Override public Object visitListaDeclaracionUniq(GramaticaParser.ListaDeclaracionUniqContext ctx) {
        return new Declaracion(null, ctx.id.getText(), null, ctx.id.getLine(), ctx.id.getCharPositionInLine());
    }


    @Override public Object visitAsignacion(GramaticaParser.AsignacionContext ctx) {
        return new Asignacion(ctx.id.getText(), (Nodo)visit(ctx.expresion()), ctx.id.getLine(), ctx.id.getCharPositionInLine());
    }


    @Override public Object visitPrint(GramaticaParser.PrintContext ctx) {
        ArrayList<Nodo> instrucciones = new ArrayList<>();
        instrucciones.add((Nodo)visit(ctx.val));
        for(ParseTree item: ctx.e){
            instrucciones.add((Nodo)visit(item));
        }

        return new Print(instrucciones, ctx.p.getLine(), ctx.p.getCharPositionInLine());
    }
    @Override
    public Object visitListaPrint(GramaticaParser.ListaPrintContext ctx) {
        return visit(ctx.expresion());
    }


    @Override public Nodo visitExpresionReal(GramaticaParser.ExpresionRealContext ctx) {
        return new Primitivo(Tipo.Tipos.REAL, ctx.val.getText(), ctx.val.getLine(), ctx.val.getCharPositionInLine());
    }
    @Override public Nodo visitExpresionInt(GramaticaParser.ExpresionIntContext ctx) {
        return new Primitivo(Tipo.Tipos.INTEGER, ctx.val.getText(), ctx.val.getLine(), ctx.val.getCharPositionInLine());
    }
    @Override public Object visitExpresionChar(GramaticaParser.ExpresionCharContext ctx) {
        return new Primitivo(Tipo.Tipos.CHARACTER, ctx.val.getText(), ctx.val.getLine(), ctx.val.getCharPositionInLine());
    }
    @Override public Object visitExpresionString(GramaticaParser.ExpresionStringContext ctx) {
        return new Primitivo(Tipo.Tipos.STRING, ctx.val.getText(), ctx.val.getLine(), ctx.val.getCharPositionInLine());
    }
    @Override public Object visitExpresionTrue(GramaticaParser.ExpresionTrueContext ctx) {
        return new Primitivo(Tipo.Tipos.LOGICAL, ctx.val.getText(), ctx.val.getLine(), ctx.val.getCharPositionInLine());
    }
    @Override public Object visitExpresionFalse(GramaticaParser.ExpresionFalseContext ctx) {
        return new Primitivo(Tipo.Tipos.LOGICAL, ctx.val.getText(), ctx.val.getLine(), ctx.val.getCharPositionInLine());
    }


    @Override public Object visitTipoInteger(GramaticaParser.TipoIntegerContext ctx) {
        return new Tipo(Tipo.Tipos.INTEGER);
    }
    @Override public Object visitTipoReal(GramaticaParser.TipoRealContext ctx) {
        return new Tipo(Tipo.Tipos.REAL);
    }
    @Override public Object visitTipoComplex(GramaticaParser.TipoComplexContext ctx) {
        return new Tipo(Tipo.Tipos.COMPLEX);
    }
    @Override public Object visitTipoCharacter(GramaticaParser.TipoCharacterContext ctx) {
        return new Tipo(Tipo.Tipos.CHARACTER);
    }
    @Override public Object visitTipoLogical(GramaticaParser.TipoLogicalContext ctx) {
        return new Tipo(Tipo.Tipos.LOGICAL);
    }
}
