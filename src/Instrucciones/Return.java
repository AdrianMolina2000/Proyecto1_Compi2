package Instrucciones;

import Abstract.Nodo;
import Abstract.NodoAST;
import Expresiones.Primitivo;
import Other.Excepcion;
import Other.Tipo;
import Symbols.Table;
import Symbols.Tree;

public class Return extends Nodo {
    Nodo expresion;

    //Para el AST
    NodoAST nodoMain;

    public Return(Nodo expresion, int line, int column) {
        super(null, line, column);
        this.expresion = expresion;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        //ERROR
        if(this.expresion == null){
            String err = "La expresion no es valida \n";
            Excepcion error = new Excepcion("Semantico", err,this.line, this.column);
            tree.excepciones.add(error);
            return error;
        }


        Object expr = this.expresion.execute(table, tree);
        if (expr instanceof Excepcion) {
            return expr;
        }

        //Creo el nodo Main AST
        nodoMain = new NodoAST("RETURN");
        nodoMain.agregarHijo(this.expresion.getAST());

        return expr;
    }

    @Override
    public NodoAST getAST() {
        NodoAST nodo = new NodoAST("RETURN");

        if(nodoMain != null){
            return nodoMain;
        }

        return nodo;
    }

    @Override
    public void get3D() {

    }
}
