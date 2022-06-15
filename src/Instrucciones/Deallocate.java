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
    public Deallocate(String id, int line, int column) {
        super(null, line, column);
        this.id = id;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        Simbolo simbolo = table.getVariable(this.id);

        if(simbolo == null){
            String err = "La variable {" + this.id + "} no ha sido encontrada \n";
            Excepcion error = new Excepcion("Semantico", err, line, column);
            tree.excepciones.add(error);
            tree.consola.add(error.toString());
        }else {
            if(((ArrayList<?>)simbolo.valor).size() == 0){
                String err = "La variable {" + this.id + "} no posee dimension, no puede usar Deallocate de nuevo \n";
                Excepcion error = new Excepcion("Semantico", err, line, column);
                tree.excepciones.add(error);
                tree.consola.add(error.toString());
                return error;
            }

            if (simbolo.tipo2.tipo == Tipo.Tipos.ALLOCATE) {
                simbolo.valor = new ArrayList<Nodo>();
            }else if(simbolo.tipo2.tipo == Tipo.Tipos.ALLOCATE2){
                simbolo.valor = new ArrayList<ArrayList<Nodo>>();
            }else{
                String err = "El arreglo no es del tipo Allocatable \n";
                Excepcion error = new Excepcion("Semantico", err, line, column);
                tree.excepciones.add(error);
                tree.consola.add(error.toString());
                return error;
            }
        }
        return null;
    }

    @Override
    public NodoAST getAST() {
        NodoAST nodo =  new NodoAST("DEALLOCATE");
        nodo.agregarHijo(new NodoAST(this.id));
        return nodo;
    }
}
