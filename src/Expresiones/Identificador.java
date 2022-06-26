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

public class Identificador extends Nodo {
    public String id;
    public Tipo.Tipos tipo2;

    //PARA EL AST
    NodoAST nodoMain;

    //Para C3D
    Table tableC3D;

    public Identificador(String id, int line, int column) {
        super(null, line, column);
        this.id = id;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        //Obtengo la variable de la tabla de simbolos
        Simbolo variable = table.getVariable(this.id);

        if (variable == null) {
            String err = "La variable {"+this.id+"} no ha sido encontrada \n";
            Excepcion error = new Excepcion("Semantico", err,this.line, this.column);
            tree.excepciones.add(error);
            //tree.consola.add(error.toString());
            return error;
        }

        //Verifico que la variable sea del tipo VARIABLE
        if(variable.tipo2.tipo == Tipo.Tipos.VARIABLE){
            //Verifico si posee otra variable dentro
            if (variable.valor instanceof Identificador) {
                variable.valor = ((Identificador)variable.valor).execute(table, tree);
            }

            Object result = variable.valor;

            //Le coloco el tipo a esta clase
            this.tipo = variable.tipo.tipo;
            this.tipo2 = variable.tipo2.tipo;

            //Creacion del nodo AST
            nodoMain = new NodoAST("ID");
            nodoMain.agregarHijo(this.id);
            nodoMain.agregarHijo(String.valueOf(result));

            //Para C3D
            this.isC3D = true;
            tableC3D = table;

            //Devuelvo el valor resultante
            return result;
        }

        //Verifico si es un arreglo de 1 dimension
        else if (variable.tipo2.tipo == Tipo.Tipos.ARREGLO || variable.tipo2.tipo == Tipo.Tipos.ALLOCATE) {

            //Obtengo el arreglo de la lista de valores
            ArrayList<Nodo> vieja = (ArrayList<Nodo>) variable.valor;

            //Creo una nueva lista para copiar los valores
            ArrayList<Nodo> nueva = new ArrayList<>();

            //Creo el String para el AST
            String valorNodo = "[";
            for(int i = 0; i < vieja.size(); i++){
                Nodo no = vieja.get(i);
                Object val = no.execute(table, tree);

                if (val instanceof Excepcion e) {
                    tree.consola.add(e.toString());
                    return val;
                }

                //Creo el nuevo primitivo
                Primitivo prim =  new Primitivo(no.tipo, val, no.line, no.column);
                nueva.add(prim);

                valorNodo += val + ", ";
            }
            valorNodo += "]";


            //Le asigno tipo a esta clase
            this.tipo = variable.tipo.tipo;
            this.tipo2 = variable.tipo2.tipo;

            //Creo el nodo para el AST
            nodoMain = new NodoAST("ID");
            nodoMain.agregarHijo(new NodoAST(this.id));
            nodoMain.agregarHijo(new NodoAST(valorNodo));

            //Devuelvo la lista de valores
            return nueva;
        }

        //Verifico si es un arreglo de 2 dimensiones
        else if (variable.tipo2.tipo == Tipo.Tipos.ARREGLO2 || variable.tipo2.tipo == Tipo.Tipos.ALLOCATE2) {

            //Obtengo la lista de listas de la variable
            ArrayList<ArrayList<Nodo>> viejaI = (ArrayList<ArrayList<Nodo>>) variable.valor;

            //Creo la nueva lista de listas
            ArrayList<ArrayList<Nodo>> nuevaI = new ArrayList<>();

            String valorNodo = "[";
            for(int i = 0; i<viejaI.size(); i++){
                //Obtengo la lista de valores
                ArrayList<Nodo> viejaJ = viejaI.get(i);

                //Creo la nueva lista de valores
                ArrayList<Nodo> nuevaJ = new ArrayList<>();

                valorNodo += "[";
                for(int j = 0; j<viejaJ.size(); j++) {
                    Nodo no = viejaJ.get(j);
                    Object val = no.execute(table, tree);

                    if (val instanceof Excepcion e) {
                        tree.consola.add(e.toString());
                        return val;
                    }

                    //Creo el nuevo nodo Primitivo
                    Primitivo prim = new Primitivo(no.tipo, val, no.line, no.column);
                    nuevaJ.add(prim);

                    valorNodo += val + ", ";
                }
                valorNodo += "]";
                nuevaI.add(nuevaJ);
            }
            valorNodo += "]";

            //Le asigno tipo a esta clase
            this.tipo = variable.tipo.tipo;
            this.tipo2 = variable.tipo2.tipo;

            //Creo el nodo para el AST
            nodoMain = new NodoAST("ID");
            nodoMain.agregarHijo(new NodoAST(this.id));
            nodoMain.agregarHijo(new NodoAST(valorNodo));

            //Devuelvo la lista de valores
            return nuevaI;
        }

        //ERROR
        else{
            String err = "La variable que busca no es de los tipos admitidos \n";
            Excepcion error = new Excepcion("Semantico", err,this.line, this.column);
            tree.excepciones.add(error);
            //tree.consola.add(error.toString());
            return error;
        }
    }

    @Override
    public NodoAST getAST() {
        NodoAST nodo = new NodoAST("VARIABLE");

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
            Globales.gen.addComment("Acceder Variable");

            Simbolo variable = this.tableC3D.getVariable(this.id);

            String pos = Globales.gen.addTemp();
            String temp = Globales.gen.addTemp();

            String posVar = String.valueOf(variable.pos);

            if(variable.inFunc){
                Globales.gen.addExp(pos, "P", "+", String.valueOf(variable.pos+1));
            }else{
                Globales.gen.addExp(pos, "P", "+", posVar);
            }


            Globales.gen.getStack(temp, pos);

            if (variable.tipo.tipo != Tipo.Tipos.LOGICAL) {
                if(this.valor3D == null){
                    this.valor3D = temp;
                }
                this.tmp = true;
            }else {
                if (this.ev == null) {
                    this.ev = Globales.gen.newLabel();
                }
                if (this.ef == null) {
                    this.ef = Globales.gen.newLabel();
                }

                Globales.gen.newIF(temp, "==", "1", this.ev);
                Globales.gen.addGoto(this.ef);
                this.valor3D = "";
                this.tmp = false;
            }
        }
    }
}
