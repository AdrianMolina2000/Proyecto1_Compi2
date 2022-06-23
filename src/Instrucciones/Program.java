package Instrucciones;

import Abstract.Nodo;
import Abstract.NodoAST;
import Other.Excepcion;
import Other.Tipo;
import Symbols.Table;
import Symbols.Tree;

import java.util.ArrayList;

public class Program extends Nodo {
    public ArrayList<Nodo> instrucciones;
    public String abre;
    public String cierra;

    //Para AST
    ArrayList<NodoAST> nodoIns = new ArrayList<>();

    public Program(ArrayList<Nodo> instrucciones, String abre, String cierra, int line, int column) {
        super(null, line, column);
        this.instrucciones = instrucciones;
        this.abre = abre;
        this.cierra = cierra;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        Table newTable = new Table(null);

        //Verifico que el nombre de apertura y cierre sean iguales
        if(abre.equalsIgnoreCase(cierra)){
            //Recorro todas las instrucciones obtenidas
            for(int i = 0; i<instrucciones.size(); i++){

                //Ejecuto todas las instrucciones creadas dentro del PROGRAM
                Object val = instrucciones.get(i).execute(newTable, tree);

                //Obtengo todos los AST de las instrucciones
                nodoIns.add(instrucciones.get(i).getAST());

                //ERROR
                if(val instanceof Excepcion e){
                    tree.consola.add(e.toString());
                }
            }
        }

        //ERROR
        else{
            String err = "Los nombres de apertura y cierre deben ser iguales \n";
            Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
            tree.consola.add(error.toString());
            tree.excepciones.add(error);
        }
        return null;
    }

    @Override
    public NodoAST getAST() {
        NodoAST nodo = new NodoAST("PROGRAM");
        nodo.agregarHijos(nodoIns);
        return nodo;
    }

    @Override
    public void get3D() {

        for(int i = 0; i<instrucciones.size(); i++){
            instrucciones.get(i).get3D();
        }
    }
}
