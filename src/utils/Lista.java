package utils;

import java.lang.reflect.Array;

public class Lista<T> {

    private T[] elementos;
    private int tamanho;


    public Lista(int capacidade) {
        this.elementos = (T[]) new Object[capacidade];
        tamanho = 0;
    }

    public Lista() {
        this.elementos = (T[]) new Object[10];
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
        if (this.tamanho == 0) {
            this.elementos[0] = elemento;
            this.tamanho++;
            return true;
        }
        if (!(pos > 0 && pos < this.tamanho)) {
            throw new IllegalArgumentException("Posição inválida");
        }
        for (int i = this.tamanho - 1; pos <= i; i--) {
            this.elementos[i + 1] = this.elementos[i];
        }
        this.elementos[pos] = elemento;
        this.tamanho++;
        return true;
    }


    public int removeElemento(T elemento) {
        int pos = this.posicao(elemento);
        if (pos < 0) return -1;
        this.removeElemento(pos);
        this.tamanho--;
        return pos;
    }

    public int removeElemento(int posicao) {
        if (!(posicao >= 0 && posicao < this.tamanho)) {
            return -1;
        }
        for (int i = posicao; i < this.tamanho - 1; i++) {
            this.elementos[i] = this.elementos[i + 1];
        }
        this.tamanho--;
        return 1;
    }


    private int posicao(T elemento) {
        for (int i = 0; i < this.tamanho; i++) {
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

    public void limpar() {
        this.tamanho = 0;
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
            this.tamanho = novaLista.length;
        }
    }

    public boolean contem(T elemento) {
        return this.posicao(elemento) >= 0;
    }


    public int ultimoIndice(T elemento) {
        int ultimo = -1;
        for (int i = 0; i < this.tamanho; i++) {
            if (this.elementos[i].equals(elemento)) {
                ultimo = i;
            }
        }
        return ultimo;
    }

    public Object ultimoIndice() {
        return this.elementos[tamanho - 1];
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
