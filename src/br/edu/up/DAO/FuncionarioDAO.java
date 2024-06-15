
package br.edu.up.DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.up.Models.Funcionario;
import br.edu.up.Models.Enums.TipoCargo;

public class FuncionarioDAO {
  private String header = "";
  private String arquivo = "C:\\Users\\guize\\Desktop\\Faculdade\\lista-5-final\\lista-5\\src\\br\\edu\\up\\DAO\\Funcionarios.csv";
  List<Funcionario> ListaFuncionario = new ArrayList<Funcionario>();

  // READ lista todos os jogos
  public boolean adicionarFuncionarios(List<Funcionario> funcionario) {

    try {

      FileWriter salvaArquivo = new FileWriter(arquivo);
      PrintWriter salvar = new PrintWriter(salvaArquivo);

      salvar.println(header);

      for (Funcionario func : funcionario) {
        salvar.println(func.toCsv());
      }
      salvar.close();

      return true;

    } catch (IOException e) {
      System.out.println("Não foi possivel gravar o arquivo");
    }
    return false;
  }

  public boolean gravarFuncionario(Funcionario func) {
    return ListaFuncionario.add(func);
  }

  // UPDATE
  public boolean atualizarFuncionario(Funcionario funcionario) {
    // Que isso meu deus?
    // List<Jogo> jogos = listarJogos();
    boolean encontrado = ListaFuncionario.equals(funcionario);

    // Que isso?
    // for (int i = 0; i < ListaJogos.size(); i++) {
    // Jogo j = ListaJogos.get(i);
    // if (jogo.getId().equals(jogo.getId())) {
    // ListaJogos.set(i, jogo);
    // encontrado = true;
    // break;
    // }
    // }

    if (encontrado) {
      int index = ListaFuncionario.indexOf(funcionario);
      ListaFuncionario.add(index, funcionario);
      return adicionarFuncionarios(ListaFuncionario);
    } else {
      System.out.println("Codigo não encontrado: " + funcionario.getCodigo());
      return false;
    }
  }

  // DELETE
  public boolean deletarFuncionario(int id) {
    boolean encontrado = ListaFuncionario.removeIf(x -> x.getCodigo() == id);

    // Que isso?
    // for (int i = 0; i < jogos.size(); i++) {
    // Jogo jogo = jogos.get(i);
    // if (jogo.getId().equals(id)) {
    // jogos.remove(i);
    // encontrado = true;
    // break;
    // }
    // }

    if (encontrado) {
      return (adicionarFuncionarios(ListaFuncionario));
    } else {
      System.out.println("Código não encontrado: " + id);
      return false;
    }
  }

  // Lista todos os jogos
  public List<Funcionario> listarFuncionario() {

    try {
      File arquivoJogos = new File(arquivo);

      Scanner sc = new Scanner(arquivoJogos);
      // aqui é só o nome da primeira linha(nome das colunas, então fiz essa variavel
      // pra ler essa linha)
      // e pular ela
      header = sc.nextLine();

      while (sc.hasNextLine()) {
        String linha = sc.nextLine();

        String[] dados = linha.split(";");

        int id = Integer.parseInt(dados[0]);

        if (id != 0) {
          String nome = dados[1];
          String documento = dados[2];
          int idade = Integer.parseInt(dados[3]);
          TipoCargo cargo = TipoCargo.valueOf(dados[4]);
          String endereco = dados[5];

          Funcionario func = new Funcionario(documento, nome, idade, endereco, cargo, id);
          ListaFuncionario.add(func);
        }
      }
      sc.close();

    } catch (FileNotFoundException e) {
      System.out.println("Arquivo não encontrado! " + e.getMessage());
    }
    return ListaFuncionario;
  }

}
