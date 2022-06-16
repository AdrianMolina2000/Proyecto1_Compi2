package Instrucciones;

import Abstract.Nodo;
import Abstract.NodoAST;
import Other.Tipo;
import Symbols.Table;
import Symbols.Tree;

public class Cycle extends Nodo {
    String id;
    public Cycle(String id, int line, int column) {
        super(null, line, column);
        this.id = id;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        return this;
    }

    @Override
    public NodoAST getAST() {
        NodoAST nodo = new NodoAST("CYCLE");

        if(!id.equalsIgnoreCase("!")){
            nodo.agregarHijo(new NodoAST(id));
        }

        return nodo;
    }
}
