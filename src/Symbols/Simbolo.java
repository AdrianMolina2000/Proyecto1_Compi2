package Symbols;
import Gramatica.Globales;
import Other.Tipo;

public class Simbolo {
    public Tipo tipo;
    public Tipo tipo2;
    public String id;
    public Object valor;
    public int line;
    public int column;
    Table ambito;
    public int pos;
    public boolean inFunc;
    public boolean isGlobal = false;


    public Simbolo(Tipo tipo, Tipo tipo2, String id, Object valor, int line, int column, Table ambito, boolean inFunc){
        this.tipo = tipo;
        this.tipo2 = tipo2;
        this.id = id;
        this.valor = valor;
        this.line = line;
        this.column = column;
        this.ambito = ambito;
        this.inFunc = inFunc;
    }

}
