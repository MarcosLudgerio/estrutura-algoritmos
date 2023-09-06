package utils.estruturas;

import utils.estatica.EstruturaEstatica;

public class Pilha<T> extends EstruturaEstatica<T> {

    public Pilha() {
    }

    public Pilha(int capacidade) {
        super(capacidade);
    }

    public void empilhar(T elemento) {
        super.adiciona(elemento);
    }

    public T topo() {
        if(this.estaVazia()) return null;
        return this.elementos[tamanho - 1];
    }

    public T desempilhar(){
        if(this.estaVazia()) return null;
        return this.elementos[--tamanho];
    }

}
