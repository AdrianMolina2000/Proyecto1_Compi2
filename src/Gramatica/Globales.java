package Gramatica;

import Abstract.NodoAST;
import Expresiones.Primitivo;
import Other.Tipo;
import Symbols.Tree;
import org.antlr.v4.gui.TreeViewer;

import java.io.*;

public class Globales {

    public static String entrada = "";
    public static String salida = "";
    public static Tree tree;
    public static NodoAST nodoRaiz;
    public static TreeViewer treeViewer;

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

    public static void graphAST(NodoAST raiz){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("C:/Reportes/ast.txt");
            pw = new PrintWriter(fichero);

            String diag = getDot(raiz);

            pw.println(diag);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para
                // asegurarnos que se cierra el fichero.
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }



        try {
            String filePath1 = "C:/Reportes/ast.txt";
            File file1 = new File(filePath1);
            String path1 = file1.getPath();

            String filePath2 = "C:/Reportes/Ast.pdf";
            File file2 = new File(filePath2);
            String path2 = file2.getPath();

            String fileInputPath = path1;
            String fileOutputPath = path2;

            String tParam = "-Tpdf";
            String tOParam = "-o";

            String[] cmd = new String[5];
            cmd[0] = "C:/Program Files/Graphviz/bin/dot.exe";
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;

            Runtime rt = Runtime.getRuntime();
            rt.exec( cmd );
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    static int c = 1;
    static String grafo = "";

    static public String getDot(NodoAST raiz){
        grafo = "";
        grafo += "digraph {\n";//                         "     \"
        grafo += "n0[label=\"" + raiz.getValor() + "\"];\n";
        c = 1;
        recorrerAST("n0", raiz);
        grafo += "}";
        return grafo;
    }

    static public void recorrerAST(String padre, NodoAST nPadre){
        for(NodoAST hijo: nPadre.getHijos()){
            String nombreHijo = "n" + c;
            grafo += nombreHijo + "[label=\"" + hijo.getValor()+ "\"];\n";
            grafo += padre + "->" + nombreHijo + ";\n";
            c++;
            recorrerAST(nombreHijo, hijo);
        }
    }
}
