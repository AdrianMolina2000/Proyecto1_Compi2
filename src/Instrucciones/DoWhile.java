package Instrucciones;

import Abstract.Nodo;
import Expresiones.Primitivo;
import Other.Excepcion;
import Other.Tipo;
import Symbols.Table;
import Symbols.Tree;

import java.util.ArrayList;

public class DoWhile extends Nodo {
    Nodo condicion;
    ArrayList<Nodo> expresiones;

    public DoWhile(Nodo condicion, ArrayList<Nodo> expresiones, int line, int column) {
        super(null, line, column);
        this.condicion = condicion;
        this.expresiones = expresiones;
    }

    @Override
    public Object execute(Table table, Tree tree) {
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
            for(int j = 0; j<this.expresiones.size(); j++){

                Object res = this.expresiones.get(j).execute(newtable, tree);
//            if (res instanceof Continue) {
//                break;
//            } else if (res instanceof Break || res instanceof Retorno) {
//                return;
//            }

            }
        }
        return null;
    }
}
