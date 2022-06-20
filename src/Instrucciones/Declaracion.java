package Instrucciones;

import Abstract.Nodo;
import Abstract.NodoAST;
import Expresiones.Primitivo;
import Gramatica.Globales;
import Other.Excepcion;
import Other.Tipo;
import Symbols.C3D;
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

        //Verifico si la variable ya existe
        if(table.getVariable(this.id) != null){
            String err = "La variable {" + this.id + "} ya ha sido declarada \n";
            Excepcion error = new Excepcion("Semantico", err, line, column);
            tree.excepciones.add(error);
            return error;
        }

        //Creo la variable
        Tipo nuevoTipo = new Tipo(this.tipo);
        Tipo nuevoTipo2 = new Tipo(Tipo.Tipos.VARIABLE);

        Simbolo simbolo = new Simbolo(nuevoTipo, nuevoTipo2, this.id, result, this.line, this.column, table);


        //Para 3D
        if(Globales.gen == null){
            C3D genAux = new C3D();
            Globales.gen = genAux.getInstance();
        }
        Globales.gen.addComment("Empezando Declarar Variable");

        simbolo.pos = table.size;
        simbolo.heap = false;
        int pos = simbolo.pos;

        if(this.valor.tipo == Tipo.Tipos.LOGICAL){
            String ev = Globales.gen.newLabel();
            Globales.gen.addLabel(this.valor.ev);
            Globales.gen.setStack(String.valueOf(pos), "1");
            Globales.gen.addGoto(ev);
            Globales.gen.addLabel(this.valor.ef);
            Globales.gen.setStack(String.valueOf(pos), "0");
            Globales.gen.addLabel(ev);
        }else{
            Globales.gen.setStack(String.valueOf(pos), this.valor.valor3D);
        }

        Globales.gen.addComment("Fin declaracion varible");




        table.setVariable(simbolo);
        tree.Variables.add(simbolo);

        //Creacion de nodoMain AST
        nodoMain = new NodoAST("DECLARACION");
        NodoAST nodoId = new NodoAST("ID");
        nodoId.agregarHijo(new NodoAST(tipo.toString()));
        nodoId.agregarHijo(new NodoAST(id));
        nodoMain.agregarHijo(nodoId);
        nodoMain.agregarHijo(this.valor.getAST());

        //Termino la ejecucion
        return null;
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
