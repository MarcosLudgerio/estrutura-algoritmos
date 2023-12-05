package tests;

import utils.estruturas.ArvoreBinariaBusca;
import utils.estruturas.No;
import utils.estruturas.Pilha;

import java.util.Stack;

public class PilhaTestes {
    public static void main(String[] args) {
        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
        arvore.raiz = new No(1);
        arvore.raiz.esquerda = new No(2);
        arvore.raiz.direita = new No(3);
        arvore.raiz.esquerda.esquerda = new No(4);
        arvore.raiz.esquerda.direita = new No(5);

        System.out.println("Percorrendo a árvore em nível:");
        arvore.percorrerEmNivel();

    }
}
