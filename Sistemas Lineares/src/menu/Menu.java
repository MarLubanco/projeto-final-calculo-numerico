package menu;

import metodos.bisseccao.Bisseccao;
import metodos.gauss.Gauss;
import metodos.lagrange.LaGrange;
import metodos.lagrangeTeste.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    private JPanel panel = new JPanel();
    private JFrame frame = new JFrame("Menu");
    private JButton bisseccaoButton = new JButton("Bissecção");
    private JButton gaussButton = new JButton("Gauss");
    private JButton laGrangeButton = new JButton("LaGrange");
    private JLabel perguntaMetodo = new JLabel();
    private Bisseccao bisseccao = new Bisseccao();
    private Gauss gauss = new Gauss();
    private LaGrange laGrange = new LaGrange();
    // private MetodosInterpolacao metodosInterpolacao = new MetodosInterpolacao();

    public Menu() {

    }

    public void iniciar() {
        int telaWidth = 955;
        int telaHeight = 450;
        Font myFont1 = new Font("Sans Serif Plain", Font.BOLD, 16);

        frame.setSize(telaWidth, telaHeight);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // botões:
        // botão Bisseccao
        bisseccaoButton.setLayout(null);
        bisseccaoButton.setFont(myFont1);
        bisseccaoButton.setBounds((telaWidth - 670), telaHeight - 100, 130, 30);
        bisseccaoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bisseccao.init();
                frame.setVisible(false);
            }
        });

        // botão Gauss
        gaussButton.setLayout(null);
        gaussButton.setFont(myFont1);
        gaussButton.setBounds((telaWidth - 540), telaHeight - 100, 130, 30);
        gaussButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gauss.init();
                frame.setVisible(false);
            }
        });

        // botão LaGrange
        laGrangeButton.setLayout(null);
        laGrangeButton.setFont(myFont1);
        laGrangeButton.setBounds((telaWidth - 410), telaHeight - 100, 130, 30);
        laGrangeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                laGrange.init();
                frame.setVisible(false);
            }
        });

        perguntaMetodo.setFont(myFont1);
        perguntaMetodo.setText("Selecione um método: ");
        perguntaMetodo.setBounds(380, 150, 300, 40);

        // adiciona os objetos:
        frame.add(laGrangeButton);
        frame.add(bisseccaoButton);
        frame.add(gaussButton);
        frame.add(perguntaMetodo);
        frame.add(panel);
        frame.setBackground(Color.white);
        frame.setVisible(true);
        panel.setVisible(true);
    }
}