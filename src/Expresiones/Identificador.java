package Expresiones;

import Abstract.Nodo;
import Other.Excepcion;
import Other.Tipo;
import Symbols.Simbolo;
import Symbols.Table;
import Symbols.Tree;

import java.util.ArrayList;

public class Identificador extends Nodo {
    public String id;
    public Object valor;

    public Identificador(String id, int line, int column) {
        super(null, line, column);
        this.id = id;
    }
    @Override
    public Object execute(Table table, Tree tree) {
        Simbolo variable;
        variable = table.getVariable(this.id);

        if (variable == null) {
            String err = "La variable {"+this.id+"} no ha sido encontrada \n";
            Excepcion error = new Excepcion("Semantico", err,this.line, this.column);
            tree.excepciones.add(error);
            tree.consola.add(error.toString());
            return error;
        }
        this.tipo = variable.tipo.tipo;
        if(variable.tipo2.tipo == Tipo.Tipos.VARIABLE){
            if (variable.valor instanceof Identificador) {
                variable.valor = ((Identificador)variable.valor).execute(table, tree);
            }
            this.tipo = variable.tipo.tipo;
            this.valor = variable.valor;

        }else if (variable.tipo2.tipo == Tipo.Tipos.ARREGLO || variable.tipo2.tipo == Tipo.Tipos.ALLOCATE) {
            this.tipo = variable.tipo.tipo;

            ArrayList<Nodo> vieja = (ArrayList<Nodo>) variable.valor;
            ArrayList<Nodo> nueva = new ArrayList<>();


            for(int i = 0; i<vieja.size(); i++){
                Nodo no = vieja.get(i);
                Object val = no.execute(table, tree);
                Primitivo prim =  new Primitivo(no.tipo, val, no.line, no.column);
                nueva.add(prim);
            }

            this.valor = nueva;
        }else if (variable.tipo2.tipo == Tipo.Tipos.ARREGLO2 || variable.tipo2.tipo == Tipo.Tipos.ALLOCATE2) {
            this.tipo = variable.tipo.tipo;

            ArrayList<ArrayList<Nodo>> viejaI = (ArrayList<ArrayList<Nodo>>) variable.valor;
            ArrayList<ArrayList<Nodo>> nuevaI = new ArrayList<>();


            for(int i = 0; i<viejaI.size(); i++){
                ArrayList<Nodo> viejaJ = viejaI.get(i);
                ArrayList<Nodo> nuevaJ = new ArrayList<>();

                for(int j = 0; j<viejaJ.size(); j++) {
                    Nodo no = viejaJ.get(j);
                    Object val = no.execute(table, tree);
                    Primitivo prim = new Primitivo(no.tipo, val, no.line, no.column);
                    nuevaJ.add(prim);
                }
                nuevaI.add(nuevaJ);
            }

            this.valor = nuevaI;
        }
        return this.valor;
    }
}
