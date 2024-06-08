package br.edu.up.Views;

import java.util.Scanner;

import br.edu.up.Controllers.LivroController;
import br.edu.up.Models.Categoria;
import br.edu.up.Models.Livro;

public class TelaPrincipal {

    LivroController controleLivro = new LivroController();

    public void menuPrinciapl() {
        /* Luis: Opções do Menu */
        System.out.println("** Bem-Vindo ao Terminal **");
        System.out.println("1. Livro");
        System.out.println("2. Filme");
        System.out.println("3. Jogo");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public void menuLivro() {
        /* Luis: Opções do Menu Livro */
        
    }

    public void menuFilme() {
    }

    public void menuJogo() {
    }

    public void mostrar() {
        /*
         * Luis: Menu
         * ESSA WHILE VAMOS MODIFICANDO CONFORME A NECESSIDADE
         */
        Scanner leitor = new Scanner(System.in);
        while (true) {
            menuLivro();
            String opL = leitor.nextLine();

            switch (opL) {
                case "1":
                    System.out.println("----------------------------");
                    System.out.println("      ADICIONAR LIVRO");
                    System.out.println("----------------------------");
                    incluirLivro();

                    break;
                case "2":
                    System.out.println("----------------------------");
                    System.out.println("     ATUALIZAR LIVRO");
                    System.out.println("----------------------------");
                    break;
                case "3":
                    System.out.println("----------------------------");
                    System.out.println("       LISTAR LIVRO");
                    System.out.println("----------------------------");

                    break;
                case "4":
                    System.out.println("----------------------------");
                    System.out.println("      DELETAR LIVROS");
                    System.out.println("----------------------------");
                    break;
                case "5":
                    System.out.println("Saindo do sistema...");
                    leitor.close();
                    return;
                default:
                    System.out.println("Opção inválida, Por gentileza escolha opção válida e tente novamente.");
            }
        }
    }

    public void incluirLivro() {
        /* Luis: Incluir Livro */
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite o Código do livro: ");
        String codigo = leitor.nextLine();

        System.out.println("Digite o titulo do livro: ");
        String titulo = leitor.nextLine();

        System.out.println("Digite o ISBN do livro: ");
        String isbn = leitor.nextLine();

        System.out.println("Digite o ANO do livro: ");
        int ano = leitor.nextInt();

        System.out.println("Digite a categoria do livro: ");
        String categoria = leitor.nextLine();

        /*
         * Luis:
         * Não estou conseguido finalizar esse final
         * Não consigo chamar a categoria
         */
        // Livro livro = new Livro(codigo, titulo, isbn, ano, Livro.getCategoria());
        // controleLivro.incluirLivro(livro);

    }
}
