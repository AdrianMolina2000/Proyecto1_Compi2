package Expresiones;

import Abstract.Nodo;
import Abstract.NodoAST;
import Gramatica.Globales;
import Other.Tipo;
import Symbols.C3D;
import Symbols.Table;
import Symbols.Tree;


public class Primitivo extends Nodo {
    Object valor;

    public Primitivo(Tipo.Tipos tipo, Object valor, int line, int column) {
        super(tipo, line, column);
        this.valor = valor;
    }

    public Object execute(Table table, Tree tree){
        if(Globales.gen == null){
            //Para 3D
            C3D genAux = new C3D();
            Globales.gen = genAux.getInstance();
        }

        if(this.tipo == Tipo.Tipos.INTEGER || this.tipo == Tipo.Tipos.REAL){

            //Guardo valores
            this.valor3D = String.valueOf(this.valor);
            this.tmp = false;

        }else if (this.tipo == Tipo.Tipos.CHARACTER){

            String entrada = String.valueOf(this.valor);
            entrada = entrada.replace("\"", "");
            entrada = entrada.replace("'", "");

            char character = entrada.charAt(0);
            int ascii = character;

            //Guardo valores
            this.valor3D = String.valueOf(ascii);
            this.tmp = false;

            return entrada;

        }else if (this.tipo == Tipo.Tipos.LOGICAL){
            if(this.ev == null){
                this.ev = Globales.gen.newLabel();
            }
            if(this.ef == null){
                this.ef = Globales.gen.newLabel();
            }

            if((boolean)this.valor){
                Globales.gen.addGoto(ev);
                Globales.gen.addGoto(ef);
            }else{
                Globales.gen.addGoto(ef);
                Globales.gen.addGoto(ev);
            }

            //Guardo valores
            this.valor3D = String.valueOf(this.valor);
            this.tmp = false;
            this.ev = ev;
            this.ef = ef;

        }else if (this.tipo == Tipo.Tipos.STRING || this.tipo == Tipo.Tipos.COMPLEX){
            Globales.gen.addComment("Guardando cadena en el heap");
            String temp = Globales.gen.addTemp();
            Globales.gen.addExp(temp, "H", "", "");

            String entrada = String.valueOf(this.valor);
            entrada = entrada.replace("\"", "");
            entrada = entrada.replace("'", "");

            for(int c = 0; c < entrada.length(); c++){
                char character = entrada.charAt(c);
                int ascii = character;

                Globales.gen.setHeap("H", String.valueOf(ascii)); //heap[H] = NUM;
                Globales.gen.nextHeap(); //H = H + 1;
            }

            Globales.gen.setHeap("H", "-1");
            Globales.gen.nextHeap();
            Globales.gen.addComment("Fin cadena en el heap");

            this.valor3D = temp;
            this.tmp = true;
            return entrada;
        }

        //RETORNA EL VALOR GENERAL
        return this.valor;
    }

    @Override
    public NodoAST getAST() {
        NodoAST nodo;
        if(Tipo.Tipos.STRING == this.tipo){
            String val = String.valueOf(this.valor).replace("\"", "");
            nodo = new NodoAST(val);
        }else{
            nodo = new NodoAST(String.valueOf(this.valor));
        }
        return nodo;
    }
}
