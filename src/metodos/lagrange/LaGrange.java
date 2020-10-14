package metodos.lagrange;

import menu.Menu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaGrange {
    private JPanel panel = new JPanel();
    private JFrame frame = new JFrame("Método de LaGrange");
    private JButton finalizar = new JButton("Finalizar");

    public LaGrange() {

    }

    public void init() {
        int telaWidth = 1000;
        int telaHeight = 650;
        int space = 5;

        Font myFont1 = new Font("Sans Serif Plain", Font.BOLD, 16);

        frame.setSize(telaWidth, telaHeight);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel jLabel = new JLabel();
        jLabel.setFont(myFont1);
        jLabel.setText("LaGrange");
        jLabel.setBounds(100, 20, 100, 100);

        // botão finalizar ação
        finalizar.setLayout(null);
        finalizar.setFont(myFont1);
        finalizar.setBounds((telaWidth - 275), telaHeight - 100, 100, 30);
        finalizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu.Menu menu = new Menu();
                frame.setVisible(false);
                menu.iniciar();
            }
        });

        frame.setBackground(Color.white);
        frame.add(jLabel);
        frame.add(panel);
        frame.setVisible(true);
        panel.setVisible(true);
    }
}