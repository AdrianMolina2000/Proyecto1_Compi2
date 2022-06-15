package Instrucciones;

import Abstract.Nodo;
import Abstract.NodoAST;
import Other.Excepcion;
import Other.Tipo;
import Symbols.Table;
import Symbols.Tree;

import java.util.ArrayList;

public class DoWhile extends Nodo {
    Nodo condicion;
    ArrayList<Nodo> expresiones;
    String id;
    String id2;

    //PARA AST
    NodoAST nodoCond = new NodoAST("CONDICION");
    ArrayList<NodoAST> instrEjec;

    public DoWhile(String id, String id2, Nodo condicion, ArrayList<Nodo> expresiones, int line, int column) {
        super(null, line, column);
        this.condicion = condicion;
        this.expresiones = expresiones;
        this.id = id;
        this.id2 = id2;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        if(!this.id.equalsIgnoreCase(id2)){
            String err = "Las etiquetas deben ser nombradas de igual forma  \n";
            Excepcion error = new Excepcion("Semantico", err, line, column);
            tree.excepciones.add(error);
            tree.consola.add(error.toString());
            return error;
        }

        Table newtable = new Table(table);

        Object cond = this.condicion.execute(newtable, tree);
        nodoCond.agregarHijo(this.condicion.getAST());

        if(this.condicion.tipo != Tipo.Tipos.LOGICAL ){
            String err = "La codicion debe ser de tipo Logical, ["+this.condicion.tipo+"] \n";
            Excepcion error = new Excepcion("Semantico", err, line, column);
            tree.excepciones.add(error);
            tree.consola.add(error.toString());
            return error;
        }

        int i = 0;
        while ((boolean)cond || i<1000){
            Object res = null;
            NodoAST nodoIteracion = new NodoAST("ITERACION");

            for(int j = 0; j<this.expresiones.size(); j++){
                res = this.expresiones.get(j).execute(newtable, tree);

                nodoIteracion.agregarHijo(this.expresiones.get(j).getAST());

                if(res instanceof Exit ex){
                    if(ex.id.equalsIgnoreCase(this.id)){
                        return null;
                    }else{
                        return res;
                    }
                }else if (res instanceof Cycle cy) {
                    if(cy.id.equalsIgnoreCase(this.id)){
                        break;
                    }else{
                        return res;
                    }
                }
            }

            if (res instanceof Cycle cy){
                if(cy.id.equalsIgnoreCase(this.id)){
                    continue;
                }else{
                    return res;
                }
            }
            i += 1;
        }
        return null;
    }

    @Override
    public NodoAST getAST() {
        NodoAST nodo = new NodoAST("DO WHILE");
        nodo.agregarHijo(nodoCond);

        NodoAST nodoIns = new NodoAST("INSTRUCCIONES");
        nodoIns.agregarHijos(instrEjec);
        nodo.agregarHijo(nodoIns);

        return nodo;
    }
}
