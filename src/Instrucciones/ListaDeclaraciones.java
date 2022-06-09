package Instrucciones;

import Abstract.Nodo;
import Other.Tipo;
import Symbols.Table;
import Symbols.Tree;

import java.util.ArrayList;

public class ListaDeclaraciones extends Nodo {
    ArrayList<Nodo> declaraciones;

    public ListaDeclaraciones(ArrayList<Nodo> declaraciones,int line, int column) {
        super(null, line, column);
        this.declaraciones = declaraciones;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        for(int i = 0; i < declaraciones.size(); i++){
            declaraciones.get(i).execute(table, tree);
        }
        return null;
    }
}
