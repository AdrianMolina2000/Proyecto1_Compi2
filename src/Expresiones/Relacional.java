package Expresiones;

import Abstract.Nodo;
import Other.Excepcion;
import Other.Tipo;
import Symbols.Table;
import Symbols.Tree;

public class Relacional extends Nodo {
    Nodo operadorIzq;
    Nodo operadorDer;
    String operador;

    public Relacional(Nodo operadorIzq, Nodo operadorDer, String operador, int line, int column) {
        super(null, line, column);
        this.operadorIzq = operadorIzq;
        this.operadorDer = operadorDer;
        this.operador = operador;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        Object resultadoIzq = this.operadorIzq.execute(table, tree);

        if (resultadoIzq instanceof Excepcion) {
            return resultadoIzq;
        }

        Object resultadoDerecho = this.operadorDer.execute(table, tree);
        if (resultadoDerecho instanceof Excepcion) {
           return resultadoDerecho;
        }

        if (this.operador.equalsIgnoreCase("==") || this.operador.equalsIgnoreCase(".eq.")) {
            if(this.operadorIzq.tipo == this.operadorDer.tipo) {
                    this.tipo = Tipo.Tipos.LOGICAL;
                    return resultadoIzq == resultadoDerecho;
            }else {
                String err = "No se pueden Igualar los tipos [" + this.operadorIzq.tipo + "] y [" + this.operadorDer.tipo + "] \n";
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.excepciones.add(error);
                tree.consola.add(error.toString());
                return error;
            }
        }else if (this.operador.equalsIgnoreCase("/=")|| this.operador.equalsIgnoreCase(".ne.")){
            if(this.operadorIzq.tipo == this.operadorDer.tipo) {
                this.tipo = Tipo.Tipos.LOGICAL;
                return resultadoIzq != resultadoDerecho;
            }else {
                String err = "No se pueden DesIgualar los tipos [" + this.operadorIzq.tipo + "] y [" + this.operadorDer.tipo + "] \n";
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.excepciones.add(error);
                tree.consola.add(error.toString());
                return error;
            }
        }else if (this.operador.equalsIgnoreCase(">")|| this.operador.equalsIgnoreCase(".gt.")){
            String err = "No se pueden usar > los tipos [" + this.operadorIzq.tipo + "] y [" + this.operadorDer.tipo + "] \n";
            if(this.operadorIzq.tipo == Tipo.Tipos.INTEGER) {
                if (this.operadorDer.tipo == Tipo.Tipos.INTEGER) {
                    this.tipo = Tipo.Tipos.LOGICAL;
                    return (int)resultadoIzq > (int)resultadoDerecho;
                }else if (this.operadorDer.tipo == Tipo.Tipos.REAL) {
                    this.tipo = Tipo.Tipos.LOGICAL;
                    return (int)resultadoIzq > (double)resultadoDerecho;
                }else {
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    tree.consola.add(error.toString());
                    return error;
                }
            }else if (this.operadorIzq.tipo == Tipo.Tipos.REAL) {
                if(this.operadorDer.tipo == Tipo.Tipos.INTEGER) {
                    this.tipo = Tipo.Tipos.LOGICAL;
                    return (double)resultadoIzq > (int)resultadoDerecho;
                }else if (this.operadorDer.tipo == Tipo.Tipos.REAL) {
                    this.tipo = Tipo.Tipos.LOGICAL;
                    return (double)resultadoIzq > (double)resultadoDerecho;
                }else {
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    tree.consola.add(error.toString());
                    return error;
                }
            }else {
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.excepciones.add(error);
                tree.consola.add(error.toString());
                return error;
            }
        }else if (this.operador.equalsIgnoreCase(">=")|| this.operador.equalsIgnoreCase(".ge.")){
            String err = "No se pueden usar >= los tipos [" + this.operadorIzq.tipo + "] y [" + this.operadorDer.tipo + "] \n";
            if(this.operadorIzq.tipo == Tipo.Tipos.INTEGER) {
                if (this.operadorDer.tipo == Tipo.Tipos.INTEGER) {
                    this.tipo = Tipo.Tipos.LOGICAL;
                    return (int)resultadoIzq >= (int)resultadoDerecho;
                }else if (this.operadorDer.tipo == Tipo.Tipos.REAL) {
                    this.tipo = Tipo.Tipos.LOGICAL;
                    return (int)resultadoIzq >= (double)resultadoDerecho;
                }else {
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    tree.consola.add(error.toString());
                    return error;
                }
            }else if (this.operadorIzq.tipo == Tipo.Tipos.REAL) {
                if(this.operadorDer.tipo == Tipo.Tipos.INTEGER) {
                    this.tipo = Tipo.Tipos.LOGICAL;
                    return (double)resultadoIzq >= (int)resultadoDerecho;
                }else if (this.operadorDer.tipo == Tipo.Tipos.REAL) {
                    this.tipo = Tipo.Tipos.LOGICAL;
                    return (double)resultadoIzq >= (double)resultadoDerecho;
                }else {
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    tree.consola.add(error.toString());
                    return error;
                }
            }else {
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.excepciones.add(error);
                tree.consola.add(error.toString());
                return error;
            }
        }else if (this.operador.equalsIgnoreCase("<")|| this.operador.equalsIgnoreCase(".lt.")){
            String err = "No se pueden usar >= los tipos [" + this.operadorIzq.tipo + "] y [" + this.operadorDer.tipo + "] \n";
            if(this.operadorIzq.tipo == Tipo.Tipos.INTEGER) {
                if (this.operadorDer.tipo == Tipo.Tipos.INTEGER) {
                    this.tipo = Tipo.Tipos.LOGICAL;
                    return (int)resultadoIzq < (int)resultadoDerecho;
                }else if (this.operadorDer.tipo == Tipo.Tipos.REAL) {
                    this.tipo = Tipo.Tipos.LOGICAL;
                    return (int)resultadoIzq < (double)resultadoDerecho;
                }else {
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    tree.consola.add(error.toString());
                    return error;
                }
            }else if (this.operadorIzq.tipo == Tipo.Tipos.REAL) {
                if(this.operadorDer.tipo == Tipo.Tipos.INTEGER) {
                    this.tipo = Tipo.Tipos.LOGICAL;
                    return (double)resultadoIzq < (int)resultadoDerecho;
                }else if (this.operadorDer.tipo == Tipo.Tipos.REAL) {
                    this.tipo = Tipo.Tipos.LOGICAL;
                    return (double)resultadoIzq < (double)resultadoDerecho;
                }else {
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    tree.consola.add(error.toString());
                    return error;
                }
            }else {
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.excepciones.add(error);
                tree.consola.add(error.toString());
                return error;
            }
        }else if (this.operador.equalsIgnoreCase("<=")|| this.operador.equalsIgnoreCase(".le.")){
            String err = "No se pueden usar >= los tipos [" + this.operadorIzq.tipo + "] y [" + this.operadorDer.tipo + "] \n";
            if(this.operadorIzq.tipo == Tipo.Tipos.INTEGER) {
                if (this.operadorDer.tipo == Tipo.Tipos.INTEGER) {
                    this.tipo = Tipo.Tipos.LOGICAL;
                    return (int)resultadoIzq <= (int)resultadoDerecho;
                }else if (this.operadorDer.tipo == Tipo.Tipos.REAL) {
                    this.tipo = Tipo.Tipos.LOGICAL;
                    return (int)resultadoIzq <= (double)resultadoDerecho;
                }else {
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    tree.consola.add(error.toString());
                    return error;
                }
            }else if (this.operadorIzq.tipo == Tipo.Tipos.REAL) {
                if(this.operadorDer.tipo == Tipo.Tipos.INTEGER) {
                    this.tipo = Tipo.Tipos.LOGICAL;
                    return (double)resultadoIzq <= (int)resultadoDerecho;
                }else if (this.operadorDer.tipo == Tipo.Tipos.REAL) {
                    this.tipo = Tipo.Tipos.LOGICAL;
                    return (double)resultadoIzq <= (double)resultadoDerecho;
                }else {
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    tree.consola.add(error.toString());
                    return error;
                }
            }else {
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.excepciones.add(error);
                tree.consola.add(error.toString());
                return error;
            }
        }else{
            String err = "Error, Operador desconocido ["+this.operador+"] \n";
            Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
            tree.excepciones.add(error);
            tree.consola.add(error.toString());
            return error;
        }
    }
}
