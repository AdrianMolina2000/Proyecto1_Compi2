package Instrucciones;

import Abstract.Nodo;
import Expresiones.Identificador;
import Other.Excepcion;
import Other.Tipo;
import Symbols.Simbolo;
import Symbols.Table;
import Symbols.Tree;

import java.util.ArrayList;

public class Asignacion extends Nodo {
    public String id;
    public Object expresion;
    Object resultado;

    public Asignacion(String id, Object valor, int line, int column) {
        super(null, line, column);
        this.id = id;
        this.expresion = valor;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        Object result = this.expresion;

        if(this.expresion instanceof Nodo res){
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

        if(this.expresion instanceof Nodo res){
            if (res.tipo != variable.tipo.tipo){
                String err = "La variable {"+this.id+"} no puede ser asignada debido a que son de diferentes tipos ["+ variable.tipo.tipo + "] y ["+res.tipo+"] \n";
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.excepciones.add(error);
                tree.consola.add(error.toString());
                return error;
            }else{
                this.tipo = variable.tipo.tipo;
            }
        }

        if(variable.tipo2.tipo == Tipo.Tipos.ARREGLO || variable.tipo2.tipo == Tipo.Tipos.ALLOCATE){
            if(result instanceof ArrayList<?> result2){
                ArrayList<Nodo> variableValor = (ArrayList<Nodo>)variable.valor;

                if(variableValor.size() == result2.size()){
                    for(int i = 0; i < result2.size(); i++){
                        if(((ArrayList<Nodo>)result2).get(i).tipo != variable.tipo.tipo){
                            String err = "El arreglo no puede ser asignado porque no poseen los mismos tipos \n";
                            Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                            tree.excepciones.add(error);
                            tree.consola.add(error.toString());
                            return error;
                        }
                    }
                }else{
                    String err = "El arreglo no puede ser asignado porque no poseen las mismas dimensiones \n";
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    tree.consola.add(error.toString());
                    return error;
                }
            }else{
                String err = "No esta asignando un arreglo a la variable [" +variable.id+ "] \n";
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.excepciones.add(error);
                tree.consola.add(error.toString());
                return error;
            }
        }else if(variable.tipo2.tipo == Tipo.Tipos.ARREGLO2 || variable.tipo2.tipo == Tipo.Tipos.ALLOCATE2){
            if(result instanceof ArrayList<?> result2){
                ArrayList<ArrayList<Nodo>> listaI = (ArrayList<ArrayList<Nodo>>) variable.valor;

                if(result2.size() != listaI.size()){
                    String err = "El arreglo no puede ser asignado porque no poseen las mismas dimensiones \n";
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    tree.consola.add(error.toString());
                    return error;
                }

                ArrayList<Nodo> listaJ = listaI.get(0);
                ArrayList<Nodo> result3 = (ArrayList<Nodo>) result2.get(0);

                if(result3.size() != listaJ.size()){
                    String err = "El arreglo no puede ser asignado porque no poseen las mismas dimensiones \n";
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    tree.consola.add(error.toString());
                    return error;
                }

                if( result3.get(0).tipo != variable.tipo.tipo){
                    String err = "El arreglo no puede ser asignado porque no poseen los mismos tipos \n";
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    tree.consola.add(error.toString());
                    return error;
                }
            }else{
                String err = "No esta asignando un arreglo a la variable [" +variable.id+ "] \n";
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.excepciones.add(error);
                tree.consola.add(error.toString());
                return error;
            }
        }else{
            if(result instanceof ArrayList<?>){
                String err = "La variable [" +variable.id+ "] no es del tipo array, no puede asignarla \n";
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.excepciones.add(error);
                tree.consola.add(error.toString());
                return error;
            }
        }

        this.resultado = result;
        variable.valor = result;
        return result;
    }
}
