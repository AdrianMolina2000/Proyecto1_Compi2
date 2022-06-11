package Instrucciones;

import Abstract.Nodo;
import Other.Excepcion;
import Other.Tipo;
import Symbols.Simbolo;
import Symbols.Table;
import Symbols.Tree;

import java.util.ArrayList;

public class AsignacionArray extends Nodo {
    String id;
    Nodo valor;
    Object resultado;
    int pos1;
    int pos2;


    public AsignacionArray(String id, int pos1, int pos2, Nodo valor, int line, int column) {
        super(null, line, column);
        this.id = id;
        this.pos1 = pos1;
        this.pos2 = pos2;
        this.valor = valor;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        Object result = this.valor.execute(table, tree);
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

        if (valor.tipo != variable.tipo.tipo){
            String err = "La variable {"+this.id+"} no puede ser asignada debido a que son de diferentes tipos ["+ variable.tipo.tipo + "] y ["+this.valor.tipo+"] \n";
            Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
            tree.excepciones.add(error);
            tree.consola.add(error.toString());
            return error;
        }

        if(variable.tipo2.tipo == Tipo.Tipos.ARREGLO || variable.tipo2.tipo == Tipo.Tipos.ALLOCATE){
            if((this.pos1 <= ((ArrayList<?>)variable.valor).size()) && (this.pos1 > 0)){
                ((ArrayList<Nodo>) variable.valor).set(this.pos1-1,this.valor);
                result = this.valor;
            }else{
                String err = "El arreglo no puede ser asignado porque la posicion no es la adecuada \n";
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.excepciones.add(error);
                tree.consola.add(error.toString());
                return error;
            }
        }else{
            if((this.pos1 <= ((ArrayList<?>)variable.valor).size()) && (this.pos1 > 0)){
                ArrayList<ArrayList<Nodo>> listI = (ArrayList<ArrayList<Nodo>>)variable.valor;
                ArrayList<Nodo> listJ = listI.get(this.pos1-1);
                if(this.pos2 <= listJ.size() && (this.pos2 > 0)) {
                    listJ.set(this.pos2 - 1, this.valor);
                    ((ArrayList<ArrayList<Nodo>>) variable.valor).set(this.pos1 - 1, listJ);
                    result = this.valor;
                }else{
                    String err = "El arreglo no puede ser asignado porque la posicion no es la adecuada \n";
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    tree.consola.add(error.toString());
                    return error;
                }
            }else{
                String err = "El arreglo no puede ser asignado porque la posicion no es la adecuada \n";
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.excepciones.add(error);
                tree.consola.add(error.toString());
                return error;
            }
        }

        this.resultado = result;
        return null;
    }
}
