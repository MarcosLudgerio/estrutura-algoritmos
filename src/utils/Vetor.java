package utils;

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
}
