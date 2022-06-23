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

public class If extends Nodo {
    Nodo condicion;
    ArrayList<Nodo> listaIf;
    ArrayList<Nodo> listaElseIf;
    ArrayList<Nodo> listaElse;

    //PARA EL AST
    NodoAST nodoMain;
    ArrayList<NodoAST> listaIfAST = new ArrayList<>();
    ArrayList<NodoAST> listaElseIfAST = new ArrayList<>();
    ArrayList<NodoAST> listaElseAST = new ArrayList<>();

    //Para C3D
    Table tableC3D;
    Tree treeC3D;

    public If(Nodo condicion, ArrayList<Nodo> listaIf, ArrayList<Nodo> listaElseIf, ArrayList<Nodo> listaElse, int line, int column) {
        super(null, line, column);
        this.condicion = condicion;
        this.listaIf = listaIf;
        this.listaElseIf = listaElseIf;
        this.listaElse = listaElse;
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
                    nodoMain = new NodoAST("IF");
                    NodoAST nodoCondicion = this.condicion.getAST();
                    NodoAST nodoInstrucciones = new NodoAST("INSTRUCCIONES");
                    nodoInstrucciones.agregarHijos(listaIfAST);
                    nodoMain.agregarHijo(nodoCondicion);
                    nodoMain.agregarHijo(nodoInstrucciones);

                    return res;
                }
            }

            //Para AST
            nodoMain = new NodoAST("IF");
            NodoAST nodoCondicion = this.condicion.getAST();
            NodoAST nodoInstrucciones = new NodoAST("INSTRUCCIONES IF");
            nodoInstrucciones.agregarHijos(listaIfAST);
            nodoMain.agregarHijo(nodoCondicion);
            nodoMain.agregarHijo(nodoInstrucciones);

            return null;
        }else {
            if(this.listaElseIf.size() != 0) {
                for(Nodo instrucciones: this.listaElseIf){

                    Object res = instrucciones.execute(table, tree);

                    if (res instanceof Excepcion e) {
                        tree.consola.add(e.toString());
                    }

                    listaElseIfAST.add(instrucciones.getAST());

                    if(res instanceof Boolean){
                        //Para AST
                        nodoMain = new NodoAST("IF");
                        NodoAST nodoCondicion = this.condicion.getAST();
                        NodoAST nodoInstrucciones = new NodoAST("LISTA ELSE IF");
                        nodoInstrucciones.agregarHijos(listaElseIfAST);
                        nodoMain.agregarHijo(nodoCondicion);
                        nodoMain.agregarHijo(nodoInstrucciones);

                        return null;
                    }

                    if (res instanceof Exit || res instanceof Cycle) {
                        //Para AST
                        nodoMain = new NodoAST("IF");
                        NodoAST nodoCondicion = this.condicion.getAST();
                        NodoAST nodoInstrucciones = new NodoAST("LISTA ELSE IF");
                        nodoInstrucciones.agregarHijos(listaElseIfAST);
                        nodoMain.agregarHijo(nodoCondicion);
                        nodoMain.agregarHijo(nodoInstrucciones);

                        return res;
                    }
                }

                //Para AST
                nodoMain = new NodoAST("IF");
                NodoAST nodoCondicion = this.condicion.getAST();
                NodoAST nodoInstrucciones = new NodoAST("LISTA ELSE IF");
                nodoInstrucciones.agregarHijos(listaElseIfAST);
                nodoMain.agregarHijo(nodoCondicion);
                nodoMain.agregarHijo(nodoInstrucciones);
            }

            if(this.listaElse.size() != 0){
                for (Nodo instrucciones: this.listaElse) {
                    Object res = instrucciones.execute(newtable, tree);

                    if (res instanceof Excepcion e) {
                        tree.consola.add(e.toString());
                    }

                    listaElseAST.add(instrucciones.getAST());

                    if (res instanceof Exit || res instanceof Cycle) {
                        //Para AST
                        nodoMain = new NodoAST("IF");
                        NodoAST nodoCondicion = this.condicion.getAST();
                        NodoAST nodoInstrucciones = new NodoAST("INSTRUCCIONES ELSE");
                        nodoInstrucciones.agregarHijos(listaElseAST);
                        nodoMain.agregarHijo(nodoCondicion);
                        nodoMain.agregarHijo(nodoInstrucciones);

                        return res;
                    }
                }

                //Para AST
                nodoMain = new NodoAST("IF");
                NodoAST nodoCondicion = this.condicion.getAST();
                NodoAST nodoInstrucciones = new NodoAST("INSTRUCCIONES ELSE");
                nodoInstrucciones.agregarHijos(listaElseAST);
                nodoMain.agregarHijo(nodoCondicion);
                nodoMain.agregarHijo(nodoInstrucciones);
            }

            return null;
        }
    }

    @Override
    public NodoAST getAST() {
        NodoAST nodo = new NodoAST("IF");

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

            Globales.gen.addComment("SENTENCIA IF");

            this.condicion.ef = Globales.gen.newLabel();;
            this.condicion.get3D();

            String salida = Globales.gen.newLabel();

            Globales.gen.addLabel(this.condicion.ev);

            for(Nodo instruccionesIf: this.listaIf){
                instruccionesIf.execute(newtable, treeC3D);

                if(instruccionesIf instanceof Exit){
                    instruccionesIf.ev = this.ev;
                }else if(instruccionesIf instanceof Cycle){
                    instruccionesIf.ev = this.ef;
                }else if(instruccionesIf instanceof If || instruccionesIf instanceof ElseIf){
                    instruccionesIf.ev = this.ev;
                    instruccionesIf.ef = this.ef;
                }

                instruccionesIf.get3D();
            }

            Globales.gen.addGoto(salida);

            Globales.gen.addLabel(this.condicion.ef);

            for(Nodo instruccionesElseIf: this.listaElseIf){
                instruccionesElseIf.execute(tableC3D, treeC3D);
                ((ElseIf)instruccionesElseIf).condicion.ef = Globales.gen.newLabel();
                ((ElseIf)instruccionesElseIf).salida = salida;

                if(instruccionesElseIf instanceof Exit){
                    instruccionesElseIf.ev = this.ev;
                }else if(instruccionesElseIf instanceof Cycle){
                    instruccionesElseIf.ev = this.ef;
                }else if(instruccionesElseIf instanceof If || instruccionesElseIf instanceof ElseIf){
                    instruccionesElseIf.ev = this.ev;
                    instruccionesElseIf.ef = this.ef;
                }

                instruccionesElseIf.get3D();
            }

            for(Nodo instruccionesElse: this.listaElse){
                instruccionesElse.execute(newtable, treeC3D);

                if(instruccionesElse instanceof Exit){
                    instruccionesElse.ev = this.ev;
                }else if(instruccionesElse instanceof Cycle){
                    instruccionesElse.ev = this.ef;
                }else if(instruccionesElse instanceof If || instruccionesElse instanceof ElseIf){
                    instruccionesElse.ev = this.ev;
                    instruccionesElse.ef = this.ef;
                }

                instruccionesElse.get3D();
            }
            Globales.gen.addLabel(salida);
        }
    }
}
