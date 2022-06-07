import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Gramatica.*;
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

                Globales.entrada = textArea1.getText();
                Globales.salida = "";

                CharStream cs = fromString(Globales.entrada);

                GramaticaLexer lexico = new GramaticaLexer(cs);
                CommonTokenStream tokens = new CommonTokenStream(lexico);
                GramaticaParser sintactico = new GramaticaParser(tokens);
                GramaticaParser.StartContext startCtx = sintactico.start();

                Visitor visitor = new Visitor();
                visitor.visit(startCtx);


                textArea2.setText(Globales.salida);
            }
        });
    }
}
