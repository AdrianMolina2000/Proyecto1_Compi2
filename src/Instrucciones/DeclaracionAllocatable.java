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
    public DeclaracionAllocatable(Tipo.Tipos tipo, String id, boolean flag, int line, int column) {
        super(tipo, line, column);
        this.id = id;
        this.flag = flag;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        Simbolo simbolo;

        if(this.flag){
            ArrayList<Nodo> res = new ArrayList<Nodo>();
            simbolo = new Simbolo(new Tipo(this.tipo), new Tipo(Tipo.Tipos.ALLOCATE), this.id, res, this.line, this.column, table);
        }else{
            ArrayList<ArrayList<Nodo>> res = new ArrayList<ArrayList<Nodo>>();
            simbolo = new Simbolo(new Tipo(this.tipo), new Tipo(Tipo.Tipos.ALLOCATE2), this.id, res, this.line, this.column, table);
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
        NodoAST nodo = new NodoAST("ALLOCATABLE");
        nodo.agregarHijo(new NodoAST(tipo.toString()));
        nodo.agregarHijo(new NodoAST(this.id));
        return nodo;
    }
}
