package br.com.biblioteca;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemaBiblioteca {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(" ");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Listar Livros");
            System.out.println("3. Ordenar por Título");
            System.out.println("4. Ordenar por Autor");
            System.out.println("5. Buscar Livro");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();

                    int ano = 0;
                    boolean anoValido = false;

                    while (!anoValido) {
                        System.out.print("Ano de Publicação: ");
                        try {
                            ano = scanner.nextInt();
                            scanner.nextLine();
                            if (ano > 0) {
                                anoValido = true;
                            } else {
                                System.out.println("Ano de publicação deve ser um número positivo. Tente novamente.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                            scanner.nextLine();
                        }
                    }

                    biblioteca.adicionarLivro(new Livro(titulo, autor, ano));
                    break;

                case 2:
                    biblioteca.listarLivros();
                    break;

                case 3:
                    Ordenacao.bubbleSort(biblioteca.getAcervo(), biblioteca.getCount(), true);
                    System.out.println("Livros ordenados por título.");
                    break;

                case 4:
                    Ordenacao.bubbleSort(biblioteca.getAcervo(), biblioteca.getCount(), false);
                    System.out.println("Livros ordenados por autor.");
                    break;

                case 5:
                    int buscaOpcao = 0;
                    boolean buscaOpcaoValida = false;

                    while (!buscaOpcaoValida) {
                        System.out.println("1. Buscar por Título");
                        System.out.println("2. Buscar por Autor");
                        System.out.print("Escolha uma opção de busca: ");
                        
                        try {
                            buscaOpcao = scanner.nextInt();
                            scanner.nextLine();
                            if (buscaOpcao == 1 || buscaOpcao == 2) {
                                buscaOpcaoValida = true;
                            } else {
                                System.out.println("Opção inválida. Por favor, escolha 1 ou 2.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                            scanner.nextLine();
                        }
                    }

                    switch (buscaOpcao) {
                        case 1:
                            System.out.print("Digite o título do livro: ");
                            String tituloBusca = scanner.nextLine();
                            Ordenacao.buscaPorTitulo(biblioteca.getAcervo(), biblioteca.getCount(), tituloBusca);
                            break;
                        case 2:
                            System.out.print("Digite o autor do livro: ");
                            String autorBusca = scanner.nextLine();
                            Ordenacao.buscaPorAutor(biblioteca.getAcervo(), biblioteca.getCount(), autorBusca);
                            break;
                        default:
                            // Não deveria chegar aqui, pois todas as opções são validadas no loop
                            System.out.println("Opção de busca inválida.");
                    }
                    break;

                case 6:
                    System.out.println("Saindo...");
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
