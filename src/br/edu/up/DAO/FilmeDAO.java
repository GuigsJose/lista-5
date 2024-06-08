package br.edu.up.DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.up.Models.Filme;

public class FilmeDAO {

    /* @author João: foi criado DAO baseado em livros, 
    feito algumas alterações necessárias.
     assim como as outras. */

    private String header = "";
    private String arquivo = "C:\\Users\\João Gabriel\\OneDrive\\Área de Trabalho\\UP\\_java-aula\\lista-5\\bin\\br\\edu\\up\\DAO\\Filmes.Csv";

    public List<Filme> listarFilmes() {
        List<Filme> listaDeFilmes = new ArrayList<>();

        try {
            File arquivoFilmes = new File(arquivo);
            Scanner sc = new Scanner(arquivoFilmes);
            header = sc.nextLine();

            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                String[] dados = linha.split(";");

                String id = dados[0];
                if (id != null && !id.equals("")) {
                    String nome = dados[1];
                    String genero = dados[2];
                    String diretor = dados[3];
                    int anoLancamento = Integer.parseInt(dados[4]);

                    Filme filme = new Filme(id, nome, genero, diretor, anoLancamento);
                    listaDeFilmes.add(filme);
                }
            }
            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado! " + e.getMessage());
        }
        return listaDeFilmes;
    }

    // CREATE
    public boolean adicionarFilme(List<Filme> filmes) {
        try {
            FileWriter salvaArquivo = new FileWriter(arquivo);
            PrintWriter salvar = new PrintWriter(salvaArquivo);
            salvar.println(header);

            for (Filme filme : filmes) {
                salvar.println(filme.toCsv());
            }
            salvar.close();
            return true;

        } catch (IOException e) {
            System.out.println("Não foi possivel gravar o arquivo");
        }
        return false;
    }

    // UPDATE
    public boolean atualizarFilme(Filme filme) {
        List<Filme> filmes = listarFilmes();
        boolean encontrado = false;

        for (int i = 0; i < filmes.size(); i++) {
            Filme f = filmes.get(i);
            if (filme.getId().equals(f.getId())) {
                filmes.set(i, filme);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            return adicionarFilme(filmes);
        } else {
            System.out.println("id não encontrado: " + filme.getId());
            return false;
        }
    }

    // DELETE
    public boolean deletarFilme(String id) {
        List<Filme> filmes = listarFilmes();
        boolean encontrado = false;

        for (int i = 0; i < filmes.size(); i++) {
            Filme filme = filmes.get(i);
            if (filme.getId().equals(id)) {
                filmes.remove(i);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            return adicionarFilme(filmes);
        } else {
            System.out.println("Código não encontrado: " + id);
            return false;
        }
    }
}
