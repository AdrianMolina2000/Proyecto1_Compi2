package Instrucciones;

import Abstract.Nodo;
import Expresiones.Identificador;
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
            if(this.expresion.get(i) instanceof Identificador ide){
                ide.execute(table, tree);

                if(ide.tipo == Tipo.Tipos.ARREGLO || ide.tipo == Tipo.Tipos.ALLOCATE){
                    String cadena = "";

                    ArrayList<Nodo> valor = (ArrayList<Nodo>) ide.execute(table, tree);
                    for(int j = 0; j<valor.size(); j++){
                        cadena += valor.get(j).execute(table, tree) + " ";
                    }

                    tree.consola.add(cadena);
                }else if(ide.tipo == Tipo.Tipos.ARREGLO2 || ide.tipo == Tipo.Tipos.ALLOCATE2){
                    String cadena = "";

                    ArrayList<ArrayList<Nodo>> valorJ = (ArrayList<ArrayList<Nodo>>) ide.execute(table, tree);
                    for(int j = 0; j<valorJ.size(); j++){
                        ArrayList<Nodo> valorK = valorJ.get(j);
                        for(int k = 0; k<valorK.size(); k++){
                            cadena += valorK.get(k).execute(table, tree) + " ";
                        }
                        cadena += "\n";
                    }

                    tree.consola.add(cadena);
                }else{
                    String salida = String.valueOf(this.expresion.get(i).execute(table, tree));
                    salida = salida.replace("\"", "");
                    salida = salida.replace("'", "");

                    if(salida.equalsIgnoreCase("true")){
                        salida = "T";
                    }else if(salida.equalsIgnoreCase("false")){
                        salida = "F";
                    }

                    tree.consola.add(salida);
                }
            }else {
                String salida = String.valueOf(this.expresion.get(i).execute(table, tree));
                salida = salida.replace("\"", "");
                salida = salida.replace("'", "");

                if (salida.equalsIgnoreCase("true")) {
                    salida = "T";
                } else if (salida.equalsIgnoreCase("false")) {
                    salida = "F";
                }

                tree.consola.add(salida);
            }
        }
        tree.consola.add("\n");
        return null;
    }
}
