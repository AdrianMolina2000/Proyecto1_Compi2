package Instrucciones;

import Abstract.Nodo;
import Other.Tipo;
import Symbols.Table;
import Symbols.Tree;

public class Exit extends Nodo {
    String id;
    public Exit(String id, int line, int column) {
        super(null, line, column);
        this.id = id;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        return this;
    }
}
