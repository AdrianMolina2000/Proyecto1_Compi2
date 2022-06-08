package Symbols;

import Abstract.Nodo;
import Other.Excepcion;
import java.util.ArrayList;

public class Tree {

    public ArrayList<Nodo> instrucciones;
    public ArrayList<Excepcion> excepciones;
    public ArrayList<String> consola;
    public ArrayList<Simbolo> Variables;


    public Tree() {
        instrucciones = new ArrayList<Nodo>();
        excepciones = new ArrayList<Excepcion>();
        consola = new ArrayList<String>();
        Variables = new ArrayList<Simbolo>();


    }

}
