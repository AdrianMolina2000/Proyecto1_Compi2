package Expresiones;

import Abstract.Nodo;
import Abstract.NodoAST;
import Gramatica.Globales;
import Other.Excepcion;
import Other.Tipo;
import Symbols.C3D;
import Symbols.Table;
import Symbols.Tree;

public class Aritmetica extends Nodo {
    Nodo operadorIzq;
    Nodo operadorDer;
    String operador;

    //Para el AST
    NodoAST nodoOp;
    NodoAST nodoIzq;
    NodoAST nodoDer;

    public Aritmetica(Nodo operadorIzq, Nodo operadorDer, String operador, int line, int column) {
        super(null, line, column);
        this.operadorIzq = operadorIzq;
        this.operadorDer = operadorDer;
        this.operador = operador;
    }

    @Override
    public Object execute(Table table, Tree tree) {
        //Para 3D
        if(Globales.gen == null){
            C3D genAux = new C3D();
            Globales.gen = genAux.getInstance();
        }

        Globales.gen.addComment("Empezando aritmetica");

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

            //SUMA
            if(this.operador.equalsIgnoreCase("+")) {
                String err = "No se pueden Sumar los tipos [" + this.operadorIzq.tipo + "] y [" + this.operadorDer.tipo + "] \n";

                //INTEGER +
                if(this.operadorIzq.tipo == Tipo.Tipos.INTEGER) {

                    //INTEGER + INTEGER = INTEGER
                    if (this.operadorDer.tipo == Tipo.Tipos.INTEGER) {
                        //Le coloco el tipo a esta clase
                        this.tipo = Tipo.Tipos.INTEGER;

                        //Creo los nodos que usare en el AST
                        nodoOp = new NodoAST("+");
                        nodoIzq = this.operadorIzq.getAST();
                        nodoDer = this.operadorDer.getAST();

                        //Para C3D
                        String left = this.operadorIzq.valor3D;
                        String right = this.operadorDer.valor3D;
                        String temp = Globales.gen.addTemp();
                        Globales.gen.addExp(temp, left, this.operador, right);
                        this.valor3D = temp;
                        this.tmp = true;
                        Globales.gen.addComment("Terminando aritmetica");


                        //Retorno la suma de los valores
                        return (int)resultadoIzq + (int)resultadoDerecho;
                    }

                    //INTEGER + REAL = REAL
                    else if (this.operadorDer.tipo == Tipo.Tipos.REAL) {
                        //Le coloco el tipo a esta clase
                        this.tipo = Tipo.Tipos.REAL;

                        //Creo los nodos que usare en el AST
                        nodoOp = new NodoAST("+");
                        nodoIzq = this.operadorIzq.getAST();
                        nodoDer = this.operadorDer.getAST();

                        //Para C3D
                        String left = this.operadorIzq.valor3D;
                        String right = this.operadorDer.valor3D;
                        String temp = Globales.gen.addTemp();
                        Globales.gen.addExp(temp, left, this.operador, right);
                        this.valor3D = temp;
                        this.tmp = true;
                        Globales.gen.addComment("Terminando aritmetica");

                        //Retorno la suma de los valores
                        return (int)resultadoIzq + (double)resultadoDerecho;
                    }

                    //INTEGER + OTHER = ERROR
                    else {
                        Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                        tree.excepciones.add(error);
                        //tree.consola.add(error.toString());
                        return error;
                    }
                }

                //REAL +
                else if (this.operadorIzq.tipo == Tipo.Tipos.REAL) {

                    //REAL + INTEGER = REAL
                    if(this.operadorDer.tipo == Tipo.Tipos.INTEGER) {
                        //Le coloco el tipo a esta clase
                        this.tipo = Tipo.Tipos.REAL;

                        //Creo los nodos que usare en el AST
                        nodoOp = new NodoAST("+");
                        nodoIzq = this.operadorIzq.getAST();
                        nodoDer = this.operadorDer.getAST();

                        //Para C3D
                        String left = this.operadorIzq.valor3D;
                        String right = this.operadorDer.valor3D;
                        String temp = Globales.gen.addTemp();
                        Globales.gen.addExp(temp, left, this.operador, right);
                        this.valor3D = temp;
                        this.tmp = true;
                        Globales.gen.addComment("Terminando aritmetica");

                        //Retorno la suma de los valores
                        return (double)resultadoIzq + (int)resultadoDerecho;
                    }

                    //REAL + REAL = REAL
                    else if (this.operadorDer.tipo == Tipo.Tipos.REAL) {
                        //Le coloco el tipo a esta clase
                        this.tipo = Tipo.Tipos.REAL;

                        //Creo los nodos que usare en el AST
                        nodoOp = new NodoAST("+");
                        nodoIzq = this.operadorIzq.getAST();
                        nodoDer = this.operadorDer.getAST();

                        //Para C3D
                        String left = this.operadorIzq.valor3D;
                        String right = this.operadorDer.valor3D;
                        String temp = Globales.gen.addTemp();
                        Globales.gen.addExp(temp, left, this.operador, right);
                        this.valor3D = temp;
                        this.tmp = true;
                        Globales.gen.addComment("Terminando aritmetica");

                        //Retorno la suma de los valores
                        return (double)resultadoIzq + (double)resultadoDerecho;
                    }

                    //REAL + OTHER = ERROR
                    else {
                        Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                        tree.excepciones.add(error);
                        //tree.consola.add(error.toString());
                        return error;
                    }
                }

                //OTHER + OTHER = ERROR
                else {
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    //tree.consola.add(error.toString());
                    return error;
                }
            }

            //RESTA
            else if (this.operador.equalsIgnoreCase( "-")) {
                String err = "No se pueden Restar los tipos [" + this.operadorIzq.tipo + "] y [" + this.operadorDer.tipo + "] \n";

                //INTEGER -
                if (this.operadorIzq.tipo == Tipo.Tipos.INTEGER) {

                    //INTEGER - INTEGER = INTEGER
                    if (this.operadorDer.tipo == Tipo.Tipos.INTEGER) {
                        //Le coloco el tipo a esta clase
                        this.tipo = Tipo.Tipos.INTEGER;

                        //Creo los nodos que usare en el AST
                        nodoOp = new NodoAST("-");
                        nodoIzq = this.operadorIzq.getAST();
                        nodoDer = this.operadorDer.getAST();

                        //Para C3D
                        String left = this.operadorIzq.valor3D;
                        String right = this.operadorDer.valor3D;
                        String temp = Globales.gen.addTemp();
                        Globales.gen.addExp(temp, left, this.operador, right);
                        this.valor3D = temp;
                        this.tmp = true;
                        Globales.gen.addComment("Terminando aritmetica");

                        //Retorno la resta de los valores
                        return (int)resultadoIzq - (int)resultadoDerecho;
                    }

                    //INTEGER - REAL = REAL
                    else if (this.operadorDer.tipo == Tipo.Tipos.REAL) {
                        //Le coloco el tipo a esta clase
                        this.tipo = Tipo.Tipos.REAL;

                        //Creo los nodos que usare en el AST
                        nodoOp = new NodoAST("-");
                        nodoIzq = this.operadorIzq.getAST();
                        nodoDer = this.operadorDer.getAST();

                        //Para C3D
                        String left = this.operadorIzq.valor3D;
                        String right = this.operadorDer.valor3D;
                        String temp = Globales.gen.addTemp();
                        Globales.gen.addExp(temp, left, this.operador, right);
                        this.valor3D = temp;
                        this.tmp = true;
                        Globales.gen.addComment("Terminando aritmetica");

                        //Retorno la resta de los valores
                        return (int)resultadoIzq - (double)resultadoDerecho;
                    }

                    //INTEGER - OTHER = ERROR
                    else {
                        Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                        tree.excepciones.add(error);
                        //tree.consola.add(error.toString());
                        return error;
                    }
                }

                //REAL -
                else if (this.operadorIzq.tipo == Tipo.Tipos.REAL) {

                    //REAL - INTEGER = REAL
                    if (this.operadorDer.tipo == Tipo.Tipos.INTEGER) {
                        //Le coloco el tipo a esta clase
                        this.tipo = Tipo.Tipos.REAL;

                        //Creo los nodos que usare en el AST
                        nodoOp = new NodoAST("-");
                        nodoIzq = this.operadorIzq.getAST();
                        nodoDer = this.operadorDer.getAST();

                        //Para C3D
                        String left = this.operadorIzq.valor3D;
                        String right = this.operadorDer.valor3D;
                        String temp = Globales.gen.addTemp();
                        Globales.gen.addExp(temp, left, this.operador, right);
                        this.valor3D = temp;
                        this.tmp = true;
                        Globales.gen.addComment("Terminando aritmetica");

                        //Retorno la resta de los valores
                        return (double)resultadoIzq - (int)resultadoDerecho;
                    }

                    //REAL - REAL = REAL
                    else if (this.operadorDer.tipo == Tipo.Tipos.REAL) {
                        //Le coloco el tipo a esta clase
                        this.tipo = Tipo.Tipos.REAL;

                        //Creo los nodos que usare en el AST
                        nodoOp = new NodoAST("-");
                        nodoIzq = this.operadorIzq.getAST();
                        nodoDer = this.operadorDer.getAST();

                        //Para C3D
                        String left = this.operadorIzq.valor3D;
                        String right = this.operadorDer.valor3D;
                        String temp = Globales.gen.addTemp();
                        Globales.gen.addExp(temp, left, this.operador, right);
                        this.valor3D = temp;
                        this.tmp = true;
                        Globales.gen.addComment("Terminando aritmetica");

                        //Retorno la resta de los valores
                        return (double)resultadoIzq - (double)resultadoDerecho;
                    }

                    //REAL - OTHER = ERROR
                    else {
                        Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                        tree.excepciones.add(error);
                        //tree.consola.add(error.toString());
                        return error;
                    }
                }

                //OTHER - OTHER = ERROR
                else {
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    //tree.consola.add(error.toString());
                    return error;
                }
            }

            //MULTIPLICACION
            else if (this.operador.equalsIgnoreCase("*")) {
                String err = "No se pueden Multiplicar los tipos [" + this.operadorIzq.tipo + "] y [" + this.operadorDer.tipo + "] \n";

                //INTEGER *
                if (this.operadorIzq.tipo == Tipo.Tipos.INTEGER) {

                    //INTEGER * INTEGER = INTEGER
                    if (this.operadorDer.tipo == Tipo.Tipos.INTEGER) {
                        //Le coloco el tipo a esta clase
                        this.tipo = Tipo.Tipos.INTEGER;

                        //Creo los nodos que usare en el AST
                        nodoOp = new NodoAST("*");
                        nodoIzq = this.operadorIzq.getAST();
                        nodoDer = this.operadorDer.getAST();

                        //Para C3D
                        String left = this.operadorIzq.valor3D;
                        String right = this.operadorDer.valor3D;
                        String temp = Globales.gen.addTemp();
                        Globales.gen.addExp(temp, left, this.operador, right);
                        this.valor3D = temp;
                        this.tmp = true;
                        Globales.gen.addComment("Terminando aritmetica");

                        //Retorno la multiplicacion de los valores
                        return (int)resultadoIzq * (int)resultadoDerecho;
                    }

                    //INTEGER * REAL = REAL
                    else if (this.operadorDer.tipo == Tipo.Tipos.REAL) {
                        //Le coloco el tipo a esta clase
                        this.tipo = Tipo.Tipos.REAL;

                        //Creo los nodos que usare en el AST
                        nodoOp = new NodoAST("*");
                        nodoIzq = this.operadorIzq.getAST();
                        nodoDer = this.operadorDer.getAST();

                        //Para C3D
                        String left = this.operadorIzq.valor3D;
                        String right = this.operadorDer.valor3D;
                        String temp = Globales.gen.addTemp();
                        Globales.gen.addExp(temp, left, this.operador, right);
                        this.valor3D = temp;
                        this.tmp = true;
                        Globales.gen.addComment("Terminando aritmetica");

                        //Retorno la multiplicacion de los valores
                        return (int)resultadoIzq * (double)resultadoDerecho;
                    }

                    //INTEGER * OTHER = ERROR
                    else {
                        Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                        tree.excepciones.add(error);
                        //tree.consola.add(error.toString());
                        return error;
                    }
                }

                //REAL *
                else if (this.operadorIzq.tipo == Tipo.Tipos.REAL) {

                    //REAL * INTEGER = REAL
                    if (this.operadorDer.tipo == Tipo.Tipos.INTEGER) {
                        //Le coloco el tipo a esta clase
                        this.tipo = Tipo.Tipos.INTEGER;

                        //Creo los nodos que usare en el AST
                        nodoOp = new NodoAST("*");
                        nodoIzq = this.operadorIzq.getAST();
                        nodoDer = this.operadorDer.getAST();

                        //Para C3D
                        String left = this.operadorIzq.valor3D;
                        String right = this.operadorDer.valor3D;
                        String temp = Globales.gen.addTemp();
                        Globales.gen.addExp(temp, left, this.operador, right);
                        this.valor3D = temp;
                        this.tmp = true;
                        Globales.gen.addComment("Terminando aritmetica");

                        //Retorno la multiplicacion de los valores
                        return (double) resultadoIzq * (int)resultadoDerecho;
                    }

                    //REAL * REAL = REAL
                    else if (this.operadorDer.tipo == Tipo.Tipos.REAL) {
                        //Le coloco el tipo a esta clase
                        this.tipo = Tipo.Tipos.REAL;

                        //Creo los nodos que usare en el AST
                        nodoOp = new NodoAST("*");
                        nodoIzq = this.operadorIzq.getAST();
                        nodoDer = this.operadorDer.getAST();

                        //Para C3D
                        String left = this.operadorIzq.valor3D;
                        String right = this.operadorDer.valor3D;
                        String temp = Globales.gen.addTemp();
                        Globales.gen.addExp(temp, left, this.operador, right);
                        this.valor3D = temp;
                        this.tmp = true;
                        Globales.gen.addComment("Terminando aritmetica");

                        //Retorno la multiplicacion de los valores
                        return (double)resultadoIzq * (double)resultadoDerecho;
                    }

                    //REAL * OTHER = ERROR
                    else{
                        Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                        tree.excepciones.add(error);
                        //tree.consola.add(error.toString());
                        return error;
                    }
                }

                //OTHER * OTHER = ERROR
                else {
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    //tree.consola.add(error.toString());
                    return error;
                }
            }

            //DIVISION
            else if (this.operador.equalsIgnoreCase("/")) {
                String err = "No se pueden Dividir los tipos [" + this.operadorIzq.tipo + "] y [" + this.operadorDer.tipo + "] \n";

                //Para C3D
                String left = this.operadorIzq.valor3D;
                String right = this.operadorDer.valor3D;

                String izq = Globales.gen.addTemp();
                String der = Globales.gen.addTemp();
                String temp = Globales.gen.addTemp();
                Globales.gen.addExp(izq, left, "", "");
                Globales.gen.addExp(der, right, "", "");

                String condicional = Globales.gen.newLabel();
                String salida = Globales.gen.newLabel();
                String salida2 = Globales.gen.newLabel();

                Globales.gen.newIF(der, "==", "0", condicional);
                Globales.gen.addGoto(salida);
                Globales.gen.addLabel(condicional);

                Globales.gen.addPrint("c", "77");
                Globales.gen.addPrint("c", "97");
                Globales.gen.addPrint("c", "116");
                Globales.gen.addPrint("c", "104");
                Globales.gen.addPrint("c", "69");
                Globales.gen.addPrint("c", "114");
                Globales.gen.addPrint("c", "114");
                Globales.gen.addPrint("c", "111");
                Globales.gen.addPrint("c", "114");
                Globales.gen.addPrint("c", "10");

                Globales.gen.addExp(temp, "0", "", "");
                Globales.gen.addGoto(salida2);
                Globales.gen.addLabel(salida);

                //NO DIVISION SOBRE 0
                if ((int)resultadoDerecho == 0) {
                    String err2 = "Error semantico, La division entre cero no esta permitida \n";
                    Excepcion error = new Excepcion("Semantico", err2, this.line, this.column);
                    tree.excepciones.add(error);

                    //Para C3D
                    Globales.gen.addExp(temp, izq, this.operador, der);
                    Globales.gen.addLabel(salida2);
                    this.valor3D = temp;
                    this.tmp = true;
                    Globales.gen.addPrint("c", "10");
                    Globales.gen.addComment("Terminando aritmetica");

                    return error;
                }

                //INTEGER /
                if (this.operadorIzq.tipo == Tipo.Tipos.INTEGER) {

                    //INTEGER / INTEGER = INTEGER
                    if (this.operadorDer.tipo == Tipo.Tipos.INTEGER){
                        //Le coloco el tipo a esta clase
                        this.tipo = Tipo.Tipos.INTEGER;

                        //Creo los nodos que usare en el AST
                        nodoOp = new NodoAST("/");
                        nodoIzq = this.operadorIzq.getAST();
                        nodoDer = this.operadorDer.getAST();

                        //Para C3D
                        Globales.gen.addExp(temp, izq, this.operador, der);
                        Globales.gen.addLabel(salida2);
                        this.valor3D = temp;
                        this.tmp = true;
                        Globales.gen.addComment("Terminando aritmetica");

                        //Retorno la Division de los valores
                        int x = (int)resultadoIzq/(int)resultadoDerecho;
                        return x;
                    }

                    //INTEGER / REAL = REAL
                    else if (this.operadorDer.tipo == Tipo.Tipos.REAL) {
                        //Le coloco el tipo a esta clase
                        this.tipo = Tipo.Tipos.REAL;

                        //Creo los nodos que usare en el AST
                        nodoOp = new NodoAST("/");
                        nodoIzq = this.operadorIzq.getAST();
                        nodoDer = this.operadorDer.getAST();

                        //Para C3D
                        Globales.gen.addExp(temp, izq, this.operador, der);
                        Globales.gen.addLabel(salida2);
                        this.valor3D = temp;
                        this.tmp = true;
                        Globales.gen.addComment("Terminando aritmetica");

                        //Retorno la division de los valores
                        double x = (int)resultadoIzq / (double)resultadoDerecho;
                        return x;
                    }

                    //INTEGER / OTHER = ERROR
                    else {
                        Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                        tree.excepciones.add(error);
                        //tree.consola.add(error.toString());
                        return error;
                    }
                }

                //REAL /
                else if (this.operadorIzq.tipo == Tipo.Tipos.REAL) {

                    //REAL / INTEGER = REAL
                    if(this.operadorDer.tipo == Tipo.Tipos.INTEGER) {
                        //Le coloco el tipo a esta clase
                        this.tipo = Tipo.Tipos.REAL;

                        //Creo los nodos que usare en el AST
                        nodoOp = new NodoAST("/");
                        nodoIzq = this.operadorIzq.getAST();
                        nodoDer = this.operadorDer.getAST();

                        //Para C3D
                        Globales.gen.addExp(temp, izq, this.operador, der);
                        Globales.gen.addLabel(salida2);
                        this.valor3D = temp;
                        this.tmp = true;
                        Globales.gen.addComment("Terminando aritmetica");

                        //Retorno la division de los valores
                        double x = (double)resultadoIzq / (int)resultadoDerecho;
                        return x;
                    }

                    //REAL / REAL = REAL
                    else if (this.operadorDer.tipo == Tipo.Tipos.REAL) {
                        //Le coloco el tipo a esta clase
                        this.tipo = Tipo.Tipos.REAL;

                        //Creo los nodos que usare en el AST
                        nodoOp = new NodoAST("/");
                        nodoIzq = this.operadorIzq.getAST();
                        nodoDer = this.operadorDer.getAST();

                        //Para C3D
                        Globales.gen.addExp(temp, izq, this.operador, der);
                        Globales.gen.addLabel(salida2);
                        this.valor3D = temp;
                        this.tmp = true;
                        Globales.gen.addComment("Terminando aritmetica");

                        //Retorno la division de los valores
                        double x = (double)resultadoIzq / (double)resultadoDerecho;
                        return x;
                    }

                    //REAL / OTHER = ERROR
                    else {
                        Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                        tree.excepciones.add(error);
                        //tree.consola.add(error.toString());
                        return error;
                    }
                }

                //OTHER / OTHER = ERROR
                else {
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    tree.consola.add(error.toString());
                    return error;
                }
            }

            //POTENCIA
            else if (this.operador.equalsIgnoreCase("**")) {
                String err = "No se pueden Potenciar los tipos [" + this.operadorIzq.tipo + "] y [" + this.operadorDer.tipo + "] \n";

                //INTEGER **
                if (this.operadorIzq.tipo == Tipo.Tipos.INTEGER) {

                    //INTEGER ** INTEGER = INTEGER
                    if (this.operadorDer.tipo == Tipo.Tipos.INTEGER){
                        //Le coloco el tipo a esta clase
                        this.tipo = Tipo.Tipos.INTEGER;

                        //Creo los nodos que usare en el AST
                        nodoOp = new NodoAST("**");
                        nodoIzq = this.operadorIzq.getAST();
                        nodoDer = this.operadorDer.getAST();

                        //Para C3D
                        String left = this.operadorIzq.valor3D;
                        String right = this.operadorDer.valor3D;

                        Globales.gen.potencia();
                        String tmp = Globales.gen.addTemp();

                        Globales.gen.addExp(tmp, "P", "+", String.valueOf(table.size));

                        Globales.gen.addExp(tmp, tmp, "+", "1");
                        Globales.gen.setStack(tmp, left);

                        Globales.gen.addExp(tmp, tmp, "+", "1");
                        Globales.gen.setStack(tmp, right);

                        Globales.gen.newTable(String.valueOf(table.size));
                        Globales.gen.callFun("potencia");
                        String temp = Globales.gen.addTemp();
                        Globales.gen.getStack(temp, "P");
                        Globales.gen.getTable(String.valueOf(table.size));

                        this.valor3D = temp;
                        this.tmp = true;
                        Globales.gen.addComment("Terminando aritmetica");

                        //Retorno la potencia de los valores
                        int x = (int)Math.pow((int)resultadoIzq,(int)resultadoDerecho);
                        return x;
                    }

                    //INTEGER ** REAL = REAL;
                    else if (this.operadorDer.tipo == Tipo.Tipos.REAL) {
                        //Le coloco el tipo a esta clase
                        this.tipo = Tipo.Tipos.REAL;

                        //Creo los nodos que usare en el AST
                        nodoOp = new NodoAST("**");
                        nodoIzq = this.operadorIzq.getAST();
                        nodoDer = this.operadorDer.getAST();

                        //Para C3D
                        String left = this.operadorIzq.valor3D;
                        String right = this.operadorDer.valor3D;

                        Globales.gen.potencia();
                        String tmp = Globales.gen.addTemp();

                        Globales.gen.addExp(tmp, "P", "+", String.valueOf(table.size));

                        Globales.gen.addExp(tmp, tmp, "+", "1");
                        Globales.gen.setStack(tmp, left);

                        Globales.gen.addExp(tmp, tmp, "+", "1");
                        Globales.gen.setStack(tmp, right);

                        Globales.gen.newTable(String.valueOf(table.size));
                        Globales.gen.callFun("potencia");
                        String temp = Globales.gen.addTemp();
                        Globales.gen.getStack(temp, "P");
                        Globales.gen.getTable(String.valueOf(table.size));

                        this.valor3D = temp;
                        this.tmp = true;
                        Globales.gen.addComment("Terminando aritmetica");

                        //Retorno la potencia de los valores
                        double x = Math.pow((int)resultadoIzq,(double)resultadoDerecho);
                        return x;
                    }

                    //INTEGER ** OTHER = ERROR
                    else {
                        Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                        tree.excepciones.add(error);
                        //tree.consola.add(error.toString());
                        return error;
                    }
                }

                //REAL **
                else if (this.operadorIzq.tipo == Tipo.Tipos.REAL) {

                    //REAL ** INTEGER = REAL
                    if(this.operadorDer.tipo == Tipo.Tipos.INTEGER) {
                        //Le coloco el tipo a esta clase
                        this.tipo = Tipo.Tipos.REAL;

                        //Creo los nodos que usare en el AST
                        nodoOp = new NodoAST("**");
                        nodoIzq = this.operadorIzq.getAST();
                        nodoDer = this.operadorDer.getAST();

                        //Para C3D
                        String left = this.operadorIzq.valor3D;
                        String right = this.operadorDer.valor3D;

                        Globales.gen.potencia();
                        String tmp = Globales.gen.addTemp();

                        Globales.gen.addExp(tmp, "P", "+", String.valueOf(table.size));

                        Globales.gen.addExp(tmp, tmp, "+", "1");
                        Globales.gen.setStack(tmp, left);

                        Globales.gen.addExp(tmp, tmp, "+", "1");
                        Globales.gen.setStack(tmp, right);

                        Globales.gen.newTable(String.valueOf(table.size));
                        Globales.gen.callFun("potencia");
                        String temp = Globales.gen.addTemp();
                        Globales.gen.getStack(temp, "P");
                        Globales.gen.getTable(String.valueOf(table.size));

                        this.valor3D = temp;
                        this.tmp = true;
                        Globales.gen.addComment("Terminando aritmetica");

                        //Retorno la potencia de los valores
                        double x = Math.pow((double)resultadoIzq,(int)resultadoDerecho);
                        return x;
                    }

                    //REAL ** REAL = REAL
                    else if (this.operadorDer.tipo == Tipo.Tipos.REAL) {
                        //Le coloco el tipo a esta clase
                        this.tipo = Tipo.Tipos.REAL;

                        //Creo los nodos que usare en el AST
                        nodoOp = new NodoAST("**");
                        nodoIzq = this.operadorIzq.getAST();
                        nodoDer = this.operadorDer.getAST();

                        //Para C3D
                        String left = this.operadorIzq.valor3D;
                        String right = this.operadorDer.valor3D;

                        Globales.gen.potencia();
                        String tmp = Globales.gen.addTemp();

                        Globales.gen.addExp(tmp, "P", "+", String.valueOf(table.size));

                        Globales.gen.addExp(tmp, tmp, "+", "1");
                        Globales.gen.setStack(tmp, left);

                        Globales.gen.addExp(tmp, tmp, "+", "1");
                        Globales.gen.setStack(tmp, right);

                        Globales.gen.newTable(String.valueOf(table.size));
                        Globales.gen.callFun("potencia");
                        String temp = Globales.gen.addTemp();
                        Globales.gen.getStack(temp, "P");
                        Globales.gen.getTable(String.valueOf(table.size));

                        this.valor3D = temp;
                        this.tmp = true;
                        Globales.gen.addComment("Terminando aritmetica");

                        //Retorno la potencia de los valores
                        double x = Math.pow((double)resultadoIzq,(double)resultadoDerecho);
                        return x;
                    }

                    //REAL ** OTHER = ERROR
                    else {
                        Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                        tree.excepciones.add(error);
                        //tree.consola.add(error.toString());
                        return error;
                    }
                }

                //OTHER ** OTHER
                else {
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    tree.consola.add(error.toString());
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

            //NEGATIVO
            if (this.operador.equalsIgnoreCase("-")) {

                // - INTEGER
                if (this.operadorDer.tipo == Tipo.Tipos.INTEGER) {
                    //Le coloco el tipo a esta clase
                    this.tipo = Tipo.Tipos.INTEGER;

                    //Creo los nodos que usare en el AST
                    nodoOp = new NodoAST("-");
                    nodoDer = this.operadorDer.getAST();

                    //Para C3D
                    String right = this.operadorDer.valor3D;
                    String temp = Globales.gen.addTemp();
                    Globales.gen.addExp(temp, "0", this.operador, right);
                    this.valor3D = temp;
                    this.tmp = true;
                    Globales.gen.addComment("Terminando aritmetica");

                    //Retorno el valor negativo
                    return -1 * (int)resultadoDerecho;
                }

                // - REAL
                else if (this.operadorDer.tipo == Tipo.Tipos.REAL) {
                    //Le coloco el tipo a esta clase
                    this.tipo = Tipo.Tipos.REAL;

                    //Creo los nodos que usare en el AST
                    nodoOp = new NodoAST("-");
                    nodoDer = this.operadorDer.getAST();

                    //Para C3D
                    String right = this.operadorDer.valor3D;
                    String temp = Globales.gen.addTemp();
                    Globales.gen.addExp(temp, "0", this.operador, right);
                    this.valor3D = temp;
                    this.tmp = true;
                    Globales.gen.addComment("Terminando aritmetica");

                    //Retorno el valor negativo
                    return -1 * (double)resultadoDerecho;
                }

                // - OTHER = ERROR
                else {
                    String err = "No se puede aplicar negativo al tipo " + this.operadorDer.tipo + "\n";
                    Excepcion error = new Excepcion("Semantico", err, this.line, this.column);
                    tree.excepciones.add(error);
                    //tree.consola.add(error.toString());
                    return error;
                }
            }

            //ERROR
            else{
                Excepcion error = new Excepcion("Semantico", "Operador desconocido \n", this.line, this.column);
                tree.excepciones.add(error);
                //tree.consola.add(error.toString());
                return error;
            }
        }
    }

    @Override
    public NodoAST getAST() {
        NodoAST nodo = new NodoAST("ARITMETICA");

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
