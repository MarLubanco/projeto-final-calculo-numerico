package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Menu {
    private JPanel panel = new JPanel();
    private JFrame frame = new JFrame("Menu");
    private JButton bisseccaoButton = new JButton("Bissecção");
    private JButton gaussButton = new JButton("Gauss");
    private JLabel perguntaMetodo = new JLabel();
    private Bisseccao bisseccao = new Bisseccao();
    private Gauss gauss = new Gauss();

    Menu() {

    }

    void frontEnd() {
        int telaWidth = 955;
        int telaHeight = 450;
        Font myFont1 = new Font("Sans Serif Plain", Font.BOLD, 16);

        frame.setSize(telaWidth, telaHeight); // tamanho da tela
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        bisseccaoButton.setLayout(null);
        bisseccaoButton.setFont(myFont1);
        bisseccaoButton.setBounds((telaWidth - 615), telaHeight - 100, 130, 30);
        gaussButton.setLayout(null);
        gaussButton.setFont(myFont1);
        gaussButton.setBounds((telaWidth - 485), telaHeight - 100, 130, 30);

        perguntaMetodo.setFont(myFont1);
        perguntaMetodo.setText("Selecione um método: ");
        perguntaMetodo.setBounds(380, 150, 300, 40);

        frame.add(bisseccaoButton);
        frame.add(gaussButton);
        frame.add(perguntaMetodo);
        frame.add(panel);
        frame.setBackground(Color.white);
        frame.setVisible(true);
        panel.setVisible(true);

        bisseccaoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bisseccao.frontEnd();
                frame.setVisible(false);
            }
        });

        gaussButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gauss.frontEnd();
                frame.setVisible(false);
            }
        });
    }
}