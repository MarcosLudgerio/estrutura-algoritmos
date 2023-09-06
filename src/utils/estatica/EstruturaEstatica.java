package utils.estatica;

import utils.estatica.EstruturaBase;

public class EstruturaEstatica<T> extends EstruturaBase<T> {
    public EstruturaEstatica() {
        super();
    }
    public EstruturaEstatica(int capacidade) {
        super(capacidade);
    }

    public boolean adiciona(T elemento){
        return super.adiciona(elemento);
    }

    protected void aumentarCapacidade() {
        super.aumentarCapacidade();
    }

    protected int getTamanho() {
        return super.getTamanho();
    }
    @Override
    public String toString() {
      return super.toString();
    }
}
