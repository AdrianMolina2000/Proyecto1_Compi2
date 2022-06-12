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

    //Instrucciones2
    @Override public Object visitInstrucciones2Print(GramaticaParser.Instrucciones2PrintContext ctx) {
        return visit(ctx.print());
    }
    @Override public Object visitInstrucciones2Declaracion(GramaticaParser.Instrucciones2DeclaracionContext ctx) {
        return visit(ctx.declaracion());
    }
    @Override public Object visitInstrucciones2Asignacion(GramaticaParser.Instrucciones2AsignacionContext ctx) {
        return visit(ctx.asignacion());
    }
    @Override public Object visitInstrucciones2Allocate(GramaticaParser.Instrucciones2AllocateContext ctx) {
        return visit(ctx.allocate());
    }
    @Override public Object visitInstrucciones2If(GramaticaParser.Instrucciones2IfContext ctx) {
        return visit(ctx.if_());
    }

    @Override
    public Object visitInstrucciones2Do(GramaticaParser.Instrucciones2DoContext ctx) {
        return visit(ctx.do_());
    }

    //Declaracion
    @Override public Object visitDeclaracionArray2Dim(GramaticaParser.DeclaracionArray2DimContext ctx) {
        return new DeclaracionArray(((Tipo)visit(ctx.tipo())).tipo, ctx.id.getText(), (Nodo)visit(ctx.dim1), (Nodo)visit(ctx.dim2), ctx.id.getLine(), ctx.id.getCharPositionInLine());
    }
    @Override public Object visitDeclaracionArray1Dim(GramaticaParser.DeclaracionArray1DimContext ctx) {
        return new DeclaracionArray(((Tipo)visit(ctx.tipo())).tipo, ctx.id.getText(), (Nodo)visit(ctx.dim1), null, ctx.id.getLine(), ctx.id.getCharPositionInLine());
    }
    @Override public Object visitDeclaracionArray2Dim2(GramaticaParser.DeclaracionArray2Dim2Context ctx) {
        return new DeclaracionArray(((Tipo)visit(ctx.tipo())).tipo, ctx.id.getText(), (Nodo)visit(ctx.dim1), (Nodo)visit(ctx.dim2), ctx.id.getLine(), ctx.id.getCharPositionInLine());
    }
    @Override public Object visitDeclaracionArray1Dim2(GramaticaParser.DeclaracionArray1Dim2Context ctx) {
        return new DeclaracionArray(((Tipo)visit(ctx.tipo())).tipo, ctx.id.getText(), (Nodo)visit(ctx.dim1), null, ctx.id.getLine(), ctx.id.getCharPositionInLine());
    }
    @Override public Object visitDeclaracionAllocatable2Dim(GramaticaParser.DeclaracionAllocatable2DimContext ctx) {
        return new DeclaracionAllocatable(((Tipo)visit(ctx.tipo())).tipo,ctx.id.getText(),false, ctx.id.getLine(), ctx.id.getCharPositionInLine());
    }
    @Override public Object visitDeclaracionAllocatable1Dim(GramaticaParser.DeclaracionAllocatable1DimContext ctx) {
        return new DeclaracionAllocatable(((Tipo)visit(ctx.tipo())).tipo,ctx.id.getText(),true, ctx.id.getLine(), ctx.id.getCharPositionInLine());
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


    //Asignacion
    @Override public Object visitAsignacionId(GramaticaParser.AsignacionIdContext ctx) {
        return new Asignacion(ctx.id.getText(), visit(ctx.expresion()), ctx.id.getLine(), ctx.id.getCharPositionInLine());
    }
    @Override public Object visitAsignacionArray1(GramaticaParser.AsignacionArray1Context ctx) {
        return new AsignacionArray(ctx.id.getText(), (Nodo)visit(ctx.num), null, (Nodo)visit(ctx.val), ctx.id.getLine(), ctx.id.getCharPositionInLine());
    }
    @Override public Object visitAsignacionArray2(GramaticaParser.AsignacionArray2Context ctx) {
        return new AsignacionArray(ctx.id.getText(), (Nodo)visit(ctx.num1), (Nodo)visit(ctx.num2), (Nodo)visit(ctx.val), ctx.id.getLine(), ctx.id.getCharPositionInLine());
    }


    //Allocate
    @Override public Object visitAllocate1Dim(GramaticaParser.Allocate1DimContext ctx) {
        return new Allocate(ctx.id.getText(), Integer.parseInt(ctx.val1.getText()), null, ctx.id.getLine(), ctx.id.getCharPositionInLine());
    }
    @Override public Object visitAllocate2Dim(GramaticaParser.Allocate2DimContext ctx) {
        return new Allocate(ctx.id.getText(), Integer.parseInt(ctx.val1.getText()), Integer.parseInt(ctx.val2.getText()), ctx.id.getLine(), ctx.id.getCharPositionInLine());
    }
    @Override public Object visitDeallocate(GramaticaParser.DeallocateContext ctx) {
        return new Deallocate(ctx.id.getText(), ctx.id.getLine(), ctx.id.getCharPositionInLine());
    }


    //Print
    @Override public Object visitPrint(GramaticaParser.PrintContext ctx) {
        ArrayList<Nodo> instrucciones = new ArrayList<>();
        instrucciones.add((Nodo)visit(ctx.val));
        for(ParseTree item: ctx.e){
            instrucciones.add((Nodo)visit(item));
        }

        return new Print(instrucciones, ctx.p.getLine(), ctx.p.getCharPositionInLine());
    }
    @Override public Object visitListaPrint(GramaticaParser.ListaPrintContext ctx) {
        return visit(ctx.expresion());
    }


    //IF
    @Override public Object visitIfNormal(GramaticaParser.IfNormalContext ctx) {
        ArrayList<Nodo> instruccionesIf = new ArrayList<>();
        ArrayList<Nodo> instruccionesElse = new ArrayList<>();
        for(ParseTree item: ctx.e){
            instruccionesIf.add((Nodo)visit(item));
        }

        return new If((Nodo)visit(ctx.cond), instruccionesIf, instruccionesElse, ctx.id.getLine(), ctx.id.getCharPositionInLine());
    }
    @Override public Object visitIfElse(GramaticaParser.IfElseContext ctx) {
        ArrayList<Nodo> instruccionesIf = new ArrayList<>();
        ArrayList<Nodo> instruccionesElse = new ArrayList<>();
        for(ParseTree item: ctx.e){
            instruccionesIf.add((Nodo)visit(item));
        }
        for(ParseTree item: ctx.e2){
            instruccionesElse.add((Nodo)visit(item));
        }

        return new If((Nodo)visit(ctx.cond), instruccionesIf, instruccionesElse, ctx.id.getLine(), ctx.id.getCharPositionInLine());
    }
    @Override public Object visitIfElseIf(GramaticaParser.IfElseIfContext ctx) {
        ArrayList<Nodo> instruccionesIf = new ArrayList<>();
        ArrayList<Nodo> instruccionesElse = new ArrayList<>();
        for(ParseTree item: ctx.e){
            instruccionesIf.add((Nodo)visit(item));
        }
        for(ParseTree item: ctx.e2){
            instruccionesElse.add((Nodo)visit(item));
        }

        return new If((Nodo)visit(ctx.cond), instruccionesIf, instruccionesElse, ctx.id.getLine(), ctx.id.getCharPositionInLine());
    }
    @Override public Object visitIfElseIfElse(GramaticaParser.IfElseIfElseContext ctx) {
        ArrayList<Nodo> instruccionesIf = new ArrayList<>();
        ArrayList<Nodo> instruccionesElse = new ArrayList<>();
        for(ParseTree item: ctx.e){
            instruccionesIf.add((Nodo)visit(item));
        }
        for(ParseTree item: ctx.e2){
            instruccionesElse.add((Nodo)visit(item));
        }
        for(ParseTree item: ctx.e3){
            instruccionesElse.add((Nodo)visit(item));
        }

        return new If((Nodo)visit(ctx.cond), instruccionesIf, instruccionesElse, ctx.id.getLine(), ctx.id.getCharPositionInLine());
    }
    @Override public Object visitElseif(GramaticaParser.ElseifContext ctx) {
        ArrayList<Nodo> instruccionesIf = new ArrayList<>();
        ArrayList<Nodo> instruccionesElse = new ArrayList<>();
        for(ParseTree item: ctx.e){
            instruccionesIf.add((Nodo)visit(item));
        }

        return new If((Nodo)visit(ctx.cond), instruccionesIf, instruccionesElse, ctx.id.getLine(), ctx.id.getCharPositionInLine());
    }


    //DO

    @Override
    public Object visitDoNormal(GramaticaParser.DoNormalContext ctx) {
        ArrayList<Nodo> instrucciones = new ArrayList<>();
        for(ParseTree item: ctx.e){
            instrucciones.add((Nodo)visit(item));
        }
        return new Do((Nodo)visit(ctx.inicio), (Nodo)visit(ctx.fin), (Nodo)visit(ctx.paso), instrucciones, ctx.id.getLine(), ctx.id.getCharPositionInLine());
    }

    @Override
    public Object visitDoWhile(GramaticaParser.DoWhileContext ctx) {
        ArrayList<Nodo> instrucciones = new ArrayList<>();
        for(ParseTree item: ctx.e){
            instrucciones.add((Nodo)visit(item));
        }
        return new DoWhile((Nodo)visit(ctx.condicion), instrucciones, ctx.id.getLine(), ctx.id.getCharPositionInLine());
    }


    //Expresion
    @Override public Object visitExpresionIdentificador(GramaticaParser.ExpresionIdentificadorContext ctx) {
        return new Identificador(ctx.val.getText(), ctx.val.getLine(), ctx.val.getCharPositionInLine());
    }
    @Override public Object visitExpresionArray2(GramaticaParser.ExpresionArray2Context ctx) {
        return new ArrayPos(ctx.val.getText(), Integer.parseInt(ctx.pos1.getText()), Integer.parseInt(ctx.pos2.getText()), ctx.val.getLine(), ctx.val.getCharPositionInLine());
    }
    @Override public Object visitExpresionArray1(GramaticaParser.ExpresionArray1Context ctx) {
        return new ArrayPos(ctx.val.getText(), Integer.parseInt(ctx.pos.getText()), 0, ctx.val.getLine(), ctx.val.getCharPositionInLine());
    }
    @Override public Nodo visitExpresionResta(GramaticaParser.ExpresionRestaContext ctx) {
        return new Aritmetica((Nodo)visit(ctx.val1), (Nodo)visit(ctx.val2), ctx.op.getText(), ctx.op.getLine(), ctx.op.getCharPositionInLine());
    }
    @Override public Nodo visitExpresionNegativo(GramaticaParser.ExpresionNegativoContext ctx) {
        return new Aritmetica(null, (Nodo)visit(ctx.expresion()), ctx.op.getText(), ctx.op.getLine(), ctx.op.getCharPositionInLine());
    }
    @Override public Nodo visitExpresionMultiplicacion(GramaticaParser.ExpresionMultiplicacionContext ctx) {
        return new Aritmetica((Nodo)visit(ctx.val1), (Nodo)visit(ctx.val2), ctx.op.getText(), ctx.op.getLine(), ctx.op.getCharPositionInLine());
    }
    @Override public Nodo visitExpresionSuma(GramaticaParser.ExpresionSumaContext ctx) {
        return new Aritmetica((Nodo)visit(ctx.val1), (Nodo)visit(ctx.val2), ctx.op.getText(), ctx.op.getLine(), ctx.op.getCharPositionInLine());    }
    @Override public Nodo visitExpresionDivision(GramaticaParser.ExpresionDivisionContext ctx) {
        return new Aritmetica((Nodo)visit(ctx.val1), (Nodo)visit(ctx.val2), ctx.op.getText(), ctx.op.getLine(), ctx.op.getCharPositionInLine());
    }
    @Override public Nodo visitExpresionPotencia(GramaticaParser.ExpresionPotenciaContext ctx) {
        return new Aritmetica((Nodo)visit(ctx.val1), (Nodo)visit(ctx.val2), ctx.op.getText(), ctx.op.getLine(), ctx.op.getCharPositionInLine());
    }
    @Override public Nodo visitExpresionLt(GramaticaParser.ExpresionLtContext ctx) {
        return new Relacional((Nodo)visit(ctx.val1), (Nodo)visit(ctx.val2), ctx.op.getText(), ctx.op.getLine(), ctx.op.getCharPositionInLine());
    }
    @Override public Nodo visitExpresionGe(GramaticaParser.ExpresionGeContext ctx) {
        return new Relacional((Nodo)visit(ctx.val1), (Nodo)visit(ctx.val2), ctx.op.getText(), ctx.op.getLine(), ctx.op.getCharPositionInLine());
    }
    @Override public Nodo visitExpresionNe(GramaticaParser.ExpresionNeContext ctx) {
        return new Relacional((Nodo)visit(ctx.val1), (Nodo)visit(ctx.val2), ctx.op.getText(), ctx.op.getLine(), ctx.op.getCharPositionInLine());
    }
    @Override public Nodo visitExpresionLe(GramaticaParser.ExpresionLeContext ctx) {
        return new Relacional((Nodo)visit(ctx.val1), (Nodo)visit(ctx.val2), ctx.op.getText(), ctx.op.getLine(), ctx.op.getCharPositionInLine());
    }
    @Override public Nodo visitExpresionEq(GramaticaParser.ExpresionEqContext ctx) {
        return new Relacional((Nodo)visit(ctx.val1), (Nodo)visit(ctx.val2), ctx.op.getText(), ctx.op.getLine(), ctx.op.getCharPositionInLine());
    }
    @Override public Nodo visitExpresionGt(GramaticaParser.ExpresionGtContext ctx) {
        return new Relacional((Nodo)visit(ctx.val1), (Nodo)visit(ctx.val2), ctx.op.getText(), ctx.op.getLine(), ctx.op.getCharPositionInLine());
    }
    @Override public Nodo visitExpresionOr(GramaticaParser.ExpresionOrContext ctx) {
        return new Logica((Nodo)visit(ctx.val1), (Nodo)visit(ctx.val2), ctx.op.getText(), ctx.op.getLine(), ctx.op.getCharPositionInLine());
    }
    @Override public Nodo visitExpresionNot(GramaticaParser.ExpresionNotContext ctx) {
        return new Logica(null, (Nodo)visit(ctx.expresion()), ctx.op.getText(), ctx.op.getLine(), ctx.op.getCharPositionInLine());
    }
    @Override public Nodo visitExpresionAnd(GramaticaParser.ExpresionAndContext ctx) {
        return new Logica((Nodo)visit(ctx.val1), (Nodo)visit(ctx.val2), ctx.op.getText(), ctx.op.getLine(), ctx.op.getCharPositionInLine());
    }
    @Override public Object visitExpresionSize(GramaticaParser.ExpresionSizeContext ctx) {
        return new Size(ctx.val.getText(), ctx.si.getLine(), ctx.si.getCharPositionInLine());
    }
    @Override public Nodo visitExpresionReal(GramaticaParser.ExpresionRealContext ctx) {
        return new Primitivo(Tipo.Tipos.REAL, Double.parseDouble(ctx.val.getText()), ctx.val.getLine(), ctx.val.getCharPositionInLine());
    }
    @Override public Nodo visitExpresionInt(GramaticaParser.ExpresionIntContext ctx) {
        return new Primitivo(Tipo.Tipos.INTEGER, Integer.parseInt(ctx.val.getText()), ctx.val.getLine(), ctx.val.getCharPositionInLine());
    }
    @Override public Nodo visitExpresionChar(GramaticaParser.ExpresionCharContext ctx) {
        return new Primitivo(Tipo.Tipos.CHARACTER, ctx.val.getText(), ctx.val.getLine(), ctx.val.getCharPositionInLine());
    }
    @Override public Nodo visitExpresionString(GramaticaParser.ExpresionStringContext ctx) {
        return new Primitivo(Tipo.Tipos.STRING, ctx.val.getText(), ctx.val.getLine(), ctx.val.getCharPositionInLine());
    }
    @Override public Nodo visitExpresionTrue(GramaticaParser.ExpresionTrueContext ctx) {
        return new Primitivo(Tipo.Tipos.LOGICAL, true, ctx.val.getLine(), ctx.val.getCharPositionInLine());
    }
    @Override public Nodo visitExpresionFalse(GramaticaParser.ExpresionFalseContext ctx) {
        return new Primitivo(Tipo.Tipos.LOGICAL, false, ctx.val.getLine(), ctx.val.getCharPositionInLine());
    }
    @Override public Object visitExpresionParentesis(GramaticaParser.ExpresionParentesisContext ctx) {
        return visit(ctx.expresion());
    }
    @Override public Object visitExpresionListaExpresion(GramaticaParser.ExpresionListaExpresionContext ctx) {
        ArrayList<Nodo> listDec = new ArrayList<Nodo>();

        listDec.add((Nodo)visit(ctx.val));

        for(ParseTree item: ctx.e){
            Nodo valor = (Nodo)visit(item);
            listDec.add(valor);
        }
        return listDec;
    }
    @Override public Object visitListaExpresion(GramaticaParser.ListaExpresionContext ctx) {
        return visit(ctx.expresion());
    }


    //Tipo
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
