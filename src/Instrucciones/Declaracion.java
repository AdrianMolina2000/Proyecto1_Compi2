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


public class Declaracion extends Nodo {
    String id;
    public Nodo valor;

    //Para AST
    NodoAST nodoMain;

    public Declaracion(Tipo.Tipos tipo, String id, Nodo valor, int line, int column) {
        super(tipo, line, column);
        this.id = id;
        this.valor = valor;
    }

    @Override
    public Object execute(Table table, Tree tree) {

        //ERROR
        if(this.valor == null){
            String err = "La expresion no es valida \n";
            Excepcion error = new Excepcion("Semantico", err,this.line, this.column);
            tree.excepciones.add(error);
            return error;
        }


        Object result = this.valor.execute(table, tree);
        if (result instanceof Excepcion) {
            return result;
        }

        //Verifico que no sea una lista
        if (result instanceof ArrayList<?>) {
            String err = "No puede asignar un arreglo a una variable \n";
            Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
            tree.excepciones.add(error);
            return error;
        }

        //Verifico que sean de los mismo tipos
        if (this.valor.tipo != this.tipo) {
            String err = "La variable {" +this.id+ "} no puede ser declarada debido a que son de diferentes tipos [" +this.tipo+"] y [" +valor.tipo + "] \n";
            Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
            tree.excepciones.add(error);
            return error;
        }

        Tipo nuevoTipo = new Tipo(this.tipo);
        Tipo nuevoTipo2 = new Tipo(Tipo.Tipos.VARIABLE);

        Simbolo simbolo = new Simbolo(nuevoTipo, nuevoTipo2, this.id, result, this.line, this.column, table);

        if(table.getVariable(this.id) == null){
            table.setVariable(simbolo);

            //Creacion de nodoMain AST
            nodoMain = new NodoAST("DECLARACION");
            NodoAST nodoId = new NodoAST("ID");
            nodoId.agregarHijo(new NodoAST(tipo.toString()));
            nodoId.agregarHijo(new NodoAST(id));
            nodoMain.agregarHijo(nodoId);
            nodoMain.agregarHijo(this.valor.getAST());

            //Termino la ejecucion
            return null;
        }else{
            String err = "La variable {" + this.id + "} ya ha sido declarada \n";
            Excepcion error = new Excepcion("Semantico", err, line, column);
            tree.excepciones.add(error);
            return error;
        }
    }

    @Override
    public NodoAST getAST() {
        NodoAST nodo = new NodoAST("DECLARACION");

        if(nodoMain != null){
            return nodoMain;
        }

        return nodo;
    }
}
