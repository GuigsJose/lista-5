package br.edu.up.Views;

import java.util.Scanner;

import br.edu.up.Controllers.ClienteController;
import br.edu.up.Controllers.FilmeController;
import br.edu.up.Controllers.FuncionarioController;
import br.edu.up.Controllers.JogoController;
import br.edu.up.Models.Jogo;
import br.edu.up.Models.Cliente;
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
import br.edu.up.Models.Enums.TipoCliente;

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
    ClienteController clienteController = new ClienteController();

    public void menuPrinciapl() {
        /* Luis: Opções do Menu */
        System.out.println("** Bem-Vindo ao Terminal **");
        System.out.println("1. Locadora");
        System.out.println("2. Sair");
        System.out.print("Escolha uma opção: ");

        mostrar();
    }

    public void mostrar() {
        Scanner leitor = new Scanner(System.in);

        while (true) {
            String opcao = leitor.nextLine();

            switch (opcao) {
                case "1":
                    MostrarmenuLocadora();
                    break;
                case "2":
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
        System.out.println("7. Voltar ao menu anterior");
        System.out.println("8. Sair");
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
                    MostrarmenuLocadora();
                    break;
                case "2":
                    System.out.println("----------------------------");
                    System.out.println("     MENU FUNCIONARIOS");
                    System.out.println("----------------------------");
                    MostrarmenuFuncionario();
                    MostrarmenuLocadora();
                    break;
                case "3":
                    System.out.println("----------------------------");
                    System.out.println("       MENU LIVROS");
                    System.out.println("----------------------------");
                    MostrarmenuLivro();
                    MostrarmenuLocadora();
                    break;
                case "4":
                    System.out.println("----------------------------");
                    System.out.println("      MENU FILMES");
                    System.out.println("----------------------------");
                    MostrarmenuFilme();
                    MostrarmenuLocadora();
                    break;
                case "5":
                    System.out.println("----------------------------");
                    System.out.println("      MENU JOGOS");
                    System.out.println("----------------------------");
                    MostrarmenuJogo();
                    MostrarmenuLocadora();
                    break;
                case "6":
                    System.out.println("----------------------------");
                    System.out.println("      MENU CLIENTE");
                    System.out.println("----------------------------");
                    MostrarmenuCliente();
                    MostrarmenuLocadora();
                    break;
                case "7":
                    menuPrinciapl();
                    break;
                case "8":
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
        System.out.println("5. Voltar ao Menu anterior");
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
                    MostrarmenuFuncionario();
                    break;
                case "2":
                    System.out.println("----------------------------");
                    System.out.println("     ATUALIZAR FUNCIONARIO");
                    System.out.println("----------------------------");
                    Funcionario func = AdicionarFuncionario();
                    funcionarioController.atualizarFuncionario(func);
                    MostrarmenuFuncionario();
                    break;
                case "3":
                    System.out.println("----------------------------");
                    System.out.println("       LISTAR FUNCIONARIO");
                    System.out.println("----------------------------");
                    MostrarmenuFuncionario();
                    break;
                case "4":
                    System.out.println("----------------------------");
                    System.out.println("      DELETAR FUNCIONARIO");
                    System.out.println("----------------------------");
                    MostrarmenuFuncionario();
                    break;
                case "5":

                    funcionarioController.salvarDados();
                    locadoraController.AdicionarFuncionario(funcionarioController.listarFuncionarios());
                    MostrarmenuLocadora();
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

    public void MostrarmenuCliente() {
        System.out.println("** Cliente **");
        System.out.println("1. Cadastrar Cliente");
        System.out.println("2. Atualizar Cliente");
        System.out.println("3. Listar Cliente");
        System.out.println("4. Deletar Cliente");
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
                    System.out.println("      ADICIONAR CLIENTE");
                    System.out.println("----------------------------");
                    AdicionarCliente();
                    MostrarmenuCliente();
                    break;
                case "2":
                    System.out.println("----------------------------");
                    System.out.println("     ATUALIZAR CLIENTE");
                    System.out.println("----------------------------");
                    Cliente cliente = AdicionarCliente();
                    clienteController.atualizarCliente(cliente);
                    MostrarmenuCliente();
                    break;
                case "3":
                    System.out.println("----------------------------");
                    System.out.println("       LISTAR CLIENTE");
                    System.out.println("----------------------------");
                    clienteController.listarCliente();
                    MostrarmenuCliente();
                    break;
                case "4":
                    System.out.println("----------------------------");
                    System.out.println("      DELETAR CLIENTE");
                    System.out.println("----------------------------");
                    System.out.println("Infome o código do cliente");
                    int codigo = leitor.nextInt();
                    clienteController.deletarCliente(codigo);
                    MostrarmenuCliente();
                    break;
                case "5":

                    clienteController.salvarDados();
                    locadoraController.AdicionarClientes(clienteController.listarCliente());
                    MostrarmenuLocadora();
                    break;
                case "6":
                    System.out.println("Saindo do sistema...");
                    leitor.close();
                    clienteController.salvarDados();
                    locadoraController.AdicionarClientes(clienteController.listarCliente());
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
                    MostrarmenuLivro();

                    break;
                case "2":
                    System.out.println("----------------------------");
                    System.out.println("     ATUALIZAR LIVRO");
                    System.out.println("----------------------------");
                    Livro livro = incluirLivro();
                    controleLivro.atualizarLivro(livro);
                    MostrarmenuLivro();
                    break;
                case "3":
                    System.out.println("----------------------------");
                    System.out.println("       LISTAR LIVRO");
                    System.out.println("----------------------------");
                    controleLivro.listarLivros();
                    MostrarmenuLivro();
                    break;
                case "4":
                    System.out.println("----------------------------");
                    System.out.println("      DELETAR LIVROS");
                    System.out.println("----------------------------");
                    System.out.println("Informe o codigo do livro:");
                    int codigo = leitor.nextInt();
                    controleLivro.deletarLivro(codigo);
                    MostrarmenuLivro();
                    break;
                case "5":

                    controleLivro.salvarDados();
                    locadoraController.AdicionarLivros(controleLivro.listarLivros());
                    MostrarmenuLocadora();
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

    public Livro incluirLivro() {
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

        return livro;

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
                    incluirFilme();
                    MostrarmenuFilme();
                    break;
                case "2":
                    System.out.println("----------------------------");
                    System.out.println("     ATUALIZAR FILME");
                    System.out.println("----------------------------");
                    Filme filme = incluirFilme();
                    filmeController.atualizarFilme(filme);
                    MostrarmenuFilme();
                    break;
                case "3":
                    System.out.println("----------------------------");
                    System.out.println("       LISTAR FILME");
                    System.out.println("----------------------------");
                    filmeController.listarFilmes();
                    MostrarmenuFilme();
                    break;
                case "4":
                    System.out.println("----------------------------");
                    System.out.println("      DELETAR FILMES");
                    System.out.println("----------------------------");
                    System.out.println("Informe o código do filme:");
                    int codigo = leitor.nextInt();
                    filmeController.deletarFilme(codigo);
                    MostrarmenuFilme();
                    break;
                case "5":

                    filmeController.salvarDados();
                    locadoraController.AdicionarFilmes(filmeController.listarFilmes());
                    MostrarmenuLocadora();
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

    public Filme incluirFilme() {
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

        return filme;

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
                    MostrarmenuJogo();
                    break;
                case "2":
                    System.out.println("----------------------------");
                    System.out.println("     ATUALIZAR JOGO");
                    System.out.println("----------------------------");
                    Jogo jogo = incluirJogo();
                    jogoController.atualizarJogo(jogo);
                    MostrarmenuJogo();
                    break;
                case "3":
                    System.out.println("----------------------------");
                    System.out.println("       LISTAR JOGO");
                    System.out.println("----------------------------");
                    jogoController.listarJogos();
                    MostrarmenuJogo();
                    break;
                case "4":
                    System.out.println("----------------------------");
                    System.out.println("      DELETAR JOGOS");
                    System.out.println("----------------------------");
                    deletarJogo();
                    MostrarmenuJogo();
                    break;
                case "5":

                    jogoController.salvarDados();
                    locadoraController.AdicionarJogos(jogoController.listarJogos());
                    MostrarmenuLocadora();
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

    public Jogo incluirJogo() {
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
        return jogo;

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

    public Cliente AdicionarCliente() {
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
        for (TipoCliente tipo : TipoCliente.values()) {
            System.out.println(tipo.ordinal() + " - " + tipo.getTipoCliente());
        }

        System.out.print("Digite o número correspondente ao tipo do cliente: ");
        int tipoIndex = leitor.nextInt();

        TipoCliente clienteTipo = TipoCliente.values()[tipoIndex];

        System.out.println("Digite o codigo: ");
        int codigo = leitor.nextInt();

        Cliente cliente = new Cliente(documento, nome, idade, endereco, clienteTipo, codigo);
        clienteController.incluirCliente(cliente);

        return cliente;
    }

}
