package metodos.lagrangeTeste;

/**
 * Classe que interpreta uma expressao fornecida
 */
public class InterpretadorExpressao {
    private String strExpressao;
    private int posicao;
    private boolean achouErro = false;

    public InterpretadorExpressao() {
    }

    public InterpretadorExpressao(String exp) {
        strExpressao = new String(exp);
    }

    public void mudaExpressao(String exp) {
        strExpressao = exp;
    }

    public String retornaExpressao() {
        return strExpressao;
    }

    public boolean retornaErro() {
        return achouErro;
    }

    public char proximoCaracter() {
        return strExpressao.charAt(posicao++);
    }

    public void erro(int numErro) {
        String mensagem;
        switch (numErro) {
            case 1:
                mensagem = new String(") esperado");
                break;
            case 2:
                mensagem = new String("Digito esperado");
                break;
            case 3:
                mensagem = new String("Função inválida");
                break;
            case 4:
                mensagem = new String("( esperado");
                break;
            case 5:
                mensagem = new String("Expressão inválida");
                break;
            case 6:
                mensagem = new String("Função não definida no ponto");
                break;
            default:
                mensagem = new String("Erro desconhecido");
                break;
        }
        JanelaErro janelaErro = new JanelaErro("Erro", mensagem);
    }

    public double expressao(double x) {
        char c;
        boolean continua = true;
        double e = 0;

        switch (strExpressao.charAt(posicao)) {
            case '+':
                proximoCaracter();
                e = termo(x);
                break;
            case '-':
                proximoCaracter();
                e = -termo(x);
                break;
            default:
                e = termo(x);
                break;
        }

        while (continua && posicao < strExpressao.length() - 1) {
            switch (strExpressao.charAt(posicao)) {
                case '+':
                    proximoCaracter();
                    e = e + termo(x);
                    break;
                case '-':
                    proximoCaracter();
                    e = e - termo(x);
                    break;
                default:
                    continua = false;
                    break;
            }
        }
        return e;
    }

    public double termo(double x) {
        char c;
        boolean continua = true;
        double t = fator(x);

        while (continua && posicao < strExpressao.length() - 1) {
            switch (strExpressao.charAt(posicao)) {
                case '*':
                    c = proximoCaracter();
                    t = t * fator(x);
                    break;
                case '/':
                    c = proximoCaracter();
                    t = t / fator(x);
                    break;
                case '^':
                    c = proximoCaracter();
                    double expoente = fator(x);
                    t = Math.pow(t, expoente);
                    break;
                default:
                    continua = false;
                    break;
            }
        }
        return t;
    }

