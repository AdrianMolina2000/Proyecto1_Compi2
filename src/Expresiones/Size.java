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

public class Size extends Nodo {
    String id;

    //PARA EL AST
    NodoAST nodoRest;

    //Para el C3D
    int size;

    public Size(String id, int line, int column) {
        super(null, line, column);
        this.id = id;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        Simbolo variable = table.getVariable(this.id);

        //Verifico que la variable exista en mi tabla
        if (variable == null) {
            String err = "La variable {"+this.id+"} no ha sido encontrada \n";
            Excepcion error = new Excepcion("Semantico", err,this.line, this.column);
            tree.excepciones.add(error);
            //tree.consola.add(error.toString());
            return error;
        }

        //Verifico que la variable sea del tipo arreglo
        if(       variable.tipo2.tipo == Tipo.Tipos.ARREGLO
                ||variable.tipo2.tipo == Tipo.Tipos.ARREGLO2
                ||variable.tipo2.tipo == Tipo.Tipos.ALLOCATE
                ||variable.tipo2.tipo == Tipo.Tipos.ALLOCATE2
        ){
            if(variable.valor instanceof ArrayList<?> listaI) {
                if(listaI.size() > 0) {
                    if (listaI.get(0) instanceof ArrayList<?> listaJ) {
                        //Le coloco el tipo a esta clase
                        this.tipo = Tipo.Tipos.INTEGER;

                        //Guardo el size del arreglo
                        int retorno = listaI.size() * listaJ.size();

                        //Creo el nodo con el valor para el AST
                        nodoRest = new NodoAST("*");
                        nodoRest.agregarHijo(new NodoAST(String.valueOf(listaI.size())));
                        nodoRest.agregarHijo(new NodoAST(String.valueOf(listaJ.size())));

                        //Retorno el valor de la lista
                        return retorno;
                    }
                }
                //Le coloco el tipo a esta clase
                this.tipo = Tipo.Tipos.INTEGER;

                //Creo el nodo con el valor para el AST
                nodoRest = new NodoAST(String.valueOf(listaI.size()));

                //Para C3D
                this.isC3D = true;
                this.size = listaI.size();

                //Retorno el valor de la lista
                return listaI.size();
            }
        }else{
            String err = "La variable {"+this.id+"} no es del tipo Array \n";
            Excepcion error = new Excepcion("Semantico", err,this.line, this.column);
            tree.excepciones.add(error);
            //tree.consola.add(error.toString());
            return error;
        }

        return null;
    }


    @Override
    public NodoAST getAST() {
        NodoAST nodo = new NodoAST("SIZE");
        nodo.agregarHijo(new NodoAST(this.id));
        if(nodoRest != null){
            nodo.agregarHijo(nodoRest);
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
            String tempSize = Globales.gen.addTemp();
            Globales.gen.addExp(tempSize, "0", "+", String.valueOf(this.size));
            this.valor3D = tempSize;
            this.tmp = true;
        }
    }
}
