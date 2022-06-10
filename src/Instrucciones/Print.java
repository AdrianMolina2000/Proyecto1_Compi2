package Instrucciones;

import Abstract.Nodo;
import Other.Tipo;
import Symbols.Table;
import Symbols.Tree;

import java.util.ArrayList;

public class Print extends Nodo {
    ArrayList<Nodo> expresion;
    public Print(ArrayList<Nodo> expresion, int line, int column) {
        super(null, line, column);
        this.expresion = expresion;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        for(int i = 0; i<this.expresion.size(); i++){
            String salida = String.valueOf(this.expresion.get(i).execute(table, tree));
            salida = salida.replace("\"", "");
            salida = salida.replace("'", "");

            if(salida.equalsIgnoreCase(".true.")){
                salida = "T";
            }else if(salida.equalsIgnoreCase(".false.")){
                salida = "F";
            }

            tree.consola.add(salida);
        }
        tree.consola.add("\n");
        return null;
    }
}
