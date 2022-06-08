package Symbols;

import java.util.HashMap;
import java.util.Map;

public class Table {
    Table anterior;
    Map<String, Simbolo> Variables;

    public Table(Table anterior) {
        this.anterior = anterior;
    }

    public void setVariable(Simbolo simbol){
        Table ambito = this;
        ambito.Variables.put(simbol.id, simbol);
    }

    public Simbolo getVariable(String id){
        Table ambito = this;
        while (ambito != null){

            for (Map.Entry<String, Simbolo> entry : ambito.Variables.entrySet()) {
                if(entry.getKey() == id){
                    return ambito.Variables.get(id);
                }
            }
            ambito = ambito.anterior;
        }
        return null;
    }
}
