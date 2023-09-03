package utils;

import java.lang.reflect.Array;

public class Lista<T> {

    private T[] elementos;
    private int tamanho;


    public Lista(int capacidade) {
        this.elementos = (T[]) new Object[capacidade];
        tamanho = 0;
    }

    public Lista(int capacidade, Class<T> tipo) {
        this.elementos = (T[]) Array.newInstance(tipo, capacidade);
        tamanho = 0;
    }

    public boolean adiciona(T elemento) {
        aumentarCapacidade();
        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
            return true;
        }
        return false;
    }

    public boolean adiciona(T elemento, int pos) {
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


    public void removeElemento(T elemento) {
        int pos = this.posicao(elemento);
        for (int i = pos; i < this.tamanho - 1; i++) {
            this.elementos[i] = this.elementos[i + 1];
        }
        this.tamanho--;
    }

    private int posicao(T elemento) {
        for (int i = 0; i < this.tamanho - 1; i++) {
            if (this.elementos[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }


    public Object busca(int posicao) {
        if (!(posicao >= 0 && posicao < this.tamanho)) {
            throw new IllegalArgumentException("Posição inválida");
        }
        return this.elementos[posicao];
    }

    public int getTamanho() {
        return tamanho;
    }

    private void aumentarCapacidade() {
        if (getTamanho() == this.elementos.length) {
            T[] novaLista = (T[]) new Object[this.elementos.length * 2];
            for (int i = 0; i < elementos.length; i++) {
                novaLista[i] = elementos[i];
            }
            this.elementos = novaLista;
        }
    }

    public boolean contem(T elemento) {
        return this.posicao(elemento) >= 0;
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
