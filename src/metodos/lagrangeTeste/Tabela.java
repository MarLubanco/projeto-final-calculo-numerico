package metodos.lagrangeTeste;

import java.awt.*;

public class Tabela extends ScrollPane {
    private int numPtos;
    private double[] x, fX;
    private Label[] lbX, lbFx;
    private TextField[] tfX, tfFx;
    private GridBagLayout layout;
    private GridBagConstraints constraints;
    private Panel painel;

    public Tabela() {
    }

    public Tabela(int numPtos) {

        this.numPtos = numPtos;

        // instanciacao dos dados
        x = new double[numPtos];
        fX = new double[numPtos];

        lbX = new Label[numPtos];
        lbFx = new Label[numPtos];

        tfX = new TextField[numPtos];
        tfFx = new TextField[numPtos];

        painel = new Panel();

        layout = new GridBagLayout();
        constraints = new GridBagConstraints();

        add(painel);
        painel.setLayout(layout);

        for (int i = 0; i < numPtos; i++) {
            lbX[i] = new Label("x[ " + i + " ]:", Label.RIGHT);
            lbFx[i] = new Label("f( x[ " + i + " ] ): ", Label.RIGHT);

            tfX[i] = new TextField(4);
            tfFx[i] = new TextField(4);

            addComponent(lbX[i], 0, i, 1, 1);
            addComponent(tfX[i], 1, i, 1, 1);
            addComponent(lbFx[i], 2, i, 1, 1);
            addComponent(tfFx[i], 3, i, 1, 1);
        }
    }

    void getVetorX(double[] x) {
        for (int i = 0; i < numPtos; i++)
            x[i] = Double.parseDouble(tfX[i].getText());
    }

    void getVetorFx(double[] fx) {
        for (int i = 0; i < numPtos; i++)
            fx[i] = Double.parseDouble(tfFx[i].getText());
    }

    private void addComponent(Component component,
                              int row, int column, int width, int height) {

        // configura gridx e gridy
        constraints.gridx = column;
        constraints.gridy = row;

        // configura gridwidth e gridheight
        constraints.gridwidth = width;
        constraints.gridheight = height;

        // configura restrições e adiciona componente
        layout.setConstraints(component, constraints);
        painel.add(component);
    }
}