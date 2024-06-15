package br.edu.up.DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.up.Models.Cliente;
import br.edu.up.Models.Enums.TipoCliente;

public class ClienteDAO {
  private String header = "";
  private String arquivo = "C:\\Users\\guize\\Desktop\\Faculdade\\lista-5-final\\lista-5\\src\\br\\edu\\up\\DAO\\Clientes.csv";
  List<Cliente> ListaClientes = new ArrayList<Cliente>();

  // READ lista todos os jogos
  public boolean adicionarClientes(List<Cliente> cliente) {

    try {

      FileWriter salvaArquivo = new FileWriter(arquivo);
      PrintWriter salvar = new PrintWriter(salvaArquivo);

      salvar.println(header);

      for (Cliente clien : cliente) {
        salvar.println(clien.toCsv());
      }
      salvar.close();

      return true;

    } catch (IOException e) {
      System.out.println("Não foi possivel gravar o arquivo");
    }
    return false;
  }

  public boolean gravarCliente(Cliente cliente) {
    return ListaClientes.add(cliente);
  }

  // UPDATE
  public boolean atualizarCliente(Cliente cliente) {
    // Que isso meu deus?
    // List<Jogo> jogos = listarJogos();
    boolean encontrado = ListaClientes.equals(cliente);

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
      int index = ListaClientes.indexOf(cliente);
      ListaClientes.add(index, cliente);
      return adicionarClientes(ListaClientes);
    } else {
      System.out.println("Codigo não encontrado: " + cliente.getCodigo());
      return false;
    }
  }

  // DELETE
  public boolean deletarCliente(int id) {
    boolean encontrado = ListaClientes.removeIf(x -> x.getCodigo() == id);

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
      return (adicionarClientes(ListaClientes));
    } else {
      System.out.println("Código não encontrado: " + id);
      return false;
    }
  }

  // Lista todos os jogos
  public List<Cliente> listarClientes() {

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
          TipoCliente cargo = TipoCliente.valueOf(dados[4]);
          String endereco = dados[5];

          Cliente clien = new Cliente(documento, nome, idade, endereco, cargo, id);
          ListaClientes.add(clien);
        }
      }
      sc.close();

    } catch (FileNotFoundException e) {
      System.out.println("Arquivo não encontrado! " + e.getMessage());
    }
    return ListaClientes;
  }

}
