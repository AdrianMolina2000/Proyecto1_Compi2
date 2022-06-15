package Expresiones;

import Abstract.Nodo;
import Abstract.NodoAST;
import Other.Excepcion;
import Other.Tipo;
import Symbols.Table;
import Symbols.Tree;

public class Aritmetica extends Nodo {
    Nodo operadorIzq;
    Nodo operadorDer;
    String operador;

    public Aritmetica(Nodo operadorIzq, Nodo operadorDer, String operador, int line, int column) {
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

            if (this.operador.equalsIgnoreCase("+")) {
                String err = "No se pueden Sumar los tipos [" + this.operadorIzq.tipo + "] y [" + this.operadorDer.tipo + "] \n";
                if(this.operadorIzq.tipo == Tipo.Tipos.INTEGER) {
                    if (this.operadorDer.tipo == Tipo.Tipos.INTEGER) {
                        this.tipo = Tipo.Tipos.INTEGER;
                        return (int)resultadoIzq + (int)resultadoDerecho;
                    }else if (this.operadorDer.tipo == Tipo.Tipos.REAL) {
                        this.tipo = Tipo.Tipos.REAL;
                        return (int)resultadoIzq + (double)resultadoDerecho;
                    }else {
                        Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                        tree.excepciones.add(error);
                        tree.consola.add(error.toString());
                        return error;
                    }
                }else if (this.operadorIzq.tipo == Tipo.Tipos.REAL) {
                    if(this.operadorDer.tipo == Tipo.Tipos.INTEGER) {
                        this.tipo = Tipo.Tipos.REAL;
                        return (double)resultadoIzq + (int)resultadoDerecho;
                    }else if (this.operadorDer.tipo == Tipo.Tipos.REAL) {
                        this.tipo = Tipo.Tipos.REAL;
                        return (double)resultadoIzq + (double)resultadoDerecho;
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
            }else if (this.operador.equalsIgnoreCase( "-")) {
                String err = "No se pueden Restar los tipos [" + this.operadorIzq.tipo + "] y [" + this.operadorDer.tipo + "] \n";
                if (this.operadorIzq.tipo == Tipo.Tipos.INTEGER) {
                    if (this.operadorDer.tipo == Tipo.Tipos.INTEGER) {
                        this.tipo = Tipo.Tipos.INTEGER;
                        return (int)resultadoIzq - (int)resultadoDerecho;
                    }else if (this.operadorDer.tipo == Tipo.Tipos.REAL) {
                        this.tipo = Tipo.Tipos.REAL;
                        return (int)resultadoIzq - (double)resultadoDerecho;
                    }else {
                        Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                        tree.excepciones.add(error);
                        tree.consola.add(error.toString());
                        return error;
                    }
                }else if (this.operadorIzq.tipo == Tipo.Tipos.REAL) {
                    if (this.operadorDer.tipo == Tipo.Tipos.INTEGER) {
                        this.tipo = Tipo.Tipos.REAL;
                        return (double)resultadoIzq - (int)resultadoDerecho;
                    }else if (this.operadorDer.tipo == Tipo.Tipos.REAL) {
                        this.tipo = Tipo.Tipos.REAL;
                        return (double)resultadoIzq - (double)resultadoDerecho;
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
            }else if (this.operador.equalsIgnoreCase("*")) {
                String err = "No se pueden Multiplicar los tipos [" + this.operadorIzq.tipo + "] y [" + this.operadorDer.tipo + "] \n";
                if (this.operadorIzq.tipo == Tipo.Tipos.INTEGER) {
                    if (this.operadorDer.tipo == Tipo.Tipos.INTEGER) {
                        this.tipo = Tipo.Tipos.INTEGER;
                        return (int)resultadoIzq * (int)resultadoDerecho;
                    } else if (this.operadorDer.tipo == Tipo.Tipos.REAL) {
                        this.tipo = Tipo.Tipos.REAL;
                        return (int)resultadoIzq * (double)resultadoDerecho;
                    }else {
                        Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                        tree.excepciones.add(error);
                        tree.consola.add(error.toString());
                        return error;
                    }
                }else if (this.operadorIzq.tipo == Tipo.Tipos.REAL) {
                    if (this.operadorDer.tipo == Tipo.Tipos.INTEGER) {
                        this.tipo = Tipo.Tipos.INTEGER;
                        return (double) resultadoIzq * (int)resultadoDerecho;
                    }else if (this.operadorDer.tipo == Tipo.Tipos.REAL) {
                        this.tipo = Tipo.Tipos.REAL;
                        return (double)resultadoIzq * (double)resultadoDerecho;
                    }else{
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
            } else if (this.operador.equalsIgnoreCase("/")) {
                String err = "No se pueden Dividir los tipos [" + this.operadorIzq.tipo + "] y [" + this.operadorDer.tipo + "] \n";
                if ((int)resultadoDerecho == 0) {
                    Excepcion error = new Excepcion("Semantico",
                            "Error aritmetico, La division con cero no esta permitida",
                            this.line, this.column);
                    tree.excepciones.add(error);
                    tree.consola.add(error.toString());
                    return error;
                }
                if (this.operadorIzq.tipo == Tipo.Tipos.INTEGER) {
                    if (this.operadorDer.tipo == Tipo.Tipos.INTEGER){
                        this.tipo = Tipo.Tipos.INTEGER;
                        int x = (int)resultadoIzq/(int)resultadoDerecho;
                        return x;
                    } else if (this.operadorDer.tipo == Tipo.Tipos.REAL) {
                        this.tipo = Tipo.Tipos.REAL;
                        double x = (int)resultadoIzq / (double)resultadoDerecho;
                        return x;
                    }else {
                        Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                        tree.excepciones.add(error);
                        tree.consola.add(error.toString());
                        return error;
                    }
                }else if (this.operadorIzq.tipo == Tipo.Tipos.REAL) {
                    if(this.operadorDer.tipo == Tipo.Tipos.INTEGER) {
                        this.tipo = Tipo.Tipos.REAL;
                        double x = (double)resultadoIzq / (int)resultadoDerecho;
                        return x;
                    }else if (this.operadorDer.tipo == Tipo.Tipos.REAL) {
                        this.tipo = Tipo.Tipos.REAL;
                        double x = (double)resultadoIzq / (double)resultadoDerecho;
                        return x;
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
            }else if (this.operador.equalsIgnoreCase("**")) {
                String err = "No se pueden Potenciar los tipos [" + this.operadorIzq.tipo + "] y [" + this.operadorDer.tipo + "] \n";
                if (this.operadorIzq.tipo == Tipo.Tipos.INTEGER) {
                    if (this.operadorDer.tipo == Tipo.Tipos.INTEGER){
                        this.tipo = Tipo.Tipos.INTEGER;
                        int x = (int)Math.pow((int)resultadoIzq,(int)resultadoDerecho);
                        return x;
                    }else if (this.operadorDer.tipo == Tipo.Tipos.REAL) {
                        this.tipo = Tipo.Tipos.REAL;
                        double x = Math.pow((int)resultadoIzq,(double)resultadoDerecho);
                        return x;
                    }else {
                        Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                        tree.excepciones.add(error);
                        tree.consola.add(error.toString());
                        return error;
                    }
                }else if (this.operadorIzq.tipo == Tipo.Tipos.REAL) {
                    if(this.operadorDer.tipo == Tipo.Tipos.INTEGER) {
                        this.tipo = Tipo.Tipos.REAL;
                        double x = Math.pow((double)resultadoIzq,(int)resultadoDerecho);
                        return x;
                    }else if (this.operadorDer.tipo == Tipo.Tipos.REAL) {
                        this.tipo = Tipo.Tipos.REAL;
                        double x = Math.pow((double)resultadoIzq,(double)resultadoDerecho);
                        return x;
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
            }else {
                String err = "Error, Operador desconocido ["+this.operador+"] \n";
                Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                tree.excepciones.add(error);
                tree.consola.add(error.toString());
                return error;
            }
        } else {
            Object resultadoDerecho = this.operadorDer.execute(table, tree);
            if (resultadoDerecho instanceof Excepcion) {
                return resultadoDerecho;
            }
            if (this.operador.equalsIgnoreCase("-")) {
                if (this.operadorDer.tipo == Tipo.Tipos.INTEGER) {
                    this.tipo = Tipo.Tipos.INTEGER;
                    return -1 * (int)resultadoDerecho;
                } else if (this.operadorDer.tipo == Tipo.Tipos.REAL) {
                    this.tipo = Tipo.Tipos.REAL;
                    return -1 * (double)resultadoDerecho;
                } else {
                    String err = "No se puede aplicar negativo al tipo " + this.operadorDer.tipo + "\n";
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    tree.consola.add(error.toString());
                    return error;
                }
            }else{
                Excepcion error = new Excepcion("Semantico", "Operador desconocido \n", this.line, this.column);
                tree.excepciones.add(error);
                tree.consola.add(error.toString());
                return error;
            }
        }
    }

    @Override
    public NodoAST getAST() {
        NodoAST nodo = new NodoAST(this.operador);
        if (this.operadorIzq != null) {
            nodo.agregarHijo(this.operadorIzq.getAST());
            nodo.agregarHijo(this.operadorDer.getAST());
        } else {
            nodo.agregarHijo(this.operadorDer.getAST());
        }
        return nodo;
    }
}
