package Expresiones;

import Abstract.Nodo;
import Abstract.NodoAST;
import Other.Excepcion;
import Other.Tipo;
import Symbols.Table;
import Symbols.Tree;

public class Logica extends Nodo {
    Nodo operadorIzq;
    Nodo operadorDer;
    String operador;

    //Para el AST
    NodoAST nodoOp;
    NodoAST nodoIzq;
    NodoAST nodoDer;

    public Logica(Nodo operadorIzq, Nodo operadorDer, String operador, int line, int column) {
        super(null, line, column);
        this.operadorIzq = operadorIzq;
        this.operadorDer = operadorDer;
        this.operador = operador;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        if(this.operadorDer == null){
            String err = "No existe el operador derecho";
            Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
            tree.excepciones.add(error);
            //tree.consola.add(error.toString());
            return error;
        }

        if (this.operadorIzq != null) {
            Object resultadoIzq = this.operadorIzq.execute(table, tree);
            if (resultadoIzq instanceof Excepcion) {
                return resultadoIzq;
            }

            Object resultadoDerecho = this.operadorDer.execute(table, tree);
            if (resultadoDerecho instanceof Excepcion) {
                return resultadoDerecho;
            }

            //AND
            if (this.operador.equalsIgnoreCase(".and.")) {
                String err = "No se pueden operar logicamente los tipos [" + this.operadorIzq.tipo + "] y [" + this.operadorDer.tipo + "] \n";

                //LOGICAL AND LOGICAL
                if(this.operadorIzq.tipo == Tipo.Tipos.LOGICAL && this.operadorDer.tipo == Tipo.Tipos.LOGICAL) {
                    //Le coloco tipo a esta clase
                    this.tipo = Tipo.Tipos.LOGICAL;

                    //Creo los nodos que usare en el AST
                    nodoOp = new NodoAST(".and.");
                    nodoIzq = this.operadorIzq.getAST();
                    nodoDer = this.operadorDer.getAST();

                    //Retorno el valor resultante
                    return (boolean)resultadoIzq && (boolean)resultadoDerecho;
                }

                //OTHER AND OTHER = ERROR
                else {
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    //tree.consola.add(error.toString());
                    return error;
                }
            }

            //OR
            else if (this.operador.equalsIgnoreCase(".or.")) {
                String err = "No se pueden operar logicamente los tipos [" + this.operadorIzq.tipo + "] y [" + this.operadorDer.tipo + "] \n";

                //LOGICAL OR LOGICAL
                if(this.operadorIzq.tipo == Tipo.Tipos.LOGICAL && this.operadorDer.tipo == Tipo.Tipos.LOGICAL) {
                    //Le coloco tipo a esta clase
                    this.tipo = Tipo.Tipos.LOGICAL;

                    //Creo los nodos que usare en el AST
                    nodoOp = new NodoAST(".or.");
                    nodoIzq = this.operadorIzq.getAST();
                    nodoDer = this.operadorDer.getAST();

                    //Retorno el valor resultante
                    return (boolean)resultadoIzq || (boolean)resultadoDerecho;
                }

                //OTHER OR OTHER = ERROR
                else {
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    //tree.consola.add(error.toString());
                    return error;
                }
            }

            //OPERADOR DESCONOCIDO
            else {
                String err = "Error, Operador desconocido ["+this.operador+"] \n";
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.excepciones.add(error);
                //tree.consola.add(error.toString());
                return error;
            }
        }

        //OPERADOR UNARIO
        else {
            Object resultadoDerecho = this.operadorDer.execute(table, tree);
            if (resultadoDerecho instanceof Excepcion) {
                return resultadoDerecho;
            }

            //NOT
            if (this.operador.equalsIgnoreCase(".not.")) {
                if (this.operadorDer.tipo == Tipo.Tipos.LOGICAL) {
                    //Le coloco tipo a la clase
                    this.tipo = Tipo.Tipos.LOGICAL;

                    //Creo los nodos que usare en el AST
                    nodoOp = new NodoAST(".not.");
                    nodoDer = this.operadorDer.getAST();

                    //Retorno el valor negativo
                    return !(boolean)resultadoDerecho;
                }else {
                    String err = "No se puede aplicar not al tipo " + this.operadorDer.tipo + "\n";
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    //tree.consola.add(error.toString());
                    return error;
                }
            }

            //ERROR
            else {
                Excepcion error = new Excepcion("Semantico", "Operador desconocido \n", this.line, this.column);
                tree.excepciones.add(error);
                //tree.consola.add(error.toString());
                return error;
            }
        }
    }

    @Override
    public NodoAST getAST() {
        NodoAST nodo = new NodoAST("LOGICA");

        if(nodoOp != null && nodoDer != null){
            if(nodoIzq != null){
                nodoOp.agregarHijo(nodoIzq);
                nodoOp.agregarHijo(nodoDer);
            }else{
                nodoOp.agregarHijo(nodoDer);
            }
            return nodoOp;
        }
        return nodo;
    }
}
