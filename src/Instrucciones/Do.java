package Instrucciones;

import Abstract.Nodo;
import Expresiones.Primitivo;
import Other.Excepcion;
import Other.Tipo;
import Symbols.Simbolo;
import Symbols.Table;
import Symbols.Tree;

import java.util.ArrayList;

public class Do extends Nodo {
    Nodo inicio;
    Nodo fin;
    Nodo paso;
    ArrayList<Nodo> expresiones;
    String id;
    String id2;


    public Do(String id, String id2, Nodo inicio, Nodo fin, Nodo paso, ArrayList<Nodo> expresiones, int line, int column) {
        super(null, line, column);
        this.inicio = inicio;
        this.fin = fin;
        this.paso = paso;
        this.expresiones = expresiones;
        this.id = id;
        this.id2 = id2;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        if(!this.id.equalsIgnoreCase(id2)){
            String err = "Las etiquetas deben ser nombradas de igual forma  \n";
            Excepcion error = new Excepcion("Semantico", err, line, column);
            tree.excepciones.add(error);
            tree.consola.add(error.toString());
            return error;
        }

        Table newtable = new Table(table);

        Object inic = this.inicio.execute(newtable, tree);
        Object fine = this.fin.execute(newtable, tree);
        Object pas = this.paso.execute(newtable, tree);
        boolean cont = false;



        if(this.inicio.tipo != Tipo.Tipos.INTEGER || this.fin.tipo != Tipo.Tipos.INTEGER || this.paso.tipo != Tipo.Tipos.INTEGER){
            String err = "El inicio["+this.inicio.tipo+"], fin["+this.fin.tipo+"] y paso["+this.paso.tipo+"] deben ser del tipo INTEGER  \n";
            Excepcion error = new Excepcion("Semantico", err, line, column);
            tree.excepciones.add(error);
            tree.consola.add(error.toString());
            return error;
        }

        for(int i = (int)inic; i <= (int)fine  ; i += (int)pas){

            Object res = null;
            for(int j = 0; j<this.expresiones.size(); j++){
                res = this.expresiones.get(j).execute(newtable, tree);
                if (res instanceof Exit ex) {
                    if(ex.id.equalsIgnoreCase(this.id)){
                        Simbolo in = table.getVariable(((Asignacion)this.inicio).id);

                        Asignacion nueva = new Asignacion(in.id, new Primitivo(Tipo.Tipos.INTEGER, inic, this.line, this.column), this.line, this.column);
                        nueva.execute(newtable, tree);

                        return null;
                    }else{
                        return res;
                    }
                }else if(res instanceof Cycle ex){
                    if(ex.id.equalsIgnoreCase(this.id)){
                        cont = true;
                        break;
                    }else{
                        return res;
                    }
                }
            }
            int k;
            if(i + (int)pas <= (int)fine){
                k = i + (int)pas;
            }else{
                k = i;
            }
            Simbolo in = table.getVariable(((Asignacion)this.inicio).id);

            Asignacion nueva = new Asignacion(in.id, new Primitivo(Tipo.Tipos.INTEGER, k, this.line, this.column), this.line, this.column);
            nueva.execute(newtable, tree);

        }

        Simbolo in = table.getVariable(((Asignacion)this.inicio).id);

        Asignacion nueva = new Asignacion(in.id, new Primitivo(Tipo.Tipos.INTEGER, inic, this.line, this.column), this.line, this.column);
        nueva.execute(newtable, tree);

        return null;
    }
}

/*
program myProgram
implicit none

    integer :: i , j
    outer_loop : do i = 1 , 10 , 1
        inner_loop : do j = 1 , 10 , 1
            if ((j + i) > 10) then  !imprime solo la pareja de números i, j
					                !que suman más de 10
                cycle inner_loop        !va a la siguiete iteración del ciclo “outer_loop”
            end if
            print *, "I=" , i , "J=" , j , "Sum=" , j + i
        end do inner_loop
    end do outer_loop
end program myProgram
 */