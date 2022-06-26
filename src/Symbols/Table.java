package Symbols;

import Gramatica.Globales;
import Other.Excepcion;

import java.util.HashMap;
import java.util.Map;

public class Table {
    public Table anterior;
    public Table siguiente;
    public Map<String, Simbolo> Variables;
    public int size = 0;

    public Table(Table anterior) {
        this.anterior = anterior;
        Variables = new HashMap<>();
    }

    public void setVariable(Simbolo simbol){
        simbol.pos = this.getTotalSize();
        if(this.anterior == null){
            simbol.isGlobal = true;
            simbol.pos = size;
        }

        if(simbol.inFunc){
            simbol.pos = size;
        }

        this.Variables.put(simbol.id.toLowerCase(), simbol);
        size++;
    }

    public Simbolo getVariable(String id){
        Table ambito = this;
        while (ambito != null){
            for (Map.Entry<String, Simbolo> entry : ambito.Variables.entrySet()) {
                if(entry.getKey().equalsIgnoreCase(id.toLowerCase())){
                    return ambito.Variables.get(id.toLowerCase());
                }
            }
            ambito = ambito.anterior;
        }
        return null;
    }

    public Simbolo getVariable2(String id){
        if(Variables.containsKey(id.toLowerCase())){
            return Variables.get(id.toLowerCase());
        }else{
            return null;
        }
    }

    public int getTotalSize(){
        int sum = 0;
        Table ambito = this;
        while (ambito != null){
            sum += ambito.size;
            ambito = ambito.anterior;
        }
        return sum;
    }

    public int getPrevSizes(){
        int sum = 0;
        Table ambito = this.anterior;
        while (ambito != null){
            sum += ambito.size;
            ambito = ambito.anterior;
        }
        return sum;
    }
}
