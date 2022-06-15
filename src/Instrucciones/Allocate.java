package Instrucciones;

import Abstract.Nodo;
import Abstract.NodoAST;
import Gramatica.Globales;
import Other.Excepcion;
import Other.Tipo;
import Symbols.Simbolo;
import Symbols.Table;
import Symbols.Tree;

import java.util.ArrayList;

public class Allocate extends Nodo {
    String id;
    Nodo dim1;
    Nodo dim2;
    Object di1;
    Object di2;

    public Allocate(String id, Nodo dim1, Nodo dim2, int line, int column) {
        super(null, line, column);
        this.id = id;
        this.dim1 = dim1;
        this.dim2 = dim2;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        Simbolo simbolo = table.getVariable(this.id);

        di1 = this.dim1.execute(table, tree);
        if (di1 instanceof Excepcion) {
            return di1;
        }

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
                if((int)this.di1 <= 0){
                    String err = "Las dimensiones no pueden ser menores a 1 \n";
                    Excepcion error = new Excepcion("Semantico", err, line, column);
                    tree.excepciones.add(error);
                    tree.consola.add(error.toString());
                    return error;
                }

                ArrayList<Nodo> res = new ArrayList<Nodo>();

                for(int i = 0; i<(int)this.di1; i++){
                    res.add(Globales.defal(simbolo.tipo.tipo, this.line, this.column));
                }

                simbolo.valor = res;
            }else{
                di2 = this.dim2.execute(table, tree);
                if (di2 instanceof Excepcion) {
                    return di2;
                }

                if((int)this.di1 <= 0 || (int)this.di2 <= 0){
                    String err = "Las dimensiones no pueden ser menores a 1 \n";
                    Excepcion error = new Excepcion("Semantico", err, line, column);
                    tree.excepciones.add(error);
                    tree.consola.add(error.toString());
                    return error;
                }

                ArrayList<ArrayList<Nodo>> resI = new ArrayList<ArrayList<Nodo>>();

                for(int i = 0; i<(int)this.di1; i++){
                    ArrayList<Nodo> resJ = new ArrayList<Nodo>();
                    for(int j = 0; j<(int)this.di2; j++){
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

    @Override
    public NodoAST getAST() {
        NodoAST nodo = new NodoAST("ALLOCATE");
        nodo.agregarHijo(new NodoAST(this.id));
        NodoAST dimen = new NodoAST("Dimension");

        if(this.dim2 == null){
            dimen.agregarHijo(String.valueOf(this.di1));
        }else{
            dimen.agregarHijo(String.valueOf(this.di1));
            dimen.agregarHijo(String.valueOf(this.di2));
        }

        nodo.agregarHijo(dimen);
        return nodo;
    }
}
