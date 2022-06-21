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

    ArrayList<NodoAST> nodoIns = new ArrayList<>();

    public Print(ArrayList<Nodo> expresion, int line, int column) {
        super(null, line, column);
        this.expresion = expresion;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        for(int i = 0; i<this.expresion.size(); i++){
            if(this.expresion.get(i) instanceof Identificador iden){
                //Obtengo la variable de la tabla de simbolos
                Simbolo ide = table.getVariable(iden.id);

                Object val = iden.execute(table, tree);

                //ERROR
                if(val instanceof Excepcion e){
                    return val;
                }

                nodoIns.add(iden.getAST());

                //ERROR
                if(ide == null){
                    String err = "La variable {"+iden.id+"} no ha sido encontrada \n";
                    Excepcion error = new Excepcion("Semantico", err,this.line, this.column);
                    tree.excepciones.add(error);
                    return error;
                }

                //Verifico si la variable es del tipo ARREGLO
                if(ide.tipo2.tipo == Tipo.Tipos.ARREGLO || ide.tipo2.tipo == Tipo.Tipos.ALLOCATE){
                    String cadena = "";

                    ArrayList<Nodo> valor = (ArrayList<Nodo>) ide.valor;
                    for(int j = 0; j<valor.size(); j++){
                        cadena += valor.get(j).execute(table, tree) + " ";
                    }

                    tree.consola.add(cadena);
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

                    //PARA C3D
                    if(this.expresion.get(i).valor3D != null){
                        Nodo prim = this.expresion.get(i);
                        if(Globales.gen == null){
                            C3D genAux = new C3D();
                            Globales.gen = genAux.getInstance();
                        }

                        if(prim.tipo == Tipo.Tipos.INTEGER){
                            Globales.gen.addComment("Imprimiendo un Integer");
                            Globales.gen.addPrint("d", String.valueOf(prim.valor3D));
                            Globales.gen.addPrint("c",  String.valueOf(10));
                        }

                        else if(prim.tipo == Tipo.Tipos.REAL){
                            Globales.gen.addComment("Imprimiendo un Real");
                            Globales.gen.printFloat("f", String.valueOf(prim.valor3D));
                            Globales.gen.addPrint("c",  String.valueOf(10));
                        }

                        else if(prim.tipo == Tipo.Tipos.CHARACTER){
                            Globales.gen.addComment("Imprimiendo un Character");
                            Globales.gen.addPrint("c", prim.valor3D);
                            Globales.gen.addPrint("c",  String.valueOf(10));
                        }

                        else if(prim.tipo == Tipo.Tipos.STRING || prim.tipo == Tipo.Tipos.COMPLEX){
                            Globales.gen.addComment("Imprimiendo Cadena");
                            Globales.gen.printString();
                            String tmp = Globales.gen.addTemp();
                            Globales.gen.addExp(tmp, "P", "+", String.valueOf(table.size));
                            Globales.gen.addExp(tmp, tmp, "+", "1");
                            Globales.gen.setStack(tmp, prim.valor3D);
                            Globales.gen.newTable(String.valueOf(table.size));
                            Globales.gen.callFun("printString");
                            Globales.gen.getStack(Globales.gen.addTemp(), "P");
                            Globales.gen.getTable(String.valueOf(table.size));
                            Globales.gen.addPrint("c",  String.valueOf(10));
                        }

                        else if(prim.tipo == Tipo.Tipos.LOGICAL){
                            Globales.gen.addComment("Imprimiendo un Logical");
                            String tempLbl = Globales.gen.newLabel();
                            Globales.gen.addLabel(prim.ev);
                            Globales.gen.printTrue();
                            Globales.gen.addGoto(tempLbl);
                            Globales.gen.addLabel(prim.ef);
                            Globales.gen.printFalse();
                            Globales.gen.addLabel(tempLbl);
                            Globales.gen.addPrint("c",  String.valueOf(10));
                        }
                    }
                }
            }else {
                Object val = this.expresion.get(i).execute(table, tree);

                if(val instanceof Excepcion){
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

                //PARA C3D
                if(this.expresion.get(i).valor3D != null){
                    Nodo prim = this.expresion.get(i);
                    if(Globales.gen == null){
                        C3D genAux = new C3D();
                        Globales.gen = genAux.getInstance();
                    }

                    if(prim.tipo == Tipo.Tipos.INTEGER){
                        Globales.gen.addComment("Imprimiendo un Integer");
                        Globales.gen.addPrint("d", prim.valor3D);
                        Globales.gen.addPrint("c",  String.valueOf(10));
                    }

                    else if(prim.tipo == Tipo.Tipos.REAL){
                        Globales.gen.addComment("Imprimiendo un Real");
                        Globales.gen.printFloat("f", prim.valor3D);
                        Globales.gen.addPrint("c",  String.valueOf(10));
                    }

                    else if(prim.tipo == Tipo.Tipos.CHARACTER){
                        Globales.gen.addComment("Imprimiendo un Character");
                        Globales.gen.addPrint("c", prim.valor3D);
                        Globales.gen.addPrint("c",  String.valueOf(10));
                    }

                    else if(prim.tipo == Tipo.Tipos.STRING || prim.tipo == Tipo.Tipos.COMPLEX){
                        Globales.gen.addComment("Imprimiendo Cadena");
                        Globales.gen.printString();
                        String tmp = Globales.gen.addTemp();
                        Globales.gen.addExp(tmp, "P", "+", String.valueOf(table.size));
                        Globales.gen.addExp(tmp, tmp, "+", "1");
                        Globales.gen.setStack(tmp, prim.valor3D);
                        Globales.gen.newTable(String.valueOf(table.size));
                        Globales.gen.callFun("printString");
                        Globales.gen.getStack(Globales.gen.addTemp(), "P");
                        Globales.gen.getTable(String.valueOf(table.size));
                        Globales.gen.addPrint("c",  String.valueOf(10));
                    }

                    else if(prim.tipo == Tipo.Tipos.LOGICAL){
                        Globales.gen.addComment("Imprimiendo un Logical");
                        String tempLbl = Globales.gen.newLabel();
                        Globales.gen.addLabel(prim.ev);
                        Globales.gen.printTrue();
                        Globales.gen.addGoto(tempLbl);
                        Globales.gen.addLabel(prim.ef);
                        Globales.gen.printFalse();
                        Globales.gen.addLabel(tempLbl);
                        Globales.gen.addPrint("c",  String.valueOf(10));
                    }
                }
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
}
