import utils.Contato;
import utils.Lista;

import java.util.Scanner;

public class ContatoTeste {

    public static void main(String[] args) {

        Scanner io = new Scanner(System.in);

        Lista<Contato> listaDeContatos = new Lista<>();
        exibeMenu();
        String opcao = opcaoMenu(io);

        while (!opcao.equals("0")) {
            switch (opcao) {
                case "1":
                    adicionarContato(listaDeContatos, io);
                    break;
                case "2":
                    adicionarContatoNaPosicao(listaDeContatos, io);
                    break;
                case "3": // Recuperar contato por posição
                    try {
                        visualizarUmContato(listaDeContatos, io);
                    } catch (Exception e) {
                        System.out.println("ALGO DEU ERRADO POR FAVOR, VERIFIQUE OS DADOS");
                    }
                    break;
                case "4":
                    try {
                        apagarContato(listaDeContatos, io);
                    } catch (Exception e) {
                        System.out.println("NENHUM CONTATO NA LISTA");
                    }
                    break;
                case "5":
                    try {
                        ultimoIndiceContato(listaDeContatos);
                    } catch (Exception e) {
                        System.out.println("NENHUM CONTATO NA LISTA");
                    }
                    break;
                case "6":
                    try {
                        if (recuperarContato(listaDeContatos, io))
                            System.out.println("CONTATO EXISTE NA LISTA");
                    } catch (Exception e) {
                        System.out.println("NENHUM CONTATO NA LISTA");
                    }
                    break;
                case "7":
                    exibirTamanhoDaLista(listaDeContatos);
                    break;
                case "8":
                    limparLista(listaDeContatos);
                    break;
                case "9":
                    try {
                        listagem(listaDeContatos);
                    } catch (Exception e) {
                        System.out.println("NENHUM CONTATO NA LISTA");
                    }
                    break;
                case "10": // Exibir Menu
                    exibeMenu();
                    break;
                default:
                    System.out.println("Escolha uma opção válida!");
                    break;
            }
            opcao = opcaoMenu(io);
        }
        System.out.println("OBRIGADO POR USAR O SISTEMA!");
    }

    private static void exibeMenu() {
        System.out.println("Informe a opção desejada: ");
        System.out.println("1 - Adicionar novo contato ao final");
        System.out.println("2 - Adicionar contato em uma posição");
        System.out.println("3 - Recuperar contato por posição");
        System.out.println("5 - Excluir contato por posição");
        System.out.println("8 - Verificar se contato existe");
        System.out.println("9 - Tamanho da lista de contatos");
        System.out.println("10 - Limpar todos os dados");
        System.out.println("11 - Visualizar lista");
        System.out.println("12 - Ver detalhes do contato ");
        System.out.println("0 - Sair");
    }

    public static void listagem(Lista<Contato> lista) throws Exception {
        validarTamanhoDaLista(lista);
        for (int i = 0; i < lista.getTamanho(); i++) {
            Contato c = (Contato) lista.busca(i);
            System.out.println(i + " - " + c.getNome());
        }
    }

    public static void visualizarUmContato(Lista<Contato> lista, Scanner io) throws Exception {
        validarTamanhoDaLista(lista);
        int posicao = inserirInformacaoInteira("INFORME A POSIÇÃO DO CONTATO QUE DESEJA VER", io);
        Contato c = (Contato) lista.busca(posicao);
        System.out.println("Nome: " + c.getNome());
        System.out.println("Telefone: " + c.getTelefone());
        System.out.println("Email: " + c.getEmail());

    }

    public static void apagarContato(Lista<Contato> lista, Scanner io) throws Exception {
        validarTamanhoDaLista(lista)
        int number = inserirInformacaoInteira("INFORME A POSIÇÃO DO CONTATO QUE DESEJA EXCLUIR: ", io);
        int i = lista.removeElemento(number);
        if (i >= 0) System.out.println("CONTATO REMOVIDO COM SUCESSO!");
        else System.out.println("ERRO AO REMOVER CONTATO");
    }

    private static String opcaoMenu(Scanner io) {
        System.out.println("ESCOLHA UMA OPÇÃO: ");
        return io.nextLine();
    }

    private static int inserirInformacaoInteira(String msg, Scanner io) {
        System.out.println(msg);
        String number = io.nextLine();
        return validarPosicao(number);
    }

    private static String inserirInformacaoString(String msg, Scanner io) {
        System.out.println(msg);
        String number = io.nextLine();
        return number;
    }

    private static void criarVariosContatos(int quantidade, Lista<Contato> lista) {
        for (int i = 0; i <= quantidade; i++) {
            String nome = "Contato " + i;
            String email = "contato" + i + "@email.com";
            String endereco = "(83)" + i + "2982913";

            lista.adiciona(new Contato(nome, email, endereco));
        }
    }

    private static void adicionarContato(Lista<Contato> lista, Scanner io) {
        lista.adiciona(criarObjetoContato(io));
    }

    private static void adicionarContatoNaPosicao(Lista<Contato> lista, Scanner io) {
        int posicao = inserirInformacaoInteira("INFORME A POSIÇÃO QUE DESEJA ADICIONAR O CONTATO", io);
        lista.adiciona(criarObjetoContato(io), posicao);
    }

    private static int validarPosicao(String number) {
        int posicao = -1;
        try {
            posicao = Integer.parseInt(number);
        } catch (Exception ex) {
            System.out.println("Insira um número inteiro!");
        }
        return posicao;
    }

    public static Contato criarObjetoContato(Scanner io) {
        String nome, email, telefone;
        nome = inserirInformacaoString("INFORME O NOME: ", io);
        email = inserirInformacaoString("INFORME O EMAIL: ", io);
        telefone = inserirInformacaoString("INFORME O TELEFONE: ", io);
        return new Contato(nome, email, telefone);
    }

    public static void validarTamanhoDaLista(Lista<Contato> lista) throws Exception {
        if (lista.getTamanho() == 0) {
            throw new Exception("NENHUM CONTATO NA LISTA");
        }
    }

    public static void ultimoIndiceContato(Lista<Contato> lista) throws Exception {
        validarTamanhoDaLista(lista);
        lista.ultimoIndice();
    }

    public static boolean recuperarContato(Lista<Contato> lista, Scanner io) throws Exception {
        validarTamanhoDaLista(lista);
        int number = inserirInformacaoInteira("INFORME A POSIÇÃO DO CONTATO QUE DESEJA SABER SE EXISTE: ", io);
        Contato c = (Contato) lista.busca(number);
        return lista.contem(c);
    }

    public static void exibirTamanhoDaLista(Lista<Contato> lista){
        System.out.println("O TAMANHO DA LISTA É: " + lista.getTamanho());
    }

    public static void limparLista(Lista<Contato> lista){
        lista.limpar();
        System.out.println("TODOS OS ITENS DA LISTA FORAM EXCLUIDOS!");
    }
}
