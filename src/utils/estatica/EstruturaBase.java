package utils.estatica;

public class EstruturaBase<T> {
    protected T[] elementos;
    protected int tamanho;


    public EstruturaBase(int capacidade) {
        this.elementos = (T[]) new Object[capacidade];
        tamanho = 0;
    }

    public EstruturaBase() {
        this(10);
    }

    protected boolean adiciona(T elemento) {
        aumentarCapacidade();
        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
            return true;
        }
        return false;
    }

    protected boolean adiciona(T elemento, int pos) {
        aumentarCapacidade();
        if (this.tamanho == 0) {
            this.elementos[0] = elemento;
            this.tamanho++;
            return true;
        }
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

    protected void aumentarCapacidade() {
        if (getTamanho() == this.elementos.length) {
            T[] novaLista = (T[]) new Object[this.elementos.length * 2];
            for (int i = 0; i < elementos.length; i++) {
                novaLista[i] = elementos[i];
            }
            this.tamanho = elementos.length;
            this.elementos = novaLista;
        }
    }

    protected int getTamanho() {
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
