package utils;

public class Vetor {
    private int[] elementos;

    public Vetor(int capacidade) {
        this.elementos = new int[capacidade];
    }

    public void adicionar(int elemento) {
        for (int i = 0; i < elementos.length; i++) {
            if (this.elementos[i] == 0) {
                this.elementos[i] = elemento;
                break;
            }
        }
    }
}
