package Instrucciones;

import Abstract.Nodo;
import Other.Excepcion;
import Other.Tipo;
import Symbols.Simbolo;
import Symbols.Table;
import Symbols.Tree;

public class Asignacion extends Nodo {
    String id;
    Nodo valor;
    Object resultado;

    public Asignacion(String id, Nodo valor, int line, int column) {
        super(null, line, column);
        this.id = id;
        this.valor = valor;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        Object result = this.valor.execute(table, tree);
        boolean bandera = true;
        if (result instanceof Excepcion) {
            return result;
        }

        Simbolo variable;
        variable = table.getVariable(this.id);

        if (variable == null) {
            String err = "La variable {"+this.id+"} no ha sido encontrada \n";
            Excepcion error = new Excepcion("Semantico", err,this.line, this.column);
            tree.excepciones.add(error);
            tree.consola.add(error.toString());
            return error;
        }

        if (this.valor.tipo != variable.tipo.tipo){
            String err = "La variable {"+this.id+"} no puede ser asignada debido a que son de diferentes tipos ["+ variable.tipo.tipo + "] y ["+valor.tipo+"] \n";
            Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
            tree.excepciones.add(error);
            tree.consola.add(error.toString());
            return error;
        }


        Object val = result;
        this.resultado = val;
        variable.valor = val;
        return null;
    }
}
