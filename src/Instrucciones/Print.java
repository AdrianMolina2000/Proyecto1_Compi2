package Instrucciones;

import Abstract.Nodo;
import Other.Tipo;
import Symbols.Table;
import Symbols.Tree;

public class Print extends Nodo {
    Nodo expresion;
    public Print(Nodo expresion, int line, int column) {
        super(null, line, column);
        this.expresion = expresion;

    }

    @Override
    public Object execute(Table table, Tree tree) {
        tree.consola.add((String)this.expresion.execute(table, tree));
        return null;
    }
}
