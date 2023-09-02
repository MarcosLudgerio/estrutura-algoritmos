import utils.Vetor;

public class Main {
    public static void main(String[] args) {
        Vetor v = new Vetor(5);
        v.adiciona(3);
        v.adiciona(2);
        v.adiciona(4);
        v.adiciona(5);
        v.adiciona(51, 1);
        System.out.println(v);
    }
}