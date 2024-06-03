package br.edu.up.Views;

import java.util.Scanner;

import br.edu.up.Controllers.LivroController;
import br.edu.up.Models.Categoria;
import br.edu.up.Models.Livro;

public class TelaPrincipal {

    LivroController controleLivro = new LivroController();

    public void menu() {
        /* Luis: Opções do Menu */
        System.out.println("** Bem-Vindo ao Terminal **");
        System.out.println("1. Adicionar Livro");
        System.out.println("2. Atualizar Livro");
        System.out.println("3. Listar Livros");
        System.out.println("4. Deletar Livro");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public void mostrar() {
        /*
         * Luis: Menu
         * ESSA WHILE VAMOS MODIFICANDO CONFORME A NECESSIDADE
         */
        Scanner leitor = new Scanner(System.in);
        while (true) {
            menu();
            String op = leitor.nextLine();

            switch (op) {
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
        String c = leitor.nextLine();
        Categoria _categoria = Categoria.descricaoCategoria(c);
        

        /*
         * Luis:
         * Não estou conseguido finalizar esse final
         * Não consigo chamar a categoria
         */
        Livro livro = new Livro(codigo, titulo, isbn, ano, _categoria); 
        controleLivro.incluirLivro(livro);

    }

    public void atualizar(){
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite o Código do livro: ");
        String codigo = leitor.nextLine();


    }
}
