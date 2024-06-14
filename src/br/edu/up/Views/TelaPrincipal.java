package br.edu.up.Views;

import java.util.Scanner;

import br.edu.up.Controllers.FilmeController;
import br.edu.up.Controllers.FuncionarioController;
import br.edu.up.Controllers.JogoController;
import br.edu.up.Models.Jogo;
import br.edu.up.Models.Filme;
import br.edu.up.Models.Funcionario;
import br.edu.up.Controllers.JogoController;
import br.edu.up.Models.Jogo;

import br.edu.up.Controllers.LivroController;
import br.edu.up.Controllers.LocadoraController;
import br.edu.up.Models.Livro;
import br.edu.up.Models.Locadora;
import br.edu.up.Models.Enums.Categoria;
import br.edu.up.Models.Enums.TipoCargo;

public class TelaPrincipal {

    /*
     * @author João: precisamos juntar o que forem terminando nessa View,
     * creio eu não ser necessário outra view.
     */

    LocadoraController locadoraController = new LocadoraController();

    LivroController controleLivro = new LivroController();
    JogoController jogoController = new JogoController();
    FilmeController filmeController = new FilmeController();
    FuncionarioController funcionarioController = new FuncionarioController();

    public void menuPrinciapl() {
        /* Luis: Opções do Menu */
        System.out.println("** Bem-Vindo ao Terminal **");
        System.out.println("1. Livro");
        System.out.println("2. Filme");
        System.out.println("3. Jogo");
        System.out.println("4. Locadora");
        System.out.println("5. Sair");
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
                    MostrarmenuLocadora();
                    break;
                case "5":
                    System.out.println("Saindo do sistema");
                    leitor.close();
                    return;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

    public void MostrarmenuLocadora() {
        System.out.println("** Locadora **");
        System.out.println("1. Mostrar Informações");
        System.out.println("2. Menu Funcionario");
        System.out.println("3. Menu Livro");
        System.out.println("4. Menu Filme");
        System.out.println("5. Menu Jogo");
        System.out.println("6. Menu Cliente");
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
                    System.out.println("      CRIAR LOCADORA");
                    System.out.println("----------------------------");
                    CriarLocadora();
                    break;
                case "2":
                    System.out.println("----------------------------");
                    System.out.println("     ADICIONAR FUNCIONARIOS");
                    System.out.println("----------------------------");
                    AdicionarFuncionario();
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

    public void MostrarmenuFuncionario() {
        System.out.println("** Funcionario **");
        System.out.println("1. Cadastrar Funcionario");
        System.out.println("2. Atualizar Funcionario");
        System.out.println("3. Listar Funcionario");
        System.out.println("4. Deletar Funcionario");
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
                    System.out.println("      ADICIONAR FUNCIONARIO");
                    System.out.println("----------------------------");
                    AdicionarFuncionario();
                    break;
                case "2":
                    System.out.println("----------------------------");
                    System.out.println("     ATUALIZAR FUNCIONARIO");
                    System.out.println("----------------------------");
                    Funcionario func = AdicionarFuncionario();
                    funcionarioController.atualizarFuncionario(func);
                    break;
                case "3":
                    System.out.println("----------------------------");
                    System.out.println("       LISTAR FUNCIONARIO");
                    System.out.println("----------------------------");
                    funcionarioController.listarFuncionarios();
                    break;
                case "4":
                    System.out.println("----------------------------");
                    System.out.println("      DELETAR FUNCIONARIO");
                    System.out.println("----------------------------");
                    System.out.println("Informe o código do funcionario:");
                    int codigo = leitor.nextInt();
                    funcionarioController.deletarFuncionario(codigo);
                    break;
                case "5":
                    menuPrinciapl();
                    funcionarioController.salvarDados();
                    locadoraController.AdicionarFuncionario(funcionarioController.listarFuncionarios());
                    break;
                case "6":
                    System.out.println("Saindo do sistema...");
                    leitor.close();
                    funcionarioController.salvarDados();
                    locadoraController.AdicionarFuncionario(funcionarioController.listarFuncionarios());
                    return;
                default:
                    System.out.println("Opção inválida, Por gentileza escolha opção válida e tente novamente.");
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
                    controleLivro.salvarDados();
                    locadoraController.AdicionarLivros(controleLivro.listarLivros());
                    break;
                case "6":
                    System.out.println("Saindo do sistema...");
                    leitor.close();
                    controleLivro.salvarDados();
                    locadoraController.AdicionarLivros(controleLivro.listarLivros());
                    return;
                default:
                    System.out.println("Opção inválida, Por gentileza escolha opção válida e tente novamente.");
            }
        }
    }

    public void CriarLocadora() {
        /* Luis: Incluir Livro */
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite o nome da locadora: ");
        String nome = leitor.nextLine();

        System.out.println("Digite o endereço da locadora: ");
        String endereco = leitor.nextLine();

        System.out.println("Digite o CNPJ da locadora: ");
        String cnpj = leitor.nextLine();

        System.out.println("Digite o ano da fundação: ");
        int ano = leitor.nextInt();

        locadoraController.CriarLocadora(nome, endereco, cnpj, ano);

    }

