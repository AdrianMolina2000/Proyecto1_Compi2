package Gramatica;

import Expresiones.Primitivo;
import Other.Tipo;
import Symbols.Tree;

public class Globales {
    public static Tree tree = new Tree();
    public static String entrada = "";
    public static String salida = "";

    public static Primitivo defal(Tipo.Tipos tipo, int line, int column) {
        if (tipo == Tipo.Tipos.INTEGER) {
            return new Primitivo(tipo, 0, line, column);
        } else if (tipo == Tipo.Tipos.REAL) {
            return new Primitivo(tipo, 0.0, line, column);
        } else if (tipo == Tipo.Tipos.COMPLEX) {
            return new Primitivo(tipo, "(9.192517926E-43,0.00000000)", line, column);
        } else if (tipo == Tipo.Tipos.CHARACTER) {
            return new Primitivo(tipo, " ", line, column);
        } else if (tipo == Tipo.Tipos.LOGICAL) {
            return new Primitivo(tipo, false, line, column);
        }
        return null;
    }

}
