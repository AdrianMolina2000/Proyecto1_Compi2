import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Gramatica.*;
import Symbols.Table;
import Symbols.Tree;
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

                Globales.tree = new Tree();
                Globales.entrada = textArea1.getText();
                Globales.salida = "";

                CharStream cs = fromString(Globales.entrada);

                GramaticaLexer lexico = new GramaticaLexer(cs);
                CommonTokenStream tokens = new CommonTokenStream(lexico);
                GramaticaParser sintactico = new GramaticaParser(tokens);
                GramaticaParser.StartContext startCtx = sintactico.start();

                Visitor visitor = new Visitor();
                visitor.visit(startCtx);

                Table table = new Table(null);
                for(int i = 0; i<Globales.tree.instrucciones.size(); i++){
                    Globales.tree.instrucciones.get(i).execute(table, Globales.tree);
                }

                for(int i = 0; i < Globales.tree.consola.size(); i++){
                    Globales.salida += Globales.tree.consola.get(i) + "\n";
                }

                textArea2.setText(Globales.salida);
            }
        });
    }
}

