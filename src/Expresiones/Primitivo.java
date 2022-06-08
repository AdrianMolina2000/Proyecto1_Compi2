package Expresiones;

import Abstract.Nodo;
import Other.Excepcion;
import Other.Tipo;
import Symbols.Table;
import Symbols.Tree;

import java.util.ArrayList;


public class Primitivo extends Nodo {
    Object valor;

    public Primitivo(Tipo.Tipos tipo, Object valor, int line, int column) {
        super(tipo, line, column);
        this.valor = valor;
    }

    public Object execute(Table table, Tree tree){
        return this.valor;
    }
}
