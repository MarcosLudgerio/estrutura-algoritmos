import utils.Contato;
import utils.Lista;

import java.util.Scanner;

public class ContatoTeste {

    public static void main(String[] args) {

        Scanner io = new Scanner(System.in);
        int posicao = -1;
        String number;

        Lista<Contato> listaDeContatos = new Lista<>();
        exibeMenu();
        String opcao = opcaoMenu(io);

        while (!opcao.equals("0")) {
            switch (opcao) {
                case "1": // Adicionar novo contato ao final
                    adicionarContato(listaDeContatos, io);
                    break;
                case "2": // Adicionar contato em uma posição

                    System.out.println("Informe a posição do contato");
                    String pos = io.nextLine();
                    posicao = validarPosicao(pos);

                    adicionarContato(listaDeContatos, io, posicao);
                    break;
                case "3": // Recuperar contato por posição
                    if (listaDeContatos.getTamanho() == 0) {
                        System.out.println("NENHUM CONTATO NA LISTA");
                        break;
                    }
                    System.out.println("INFORME A POSIÇÃO DO CONTATO");
                    number = io.nextLine();
                    posicao = validarPosicao(number);
                    visualizarUmContato(listaDeContatos, posicao);
                    break;
                case "4": // Excluir contato por posição
                    if (listaDeContatos.getTamanho() == 0) {
                        System.out.println("NENHUM CONTATO NA LISTA");
                        break;
                    }
                    System.out.println("INFORME A POSIÇÃO DO CONTATO: ");
                    number = io.nextLine();
                    posicao = validarPosicao(number);
                    int i = listaDeContatos.removeElemento(posicao);
                    if (i >= 0) System.out.println("CONTATO REMOVIDO COM SUCESSO!");
                    else System.out.println("ERRO AO REMOVER CONTATO");
                    break;
                case "7": //Consultar ultimo indice
                    if (listaDeContatos.getTamanho() == 0) {
                        System.out.println("NENHUM CONTATO NA LISTA");
                        break;
                    }
                    listaDeContatos.ultimoIndice();
                    break;
                case "8": // Verificar se contato existe
                    if (listaDeContatos.getTamanho() == 0) {
                        System.out.println("NENHUM CONTATO NA LISTA");
                        break;
                    }
                    System.out.println("opção 8");
                    break;
                case "9": // Tamanho da lista de contatos
                    System.out.println("O TAMANHO DA LISTA É: " + listaDeContatos.getTamanho());
                    break;
                case "10":  // Limpar todos os dados
                    System.out.println("opção 10");
                    break;
                case "11": // Visualizar lista
                    if (listaDeContatos.getTamanho() == 0) {
                        System.out.println("NENHUM CONTATO NA LISTA");
                        break;
                    }
                    listagem(listaDeContatos);
                    break;
                case "12": // Exibir Menu
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
        System.out.println("4 - Recuperar contato");
        System.out.println("5 - Excluir contato por posição");
        System.out.println("6 - Excluir contato específico");
        System.out.println("7 - Consultar ultimo indice");
        System.out.println("8 - Verificar se contato existe");
        System.out.println("9 - Tamanho da lista de contatos");
        System.out.println("10 - Limpar todos os dados");
        System.out.println("11 - Visualizar lista");
        System.out.println("12 - Ver detalhes do contato ");
        System.out.println("0 - Sair");
    }

    public static void listagem(Lista<Contato> lista) {
        for (int i = 0; i < lista.getTamanho(); i++) {
            Contato c = (Contato) lista.busca(i);
            System.out.println(i + " - " + c.getNome());
        }
    }

    public static void visualizarUmContato(Lista<Contato> lista, int pos) {
        Contato c = (Contato) lista.busca(pos);
        System.out.println("Nome: " + c.getNome());
        System.out.println("Telefone: " + c.getTelefone());
        System.out.println("Email: " + c.getEmail());

    }

    private static String opcaoMenu(Scanner io) {
        System.out.println("ESCOLHA UMA OPÇÃO: ");
        return io.nextLine();
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

    private static void adicionarContato(Lista<Contato> lista, Scanner io, int posicao) {
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
        System.out.println("INFORME O NOME DO CONTATO: ");
        nome = io.nextLine();
        System.out.println("INFORME O EMAIL DO CONTATO: ");
        email = io.nextLine();
        System.out.println("INFORME O TELEFONE DO CONTATO: ");
        telefone = io.nextLine();
        return new Contato(nome, email, telefone);
    }


}
