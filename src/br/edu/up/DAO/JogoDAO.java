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

public class JogoDAO {
    private String header = "";
    private String arquivo = "C:\\Users\\Luis_\\Desktop\\Faculdade\\Java\\lista-5\\bin\\br\\edu\\up\\DAO\\Jogos.csv";

    //CREATE JOGOS
    public boolean adicionarJogos(List<Jogo> jogos){

        try{

            FileWriter salvaArquivo = new FileWriter(arquivo);
            PrintWriter salvar = new PrintWriter(salvaArquivo);

            salvar.println(header);

            for (Jogo jogo : jogos) {
                salvar.println(jogo.toCsv());
            }
            salvar.close();

            return true;


        }catch(IOException e){
            System.out.println("Não foi possivel gravar o arquivo");
        }
        return false;
    }

    //UPDATE
    public boolean atualizarJogo(Jogo jogo){
        List<Jogo> jogos = listarJogos();
        boolean encontrado = false;

        for (int i = 0; i < jogos.size(); i++) {
            Jogo j = jogos.get(i);  
            if (jogo.getId().equals(jogo.getId())) {
                jogos.set(i, jogo);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            return adicionarJogos(jogos);
        }else{
            System.out.println("Codigo não encontrado: " + jogo.getId());
            return false;
        }
    }

    //DELETE
    public boolean deletarJogo(String id){
        List<Jogo> jogos = listarJogos();
        boolean encontrado = false;

        for (int i = 0; i < jogos.size(); i++) {
            Jogo jogo = jogos.get(i);
            if (jogo.getId().equals(id)) {
                jogos.remove(i);
                encontrado = true;
                break;
            }
        }


        if (encontrado) {
            return(adicionarJogos(jogos));
        }else{
            System.out.println("Código não encontrado: " + id);
            return false;
        }
    }
    
    // Lista todos os jogos 
    public List<Jogo> listarJogos(){
        List<Jogo> listaDeJogos = new ArrayList<>();

        try{
            File arquivoJogos = new File(arquivo);

            Scanner sc = new Scanner(arquivoJogos);
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
                    int ano = Integer.parseInt(dados[3]);
                    
                    Jogo jogo = new Jogo(id, nome, genero, ano);
                    listaDeJogos.add(jogo);
                }    
            }
            sc.close();


        }catch(FileNotFoundException e){
            System.out.println("Arquivo não encontrado! " + e.getMessage());
        }
        return listaDeJogos;
    }
}
