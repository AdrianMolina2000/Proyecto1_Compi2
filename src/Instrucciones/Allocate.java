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

    //Para el AST
    NodoAST mainAST;


    public Allocate(String id, Nodo dim1, Nodo dim2, int line, int column) {
        super(null, line, column);
        this.id = id;
        this.dim1 = dim1;
        this.dim2 = dim2;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        //Obtengo la variable de la tabla de simbolos
        Simbolo simbolo = table.getVariable(this.id);

        //ERROR
        if(simbolo == null){
            String err = "La variable {" + this.id + "} no ha sido encontrada \n";
            Excepcion error = new Excepcion("Semantico", err, line, column);
            tree.excepciones.add(error);
            return error;
        }

        //ERROR
        if(this.dim1 == null){
            String err = "No han ingresado dimensiones \n";
            Excepcion error = new Excepcion("Semantico", err, line, column);
            tree.excepciones.add(error);
            return error;
        }

        Object di1 = this.dim1.execute(table, tree);
        if (di1 instanceof Excepcion e) {
            return di1;
        }

        //ERROR
        if(((ArrayList<?>)simbolo.valor).size() != 0){
            String err = "La variable {" + this.id + "} ya posee una dimension, no puede usar Allocate de nuevo \n";
            Excepcion error = new Excepcion("Semantico", err, line, column);
            tree.excepciones.add(error);
            return error;
        }

        if(simbolo.tipo2.tipo == Tipo.Tipos.ALLOCATE){
            //ERROR
            if(this.dim2 != null){
                String err = "El arreglo es unicamente de 1 dimension \n";
                Excepcion error = new Excepcion("Semantico", err, line, column);
                tree.excepciones.add(error);
                return error;
            }

            if(di1 instanceof Integer d1){
                //ERROR
                if(d1 <= 0){
                    String err = "Las dimensiones no pueden ser menores a 1 \n";
                    Excepcion error = new Excepcion("Semantico", err, line, column);
                    tree.excepciones.add(error);
                    return error;
                }

                //Creo una nueva lista vacia
                ArrayList<Nodo> res = new ArrayList<Nodo>();

                for(int i = 0; i<d1; i++){
                    res.add(Globales.defal(simbolo.tipo.tipo, this.line, this.column));
                }

                //Para el AST
                mainAST = new NodoAST("ALLOCATE");
                mainAST.agregarHijo(this.dim1.getAST());

                //Se asigna la lista a la variable
                simbolo.valor = res;
                return null;
            }

            //ERROR
            else{
                String err = "Las dimensiones deben ser INTEGER \n";
                Excepcion error = new Excepcion("Semantico", err, line, column);
                tree.excepciones.add(error);
                return error;
            }


        }else if(simbolo.tipo2.tipo == Tipo.Tipos.ALLOCATE2){
            //ERROR
            if(this.dim2 == null){
                String err = "El arreglo es de 2 dimension \n";
                Excepcion error = new Excepcion("Semantico", err, line, column);
                tree.excepciones.add(error);
                return error;
            }

            Object di2 = this.dim2.execute(table, tree);
            if (di2 instanceof Excepcion e) {
                return di2;
            }

            if(di1 instanceof Integer d1) {
                if(di2 instanceof Integer d2) {
                    if (d1 <= 0 || d2 <= 0) {
                        String err = "Las dimensiones no pueden ser menores a 1 \n";
                        Excepcion error = new Excepcion("Semantico", err, line, column);
                        tree.excepciones.add(error);
                        return error;
                    }

                    //Se crea la nueva lista de listas
                    ArrayList<ArrayList<Nodo>> resI = new ArrayList<ArrayList<Nodo>>();

                    //Se llena la lista
                    for (int i = 0; i < d1; i++) {
                        //Se crea la lista de Nodos
                        ArrayList<Nodo> resJ = new ArrayList<Nodo>();

                        //Se llena la lista de Nodos
                        for (int j = 0; j < d2; j++) {
                            resJ.add(Globales.defal(simbolo.tipo.tipo, this.line, this.column));
                        }
                        resI.add(resJ);
                    }

                    //Para el AST
                    mainAST = new NodoAST("ALLOCATE");
                    mainAST.agregarHijo(this.dim1.getAST());
                    mainAST.agregarHijo(this.dim2.getAST());

                    //Se asigna la lista a la variable
                    simbolo.valor = resI;
                    return null;
                }

                //ERROR
                else{
                    String err = "Las dimensiones deben ser INTEGER \n";
                    Excepcion error = new Excepcion("Semantico", err, line, column);
                    tree.excepciones.add(error);
                    return error;
                }
            }

            //ERROR
            else{
                String err = "Las dimensiones deben ser INTEGER \n";
                Excepcion error = new Excepcion("Semantico", err, line, column);
                tree.excepciones.add(error);
                return error;
            }
        }

        //ERROR
        else{
            String err = "El arreglo no es del tipo Allocatable \n";
            Excepcion error = new Excepcion("Semantico", err, line, column);
            tree.excepciones.add(error);
            return error;
        }
    }

    @Override
    public NodoAST getAST() {
        NodoAST nodo = new NodoAST("ALLOCATE");

        if(mainAST != null){
            return mainAST;
        }

        return nodo;
    }

    @Override
    public void get3D() {

    }
}
