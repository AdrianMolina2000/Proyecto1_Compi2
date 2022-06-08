package Other;

public class Tipo {
    public enum Tipos{
        INTEGER,
        REAL,
        COMPLEX,
        CHARACTER,
        LOGICAL,
        ARREGLO,
        VOID,
        METODO,
        FUNCION,
        VARIABLE,
        NULL
    }

    Tipos tipo;

    public Tipo(Tipos tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        if (this.tipo == Tipos.INTEGER) {
            return "entero";
        } else if (this.tipo == Tipos.REAL) {
            return "real";
        } else if (this.tipo == Tipos.COMPLEX) {
            return "complex";
        } else if (this.tipo == Tipos.CHARACTER) {
            return "caracter";
        } else if (this.tipo == Tipos.LOGICAL) {
            return "logico";
        }else if (this.tipo == Tipos.ARREGLO) {
            return "arreglo";
        }else if (this.tipo == Tipos.VOID) {
            return "void";
        }else if (this.tipo == Tipos.METODO) {
            return "metodo";
        }else if (this.tipo == Tipos.FUNCION) {
            return "funcion";
        }else if (this.tipo == Tipos.VARIABLE) {
            return "variable";
        }else if (this.tipo == Tipos.NULL) {
            return "Lista";
        }
        return "";
    }
}
