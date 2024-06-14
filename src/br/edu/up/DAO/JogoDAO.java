package br.edu.up.DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import br.edu.up.Models.Jogo;
import br.edu.up.Models.Livro;
import br.edu.up.Models.Enums.Categoria;

public class JogoDAO {
    private String header = "";
    private String arquivo = "C:\\Java-Project\\lista-05\\Biblioteca\\src\\br\\edu\\up\\DAO\\Jogos.csv";
    List<Jogo> ListaJogos = new ArrayList<Jogo>();

    // READ lista todos os jogos
    public boolean adicionarJogos(List<Jogo> jogos) {

        try {

            FileWriter salvaArquivo = new FileWriter(arquivo);
            PrintWriter salvar = new PrintWriter(salvaArquivo);

            salvar.println(header);

            for (Jogo jogo : jogos) {
                salvar.println(jogo.toCsv());
            }
            salvar.close();

            return true;

        } catch (IOException e) {
            System.out.println("Não foi possivel gravar o arquivo");
        }
        return false;
    }

    public boolean gravarJogo(Jogo jogo) {
        return ListaJogos.add(jogo);
    }

    // UPDATE
    public boolean atualizarJogo(Jogo jogo) {
        // Que isso meu deus?
        // List<Jogo> jogos = listarJogos();
        boolean encontrado = ListaJogos.equals(jogo);

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
            int index = ListaJogos.indexOf(jogo);
            ListaJogos.add(index, jogo);
            return adicionarJogos(ListaJogos);
        } else {
            System.out.println("Codigo não encontrado: " + jogo.getCodigo());
            return false;
        }
    }

    // DELETE
    public boolean deletarJogo(int id) {
        boolean encontrado = ListaJogos.removeIf(x -> x.getCodigo() == id);

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
            return (adicionarJogos(ListaJogos));
        } else {
            System.out.println("Código não encontrado: " + id);
            return false;
        }
    }

    // Lista todos os jogos
    public List<Jogo> listarJogos() {
        List<Jogo> listaDeJogos = new ArrayList<>();

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
                    Categoria categoria = Categoria.valueOf(dados[2]);
                    int ano = Integer.parseInt(dados[3]);

                    Jogo jogo = new Jogo(id, nome, categoria, ano);
                    listaDeJogos.add(jogo);
                }
            }
            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado! " + e.getMessage());
        }
        return listaDeJogos;
    }

    public boolean gravarJogo(List<Jogo> jogo) {
        try {
            FileWriter salvaArquivo = new FileWriter(arquivo);
            PrintWriter salvar = new PrintWriter(salvaArquivo);

            salvar.println(header);

            for (Jogo jg : jogo) {
                salvar.println(jg.toCsv());
            }
            salvar.close();

            return true;

        } catch (IOException e) {
            System.out.println("Não foi possivel gravar o arquivo");
        }
        return false;
    }

}
