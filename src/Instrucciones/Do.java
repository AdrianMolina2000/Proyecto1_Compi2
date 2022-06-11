package Instrucciones;

import Abstract.Nodo;
import Expresiones.Primitivo;
import Other.Excepcion;
import Other.Tipo;
import Symbols.Table;
import Symbols.Tree;

import java.util.ArrayList;

public class Do extends Nodo {
    Nodo inicio;
    Nodo fin;
    Nodo paso;
    ArrayList<Nodo> expresiones;


    public Do(Nodo inicio, Nodo fin, Nodo paso, ArrayList<Nodo> expresiones, int line, int column) {
        super(null, line, column);
        this.inicio = inicio;
        this.fin = fin;
        this.paso = paso;
        this.expresiones = expresiones;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        Table newtable = new Table(table);

        Object inic = this.inicio.execute(newtable, tree);
        Object fine = this.fin.execute(newtable, tree);
        Object pas = this.paso.execute(newtable, tree);




        if(this.inicio.tipo != Tipo.Tipos.INTEGER || this.fin.tipo != Tipo.Tipos.INTEGER || this.paso.tipo != Tipo.Tipos.INTEGER){
            String err = "El inicio["+this.inicio.tipo+"], fin["+this.fin.tipo+"] y paso["+this.paso.tipo+"] deben ser del tipo INTEGER  \n";
            Excepcion error = new Excepcion("Semantico", err, line, column);
            tree.excepciones.add(error);
            tree.consola.add(error.toString());
            return error;
        }

        for(int i = (int)inic; i<(int)fine; i += (int)pas){

            for(int j = 0; j<this.expresiones.size(); j++){

                Object res = this.expresiones.get(j).execute(newtable, tree);
                //            if (res instanceof Continue) {
//                break;
//            } else if (res instanceof Break || res instanceof Retorno) {
//                return;
//            }

            }
            int k;
            if(i + (int)pas < (int)fine){
                k = i + (int)pas;
            }else{
                k = i;
            }
            ((Asignacion)this.inicio).valor = new Primitivo(Tipo.Tipos.INTEGER, k, this.line, this.column);
            ((Asignacion)this.inicio).execute(newtable, tree);
        }

        ((Asignacion)this.inicio).valor = new Primitivo(Tipo.Tipos.INTEGER, (int)inic, this.line, this.column);
        ((Asignacion)this.inicio).execute(newtable, tree);
        return null;
    }
}
