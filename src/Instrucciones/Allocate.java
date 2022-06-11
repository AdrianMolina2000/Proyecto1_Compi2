package Instrucciones;

import Abstract.Nodo;
import Gramatica.Globales;
import Other.Excepcion;
import Other.Tipo;
import Symbols.Simbolo;
import Symbols.Table;
import Symbols.Tree;

import java.util.ArrayList;

public class Allocate extends Nodo {
    String id;
    Object dim1;
    Object dim2;

    public Allocate(String id, Object dim1, Object dim2, int line, int column) {
        super(null, line, column);
        this.id = id;
        this.dim1 = dim1;
        this.dim2 = dim2;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        Simbolo simbolo = table.getVariable(this.id);

        if(simbolo == null){
            String err = "La variable {" + this.id + "} no ha sido encontrada \n";
            Excepcion error = new Excepcion("Semantico", err, line, column);
            tree.excepciones.add(error);
            tree.consola.add(error.toString());
            return error;
        }

        if(((ArrayList<?>)simbolo.valor).size() != 0){
            String err = "La variable {" + this.id + "} ya posee una dimension, no puede usar Allocate de nuevo \n";
            Excepcion error = new Excepcion("Semantico", err, line, column);
            tree.excepciones.add(error);
            tree.consola.add(error.toString());
            return error;
        }

        if(simbolo.tipo2.tipo == Tipo.Tipos.ALLOCATE || simbolo.tipo2.tipo == Tipo.Tipos.ALLOCATE2){
            if(this.dim2 == null){
                if((int)this.dim1 <= 0){
                    String err = "Las dimensiones no pueden ser menores a 1 \n";
                    Excepcion error = new Excepcion("Semantico", err, line, column);
                    tree.excepciones.add(error);
                    tree.consola.add(error.toString());
                    return error;
                }

                ArrayList<Nodo> res = new ArrayList<Nodo>();

                for(int i = 0; i<(int)this.dim1; i++){
                    res.add(Globales.defal(simbolo.tipo.tipo, this.line, this.column));
                }

                simbolo.valor = res;
            }else{
                if((int)this.dim1 <= 0 || (int)this.dim2 <= 0){
                    String err = "Las dimensiones no pueden ser menores a 1 \n";
                    Excepcion error = new Excepcion("Semantico", err, line, column);
                    tree.excepciones.add(error);
                    tree.consola.add(error.toString());
                    return error;
                }

                ArrayList<ArrayList<Nodo>> resI = new ArrayList<ArrayList<Nodo>>();

                for(int i = 0; i<(int)this.dim1; i++){
                    ArrayList<Nodo> resJ = new ArrayList<Nodo>();
                    for(int j = 0; j<(int)this.dim2; j++){
                        resJ.add(Globales.defal(simbolo.tipo.tipo, this.line, this.column));
                    }
                    resI.add(resJ);
                }
                simbolo.valor = resI;
            }
        }else{
            String err = "El arreglo no es del tipo Allocatable \n";
            Excepcion error = new Excepcion("Semantico", err, line, column);
            tree.excepciones.add(error);
            tree.consola.add(error.toString());
            return error;
        }
        return null;
    }
}
