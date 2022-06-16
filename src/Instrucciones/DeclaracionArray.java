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

public class DeclaracionArray extends Nodo {
    String id;
    Nodo dim1;
    Nodo dim2;
    public Object valor;

    //Para AST
    NodoAST nodoMain;

    public DeclaracionArray(Tipo.Tipos tipo, String id, Nodo dim1, Nodo dim2, int line, int column) {
        super(tipo, line, column);
        this.id = id;
        this.dim1 = dim1;
        this.dim2 = dim2;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        Simbolo simbolo = table.getVariable(this.id);

        if(simbolo != null){
            String err = "La variable {" + this.id + "} ya ha sido declarada \n";
            Excepcion error = new Excepcion("Semantico", err, line, column);
            tree.excepciones.add(error);
            return error;
        }

        //Verifico que venga una posicion
        if(this.dim1 == null){
            String err = "Debe enviar una dimension del arreglo valida \n";
            Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
            tree.excepciones.add(error);
            //tree.consola.add(error.toString());
            return error;
        }

        Object dm1 = this.dim1.execute(table, tree);
        if (dm1 instanceof Excepcion) {
            return dm1;
        }

        //Verifico si sera un arreglo de 1 dimension
        if(this.dim2 == null){
            if(dm1 instanceof Integer d1){

                //ERROR
                if(d1 <= 0){
                    String err = "Las dimensiones no pueden ser menores a 1 \n";
                    Excepcion error = new Excepcion("Semantico", err, line, column);
                    tree.excepciones.add(error);
                    return error;
                }

                //Creo una lista con valores por defecto para la variable
                ArrayList<Nodo> result = new ArrayList<Nodo>();
                for(int i = 0; i < d1; i++){
                    result.add(Globales.defal(this.tipo, this.line, this.column));
                }

                //Creo la nueva variable tipo ARRAY
                Tipo nuevoTipo = new Tipo(this.tipo);
                Tipo nuevoTipo2 = new Tipo(Tipo.Tipos.ARREGLO);
                simbolo = new Simbolo(nuevoTipo, nuevoTipo2, this.id, result, this.line, this.column, table);

                //Creo el nodo para el AST
                nodoMain =  new NodoAST("DECLARACION");
                NodoAST nodoId =  new NodoAST("ID");
                nodoId.agregarHijo(new NodoAST(this.tipo.toString()));
                nodoId.agregarHijo(new NodoAST(this.id));
                nodoMain.agregarHijo(nodoId);
                NodoAST nodoDim =  new NodoAST("DIMENSIONES");
                nodoDim.agregarHijo(this.dim1.getAST());
                nodoMain.agregarHijo(nodoDim);

                //Agrego la variable a la tabla de simbolos
                table.setVariable(simbolo);

                //Termino la ejecucion
                return null;
            }

            //ERROR
            else{
                String err = "El arreglo no puede ser declarado porque la dimension no es INTEGER \n";
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.excepciones.add(error);
                return error;
            }
        }

        //El arreglo sera de 2 dimensiones
        else{
            if(dm1 instanceof Integer d1){

                Object dm2 = this.dim2.execute(table, tree);
                if (dm2 instanceof Excepcion) {
                    return dm2;
                }

                if(dm2 instanceof Integer d2){

                    //ERROR
                    if(d1 <= 0 || d2 <= 0){
                        String err = "Las dimensiones no pueden ser menores a 1 \n";
                        Excepcion error = new Excepcion("Semantico", err, line, column);
                        tree.excepciones.add(error);
                        return error;
                    }

                    //Creo la lista para asignar a la variable
                    ArrayList<ArrayList<Nodo>> resI = new ArrayList<ArrayList<Nodo>>();

                    for(int i = 0; i < d1; i++){

                        //Creo una lista de nodos
                        ArrayList<Nodo> resJ = new ArrayList<Nodo>();

                        for(int j = 0; j < d2; j++){
                            resJ.add(Globales.defal(this.tipo, this.line, this.column));
                        }

                        //Agrego la lista de nodos a la lista de listas
                        resI.add(resJ);
                    }

                    //Creo la nueva variable tipo ARRAY
                    Tipo nuevoTipo = new Tipo(this.tipo);
                    Tipo nuevoTipo2 = new Tipo(Tipo.Tipos.ARREGLO2);
                    simbolo = new Simbolo(nuevoTipo, nuevoTipo2, this.id, resI, this.line, this.column, table);

                    //Creo el nodo para el AST
                    nodoMain =  new NodoAST("DECLARACION");
                    NodoAST nodoId =  new NodoAST("ID");
                    nodoId.agregarHijo(new NodoAST(this.tipo.toString()));
                    nodoId.agregarHijo(new NodoAST(this.id));
                    nodoMain.agregarHijo(nodoId);
                    NodoAST nodoDim =  new NodoAST("DIMENSIONES");
                    nodoDim.agregarHijo(this.dim1.getAST());
                    nodoDim.agregarHijo(this.dim2.getAST());
                    nodoMain.agregarHijo(nodoDim);

                    //Agrego la variable a la tabla de simbolos
                    table.setVariable(simbolo);

                    //Termino la ejecucion
                    return null;
                }

                //ERROR
                else{
                    String err = "El arreglo no puede ser declarado porque la dimension no es INTEGER \n";
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    return error;
                }
            }

            //ERROR
            else{
                String err = "El arreglo no puede ser declarado porque la dimension no es INTEGER \n";
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.excepciones.add(error);
                return error;
            }
        }
    }

    @Override
    public NodoAST getAST() {
        NodoAST nodo =  new NodoAST("DECLARACION");

        if(nodoMain != null){
            return nodoMain;
        }

        return nodo;
    }
}
