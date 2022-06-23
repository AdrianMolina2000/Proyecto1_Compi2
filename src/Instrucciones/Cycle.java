package Instrucciones;

import Abstract.Nodo;
import Abstract.NodoAST;
import Gramatica.Globales;
import Other.Tipo;
import Symbols.C3D;
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

    @Override
    public void get3D() {
        if(Globales.gen == null){
            C3D genAux = new C3D();
            Globales.gen = genAux.getInstance();
        }
        if(this.ev != null){
            Globales.gen.addGoto(this.ev);
        }
    }
}
