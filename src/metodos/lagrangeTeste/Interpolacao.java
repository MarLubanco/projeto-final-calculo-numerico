package metodos.lagrangeTeste;

/* classe que contem os metodos de Interpolacao Polinomial */
public class Interpolacao {
    private int erro;    // esta variavel contem algum tipo de erro que ocorreu em algum metodo de interpolacao chamado
    // Valores possiveis para a variavel erro:
    // 0: nao ocorreu nenhum tipo de erro;
    // 1: ocorreu um erro no metodo retornaDiferencaDividida();

    Interpolacao() {
        erro = 0; // nao ocorreu nenhum erro ate agora
    }

    /* retorna os vetores x e y (x e y sao valores tabelados ) ordenados de acordo
       com os valores do vetor x.
       Modo de chamada: ordenacaoBolha( <arg1>, <arg2>)
       <arg1> double[], valores tabelados de x
       <arg2> double[], valores tabelados de y
    */
    void ordenacaoBolha(double[] x, double[] y) {
        int i;
        double auxX, auxY;
        boolean achou;

        i = x.length - 1;
        do {
            achou = false;
            for (int j = 1; j < i; j++)
                if (x[j] > x[j + 1]) {
                    auxX = x[j];
                    x[j] = x[j + 1];
                    x[j + 1] = auxX;

                    auxY = y[j];
                    y[j] = y[j + 1];
                    y[j + 1] = auxY;

                    achou = true;
                }
        } while (achou);
    }

    /* retorna o indice do ponto inicial (k) para o polinomio interpolador.
       Modo de chamada: <argumento> = retornaIndiceInicial( <arg1>, ..., <arg4>)
       <arg1>: int, grau do polinomio
       <arg2>: double, ponto onde se deseja conhecer o p(x) interpolado
       <arg3>: vetor, valores tabelados de x
       <arg4>: vetor, valores tabelados de y
    */
    int retornaIndiceInicial(int grau, double pto, double[] x, double[] y) {
        int i, esq, dir, cont, numPtos;

        if (pto < x[0])
            return 0;

        numPtos = x.length - 1;
        if (pto > x[numPtos])
            return numPtos - grau;

        i = 0;
        while (i < x.length && pto > x[i])
            i++;

        esq = i - 1;
        dir = i;

        if (grau == 0) {
            if (Math.abs(pto - x[esq - 1]) <= Math.abs(pto - x[dir]))
                return esq;
            return dir;
        }

        cont = 2;
        while (cont != grau + 1) {
            if (dir >= numPtos || (esq > 0 && (Math.abs(pto - x[esq - 1]) <= Math.abs(pto - x[dir]))))
                esq--;
            else if (esq < 0 || (dir < numPtos && (Math.abs(pto - x[esq - 1]) > Math.abs(pto - x[dir]))))
                dir++;
            cont++;
        }
        return esq;
    }

/* retorna o valor do polinomio interpolado, calculado atraves da Forma de interpolacao
   Lagrangeana.

   Modo de chamada: <arg> = metodoLagrange(<arg1>, ..., <arg4>)
   <arg1>: int, grau do polinomio
   <arg2>: double, ponto onde se deseja conhecer o p(x) interpolado
   <arg3>: vetor, valores tabelados de x
   <arg4>: vetor, valores tabelados de y
*/

    double metodoLagrange(int grau, double pto, double[] x, double[] y) {
        int k;
        double aux1, aux2, l, p;

        p = 0;
        k = retornaIndiceInicial(grau, pto, x, y);

        for (int i = 0; i <= grau; i++) {
            l = 1;
            for (int j = 0; j <= grau; j++)
                if (j != i)
                    l = l * (pto - x[k + j]) / (x[k + i] - x[k + j]);
            p = p + y[k + i] * l;
        }
        return p;
    }

    /* retorna a diferenca dividida (DD) do polinomio dado.

       Modo de chamada: <arg> = retornaDiferencaDividida(<arg1>, ..., <arg4>)
       <arg1>: int, indice inicial
       <arg2>: int, ordem da diferenca dividida
       <arg3>: double[], valores tabelados de x
       <arg4>: double[], valores tabelados de y
    */
    double retornaDiferencaDividida(int k, int n, double[] x, double[] y) {
        ordenacaoBolha(x, y);
        if (n == 0)
            return y[k];
        try {
//			if (x[k+n] - x[k] != 0)
            return (retornaDiferencaDividida(k + 1, n - 1, x, y) -
                    retornaDiferencaDividida(k, n - 1, x, y)) / (x[k + n] - x[k]);
        } catch (ArithmeticException arithmeticException) {
            // divisao por zero
        } catch (ArrayIndexOutOfBoundsException arrayException) {
            // indice do array invalido
            System.out.println(arrayException.toString());
        }

        erro = 1;    // nao foi possivel retornar as diferencas divididas
        return 0;
    }

    /* retorna o valor do polinomio interpolado, calculado atraves da forma de
       Interpolacao de Newton utilizando Diferencas Divididas.

       Modo de chamada: <arg> = metodoNewtonDD(<arg1>, ..., <arg4>)
       <arg1>: int, indice inicial
       <arg2>: int, grau do polinomio
       <arg3>: double[], valores tabelados de x
       <arg4>: double[], valores tabelados de y
    */
    double metodoNewtonDD(int grau, double pto, double[] x, double[] y) {
        double p, termo;

        int k = retornaIndiceInicial(grau, pto, x, y);

        termo = 1;
        p = y[k];
        for (int i = 1; i < x.length; i++) {
            termo *= (pto - x[k + i - 1]);
            p += termo * retornaDiferencaDividida(k, i, x, y);
        }

        return p;
    }

    /* retorna o valor contido na variavel erro que indica se houve algum tipo
       de erro em algum metodo chamado.
    */
    int getErro() {
        return erro;
    }

    /* modifica o conteudo da variavel erro para um novo valor */
    void setErro(int valor) {
        erro = valor;
    }
}