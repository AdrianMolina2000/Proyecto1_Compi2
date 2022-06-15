package Instrucciones;

import Abstract.Nodo;
import Abstract.NodoAST;
import Expresiones.Primitivo;
import Other.Tipo;
import Symbols.Table;
import Symbols.Tree;

public class Return extends Nodo {
    Nodo expresion;
    NodoAST nodoExp;

    public Return(Nodo expresion, int line, int column) {
        super(null, line, column);
        this.expresion = expresion;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        Object expr = this.expresion.execute(table, tree);
        nodoExp = new NodoAST(expr.toString());
        Primitivo prim =  new Primitivo(this.expresion.tipo, expr, this.line, this.column);
        return expr;
    }

    @Override
    public NodoAST getAST() {
        NodoAST nodo = new NodoAST("RETURN");
        nodo.agregarHijo(nodoExp);
        return nodo;
    }
}
