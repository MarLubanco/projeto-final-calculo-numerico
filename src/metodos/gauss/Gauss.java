package metodos.gauss;

import menu.Menu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gauss {
    private JPanel panel = new JPanel();
    private JFrame frame = new JFrame("Método de Gauss");
    private JButton calcular = new JButton("Calcular");
    private JButton finalizar = new JButton("Finalizar");

    public Gauss() {

    }

    public void init() {
        int telaWidth = 1000;
        int telaHeight = 650;
        int space = 5;

        Font myFont1 = new Font("Sans Serif Plain", Font.BOLD, 16);

        frame.setSize(telaWidth, telaHeight);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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

        // área das iteracoes
        TextArea iteracoes = new TextArea();
        iteracoes.setBounds(space + 50, 255, 470, 310);

        JLabel iteracoesLegenda = new JLabel();
        iteracoesLegenda.setFont(myFont1);
        iteracoesLegenda.setText("Iterações: ");
        iteracoesLegenda.setBounds(space + 50, 230, 100, 20);

        // botões:
        // botão calcular Gauss
        calcular.setLayout(null);
        calcular.setFont(myFont1);
        calcular.setBounds((telaWidth - 175), telaHeight - 100, 100, 30);
        calcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // pega os valores dos campos
                // linha 1
                double a11 = Integer.parseInt(tabela.getValueAt(0, 0).toString());
                double a12 = Integer.parseInt(tabela.getValueAt(0, 1).toString());
                double a13 = Integer.parseInt(tabela.getValueAt(0, 2).toString());
                double a14 = Integer.parseInt(tabela.getValueAt(0, 3).toString());

                // linha 2
                double a21 = Integer.parseInt(tabela.getValueAt(1, 0).toString());
                double a22 = Integer.parseInt(tabela.getValueAt(1, 1).toString());
                double a23 = Integer.parseInt(tabela.getValueAt(1, 2).toString());
                double a24 = Integer.parseInt(tabela.getValueAt(1, 3).toString());

                // linha 3
                double a31 = Integer.parseInt(tabela.getValueAt(2, 0).toString());
                double a32 = Integer.parseInt(tabela.getValueAt(2, 1).toString());
                double a33 = Integer.parseInt(tabela.getValueAt(2, 2).toString());
                double a34 = Integer.parseInt(tabela.getValueAt(2, 3).toString());

                // seta um valor pego do sistema original no sistema resultante
                // fórmula: l2 = l2 - ((a21/pivo) * l1)
                // pivo = a11
                tabelaResultante.setValueAt(a11, 0, 0);
                tabelaResultante.setValueAt(a12, 0, 1);
                tabelaResultante.setValueAt(a13, 0, 2);
                tabelaResultante.setValueAt(a14, 0, 3);

                //l2
                String calculoA21 = String.valueOf(a21 - ((a21/a11) * a11));
                tabelaResultante.setValueAt(calculoA21, 1, 0);

                String calculoA22 = String.valueOf(a22 - ((a21/a11) * a12));
                tabelaResultante.setValueAt(calculoA22, 1, 1);
                // pega o segundo pivo
                a22 = Double.parseDouble(calculoA22);

                String calculoA23 = String.valueOf(a23 - ((a21/a11) * a13));
                tabelaResultante.setValueAt(calculoA23, 1, 2);

                String calculoA24 = String.valueOf(a24 - ((a21/a11) * a14));
                tabelaResultante.setValueAt(calculoA24, 1, 3);

                // fórmula: l3 = l3 - ((a31/pivo) * l1))
                // pivo = a11
                String calculoA31 = String.valueOf(a31 - ((a31/a11) * a11));
                tabelaResultante.setValueAt(calculoA31, 2, 0);

                String calculoA32 = String.valueOf(a32- ((a31/a11) * a12));
                tabelaResultante.setValueAt(calculoA32, 2, 1);

                String calculoA33 = String.valueOf(a33 - ((a31/a11) * a13));
                tabelaResultante.setValueAt(calculoA33, 2, 2);

                String calculoA34 = String.valueOf(a34 - ((a31/a11) * a14));
                tabelaResultante.setValueAt(calculoA34, 2, 3);

                // fórmula: l3 = l3 - ((calculoA32/pivo) * l2))
                // pivo = a22
                String segundoCalculo32 = String.valueOf(Double.parseDouble(calculoA32) - (
                        (Double.parseDouble(calculoA32)/Double.parseDouble(calculoA22)) * Double.parseDouble(calculoA22)));
                tabelaResultante.setValueAt(segundoCalculo32, 2, 1);

                String segundoCalculo33 = String.valueOf(Double.parseDouble(calculoA33) - (
                        (Double.parseDouble(calculoA32)/Double.parseDouble(calculoA22)) * Double.parseDouble(calculoA23)));
                tabelaResultante.setValueAt(segundoCalculo33, 2, 2);

                String segundoCalculo34 = String.valueOf(Double.parseDouble(calculoA34) - (
                        (Double.parseDouble(calculoA32)/Double.parseDouble(calculoA22)) * Double.parseDouble(calculoA24)));
                tabelaResultante.setValueAt(segundoCalculo34, 2, 3);

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

        // botão finalizar ação
        finalizar.setLayout(null);
        finalizar.setFont(myFont1);
        finalizar.setBounds((telaWidth - 275), telaHeight - 100, 100, 30);
        finalizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu menu = new Menu();
                frame.setVisible(false);
                menu.iniciar();
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
        frame.add(calcular);
        frame.add(finalizar);
        frame.add(panel);
        frame.setVisible(true);
        panel.setVisible(true);
    }
}