package metodos.lagrangeTeste;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * JanelaErro: classe que se parece com uma MessageBox do Windows
 */
public class JanelaErro extends Frame implements ActionListener, WindowListener {
    private Label lbMensagem = new Label();
    private Button btnOk = new Button("OK");
    private Panel p1 = new Panel();
    private Panel p2 = new Panel();

    JanelaErro(String titulo, String mensagem) {
        super(titulo);

        setLayout(new BorderLayout());
        add("Center", p1);
        add("South", p2);

        lbMensagem.setText(mensagem);

        p1.add(lbMensagem);
        p2.add(btnOk);

        btnOk.addActionListener(this);
        addWindowListener(this);

        setSize(150, 150);
        setResizable(false);
        show();
    }

    public void actionPerformed(ActionEvent e) {
        hide();
    }

    public void windowClosing(WindowEvent e) {
        hide();
    }

    public void windowOpened(WindowEvent e) {
    }

    public void windowClosed(WindowEvent e) {
    }

    public void windowIconified(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
    }

    public void windowActivated(WindowEvent e) {
    }

    public void windowDeactivated(WindowEvent e) {
    }

    public void mudaMensagem(String novaMensagem) {
        lbMensagem.setText(novaMensagem);
    }

    public String retornaMensagem() {
        return lbMensagem.getText();
    }
}