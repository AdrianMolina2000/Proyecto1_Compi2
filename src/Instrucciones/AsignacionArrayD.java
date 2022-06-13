package Instrucciones;

import Abstract.Nodo;
import Expresiones.Primitivo;
import Other.Excepcion;
import Other.Tipo;
import Symbols.Simbolo;
import Symbols.Table;
import Symbols.Tree;

import java.util.ArrayList;

public class AsignacionArrayD extends Nodo {
    String id;

    Nodo expresion;
    public AsignacionArrayD(String id, Nodo expresion, int line, int column) {
        super(null, line, column);
        this.id = id;

        this.expresion = expresion;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        Object result = null;

        result = this.expresion.execute(table, tree);
        if (result instanceof Excepcion) {
            return result;
        }

        Simbolo variable;
        variable = table.getVariable(this.id);

        if (variable == null) {
            String err = "La variable {"+this.id+"} no ha sido encontrada \n";
            Excepcion error = new Excepcion("Semantico", err,this.line, this.column);
            tree.excepciones.add(error);
            tree.consola.add(error.toString());
            return error;
        }

        if(variable.tipo2.tipo == Tipo.Tipos.ARREGLO || variable.tipo2.tipo == Tipo.Tipos.ALLOCATE){
            this.expresion.execute(table,tree);
            if(this.expresion.tipo != variable.tipo.tipo){
                String err = "El arreglo no puede ser asignado porque no poseen los mismos tipos \n";
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.excepciones.add(error);
                tree.consola.add(error.toString());
                return error;
            }

            for(int i = 0; i < ((ArrayList<Nodo>)variable.valor).size(); i++){
                Primitivo prim= new Primitivo(variable.tipo.tipo, this.expresion.execute(table, tree), this.expresion.line, this.expresion.column);
                ((ArrayList<Nodo>)variable.valor).set(i, prim);
            }
        }else if(variable.tipo2.tipo == Tipo.Tipos.ARREGLO2 || variable.tipo2.tipo == Tipo.Tipos.ALLOCATE2){
            this.expresion.execute(table,tree);

            if(this.expresion.tipo != variable.tipo.tipo){
                String err = "El arreglo no puede ser asignado porque no poseen los mismos tipos \n";
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.excepciones.add(error);
                tree.consola.add(error.toString());
                return error;
            }

            for(int i = 0; i < ((ArrayList<ArrayList<Nodo>>)variable.valor).size(); i++){
                ArrayList<Nodo> arra = ((ArrayList<ArrayList<Nodo>>)variable.valor).get(i);
                for(int j = 0; j < arra.size(); j++){
                    Primitivo prim= new Primitivo(variable.tipo.tipo, this.expresion.execute(table, tree), this.expresion.line, this.expresion.column);
                    arra.set(j, prim);
                }
            }
        }

        return null;
    }
}
