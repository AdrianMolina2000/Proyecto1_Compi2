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

    public DeclaracionArray(Tipo.Tipos tipo, String id, Nodo dim1, Nodo dim2, int line, int column) {
        super(tipo, line, column);
        this.id = id;
        this.dim1 = dim1;
        this.dim2 = dim2;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        Simbolo simbolo;

        Object dm1 = this.dim1.execute(table, tree);


        if(this.dim2 == null){
            if((int)dm1 <= 0){
                String err = "Las dimensiones no pueden ser menores a 1 \n";
                Excepcion error = new Excepcion("Semantico", err, line, column);
                tree.excepciones.add(error);
                tree.consola.add(error.toString());
                return error;
            }

            ArrayList<Nodo> res = new ArrayList<Nodo>();

            for(int i = 0; i<(int)dm1; i++){
                res.add(Globales.defal(this.tipo, this.line, this.column));
            }

            this.valor = res;
            simbolo = new Simbolo(new Tipo(this.tipo), new Tipo(Tipo.Tipos.ARREGLO), this.id, this.valor, this.line, this.column, table);
        }else{
            Object dm2 = this.dim2.execute(table, tree);
            if((int)dm1 <= 0 || (int)dm2 <= 0){
                String err = "Las dimensiones no pueden ser menores a 1 \n";
                Excepcion error = new Excepcion("Semantico", err, line, column);
                tree.excepciones.add(error);
                tree.consola.add(error.toString());
                return error;
            }

            ArrayList<ArrayList<Nodo>> resI = new ArrayList<ArrayList<Nodo>>();

            for(int i = 0; i<(int)dm1; i++){
                ArrayList<Nodo> resJ = new ArrayList<Nodo>();
                for(int j = 0; j<(int)dm2; j++){
                    resJ.add(Globales.defal(this.tipo, this.line, this.column));
                }
                resI.add(resJ);
            }
            this.valor = resI;
            simbolo = new Simbolo(new Tipo(this.tipo), new Tipo(Tipo.Tipos.ARREGLO2), this.id, this.valor, this.line, this.column, table);
        }


        if(table.getVariable(this.id) == null){
            table.setVariable(simbolo);
        }else{
            String err = "La variable {" + this.id + "} ya ha sido declarada \n";
            Excepcion error = new Excepcion("Semantico", err, line, column);
            tree.excepciones.add(error);
            tree.consola.add(error.toString());
            return error;
        }

        return null;
    }

    @Override
    public NodoAST getAST() {
        NodoAST nodo =  new NodoAST("DECLARACION");
        NodoAST nodoId =  new NodoAST("ID");
        nodoId.agregarHijo(new NodoAST(tipo.toString()));
        nodoId.agregarHijo(new NodoAST(this.id));
        nodo.agregarHijo(nodoId);
        NodoAST nodoDim =  new NodoAST("DIMENSIONES");
        nodoDim.agregarHijo(this.dim1.getAST());
        if(this.dim2 != null){
            nodoDim.agregarHijo(this.dim2.getAST());
        }
        nodo.agregarHijo(nodoDim);
        return nodo;
    }
}
