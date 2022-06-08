package Abstract;

import Other.Tipo;
import Symbols.Table;
import Symbols.Tree;

public abstract class Nodo {
    public int line;
    public int column;
    public Tipo.Tipos tipo;

    public abstract Object execute(Table table, Tree tree);

    public Nodo(Tipo.Tipos tipo, int line, int column) {
        this.line = line;
        this.column = column;
        this.tipo = tipo;
    }
}
