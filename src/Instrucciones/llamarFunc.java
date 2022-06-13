package Instrucciones;

import Abstract.Nodo;
import Expresiones.Identificador;
import Expresiones.Primitivo;
import Other.Excepcion;
import Other.Tipo;
import Symbols.Simbolo;
import Symbols.Table;
import Symbols.Tree;

import java.util.ArrayList;

public class llamarFunc extends Nodo {
    String id;
    ArrayList<Nodo> parametrosEnt;

    public llamarFunc(String id, ArrayList<Nodo> parametrosEnt, int line, int column) {
        super(null, line, column);
        this.id = id;
        this.parametrosEnt = parametrosEnt;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        Table newtable = new Table(null);

        Simbolo simboloMetodo = tree.getFuncion(this.id);

        if (simboloMetodo == null) {
            String err = "La Funcion {"+this.id+"} no ha sido encontrada \n";
            Excepcion error = new Excepcion("Semantico", err,this.line, this.column);
            tree.excepciones.add(error);
            tree.consola.add(error.toString());
            return error;
        }


        this.tipo = ((ArrayList<ArrayList<Nodo>>)simboloMetodo.valor).get(2).get(0).tipo;

        ArrayList<Nodo> parametros = ((ArrayList<ArrayList<Nodo>>)simboloMetodo.valor).get(0);

        if(this.parametrosEnt.size() != parametros.size()){
            String err = "Los parametros de entrada y parametros declarados no son los mismos \n";
            Excepcion error = new Excepcion("Semantico", err,this.line, this.column);
            tree.excepciones.add(error);
            tree.consola.add(error.toString());
            return error;
        }

        for (int i = 0; i < parametros.size(); i++) {
            if(parametros.get(i) instanceof Declaracion dec){
                if(this.parametrosEnt.get(i) instanceof Identificador ide){
                    ide.execute(table, tree);
                    if(ide.tipo != dec.tipo){
                        String err = "La variable {" +dec.id+ "} no puede ser declarada debido a que son de diferentes tipos [" +dec.tipo+"] y [" +ide.tipo + "] \n";
                        Excepcion error = new Excepcion("Semantico", err, dec.line, dec.column);
                        tree.excepciones.add(error);
                        tree.consola.add(error.toString());
                        return error;
                    }
                    dec.valor = new Primitivo(ide.tipo, ide.execute(table, tree), dec.line, dec.column);
                    dec.execute(newtable, tree);
                }else {
                    this.parametrosEnt.get(i).execute(table, tree);
                    if(this.parametrosEnt.get(i).tipo != dec.tipo){
                        String err = "La variable {" +dec.id+ "} no puede ser declarada debido a que son de diferentes tipos [" +dec.tipo+"] y [" +this.parametrosEnt.get(i).tipo+ "] \n";
                        Excepcion error = new Excepcion("Semantico", err, dec.line, dec.column);
                        tree.excepciones.add(error);
                        tree.consola.add(error.toString());
                        return error;
                    }
                    dec.valor = this.parametrosEnt.get(i);
                    dec.execute(newtable, tree);
                }

            }else if(parametros.get(i) instanceof DeclaracionArray decArray) {
                Object dim1 = decArray.dim1.execute(newtable, tree);


                if(this.parametrosEnt.get(i) instanceof Identificador ide){
                    Object result = ide.execute(table, tree);

                    if(decArray.dim2 == null){
                        if(ide.tipo != Tipo.Tipos.ARREGLO){
                            String err = "El arreglo {" +decArray.id+ "} no puede ser declarada debido a que son de diferentes tipos [Array] y [" +ide.tipo + "] \n";
                            Excepcion error = new Excepcion("Semantico", err, decArray.line, decArray.column);
                            tree.excepciones.add(error);
                            tree.consola.add(error.toString());
                            return error;
                        }
                        if((int)dim1 != ((ArrayList<Nodo>)result).size()){
                            String err = "El arreglo {" +decArray.id+ "} no puede ser declarado debido a que son de diferentes dimensiones \n";
                            Excepcion error = new Excepcion("Semantico", err, decArray.line, decArray.column);
                            tree.excepciones.add(error);
                            tree.consola.add(error.toString());
                            return error;
                        }

                        decArray.execute(newtable, tree);
                        Asignacion newA = new Asignacion(decArray.id, result, decArray.line, decArray.column);

                        newA.execute(newtable, tree);
                    }else{
                        Object dim2 = decArray.dim2.execute(newtable, tree);

                        if(ide.tipo != Tipo.Tipos.ARREGLO2){
                            String err = "El arreglo {" +decArray.id+ "} no puede ser declarada debido a que son de diferentes tipos [Array] y [" +ide.tipo + "] \n";
                            Excepcion error = new Excepcion("Semantico", err, decArray.line, decArray.column);
                            tree.excepciones.add(error);
                            tree.consola.add(error.toString());
                            return error;
                        }

                        ArrayList<ArrayList<Nodo>> listI = (ArrayList<ArrayList<Nodo>>) result;
                        ArrayList<Nodo> listJ = listI.get(0);

                        if((int)dim1 != listI.size() || (int)dim2 != listJ.size()){
                            String err = "El arreglo {" +decArray.id+ "} no puede ser declarado debido a que son de diferentes dimensiones \n";
                            Excepcion error = new Excepcion("Semantico", err, decArray.line, decArray.column);
                            tree.excepciones.add(error);
                            tree.consola.add(error.toString());
                            return error;
                        }

                        decArray.execute(newtable, tree);
                        Simbolo variable = newtable.getVariable(decArray.id);
                        variable.valor = listI;
                    }
                }
            }
        }

        ArrayList<Nodo> instrucciones = ((ArrayList<ArrayList<Nodo>>)simboloMetodo.valor).get(1);
        Nodo declaRet = ((ArrayList<ArrayList<Nodo>>)simboloMetodo.valor).get(2).get(0);
        declaRet.execute(newtable, tree);

        for (int i = 0; i < instrucciones.size(); i++) {
            Object res = instrucciones.get(i).execute(newtable, tree);
        }

        Identificador iden = new Identificador("", declaRet.line, declaRet.column);

        if(declaRet instanceof Declaracion dec){
            iden = new Identificador(dec.id, dec.line, dec.column);
        }else if(declaRet instanceof DeclaracionArray decA){
            iden = new Identificador(decA.id, decA.line, decA.column);
        }

        return new Return(iden, iden.line, iden.column).execute(newtable, tree);
    }
}
