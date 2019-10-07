package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Bisseccao {
    private JFrame frame = new JFrame("Método da Bissecção");
    private JButton buttonCalcular = new JButton("Calcular");
    private JButton buttonFinalizar = new JButton("Finalizar");
    private JPanel panel = new JPanel();
    private float[] valoresX = {-5,-4,-3,-2,-1,0,1,2,3,4,5};
    private float[] resultadosX = new float[valoresX.length];
    private float[] zeros = new float[valoresX.length];
    private TextField campo1 = new TextField(); // novo campo de texto
    private TextField campo2 = new TextField();
    private TextField campo3 = new TextField();
    private TextField campo4 = new TextField();
    private TextField campo5 = new TextField();
    private TextField campo6 = new TextField();
    private TextField expoenteEpsilon = new TextField();
    private TextField intervalo1 = new TextField(); // campo intervalo 1
    private TextField intervalo2 = new TextField(); // campo intervalo 2
    private TextField resultado = new TextField(); // campo resultado
    private TextField operador = new TextField(); // novo campo para operador
    private TextField operador2 = new TextField();
    private TextField operador3 = new TextField();
    private TextField operador4 = new TextField();
    private TextField operador5 = new TextField();
    private TextArea iteracoes = new TextArea(); // campo interacao 1
    private float textof;
    private float texto2f;
    private float texto3f;
    private float texto4f;
    private float texto5f;
    private float texto6f;
    private float intervalo1f;
    private float intervalo2f;
    private String saida = "";

    Bisseccao() {

    }

    void frontEnd() {
        int telaWidth = 1050;
        int telaHeight = 500;
        int legendaWidth = 45;
        int legendaHeigth = 15;
        int campoTextoWidth = 80;
        int campoTextoHeigth = 25;
        int space = 8;
        frame.setSize(telaWidth, telaHeight); // tamanho da tela
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Font myFont1 = new Font("Sans Serif Plain", Font.BOLD, 16);

        JLabel fx = new JLabel();
        fx.setText("f(x)= ");
        fx.setBounds(3, 25, legendaWidth, 15);
        fx.setFont(myFont1);

        campo1.setBounds(space + 30, 20, campoTextoWidth, campoTextoHeigth); // posicoes do campo de texto: (x, y, largura, altura)
        JLabel textoLegenda = new JLabel(); // novo texto
        textoLegenda.setText("x^5"); // escrita do texto
        textoLegenda.setBounds(campo1.getX() + campoTextoWidth + space, 20, legendaWidth, legendaHeigth); // posições do texto
        textoLegenda.setFont(myFont1);

        JLabel epsilon = new JLabel();
        epsilon.setText("E^");
        epsilon.setBounds(campo1.getX(), 45, 70, legendaHeigth + 10);
        epsilon.setFont(myFont1);
        expoenteEpsilon.setBounds(campo1.getX() + 20, 50, 20, campoTextoHeigth);

        iteracoes.setBounds(campo1.getX(), 135, 550, 275);

        JLabel intervaloLegenda = new JLabel(); // nova legenda("Intervalo")
        intervaloLegenda.setText("Intervalo = ");
        intervaloLegenda.setBounds(campo1.getX(), 70, 150, legendaHeigth + 10);
        intervaloLegenda.setFont(myFont1);
        intervalo1.setBounds(campo1.getX(), 90, 45, campoTextoHeigth);
        intervalo2.setBounds(campo1.getX() + 45, 90, 45, campoTextoHeigth);

        JLabel resultadoLegenda = new JLabel();  // nova legenda("Resultado")
        resultadoLegenda.setText("Resultado = ");
        resultadoLegenda.setBounds(campo1.getX(), 115, 150, legendaHeigth + 10);
        resultadoLegenda.setFont(myFont1);
        resultado.setBounds(campo1.getX(), 130, campoTextoWidth, campoTextoHeigth);

        operador.setBounds(textoLegenda.getX() + space + 30, 20, 20, campoTextoHeigth); // posições do campo para operador

        campo2.setBounds(textoLegenda.getX() + campoTextoWidth + space, 20, campoTextoWidth, campoTextoHeigth);
        JLabel texto2Legenda = new JLabel();
        texto2Legenda.setText("x^4");
        texto2Legenda.setBounds(campo2.getX() + campoTextoWidth + space, 20, legendaWidth, legendaHeigth);
        texto2Legenda.setFont(myFont1);

        operador2.setBounds(texto2Legenda.getX() + space + 30, 20, 20, campoTextoHeigth);

        campo3.setBounds(texto2Legenda.getX() + campoTextoWidth + space, 20, campoTextoWidth, campoTextoHeigth);
        JLabel texto3Legenda = new JLabel();
        texto3Legenda.setText("x^3");
        texto3Legenda.setBounds(campo3.getX() + campoTextoWidth + space, 20, legendaWidth, legendaHeigth);
        texto3Legenda.setFont(myFont1);

        operador3.setBounds(texto3Legenda.getX() + space + 30, 20, 20, campoTextoHeigth);

        campo4.setBounds(texto3Legenda.getX() + campoTextoWidth + space, 20, campoTextoWidth, campoTextoHeigth);
        JLabel texto4Legenda = new JLabel();
        texto4Legenda.setText("x^2");
        texto4Legenda.setBounds(campo4.getX() + campoTextoWidth + space, 20, legendaWidth, legendaHeigth);
        texto4Legenda.setFont(myFont1);

        operador4.setBounds(texto4Legenda.getX() + space + 30, 20, 20, campoTextoHeigth);

        campo5.setBounds(texto4Legenda.getX() + campoTextoWidth + space, 20, campoTextoWidth, campoTextoHeigth);
        JLabel texto5Legenda = new JLabel();
        texto5Legenda.setText("x^1");
        texto5Legenda.setBounds(campo5.getX() + campoTextoWidth + space, 20, legendaWidth, legendaHeigth);
        texto5Legenda.setFont(myFont1);

        operador5.setBounds(texto5Legenda.getX() + space + 30, 20, 20, campoTextoHeigth);

        campo6.setBounds(texto5Legenda.getX() + campoTextoWidth + space, 20, campoTextoWidth, campoTextoHeigth);
        JLabel texto6Legenda = new JLabel();
        texto6Legenda.setText("*1");
        texto6Legenda.setBounds(campo6.getX() + campoTextoWidth + space, 20, legendaWidth, legendaHeigth);
        texto6Legenda.setFont(myFont1);

        // botões
        buttonCalcular.setLayout(null);
        buttonCalcular.setBounds((telaWidth - 175), telaHeight - 100, 100, 30);
        buttonCalcular.setFont(myFont1);

        buttonFinalizar.setLayout(null);
        buttonFinalizar.setBounds((telaWidth - 275), telaHeight - 100, 100, 30);
        buttonFinalizar.setFont(myFont1);

        buttonCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saida = "";
                iteracoes.setText("");
                backEnd();
            }
        });

        buttonFinalizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu menu = new Menu();
                frame.setVisible(false);
                menu.frontEnd();
            }
        });

        frame.setBackground(Color.white);
        frame.add(campo1); // add campo para texto
        frame.add(operador); // add para operador
        frame.add(campo2);
        frame.add(operador2);
        frame.add(campo3);
        frame.add(operador3);
        frame.add(campo4);
        frame.add(operador4);
        frame.add(campo5);
        frame.add(operador5);
        frame.add(campo6);
        frame.add(intervalo1);
        frame.add(intervalo2);
        frame.add(expoenteEpsilon);

        frame.add(iteracoes);

        frame.add(fx);
        frame.add(textoLegenda); // add '(x^5)'
        frame.add(texto2Legenda);
        frame.add(texto3Legenda);
        frame.add(texto4Legenda);
        frame.add(texto5Legenda);
        frame.add(texto6Legenda);
        frame.add(epsilon);
        frame.add(intervaloLegenda);
        frame.add(resultadoLegenda);

        frame.add(buttonCalcular); // add o botão 'calcular'
        frame.add(buttonFinalizar);
        frame.add(panel);
        frame.setVisible(true);
        panel.setVisible(true);
    }

    private void backEnd() {
        textof = Float.parseFloat(this.campo1.getText());
        texto2f = Float.parseFloat(this.campo2.getText());
        texto3f = Float.parseFloat(this.campo3.getText());
        texto4f = Float.parseFloat(this.campo4.getText());
        texto5f = Float.parseFloat(this.campo5.getText());
        texto6f = Float.parseFloat(this.campo6.getText());

        int expoenteEpsilon = Integer.parseInt(this.expoenteEpsilon.getText());

        preparaX();
        intervalo1.setText(String.valueOf(intervalo1f));
        intervalo2.setText(String.valueOf(intervalo2f));

        float resultadoFinal = bisseccao(intervalo1f, intervalo2f, expoenteEpsilon);

        iteracoes.append(saida);
        resultado.setText(String.valueOf(resultadoFinal));
    }

    private void preparaX(){
        for (int i = 0; i < valoresX.length; i++) {
            float x5 = valoresX[i]* valoresX[i]*valoresX[i]*valoresX[i]*valoresX[i];
            float textofaux = textof * x5;

            float x4 = (valoresX[i]* valoresX[i]* valoresX[i]* valoresX[i]);
            float texto2faux = texto2f * x4;

            float x3 = (valoresX[i]* valoresX[i]* valoresX[i]);
            float texto3faux = texto3f * x3;

            float x2 = (valoresX[i]* valoresX[i]);
            float texto4faux = texto4f * x2;

            float x1 = valoresX[i];
            float texto5faux = texto5f * x1;

            resultadosX[i] = calculaFuncao(textofaux, texto2faux, texto3faux, texto4faux, texto5faux,
                    texto6f, operador, operador2, operador3, operador4, operador5);
        }

        encontraZeros(resultadosX);
        for (int i = 0; i < resultadosX.length; i++) {
            System.out.println("O valor de x é= "+ valoresX[i] + ", o resultado de x é= " + resultadosX[i]);
        }
        System.out.println();
    }

    private void encontraZeros(float[] numeros) {
        for (int i = 1; i < numeros.length; i++) {
            if(numeros[i] >= 0 && numeros[i - 1] < 0) {
                intervalo1f = valoresX[i-1];
                intervalo2f = valoresX[i];
                zeros[i-1] = intervalo1f;
                zeros[i] = intervalo2f;
            }
            if (numeros[i] <0 && numeros[i-1] >=0) {
                intervalo1f = valoresX[i-1];
                intervalo2f = valoresX[i];
                zeros[i-1] = intervalo1f;
                zeros[i] = intervalo2f;
            }
        }

        for(int i = 0; i < zeros.length -1 ; i++) {
            System.out.println("Intervalo" + (i + 1) + "é: " + zeros[i] + " e " + zeros[i+1]);
        }
    }

    private float calculaFuncao(float texto, float texto2, float texto3, float texto4, float texto5, float texto6,
                                java.awt.TextField operador1, java.awt.TextField operador2, java.awt.TextField operador3,
                                java.awt.TextField operador4, java.awt.TextField operador5) {
        float resultado = 0;

        if (operador1.getText().equals("+")) {
            float calculo1 = texto + texto2;
            resultado += calculo1;
        } else if (operador1.getText().equals("-")) {
            float calculo1 = texto - texto2;
            resultado += calculo1;
        }

        if (operador2.getText().equals("+")) {
            resultado += texto3;
        } else if (operador2.getText().equals("-")) {
            resultado -= texto3;
        }

        if (operador3.getText().equals("+")) {
            resultado += texto4;
        } else if (operador3.getText().equals("-")) {
            resultado -= texto4;
        }

        if (operador4.getText().equals("+")) {
            resultado += texto5;
        } else if (operador4.getText().equals("-")) {
            resultado -= texto5;
        }

        if (operador5.getText().equals("+")) {
            resultado += texto6;
        } else if (operador5.getText().equals("-")) {
            resultado -= texto6;
        }
        return resultado;
    }

    private float preparaXParaBisseccao(float x) {
        float x5 = x * x*x*x*x;
        float textofaux = textof * x5;

        float x4 = (x* x* x* x);
        float texto2faux = texto2f * x4;

        float x3 = (x* x* x);
        float texto3faux = texto3f * x3;

        float x2 = (x* x);
        float texto4faux = texto4f * x2;

        float texto5faux = texto5f * x;

        return calculaFuncao(textofaux, texto2faux, texto3faux, texto4faux, texto5faux,
                texto6f, operador, operador2, operador3, operador4, operador5);
    }

    private float bisseccao(float intervalo1, float intervalo2, int expo) {
        float epsilon = (float) Math.pow((10), expo);
        float x;
        boolean Maisproximo = false;
        float criterio = 0;
        int cont = 0;

        while (!Maisproximo) {
            criterio = x = divide(intervalo1, intervalo2);

            if (cont %2 == 0) {
                intervalo2 = x;
            } else {
                intervalo1 = x;
            }

            float diferenca = (intervalo1 - intervalo2);

            if(diferenca < 0) {
                diferenca = diferenca * -1;
            }

            saida = saida.concat("Valor de x: " + x + " Valor f(x): " + preparaXParaBisseccao(x) + "  Valor de B - A: "
                    + diferenca) + '\n';

            Maisproximo = !(diferenca > epsilon);
            cont = cont + 1;
        }
        System.out.println(saida);
        return criterio;
    }

    private float divide(float x1, float x2) {
        return (x1 + x2) / 2;
    }
}