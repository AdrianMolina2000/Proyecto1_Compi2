package Expresiones;

import Abstract.Nodo;
import Abstract.NodoAST;
import Gramatica.Globales;
import Other.Excepcion;
import Other.Tipo;
import Symbols.C3D;
import Symbols.Table;
import Symbols.Tree;

public class Relacional extends Nodo {
    Nodo operadorIzq;
    Nodo operadorDer;
    String operador;

    //Para el AST
    NodoAST nodoOp;
    NodoAST nodoIzq;
    NodoAST nodoDer;

    //Para C3D
    Object resultadoDer;

    public Relacional(Nodo operadorIzq, Nodo operadorDer, String operador, int line, int column) {
        super(null, line, column);
        this.operadorIzq = operadorIzq;
        this.operadorDer = operadorDer;
        this.operador = operador;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        //Verifico que ambos operadores existan
        if(this.operadorIzq == null){
            String err = "No existe el operador izquierdo";
            Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
            tree.excepciones.add(error);
            return error;
        }

        if(this.operadorDer == null){
            String err = "No existe el operador derecho";
            Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
            tree.excepciones.add(error);
            return error;
        }

        Object resultadoIzq = this.operadorIzq.execute(table, tree);
        if (resultadoIzq instanceof Excepcion) {
            return resultadoIzq;
        }

        Object resultadoDerecho = this.operadorDer.execute(table, tree);
        if (resultadoDerecho instanceof Excepcion) {
           return resultadoDerecho;
        }

        this.resultadoDer = resultadoDerecho;

        //IGUAL A
        if (this.operador.equalsIgnoreCase("==") || this.operador.equalsIgnoreCase(".eq.")) {
            //VERIFICO TIPOS
            if(this.operadorIzq.tipo == this.operadorDer.tipo) {
                //Le coloco tipo a esta clase
                this.tipo = Tipo.Tipos.LOGICAL;

                //Creo los nodos que usare en el AST
                nodoOp = new NodoAST("==");
                nodoIzq = this.operadorIzq.getAST();
                nodoDer = this.operadorDer.getAST();

                //Retorno la igualacion de los valores
                if(this.operadorIzq.tipo == Tipo.Tipos.STRING || this.operadorIzq.tipo == Tipo.Tipos.COMPLEX){

                    //Termina la ejecucion
                    return String.valueOf(resultadoIzq).equalsIgnoreCase(String.valueOf(resultadoDerecho));

                }else if(this.operadorIzq.tipo == Tipo.Tipos.CHARACTER) {
                    //Para C3D
                    this.isC3D = true;

                    //Termino ejecucion
                    return String.valueOf(resultadoIzq).equalsIgnoreCase(String.valueOf(resultadoDerecho));
                }else if(this.operadorIzq.tipo == Tipo.Tipos.INTEGER || this.operadorIzq.tipo == Tipo.Tipos.REAL){
                    //Para C3D
                    this.isC3D = true;

                    //Termino ejecucion
                    return resultadoIzq.equals(resultadoDerecho);
                }else if(this.operadorIzq.tipo == Tipo.Tipos.LOGICAL){
                    //Para C3D
                    this.isC3D = true;

                    //Termino ejecucion
                    return resultadoIzq == resultadoDerecho;
                }else{

                    //Termino ejecucion
                    return resultadoIzq == resultadoDerecho;
                }
            }

            //TIPOS DIFERENTES = ERROR
            else {
                String err = "No se pueden Igualar los tipos [" + this.operadorIzq.tipo + "] y [" + this.operadorDer.tipo + "] \n";
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.excepciones.add(error);
                //tree.consola.add(error.toString());
                return error;
            }
        }

        //DIFERENTE DE
        else if (this.operador.equalsIgnoreCase("/=")|| this.operador.equalsIgnoreCase(".ne.")){
            //VERIFICO TIPOS
            if(this.operadorIzq.tipo == this.operadorDer.tipo) {

                //Le coloco tipo a esta clase
                this.tipo = Tipo.Tipos.LOGICAL;

                //Creo los nodos que usare en el AST
                nodoOp = new NodoAST("!=");
                nodoIzq = this.operadorIzq.getAST();
                nodoDer = this.operadorDer.getAST();

                //Retorno la Des igualacion de los valores
                if(this.operadorIzq.tipo == Tipo.Tipos.STRING || this.operadorIzq.tipo == Tipo.Tipos.COMPLEX){

                    //Termina la ejecucion
                    return !String.valueOf(resultadoIzq).equalsIgnoreCase(String.valueOf(resultadoDerecho));

                }else if(this.operadorIzq.tipo == Tipo.Tipos.CHARACTER) {
                    //Para C3D
                    this.isC3D = true;

                    //Termino ejecucion
                    return !String.valueOf(resultadoIzq).equalsIgnoreCase(String.valueOf(resultadoDerecho));
                }else if(this.operadorIzq.tipo == Tipo.Tipos.INTEGER || this.operadorIzq.tipo == Tipo.Tipos.REAL){
                    //Para C3D
                    this.isC3D = true;

                    //Termino ejecucion
                    return !resultadoIzq.equals(resultadoDerecho);
                }else if(this.operadorIzq.tipo == Tipo.Tipos.LOGICAL){
                    //Para C3D
                    this.isC3D = true;

                    //Termino ejecucion
                    return resultadoIzq != resultadoDerecho;
                }else{
                    //Termino ejecucion
                    return resultadoIzq != resultadoDerecho;
                }
            }

            //TIPOS DIFERENTES = ERROR
            else {
                String err = "No se pueden DesIgualar los tipos [" + this.operadorIzq.tipo + "] y [" + this.operadorDer.tipo + "] \n";
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.excepciones.add(error);
                //tree.consola.add(error.toString());
                return error;
            }
        }

        //MAYOR A
        else if (this.operador.equalsIgnoreCase(">")|| this.operador.equalsIgnoreCase(".gt.")){
            String err = "No se pueden usar > los tipos [" + this.operadorIzq.tipo + "] y [" + this.operadorDer.tipo + "] \n";

            //INTEGER >
            if(this.operadorIzq.tipo == Tipo.Tipos.INTEGER) {

                //INTEGER > INTEGER
                if (this.operadorDer.tipo == Tipo.Tipos.INTEGER) {
                    //Le coloco tipo a esta clase
                    this.tipo = Tipo.Tipos.LOGICAL;

                    //Creo los nodos que usare en el AST
                    nodoOp = new NodoAST(">");
                    nodoIzq = this.operadorIzq.getAST();
                    nodoDer = this.operadorDer.getAST();

                    //Para C3D
                    this.isC3D = true;

                    //Retorno el resultado de los valores
                    return (int)resultadoIzq > (int)resultadoDerecho;
                }

                //INTEGER > REAL
                else if (this.operadorDer.tipo == Tipo.Tipos.REAL) {
                    //Le coloco tipo a esta clase
                    this.tipo = Tipo.Tipos.LOGICAL;

                    //Creo los nodos que usare en el AST
                    nodoOp = new NodoAST(">");
                    nodoIzq = this.operadorIzq.getAST();
                    nodoDer = this.operadorDer.getAST();

                    //Para C3D
                    this.isC3D = true;

                    //Retorno el resultado de los valores
                    return (int)resultadoIzq > (double)resultadoDerecho;
                }

                //INTEGER > OTHER = ERROR
                else {
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    //tree.consola.add(error.toString());
                    return error;
                }
            }

            //REAL >
            else if (this.operadorIzq.tipo == Tipo.Tipos.REAL) {

                //REAL > INTEGER
                if(this.operadorDer.tipo == Tipo.Tipos.INTEGER) {
                    //Le coloco tipo a esta clase
                    this.tipo = Tipo.Tipos.LOGICAL;

                    //Creo los nodos que usare en el AST
                    nodoOp = new NodoAST(">");
                    nodoIzq = this.operadorIzq.getAST();
                    nodoDer = this.operadorDer.getAST();

                    //Para C3D
                    this.isC3D = true;

                    //Retorno el resultado de los valores
                    return (double)resultadoIzq > (int)resultadoDerecho;
                }

                //REAL > REAL
                else if (this.operadorDer.tipo == Tipo.Tipos.REAL) {
                    //Le coloco tipo a esta clase
                    this.tipo = Tipo.Tipos.LOGICAL;

                    //Creo los nodos que usare en el AST
                    nodoOp = new NodoAST(">");
                    nodoIzq = this.operadorIzq.getAST();
                    nodoDer = this.operadorDer.getAST();

                    //Para C3D
                    this.isC3D = true;

                    //Retorno el resultado de los valores
                    return (double)resultadoIzq > (double)resultadoDerecho;
                }

                //REAL > OTHER = ERROR
                else {
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    //tree.consola.add(error.toString());
                    return error;
                }
            }

            //OTHER > OTHER = ERROR
            else {
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.excepciones.add(error);
                //tree.consola.add(error.toString());
                return error;
            }
        }

        //MAYOR O IGUAL A
        else if (this.operador.equalsIgnoreCase(">=")|| this.operador.equalsIgnoreCase(".ge.")){
            String err = "No se pueden usar >= los tipos [" + this.operadorIzq.tipo + "] y [" + this.operadorDer.tipo + "] \n";

            //INTEGER >=
            if(this.operadorIzq.tipo == Tipo.Tipos.INTEGER) {

                //INTEGER >= INTEGER
                if (this.operadorDer.tipo == Tipo.Tipos.INTEGER) {
                    //Le coloco tipo a esta clase
                    this.tipo = Tipo.Tipos.LOGICAL;

                    //Creo los nodos que usare en el AST
                    nodoOp = new NodoAST(">=");
                    nodoIzq = this.operadorIzq.getAST();
                    nodoDer = this.operadorDer.getAST();

                    //Para C3D
                    this.isC3D = true;

                    //Retorno el resultado de los valores
                    return (int)resultadoIzq >= (int)resultadoDerecho;
                }

                //INTEGER >= REAL
                else if (this.operadorDer.tipo == Tipo.Tipos.REAL) {
                    //Le coloco tipo a esta clase
                    this.tipo = Tipo.Tipos.LOGICAL;

                    //Creo los nodos que usare en el AST
                    nodoOp = new NodoAST(">=");
                    nodoIzq = this.operadorIzq.getAST();
                    nodoDer = this.operadorDer.getAST();

                    //Para C3D
                    this.isC3D = true;

                    //Retorno el resultado de los valores
                    return (int)resultadoIzq >= (double)resultadoDerecho;
                }

                //INTEGER >= OTHER = ERROR
                else {
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    //tree.consola.add(error.toString());
                    return error;
                }
            }

            //REAL >=
            else if (this.operadorIzq.tipo == Tipo.Tipos.REAL) {

                //REAL >= INTEGER
                if(this.operadorDer.tipo == Tipo.Tipos.INTEGER) {
                    //Le coloco tipo a esta clase
                    this.tipo = Tipo.Tipos.LOGICAL;

                    //Creo los nodos que usare en el AST
                    nodoOp = new NodoAST(">=");
                    nodoIzq = this.operadorIzq.getAST();
                    nodoDer = this.operadorDer.getAST();

                    //Para C3D
                    this.isC3D = true;

                    //Retorno el resultado de los valores
                    return (double)resultadoIzq >= (int)resultadoDerecho;
                }

                //REAL >= REAL
                else if (this.operadorDer.tipo == Tipo.Tipos.REAL) {
                    //Le coloco tipo a esta clase
                    this.tipo = Tipo.Tipos.LOGICAL;

                    //Creo los nodos que usare en el AST
                    nodoOp = new NodoAST(">=");
                    nodoIzq = this.operadorIzq.getAST();
                    nodoDer = this.operadorDer.getAST();

                    //Para C3D
                    this.isC3D = true;

                    //Retorno el resultado de los valores
                    return (double)resultadoIzq >= (double)resultadoDerecho;
                }

                //REAL >= REAL = ERROR
                else {
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    //tree.consola.add(error.toString());
                    return error;
                }
            }

            //OTHER >= OTHER = ERROR
            else {
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.excepciones.add(error);
                //tree.consola.add(error.toString());
                return error;
            }
        }

        //MENOR QUE
        else if (this.operador.equalsIgnoreCase("<")|| this.operador.equalsIgnoreCase(".lt.")){
            String err = "No se pueden usar >= los tipos [" + this.operadorIzq.tipo + "] y [" + this.operadorDer.tipo + "] \n";

            //INTEGER <
            if(this.operadorIzq.tipo == Tipo.Tipos.INTEGER) {

                //INTEGER < INTEGER
                if (this.operadorDer.tipo == Tipo.Tipos.INTEGER) {
                    //Le coloco tipo a esta clase
                    this.tipo = Tipo.Tipos.LOGICAL;

                    //Creo los nodos que usare en el AST
                    nodoOp = new NodoAST("<");
                    nodoIzq = this.operadorIzq.getAST();
                    nodoDer = this.operadorDer.getAST();

                    //Para C3D
                    this.isC3D = true;

                    //Retorno el resultado de los valores
                    return (int)resultadoIzq < (int)resultadoDerecho;
                }

                //INTEGER < REAL
                else if (this.operadorDer.tipo == Tipo.Tipos.REAL) {
                    //Le coloco tipo a esta clase
                    this.tipo = Tipo.Tipos.LOGICAL;

                    //Creo los nodos que usare en el AST
                    nodoOp = new NodoAST("<");
                    nodoIzq = this.operadorIzq.getAST();
                    nodoDer = this.operadorDer.getAST();

                    //Para C3D
                    this.isC3D = true;

                    //Retorno el resultado de los valores
                    return (int)resultadoIzq < (double)resultadoDerecho;
                }

                //INTEGER < OTHER = ERROR
                else {
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    //tree.consola.add(error.toString());
                    return error;
                }
            }

            //REAL <
            else if (this.operadorIzq.tipo == Tipo.Tipos.REAL) {

                //REAL < INTEGER
                if(this.operadorDer.tipo == Tipo.Tipos.INTEGER) {
                    //Le coloco tipo a esta clase
                    this.tipo = Tipo.Tipos.LOGICAL;

                    //Creo los nodos que usare en el AST
                    nodoOp = new NodoAST("<");
                    nodoIzq = this.operadorIzq.getAST();
                    nodoDer = this.operadorDer.getAST();

                    //Para C3D
                    this.isC3D = true;

                    //Retorno el resultado de los valores
                    return (double)resultadoIzq < (int)resultadoDerecho;
                }

                //REAL < REAL
                else if (this.operadorDer.tipo == Tipo.Tipos.REAL) {
                    //Le coloco tipo a esta clase
                    this.tipo = Tipo.Tipos.LOGICAL;

                    //Creo los nodos que usare en el AST
                    nodoOp = new NodoAST("<");
                    nodoIzq = this.operadorIzq.getAST();
                    nodoDer = this.operadorDer.getAST();

                    //Para C3D
                    this.isC3D = true;

                    //Retorno el resultado de los valores
                    return (double)resultadoIzq < (double)resultadoDerecho;
                }

                //REAL < OTHER = ERROR
                else {
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    //tree.consola.add(error.toString());
                    return error;
                }
            }

            //OTHER < OTHER = ERROR
            else {
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.excepciones.add(error);
                //tree.consola.add(error.toString());
                return error;
            }
        }

        //MENOR O IGUAL QUE
        else if (this.operador.equalsIgnoreCase("<=")|| this.operador.equalsIgnoreCase(".le.")){
            String err = "No se pueden usar >= los tipos [" + this.operadorIzq.tipo + "] y [" + this.operadorDer.tipo + "] \n";

            //INTEGER <=
            if(this.operadorIzq.tipo == Tipo.Tipos.INTEGER) {

                //INTEGER <= INTEGER
                if (this.operadorDer.tipo == Tipo.Tipos.INTEGER) {
                    //Le coloco tipo a esta clase
                    this.tipo = Tipo.Tipos.LOGICAL;

                    //Creo los nodos que usare en el AST
                    nodoOp = new NodoAST("<=");
                    nodoIzq = this.operadorIzq.getAST();
                    nodoDer = this.operadorDer.getAST();

                    //Para C3D
                    this.isC3D = true;

                    //Retorno el resultado de los valores
                    return (int)resultadoIzq <= (int)resultadoDerecho;
                }

                //INTEGER <= REAL
                else if (this.operadorDer.tipo == Tipo.Tipos.REAL) {
                    //Le coloco tipo a esta clase
                    this.tipo = Tipo.Tipos.LOGICAL;

                    //Creo los nodos que usare en el AST
                    nodoOp = new NodoAST("<=");
                    nodoIzq = this.operadorIzq.getAST();
                    nodoDer = this.operadorDer.getAST();

                    //Para C3D
                    this.isC3D = true;

                    //Retorno el resultado de los valores
                    return (int)resultadoIzq <= (double)resultadoDerecho;
                }

                //INTEGER <= OTHER = ERROR
                else {
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    //tree.consola.add(error.toString());
                    return error;
                }
            }

            //REAL <=
            else if (this.operadorIzq.tipo == Tipo.Tipos.REAL) {

                //REAL <= INTEGER
                if(this.operadorDer.tipo == Tipo.Tipos.INTEGER) {
                    //Le coloco tipo a esta clase
                    this.tipo = Tipo.Tipos.LOGICAL;

                    //Creo los nodos que usare en el AST
                    nodoOp = new NodoAST("<=");
                    nodoIzq = this.operadorIzq.getAST();
                    nodoDer = this.operadorDer.getAST();

                    //Para C3D
                    this.isC3D = true;

                    //Retorno el resultado de los valores
                    return (double)resultadoIzq <= (int)resultadoDerecho;
                }

                //REAL <= REAL
                else if (this.operadorDer.tipo == Tipo.Tipos.REAL) {
                    //Le coloco tipo a esta clase
                    this.tipo = Tipo.Tipos.LOGICAL;

                    //Creo los nodos que usare en el AST
                    nodoOp = new NodoAST("<=");
                    nodoIzq = this.operadorIzq.getAST();
                    nodoDer = this.operadorDer.getAST();

                    //Para C3D
                    this.isC3D = true;

                    //Retorno el resultado de los valores
                    return (double)resultadoIzq <= (double)resultadoDerecho;
                }

                //REAL <= OTHER = ERROR
                else {
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    //tree.consola.add(error.toString());
                    return error;
                }
            }

            //OTHER <= OTHER = ERROR
            else {
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.excepciones.add(error);
                //tree.consola.add(error.toString());
                return error;
            }
        }

        //OTHER
        else{
            String err = "Error, Operador desconocido ["+this.operador+"] \n";
            Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
            tree.excepciones.add(error);
            tree.consola.add(error.toString());
            return error;
        }
    }

