package Expresiones;

import Abstract.Nodo;
import Abstract.NodoAST;
import Other.Excepcion;
import Other.Tipo;
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

    public Relacional(Nodo operadorIzq, Nodo operadorDer, String operador, int line, int column) {
        super(null, line, column);
        this.operadorIzq = operadorIzq;
        this.operadorDer = operadorDer;
        this.operador = operador;
    }

    @Override
    public Object execute(Table table, Tree tree) {

        if(this.operadorIzq == null){
            String err = "No existe el operador izquierdo";
            Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
            tree.excepciones.add(error);
            //tree.consola.add(error.toString());
            return error;
        }

        if(this.operadorDer == null){
            String err = "No existe el operador derecho";
            Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
            tree.excepciones.add(error);
            //tree.consola.add(error.toString());
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
                return resultadoIzq == resultadoDerecho;
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

                //Retorno el resultado de los valores
                return resultadoIzq != resultadoDerecho;
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
}
