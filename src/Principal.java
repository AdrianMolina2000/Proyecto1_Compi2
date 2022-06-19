import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import Abstract.Nodo;
import Abstract.NodoAST;
import Gramatica.*;
import Other.Excepcion;
import Symbols.C3D;
import Symbols.Simbolo;
import Symbols.Table;
import Symbols.Tree;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.*;

import static org.antlr.v4.runtime.CharStreams.fromString;




public class Principal extends JFrame{
    private JPanel mainPanel;
    private JButton Compilar;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JButton ASTButton;
    private JButton CSTButton;
    private JButton simbolosButton;
    private JButton erroresButton;
    private JTextArea textArea3;
    private JScrollPane scrollPane1;
    private JScrollPane scrollPane2;
    private JButton c3DButton;

    public static void main(String[] args) {
        JFrame frame = new Principal("Compilador");
        frame.setSize(1500, 800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public Principal(String title) throws HeadlessException {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        Compilar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Globales.tree = new Tree();

                //Para 3D
                C3D genAux = new C3D();
                Globales.gen = genAux.getInstance();

                Globales.entrada = textArea1.getText();
                Globales.salida = "";

                CharStream cs = fromString(Globales.entrada);

                GramaticaLexer lexico = new GramaticaLexer(cs);

                Globales.tree.excepciones.add(new Excepcion(null, "DESCRIPCION", -1, -1));
                //MANEJO DE ERRORES LEXICOS
                lexico.removeErrorListeners();
                lexico.addErrorListener(new BaseErrorListener() {
                    @Override
                    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                        Globales.tree.excepciones.add(new Excepcion("Lexico", msg, line, charPositionInLine));
                    }
                });

                CommonTokenStream tokens = new CommonTokenStream(lexico);
                GramaticaParser sintactico = new GramaticaParser(tokens);

                //MANEJO DE ERRORES SINTACTICOS
                sintactico.removeErrorListeners();
                sintactico.addErrorListener(new BaseErrorListener() {
                    @Override
                    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                        Globales.tree.excepciones.add(new Excepcion("Sintactico", msg, line, charPositionInLine));
                    }
                });

                GramaticaParser.StartContext startCtx = sintactico.start();

                Visitor visitor = new Visitor();
                Object treeAST = visitor.visit(startCtx);

                java.util.List<String> ruleNames = Arrays.asList(sintactico.getRuleNames());
                Globales.treeViewer = new TreeViewer(ruleNames, startCtx);

                Table table = new Table(null);
                Globales.tree.instrucciones = (ArrayList<Nodo>) treeAST;

                Globales.nodoRaiz = new NodoAST("RAIZ");

                for(int i = 0; i<Globales.tree.instrucciones.size(); i++){
                    Object res = Globales.tree.instrucciones.get(i).execute(table, Globales.tree);
                    //ERROR
                    if(res instanceof Excepcion er){
                        Globales.tree.consola.add(er.toString());
                    }
                    Globales.nodoRaiz.agregarHijo(Globales.tree.instrucciones.get(i).getAST());
                }

                for(int i = 0; i < Globales.tree.consola.size(); i++){
                    Globales.salida += Globales.tree.consola.get(i);
                }


                textArea2.setText(Globales.salida);




            }
        });


        ASTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Globales.graphAST(Globales.nodoRaiz);
            }
        });
        CSTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Globales.treeViewer.open();
            }
        });
        simbolosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String reportVar = "digraph E { node[shape = plain] tabla [label = <<TABLE>";
                reportVar += "<TR><TD> TIPO1 </TD>" +
                        "<TD> TIPO2 </TD>" +
                        "<TD> NOMBRE </TD>"+
                        "<TD> LINEA </TD>"+
                        "<TD> COLUMNA </TD></TR>";

                for(Simbolo sim: Globales.tree.Variables) {
                    reportVar += "<TR><TD>" + sim.tipo.toString() + "</TD>" +
                            "<TD>" + sim.tipo2.toString() + "</TD>" +
                            "<TD>" + sim.id + "</TD>" +
                            "<TD>" + sim.line + "</TD>" +
                            "<TD>" + sim.column + "</TD></TR>";
                }

                for (String clave : Globales.tree.funciones.keySet()) {
                    Simbolo sim = Globales.tree.funciones.get(clave);

                    reportVar += "<TR><TD>" + sim.tipo.toString() + "</TD>" +
                            "<TD>" + sim.tipo2.toString() + "</TD>" +
                            "<TD>" + sim.id + "</TD>" +
                            "<TD>" + sim.line + "</TD>" +
                            "<TD>" + sim.column + "</TD></TR>";
                }

                for (String clave : Globales.tree.metodos.keySet()) {
                    Simbolo sim = Globales.tree.metodos.get(clave);

                    reportVar += "<TR><TD>" + sim.tipo.toString() + "</TD>" +
                            "<TD>" + sim.tipo2.toString() + "</TD>" +
                            "<TD>" + sim.id + "</TD>" +
                            "<TD>" + sim.line + "</TD>" +
                            "<TD>" + sim.column + "</TD></TR>";
                }

                reportVar += "</TABLE>>]; }";



                FileWriter fichero = null;
                PrintWriter pw = null;
                try
                {
                    fichero = new FileWriter("C:/Reportes/simbolos.txt");
                    pw = new PrintWriter(fichero);

                    pw.println(reportVar);
                } catch (Exception e1) {
                    e1.printStackTrace();
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
                    Runtime.getRuntime().exec("dot -Tpdf C:/Reportes/simbolos.txt -o C:/Reportes/simbolos.pdf");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        erroresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String reportError = "digraph E { node[shape = plain] tabla [label = <<TABLE>";
                for(Excepcion err: Globales.tree.excepciones)
                    reportError += err.getTabla();
                reportError += "</TABLE>>]; }";

                FileWriter fichero = null;
                PrintWriter pw = null;
                try
                {
                    fichero = new FileWriter("C:/Reportes/errores.txt");
                    pw = new PrintWriter(fichero);

                    pw.println(reportError);
                } catch (Exception e1) {
                    e1.printStackTrace();
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
                    Runtime.getRuntime().exec("dot -Tpdf C:/Reportes/errores.txt -o C:/Reportes/errores.pdf");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        c3DButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Globales.gen == null){
                    //Para 3D
                    C3D genAux = new C3D();
                    Globales.gen = genAux.getInstance();
                }

                textArea3.setText(Globales.gen.getCode());
            }
        });
    }
}

