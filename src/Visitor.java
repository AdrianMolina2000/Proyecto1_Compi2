import Gramatica.*;

public class Visitor extends GramaticaBaseVisitor<Object> {

    @Override public Object visitStart(GramaticaParser.StartContext ctx) { return visitChildren(ctx); }
    @Override public Object visitInstrucciones(GramaticaParser.InstruccionesContext ctx) { return visitChildren(ctx); }
    @Override public Object visitInstrucciones2(GramaticaParser.Instrucciones2Context ctx) { return visitChildren(ctx); }
    @Override public Object visitPrint(GramaticaParser.PrintContext ctx) { return visitChildren(ctx); }
    @Override public Object visitExpresion(GramaticaParser.ExpresionContext ctx) { return visitChildren(ctx); }
}
