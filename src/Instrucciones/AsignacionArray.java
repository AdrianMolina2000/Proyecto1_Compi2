package Instrucciones;

import Abstract.Nodo;
import Abstract.NodoAST;
import Expresiones.Primitivo;
import Gramatica.Globales;
import Other.Excepcion;
import Other.Tipo;
import Symbols.C3D;
import Symbols.Simbolo;
import Symbols.Table;
import Symbols.Tree;

import java.util.ArrayList;

public class AsignacionArray extends Nodo {
    String id;
    Nodo valor;
    Nodo pos1;
    Nodo pos2;

    //PARA AST
    NodoAST nodoMain;

    //Para C3D
    int posicion1;
    int posicion2;

    public AsignacionArray(String id, Nodo pos1, Nodo pos2, Nodo valor, int line, int column) {
        super(null, line, column);
        this.id = id;
        this.pos1 = pos1;
        this.pos2 = pos2;
        this.valor = valor;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        //Obtengo la variable a asignar
        Simbolo variable = table.getVariable(this.id);

        //ERROR
        if (variable == null) {
            String err = "La variable {"+this.id+"} no ha sido encontrada \n";
            Excepcion error = new Excepcion("Semantico", err,this.line, this.column);
            tree.excepciones.add(error);
            return error;
        }

        //ERROR
        if(this.pos1 == null){
            String err = "La posicion no es valida \n";
            Excepcion error = new Excepcion("Semantico", err,this.line, this.column);
            tree.excepciones.add(error);
            return error;
        }

        Object po1 = this.pos1.execute(table, tree);
        if (po1 instanceof Excepcion) {
            return po1;
        }

        //ERROR
        if(this.valor == null){
            String err = "La expresion no es valida \n";
            Excepcion error = new Excepcion("Semantico", err,this.line, this.column);
            tree.excepciones.add(error);
            return error;
        }

        Object result = this.valor.execute(table, tree);
        if (result instanceof Excepcion) {
            return result;
        }

        if (this.valor.tipo != variable.tipo.tipo){
            String err = "La variable {"+this.id+"} no puede ser asignada debido a que son de diferentes tipos ["+ variable.tipo.tipo + "] y ["+this.valor.tipo+"] \n";
            Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
            tree.excepciones.add(error);
            return error;
        }

        //Verifico que la variable sea del tipo ARRAY
        if(variable.tipo2.tipo == Tipo.Tipos.ARREGLO || variable.tipo2.tipo == Tipo.Tipos.ALLOCATE){
            if(po1 instanceof Integer p1){

                //ERROR
                if(this.pos2 != null){
                    String err = "La variable es unicamente de una dimension \n";
                    Excepcion error = new Excepcion("Semantico", err,this.line, this.column);
                    tree.excepciones.add(error);
                    return error;
                }

                //Verifico que la variable sea del tipo lista de Nodos
                if(variable.valor instanceof ArrayList<?> listaI){

                    if(p1 <= listaI.size() && p1 > 0){
                        //Creo el nuevo valor a agregar
                        Primitivo prim = new Primitivo(this.valor.tipo, result, this.line, this.column);
                        ((ArrayList<Nodo>) variable.valor).set(p1-1, prim);

                        //Creo el nodo para el AST
                        nodoMain = new NodoAST("ASIGNACION");

                        NodoAST nodoId = new NodoAST("ID");
                        nodoId.agregarHijo(this.id);

                        NodoAST nodoPos = new NodoAST("POSICION");
                        nodoPos.agregarHijo(this.pos1.getAST());
                        nodoId.agregarHijo(nodoPos);

                        nodoMain.agregarHijo(nodoId);
                        nodoMain.agregarHijo(this.valor.getAST());

                        if(variable.tipo2.tipo == Tipo.Tipos.ARREGLO){
                            this.isC3D = true;
                            this.posicion1 = p1;
                        }

                        //Salgo de la ejecucion
                        return null;
                    }

                    //ERROR
                    else{
                        String err = "El arreglo no puede ser asignado porque la posicion no es la adecuada \n";
                        Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                        tree.excepciones.add(error);
                        return error;
                    }
                }

                //ERROR
                else{
                    String err = "La variable no posee un arreglo \n";
                    Excepcion error = new Excepcion("Semantico", err, line, column);
                    tree.excepciones.add(error);
                    return error;
                }

            }

            //ERROR
            else{
                String err = "La posicion deben ser INTEGER \n";
                Excepcion error = new Excepcion("Semantico", err, line, column);
                tree.excepciones.add(error);
                return error;
            }

        }

        //Verifico que la variable sea del tipo ARRAY
        else if(variable.tipo2.tipo == Tipo.Tipos.ARREGLO2 || variable.tipo2.tipo == Tipo.Tipos.ALLOCATE2){
            if(po1 instanceof Integer p1) {

                //ERROR
                if(this.pos2 == null){
                    String err = "La variable requiere 2 posiciones para ser asignada \n";
                    Excepcion error = new Excepcion("Semantico", err,this.line, this.column);
                    tree.excepciones.add(error);
                    return error;
                }

                Object po2 = this.pos2.execute(table, tree);
                if (po2 instanceof Excepcion) {
                    return po2;
                }

                if(po2 instanceof Integer p2) {

                    //Verifico que la variable sea del tipo lista de Nodos
                    if(variable.valor instanceof ArrayList<?> listaI) {

                        //Verifico que el size sea el adecuado
                        if ((p1 <= listaI.size()) && p1 > 0) {

                            if(listaI.get(0) instanceof ArrayList<?> listaJ) {

                                //Obtengo la lista de listas
                                ArrayList<ArrayList<Nodo>> listI = (ArrayList<ArrayList<Nodo>>) variable.valor;
                                ArrayList<Nodo> listJ = listI.get(p1 - 1);


                                if (p2 <= listJ.size() && p2 > 0) {
                                    //Creo el valor a asignar
                                    Primitivo prim = new Primitivo(this.valor.tipo, result, this.line, this.column);
                                    listJ.set(p2 - 1, prim);
                                    ((ArrayList<ArrayList<Nodo>>) variable.valor).set(p1 - 1, listJ);

                                    //Creo el nodo para el AST
                                    nodoMain = new NodoAST("ASIGNACION");

                                    NodoAST nodoId = new NodoAST("ID");
                                    nodoId.agregarHijo(this.id);

                                    NodoAST nodoPos = new NodoAST("POSICION");
                                    nodoPos.agregarHijo(this.pos1.getAST());
                                    nodoPos.agregarHijo(this.pos2.getAST());
                                    nodoId.agregarHijo(nodoPos);

                                    nodoMain.agregarHijo(nodoId);
                                    nodoMain.agregarHijo(this.valor.getAST());

                                    if(variable.tipo2.tipo == Tipo.Tipos.ARREGLO2){
                                        this.isC3D = true;
                                        this.posicion1 = p1;
                                        this.posicion2 = p2;
                                    }

                                    //Salgo de la ejecucion
                                    return null;
                                }

                                //ERROR
                                else {
                                    String err = "El arreglo no puede ser asignado porque la posicion no es la adecuada \n";
                                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                                    tree.excepciones.add(error);
                                    return error;
                                }
                            }

                            //ERROR
                            else{
                                String err = "La variable no posee un arreglo \n";
                                Excepcion error = new Excepcion("Semantico", err, line, column);
                                tree.excepciones.add(error);
                                return error;
                            }
                        }

                        //ERROR
                        else {
                            String err = "El arreglo no puede ser asignado porque la posicion no es la adecuada \n";
                            Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                            tree.excepciones.add(error);
                            return error;
                        }
                    }

                    //ERROR
                    else{
                        String err = "La variable no posee un arreglo \n";
                        Excepcion error = new Excepcion("Semantico", err, line, column);
                        tree.excepciones.add(error);
                        return error;
                    }
                }

                //ERROR
                else{
                    String err = "La posicion deben ser INTEGER \n";
                    Excepcion error = new Excepcion("Semantico", err, line, column);
                    tree.excepciones.add(error);
                    return error;
                }
            }

            //ERROR
            else{
                String err = "La posicion deben ser INTEGER \n";
                Excepcion error = new Excepcion("Semantico", err, line, column);
                tree.excepciones.add(error);
                return error;
            }
        }

        //ERROR
        else{
            String err = "La variable [" +variable.id+ "] no es de un tipo valido para asignar \n";
            Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
            tree.excepciones.add(error);
            return error;
        }
    }

