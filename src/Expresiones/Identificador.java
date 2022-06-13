package Expresiones;

import Abstract.Nodo;
import Other.Excepcion;
import Other.Tipo;
import Symbols.Simbolo;
import Symbols.Table;
import Symbols.Tree;

import java.util.ArrayList;

public class Identificador extends Nodo {
    String id;
    Object valor;

    public Identificador(String id, int line, int column) {
        super(null, line, column);
        this.id = id;
    }
    @Override
    public Object execute(Table table, Tree tree) {
        Simbolo variable;
        variable = table.getVariable(this.id);

        if (variable == null) {
            String err = "La variable {"+this.id+"} no ha sido encontrada \n";
            Excepcion error = new Excepcion("Semantico", err,this.line, this.column);
            tree.excepciones.add(error);
            tree.consola.add(error.toString());
            return error;
        }
        this.tipo = variable.tipo.tipo;
        if(variable.tipo2.tipo == Tipo.Tipos.VARIABLE){
            if (variable.valor instanceof Identificador) {
                variable.valor = ((Identificador)variable.valor).execute(table, tree);
            }
            this.tipo = variable.tipo.tipo;
            this.valor = variable.valor;
        } else if (variable.tipo2.tipo == Tipo.Tipos.ARREGLO || variable.tipo2.tipo == Tipo.Tipos.ALLOCATE) {
            this.tipo = Tipo.Tipos.ARREGLO;

            ArrayList<Nodo> vieja = (ArrayList<Nodo>) variable.valor;
            ArrayList<Nodo> nueva = new ArrayList<>();


            for(int i = 0; i<vieja.size(); i++){
                Nodo no = vieja.get(i);
                Object val = no.execute(table, tree);
                Primitivo prim =  new Primitivo(no.tipo, val, no.line, no.column);
                nueva.add(prim);
            }

            /*
            String cadena = "";

            for(int i = 0; i<((ArrayList<?>)variable.valor).size(); i++){
                cadena += ((ArrayList<Nodo>) variable.valor).get(i).execute(table, tree) + " ";
            }
            cadena += "\n";
            this.valor = cadena;
             */

        }else if (variable.tipo2.tipo == Tipo.Tipos.ARREGLO2 || variable.tipo2.tipo == Tipo.Tipos.ALLOCATE2) {
            this.tipo = Tipo.Tipos.ARREGLO2;

            /*
            String cadena = "";

            ArrayList<ArrayList<Nodo>> listaI = (ArrayList<ArrayList<Nodo>>) variable.valor;

            for(int i = 0; i<listaI.size(); i++){
                ArrayList<Nodo> listaJ = listaI.get(i);
                for(int j = 0; j<listaJ.size(); j++){
                    cadena += listaJ.get(j).execute(table, tree) + " ";
                }
                cadena += "\n";
            }

            this.valor = cadena;
            */
        }
        return this.valor;
    }
}
