package Instrucciones;

import Abstract.Nodo;
import Abstract.NodoAST;
import Expresiones.Identificador;
import Gramatica.Globales;
import Other.Excepcion;
import Other.Tipo;
import Symbols.C3D;
import Symbols.Simbolo;
import Symbols.Table;
import Symbols.Tree;

import java.util.ArrayList;

public class Asignacion extends Nodo {
    public String id;
    public Object expresion;

    //PARA AST
    NodoAST nodoMain;

    //Para C3D
    Table tableC3D;

    public Asignacion(String id, Object valor, int line, int column) {
        super(null, line, column);
        this.id = id;
        this.expresion = valor;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        //Obtengo la variable a asignar
        Simbolo variable = table.getVariable(this.id);

        if (variable == null) {
            String err = "La variable {"+this.id+"} no ha sido encontrada \n";
            Excepcion error = new Excepcion("Semantico", err,this.line, this.column);
            tree.excepciones.add(error);
            return error;
        }

        //ERROR
        if(this.expresion == null){
            String err = "La expresion no es valida \n";
            Excepcion error = new Excepcion("Semantico", err,this.line, this.column);
            tree.excepciones.add(error);
            return error;
        }

        Object result = this.expresion;
        if(this.expresion instanceof Nodo res){
            result = res.execute(table, tree);
            if (result instanceof Excepcion e) {
                return result;
            }
        }


        this.tipo = variable.tipo.tipo;
        if(this.expresion instanceof Nodo res){
            if (res.tipo != variable.tipo.tipo){
                String err = "La variable {"+this.id+"} no puede ser asignada debido a que son de diferentes tipos ["+ variable.tipo.tipo + "] y ["+res.tipo+"] \n";
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.excepciones.add(error);
                return error;
            }
        }

        //Verifico si la variable es del tipo variable
        if(variable.tipo2.tipo == Tipo.Tipos.VARIABLE){
            if(this.expresion instanceof Nodo rest){

                if(result instanceof ArrayList<?>){
                    String err = "No es un valor valido para La variable {"+this.id+"} \n";
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    return error;
                }

                //Guardo el nuevo valor en la variable
                variable.valor = result;

                //Creo el nodo AST
                nodoMain = new NodoAST("ASIGNAR");
                nodoMain.agregarHijo(new NodoAST(this.id));
                nodoMain.agregarHijo(rest.getAST());

                //Para el C3D
                this.isC3D = true;
                this.tableC3D = table;

                //Termino la ejecucion
                return result;
            }else{
                String err = "No es un valor valido para La variable {"+this.id+"} \n";
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.excepciones.add(error);
                return error;
            }
        }

        //Verifico si la variable es del tipo ARRAY
        else if(variable.tipo2.tipo == Tipo.Tipos.ARREGLO || variable.tipo2.tipo == Tipo.Tipos.ALLOCATE){

            //Verifico si la entrada es una lista
            if(result instanceof ArrayList<?> listaI){
                ArrayList<Nodo> variableValor = (ArrayList<Nodo>)variable.valor;

                //Verifico que las listas sean de las mismas dimensiones
                if(variableValor.size() != listaI.size()){
                    String err = "El arreglo no puede ser asignado porque no poseen las mismas dimensiones \n";
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    return error;
                }

                //ERROR
                if(variableValor.size() == 0){
                    String err = "El arreglo no puede ser asignado porque no poseen las mismas dimensiones \n";
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    return error;
                }

                String resultado = "[";
                for(int i = 0; i < listaI.size(); i++){
                    if(((ArrayList<Nodo>)listaI).get(i).tipo != variable.tipo.tipo){
                        String err = "El arreglo no puede ser asignado porque no poseen los mismos tipos \n";
                        Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                        tree.excepciones.add(error);
                        return error;
                    }
                    resultado += ((ArrayList<Nodo>)listaI).get(i).execute(table, tree) + ", ";
                }
                resultado += "]";

                //Creo el nodo AST
                nodoMain = new NodoAST("ASIGNAR");
                nodoMain.agregarHijo(new NodoAST(this.id));
                nodoMain.agregarHijo(new NodoAST(resultado));

                //Le agrego la lista obtenida al arreglo
                variable.valor = listaI;
                return null;
            }

            //ERROR
            else{
                String err = "No esta asignando un arreglo a la variable [" +variable.id+ "] \n";
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.excepciones.add(error);
                return error;
            }
        }

        //Verifico si la variable es del tipo ARREGLO de 2 dimensiones
        else if(variable.tipo2.tipo == Tipo.Tipos.ARREGLO2 || variable.tipo2.tipo == Tipo.Tipos.ALLOCATE2){

            //Verifico si la entrada es una lista
            if(result instanceof ArrayList<?> listaI){

                //Obtengo la lista de listas de la variable
                ArrayList<ArrayList<Nodo>> variableValI = (ArrayList<ArrayList<Nodo>>) variable.valor;

                //Verifico que la lista obtenida y la de la variable sean de la misma dimension
                if(listaI.size() != variableValI.size()){
                    String err = "El arreglo no puede ser asignado porque no poseen las mismas dimensiones \n";
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    return error;
                }

                //ERROR
                if(variableValI.size() == 0){
                    String err = "El arreglo no puede ser asignado porque no poseen las mismas dimensiones \n";
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    return error;
                }

                String resultado = "[";
                for(int i = 0; i < listaI.size(); i++){
                    resultado += "[";


                    if(listaI.get(i) instanceof ArrayList<?>){
                        ArrayList<Nodo> variableValJ = variableValI.get(i);
                        ArrayList<Nodo> listaJ = (ArrayList<Nodo>) listaI.get(i);

                        if(listaJ.size() != variableValJ.size()){
                            String err = "El arreglo no puede ser asignado porque no poseen las mismas dimensiones \n";
                            Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                            tree.excepciones.add(error);
                            return error;
                        }

                        //ERROR
                        if(variableValJ.size() == 0){
                            String err = "El arreglo no puede ser asignado porque no poseen las mismas dimensiones \n";
                            Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                            tree.excepciones.add(error);
                            return error;
                        }

                        for(int j=0; j < listaJ.size(); j++){
                            //Verifico que los valores de la lista sean del mismo tipo que la variable
                            if(listaJ.get(j).tipo != variable.tipo.tipo){
                                String err = "El arreglo no puede ser asignado porque no poseen los mismos tipos \n";
                                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                                tree.excepciones.add(error);
                                return error;
                            }

                            resultado += listaJ.get(j).execute(table, tree) + ", ";
                        }
                        resultado += "], ";
                    }

                    //ERROR
                    else{
                        String err = "No esta asignando un arreglo valido a la variable [" +variable.id+ "] \n";
                        Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                        tree.excepciones.add(error);
                        return error;
                    }

                }
                resultado += "]";

                //Creo el nodo AST
                nodoMain = new NodoAST("ASIGNAR");
                nodoMain.agregarHijo(new NodoAST(this.id));
                nodoMain.agregarHijo(new NodoAST(resultado));

                //Le asigno el valor a la variable
                variable.valor = listaI;
                return null;
            }

            //ERROR
            else{
                String err = "No esta asignando un arreglo a la variable [" +variable.id+ "] \n";
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
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
            Globales.gen.addComment("Asignar Variable");

            Simbolo variable = this.tableC3D.getVariable(this.id);

            String pos = Globales.gen.addTemp();

            String totalSize = String.valueOf(tableC3D.getTotalSize());
            String posVar = String.valueOf(variable.pos);

            if(!variable.isGlobal){
                Globales.gen.addExp(pos, "P", "+", totalSize);
            }else{
                Globales.gen.addExp(pos, "0", "+", posVar);
            }

            ((Nodo) this.expresion).get3D();
            Nodo rest = (Nodo)this.expresion;

            if(rest.tipo == Tipo.Tipos.LOGICAL){
                String ev = Globales.gen.newLabel();
                Globales.gen.addLabel(rest.ev);
                Globales.gen.setStack(pos, "1");
                Globales.gen.addGoto(ev);
                Globales.gen.addLabel(rest.ef);
                Globales.gen.setStack(pos, "0");
                Globales.gen.addLabel(ev);
            }else{
                Globales.gen.setStack(pos, rest.valor3D);
            }
        }
    }
}
