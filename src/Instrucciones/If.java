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

    //PARA EL AST
    NodoAST nodoMain;
    ArrayList<NodoAST> listaIfAST = new ArrayList<>();
    ArrayList<NodoAST> listaElseAST = new ArrayList<>();


    public If(Nodo condicion, ArrayList<Nodo> listaIf, ArrayList<Nodo> listaElse, int line, int column) {
        super(null, line, column);
        this.condicion = condicion;
        this.listaIf = listaIf;
        this.listaElse = listaElse;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        Table newtable = new Table(table);

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

        //Verifico si la condicion de entrada es verdadera
        if((boolean)result) {

            //Ejecuto las instrucciones por si la condicion es verdadera
            for(int i = 0; i<this.listaIf.size(); i++) {
                Object res = this.listaIf.get(i).execute(newtable, tree);

                if (res instanceof Excepcion e) {
                    tree.consola.add(e.toString());
                }

                //Agrego los AST a una lista
                listaIfAST.add(this.listaIf.get(i).getAST());

                //Verifico si vienen instrucciones de control
                if (res instanceof Exit || res instanceof Cycle) {
                    //Creo el nodoMain para el AST
                    nodoMain = new NodoAST("IF");

                    NodoAST nodoCond = new NodoAST("CONDICION");
                    nodoCond.agregarHijo(this.condicion.getAST());
                    nodoMain.agregarHijo(nodoCond);

                    NodoAST nodoIf = new NodoAST("INSTRUCCIONES IF");
                    if(this.listaIf.size() != 0){
                        nodoIf.agregarHijos(listaIfAST);
                    }

                    nodoMain.agregarHijo(nodoIf);

                    //Detengo la ejecucion
                    return res;
                }
            }

            //Creo el nodoMain para el AST
            nodoMain = new NodoAST("IF");

            NodoAST nodoCond = new NodoAST("CONDICION");
            nodoCond.agregarHijo(this.condicion.getAST());
            nodoMain.agregarHijo(nodoCond);

            NodoAST nodoIf = new NodoAST("INSTRUCCIONES IF");
            if(this.listaIf.size() != 0){
                nodoIf.agregarHijos(listaIfAST);
            }

            nodoMain.agregarHijo(nodoIf);

            //Detengo la ejecucion
            return true;
        }

        //Verifico si la condicion de entrada es falsa
        else {

            //Ejecuto las instrucciones por si la condicion es falsa
            for (int i = 0; i < this.listaElse.size(); i++) {
                Object res = this.listaElse.get(i).execute(newtable, tree);

                if (res instanceof Excepcion e) {
                    tree.consola.add(e.toString());
                }else{
                    //Agrego los AST a una lista
                    listaElseAST.add(this.listaElse.get(i).getAST());

                    //Verifico si vienen instrucciones de control
                    if (res instanceof Exit || res instanceof Cycle) {
                        //Creo el nodoMain para el AST
                        nodoMain = new NodoAST("IF");

                        NodoAST nodoCond = new NodoAST("CONDICION");
                        nodoCond.agregarHijo(this.condicion.getAST());
                        nodoMain.agregarHijo(nodoCond);

                        NodoAST nodoElse = new NodoAST("INSTRUCCIONES ELSE");
                        if(this.listaIf.size() != 0){
                            nodoElse.agregarHijos(listaElseAST);
                        }

                        nodoMain.agregarHijo(nodoElse);

                        //Detengo la ejecucion
                        return res;
                    }

                    //Es una condicion para validar si es un Else If
                    if(res != null){
                        if((boolean)res){
                            //Creo el nodoMain para el AST
                            nodoMain = new NodoAST("ELSE IF");

                            NodoAST nodoCond = new NodoAST("CONDICION");
                            nodoCond.agregarHijo(this.condicion.getAST());
                            nodoMain.agregarHijo(nodoCond);

                            NodoAST nodoElse = new NodoAST("INSTRUCCIONES ELSE IF");
                            if(this.listaIf.size() != 0){
                                nodoElse.agregarHijos(listaElseAST);
                            }

                            nodoMain.agregarHijo(nodoElse);

                            //Detengo la ejecucion
                            return false;
                        }
                    }
                }
            }

            //Creo el nodoMain para el AST
            nodoMain = new NodoAST("IF");

            NodoAST nodoCond = new NodoAST("CONDICION");
            nodoCond.agregarHijo(this.condicion.getAST());
            nodoMain.agregarHijo(nodoCond);

            NodoAST nodoElse = new NodoAST("INSTRUCCIONES ELSE");
            if(this.listaIf.size() != 0){
                nodoElse.agregarHijos(listaElseAST);
            }

            nodoMain.agregarHijo(nodoElse);

            //Detengo la ejecucion
            return false;
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
}