    @Override
    public NodoAST getAST() {
        NodoAST nodo = new NodoAST("RELACIONAL");

        if(nodoOp != null && nodoDer != null && nodoIzq != null){
             nodoOp.agregarHijo(nodoIzq);
             nodoOp.agregarHijo(nodoDer);
             return nodoOp;
        }

        return nodo;
    }

    @Override
    public void get3D() {
        if(Globales.gen == null){
            C3D genAux = new C3D();
            Globales.gen = genAux.getInstance();
        }

        if(isC3D) {
            Globales.gen.addComment("Relacional");

            if(this.ev == null){
                this.ev = Globales.gen.newLabel();
            }
            if(this.ef == null){
                this.ef = Globales.gen.newLabel();
            }

            this.operadorIzq.get3D();
            this.operadorDer.get3D();

            if (this.operador.equalsIgnoreCase("==") || this.operador.equalsIgnoreCase(".eq.")) {
                if (this.operadorIzq.tipo == Tipo.Tipos.CHARACTER || this.operadorIzq.tipo == Tipo.Tipos.INTEGER || this.operadorIzq.tipo == Tipo.Tipos.REAL) {
                    Globales.gen.newIF(this.operadorIzq.valor3D, "==", this.operadorDer.valor3D, this.ev);
                    Globales.gen.addGoto(this.ef);

                    this.valor3D = "";
                    this.tmp = false;
                } else if (this.operadorIzq.tipo == Tipo.Tipos.LOGICAL) {
                    String gote = Globales.gen.newLabel();
                    String tmp1 = Globales.gen.addTemp();

                    Globales.gen.addLabel(operadorIzq.ev);
                    Globales.gen.addExp(tmp1, "1", "", "");
                    Globales.gen.addGoto(gote);

                    Globales.gen.addLabel(operadorIzq.ef);
                    Globales.gen.addExp(tmp1, "0", "", "");

                    Globales.gen.addLabel(gote);

                    //Verificando el false derecho
                    String salida = Globales.gen.newLabel();
                    String temp2 = Globales.gen.addTemp();

                    if ((boolean) resultadoDer) {
                        Globales.gen.addLabel(operadorDer.ev);

                        Globales.gen.addExp(temp2, "1", "", "");
                        Globales.gen.addGoto(salida);

                        Globales.gen.addLabel(operadorDer.ef);
                        Globales.gen.addExp(temp2, "0", "", "");

                        Globales.gen.addLabel(salida);
                    } else {
                        Globales.gen.addLabel(operadorDer.ev);

                        Globales.gen.addExp(temp2, "0", "", "");
                        Globales.gen.addGoto(salida);

                        Globales.gen.addLabel(operadorDer.ef);
                        Globales.gen.addExp(temp2, "1", "", "");

                        Globales.gen.addLabel(salida);
                    }

                    Globales.gen.newIF(tmp1, "==", temp2, this.ev);
                    Globales.gen.addGoto(this.ef);

                    this.valor3D = "";
                    this.tmp = false;
                }
            } else if (this.operador.equalsIgnoreCase("/=") || this.operador.equalsIgnoreCase(".ne.")) {
                if (this.operadorIzq.tipo == Tipo.Tipos.CHARACTER || this.operadorIzq.tipo == Tipo.Tipos.INTEGER || this.operadorIzq.tipo == Tipo.Tipos.REAL) {
                    Globales.gen.newIF(this.operadorIzq.valor3D, "!=", this.operadorDer.valor3D, this.ev);
                    Globales.gen.addGoto(this.ef);

                    this.valor3D = "";
                    this.tmp = false;
                } else if (this.operadorIzq.tipo == Tipo.Tipos.LOGICAL) {
                    String gote = Globales.gen.newLabel();
                    String tmp1 = Globales.gen.addTemp();

                    Globales.gen.addLabel(operadorIzq.ev);
                    Globales.gen.addExp(tmp1, "1", "", "");
                    Globales.gen.addGoto(gote);

                    Globales.gen.addLabel(operadorIzq.ef);
                    Globales.gen.addExp(tmp1, "0", "", "");

                    Globales.gen.addLabel(gote);

                    //Verificando el false derecho
                    String salida = Globales.gen.newLabel();
                    String temp2 = Globales.gen.addTemp();

                    if ((boolean) resultadoDer) {
                        Globales.gen.addLabel(operadorDer.ev);

                        Globales.gen.addExp(temp2, "1", "", "");
                        Globales.gen.addGoto(salida);

                        Globales.gen.addLabel(operadorDer.ef);
                        Globales.gen.addExp(temp2, "0", "", "");

                        Globales.gen.addLabel(salida);
                    } else {
                        Globales.gen.addLabel(operadorDer.ev);

                        Globales.gen.addExp(temp2, "0", "", "");
                        Globales.gen.addGoto(salida);

                        Globales.gen.addLabel(operadorDer.ef);
                        Globales.gen.addExp(temp2, "1", "", "");

                        Globales.gen.addLabel(salida);
                    }

                    Globales.gen.newIF(tmp1, "!=", temp2, this.ev);
                    Globales.gen.addGoto(this.ef);

                    this.valor3D = "";
                    this.tmp = false;
                }
            } else if (this.operador.equalsIgnoreCase(">") || this.operador.equalsIgnoreCase(".gt.")) {
                Globales.gen.newIF(this.operadorIzq.valor3D, ">", this.operadorDer.valor3D, this.ev);
                Globales.gen.addGoto(this.ef);

                this.valor3D = "";
                this.tmp = false;
            } else if (this.operador.equalsIgnoreCase(">=") || this.operador.equalsIgnoreCase(".ge.")) {
                Globales.gen.newIF(this.operadorIzq.valor3D, ">=", this.operadorDer.valor3D, this.ev);
                Globales.gen.addGoto(this.ef);

                this.valor3D = "";
                this.tmp = false;
            } else if (this.operador.equalsIgnoreCase("<") || this.operador.equalsIgnoreCase(".lt.")) {
                Globales.gen.newIF(this.operadorIzq.valor3D, "<", this.operadorDer.valor3D, this.ev);
                Globales.gen.addGoto(this.ef);

                this.valor3D = "";
                this.tmp = false;
            } else if (this.operador.equalsIgnoreCase("<=") || this.operador.equalsIgnoreCase(".le.")) {
                Globales.gen.newIF(this.operadorIzq.valor3D, "<=", this.operadorDer.valor3D, this.ev);
                Globales.gen.addGoto(this.ef);

                this.valor3D = "";
                this.tmp = false;
            }
        }
    }
}
