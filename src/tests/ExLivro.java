package tests;

import utils.estruturas.Pilha;
import utils.model.Livro;

import java.util.Scanner;

public class ExLivro {
    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);
        Pilha<Livro> pilha = new Pilha<>(20);

        for (int i = 1; i <= 6; i++) {
            System.out.println("Informe o nome do livro: " + i);
            String nome = io.nextLine();
            System.out.println("Informe o nome do autor: " + i);
            String autor = io.nextLine();
            pilha.adiciona(new Livro(nome, autor));
        }

        System.out.println(pilha);
        System.out.println(pilha.estaVazia());
        System.out.println(pilha.topo());
        pilha.empilhar(new Livro("Livro empilhado", "autor desconhedico"));
        System.out.println(pilha.desempilhar());

        while (!pilha.estaVazia()) {
            System.out.println("DESEMPILHANDO: " + pilha.desempilhar());
        }
    }
}
