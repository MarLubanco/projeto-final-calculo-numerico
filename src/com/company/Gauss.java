package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Gauss {
    private JPanel panel = new JPanel();
    private JFrame frame = new JFrame("Método de Gauss");
    private JButton calcular = new JButton("Calcular");
    private JButton finalizar = new JButton("Finalizar");
    // private JButton pegaOrdem = new JButton("Selecionar");

    Gauss() {

    }

    void frontEnd() {
        int telaWidth = 1000;
        int telaHeight = 650;
        int space = 5;

        Font myFont1 = new Font("Sans Serif Plain", Font.BOLD, 16);
        // Font myFont2 = new Font("Sans Serif Plain", Font.BOLD, 12);

        frame.setSize(telaWidth, telaHeight); // tamanho da tela
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//        TextField ordemSistema = new TextField(); // campo para ordem do sistema linear
//        ordemSistema.setBounds(space + 210, 5, campoTextoWidth, campoTextoHeigth);
//        ordemSistema.setFont(myFont1);

//        JLabel ordemSistemaLegenda = new JLabel();
//        ordemSistemaLegenda.setFont(myFont1);
//        ordemSistemaLegenda.setText("Ordem do Sistema = ");
//        ordemSistemaLegenda.setBounds(space + 50, 8, 160,  20);

        JLabel sistemaOriginal = new JLabel();
        sistemaOriginal.setFont(myFont1);
        sistemaOriginal.setText("Preencha o sistema linear: ");
        sistemaOriginal.setBounds(space + 50, 5, 260, 20);

        JLabel sistemaResultante = new JLabel();
        sistemaResultante.setFont(myFont1);
        sistemaResultante.setText("Sistema resultante: ");
        sistemaResultante.setBounds(space + 50, 120, 160, 20);

        // cria as matrizes
        JTable tabela = new JTable(3, 4);
        JTable tabelaResultante = new JTable(3, 4);
        tabela.setRowHeight(25);
        tabelaResultante.setRowHeight(25);
        tabela.setBounds(space + 50, 30, tabela.getColumnCount() * 50, tabela.getRowCount()
                * tabela.getRowHeight());
        tabelaResultante.setBounds(space + 50, 145, tabela.getColumnCount() * 50, tabela.getRowCount()
                * tabela.getRowHeight());

        JTextArea iteracoes = new JTextArea();
        iteracoes.setBounds(space + 50, 255, 470, 310);

        JLabel iteracoesLegenda = new JLabel();
        iteracoesLegenda.setFont(myFont1);
        iteracoesLegenda.setText("Iterações: ");
        iteracoesLegenda.setBounds(space + 50, 230, 100, 20);

        // botões
        calcular.setLayout(null);
        calcular.setFont(myFont1);
        calcular.setBounds((telaWidth - 175), telaHeight - 100, 100, 30);
        calcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // int tamanhoSistema = Integer.parseInt(ordemSistema.getText());

                // pega os valores dos campos
                int a11 = Integer.parseInt(tabela.getValueAt(0, 0).toString());
                int a12 = Integer.parseInt(tabela.getValueAt(0, 1).toString());
                int a13 = Integer.parseInt(tabela.getValueAt(0, 2).toString());
                int a14 = Integer.parseInt(tabela.getValueAt(0, 3).toString());

                int a21 = Integer.parseInt(tabela.getValueAt(1, 0).toString());
                int a22 = Integer.parseInt(tabela.getValueAt(1, 1).toString());
                int a23 = Integer.parseInt(tabela.getValueAt(1, 2).toString());
                int a24 = Integer.parseInt(tabela.getValueAt(1, 3).toString());

                int a31 = Integer.parseInt(tabela.getValueAt(2, 0).toString());
                int a32 = Integer.parseInt(tabela.getValueAt(2, 1).toString());
                int a33 = Integer.parseInt(tabela.getValueAt(2, 2).toString());
                int a34 = Integer.parseInt(tabela.getValueAt(2, 3).toString());

                // seta um valor pego do sistema original no sistema resultante
                // pivo = a11
                // fórmula: l2 = l2 - ((a21/pivo) * l1)
                tabelaResultante.setValueAt(a11, 0, 0);
                tabelaResultante.setValueAt(a12, 0, 1);
                tabelaResultante.setValueAt(a13, 0, 2);
                tabelaResultante.setValueAt(a14, 0, 3);

                //l2
                String calculoA21 = String.valueOf(a21 - ((a21/a11) * a11));
                tabelaResultante.setValueAt(calculoA21, 1, 0);
                // a21 = Integer.parseInt(calculoA21);

                String calculoA22 = String.valueOf(a22 - ((a21/a11) * a12));
                tabelaResultante.setValueAt(calculoA22, 1, 1);
                a22 = Integer.parseInt(calculoA22);

                String calculoA23 = String.valueOf(a23 - ((a21/a11) * a13));
                tabelaResultante.setValueAt(calculoA23, 1, 2);
                // a23 = Integer.parseInt(calculoA23);

                String calculoA24 = String.valueOf(a24 - ((a21/a11) * a14));
                tabelaResultante.setValueAt(calculoA24, 1, 3);
                // a24 = Integer.parseInt(calculoA24);

                // pivo = a11
                // fórmula: l3 = l3 - ((a31/pivo) * l1))
                String calculoA31 = String.valueOf(a31 - ((a31/a11) * a11));
                tabelaResultante.setValueAt(calculoA31, 2, 0);
                // a31 = Integer.parseInt(calculoA31);

                String calculoA32 = String.valueOf(a32- ((a31/a11) * a12));
                tabelaResultante.setValueAt(calculoA32, 2, 1);
                // a32 = Integer.parseInt(calculoA32);

                String calculoA33 = String.valueOf(a33 - ((a31/a11) * a13));
                tabelaResultante.setValueAt(calculoA33, 2, 2);
                // a33 = Integer.parseInt(calculoA33);

                String calculoA34 = String.valueOf(a34 - ((a31/a11) * a14));
                tabelaResultante.setValueAt(calculoA34, 2, 3);
                // a34 = Integer.parseInt(calculoA34);

                // pivo = a22
                // fórmula: l3 = l3 - ((calculoA32/pivo) * l2))
                String segundoCalculo32 = String.valueOf(Integer.parseInt(calculoA32) - (
                        (Integer.parseInt(calculoA32)/Integer.parseInt(calculoA22)) * Integer.parseInt(calculoA22)));
                tabelaResultante.setValueAt(segundoCalculo32, 2, 1);

                String segundoCalculo33 = String.valueOf(Integer.parseInt(calculoA33) - (
                        (Integer.parseInt(calculoA32)/Integer.parseInt(calculoA22)) * Integer.parseInt(calculoA23)));
                tabelaResultante.setValueAt(segundoCalculo33, 2, 2);

                String segundoCalculo34 = String.valueOf(Integer.parseInt(calculoA34) - (
                        (Integer.parseInt(calculoA32)/Integer.parseInt(calculoA22)) * Integer.parseInt(calculoA24)));
                tabelaResultante.setValueAt(segundoCalculo34, 2, 3);

                // tabela de iterações:
                iteracoes.setText("Pivo = " + a11 + '\n' +
                        '\n' +
                        "Primeira linha: " + '\n' +
                        "a11 = " + a11 + ", " + "a12 = " + a12 + ", " + "a13 = " + a13 + ", " + "a14 = " + a14 + '\n' +
                        "Segunda linha: " + '\n' +
                        "a21 = a21 - ((a21/a11) * a11) = " + calculoA21 + '\n' +
                        "a22 = a22 - ((a21/a11) * a12 = " + calculoA22 + '\n' +
                        "a23 = a23 - ((a21/a11) * a13) = " + calculoA23 + '\n' +
                        "a24 = a24 - ((a21/a11) * a14) = " + calculoA24 + '\n' +
                        "Terceira linha: " + '\n' +
                        "a31 = a31 - ((a31/a11) * a11) = " + calculoA31 + '\n' +
                        "a32 = a32 - ((a31/a11) * a12) = " + calculoA32 + '\n' +
                        "a33 = a33 - ((a31/a11) * a13) = " + calculoA33 + '\n' +
                        "a34 = a34 - ((a31/a11) * a14) = " + calculoA34 + '\n' +
                        '\n' +
                        "Pivo = " + a22 + '\n' +
                        "a32 = a32 - ((a32/a22) * a22) = " + segundoCalculo32 + '\n' +
                        "a33 = a33 - ((a32/a22) * a33) = " + segundoCalculo33 + '\n' +
                        "a34 = a34 - ((a33/a22) * a34) = " + segundoCalculo34 + '\n');
            }
        });

        finalizar.setLayout(null);
        finalizar.setFont(myFont1);
        finalizar.setBounds((telaWidth - 275), telaHeight - 100, 100, 30);
        finalizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu menu = new Menu();
                frame.setVisible(false);
                menu.frontEnd();
            }
        });

        // adiciona objetos à tela:
        frame.setBackground(Color.white);
        frame.add(iteracoesLegenda);
        frame.add(iteracoes);
        frame.add(sistemaOriginal);
        frame.add(sistemaResultante);
        frame.add(tabela);
        frame.add(tabelaResultante);
        frame.add(calcular); // add o botão 'calcular'
        frame.add(finalizar);
        frame.add(panel);
        frame.setVisible(true);
        panel.setVisible(true);
    }
}