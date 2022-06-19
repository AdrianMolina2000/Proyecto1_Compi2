package Symbols;

import java.util.HashMap;
import java.util.Map;

public class Table {
    Table anterior;
    public Map<String, Simbolo> Variables;
    public int size;

    public Table(Table anterior) {
        this.anterior = anterior;
        Variables = new HashMap<>();
        size = 0;
    }

    public void setVariable(Simbolo simbol){
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
}
