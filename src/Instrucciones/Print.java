package Instrucciones;

import Abstract.Nodo;
import Abstract.NodoAST;
import Expresiones.Identificador;
import Expresiones.Primitivo;
import Gramatica.Globales;
import Other.Excepcion;
import Other.Tipo;
import Symbols.C3D;
import Symbols.Simbolo;
import Symbols.Table;
import Symbols.Tree;

import java.util.ArrayList;

public class Print extends Nodo {
    ArrayList<Nodo> expresion;

    //Para AST
    ArrayList<NodoAST> nodoIns = new ArrayList<>();

    //Para C3D
    Table tablaC3D;

    public Print(ArrayList<Nodo> expresion, int line, int column) {
        super(null, line, column);
        this.expresion = expresion;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        tablaC3D = table;
        for(int i = 0; i<this.expresion.size(); i++){
            if(this.expresion.get(i) instanceof Identificador iden){
                //Obtengo la variable de la tabla de simbolos
                Simbolo ide = table.getVariable(iden.id);

                //ERROR
                if(ide == null){
                    String err = "La variable {"+iden.id+"} no ha sido encontrada \n";
                    Excepcion error = new Excepcion("Semantico", err,this.line, this.column);
                    tree.excepciones.add(error);

                    //Para deshabilitar el C3D
                    this.isC3D = false;

                    return error;
                }

                Object val = iden.execute(table, tree);
                //ERROR
                if(val instanceof Excepcion){
                    //Para deshabilitar el C3D
                    this.isC3D = false;

                    return val;
                }

                nodoIns.add(iden.getAST());


                //Verifico si la variable es del tipo ARREGLO
                if(ide.tipo2.tipo == Tipo.Tipos.ARREGLO || ide.tipo2.tipo == Tipo.Tipos.ALLOCATE){
                    String cadena = "";

                    ArrayList<Nodo> valor = (ArrayList<Nodo>) ide.valor;
                    for(int j = 0; j<valor.size(); j++){
                        cadena += valor.get(j).execute(table, tree) + " ";
                    }

                    tree.consola.add(cadena);

                    //Para deshabilitar el C3D
                    this.isC3D = true;
                }

                //Verifico si la variable es del tipo ARREGLO2
                else if(ide.tipo2.tipo == Tipo.Tipos.ARREGLO2 || ide.tipo2.tipo == Tipo.Tipos.ALLOCATE2){
                    String cadena = "";

                    ArrayList<ArrayList<Nodo>> valorJ = (ArrayList<ArrayList<Nodo>>) ide.valor;
                    for(int j = 0; j<valorJ.size(); j++){
                        ArrayList<Nodo> valorK = valorJ.get(j);
                        for(int k = 0; k<valorK.size(); k++){
                            cadena += valorK.get(k).execute(table, tree) + " ";
                        }
                        cadena += "\n";
                    }

                    tree.consola.add(cadena);

                    //Para deshabilitar el C3D
                    this.isC3D = true;
                }

                else{
                    String salida = String.valueOf(val);
                    salida = salida.replace("\"", "");
                    salida = salida.replace("'", "");

                    if(salida.equalsIgnoreCase("true")){
                        salida = "T";
                    }else if(salida.equalsIgnoreCase("false")){
                        salida = "F";
                    }

                    tree.consola.add(salida);

                    //Para habilitar el C3D
                    this.isC3D = true;
                }
            }else {
                Object val = this.expresion.get(i).execute(table, tree);

                if(val instanceof Excepcion){
                    //Para deshabilitar el C3D
                    this.isC3D = false;

                    return val;
                }

                String salida = String.valueOf(val);

                if (salida.equalsIgnoreCase("true")) {
                    salida = "T";
                } else if (salida.equalsIgnoreCase("false")) {
                    salida = "F";
                }

                tree.consola.add(salida);

                //Para AST
                nodoIns.add(this.expresion.get(i).getAST());

                //Para habilitar el C3D
                this.isC3D = true;
            }
        }
        tree.consola.add("\n");
        return null;
    }

    @Override
    public NodoAST getAST() {
        NodoAST nodo = new NodoAST("PRINT");
        nodo.agregarHijos(nodoIns);
        return nodo;
    }

