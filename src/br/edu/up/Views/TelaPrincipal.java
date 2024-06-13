package br.edu.up.Views;

import java.util.Scanner;

import br.edu.up.Controllers.FilmeController;
import br.edu.up.Controllers.JogoController;
import br.edu.up.Models.Jogo;
import br.edu.up.Models.Filme;

import br.edu.up.Controllers.JogoController;
import br.edu.up.Models.Jogo;

import br.edu.up.Controllers.LivroController;
import br.edu.up.Models.Livro;

public class TelaPrincipal {

    /*
     * @author João: precisamos juntar o que forem terminando nessa View,
     * creio eu não ser necessário outra view.
     */

    LivroController controleLivro = new LivroController();
    JogoController jogoController = new JogoController();
    FilmeController filmeController = new FilmeController();

    public void menuPrinciapl() {
        /* Luis: Opções do Menu */
        System.out.println("** Bem-Vindo ao Terminal **");
        System.out.println("1. Livro");
        System.out.println("2. Filme");
        System.out.println("3. Jogo");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public void mostrar() {
        Scanner leitor = new Scanner(System.in);
        while (true) {
            menuPrinciapl();
            String opcao = leitor.nextLine();

            switch (opcao) {
                case "1":
                    MostrarmenuLivro();
                    break;
                case "2":
                    MostrarmenuFilme();
                    break;
                case "3":
                    MostrarmenuJogo();
                    break;
                case "4":
                    System.out.println("Saindo do sistema");
                    leitor.close();
                    return;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

    public void MostrarmenuLivro() {
        System.out.println("** Livro **");
        System.out.println("1. Cadastrar Livro");
        System.out.println("2. Atualizar Livro");
        System.out.println("3. Listar Livros");
        System.out.println("4. Deletar Livro");
        System.out.println("5. Voltar ao Menu Principal");
        System.out.println("6. Sair");
        /*
         * Luis: Menu
         * ESSA WHILE VAMOS MODIFICANDO CONFORME A NECESSIDADE
         */
        Scanner leitor = new Scanner(System.in);
        while (true) {
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
                    menuPrinciapl();
                    break;
                case "6":
                    System.out.println("Saindo do sistema...");
                    leitor.close();
                    controleLivro.salvarDados();
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

        Livro livro = new Livro(codigo, titulo, isbn, ano, categoria);
        controleLivro.incluirLivro(livro);

    }

    public void MostrarmenuFilme() {
        System.out.println("** Filme **");
        System.out.println("1. Cadastrar Filme");
        System.out.println("2. Atualizar Filme");
        System.out.println("3. Listar Filmes");
        System.out.println("4. Deletar Filme");
        System.out.println("5. Voltar ao Menu Principal");
        System.out.println("6. Sair");
        Scanner leitor = new Scanner(System.in);
        while (true) {
            String opF = leitor.nextLine();

            switch (opF) {
                case "1":
                    System.out.println("----------------------------");
                    System.out.println("      ADICIONAR FILME");
                    System.out.println("----------------------------");

                    break;
                case "2":
                    System.out.println("----------------------------");
                    System.out.println("     ATUALIZAR FILME");
                    System.out.println("----------------------------");

                    break;
                case "3":
                    System.out.println("----------------------------");
                    System.out.println("       LISTAR FILME");
                    System.out.println("----------------------------");

                    break;
                case "4":
                    System.out.println("----------------------------");
                    System.out.println("      DELETAR FILMES");
                    System.out.println("----------------------------");
                    break;
                case "5":
                    menuPrinciapl();
                    break;
                case "6":
                    System.out.println("Saindo do sistema...");
                    leitor.close();
                    return;
                default:
                    System.out.println("Opção inválida, Por gentileza escolha opção válida e tente novamente.");
            }
        }
    }

    public void incluirFilme() {
        /* Luis: Incluir Filme */
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite o id do Filme: ");
        String id = leitor.nextLine();

        System.out.println("Digite o nome do Filme: ");
        String nome = leitor.nextLine();

        System.out.println("Digite o genero do Filme: ");
        String genero = leitor.nextLine();

        System.out.println("Digite o nome do diretor do Filme: ");
        String diretor = leitor.nextLine();

        System.out.println("Digite o ano lançamento do Filme: ");
        int anoLancamento = leitor.nextInt();

        Filme filme = new Filme(id, nome, genero, diretor, anoLancamento);
        filmeController.incluirFilme(filme);

    }

    public void MostrarmenuJogo() {
        System.out.println("** Jogo **");
        System.out.println("1. Cadastrar Jogo");
        System.out.println("2. Atualizar Jogo");
        System.out.println("3. Listar Jogos");
        System.out.println("4. Deletar Jogo");
        System.out.println("5. Voltar ao Menu Principal");
        System.out.println("6. Sair");
        Scanner leitor = new Scanner(System.in);
        while (true) {

            String opJ = leitor.nextLine();

            switch (opJ) {
                case "1":
                    System.out.println("----------------------------");
                    System.out.println("      ADICIONAR JOGO");
                    System.out.println("----------------------------");
                    incluirJogo();

                    break;
                case "2":
                    System.out.println("----------------------------");
                    System.out.println("     ATUALIZAR JOGO");
                    System.out.println("----------------------------");

                    break;
                case "3":
                    System.out.println("----------------------------");
                    System.out.println("       LISTAR JOGO");
                    System.out.println("----------------------------");
                    jogoController.listarJogos();
                    break;
                case "4":
                    System.out.println("----------------------------");
                    System.out.println("      DELETAR JOGOS");
                    System.out.println("----------------------------");
                    deletarJogo();
                    break;
                case "5":
                    menuPrinciapl();
                    break;
                case "6":
                    System.out.println("Saindo do sistema...");
                    leitor.close();
                    return;
                default:
                    System.out.println("Opção inválida, Por gentileza escolha opção válida e tente novamente.");
            }
        }
    }

    public void incluirJogo() {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite o Código do jogo: ");
        String id = leitor.nextLine();

        System.out.println("Digite o nome do jogo: ");
        String nome = leitor.nextLine();

        System.out.println("Digite o genero do jogo: ");
        String genero = leitor.nextLine();

        System.out.println("Digite o ano do jogo: ");
        int ano = leitor.nextInt();

        String resultado = jogoController.adicionar(id, nome, genero, ano);
        System.out.println(resultado);

    }

    public void atualizar() {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite o as infomações do jogo que você deseja atualizar");

        System.out.println("Digite o Código: ");
        String id = leitor.nextLine();

        System.out.println("Digite o nome: ");
        String nome = leitor.nextLine();

        System.out.println("Digite o genero: ");
        String genero = leitor.nextLine();

        System.out.println("Digite o ano: ");
        int ano = leitor.nextInt();

        jogoController.atualizarJogo(id, nome, genero, ano);
    }

    public void deletarJogo() {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite o Código do jogo que você deseja deletar: ");
        String id = leitor.nextLine();

        jogoController.deletarFuncionario(id);
    }

}
