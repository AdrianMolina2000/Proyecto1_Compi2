package Instrucciones;

import Abstract.Nodo;
import Abstract.NodoAST;
import Other.Excepcion;
import Other.Tipo;
import Symbols.Table;
import Symbols.Tree;

import java.util.ArrayList;

public class ListaDeclaraciones extends Nodo {
    ArrayList<Nodo> declaraciones;

    //Para AST
    ArrayList<NodoAST> nodoDec = new ArrayList<>();

    public ListaDeclaraciones(ArrayList<Nodo> declaraciones,int line, int column) {
        super(null, line, column);
        this.declaraciones = declaraciones;
    }

    @Override
    public Object execute(Table table, Tree tree) {

        //Recorro todas las declaraciones de la lista
        for(int i = 0; i < declaraciones.size(); i++){

            //Ejecuto todas las declaraciones de la lista
            Object result = declaraciones.get(i).execute(table, tree);

            //ERROR
            if(result instanceof Excepcion e){
                tree.consola.add(e.toString());
            }

            else {
                //Guardo los AST de las declaraciones
                nodoDec.add(declaraciones.get(i).getAST());
            }
        }
        return null;
    }

    @Override
    public NodoAST getAST() {
        NodoAST nodo = new NodoAST("LISTA DECLARACION");
        nodo.agregarHijos(nodoDec);
        return nodo;
    }
}
