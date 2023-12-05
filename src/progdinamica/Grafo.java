package progdinamica;

import java.util.Arrays;

public class Grafo {
    private int vertices;
    private int[][] grafo;

    public Grafo(int vertices) {
        this.vertices = vertices;
        this.grafo = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++)
            for (int j = 0; j < vertices; j++)
                this.grafo[i][j] = 0;
    }

    public void exibeGrafo(){
        for (int i = 0; i < vertices; i++)
                System.out.println(Arrays.toString(this.grafo[i]));
    }
}
