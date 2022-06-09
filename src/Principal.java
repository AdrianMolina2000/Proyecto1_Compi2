import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Abstract.Nodo;
import Gramatica.*;
import Symbols.Table;
import Symbols.Tree;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import static org.antlr.v4.runtime.CharStreams.fromString;




public class Principal extends JFrame{
    private JPanel mainPanel;
    private JButton button1;
    private JTextArea textArea1;
    private JTextArea textArea2;

    public static void main(String[] args) {

        JFrame frame = new Principal("Compilador");
        frame.setSize(1000,600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public Principal(String title) throws HeadlessException {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tree tree = new Tree();
                Globales.entrada = textArea1.getText();
                Globales.salida = "";

                CharStream cs = fromString(Globales.entrada);

                GramaticaLexer lexico = new GramaticaLexer(cs);
                CommonTokenStream tokens = new CommonTokenStream(lexico);
                GramaticaParser sintactico = new GramaticaParser(tokens);
                GramaticaParser.StartContext startCtx = sintactico.start();

                Visitor visitor = new Visitor();
                Object treeAST = visitor.visit(startCtx);

                Table table = new Table(null);
                tree.instrucciones = (ArrayList<Nodo>) treeAST;

                for(int i = 0; i<tree.instrucciones.size(); i++){
                    tree.instrucciones.get(i).execute(table, tree);
                }

                for(int i = 0; i < tree.consola.size(); i++){
                    Globales.salida += tree.consola.get(i);
                }

                textArea2.setText(Globales.salida);


                /*List<String> ruleNames = Arrays.asList(sintactico.getRuleNames());
                TreeViewer treeViewer = new TreeViewer(ruleNames, startCtx);
                treeViewer.open();*/
            }
        });
    }
}

