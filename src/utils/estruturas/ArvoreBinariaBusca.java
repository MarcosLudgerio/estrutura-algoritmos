package utils.estruturas;

import java.util.LinkedList;
import java.util.Queue;

public class ArvoreBinariaBusca {
    public No raiz;

    public void percorrerEmNivel() {
        if (raiz == null) {
            return;
        }

        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            No noAtual = fila.poll();
            System.out.println(noAtual.valor + " ");

            if (noAtual.esquerda != null) {
                fila.add(noAtual.esquerda);
            }

            if (noAtual.direita != null) {
                fila.add(noAtual.direita);
            }
        }
    }
}
