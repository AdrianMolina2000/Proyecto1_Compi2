package Other;

public class Excepcion {
    String tipo;
    String descripcion;
    int line;
    int column;

    public Excepcion(String tipo, String descripcion, int line, int column) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.line = line;
        this.column = column;
    }

    @Override
    public String toString() {
        return "Error " + this.tipo + " en la linea " + this.line + " y columna " + this.column + ", " + this.descripcion;
    }
}
