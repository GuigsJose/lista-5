package br.edu.up.Controllers;

import java.util.List;
import java.util.stream.Collectors;

import br.edu.up.Models.Cliente;
import br.edu.up.Models.Filme;
import br.edu.up.Models.Funcionario;
import br.edu.up.Models.Jogo;
import br.edu.up.Models.Livro;
import br.edu.up.Models.Locadora;

public class LocadoraController {
  Locadora Locadora;

  public void CriarLocadora(String nome, String endereco, String cnpj, int ano) {
    Locadora = new Locadora(nome, endereco, cnpj, ano);
  }

  public String ConsultarLocadora() {
    return Locadora.toString();
  }

  public void AdicionarLivros(List<Livro> livros) {
    Locadora.AdicionarLivros(livros);
  }

  public void AdicionarFilmes(List<Filme> filmes) {
    Locadora.AdicionarFilmes(filmes);
  }

  public void AdicionarJogos(List<Jogo> jogos) {
    Locadora.AdicionarJogos(jogos);
  }

  public void AdicionarFuncionario(List<Funcionario> funcionarios) {
    Locadora.AdicionarFuncionarios(funcionarios);
  }

  public void AdicionarClientes(List<Cliente> clientes) {
    Locadora.AdicionarClientes(clientes);
  }

  public void AtualizarLivros(List<Livro> livros) {
    Locadora.AdicionarLivros(livros);
  }

  public void AtualizarFilmes(List<Filme> filmes) {
    Locadora.AdicionarFilmes(filmes);
  }

  public void AtualizarJogos(List<Jogo> jogos) {
    Locadora.AdicionarJogos(jogos);
  }

  public void AtualizarFuncionarios(List<Funcionario> funcionarios) {
    Locadora.AdicionarFuncionarios(funcionarios);
  }

  public void AtualizarClientes(List<Cliente> clientes) {
    Locadora.AdicionarClientes(clientes);
  }

  public List<Funcionario> GetFuncionario(int codigo) {
    return Locadora.GetFuncionario(codigo);
  }

  public List<Filme> GetFilme(int codigo) {
    return Locadora.GetFilme(codigo);
  }

  public List<Livro> GetLivro(int codigo) {
    return Locadora.GetLivro(codigo);
  }

  public List<Jogo> GetJogo(int codigo) {
    return Locadora.GetJogo(codigo);
  }

  public List<Cliente> GetCliente(int codigo) {
    return Locadora.GetCliente(codigo);
  }
}
