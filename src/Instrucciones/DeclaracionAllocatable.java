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

public class DeclaracionAllocatable extends Nodo {
    String id;
    boolean flag;

    NodoAST nodoMain;
    public DeclaracionAllocatable(Tipo.Tipos tipo, String id, boolean flag, int line, int column) {
        super(tipo, line, column);
        this.id = id;
        this.flag = flag;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        Simbolo simbolo;

        Tipo nuevoTipo;
        Tipo nuevoTipo2;
        Object result;

        //Verifico si es de una o dos dimensiones
        if(this.flag){
            result = new ArrayList<Nodo>();

            nuevoTipo = new Tipo(this.tipo);
            nuevoTipo2 = new Tipo(Tipo.Tipos.ALLOCATE);
        }else{
            result = new ArrayList<ArrayList<Nodo>>();

            nuevoTipo = new Tipo(this.tipo);
            nuevoTipo2 = new Tipo(Tipo.Tipos.ALLOCATE2);
        }

        //Creo la nueva variable
        simbolo = new Simbolo(nuevoTipo, nuevoTipo2, this.id, result, this.line, this.column, table);

        //Verifico si existe en la tabla de simbolos
        if(table.getVariable(this.id) == null){
            table.setVariable(simbolo);
            tree.Variables.add(simbolo);

            nodoMain = new NodoAST("ALLOCATABLE");
            nodoMain.agregarHijo(new NodoAST(this.tipo.toString()));
            nodoMain.agregarHijo(new NodoAST(this.id));

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
        NodoAST nodo = new NodoAST("ALLOCATABLE");

        if(nodoMain != null){
            return nodoMain;
        }

        return nodo;
    }

    @Override
    public void get3D() {

    }
}
