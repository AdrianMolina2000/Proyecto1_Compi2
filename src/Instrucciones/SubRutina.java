package Instrucciones;

import Abstract.Nodo;
import Abstract.NodoAST;
import Other.Excepcion;
import Other.Tipo;
import Symbols.Simbolo;
import Symbols.Table;
import Symbols.Tree;

import java.util.ArrayList;

public class SubRutina extends Nodo {
    String id1;
    String id2;
    ArrayList<String> listaParams1;
    ArrayList<Nodo> listaParams2;
    ArrayList<Nodo> instrucciones;
    public SubRutina(String id1, String id2, ArrayList<String> listaParams1, ArrayList<Nodo> listaParams2, ArrayList<Nodo> instrucciones, int line, int column) {
        super(null, line, column);
        this.id1 = id1;
        this.id2 = id2;
        this.listaParams1 = listaParams1;
        this.listaParams2 = listaParams2;
        this.instrucciones = instrucciones;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        if(!id1.equalsIgnoreCase(id2)){
            Excepcion error = new Excepcion("Semantico", "Los nombres de apertura y cierre deben ser iguales \n",
                    this.line, this.column);
            tree.excepciones.add(error);
            return error;
        }

        if(this.listaParams1.size() != this.listaParams2.size()){
            Excepcion error = new Excepcion("Semantico", "Los parametros estan incompletos \n",
                    this.line, this.column);
            tree.excepciones.add(error);
            return error;
        }

        if (tree.getMetodo(this.id1) == null) {
            this.tipo = Tipo.Tipos.METODO;

            for(int i = 0; i<listaParams2.size(); i++){
                Object decla = listaParams2.get(i);
                if(decla instanceof Declaracion dec){
                    if(!dec.id.equalsIgnoreCase(listaParams1.get(i))){
                        String err = "Los parametros deben tener el mismo nombre ["+dec.id+"] ["+listaParams1.get(i)+"] \n";
                        Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                        tree.excepciones.add(error);
                        return error;
                    }
                }else if(decla instanceof DeclaracionArray dec){
                    if(!dec.id.equalsIgnoreCase(listaParams1.get(i))){
                        String err = "Los parametros deben tener el mismo nombre ["+dec.id+"] ["+listaParams1.get(i)+"] \n";
                        Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                        tree.excepciones.add(error);
                        return error;
                    }
                }
            }

            ArrayList<ArrayList<Nodo>> metodoValor = new ArrayList<>();

            metodoValor.add(listaParams2);
            metodoValor.add(instrucciones);

            Simbolo metodo = new Simbolo(new Tipo(Tipo.Tipos.VOID), new Tipo(Tipo.Tipos.METODO), this.id1, metodoValor, this.line, this.column, table);
            tree.setMetodo(metodo);
            return null;
        } else {
            String err = "La subrutina [" +this.id1+ "] ya ha sido creado con anterioridad";
            Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
            tree.excepciones.add(error);
            return error;
        }
    }

    @Override
    public NodoAST getAST() {
        NodoAST nodo = new NodoAST("SUBRUTINA");
        nodo.agregarHijo(new NodoAST(id1));
        if(listaParams1.size() != 0){
            NodoAST nodoParam = new NodoAST("PARAMETROS");
            for(String param: listaParams1){
                nodoParam.agregarHijo(param);
            }
            nodo.agregarHijo(nodoParam);
        }
        return nodo;
    }
}
