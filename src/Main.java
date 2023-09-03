import utils.Vetor;

public class Main {
    public static void main(String[] args) {
        Vetor v = new Vetor(2);
        v.adiciona(12);
        v.adiciona(52);
        v.adiciona(23);
        v.adiciona(89);
        v.adiciona(44);
        v.adiciona(57);
        v.adiciona(521, 1);
        v.adiciona(98, 3);

        v.removeElemento(52);
        System.out.println(v);
    }
}