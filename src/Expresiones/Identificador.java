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

        if(variable.tipo2.tipo == Tipo.Tipos.VARIABLE){
            this.tipo = variable.tipo.tipo;
            if (variable.valor instanceof Identificador) {
                variable.valor = ((Identificador)variable.valor).execute(table, tree);
            }
            this.valor = variable.valor;
        } else if (variable.tipo2.tipo == Tipo.Tipos.ARREGLO) {
            this.tipo = Tipo.Tipos.STRING;
            String cadena = "";

            for(int i = 0; i<((ArrayList<?>)variable.valor).size(); i++){
                cadena += ((ArrayList<Nodo>) variable.valor).get(i).execute(table, tree) + " ";
            }
            cadena += "\n";
            this.valor = cadena;
        }else if (variable.tipo2.tipo == Tipo.Tipos.ARREGLO2) {
            this.tipo = Tipo.Tipos.STRING;
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
        }
        return this.valor;
    }
}
