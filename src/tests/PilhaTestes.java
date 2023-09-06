package tests;

import utils.estruturas.Pilha;

public class PilhaTestes {
    public static void main(String[] args) {

        Pilha<Integer> pilha = new Pilha<>();
        System.out.println(pilha);
        System.out.println(pilha.getTamanho());
        System.out.println(pilha.getTamanho());

        for(int i = 0; i < 11; i++){
            pilha.empilhar(i);
        }
        System.out.println(pilha);
        System.out.println(pilha.getTamanho());
    }
}
