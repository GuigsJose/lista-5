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

    public void AdicionarFuncionarios(List<Funcionario> funcionarios) {
        Funcionarios = funcionarios;
    }

    public void AdicionarFilmes(List<Filme> filmes) {
        Filmes = filmes;
    }

    public void AdicionarLivros(List<Livro> livros) {
        Livros = livros;
    }

    public void AdicionarJogos(List<Jogo> jogos) {
        Jogos = jogos;
    }

    public void AdicionarClientes(List<Cliente> clientes) {
        Clientes = clientes;
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

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        this.Endereco = endereco;
    }

    public String getCnpj() {
        return Cnpj;
    }

    public void setCnpj(String cnpj) {
        this.Cnpj = cnpj;
    }

    public int getAnoFundacao() {
        return AnoFundacao;
    }

    public void setAnoFundacao(int anoFundacao) {
        this.AnoFundacao = anoFundacao;
    }
}
