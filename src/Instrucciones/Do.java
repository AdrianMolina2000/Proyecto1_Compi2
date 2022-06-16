package Instrucciones;

import Abstract.Nodo;
import Abstract.NodoAST;
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

    //PARA AST
    ArrayList<NodoAST> instrEjec = new ArrayList<>();
    NodoAST nodoMain;

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
        //Creo un nuevo ambito
        Table newtable = new Table(table);

        //ERROR
        if(!this.id.equalsIgnoreCase(id2)){
            String err = "Las etiquetas deben ser nombradas de igual forma  \n";
            Excepcion error = new Excepcion("Semantico", err, line, column);
            tree.excepciones.add(error);
            return error;
        }

        //Verifico que venga un inicio
        if(this.inicio == null){
            String err = "Debe enviar un inicio valido \n";
            Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
            tree.excepciones.add(error);
            return error;
        }

        Object inic = this.inicio.execute(newtable, tree);
        if (inic instanceof Excepcion) {
            return inic;
        }

        //Verifico que venga un fin
        if(this.fin == null){
            String err = "Debe enviar un fin valido \n";
            Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
            tree.excepciones.add(error);
            return error;
        }

        Object fine = this.fin.execute(newtable, tree);
        if (fine instanceof Excepcion) {
            return fine;
        }

        //Verifico que venga un paso
        if(this.paso == null){
            String err = "Debe enviar un paso valido \n";
            Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
            tree.excepciones.add(error);
            return error;
        }

        Object pas = this.paso.execute(newtable, tree);
        if (pas instanceof Excepcion) {
            return pas;
        }

        //Valido que sea del tipo INTEGER
        if(this.inicio.tipo != Tipo.Tipos.INTEGER || this.fin.tipo != Tipo.Tipos.INTEGER || this.paso.tipo != Tipo.Tipos.INTEGER){
            String err = "El inicio["+this.inicio.tipo+"], fin["+this.fin.tipo+"] y paso["+this.paso.tipo+"] deben ser del tipo INTEGER  \n";
            Excepcion error = new Excepcion("Semantico", err, line, column);
            tree.excepciones.add(error);
            return error;
        }

        //Verifico que no sea una lista vacia
        if(this.expresiones.size() == 0){
            String err = "El do no puede venir sin instrucciones \n";
            Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
            tree.excepciones.add(error);
            return error;
        }

        //Esto repetira todas las instrucciones que vienen
        for(int i = (int)inic; i <= (int)fine  ; i += (int)pas){

            Object res;

            //Creo el nodo para el AST
            NodoAST nodoIteracion = new NodoAST("ITERACION");

            //Recorro y ejecuto todas las intrucciones
            for(int j = 0; j<this.expresiones.size(); j++){

                //Ejecuto la instruccion
                res = this.expresiones.get(j).execute(newtable, tree);

                //ERROR
                if(res instanceof Excepcion e){
                    tree.consola.add(e.toString());
                }

                //Verifico si el resultado es del tipo EXIT
                if (res instanceof Exit ex) {

                    //Salgo de este for y detengo la ejecucion
                    if(ex.id.equalsIgnoreCase(this.id)){
                        Simbolo in = table.getVariable(((Asignacion)this.inicio).id);

                        Asignacion nueva = new Asignacion(in.id, new Primitivo(Tipo.Tipos.INTEGER, inic, this.line, this.column), this.line, this.column);
                        nueva.execute(newtable, tree);

                        //Agrego valores para el AST
                        nodoIteracion.agregarHijo(this.expresiones.get(j).getAST());
                        nodoIteracion.agregarHijo(nueva.getAST());

                        //Creo los nodos para el AST
                        nodoMain = new NodoAST("DO");

                        NodoAST nodoI = new NodoAST("INICIO");
                        nodoI.agregarHijo(this.inicio.getAST());
                        nodoMain.agregarHijo(nodoI);

                        NodoAST nodoF = new NodoAST("FIN");
                        nodoF.agregarHijo(this.fin.getAST());
                        nodoMain.agregarHijo(nodoF);

                        NodoAST nodoP = new NodoAST("PASO");
                        nodoP.agregarHijo(this.paso.getAST());
                        nodoMain.agregarHijo(nodoP);

                        NodoAST nodoIns = new NodoAST("INSTRUCCIONES");
                        nodoIns.agregarHijos(instrEjec);
                        nodoMain.agregarHijo(nodoIns);

                        //Detengo la Ejecucion
                        return null;
                    }

                    //Salgo de este for y sigo enviando el EXIT
                    else{
                        //Creo los nodos para el AST
                        nodoMain = new NodoAST("DO");

                        NodoAST nodoI = new NodoAST("INICIO");
                        nodoI.agregarHijo(this.inicio.getAST());
                        nodoMain.agregarHijo(nodoI);

                        NodoAST nodoF = new NodoAST("FIN");
                        nodoF.agregarHijo(this.fin.getAST());
                        nodoMain.agregarHijo(nodoF);

                        NodoAST nodoP = new NodoAST("PASO");
                        nodoP.agregarHijo(this.paso.getAST());
                        nodoMain.agregarHijo(nodoP);

                        NodoAST nodoIns = new NodoAST("INSTRUCCIONES");
                        nodoIns.agregarHijos(instrEjec);
                        nodoMain.agregarHijo(nodoIns);

                        //Detengo la ejecucion
                        return res;
                    }
                }

                //Verifico si el resultado es del tipo Cycle
                else if(res instanceof Cycle ex){

                    //Detengo el for actual
                    if(ex.id.equalsIgnoreCase(this.id)){

                        //Agrego nodo para el AST
                        nodoIteracion.agregarHijo(this.expresiones.get(j).getAST());

                        break;
                    }

                    //Detengo el for Actual y sigo enviando el Cycle
                    else{
                        //Creo los nodos para el AST
                        nodoMain = new NodoAST("DO");

                        NodoAST nodoI = new NodoAST("INICIO");
                        nodoI.agregarHijo(this.inicio.getAST());
                        nodoMain.agregarHijo(nodoI);

                        NodoAST nodoF = new NodoAST("FIN");
                        nodoF.agregarHijo(this.fin.getAST());
                        nodoMain.agregarHijo(nodoF);

                        NodoAST nodoP = new NodoAST("PASO");
                        nodoP.agregarHijo(this.paso.getAST());
                        nodoMain.agregarHijo(nodoP);

                        NodoAST nodoIns = new NodoAST("INSTRUCCIONES");
                        nodoIns.agregarHijos(instrEjec);
                        nodoMain.agregarHijo(nodoIns);

                        //Detengo la ejecucion
                        return res;
                    }
                }

                //Agrego nodo para el AST
                nodoIteracion.agregarHijo(this.expresiones.get(j).getAST());
            }

            //variable creada para simular el paso
            int k;
            if(i + (int)pas <= (int)fine){
                k = i + (int)pas;
            }else{
                k = i;
            }

            //Obtengo la variable de paso de la tabla de simbolos
            Simbolo in = table.getVariable(((Asignacion)this.inicio).id);

            //Creo la asignacion y la ejecuto
            Asignacion nueva = new Asignacion(in.id, new Primitivo(Tipo.Tipos.INTEGER, k, this.line, this.column), this.line, this.column);
            nueva.execute(newtable, tree);

            //Agrego un nodo para el AST
            nodoIteracion.agregarHijo(nueva.getAST());
            instrEjec.add(nodoIteracion);
        }

        //Obtengo la variable de paso de la tabla de simbolos
        Simbolo in = table.getVariable(((Asignacion)this.inicio).id);

        //Creo la asignacion y la ejecuto
        Asignacion nueva = new Asignacion(in.id, new Primitivo(Tipo.Tipos.INTEGER, inic, this.line, this.column), this.line, this.column);
        nueva.execute(newtable, tree);

        //Creo los nodos para el AST
        nodoMain = new NodoAST("DO");

        NodoAST nodoI = new NodoAST("INICIO");
        nodoI.agregarHijo(this.inicio.getAST());
        nodoMain.agregarHijo(nodoI);

        NodoAST nodoF = new NodoAST("FIN");
        nodoF.agregarHijo(this.fin.getAST());
        nodoMain.agregarHijo(nodoF);

        NodoAST nodoP = new NodoAST("PASO");
        nodoP.agregarHijo(this.paso.getAST());
        nodoMain.agregarHijo(nodoP);

        NodoAST nodoIns = new NodoAST("INSTRUCCIONES");
        nodoIns.agregarHijos(instrEjec);
        nodoMain.agregarHijo(nodoIns);

        //Detengo la ejecucion
        return null;
    }

    @Override
    public NodoAST getAST() {
        NodoAST nodo = new NodoAST("DO");

        if(nodoMain != null){
            return nodoMain;
        }

        return nodo;
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