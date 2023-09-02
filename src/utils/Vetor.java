package utils;

import java.util.Arrays;

public class Vetor {
    private int[] elementos;
    private int tamanho;

    public Vetor(int capacidade) {
        this.elementos = new int[capacidade];
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
        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
            return true;
        }
        return false;
    }

    public int getTamanho() {
        return tamanho;
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
