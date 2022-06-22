package Instrucciones;

import Abstract.Nodo;
import Abstract.NodoAST;
import Gramatica.Globales;
import Other.Excepcion;
import Other.Tipo;
import Symbols.C3D;
import Symbols.Table;
import Symbols.Tree;

import java.util.ArrayList;

public class ElseIf extends Nodo {
    Nodo condicion;
    ArrayList<Nodo> listaIf;

    //PARA EL AST
    NodoAST nodoMain;
    ArrayList<NodoAST> listaIfAST = new ArrayList<>();

    //Para C3D
    Table tableC3D;
    Tree treeC3D;
    String salida;

    public ElseIf(Nodo condicion, ArrayList<Nodo> listaIf, int line, int column) {
        super(null, line, column);
        this.condicion = condicion;
        this.listaIf = listaIf;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        tableC3D = table;
        treeC3D = tree;

        Table newtable = new Table(table);
        table.siguiente = newtable;

        //Verifico que venga una condicion
        if(this.condicion == null){
            String err = "Debe enviar una condicion valida \n";
            Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
            tree.excepciones.add(error);
            return error;
        }

        Object result = this.condicion.execute(newtable, tree);
        if (result instanceof Excepcion) {
            return result;
        }

        //ERROR
        if (this.condicion.tipo != Tipo.Tipos.LOGICAL) {
            Excepcion error = new Excepcion("Semantico", "Se esperaba una expresion BOOLEANA para la condicion \n", this.line, this.column);
            tree.excepciones.add(error);
            tree.consola.add(error.toString());
            return error;
        }


        //Para C3D
        this.isC3D = true;

        if((boolean)result) {
            for(Nodo instrucciones: this.listaIf) {
                Object res = instrucciones.execute(newtable, tree);

                if (res instanceof Excepcion e) {
                    tree.consola.add(e.toString());
                }

                listaIfAST.add(instrucciones.getAST());

                if (res instanceof Exit || res instanceof Cycle) {
                    //Para AST
                    nodoMain = new NodoAST("ELSE IF");
                    NodoAST nodoCondicion = this.condicion.getAST();
                    NodoAST nodoInstrucciones = new NodoAST("INSTRUCCIONES ELSE IF");
                    nodoInstrucciones.agregarHijos(listaIfAST);
                    nodoMain.agregarHijo(nodoCondicion);
                    nodoMain.agregarHijo(nodoInstrucciones);

                    return res;
                }
            }

            //Para AST
            nodoMain = new NodoAST("ELSE IF");
            NodoAST nodoCondicion = this.condicion.getAST();
            NodoAST nodoInstrucciones = new NodoAST("INSTRUCCIONES ELSE IF");
            nodoInstrucciones.agregarHijos(listaIfAST);
            nodoMain.agregarHijo(nodoCondicion);
            nodoMain.agregarHijo(nodoInstrucciones);

            return true;
        }

        //Para AST
        nodoMain = new NodoAST("ELSE IF");
        NodoAST nodoCondicion = this.condicion.getAST();
        nodoMain.agregarHijo(nodoCondicion);
        return null;
    }

    @Override
    public NodoAST getAST() {
        NodoAST nodo = new NodoAST("ELSE IF");

        if(nodoMain != null){
            return nodoMain;
        }

        return nodo;
    }

    @Override
    public void get3D() {
        if(Globales.gen == null){
            C3D genAux = new C3D();
            Globales.gen = genAux.getInstance();
        }

        if(this.isC3D){
            Table newtable = new Table(tableC3D);

            condicion.get3D();

            Globales.gen.addLabel(condicion.ev);

            for(Nodo instruccionesIf: this.listaIf){
                instruccionesIf.execute(newtable, treeC3D);
                instruccionesIf.get3D();
            }

            Globales.gen.addGoto(this.salida);
            Globales.gen.addLabel(condicion.ef);

        }
    }
}
