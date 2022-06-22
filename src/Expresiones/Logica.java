package Expresiones;

import Abstract.Nodo;
import Abstract.NodoAST;
import Gramatica.Globales;
import Other.Excepcion;
import Other.Tipo;
import Symbols.C3D;
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
            return error;
        }

        if (this.operadorIzq != null) {
            //AND
            if (this.operador.equalsIgnoreCase(".and.")) {
                String err = "No se pueden operar logicamente los tipos [" + this.operadorIzq.tipo + "] y [" + this.operadorDer.tipo + "] \n";

                Object resultadoIzq = this.operadorIzq.execute(table, tree);
                if (resultadoIzq instanceof Excepcion) {
                    return resultadoIzq;
                }

                //ERROR
                if(this.operadorIzq.tipo != Tipo.Tipos.LOGICAL) {
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    return error;
                }

                Object resultadoDerecho = this.operadorDer.execute(table, tree);
                if (resultadoDerecho instanceof Excepcion) {
                    return resultadoDerecho;
                }

                //ERROR
                if(this.operadorDer.tipo != Tipo.Tipos.LOGICAL) {
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    return error;
                }

                //Le coloco tipo a esta clase
                this.tipo = Tipo.Tipos.LOGICAL;

                //Creo los nodos que usare en el AST
                nodoOp = new NodoAST(".and.");
                nodoIzq = this.operadorIzq.getAST();
                nodoDer = this.operadorDer.getAST();

                //Para el C3D
                this.isC3D = true;

                //Retorno el valor resultante
                return (boolean)resultadoIzq && (boolean)resultadoDerecho;
            } else if (this.operador.equalsIgnoreCase(".or.")) {
                String err = "No se pueden operar logicamente los tipos [" + this.operadorIzq.tipo + "] y [" + this.operadorDer.tipo + "] \n";

                Object resultadoIzq = this.operadorIzq.execute(table, tree);
                if (resultadoIzq instanceof Excepcion) {
                    return resultadoIzq;
                }

                //ERROR
                if(this.operadorIzq.tipo != Tipo.Tipos.LOGICAL) {
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    return error;
                }

                Object resultadoDerecho = this.operadorDer.execute(table, tree);
                if (resultadoDerecho instanceof Excepcion) {
                    return resultadoDerecho;
                }

                //ERROR
                if(this.operadorDer.tipo != Tipo.Tipos.LOGICAL) {
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    return error;
                }

                //Le coloco tipo a esta clase
                this.tipo = Tipo.Tipos.LOGICAL;

                //Creo los nodos que usare en el AST
                nodoOp = new NodoAST(".or.");
                nodoIzq = this.operadorIzq.getAST();
                nodoDer = this.operadorDer.getAST();

                //Para el C3D
                this.isC3D = true;

                //Retorno el valor resultante
                return (boolean)resultadoIzq || (boolean)resultadoDerecho;
            }

            //OPERADOR DESCONOCIDO
            else {
                String err = "Error, Operador desconocido ["+this.operador+"] \n";
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.excepciones.add(error);
                return error;
            }
        }

        //OPERADOR UNARIO
        else {
            //NOT
            if (this.operador.equalsIgnoreCase(".not.")) {
                Object resultadoDerecho = this.operadorDer.execute(table, tree);
                if (resultadoDerecho instanceof Excepcion) {
                    return resultadoDerecho;
                }

                //ERROR
                if(this.operadorDer.tipo != Tipo.Tipos.LOGICAL) {
                    String err = "No se puede operar porque no es del tipo logical";
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    return error;
                }

                //Le coloco tipo a la clase
                this.tipo = Tipo.Tipos.LOGICAL;

                //Creo los nodos que usare en el AST
                nodoOp = new NodoAST(".not.");
                nodoDer = this.operadorDer.getAST();

                //Para el C3D
                this.isC3D = true;

                //Retorno el valor negativo
                return !(boolean)resultadoDerecho;
            }

            //ERROR
            else {
                Excepcion error = new Excepcion("Semantico", "Operador desconocido \n", this.line, this.column);
                tree.excepciones.add(error);
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

    @Override
    public void get3D() {
        if(Globales.gen == null){
            C3D genAux = new C3D();
            Globales.gen = genAux.getInstance();
        }

        if(this.isC3D) {
            Globales.gen.addComment("Logica");

            if (this.ev == null) {
                this.ev = Globales.gen.newLabel();
            }
            if (this.ef == null) {
                this.ef = Globales.gen.newLabel();
            }

            if (this.operadorIzq != null) {
                if (this.operador.equalsIgnoreCase(".and.")) {
                    String lbl = Globales.gen.newLabel();
                    operadorIzq.ev = lbl;
                    operadorDer.ev = this.ev;
                    operadorIzq.ef = this.ef;
                    operadorDer.ef = this.ef;

                    this.operadorIzq.get3D();

                    Globales.gen.addLabel(lbl);

                    this.operadorDer.get3D();

                    this.valor3D = "";
                    this.tmp = false;

                } else if (this.operador.equalsIgnoreCase(".or.")) {
                    operadorIzq.ev = this.ev;
                    operadorDer.ev = this.ev;
                    String lbl = Globales.gen.newLabel();
                    operadorIzq.ef = lbl;
                    operadorDer.ef = this.ef;

                    this.operadorIzq.get3D();

                    Globales.gen.addLabel(lbl);

                    this.operadorDer.get3D();

                    this.valor3D = "";
                    this.tmp = false;
                }
            } else {
                operadorDer.ev = this.ef;
                operadorDer.ef = this.ev;

                this.operadorDer.get3D();

                this.valor3D = "";
                this.tmp = false;
            }
        }
    }
}
