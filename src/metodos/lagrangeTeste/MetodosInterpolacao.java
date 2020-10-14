package metodos.lagrangeTeste;

import menu.Menu;
import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MetodosInterpolacao extends Applet implements ItemListener, ActionListener {
    public static final int LAGRANGE = 0;
    public static final int NEWTON = 1;

    private Tabela tabela;
    private int numPtos;
    private int metodoAtual;

    private TextField tfNumPtos;
    private TextField tfGrau;
    private TextField tfPto;
    private TextField tfFuncao;
    private TextField tfPtoInicial;
    private TextField tfPtoFinal;

    private Label lbNumPtos;
    private Label lbMetodos;
    private Label lbGrau;
    private Label lbPto;
    private Label lbResultado;
    private Label lbFuncao;
    private Label lbPtoInicial;
    private Label lbPtoFinal;

    private Button btOk;
    private Button btCalcular;

    private Panel p1;
    private Panel p2;
    private Panel p3;
    private Panel p4;
    private Panel p5;
    private Panel p6;
    private Panel p7;
    private Panel p8;
    private Panel p9;
    private Panel p10;

    private Choice chMetodos;

    private Checkbox cbFuncao;
    private Checkbox cbPtos;

    private CheckboxGroup cbGrupo;

    private Frame frame = new Frame("LaGrange Teste");
    private JButton finalizar = new JButton("Finalizar");

    public void init() {
        int telaWidth = 1000;
        int telaHeight = 650;

        Font myFont1 = new Font("Sans Serif Plain", Font.BOLD, 16);

        frame.setSize(telaWidth, telaHeight);

        // instanciacao
        p1 = new Panel();
        p2 = new Panel();
        p3 = new Panel();
        p4 = new Panel();
        p5 = new Panel();
        p6 = new Panel();
        p7 = new Panel();
        p8 = new Panel();
        p9 = new Panel();
        p10 = new Panel();

        chMetodos = new Choice();
        chMetodos.add("Lagrange");
        chMetodos.add("Newton");

        tfNumPtos = new TextField(4);
        tfGrau = new TextField(3);
        tfPto = new TextField(4);
        tfFuncao = new TextField(25);
        tfPtoInicial = new TextField(4);
        tfPtoFinal = new TextField(4);

        lbNumPtos = new Label("Número de subintervalos n:");
        lbMetodos = new Label("Método:");
        lbGrau = new Label("Grau:");
        lbPto = new Label("Ponto avaliado pelo polinômio interpolador:");
        lbResultado = new Label();
        lbFuncao = new Label("Função:");
        lbPtoInicial = new Label("Ponto inicial:");
        lbPtoFinal = new Label("Ponto final:");

        btOk = new Button("OK");
        btCalcular = new Button("Calcular");

        cbGrupo = new CheckboxGroup();

        // frame.add(cbGrupo);

        cbFuncao = new Checkbox("Digitar função", true, cbGrupo);
        cbPtos = new Checkbox("Pontos Tabelados", false, cbGrupo);

        setLayout(new BorderLayout());

        add("North", p6);
        add("Center", p2);
        add("South", p3);

        p1.add(lbNumPtos);
        p1.add(tfNumPtos);

        p2.setLayout(new BorderLayout());
        p2.add("North", p1);
        p2.add("Center", p7);
        p2.add("South", p10);

        p3.setLayout(new FlowLayout());
        p3.add(lbMetodos);
        p3.add(chMetodos);
        p3.add(btCalcular);

//		p4.add( lbGrau );
//		p4.add( tfGrau );
        p4.add(lbPto);
        p4.add(tfPto);

        p5.add(lbResultado);

        p6.add(cbFuncao);
        p6.add(cbPtos);

        p7.setLayout(new GridLayout(0, 1));
        p7.add(p8);
        p7.add(p9);

        p8.add(lbFuncao);
        p8.add(tfFuncao);

        p9.add(lbPtoInicial);
        p9.add(tfPtoInicial);
        p9.add(lbPtoFinal);
        p9.add(tfPtoFinal);

        p10.setLayout(new GridLayout(0, 1));
        p10.add(p4);
        p10.add(p3);
        p10.add(p5);

//		chMetodos.setEnabled( false );
//		btCalcular.setEnabled( false );

        chMetodos.addItemListener(this);
        cbFuncao.addItemListener(this);
        cbPtos.addItemListener(this);

        btOk.addActionListener(this);
        btCalcular.addActionListener(this);

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

        frame.add(finalizar);
        frame.add(p1);
        frame.add(p2);
        frame.add(p3);
        frame.add(p4);
        frame.add(p5);
        frame.add(p6);
        frame.add(p7);
        frame.add(p8);
        frame.add(p9);
        frame.add(p10);

        frame.add(chMetodos);

        frame.add(tfNumPtos);
        frame.add(tfGrau);
        frame.add(tfPto);
        frame.add(tfFuncao);
        frame.add(tfPtoInicial);
        frame.add(tfPtoFinal);

        frame.add(lbNumPtos);
        frame.add(lbMetodos);
        frame.add(lbGrau);
        frame.add(lbPto);
        frame.add(lbResultado);
        frame.add(lbFuncao);
        frame.add(lbPtoInicial);
        frame.add(lbPtoFinal);

        frame.add(btOk);
        frame.add(btCalcular);

        frame.add(cbFuncao);
        frame.add(cbPtos);

        tfNumPtos.setVisible(true);
        tfGrau.setVisible(true);
        tfPto.setVisible(true);
        tfFuncao.setVisible(true);
        tfPtoInicial.setVisible(true);
        tfPtoFinal.setVisible(true);

        lbNumPtos.setVisible(true);
        lbMetodos.setVisible(true);
        lbGrau.setVisible(true);
        lbPto.setVisible(true);
        lbResultado.setVisible(true);
        lbFuncao.setVisible(true);
        lbPtoInicial.setVisible(true);
        lbPtoInicial.setVisible(true);

        chMetodos.setVisible(true);

        btOk.setVisible(true);
        btCalcular.setVisible(true);

        cbFuncao.setVisible(true);
        cbPtos.setVisible(true);

        frame.setBackground(Color.white);
        frame.setVisible(true);

        p1.setVisible(true);
        p2.setVisible(true);
        p3.setVisible(true);
        p4.setVisible(true);
        p5.setVisible(true);
        p6.setVisible(true);
        p7.setVisible(true);
        p8.setVisible(true);
        p9.setVisible(true);
        p10.setVisible(true);

        metodoAtual = this.LAGRANGE;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btOk) {
            try {
                numPtos = Integer.parseInt(tfNumPtos.getText()) + 1;
                tabela = new Tabela(numPtos);

                p2.removeAll();
                p2.add("North", p1);
                p2.add("Center", tabela);
                p2.add("South", p10);

                tabela.validate();
                p2.validate();

                tfPto.setText("");

                lbResultado.setText("Resultado:");

//				chMetodos.setEnabled( true );
//				btCalcular.setEnabled( true );

                validate();
            } catch (NumberFormatException nfe) {
                // numero invalido
            }
        } else {
            try {
                int grau = Integer.parseInt(tfNumPtos.getText());

                double[] x = new double[grau + 1];
                double[] y = new double[grau + 1];

                InterpretadorExpressao ie = new InterpretadorExpressao(tfFuncao.getText());

                if (cbFuncao.getState()) {
                    x[0] = Double.parseDouble(tfPtoInicial.getText());
                    y[0] = ie.funcao(x[0]);

                    x[grau] = Double.parseDouble(tfPtoFinal.getText());
                    y[grau] = ie.funcao(x[grau]);

                    double h = (x[grau] - x[0]) / grau;

                    for (int i = 1; i < grau; i++) {
                        x[i] = x[i - 1] + h;
                        y[i] = ie.funcao(x[i]);
                    }
                } else {
                    tabela.getVetorX(x);    // retorna os elementos do vetor x
                    tabela.getVetorFx(y);    // retorna os elementos do vetor fx
                }

                double pto = Double.parseDouble(tfPto.getText());

                Interpolacao metodos = new Interpolacao();
                double resultado = 0;

                // executa o metodo escolhido no choice
                switch (metodoAtual) {
                    case MetodosInterpolacao.LAGRANGE:    // metodo de Lagrange
                        resultado = metodos.metodoLagrange(grau, pto, x, y);
                        break;
                    case MetodosInterpolacao.NEWTON: // metodo de Newton
                        resultado = metodos.metodoNewtonDD(grau, pto, x, y);
                        if (metodos.getErro() != 0) {
                            // mostrar qual o erro em uma outra janela
                        }
                        break;
                }

                lbResultado.setText("Resultado: " + Double.toString(resultado));

                // forca a atualizacao do applet e do painel que contem o resultado
                lbResultado.validate();
                p5.validate();
                validate();

            } catch (NumberFormatException nfe) {
                // numero invalido
            }
        }
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() instanceof Checkbox) {
            if (e.getSource() == cbFuncao) {

                p1.removeAll();

                p1.add(lbNumPtos);
                p1.add(tfNumPtos);

                p2.removeAll();
                p2.setLayout(new BorderLayout());
                p2.add("North", p1);
                p2.add("Center", p7);
                p2.add("South", p10);

                p1.validate();
                p8.validate();
                p9.validate();
                p7.validate();

            } else {

                p1.removeAll();

                p1.add(lbNumPtos);
                p1.add(tfNumPtos);
                p1.add(btOk);

                p2.removeAll();
                p2.setLayout(new BorderLayout());
                p2.add("North", p1);
                p2.add("Center", new Panel());
                p2.add("South", p10);

                p1.validate();
            }
            p10.validate();
            p2.validate();
            validate();
        } else {
            switch (chMetodos.getSelectedIndex()) {
                case 0:    // metodo de Lagrange
                    metodoAtual = this.LAGRANGE;
                    break;
                case 1: // metodo de Newton
                    metodoAtual = this.NEWTON;
                    break;
            }
        }
    }
}
