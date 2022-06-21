package Symbols;

import java.util.HashMap;
import java.util.Map;

public class Table {
    public Table anterior;
    public Map<String, Simbolo> Variables;
    public int size = 0;

    public Table(Table anterior) {
        this.anterior = anterior;
        Variables = new HashMap<>();
        if(anterior == null){
            size = 0;
        }else{
            size += anterior.size;
        }
    }

    public void setVariable(Simbolo simbol){
        if(this.anterior == null){
            simbol.isGlobal = true;
        }
        this.Variables.put(simbol.id, simbol);
        size++;
    }

    public Simbolo getVariable(String id){
        Table ambito = this;
        while (ambito != null){

            for (Map.Entry<String, Simbolo> entry : ambito.Variables.entrySet()) {
                if(entry.getKey().equalsIgnoreCase(id)){
                    return ambito.Variables.get(id);
                }
            }
            ambito = ambito.anterior;
        }
        return null;
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
}
