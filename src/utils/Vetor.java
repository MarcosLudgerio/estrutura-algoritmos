package utils;

import java.util.Arrays;

public class Vetor {
    private int[] elementos;
    private int tamanho;

    private int capacidade;

    public Vetor(int capacidade) {
        this.elementos = new int[capacidade];
        this.capacidade = capacidade;
        tamanho = 0;
    }

//    public void adicionar(int elemento) {
////        for (int i = 0; i < elementos.length; i++) {
////            if (this.elementos[i] == 0) {
////                this.elementos[i] = elemento;
////                break;
////            }
////        }

    public boolean adiciona(int elemento) {
        aumentarCapacidade();
        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
            return true;
        }
        return false;
    }

    public boolean adiciona(int elemento, int pos) {
        aumentarCapacidade();
        if (!(pos >= 0 && pos < this.tamanho)) {
            throw new IllegalArgumentException("Posição inválida");
        }
        for (int i = this.tamanho - 1; pos <= i; i--) {
            this.elementos[i + 1] = this.elementos[i];
        }
        this.elementos[pos] = elemento;
        this.tamanho++;
        return true;
    }

    public int busca(int posicao) {
        if (!(posicao >= 0 && posicao < this.tamanho)) {
            throw new IllegalArgumentException("Posição inválida");
        }
        return this.elementos[posicao];
    }

    public int getTamanho() {
        return tamanho;
    }

    private void aumentarCapacidade() {
        if (getTamanho() == this.capacidade) {
            this.capacidade *= this.capacidade;
            int[] novaLista = new int[this.capacidade];
            for (int i = 0; i < elementos.length; i++) {
                novaLista[i] = elementos[i];
            }
            this.elementos = novaLista;
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (int i = 0; i < this.tamanho - 1; i++) {
            str.append(this.elementos[i]);
            str.append(", ");
        }
        if (this.tamanho > 0) {
            str.append(this.elementos[this.tamanho - 1]);
        }
        str.append("]");
        return str.toString();
    }
}
