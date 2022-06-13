package Instrucciones;

import Abstract.Nodo;
import Other.Excepcion;
import Other.Tipo;
import Symbols.Simbolo;
import Symbols.Table;
import Symbols.Tree;

import java.util.ArrayList;

public class Funcion extends Nodo {
    String id1;
    String id2;
    String id3;
    ArrayList<String> listaParams1;
    ArrayList<Nodo> listaParams2;
    ArrayList<Nodo> retorno;
    ArrayList<Nodo> instrucciones;

    public Funcion(String id1, String id2, String id3, ArrayList<String> listaParams1, ArrayList<Nodo> listaParams2, ArrayList<Nodo> instrucciones, int line, int column) {
        super(null, line, column);
        this.id1 = id1;
        this.id2 = id2;
        this.id3 = id3;
        this.listaParams1 = listaParams1;
        this.listaParams2 = listaParams2;
        this.instrucciones = instrucciones;
        this.retorno = new ArrayList<>();
    }

    @Override
    public Object execute(Table table, Tree tree) {
        if(!id1.equalsIgnoreCase(id2)){
            Excepcion error = new Excepcion("Semantico", "Los nombres de apertura y cierre deben ser iguales \n",
                    this.line, this.column);
            tree.consola.add(error.toString());
            tree.excepciones.add(error);
            return error;
        }

        if(this.listaParams1.size() != this.listaParams2.size()){
            Excepcion error = new Excepcion("Semantico", "Los parametros estan incompletos \n",
                    this.line, this.column);
            tree.consola.add(error.toString());
            tree.excepciones.add(error);
            return error;
        }

        if (table.getVariable(this.id1) == null) {
            this.tipo = Tipo.Tipos.FUNCION;

            for(int i = 0; i<listaParams2.size(); i++){
                Object decla = listaParams2.get(i);
                if(decla instanceof Declaracion dec){
                    if(!dec.id.equalsIgnoreCase(listaParams1.get(i))){
                        String err = "Los parametros deben tener el mismo nombre ["+dec.id+"] ["+listaParams1.get(i)+"] \n";
                        Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                        tree.consola.add(error.toString());
                        tree.excepciones.add(error);
                        return error;
                    }
                }else if(decla instanceof DeclaracionArray dec){
                    if(!dec.id.equalsIgnoreCase(listaParams1.get(i))){
                        String err = "Los parametros deben tener el mismo nombre ["+dec.id+"] ["+listaParams1.get(i)+"] \n";
                        Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                        tree.consola.add(error.toString());
                        tree.excepciones.add(error);
                        return error;
                    }
                }
            }

            boolean exist = false;
            boolean listaD = false;
            int elim = 0;
            int elimL = 0;
            for(int i = 0; i<instrucciones.size(); i++){
                elim = i;
                if(instrucciones.get(i) instanceof ListaDeclaraciones lisdec){
                    for(int j = 0; j<lisdec.declaraciones.size(); j++){
                        elimL = j;
                        if(lisdec.declaraciones.get(j) instanceof Declaracion dec){
                            if(this.id3.equalsIgnoreCase(dec.id)){
                                listaD = true;
                                break;
                            }
                        }
                    }
                    if(listaD){break;}
                }else if(instrucciones.get(i) instanceof DeclaracionArray decA){
                    if(this.id3.equalsIgnoreCase(decA.id)){
                        exist = true;
                        break;
                    }
                }
            }

            if(exist){
                Nodo eli = instrucciones.remove(elim);
                this.tipo = eli.tipo;
                retorno.add(eli);
            }else if(listaD){
                ListaDeclaraciones eli = (ListaDeclaraciones) instrucciones.get(elim);
                if(eli.declaraciones.size() == 1){
                    retorno.add(eli.declaraciones.remove(elimL));
                    instrucciones.remove(elim);
                }else{
                    retorno.add(eli.declaraciones.remove(elimL));
                }
            }else{
                String err = "La variable de retorno no ha sido encontrada ["+this.id3+"] \n";
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.consola.add(error.toString());
                tree.excepciones.add(error);
                return error;
            }

            ArrayList<ArrayList<Nodo>> metodoValor = new ArrayList<>();

            metodoValor.add(listaParams2);
            metodoValor.add(instrucciones);
            metodoValor.add(retorno);

            Simbolo metodo = new Simbolo(new Tipo(this.tipo), new Tipo(Tipo.Tipos.FUNCION), this.id1, metodoValor, this.line, this.column, table);
            table.setVariable(metodo);
            return null;

        }else {
            String err = "La subrutina [" +this.id1+ "] ya ha sido creado con anterioridad";
            Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
            tree.excepciones.add(error);
            tree.consola.add(error.toString());
            return error;
        }
    }
}