    @Override
    public NodoAST getAST() {
        NodoAST nodo = new NodoAST("ASIGNACION");

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

        if(isC3D){
            Globales.gen.addComment("Asignar Valor arreglo");

            if(this.pos2 == null){
                this.pos1.get3D();
                this.valor.get3D();

                String temp = Globales.gen.addTemp();
                Globales.gen.addExp(temp, this.pos1.valor3D, "-", "1");

                Globales.gen.setPosArray(this.id, temp, this.valor.valor3D);
            }else{
                //Obtengo numero de columnas
                String temp0 = Globales.gen.addTemp();
                Globales.gen.getPosArray(temp0, this.id, "0");

                //Obtengo la posicion i
                this.pos1.get3D();
                String temp1 = Globales.gen.addTemp();
                Globales.gen.addExp(temp1, pos1.valor3D, "-", "1");

                //Multiplico P1 * J
                String temp2 = Globales.gen.addTemp();
                Globales.gen.addExp(temp2, temp0, "*", temp1);

                //Sumo P2 a lo anterior
                this.pos2.get3D();
                String temp3 = Globales.gen.addTemp();
                Globales.gen.addExp(temp3, temp2, "+", pos2.valor3D);

                this.valor.get3D();

                Globales.gen.setPosArray(this.id, temp3, this.valor.valor3D);
            }
        }
    }
}