    @Override
    public void get3D() {
        if(Globales.gen == null){
            C3D genAux = new C3D();
            Globales.gen = genAux.getInstance();
        }

        if(this.isC3D) {
            for (int i = 0; i < this.expresion.size(); i++) {
                this.expresion.get(i).get3D();
                if (this.expresion.get(i) instanceof Identificador prim) {
                    Simbolo ide = tablaC3D.getVariable(prim.id);
                    if(ide.tipo2.tipo == Tipo.Tipos.VARIABLE){
                        if (this.expresion.get(i).valor3D != null) {
                            if (prim.tipo == Tipo.Tipos.INTEGER) {
                                Globales.gen.addComment("Imprimiendo Integer");
                                Globales.gen.addPrint("d", String.valueOf(prim.valor3D));
                                Globales.gen.addPrint("c", "32");
                            } else if (prim.tipo == Tipo.Tipos.REAL) {
                                Globales.gen.addComment("Imprimiendo Real");
                                Globales.gen.printFloat("f", String.valueOf(prim.valor3D));
                                Globales.gen.addPrint("c", "32");
                            } else if (prim.tipo == Tipo.Tipos.CHARACTER) {
                                Globales.gen.addComment("Imprimiendo Character");
                                Globales.gen.addPrint("c", prim.valor3D);
                                Globales.gen.addPrint("c", "32");
                            } else if (prim.tipo == Tipo.Tipos.STRING || prim.tipo == Tipo.Tipos.COMPLEX) {
                                Globales.gen.addComment("Imprimiendo String");
                                Globales.gen.printString();
                                String tmp = Globales.gen.addTemp();
                                Globales.gen.addExp(tmp, "P", "+", String.valueOf(this.tablaC3D.getTotalSize()));
                                Globales.gen.addExp(tmp, tmp, "+", "1");
                                Globales.gen.setStack(tmp, prim.valor3D);
                                Globales.gen.newTable(String.valueOf(this.tablaC3D.getTotalSize()));
                                Globales.gen.callFun("printString");
                                Globales.gen.getStack(Globales.gen.addTemp(), "P");
                                Globales.gen.getTable(String.valueOf(this.tablaC3D.getTotalSize()));
                                Globales.gen.addPrint("c", "32");
                            } else if (prim.tipo == Tipo.Tipos.LOGICAL) {
                                Globales.gen.addComment("Imprimiendo Logical");
                                String tempLbl = Globales.gen.newLabel();
                                Globales.gen.addLabel(prim.ev);
                                Globales.gen.printTrue();
                                Globales.gen.addGoto(tempLbl);
                                Globales.gen.addLabel(prim.ef);
                                Globales.gen.printFalse();
                                Globales.gen.addLabel(tempLbl);
                                Globales.gen.addPrint("c", "32");
                            }
                        }
                    }else if(ide.tipo2.tipo == Tipo.Tipos.ARREGLO){
                        ArrayList<Nodo> listaI = (ArrayList<Nodo>)ide.valor;

                        Globales.gen.addComment("Imprimiendo Arreglo");
                        int j = 1;
                        for(Nodo valor: listaI){
                            valor.get3D();

                            String temp = Globales.gen.addTemp();
                            Globales.gen.addExp(temp, String.valueOf(j), "-", "1");

                            String ret = Globales.gen.addTemp();

                            Globales.gen.getPosArray(ret, ide.id, temp);

                            if (prim.tipo == Tipo.Tipos.INTEGER) {
                                Globales.gen.addPrint("d", ret);
                                Globales.gen.addPrint("c", "32");
                            } else if (prim.tipo == Tipo.Tipos.REAL) {
                                Globales.gen.printFloat("f", ret);
                                Globales.gen.addPrint("c", "32");
                            } else if (prim.tipo == Tipo.Tipos.CHARACTER) {
                                Globales.gen.addPrint("c", ret);
                                Globales.gen.addPrint("c", "32");
                            }
                            j++;
                        }

                    }else if(ide.tipo2.tipo == Tipo.Tipos.ARREGLO2){
                        ArrayList<ArrayList<Nodo>> listaI = (ArrayList<ArrayList<Nodo>>)ide.valor;

                        Globales.gen.addComment("Imprimiendo Arreglo");
                        int j = 1;
                        for(ArrayList<Nodo> listaJ: listaI){
                            int k = 1;
                            for(Nodo valor: listaJ){

                                //Obtengo numero de columnas
                                String temp0 = Globales.gen.addTemp();
                                Globales.gen.getPosArray(temp0, ide.id, "0");

                                //Obtengo la posicion i
                                String temp1 = Globales.gen.addTemp();
                                Globales.gen.addExp(temp1, String.valueOf(j), "-", "1");

                                //Multiplico P1 * J
                                String temp2 = Globales.gen.addTemp();
                                Globales.gen.addExp(temp2, temp0, "*", temp1);

                                //Sumo P2 a lo anterior
                                String temp3 = Globales.gen.addTemp();
                                Globales.gen.addExp(temp3, temp2, "+", String.valueOf(k));

                                String ret = Globales.gen.addTemp();
                                Globales.gen.getPosArray(ret, ide.id, temp3);


                                if (prim.tipo == Tipo.Tipos.INTEGER) {
                                    Globales.gen.addPrint("d", ret);
                                    Globales.gen.addPrint("c", "32");
                                } else if (prim.tipo == Tipo.Tipos.REAL) {
                                    Globales.gen.printFloat("f", ret);
                                    Globales.gen.addPrint("c", "32");
                                } else if (prim.tipo == Tipo.Tipos.CHARACTER) {
                                    Globales.gen.addPrint("c", ret);
                                    Globales.gen.addPrint("c", "32");
                                }

                                k++;
                            }
                            Globales.gen.addPrint("c", "10");
                            j++;
                        }

                    }


                } else {
                    if (this.expresion.get(i).valor3D != null) {
                        Nodo prim = this.expresion.get(i);

                        if (prim.tipo == Tipo.Tipos.INTEGER) {
                            Globales.gen.addComment("Imprimiendo un Integer");
                            Globales.gen.addPrint("d", prim.valor3D);
                            Globales.gen.addPrint("c", "32");
                        } else if (prim.tipo == Tipo.Tipos.REAL) {
                            Globales.gen.addComment("Imprimiendo un Real");
                            Globales.gen.printFloat("f", prim.valor3D);
                            Globales.gen.addPrint("c", "32");
                        } else if (prim.tipo == Tipo.Tipos.CHARACTER) {
                            Globales.gen.addComment("Imprimiendo un Character");
                            Globales.gen.addPrint("c", prim.valor3D);
                            Globales.gen.addPrint("c", "32");
                        } else if (prim.tipo == Tipo.Tipos.STRING || prim.tipo == Tipo.Tipos.COMPLEX) {
                            Globales.gen.addComment("Imprimiendo Cadena");
                            Globales.gen.printString();
                            String tmp = Globales.gen.addTemp();
                            Globales.gen.addExp(tmp, "P", "+", String.valueOf(this.tablaC3D.getTotalSize()));
                            Globales.gen.addExp(tmp, tmp, "+", "1");
                            Globales.gen.setStack(tmp, prim.valor3D);
                            Globales.gen.newTable(String.valueOf(this.tablaC3D.getTotalSize()));
                            Globales.gen.callFun("printString");
                            Globales.gen.getStack(Globales.gen.addTemp(), "P");
                            Globales.gen.getTable(String.valueOf(this.tablaC3D.getTotalSize()));
                            Globales.gen.addPrint("c", "32");
                        } else if (prim.tipo == Tipo.Tipos.LOGICAL) {
                            Globales.gen.addComment("Imprimiendo un Logical");
                            String tempLbl = Globales.gen.newLabel();
                            Globales.gen.addLabel(prim.ev);
                            Globales.gen.printTrue();
                            Globales.gen.addGoto(tempLbl);
                            Globales.gen.addLabel(prim.ef);
                            Globales.gen.printFalse();
                            Globales.gen.addLabel(tempLbl);
                            Globales.gen.addPrint("c", "32");
                        }
                    }
                }
            }
            Globales.gen.addPrint("c", "10");
        }
    }
}
