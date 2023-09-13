package tests;

import utils.estruturas.Pilha;

public class ParenteseTeste {

    private static final String ABRE = "({[";
    private static final String FECHA = ")}]";

    public static void main(String[] args) {
        System.out.println(validaExpressao(")A+B())"));
        System.out.println(validaExpressao("(A+B))"));
        System.out.println(validaExpressao("(A+B)"));
        System.out.println(validaExpressao("((A+B))"));
    }

    public static boolean validaExpressao(String expressao) {
        Pilha<Character> simbolos = new Pilha<>();
        int index = 0;
        char simbolo, topo;
        while (index < expressao.length()) {
            simbolo = expressao.charAt(index);
            if (ABRE.indexOf(simbolo) > -1) {
                simbolos.empilhar(simbolo);
            } else if (FECHA.indexOf(simbolo) > -1) {
                if (simbolos.estaVazia()) {
                    return false;
                } else {
                    topo = simbolos.desempilhar();
                    if (ABRE.indexOf(topo) != FECHA.indexOf(topo)) {
                        return false;
                    }
                }
            }
            index++;
        }
        return true;
    }

}
