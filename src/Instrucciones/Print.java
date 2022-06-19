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
                    String salida = String.valueOf(this.expresion.get(i).execute(table, tree));
                    salida = salida.replace("\"", "");
                    salida = salida.replace("'", "");

                    if(salida.equalsIgnoreCase("true")){
                        salida = "T";
                    }else if(salida.equalsIgnoreCase("false")){
                        salida = "F";
                    }

                    tree.consola.add(salida);
                }
            }else {
                Object val = this.expresion.get(i).execute(table, tree);
                if(val instanceof Excepcion){
                    return val;
                }

                String salida = String.valueOf(val);
                salida = salida.replace("\"", "");
                salida = salida.replace("'", "");

                if (salida.equalsIgnoreCase("true")) {
                    salida = "T";
                } else if (salida.equalsIgnoreCase("false")) {
                    salida = "F";
                }

                tree.consola.add(salida);

                //Para AST
                nodoIns.add(this.expresion.get(i).getAST());

                //PARA C3D
                if(this.expresion.get(i) instanceof Primitivo prim){
                    if(Globales.gen == null){
                        //Para 3D
                        C3D genAux = new C3D();
                        Globales.gen = genAux.getInstance();
                    }

                    if(prim.tipo == Tipo.Tipos.INTEGER){
                        Globales.gen.addComment("Imprimiendo un Integer");
                        Globales.gen.addPrint("d", String.valueOf(val));
                        Globales.gen.addPrint("c",  String.valueOf(10));
                        Globales.gen.addComment("Imprimiendo un Integer");
                    }

                    else if(prim.tipo == Tipo.Tipos.REAL){
                        Globales.gen.addComment("Imprimiendo un Real");
                        Globales.gen.printFloat("f", String.valueOf(val));
                        Globales.gen.addPrint("c",  String.valueOf(10));
                        Globales.gen.addComment("Imprimiendo un Real");
                    }

                    else if(prim.tipo == Tipo.Tipos.CHARACTER){
                        Globales.gen.addComment("Imprimiendo un Character");
                        if(salida.length() == 1){
                            char character = salida.charAt(0);
                            int ascii = character;
                            Globales.gen.addPrint("c",  String.valueOf(ascii));
                        }
                        Globales.gen.addPrint("c",  String.valueOf(10));
                        Globales.gen.addComment("Imprimiendo un Character");
                    }

                    else if(prim.tipo == Tipo.Tipos.STRING || prim.tipo == Tipo.Tipos.COMPLEX){
                        Globales.gen.addComment("Guardando cadena en el heap");
                        String temp = Globales.gen.addTemp();
                        Globales.gen.addExp(temp, "H", "", "");

                        for(int c = 0; c < salida.length(); c++){
                            char character = salida.charAt(c);
                            int ascii = character;

                            Globales.gen.setHeap("H", String.valueOf(ascii)); //heap[H] = NUM;
                            Globales.gen.nextHeap(); //H = H + 1;
                        }

                        Globales.gen.setHeap("H", "-1");
                        Globales.gen.nextHeap();
                        Globales.gen.addComment("Fin cadena en el heap");

                        //Imprimiendola
                        Globales.gen.addComment("Imprimiendo Cadena");
                        Globales.gen.printString();
                        String tmp = Globales.gen.addTemp();
                        Globales.gen.addExp(tmp, "P", "+", String.valueOf(table.size));
                        Globales.gen.addExp(tmp, tmp, "+", "1");
                        Globales.gen.setStack(tmp, temp);
                        Globales.gen.newTable(String.valueOf(table.size));
                        Globales.gen.callFun("printString");
                        Globales.gen.getStack(Globales.gen.addTemp(), "P");
                        Globales.gen.getTable(String.valueOf(table.size));
                        Globales.gen.addPrint("c",  String.valueOf(10));
                        Globales.gen.addComment("Imprimiendo Cadena");
                    }

                    else if(prim.tipo == Tipo.Tipos.LOGICAL){
                        Globales.gen.addComment("Imprimiendo un Integer");
                        if(salida.equalsIgnoreCase("T")){
                            Globales.gen.addPrint("d", String.valueOf(1));
                            Globales.gen.addPrint("c",  String.valueOf(10));
                        }else{
                            Globales.gen.addPrint("d", String.valueOf(0));
                            Globales.gen.addPrint("c",  String.valueOf(10));
                        }
                        Globales.gen.addComment("Imprimiendo un Integer");
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
