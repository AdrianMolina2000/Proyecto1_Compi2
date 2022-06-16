package Instrucciones;

import Abstract.Nodo;
import Abstract.NodoAST;
import Other.Excepcion;
import Other.Tipo;
import Symbols.Simbolo;
import Symbols.Table;
import Symbols.Tree;

import java.util.ArrayList;

public class Deallocate extends Nodo {
    String id;

    //Para el AST
    NodoAST nodoMain;

    public Deallocate(String id, int line, int column) {
        super(null, line, column);
        this.id = id;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        //Obtengo la variable de la tabla de Simbolos
        Simbolo simbolo = table.getVariable(this.id);

        if(simbolo == null){
            String err = "La variable {" + this.id + "} no ha sido encontrada \n";
            Excepcion error = new Excepcion("Semantico", err, line, column);
            tree.excepciones.add(error);
            return error;
        }

        //Verifico que la variable sea del tipo ALLOCATE
        if (simbolo.tipo2.tipo == Tipo.Tipos.ALLOCATE) {

            //Verifico que la variable posea una lista
            if(simbolo.valor instanceof ArrayList<?> listaI){

                //ERROR
                if(listaI.size() == 0){
                    String err = "La variable {" + this.id + "} no posee dimension, no puede usar Deallocate de nuevo \n";
                    Excepcion error = new Excepcion("Semantico", err, line, column);
                    tree.excepciones.add(error);
                    return error;
                }

                //Le asigno una lista vacia a la variable
                simbolo.valor = new ArrayList<Nodo>();

                //Creo el nodo para el AST
                nodoMain = new NodoAST("DEALLOCATE");
                nodoMain.agregarHijo(new NodoAST(this.id));

                //Termino la Ejecucion
                return null;
            }

            //ERROR
            else{
                String err = "El arreglo no posee un ArrayList \n";
                Excepcion error = new Excepcion("Semantico", err, line, column);
                tree.excepciones.add(error);
                return error;
            }

        }

        //Verifico que la variable sea del tipo ARRAY 2 dimensiones
        else if(simbolo.tipo2.tipo == Tipo.Tipos.ALLOCATE2){
            //Verifico que la variable posea una lista
            if(simbolo.valor instanceof ArrayList<?> listaI){

                //ERROR
                if(listaI.size() == 0){
                    String err = "La variable {" + this.id + "} no posee dimensiones, no puede usar Deallocate de nuevo \n";
                    Excepcion error = new Excepcion("Semantico", err, line, column);
                    tree.excepciones.add(error);
                    return error;
                }

                //Le asigno una lista vacia a la variable
                simbolo.valor = new ArrayList<ArrayList<Nodo>>();

                //Creo el nodo para el AST
                nodoMain = new NodoAST("DEALLOCATE");
                nodoMain.agregarHijo(new NodoAST(this.id));

                //Termino la Ejecucion
                return null;
            }

            //ERROR
            else{
                String err = "El arreglo no posee un ArrayList \n";
                Excepcion error = new Excepcion("Semantico", err, line, column);
                tree.excepciones.add(error);
                return error;
            }
        }

        //ERROR
        else{
            String err = "La variable no es del tipo Allocatable \n";
            Excepcion error = new Excepcion("Semantico", err, line, column);
            tree.excepciones.add(error);
            return error;
        }
    }

    @Override
    public NodoAST getAST() {
        NodoAST nodo =  new NodoAST("DEALLOCATE");

        if(nodoMain != null){
            return nodoMain;
        }

        return nodo;
    }
}
