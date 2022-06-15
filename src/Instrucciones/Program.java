package Instrucciones;

import Abstract.Nodo;
import Abstract.NodoAST;
import Other.Excepcion;
import Other.Tipo;
import Symbols.Table;
import Symbols.Tree;

import java.util.ArrayList;

public class Program extends Nodo {
    public ArrayList<Nodo> instrucciones;
    public String abre;
    public String cierra;

    ArrayList<NodoAST> nodoIns = new ArrayList<>();

    public Program(ArrayList<Nodo> instrucciones, String abre, String cierra, int line, int column) {
        super(null, line, column);
        this.instrucciones = instrucciones;
        this.abre = abre;
        this.cierra = cierra;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        Table newTable = new Table(table);
        if(abre.equalsIgnoreCase(cierra)){
            for(int i = 0; i<instrucciones.size(); i++){
                instrucciones.get(i).execute(newTable, tree);
                nodoIns.add(instrucciones.get(i).getAST());
            }
        }else{
            Excepcion error = new Excepcion("Semantico", "Los nombres de apertura y cierre deben ser iguales \n",
                                            this.line, this.column);
            tree.consola.add(error.toString());
            tree.excepciones.add(error);
        }
        return null;
    }

    @Override
    public NodoAST getAST() {
        NodoAST nodo = new NodoAST("PROGRAM");
        nodo.agregarHijos(nodoIns);
        return nodo;
    }
}
