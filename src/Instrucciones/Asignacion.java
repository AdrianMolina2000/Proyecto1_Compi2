package Instrucciones;

import Abstract.Nodo;
import Other.Excepcion;
import Other.Tipo;
import Symbols.Simbolo;
import Symbols.Table;
import Symbols.Tree;

import java.util.ArrayList;

public class Asignacion extends Nodo {
    String id;
    Object valor;
    Object resultado;

    public Asignacion(String id, Object valor, int line, int column) {
        super(null, line, column);
        this.id = id;
        this.valor = valor;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        Object result = null;

        if(this.valor instanceof Nodo res){
            result = res.execute(table, tree);
            if (result instanceof Excepcion) {
                return result;
            }
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

        if(this.valor instanceof Nodo res){
            if (res.tipo != variable.tipo.tipo){
                String err = "La variable {"+this.id+"} no puede ser asignada debido a que son de diferentes tipos ["+ variable.tipo.tipo + "] y ["+res.tipo+"] \n";
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.excepciones.add(error);
                tree.consola.add(error.toString());
                return error;
            }
        }

        if(variable.tipo2.tipo == Tipo.Tipos.ARREGLO || variable.tipo2.tipo == Tipo.Tipos.ALLOCATE){
            if(((ArrayList<Nodo>)variable.valor).size() == ((ArrayList<Nodo>)this.valor).size()){
                for(int i = 0; i < ((ArrayList<Nodo>)this.valor).size(); i++){
                    ((ArrayList<Nodo>)this.valor).get(i).execute(table,tree);
                    if(((ArrayList<Nodo>)this.valor).get(i).tipo != variable.tipo.tipo){
                        String err = "El arreglo no puede ser asignado porque no poseen los mismos tipos \n";
                        Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                        tree.excepciones.add(error);
                        tree.consola.add(error.toString());
                        return error;
                    }
                }
                result = this.valor;
            }else{
                String err = "El arreglo no puede ser asignado porque no poseen las mismas dimensiones \n";
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.excepciones.add(error);
                tree.consola.add(error.toString());
                return error;
            }
        }

        this.resultado = result;
        variable.valor = result;
        return null;
    }
}
