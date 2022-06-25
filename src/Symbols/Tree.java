package Symbols;

import Abstract.Nodo;
import Other.Excepcion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tree {

    public ArrayList<Nodo> instrucciones;
    public ArrayList<Excepcion> excepciones;
    public ArrayList<String> consola;
    public ArrayList<Simbolo> Variables;
    public Map<String, Simbolo> funciones;
    public Map<String, Simbolo> metodos;


    public Tree() {
        instrucciones = new ArrayList<Nodo>();
        excepciones = new ArrayList<Excepcion>();
        consola = new ArrayList<String>();
        Variables = new ArrayList<Simbolo>();
        funciones = new HashMap<>();
        metodos = new HashMap<>();
    }

    public void setFuncion(Simbolo simbol){
        this.funciones.put(simbol.id.toLowerCase(), simbol);
    }

    public Simbolo getFuncion(String id){
        for (Map.Entry<String, Simbolo> entry : funciones.entrySet()) {
            if(entry.getKey().equalsIgnoreCase(id.toLowerCase())){
                return funciones.get(id.toLowerCase());
            }
        }
        return null;
    }

    public void setMetodo(Simbolo simbol){
        this.metodos.put(simbol.id.toLowerCase(), simbol);
    }

    public Simbolo getMetodo(String id){
        for (Map.Entry<String, Simbolo> entry : metodos.entrySet()) {
            if(entry.getKey().equalsIgnoreCase(id.toLowerCase())){
                return metodos.get(id.toLowerCase());
            }
        }
        return null;
    }

}