    public void incluirLivro() {
        /* Luis: Incluir Livro */
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite o Código do livro: ");
        int codigo = leitor.nextInt();

        System.out.println("Digite o titulo do livro: ");
        String titulo = leitor.nextLine();

        System.out.println("Digite o ISBN do livro: ");
        String isbn = leitor.nextLine();

        System.out.println("Digite o ANO do livro: ");
        int ano = leitor.nextInt();

        System.out.println("Escolha uma categoria:");
        for (Categoria categoria : Categoria.values()) {
            System.out.println(categoria.ordinal() + " - " + categoria.getCategoria());
        }

        System.out.print("Digite o número correspondente à categoria: ");
        int categoriaIndex = leitor.nextInt();

        Categoria categoria = Categoria.values()[categoriaIndex];

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
                    filmeController.salvarDados();
                    locadoraController.AdicionarFilmes(filmeController.listarFilmes());
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
        int id = leitor.nextInt();

        System.out.println("Digite o nome do Filme: ");
        String nome = leitor.nextLine();

        System.out.println("Escolha uma categoria:");
        for (Categoria categoria : Categoria.values()) {
            System.out.println(categoria.ordinal() + " - " + categoria.getCategoria());
        }

        System.out.print("Digite o número correspondente à categoria: ");
        int categoriaIndex = leitor.nextInt();

        Categoria categoria = Categoria.values()[categoriaIndex];

        System.out.println("Digite o nome do diretor do Filme: ");
        String diretor = leitor.nextLine();

        System.out.println("Digite o ano lançamento do Filme: ");
        int anoLancamento = leitor.nextInt();

        Filme filme = new Filme(id, nome, diretor, anoLancamento, categoria);
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
                    jogoController.salvarDados();
                    locadoraController.AdicionarJogos(jogoController.listarJogos());
                    break;
                case "6":
                    System.out.println("Saindo do sistema...");
                    leitor.close();
                    jogoController.salvarDados();
                    locadoraController.AdicionarJogos(jogoController.listarJogos());
                    return;
                default:
                    System.out.println("Opção inválida, Por gentileza escolha opção válida e tente novamente.");
            }
        }
    }

    public void incluirJogo() {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite o Código do jogo: ");
        int id = leitor.nextInt();

        System.out.println("Digite o nome do jogo: ");
        String nome = leitor.nextLine();

        System.out.println("Escolha uma categoria:");
        for (Categoria categoria : Categoria.values()) {
            System.out.println(categoria.ordinal() + " - " + categoria.getCategoria());
        }

        System.out.print("Digite o número correspondente à categoria: ");
        int categoriaIndex = leitor.nextInt();

        Categoria categoria = Categoria.values()[categoriaIndex];

        System.out.println("Digite o ano do jogo: ");
        int ano = leitor.nextInt();

        Jogo jogo = new Jogo(categoriaIndex, nome, categoria, ano);

        jogoController.adicionarJogo(jogo);

    }

    public void atualizarJogo() {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite o as infomações do jogo que você deseja atualizar");

        System.out.println("Digite o Código: ");
        int id = leitor.nextInt();

        System.out.println("Digite o nome: ");
        String nome = leitor.nextLine();

        System.out.println("Escolha uma categoria:");
        for (Categoria categoria : Categoria.values()) {
            System.out.println(categoria.ordinal() + " - " + categoria.getCategoria());
        }

        System.out.print("Digite o número correspondente à categoria: ");
        int categoriaIndex = leitor.nextInt();

        Categoria categoria = Categoria.values()[categoriaIndex];

        System.out.println("Digite o ano: ");
        int ano = leitor.nextInt();

        jogoController.atualizarJogo(id, nome, categoria, ano);
    }

    public void deletarJogo() {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite o Código do jogo que você deseja deletar: ");
        int id = leitor.nextInt();

        jogoController.deletarJogo(id);
    }

    public Funcionario AdicionarFuncionario() {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Informe o Documento: ");
        String documento = leitor.nextLine();

        System.out.println(":Informe o Nome: ");
        String nome = leitor.nextLine();

        System.out.println("Informe a Idade:");
        int idade = leitor.nextInt();

        System.out.print("Informe o endereço: ");
        String endereco = leitor.nextLine();

        System.out.println("Escolha um Cargo:");
        for (TipoCargo cargo : TipoCargo.values()) {
            System.out.println(cargo.ordinal() + " - " + cargo.getDescricao());
        }

        System.out.print("Digite o número correspondente ao cargo: ");
        int cargoIndex = leitor.nextInt();

        TipoCargo cargo = TipoCargo.values()[cargoIndex];

        System.out.println("Digite o codigo: ");
        int codigo = leitor.nextInt();

        Funcionario funcionario = new Funcionario(documento, nome, idade, endereco, cargo, codigo);
        funcionarioController.incluirFuncionario(funcionario);
        return funcionario;
    }

}
