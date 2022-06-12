package Instrucciones;

import Abstract.Nodo;
import Other.Excepcion;
import Other.Tipo;
import Symbols.Table;
import Symbols.Tree;

import java.util.ArrayList;

public class DoWhile extends Nodo {
    Nodo condicion;
    ArrayList<Nodo> expresiones;
    String id;
    String id2;

    public DoWhile(String id, String id2, Nodo condicion, ArrayList<Nodo> expresiones, int line, int column) {
        super(null, line, column);
        this.condicion = condicion;
        this.expresiones = expresiones;
        this.id = id;
        this.id2 = id2;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        if(!this.id.equalsIgnoreCase(id2)){
            String err = "Las etiquetas deben ser nombradas de igual forma  \n";
            Excepcion error = new Excepcion("Semantico", err, line, column);
            tree.excepciones.add(error);
            tree.consola.add(error.toString());
            return error;
        }

        Table newtable = new Table(table);

        Object cond = this.condicion.execute(newtable, tree);

        if(this.condicion.tipo != Tipo.Tipos.LOGICAL ){
            String err = "La codicion debe ser de tipo Logical, ["+this.condicion.tipo+"] \n";
            Excepcion error = new Excepcion("Semantico", err, line, column);
            tree.excepciones.add(error);
            tree.consola.add(error.toString());
            return error;
        }

        while ((boolean)this.condicion.execute(newtable, tree)){
            Object res = null;
            for(int j = 0; j<this.expresiones.size(); j++){
                res = this.expresiones.get(j).execute(newtable, tree);
                if(res instanceof Exit ex){
                    if(ex.id.equalsIgnoreCase(this.id)){
                        return null;
                    }else{
                        return res;
                    }
                } else if (res instanceof Cycle cy) {
                    if(cy.id.equalsIgnoreCase(this.id)){
                        break;
                    }else{
                        return res;
                    }
                }
            }
            if (res instanceof Cycle cy){
                if(cy.id.equalsIgnoreCase(this.id)){
                    continue;
                }else{
                    return res;
                }
            }
        }
        return null;
    }
}
