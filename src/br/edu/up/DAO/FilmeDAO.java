package br.edu.up.DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.up.Models.Categoria;
import br.edu.up.Models.Filme;
import br.edu.up.Models.Livro;

public class FilmeDAO {

    private String header = "";
    private String arquivo = "\"C:\\Users\\João Gabriel\\OneDrive\\Área de Trabalho\\UP\\_java-aula\\lista-5\\bin\\br\\edu\\up\\DAO\\Filmes.Csv\"";

    public List<Filme> listarFilmes(){
        List<Filme> listaDeFilmes = new ArrayList<>();

        try{
            File arquivoFilmes = new File(arquivo);

            Scanner sc = new Scanner(arquivoFilmes);
            //aqui é só o nome da primeira linha(nome das colunas, então fiz essa variavel pra ler essa linha)
            // e pular ela
            header = sc.nextLine();

            while (sc.hasNextLine()) {
                String linha = sc.nextLine();

                String[] dados = linha.split(";");

                String id = dados[0];


                if (id != null && !id.equals("")) {
                    String nome = dados[1];
                    String genero = dados[2];
                    String diretor(dados[3]);
                    int anoLancamento = Integer.parseInt(dados[4]);
                    //aqui transforma o enum numa string, e passa a posição correspondente no array
                    //de dados no csv
                    

                    Filme filme = new Livro(id, nome, genero, diretor, anoLancamento);
                    listaDeFilmes.add(filme);
                }    
            }
            sc.close();


        }catch(FileNotFoundException e){
            System.out.println("Arquivo não encontrado! " + e.getMessage());
        }
        return listaDeFilmes;
    }

    //CREATE
    public boolean adicionarLivro(List<Livro> livros){

        try{

            FileWriter salvaArquivo = new FileWriter(arquivo);
            PrintWriter salvar = new PrintWriter(salvaArquivo);

            salvar.println(header);

            for (Livro livro : livros) {
                salvar.println(livro.toCsv());
            }
            salvar.close();

            return true;


        }catch(IOException e){
            System.out.println("Não foi possivel gravar o arquivo");
        }
        return false;
    }

    //UPDATE
    public boolean atualizarLivro(Livro livro){
        List<Livro> livros = listarLivros();
        boolean encontrado = false;

        for (int i = 0; i < livros.size(); i++) {
            Livro l = livros.get(i);  
            if (livro.getCodigo().equals(livro.getCodigo())) {
                livros.set(i, livro);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            return adicionarLivro(livros);
        }else{
            System.out.println("Codigo não encontrado: " + livro.getCodigo());
            return false;
        }
    }

    //DELETE
    public boolean deletarLivro(String codigo){
        List<Livro> livros = listarLivros();
        boolean encontrado = false;

        for (int i = 0; i < livros.size(); i++) {
            Livro livro = livros.get(i);
            if (livro.getCodigo().equals(codigo)) {
                livros.remove(i);
                encontrado = true;
                break;
            }
        }

        // rapazes, não achem estranho esse adicionarLivro(livros)
        // básicamente ele encontra o livro ali, deleta o livro(passando o código equivalente)
        // e retorna o adicionarLivro, pq ele atualiza a tabela de livros do arquivo csv
        if (encontrado) {
            return(adicionarLivro(livros));
        }else{
            System.out.println("Código não encontrado: " + codigo);
            return false;
        }
    }

}
