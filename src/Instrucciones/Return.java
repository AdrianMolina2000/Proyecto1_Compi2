package Instrucciones;

import Abstract.Nodo;
import Expresiones.Primitivo;
import Other.Tipo;
import Symbols.Table;
import Symbols.Tree;

public class Return extends Nodo {
    Nodo expresion;
    public Return(Nodo expresion, int line, int column) {
        super(null, line, column);
        this.expresion = expresion;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        Object expr = this.expresion.execute(table, tree);
        Primitivo prim =  new Primitivo(this.expresion.tipo, expr, this.line, this.column);
        return expr;
    }
}
