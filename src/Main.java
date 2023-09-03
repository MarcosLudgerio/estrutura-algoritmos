import utils.Vetor;
import utils.VetorObjeto;

public class Main {
    public static void main(String[] args) {
//        Vetor v = new Vetor(2);
//        v.adiciona(12);
//        v.adiciona(52);
//        v.adiciona(23);
//        v.adiciona(89);
//        v.adiciona(44);
//        v.adiciona(57);
//        v.adiciona(521, 1);
//        v.adiciona(98, 3);
//
//        System.out.println(v);
//        v.removeElemento(52);
//        System.out.println(v);

        VetorObjeto vo = new VetorObjeto(5);
        vo.adiciona("Teste");
        vo.adiciona("Teste 1");
        vo.adiciona("Teste 2");

        System.out.println(vo);
    }
}
