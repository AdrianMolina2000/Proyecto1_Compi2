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
    NodoAST nodoMain;
    ArrayList<NodoAST> instrEjec = new ArrayList<>();

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
            return error;
        }

        Table newtable = new Table(table);

        //Verifico que venga una condicion
        if(this.condicion == null){
            String err = "Debe enviar una condicion valida \n";
            Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
            tree.excepciones.add(error);
            return error;
        }

        Object cond = this.condicion.execute(newtable, tree);
        if (cond instanceof Excepcion) {
            return cond;
        }

        //Verifico que no sea una lista vacia
        if(this.expresiones.size() == 0){
            String err = "El do while no puede venir sin instrucciones \n";
            Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
            tree.excepciones.add(error);
            return error;
        }

        if(this.condicion.tipo != Tipo.Tipos.LOGICAL ){
            String err = "La codicion debe ser de tipo [LOGICAL], ["+this.condicion.tipo+"] \n";
            Excepcion error = new Excepcion("Semantico", err, line, column);
            tree.excepciones.add(error);
            return error;
        }

        //Creo nodo para el AST
        NodoAST nodoCond = new NodoAST("CONDICION");
        nodoCond.agregarHijo(this.condicion.getAST());

        //Creo una variable para que no se encicle
        int i = 0;

        //While para repetir las instrucciones
        while ((boolean)cond){
            Object res = null;

            //Creo nodo para el AST
            NodoAST nodoIteracion = new NodoAST("ITERACION");

            //For para ejecutar las instrucciones que vienen dentro del Do while
            for(int j = 0; j < this.expresiones.size(); j++){
                res = this.expresiones.get(j).execute(newtable, tree);

                //ERROR
                if(res instanceof Excepcion e){
                    tree.consola.add(e.toString());
                }

                nodoIteracion.agregarHijo(this.expresiones.get(j).getAST());

                //Verifico si viene un EXIT
                if(res instanceof Exit ex){
                    if(ex.id.equalsIgnoreCase(this.id)){
                        //Termino Ejecucion

                        //Creo el nodo para el AST
                        nodoMain = new NodoAST("DO WHILE");
                        nodoMain.agregarHijo(nodoCond);

                        NodoAST nodoIns = new NodoAST("INSTRUCCIONES");
                        nodoIns.agregarHijos(instrEjec);
                        nodoMain.agregarHijo(nodoIns);

                        //Termino la ejecucion
                        return null;
                    }else{
                        //Termino Ejecucion y sigo enviando el Exit

                        //Creo el nodo para el AST
                        nodoMain = new NodoAST("DO WHILE");
                        nodoMain.agregarHijo(nodoCond);

                        NodoAST nodoIns = new NodoAST("INSTRUCCIONES");
                        nodoIns.agregarHijos(instrEjec);
                        nodoMain.agregarHijo(nodoIns);

                        //Termino la ejecucion
                        return res;
                    }
                }

                //Verifico si viene un CYCLE
                else if (res instanceof Cycle cy) {
                    if(cy.id.equalsIgnoreCase(this.id)){
                        //Detengo este for
                        break;
                    }else{
                        //Detengo este for y sigo enviando el Cycle

                        //Creo el nodo para el AST
                        nodoMain = new NodoAST("DO WHILE");
                        nodoMain.agregarHijo(nodoCond);

                        NodoAST nodoIns = new NodoAST("INSTRUCCIONES");
                        nodoIns.agregarHijos(instrEjec);
                        nodoMain.agregarHijo(nodoIns);

                        //Termino la ejecucion
                        return res;
                    }
                }
            }

            if (res instanceof Cycle cy){
                if(cy.id.equalsIgnoreCase(this.id)){
                    //realizo un continue a este while
                    continue;
                }else{
                    //Detengo este while y sigo enviando el cycle

                    //Creo el nodo para el AST
                    nodoMain = new NodoAST("DO WHILE");
                    nodoMain.agregarHijo(nodoCond);

                    NodoAST nodoIns = new NodoAST("INSTRUCCIONES");
                    nodoIns.agregarHijos(instrEjec);
                    nodoMain.agregarHijo(nodoIns);

                    //Termino la ejecucion
                    return res;
                }
            }

            //Creo nodo para el AST
            instrEjec.add(nodoIteracion);

            //Ejecuto la condicion para ver si cumple
            cond = this.condicion.execute(newtable, tree);

            //Creo el nodo para el AST
            NodoAST nuevaCond = new NodoAST("CONDICION");
            nuevaCond.agregarHijo(this.condicion.getAST());
            instrEjec.add(nuevaCond);

            //Aumento i
            i += 1;
            if(i > 400){
                break;
            }
        }

        //Creo el nodo para el AST
        nodoMain = new NodoAST("DO WHILE");
        nodoMain.agregarHijo(nodoCond);

        NodoAST nodoIns = new NodoAST("INSTRUCCIONES");
        nodoIns.agregarHijos(instrEjec);
        nodoMain.agregarHijo(nodoIns);

        //Termino la ejecucion
        return null;
    }

    @Override
    public NodoAST getAST() {
        NodoAST nodo = new NodoAST("DO WHILE");

        if(nodoMain != null){
            return nodoMain;
        }

        return nodo;
    }
}
