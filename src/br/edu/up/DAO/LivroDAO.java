package br.edu.up.DAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.up.Models.Categoria;
import br.edu.up.Models.Livro;

public class LivroDAO implements LivroDaoInterface {
    private String arquivoCsv;

    public LivroDAO(String arquivoCsv){
        this.arquivoCsv = arquivoCsv;
    }

    @Override
    public List<Livro> listarLivros(){
        List<Livro> livros = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(arquivoCsv))){
            String linha;
            while((linha = br.readLine()) != null){
                String[] dados = linha.split(",");
                Livro livro = new Livro(dados[0], dados[1], dados[2],Integer.parseInt(dados[3]),Categoria.valueOf(dados[4]));
                livros.add(livro);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return livros;
    }

    @Override
    public void adicionarLivro(Livro livro){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoCsv, true))){
            bw.write(livro.getCodigo() + "," + livro.getTitulo() + "," + livro.getIsbn() + "," + livro.getAno() + "," + livro.getCategoria().name());
            bw.newLine();
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("EERROOOOO");
        }
    }

    @Override
    public void atualizarLivro(String codigo, String titulo, String isbn, int ano, Categoria categoria) {
        List<Livro> livros = listarLivros();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoCsv))) {
            for (Livro l : livros) {
                if (l.getCodigo().equals(codigo)) {
                    bw.write(codigo + "," + titulo + "," + isbn + "," + ano + "," + categoria.name());
                } else {
                    bw.write(l.getCodigo() + "," + l.getTitulo() + "," + l.getIsbn() + "," + l.getAno() + "," + l.getCategoria().name());
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removerLivro(String codigo) {
        List<Livro> livros = listarLivros();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoCsv))) {
            for (Livro l : livros) {
                if (!l.getCodigo().equals(codigo)) {
                    bw.write(l.getCodigo() + "," + l.getTitulo() + "," + l.getIsbn() + "," + l.getAno() + "," + l.getCategoria().name());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Livro buscarLivros(String codigo) {
        List<Livro> livros = listarLivros();
        for (Livro livro : livros) {
            if (livro.getCodigo().equals(codigo)) {
                return livro;
            }
        }
        return null; // Livro não encontrado
    }

}
