package tests;

import utils.estruturas.Pilha;

public class PalidramoTeste {
    public static void main(String[] args) {
        System.out.println(ePalidromo("AABBAA"));
        System.out.println(ePalidromo("abccba"));
        System.out.println(ePalidromo("abcabc"));
        System.out.println(ePalidromo("ccaacda"));
    }

    public static boolean ePalidromo(String carecteres) {
        Pilha<Character> direto = new Pilha<>();
        Pilha<Character> inverso = new Pilha<>();

        for (int i = 0; i < carecteres.length(); i++) {
            char c = carecteres.charAt(i);
            direto.empilhar(c);
        }

        for (int i = carecteres.length() - 1; 0 <= i; i--) {
            char c = carecteres.charAt(i);
            inverso.empilhar(c);
        }
        boolean retorno = true;
        do {
            char i = inverso.desempilhar();
            char d = direto.desempilhar();
            if (i != d){
                retorno = false;
                break;
            }
        } while (!inverso.estaVazia());
        return retorno;
    }
}
