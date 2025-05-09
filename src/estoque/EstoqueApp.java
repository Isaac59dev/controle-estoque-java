package estoque;

import java.util.ArrayList;
import java.util.Scanner;

public class EstoqueApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Produto> listaProdutos = new ArrayList<>();

        int opcao;

        do {
            System.out.println("\n===== MENU ESTOQUE =====");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Adicionar ao estoque");
            System.out.println("4 - Remover do estoque");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            while (!sc.hasNextInt()) {
                System.out.print("Digite um número válido: ");
                sc.next(); // descarta entrada inválida
            }

            opcao = sc.nextInt();
            sc.nextLine(); // limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome do produto: ");
                    String nome = sc.nextLine();

                    System.out.print("Quantidade inicial: ");
                    int qtd = lerIntPositivo(sc);

                    System.out.print("Preço: R$ ");
                    double preco = lerDoublePositivo(sc);

                    listaProdutos.add(new Produto(nome, qtd, preco));
                    System.out.println("✅ Produto cadastrado com sucesso!");
                    break;

                case 2:
                    if (listaProdutos.isEmpty()) {
                        System.out.println("⚠️ Nenhum produto cadastrado.");
                    } else {
                        System.out.println("\n--- Produtos no Estoque ---");
                        for (int i = 0; i < listaProdutos.size(); i++) {
                            System.out.println("[" + i + "] " + listaProdutos.get(i));
                        }
                    }
                    break;

                case 3:
                    if (listaProdutos.isEmpty()) {
                        System.out.println("⚠️ Nenhum produto para atualizar.");
                        break;
                    }

                    System.out.print("Digite o ID do produto: ");
                    int idAdd = lerIdValido(sc, listaProdutos.size());

                    System.out.print("Quantidade a adicionar: ");
                    int qtdAdd = lerIntPositivo(sc);

                    listaProdutos.get(idAdd).adicionarEstoque(qtdAdd);
                    System.out.println("✅ Estoque atualizado!");
                    break;

                case 4:
                    if (listaProdutos.isEmpty()) {
                        System.out.println("⚠️ Nenhum produto para atualizar.");
                        break;
                    }

                    System.out.print("Digite o ID do produto: ");
                    int idRem = lerIdValido(sc, listaProdutos.size());

                    System.out.print("Quantidade a remover: ");
                    int qtdRem = lerIntPositivo(sc);

                    Produto prod = listaProdutos.get(idRem);
                    if (qtdRem > prod.getQuantidade()) {
                        System.out.println("❌ Não há estoque suficiente!");
                    } else {
                        prod.removerEstoque(qtdRem);
                        System.out.println("✅ Estoque atualizado!");
                    }
                    break;

                case 0:
                    System.out.println("👋 Encerrando o programa...");
                    break;

                default:
                    System.out.println("❌ Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }

    // Métodos auxiliares para leitura segura
    private static int lerIntPositivo(Scanner sc) {
        int valor;
        while (true) {
            while (!sc.hasNextInt()) {
                System.out.print("Digite um número inteiro válido: ");
                sc.next();
            }
            valor = sc.nextInt();
            if (valor >= 0) break;
            System.out.print("Digite um valor positivo: ");
        }
        return valor;
    }

    private static double lerDoublePositivo(Scanner sc) {
        double valor;
        while (true) {
            while (!sc.hasNextDouble()) {
                System.out.print("Digite um número válido: ");
                sc.next();
            }
            valor = sc.nextDouble();
            if (valor >= 0) break;
            System.out.print("Digite um valor positivo: ");
        }
        return valor;
    }

    private static int lerIdValido(Scanner sc, int tamanhoLista) {
        int id;
        while (true) {
            while (!sc.hasNextInt()) {
                System.out.print("Digite um número válido: ");
                sc.next();
            }
            id = sc.nextInt();
            if (id >= 0 && id < tamanhoLista) break;
            System.out.print("ID inválido. Tente novamente: ");
        }
        return id;
    }
}
