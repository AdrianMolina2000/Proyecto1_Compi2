package Expresiones;

import Abstract.Nodo;
import Abstract.NodoAST;
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

    //PARA EL AST
    Object po1;
    Object po2;
    NodoAST nodoVal = new NodoAST("VALOR");
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
            this.po1 = this.pos1.execute(table, tree);
            if((int)po1 <= ((ArrayList<?>)variable.valor).size() && (int)po1 > 0) {
                this.tipo = variable.tipo.tipo;
                Nodo val = ((ArrayList<Nodo>) variable.valor).get((int)po1 - 1);
                this.valor = val.execute(table, tree);
                nodoVal.agregarHijo(val.getAST());
            }else{
                String err = "El arreglo no puede ser accedido porque la posicion no es la adecuada \n";
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.excepciones.add(error);
                tree.consola.add(error.toString());
                return error;
            }
        }else if (variable.tipo2.tipo == Tipo.Tipos.ARREGLO2 || variable.tipo2.tipo == Tipo.Tipos.ALLOCATE2) {
            po1 = this.pos1.execute(table, tree);
            po2 = this.pos2.execute(table, tree);
            if((int)po1 <= ((ArrayList<?>)variable.valor).size() && (int)po1 > 0){
                this.tipo = variable.tipo.tipo;
                ArrayList<Nodo> listaJ = ((ArrayList<ArrayList<Nodo>>)variable.valor).get((int)po2-1);
                if((int)po2 <= listaJ.size() && (int)po2 > 0){
                    this.valor = listaJ.get((int)po2-1).execute(table, tree);
                    nodoVal.agregarHijo(listaJ.get((int)po2-1).getAST());
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

    @Override
    public NodoAST getAST() {
        NodoAST nodo = new NodoAST(this.id);
        NodoAST nodoPos = new NodoAST("Posicion");

        if(this.pos2 == null){
            nodoPos.agregarHijo(String.valueOf(this.po1));
        }else{
            nodoPos.agregarHijo(String.valueOf(this.po1));
            nodoPos.agregarHijo(String.valueOf(this.po2));
        }
        nodo.agregarHijo(nodoPos);

        nodo.agregarHijo(nodoVal);
        return nodo;
    }
}
