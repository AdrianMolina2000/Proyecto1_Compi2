package Instrucciones;

import Abstract.Nodo;
import Abstract.NodoAST;
import Expresiones.Primitivo;
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
    Nodo pos1;
    Nodo pos2;
    Object po1;
    Object po2;

    //PARA AST
    String rest;

    public AsignacionArray(String id, Nodo pos1, Nodo pos2, Nodo valor, int line, int column) {
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

        po1 = (int)this.pos1.execute(table, tree);
        po2 = 0;

        if(this.pos2 != null){
            po2 = this.pos2.execute(table, tree);
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
            if(((int)po1 <= ((ArrayList<?>)variable.valor).size()) && ((int)po1 > 0)){
                Primitivo prim = new Primitivo(this.valor.tipo, this.valor.execute(table, tree), this.valor.line, this.valor.column);
                ((ArrayList<Nodo>) variable.valor).set((int)po1-1, prim);
                result = this.valor;

                rest = String.valueOf(this.valor.execute(table, tree));
            }else{
                String err = "El arreglo no puede ser asignado porque la posicion no es la adecuada \n";
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.excepciones.add(error);
                tree.consola.add(error.toString());
                return error;
            }
        }else{
            if(((int)po1 <= ((ArrayList<?>)variable.valor).size()) && ((int)po1 > 0)){
                ArrayList<ArrayList<Nodo>> listI = (ArrayList<ArrayList<Nodo>>)variable.valor;
                ArrayList<Nodo> listJ = listI.get((int)po1-1);
                if((int)po2 <= listJ.size() && ((int)po2 > 0)) {
                    Primitivo prim = new Primitivo(this.valor.tipo, this.valor.execute(table, tree), this.valor.line, this.valor.column);
                    listJ.set((int)po2 - 1, prim);
                    ((ArrayList<ArrayList<Nodo>>) variable.valor).set((int)po1 - 1, listJ);
                    result = this.valor;

                    rest = String.valueOf(this.valor.execute(table, tree));
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

    @Override
    public NodoAST getAST() {
        NodoAST nodo = new NodoAST("ASIGNACION");
        NodoAST dimen = new NodoAST("ID");
        dimen.agregarHijo(this.id);
        NodoAST posi = new NodoAST("POSICION");
        if(this.pos2 == null){
            posi.agregarHijo(new NodoAST(String.valueOf(po1)));
        }else{
            posi.agregarHijo(new NodoAST(String.valueOf(po1)));
            posi.agregarHijo(new NodoAST(String.valueOf(po2)));
        }
        dimen.agregarHijo(posi);
        nodo.agregarHijo(dimen);
        nodo.agregarHijo(new NodoAST(rest));
        return nodo;
    }
}
