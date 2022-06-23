package Expresiones;

import Abstract.Nodo;
import Abstract.NodoAST;
import Gramatica.Globales;
import Other.Excepcion;
import Other.Tipo;
import Symbols.C3D;
import Symbols.Simbolo;
import Symbols.Table;
import Symbols.Tree;

import java.util.ArrayList;

public class ArrayPos extends Nodo {
    String id;
    Nodo pos1;
    Nodo pos2;

    Object po1;
    Object po2;

    //PARA EL AST
    NodoAST nodoMain;
    NodoAST nodoId;
    NodoAST nodoPosicion;
    NodoAST nodoValor;

    //Para C3D
    int posicion1;
    int posicion2;

    public ArrayPos(String id, Nodo pos1, Nodo pos2, int line, int column) {
        super(null, line, column);
        this.id = id;
        this.pos1 = pos1;
        this.pos2 = pos2;
    }

    @Override
    public Object execute(Table table, Tree tree) {

        Simbolo variable = table.getVariable(this.id);

        if (variable == null) {
            String err = "La variable {"+this.id+"} no ha sido encontrada \n";
            Excepcion error = new Excepcion("Semantico", err,this.line, this.column);
            tree.excepciones.add(error);
            //tree.consola.add(error.toString());
            return error;
        }

        //Verifico que venga una posicion
        if(this.pos1 == null){
            String err = "Debe enviar una posicion del arreglo para acceder a su contenido \n";
            Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
            tree.excepciones.add(error);
            //tree.consola.add(error.toString());
            return error;
        }

        //Verifico si el arreglo es de una dimension
        if(variable.tipo2.tipo == Tipo.Tipos.ARREGLO || variable.tipo2.tipo == Tipo.Tipos.ALLOCATE) {
            po1 = this.pos1.execute(table, tree);
            if (po1 instanceof Excepcion) {
                return po1;
            }

            //Verifico que la primera posicion sea un INTEGER
            if(this.pos1.tipo != Tipo.Tipos.INTEGER){
                String err = "La posicion ingresada debe ser un INTEGER \n";
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.excepciones.add(error);
                //tree.consola.add(error.toString());
                return error;
            }

            //Verifico que solo venga una posicion
            if(this.pos2 != null){
                String err = "Este arreglo unicamente tiene una dimension \n";
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.excepciones.add(error);
                //tree.consola.add(error.toString());
                return error;
            }

            if(po1 instanceof Integer p1){
                ArrayList<Nodo> listaI = (ArrayList<Nodo>) variable.valor;
                if(p1 <= listaI.size() && p1 > 0) {
                    //Le coloco tipo a esta clase
                    this.tipo = variable.tipo.tipo;

                    //Obtengo el nodo de la posicion buscada
                    Nodo val = listaI.get(p1 - 1);
                    Object result = val.execute(table, tree);

                    //Creo los nodos del AST;
                    nodoMain = new NodoAST("ARRAY");

                    nodoId = new NodoAST("ID");
                    nodoId.agregarHijo(new NodoAST(this.id));

                    nodoPosicion = new NodoAST("Posicion");
                    nodoPosicion.agregarHijo(this.pos1.getAST());

                    nodoId.agregarHijo(nodoPosicion);

                    nodoMain.agregarHijo(nodoId);
                    nodoMain.agregarHijo(val.getAST());

                    //Para C3D
                    if(variable.tipo2.tipo == Tipo.Tipos.ARREGLO){
                        this.isC3D = true;
                        this.posicion1 = p1;
                    }

                    //Retorno el valor
                    return result;
                }

                //ERROR
                else{
                    String err = "El arreglo no puede ser accedido porque la posicion no es la adecuada \n";
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    //tree.consola.add(error.toString());
                    return error;
                }
            }

            //ERROR
            else{
                String err = "El arreglo no puede ser accedido porque la posicion no es INTEGER \n";
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.excepciones.add(error);
                //tree.consola.add(error.toString());
                return error;
            }
        }

        //Verifico si el arreglo es de 2 dimensiones
        else if (variable.tipo2.tipo == Tipo.Tipos.ARREGLO2 || variable.tipo2.tipo == Tipo.Tipos.ALLOCATE2) {
            po1 = this.pos1.execute(table, tree);
            if (po1 instanceof Excepcion) {
                return po1;
            }

            //Verifico que la primera posicion sea un INTEGER
            if(this.pos1.tipo != Tipo.Tipos.INTEGER){
                String err = "La posicion ingresada debe ser un INTEGER \n";
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.excepciones.add(error);
                //tree.consola.add(error.toString());
                return error;
            }

            //Verifico que vengan 2 posiciones
            if(this.pos2 == null){
                String err = "Debe enviar 2 posiciones, para acceder al contenido del arreglo \n";
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.excepciones.add(error);
                //tree.consola.add(error.toString());
                return error;
            }

            po2 = this.pos2.execute(table, tree);
            if (po2 instanceof Excepcion) {
                return po1;
            }

            //Verifico que la segunda posicion sea un INTEGER
            if(this.pos1.tipo != Tipo.Tipos.INTEGER){
                String err = "La posicion ingresada debe ser un INTEGER \n";
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.excepciones.add(error);
                //tree.consola.add(error.toString());
                return error;
            }

            if(po1 instanceof Integer p1) {
                //Obtengo la lista de listas de la variable
                ArrayList<ArrayList<Nodo>> listaI = (ArrayList<ArrayList<Nodo>>) variable.valor;

                if (p1 <= listaI.size() && p1 > 0) {
                    //Obtengo la lista de nodos necesaria
                    ArrayList<Nodo> listaJ = listaI.get(p1 - 1);

                    if(po2 instanceof Integer p2) {
                        if (p2 <= listaJ.size() && p2 > 0) {
                            //Le coloco el tipo a esta clase
                            this.tipo = variable.tipo.tipo;

                            //Obtengo el nodo de la posicion buscada
                            Nodo val = listaJ.get(p2 - 1);
                            Object result = val.execute(table, tree);

                            //Creo los nodos del AST;
                            nodoMain = new NodoAST("ARRAY");

                            nodoId = new NodoAST("ID");
                            nodoId.agregarHijo(new NodoAST(this.id));

                            nodoPosicion = new NodoAST("Posicion");
                            nodoPosicion.agregarHijo(this.pos1.getAST());
                            nodoPosicion.agregarHijo(this.pos2.getAST());

                            nodoId.agregarHijo(nodoPosicion);

                            nodoMain.agregarHijo(nodoId);
                            nodoMain.agregarHijo(val.getAST());

                            //Para C3D
                            if(variable.tipo2.tipo == Tipo.Tipos.ARREGLO2){
                                this.isC3D = true;
                                this.posicion1 = p1;
                                this.posicion2 = p2;
                            }

                            //Retorno el valor
                            return result;
                        }

                        //ERROR
                        else {
                            String err = "El arreglo no puede ser asignado porque la posicion no es la adecuada \n";
                            Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                            tree.excepciones.add(error);
                            //tree.consola.add(error.toString());
                            return error;
                        }
                    }

                    //ERROR
                    else{
                        String err = "El arreglo no puede ser accedido porque la posicion no es INTEGER \n";
                        Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                        tree.excepciones.add(error);
                        //tree.consola.add(error.toString());
                        return error;
                    }

                }

                //ERROR
                else {
                    String err = "El arreglo no puede ser accedido porque la posicion no es la adecuada \n";
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    //tree.consola.add(error.toString());
                    return error;
                }
            }

            //ERROR
            else{
                String err = "El arreglo no puede ser accedido porque la posicion no es INTEGER \n";
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.excepciones.add(error);
                //tree.consola.add(error.toString());
                return error;
            }
        }

        //ERROR
        else{
            String err = "La variable no puede ser accedida porque no es un arreglo \n";
            Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
            tree.excepciones.add(error);
            //tree.consola.add(error.toString());
            return error;
        }
    }

    @Override
    public NodoAST getAST() {
        NodoAST nodo = new NodoAST("ARRAY");

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
            Globales.gen.addComment("Obtener Valor de arreglo");

            if(this.pos2 == null){
                this.pos1.get3D();

                String temp = Globales.gen.addTemp();
                Globales.gen.addExp(temp, this.pos1.valor3D, "-", "1");

                this.valor3D = Globales.gen.addTemp();

                Globales.gen.getPosArray(this.valor3D, this.id, temp);
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

                this.valor3D = Globales.gen.addTemp();

                Globales.gen.getPosArray(this.valor3D, this.id, temp3);
            }

        }
    }
}
