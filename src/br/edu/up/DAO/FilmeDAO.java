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
import br.edu.up.Models.Enums.Categoria;

public class FilmeDAO {

    /*
     * @author João: foi criado DAO baseado em livros,
     * feito algumas alterações necessárias.
     * assim como as outras.
     */

    private String header = "";
    private String arquivo = "C:\\Users\\guize\\Desktop\\Faculdade\\lista-5-final\\lista-5\\src\\br\\edu\\up\\DAO\\Filmes.Csv";
    List<Filme> listaDeFilmes = new ArrayList<Filme>();

    public List<Filme> listarFilmes() {

        try {
            File arquivoFilmes = new File(arquivo);
            Scanner sc = new Scanner(arquivoFilmes);
            header = sc.nextLine();

            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                String[] dados = linha.split(";");

                int id = Integer.parseInt(dados[0]);
                if (id != 0) {
                    String nome = dados[1];
                    Categoria categoria = Categoria.valueOf(dados[2]);
                    String diretor = dados[3];
                    int anoLancamento = Integer.parseInt(dados[4]);

                    Filme filme = new Filme(id, nome, diretor, anoLancamento, categoria);
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
    public boolean adicionarFilme(Filme filme) {
        listaDeFilmes.add(filme);
        return gravarFilme(listaDeFilmes);
    }

    public boolean gravarFilme(List<Filme> filmes) {
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
        boolean encontrado = listaDeFilmes.equals(filme);

        // ISSO NAO EXISTE SER FEITO COM UMA COLLECTIONS
        // for (int i = 0; i < listaDeFilmes.size(); i++) {
        // if (listaDeFilmes.equals(filme)) {
        // listaDeFilmes.set(i, filme);
        // encontrado = true;
        // break;
        // }
        // }

        if (encontrado) {
            int index = listaDeFilmes.indexOf(filme);
            listaDeFilmes.add(index, filme);
            return gravarFilme(listaDeFilmes);
        } else {
            System.out.println("id não encontrado: " + filme.getCodigo());
            return false;
        }
    }

    // DELETE
    public boolean deletarFilme(int id) {
        boolean encontrado = listaDeFilmes.removeIf(x -> x.getCodigo() == id);

        // Que isso?
        // List<Filme> filmes = listarFilmes();
        // boolean encontrado = false;

        // for (int i = 0; i < filmes.size(); i++) {
        // Filme filme = filmes.get(i);
        // if (filme.getId().equals(id)) {
        // filmes.remove(i);
        // encontrado = true;
        // break;
        // }
        // }

        if (encontrado) {
            return gravarFilme(listaDeFilmes);
        } else {
            System.out.println("Código não encontrado: " + id);
            return false;
        }
    }
}
