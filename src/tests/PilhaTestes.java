package tests;

import utils.estruturas.Pilha;

import java.util.Stack;

public class PilhaTestes {
    public static void main(String[] args) {

        Pilha<Integer> pilha = new Pilha<>();

        for(int i = 50; i < 61; i++){
            pilha.empilhar(i);
        }
        System.out.println(pilha);
        System.out.println(pilha.getTamanho());
        System.out.println(pilha.estaVazia());
        System.out.println(pilha.topo());
        System.out.println(pilha.desempilhar());
        System.out.println(pilha);

    }
}
