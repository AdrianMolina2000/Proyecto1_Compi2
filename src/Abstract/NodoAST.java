package Abstract;

import java.util.ArrayList;

public class NodoAST {
    String valor;
    ArrayList<NodoAST> hijos;

    public NodoAST(String valor) {
        this.valor = valor;
        this.hijos = new ArrayList<>();
    }

    public void agregarHijo(Object hijo){
        if (hijo instanceof NodoAST hi) {
            this.hijos.add(hi);
        } else {
            this.hijos.add(new NodoAST((String)hijo));
        }
    }

    public void agregarHijos(ArrayList<NodoAST> listaHijos){
        for(NodoAST hijo : listaHijos){
            hijos.add(hijo);
        }
    }

    public void agregarPrimerHijo(Object hijo){
        if (hijo instanceof String hi) {
            this.hijos.add(0, new NodoAST(hi));
        } else if (hijo instanceof NodoAST hi) {
            this.hijos.add(0, hi);
        }
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public ArrayList<NodoAST> getHijos() {
        return hijos;
    }

    public void setHijos(ArrayList<NodoAST> hijos) {
        this.hijos = hijos;
    }
}
