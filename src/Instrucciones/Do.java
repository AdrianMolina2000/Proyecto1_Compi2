package Instrucciones;

import Abstract.Nodo;
import Abstract.NodoAST;
import Expresiones.Primitivo;
import Gramatica.Globales;
import Other.Excepcion;
import Other.Tipo;
import Symbols.C3D;
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

    //Para C3D
    Table tableC3D;

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
        tableC3D = table;

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
            Table newtable2 = new Table(newtable);
            Object res;

            //Creo el nodo para el AST
            NodoAST nodoIteracion = new NodoAST("ITERACION");

            //Recorro y ejecuto todas las intrucciones
            for(int j = 0; j<this.expresiones.size(); j++){

                //Ejecuto la instruccion
                res = this.expresiones.get(j).execute(newtable2, tree);

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
                        nueva.execute(newtable2, tree);

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
            nueva.execute(newtable2, tree);

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

        //Para C3D
        this.isC3D = true;

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

    @Override
    public void get3D() {
        if(Globales.gen == null){
            C3D genAux = new C3D();
            Globales.gen = genAux.getInstance();
        }

        if(this.isC3D){
            Globales.gen.addComment("SENTENCIA DO");

            this.inicio.get3D();
            this.paso.get3D();
            this.fin.get3D();

            Simbolo variable = this.tableC3D.getVariable(((Asignacion)this.inicio).id);

            //Creo los labels para for
            String label0 = Globales.gen.newLabel();
            String label1 = Globales.gen.newLabel();
            String label2 = Globales.gen.newLabel();
            String label3 = Globales.gen.newLabel();

            //Guardo el valor original
            Globales.gen.addComment("Guardo el valor original");
            String pos0 = Globales.gen.addTemp();
            String temp0 = Globales.gen.addTemp();

            String posVar = String.valueOf(variable.pos);
            Globales.gen.addExp(pos0, "0", "+", posVar);
            Globales.gen.getStack(temp0, pos0);

            //Inicia el ciclo
            Globales.gen.addComment("Inicia el Ciclo");
            Globales.gen.addLabel(label0);

            //Accedo a la variable de inicio
            String pos = Globales.gen.addTemp();
            String temp = Globales.gen.addTemp();

            Globales.gen.addExp(pos, "0", "+", posVar);
            Globales.gen.getStack(temp, pos);

            //Hago la validacion
            Globales.gen.addComment("Hago la validacion del do");
            Globales.gen.newIF(temp, "<=", this.fin.valor3D, label1);
            Globales.gen.addGoto(label2);

            Globales.gen.addComment("Inicio de instrucciones");
            Globales.gen.addLabel(label1);

            for(Nodo instruccion: this.expresiones){
                instruccion.get3D();
            }

            Globales.gen.addComment("Final de instrucciones");
            Globales.gen.addLabel(label3);

            //Accedo a la variable de inicio
            pos = Globales.gen.addTemp();
            temp = Globales.gen.addTemp();

            Globales.gen.addExp(pos, "0", "+", posVar);
            Globales.gen.getStack(temp, pos);

            //Le agrego el paso
            Globales.gen.addComment("Incremento la variable de inicio");
            String tvar = Globales.gen.addTemp();
            Globales.gen.addExp(tvar, temp, "+" , this.paso.valor3D);
            Globales.gen.setStack(pos, tvar);

            //Regresamos a validar
            Globales.gen.addComment("Regreso a validar");
            Globales.gen.addGoto(label0);
            Globales.gen.addComment("Termino las iteraciones del do");
            Globales.gen.addLabel(label2);

            //Le coloco el valor original a mi variable
            Globales.gen.addComment("Coloco el valor original");
            String posF = Globales.gen.addTemp();

            Globales.gen.addExp(posF, "0", "+", posVar);

            Globales.gen.setStack(posF, temp0);

        }
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