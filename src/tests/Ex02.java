package tests;

import utils.estruturas.Pilha;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);
        Pilha<Integer> pilha = new Pilha<>();
        for (int i = 0; i < 10; i++) {
            System.out.println("INFORME UM NÚMERO: ");
            int num = io.nextInt();
            if (num % 2 == 0)
                pilha.empilhar(num);
            else {
                if (pilha.estaVazia()) System.out.println("não existe elementos");
                System.out.println(pilha.desempilhar());
            }
            System.out.println(pilha);
        }


        if (!pilha.estaVazia()) {
            while (pilha.getTamanho() != 0) {
                System.out.println(" DESEMPILHANDO: " + pilha.desempilhar());
            }
        }
    }
}
