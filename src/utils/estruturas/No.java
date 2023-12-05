package utils.estruturas;

public class No {
    int valor;
    public No esquerda;
    public No direita;

    public No(int item) {
        valor = item;
        esquerda = direita = null;
    }
}
