package Instrucciones;

import Abstract.Nodo;
import Other.Excepcion;
import Other.Tipo;
import Symbols.Table;
import Symbols.Tree;

import java.util.ArrayList;

public class Program extends Nodo {
    public ArrayList<Nodo> instrucciones;
    public String abre;
    public String cierra;
    public Program(ArrayList<Nodo> instrucciones, String abre, String cierra, int line, int column) {
        super(null, line, column);
        this.instrucciones = instrucciones;
        this.abre = abre;
        this.cierra = cierra;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        if(abre.equalsIgnoreCase(cierra)){
            for(int i = 0; i<instrucciones.size(); i++){
                instrucciones.get(i).execute(table, tree);
            }
        }else{
            Excepcion error = new Excepcion("Semantico", "Los nombres de apertura y cierre deben ser iguales.",
                                            this.line, this.column);
            tree.consola.add(error.toString());
        }
        return null;
    }
}
