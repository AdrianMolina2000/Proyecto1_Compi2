package Instrucciones;

import Abstract.Nodo;
import Abstract.NodoAST;
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

    //PARA AST
    NodoAST nodoMain;

    public AsignacionArrayD(String id, Nodo expresion, int line, int column) {
        super(null, line, column);
        this.id = id;
        this.expresion = expresion;
    }

    @Override
    public Object execute(Table table, Tree tree) {

        //Obtengo la variable a asignar
        Simbolo variable = table.getVariable(this.id);

        //ERROR
        if (variable == null) {
            String err = "La variable {"+this.id+"} no ha sido encontrada \n";
            Excepcion error = new Excepcion("Semantico", err,this.line, this.column);
            tree.excepciones.add(error);
            return error;
        }

        //ERROR
        if(this.expresion == null){
            String err = "La expresion no es valida \n";
            Excepcion error = new Excepcion("Semantico", err,this.line, this.column);
            tree.excepciones.add(error);
            return error;
        }

        Object result = this.expresion.execute(table, tree);
        if (result instanceof Excepcion) {
            return result;
        }

        //Verifico si la variable es del mismo tipo que la expresion
        if(this.expresion.tipo != variable.tipo.tipo){
            String err = "El arreglo no puede ser asignado porque no poseen los mismos tipos \n";
            Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
            tree.excepciones.add(error);
            return error;
        }

        //Verifico si la variable es del tipo ARRAY
        if(variable.tipo2.tipo == Tipo.Tipos.ARREGLO || variable.tipo2.tipo == Tipo.Tipos.ALLOCATE){

            //Verifico si el valor de la variable es una Lista
            if(variable.valor instanceof ArrayList<?> listaI){

                //ERROR
                if(listaI.size() == 0){
                    String err = "El arreglo no posee dimensiones \n";
                    Excepcion error = new Excepcion("Semantico", err, line, column);
                    tree.excepciones.add(error);
                    return error;
                }

                String resultado = "[";
                for(int i = 0; i < listaI.size(); i++){
                    Primitivo prim= new Primitivo(variable.tipo.tipo, result, this.line, this.column);
                    ((ArrayList<Nodo>)variable.valor).set(i, prim);

                    resultado += result + ", ";
                }
                resultado += "]";

                //Creo el nodo para el AST
                nodoMain = new NodoAST("ASIGNACION");
                nodoMain.agregarHijo(new NodoAST(this.id));
                nodoMain.agregarHijo(new NodoAST(resultado));

                //Termino la ejecucion
                return null;
            }

            //ERROR
            else{
                String err = "La variable no posee un arreglo \n";
                Excepcion error = new Excepcion("Semantico", err, line, column);
                tree.excepciones.add(error);
                return error;
            }
        }

        //Verifico si la variable es del tipo ARRAY de 2 dimensiones
        else if(variable.tipo2.tipo == Tipo.Tipos.ARREGLO2 || variable.tipo2.tipo == Tipo.Tipos.ALLOCATE2){
            //Verifico si el valor de la variable es una Lista
            if(variable.valor instanceof ArrayList<?> listaI){

                //ERROR
                if(listaI.size() == 0){
                    String err = "El arreglo no posee dimensiones \n";
                    Excepcion error = new Excepcion("Semantico", err, line, column);
                    tree.excepciones.add(error);
                    return error;
                }

                if(listaI.get(0) instanceof ArrayList<?> listaJ) {
                    String resultado = "[";
                    for(int i = 0; i < listaI.size(); i++){
                        resultado += "[";

                        //Obtengo la lista de Nodos
                        ArrayList<Nodo> arra = ((ArrayList<ArrayList<Nodo>>)variable.valor).get(i);

                        for(int j = 0; j < arra.size(); j++){
                            //Creo el nuevo valor para el arreglo
                            Primitivo prim= new Primitivo(variable.tipo.tipo, result, this.line, this.column);
                            arra.set(j, prim);

                            resultado += result + ", ";
                        }
                        resultado += "], ";
                        ((ArrayList<ArrayList<Nodo>>)variable.valor).set(i, arra);
                    }
                    resultado += "]";

                    //Creo el nodo para el AST
                    nodoMain = new NodoAST("ASIGNACION");
                    nodoMain.agregarHijo(new NodoAST(this.id));
                    nodoMain.agregarHijo(new NodoAST(resultado));

                    //Termino la ejecucion
                    return null;
                }

                //ERROR
                else{
                    String err = "La variable no posee un arreglo \n";
                    Excepcion error = new Excepcion("Semantico", err, line, column);
                    tree.excepciones.add(error);
                    return error;
                }
            }

            //ERROR
            else{
                String err = "La variable no posee un arreglo \n";
                Excepcion error = new Excepcion("Semantico", err, line, column);
                tree.excepciones.add(error);
                return error;
            }
        }

        //ERROR
        else{
            String err = "La variable [" +variable.id+ "] no es de un tipo valido para asignar \n";
            Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
            tree.excepciones.add(error);
            return error;
        }

    }

    @Override
    public NodoAST getAST() {
        NodoAST nodo = new NodoAST("ASIGNACION");

        if(nodoMain != null){
            return nodoMain;
        }

        return nodo;
    }

    @Override
    public void get3D() {

    }
}
