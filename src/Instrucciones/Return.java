package Instrucciones;

import Abstract.Nodo;
import Other.Tipo;
import Symbols.Table;
import Symbols.Tree;

public class Return extends Nodo {
    public Return(Tipo.Tipos tipo, int line, int column) {
        super(tipo, line, column);
    }

    @Override
    public Object execute(Table table, Tree tree) {
        return null;
    }
}
