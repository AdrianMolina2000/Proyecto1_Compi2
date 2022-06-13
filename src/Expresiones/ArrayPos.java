package Expresiones;

import Abstract.Nodo;
import Other.Excepcion;
import Other.Tipo;
import Symbols.Simbolo;
import Symbols.Table;
import Symbols.Tree;

import java.util.ArrayList;

public class ArrayPos extends Nodo {
    String id;
    Nodo pos1;
    Nodo pos2;
    Object valor;

    public ArrayPos(String id, Nodo pos1, Nodo pos2, int line, int column) {
        super(null, line, column);
        this.id = id;
        this.pos1 = pos1;
        this.pos2 = pos2;
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

        if(variable.tipo2.tipo == Tipo.Tipos.ARREGLO || variable.tipo2.tipo == Tipo.Tipos.ALLOCATE) {
            Object po1 = this.pos1.execute(table, tree);
            if((int)po1 <= ((ArrayList<?>)variable.valor).size() && (int)po1 > 0) {
                this.tipo = variable.tipo.tipo;
                this.valor = ((ArrayList<Nodo>) variable.valor).get((int)po1 - 1).execute(table, tree);
            }else{
                String err = "El arreglo no puede ser accedido porque la posicion no es la adecuada \n";
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.excepciones.add(error);
                tree.consola.add(error.toString());
                return error;
            }
        }else if (variable.tipo2.tipo == Tipo.Tipos.ARREGLO2 || variable.tipo2.tipo == Tipo.Tipos.ALLOCATE2) {
            Object po1 = this.pos1.execute(table, tree);
            Object po2 = this.pos2.execute(table, tree);
            if((int)po1 <= ((ArrayList<?>)variable.valor).size() && (int)po1 > 0){
                this.tipo = variable.tipo.tipo;
                ArrayList<Nodo> listaJ = ((ArrayList<ArrayList<Nodo>>)variable.valor).get((int)po2-1);
                if((int)po2 <= listaJ.size() && (int)po2 > 0){
                    this.valor = listaJ.get((int)po2-1).execute(table, tree);
                }else{
                    String err = "El arreglo no puede ser asignado porque la posicion no es la adecuada \n";
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    tree.consola.add(error.toString());
                    return error;
                }
            }else{
                String err = "El arreglo no puede ser accedido porque la posicion no es la adecuada \n";
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.excepciones.add(error);
                tree.consola.add(error.toString());
                return error;
            }
        }
        return this.valor;
    }
}
