package Expresiones;

import Abstract.Nodo;
import Other.Excepcion;
import Other.Tipo;
import Symbols.Table;
import Symbols.Tree;

public class Logica extends Nodo {
    Nodo operadorIzq;
    Nodo operadorDer;
    String operador;
    public Logica(Nodo operadorIzq, Nodo operadorDer, String operador, int line, int column) {
        super(null, line, column);
        this.operadorIzq = operadorIzq;
        this.operadorDer = operadorDer;
        this.operador = operador;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        if (this.operadorIzq != null) {
            Object resultadoIzq = this.operadorIzq.execute(table, tree);
            if (resultadoIzq instanceof Excepcion) {
                return resultadoIzq;
            }

            Object resultadoDerecho = this.operadorDer.execute(table, tree);
            if (resultadoDerecho instanceof Excepcion) {
                return resultadoDerecho;
            }

            if (this.operador.equalsIgnoreCase(".and.")) {
                String err = "No se pueden operar logicamente los tipos [" + this.operadorIzq.tipo + "] y [" + this.operadorDer.tipo + "] \n";
                if(this.operadorIzq.tipo == Tipo.Tipos.LOGICAL && this.operadorDer.tipo == Tipo.Tipos.LOGICAL) {
                    this.tipo = Tipo.Tipos.LOGICAL;
                    return (boolean)resultadoIzq && (boolean)resultadoDerecho;
                }else {
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    tree.consola.add(error.toString());
                    return error;
                }
            }else if (this.operador.equalsIgnoreCase(".or.")) {
                String err = "No se pueden operar logicamente los tipos [" + this.operadorIzq.tipo + "] y [" + this.operadorDer.tipo + "] \n";
                if(this.operadorIzq.tipo == Tipo.Tipos.LOGICAL && this.operadorDer.tipo == Tipo.Tipos.LOGICAL) {
                    this.tipo = Tipo.Tipos.LOGICAL;
                    return (boolean)resultadoIzq || (boolean)resultadoDerecho;
                }else {
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    tree.consola.add(error.toString());
                    return error;
                }
            }else {
                String err = "Error, Operador desconocido ["+this.operador+"] \n";
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.excepciones.add(error);
                tree.consola.add(error.toString());
                return error;
            }
        }else {
            Object resultadoDerecho = this.operadorDer.execute(table, tree);
            if (resultadoDerecho instanceof Excepcion) {
                return resultadoDerecho;
            }
            if (this.operador.equalsIgnoreCase(".not.")) {
                if (this.operadorDer.tipo == Tipo.Tipos.LOGICAL) {
                    this.tipo = Tipo.Tipos.LOGICAL;
                    return !(boolean)resultadoDerecho;
                }else {
                    String err = "No se puede aplicar not al tipo " + this.operadorDer.tipo + "\n";
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    tree.consola.add(error.toString());
                    return error;
                }
            }else {
                Excepcion error = new Excepcion("Semantico", "Operador desconocido \n", this.line, this.column);
                tree.excepciones.add(error);
                tree.consola.add(error.toString());
                return error;
            }
        }
    }
}
