package Instrucciones;

import Abstract.Nodo;
import Abstract.NodoAST;
import Other.Excepcion;
import Other.Tipo;
import Symbols.Table;
import Symbols.Tree;

import java.util.ArrayList;

public class If extends Nodo {
    Nodo condicion;
    ArrayList<Nodo> listaIf;
    ArrayList<Nodo> listaElse;

    ArrayList<NodoAST> listaIfAST = new ArrayList<>();
    ArrayList<NodoAST> listaElseAST = new ArrayList<>();
    NodoAST nodoCond = new NodoAST("CONDICION");

    public If(Nodo condicion, ArrayList<Nodo> listaIf, ArrayList<Nodo> listaElse, int line, int column) {
        super(null, line, column);
        this.condicion = condicion;
        this.listaIf = listaIf;
        this.listaElse = listaElse;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        Table newtable = new Table(table);

        Object result = this.condicion.execute(newtable, tree);
        nodoCond.agregarHijo(this.condicion.getAST());

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
                listaIfAST.add(this.listaIf.get(i).getAST());
                if (res instanceof Exit || res instanceof Cycle) {
                    return res;
                }
            }
            return true;
        }else {
            for (int i = 0; i < this.listaElse.size(); i++) {
                Object res = this.listaElse.get(i).execute(newtable, tree);
                listaElseAST.add(this.listaElse.get(i).getAST());
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

    @Override
    public NodoAST getAST() {
        NodoAST nodo = new NodoAST("IF");
        nodo.agregarHijo(nodoCond);
        if(listaIfAST.size() != 0){
            NodoAST nodoIf = new NodoAST("INSTRUCCIONES IF");
            nodoIf.agregarHijos(listaIfAST);
            nodo.agregarHijo(nodoIf);
        }else{
            NodoAST nodoElse = new NodoAST("INSTRUCCIONES ELSE");
            nodoElse.agregarHijos(listaElseAST);
            nodo.agregarHijo(nodoElse);
        }
        return nodo;
    }
}
