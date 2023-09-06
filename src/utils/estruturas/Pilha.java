package utils.estruturas;

import utils.estatica.EstruturaEstatica;

public class Pilha<T> extends EstruturaEstatica<T> {

    public Pilha() {
    }

    public Pilha(int capacidade) {
        super(capacidade);
    }

    public void empilhar(T elemento){
        super.adiciona(elemento);
    }

}