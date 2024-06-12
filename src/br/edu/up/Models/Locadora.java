package br.edu.up.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Locadora {
    String Nome;
    String Endereco;
    String Cnpj;
    int AnoFundacao;

    // Funcionarios
    List<Funcionario> Funcionarios = new ArrayList<Funcionario>();

    // Produto
    List<Filme> Filmes = new ArrayList<Filme>();
    List<Livro> Livros = new ArrayList<Livro>();
    List<Jogo> Jogos = new ArrayList<Jogo>();

    // Clientes
    List<Cliente> Clientes = new ArrayList<Cliente>();

    public Locadora(String nome, String endereco, String cnpj, int ano) {
        Nome = nome;
        Endereco = endereco;
        Cnpj = cnpj;
        AnoFundacao = ano;
    }

    public void AdicionarFuncionario(Funcionario funcionario) {
        Funcionarios.add(funcionario);
    }

    public void AdicionarFilme(Filme filme) {
        Filmes.add(filme);
    }

    public void AdicionarLivro(Livro livro) {
        Livros.add(livro);
    }

    public void AdicionarJogos(Jogo jogo) {
        Jogos.add(jogo);
    }

    public void AdicionarCliente(Cliente cliente) {
        Clientes.add(cliente);
    }

    public List<Funcionario> GetFuncionario(int codigo) {
        return Funcionarios.stream().filter(x -> x.getCodigo() == codigo).collect(Collectors.toList());
    }

    public List<Filme> GetFilme(int codigo) {
        return Filmes.stream().filter(x -> x.getCodigo() == codigo).collect(Collectors.toList());
    }

    public List<Livro> GetLivro(int codigo) {
        return Livros.stream().filter(x -> x.getCodigo() == codigo).collect(Collectors.toList());
    }

    public List<Jogo> GetJogo(int codigo) {
        return Jogos.stream().filter(x -> x.getCodigo() == codigo).collect(Collectors.toList());
    }

    public List<Cliente> GetCliente(int codigo) {
        return Clientes.stream().filter(x -> x.getCodigo() == codigo).collect(Collectors.toList());
    }

    public String ListaFuncionarios() {
        return Funcionarios.toString();
    }

    public String ListaFilmes() {
        return Filmes.toString();
    }

    public String ListaLivros() {
        return Livros.toString();
    }

    public String ListaJogos() {
        return Jogos.toString();
    }

    public String ListaClientes() {
        return Clientes.toString();
    }

    public void ExcluirFuncionario(int codigo) {
        Funcionarios.remove(codigo);
    }

    public void ExcluirFilme(int codigo) {
        Filmes.remove(codigo);
    }

    public void ExcluirLivro(int codigo) {
        Livros.remove(codigo);
    }

    public void ExcluirJogo(int codigo) {
        Jogos.remove(codigo);
    }

    public void ExcluirCliente(int codigo) {
        Clientes.remove(codigo);
    }
}
