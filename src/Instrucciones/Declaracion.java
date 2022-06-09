package Instrucciones;

import Abstract.Nodo;
import Expresiones.Primitivo;
import Other.Excepcion;
import Other.Tipo;
import Symbols.Simbolo;
import Symbols.Table;
import Symbols.Tree;



public class Declaracion extends Nodo {
    String id;
    public Nodo valor;
    public Declaracion(Tipo.Tipos tipo, String id, Nodo valor, int line, int column) {
        super(tipo, line, column);
        this.id = id;
        this.valor = valor;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        Object result = this.valor.execute(table, tree);

        if (result instanceof Excepcion) {
            return result;
        }

        if (this.valor.tipo != this.tipo) {
            String err = "La variable {" +this.id+ "} no puede ser declarada debido a que son de diferentes tipos [" +this.tipo+"] y [" +valor.tipo + "] \n";
            Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
            tree.excepciones.add(error);
            tree.consola.add(error.toString());
            return error;
        }

        Simbolo simbolo;


        simbolo = new Simbolo(new Tipo(this.tipo), new Tipo(Tipo.Tipos.VARIABLE), this.id, result, this.line, this.column, table);
        if(table.getVariable(this.id) == null){
            table.setVariable(simbolo);
        }else{
            String err = "La variable {" + this.id + "} ya ha sido declarada \n";
            Excepcion error = new Excepcion("Semantico", err, line, column);
            tree.excepciones.add(error);
            tree.consola.add(error.toString());
        }


        return null;
    }
}
