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

    public String getTabla(){
        return  "<TR><TD>" + (tipo == null ? "TIPO DE ERROR" : tipo) + "</TD>" +
                "<TD>" + (line < 0 ? "FILA" : line) + "</TD>" +
                "<TD>" + (column < 0 ? "COLUMNA" : column) + "</TD>"+
                "<TD>" + descripcion + "</TD></TR>";
    }

    @Override
    public String toString() {
        return "Error " + this.tipo + " en la linea " + this.line + " y columna " + this.column + ", " + this.descripcion;
    }
}
