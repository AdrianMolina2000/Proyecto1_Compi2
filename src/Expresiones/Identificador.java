package Expresiones;

import Abstract.Nodo;
import Other.Excepcion;
import Other.Tipo;
import Symbols.Simbolo;
import Symbols.Table;
import Symbols.Tree;

public class Identificador extends Nodo {
    String id;
    Object valor;

    public Identificador(String id, int line, int column) {
        super(null, line, column);
        this.id = id;
    }
    @Override
    public Object execute(Table table, Tree tree) {
        Simbolo variable;
        variable = table.getVariable(this.id);
        if (variable == null) {
            String err = "La variable {"+this.id+"} no ha sido encontrada \n";
            Excepcion error = new Excepcion("Semantico", err,this.line, this.column);
            tree.excepciones.add(error);
            tree.consola.add(error.toString());
            return error;
        }

        this.tipo = variable.tipo.tipo;

        if (variable.valor instanceof Identificador) {
            variable.valor = ((Identificador)variable.valor).execute(table, tree);
        }

        this.valor = variable.valor;

        return this.valor;
    }
}