    public double fator(double x) {

        char c = proximoCaracter();
        double f = 0;

        if (!achouErro && c == '(') {
            f = expressao(x);

            if ((posicao > strExpressao.length() - 1 || strExpressao.charAt(posicao) != ')') && !achouErro) {
                achouErro = true;
                erro(1); // fecha parenteses esperado
            } else
                proximoCaracter(); // consome o fecha parenteses
        }
        // c eh um digito
        else if (!achouErro && Character.isDigit(c)) {
            Character caracter = new Character(c);
            StringBuffer numero = new StringBuffer(caracter.toString());
            caracter = null;
            while (posicao < strExpressao.length() - 1 && Character.isDigit(strExpressao.charAt(posicao))) {
                c = proximoCaracter();
                numero.append(c);
            }
            // numero eh do tipo ponto flutuante
            if (posicao < strExpressao.length() - 1 && strExpressao.charAt(posicao) == '.') {
                c = proximoCaracter();
                numero.append(c);
                while (Character.isDigit(strExpressao.charAt(posicao)) && posicao < strExpressao.length() - 1) {
                    c = proximoCaracter();
                    numero.append(c);
                }
            }
            try {
                f = Double.parseDouble(numero.toString());

            } catch (NumberFormatException nfe) {
                achouErro = true;
                erro(2); // numero invalido
            }
        }
        // c eh uma letra
        else if (!achouErro && Character.isLetter(c)) {
            Character caracter = new Character(c);
            StringBuffer strFuncao = new StringBuffer(caracter.toString());
            caracter = null;
            while (posicao < strExpressao.length() - 1 && Character.isLetter(strExpressao.charAt(posicao))) {
                c = proximoCaracter();
                strFuncao.append(c);
            }
            if (strFuncao.toString().equals("x") || strFuncao.toString().equals("X")) {
                f = x;
            } else {
                if (!achouErro && posicao == strExpressao.length() - 1) {
                    achouErro = true;
                    erro(3); // funcao invalida
                } else if (!achouErro && strExpressao.charAt(posicao) != '(') {
                    achouErro = true;
                    erro(4); // abre parenteses esperado
                } else if (!achouErro) {
                    if (posicao < strExpressao.length() - 1 && !achouErro)
                        proximoCaracter(); // consome o abre parenteses

                    double valor = expressao(x);

                    if (!achouErro) {
                        if (strFuncao.toString().equals("sqr"))
                            valor = Math.pow(valor, 2);
                        else if (strFuncao.toString().equals("sqrt")) {
                            if (valor >= 0)
                                valor = Math.sqrt(valor);
                            else {
                                achouErro = true;
                                erro(6); // funcao nao definida neste ponto
                            }
                        } else if (strFuncao.toString().equals("abs"))
                            valor = Math.abs(valor);
                        else if (strFuncao.toString().equals("ln"))
                            valor = Math.log(valor);
                        else if (strFuncao.toString().equals("log")) {
                            if (Math.log(10) != 0)
                                valor = Math.log(valor) / Math.log(10);
                        } else if (strFuncao.toString().equals("exp"))
                            valor = Math.exp(valor);
                        else if (strFuncao.toString().equals("sen"))
                            valor = Math.sin(valor);
                        else if (strFuncao.toString().equals("cos"))
                            valor = Math.cos(valor);
                        else if (strFuncao.toString().equals("tan"))
                            if (valor == Math.PI / 2 || valor == 3 * Math.PI / 2) {
                                achouErro = true;
                                erro(6); // funcao nao definida neste ponto
                            } else
                                valor = Math.tan(valor);
                        else if (strFuncao.toString().equals("csc") && Math.sin(valor) != 0)
                            valor = 1 / Math.sin(valor);
                        else if (strFuncao.toString().equals("sec") && Math.cos(valor) != 0)
                            valor = 1 / Math.cos(valor);
                        else if (strFuncao.toString().equals("cotan") && Math.tan(valor) != 0)
                            valor = 1 / Math.tan(valor);
                        else if (strFuncao.toString().equals("senh"))
                            valor = (Math.exp(valor) - Math.exp(-valor)) / 2;
                        else if (strFuncao.toString().equals("cosh"))
                            valor = (Math.exp(valor) + Math.exp(-valor)) / 2;
                        else if (strFuncao.toString().equals("tanh")) {
                            double senh = (Math.exp(valor) - Math.exp(-valor)) / 2;
                            double cosh = (Math.exp(valor) + Math.exp(-valor)) / 2;
                            if (cosh != 0)
                                valor = senh / cosh;
                        } else if (strFuncao.toString().equals("cotanh")) {
                            double senh = (Math.exp(valor) - Math.exp(-valor)) / 2;
                            double cosh = (Math.exp(valor) + Math.exp(-valor)) / 2;
                            if (senh != 0)
                                valor = cosh / senh;
                        }

                        if (posicao <= strExpressao.length() - 1 && !achouErro && strExpressao.charAt(posicao) == ')')
                            proximoCaracter(); // consome o fecha parenteses

                        else {
                            achouErro = true;
                            erro(1); // fecha parenteses esperado
                        }
                        f = valor;
                    }
                }
            }
        }
        // caracter invalido na expressao
        else {
            achouErro = true;
            erro(5); // expressao invalida
        }
        return f;
    }

    public double funcao(double x) {
        posicao = 0;
        achouErro = false;
        double resultado = expressao(x);
        // foi encontrado algum erro na expressao
        if (posicao <= strExpressao.length() - 1) {
            achouErro = true;
            erro(5); // expressao invalida
        }
        if (achouErro)
            return 0;
        return resultado;
    }
}