package Instrucciones;

import Abstract.Nodo;
import Other.Excepcion;
import Other.Tipo;
import Symbols.Table;
import Symbols.Tree;

import java.util.ArrayList;

public class If extends Nodo {
    Nodo condicion;
    ArrayList<Nodo> listaIf;
    ArrayList<Nodo> listaElse;

    public If(Nodo condicion, ArrayList<Nodo> listaIf, ArrayList<Nodo> listaElse, int line, int column) {
        super(null, line, column);
        this.condicion = condicion;
        this.listaIf = listaIf;
        this.listaElse = listaElse;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        int cont1=0;
        int cont2=0;

        Table newtable = new Table(table);
        Object result = this.condicion.execute(newtable, tree);

        if (result instanceof Excepcion) {
            return result;
        }

        if (this.condicion.tipo != Tipo.Tipos.LOGICAL) {
            Excepcion error = new Excepcion("Semantico", "Se esperaba una expresion BOOLEANA para la condicion \n", this.line, this.column);
            tree.excepciones.add(error);
            tree.consola.add(error.toString());
            return error;
        }

        if((boolean)result) {
            for(int i = 0; i<this.listaIf.size(); i++) {
                Object res = this.listaIf.get(i).execute(newtable, tree);
                if (res instanceof Exit || res instanceof Cycle) {
                    return res;
                }
            }
            return true;
        }else {
            for (int i = 0; i < this.listaElse.size(); i++) {
                Object res = this.listaElse.get(i).execute(newtable, tree);

                if (res instanceof Exit || res instanceof Cycle) {
                    return res;
                }

                if(res != null){
                    if((boolean)res){
                        return false;
                    }
                }
            }
            return false;
        }
    }
}
