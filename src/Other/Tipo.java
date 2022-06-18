package Other;

public class Tipo {
    public enum Tipos{
        INTEGER,
        REAL,
        COMPLEX,
        CHARACTER,
        LOGICAL,
        ARREGLO,
        ARREGLO2,
        ALLOCATE,
        ALLOCATE2,
        STRING,
        VOID,
        METODO,
        FUNCION,
        VARIABLE,
        NULL
    }

    public Tipos tipo;

    public Tipo(Tipos tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        if (this.tipo == Tipos.INTEGER) {
            return "Entero";
        } else if (this.tipo == Tipos.REAL) {
            return "Real";
        } else if (this.tipo == Tipos.COMPLEX) {
            return "Complex";
        } else if (this.tipo == Tipos.CHARACTER) {
            return "Caracter";
        } else if (this.tipo == Tipos.LOGICAL) {
            return "Logico";
        }else if (this.tipo == Tipos.ARREGLO) {
            return "Arreglo";
        }else if (this.tipo == Tipos.ARREGLO2) {
            return "Arreglo2D";
        }else if (this.tipo == Tipos.ALLOCATE) {
            return "Allocatable";
        }else if (this.tipo == Tipos.ALLOCATE2) {
            return "Allocate2";
        }else if (this.tipo == Tipos.VOID) {
            return "Void";
        }else if (this.tipo == Tipos.METODO) {
            return "Metodo";
        }else if (this.tipo == Tipos.FUNCION) {
            return "Funcion";
        }else if (this.tipo == Tipos.VARIABLE) {
            return "Variable";
        }else if (this.tipo == Tipos.NULL) {
            return "Lista";
        }
        return "";
    }
}
