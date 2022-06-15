package Expresiones;

import Abstract.Nodo;
import Abstract.NodoAST;
import Other.Excepcion;
import Other.Tipo;
import Symbols.Simbolo;
import Symbols.Table;
import Symbols.Tree;

import java.util.ArrayList;

public class Size extends Nodo {
    String id;

    //PARA EL AST
    String resultado;

    public Size(String id, int line, int column) {
        super(null, line, column);
        this.id = id;
        this.resultado = "";
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

        this.tipo = Tipo.Tipos.INTEGER;

        if(variable.tipo2.tipo == Tipo.Tipos.ARREGLO || variable.tipo2.tipo == Tipo.Tipos.ARREGLO2
                || variable.tipo2.tipo == Tipo.Tipos.ALLOCATE || variable.tipo2.tipo == Tipo.Tipos.ALLOCATE2){
            if (variable.valor instanceof ArrayList<?> listaI) {
                if(listaI.size() > 0) {
                    if (listaI.get(0) instanceof ArrayList<?> listaJ) {
                        int ret = listaI.size() * listaJ.size();
                        resultado += String.valueOf(ret);
                        return ret;
                    }
                }
                resultado += String.valueOf(listaI.size());
                return listaI.size();
            }
        }else{
            String err = "La variable {"+this.id+"} no es del tipo Array \n";
            Excepcion error = new Excepcion("Semantico", err,this.line, this.column);
            tree.excepciones.add(error);
            tree.consola.add(error.toString());
            return error;
        }
        return null;
    }

    @Override
    public NodoAST getAST() {
        NodoAST nodo = new NodoAST("Size");
        nodo.agregarHijo(new NodoAST(this.id));
        nodo.agregarHijo(new NodoAST(resultado));
        return nodo;
    }
}
