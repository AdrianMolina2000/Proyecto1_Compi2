package Abstract;

import Other.Tipo;
import Symbols.Table;
import Symbols.Tree;

public abstract class Nodo {
    public int line;
    public int column;
    public Tipo.Tipos tipo;

    public String valor3D;
    public boolean tmp;
    public String ev;
    public String ef;


    public abstract Object execute(Table table, Tree tree);
    public abstract NodoAST getAST();

    public Nodo(Tipo.Tipos tipo, int line, int column) {
        this.line = line;
        this.column = column;
        this.tipo = tipo;
    }
}
