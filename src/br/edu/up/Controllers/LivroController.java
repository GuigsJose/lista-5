package br.edu.up.Controllers;

import java.util.List;

import br.edu.up.DAO.LivroDAO;
import br.edu.up.Models.Livro;

public class LivroController {
    /*
     * LUIS:
     * APENAS NÃO FIZ O MÉTODO, APENOS O CRIEI
     */
    /*
     * @Author: Guilherme:
     * Estou criando o CRUD da controller, para a utilização da VIEW
     */
    private LivroDAO daos = new LivroDAO();
    private List<Livro> livros;

    public LivroController() {
        this.livros = daos.listarLivros();
    }

    // Criar
    public void incluirLivro(String codigo, String titulo, String isbn, int ano, String categoriaDescricao) {
        try {
            Categoria categoria = Categoria.descricaoCategoria(categoriaDescricao);
            Livro livro = new Livro(codigo, titulo, isbn, ano, categoria);
            livros.add(livro);
            daos.adicionarLivro(livros);
        } catch (IllegalArgumentException e) {
            System.out.println("Categoria inválida: " + categoriaDescricao);
        }
    }

    // Listar livros
    public List<Livro> listarLivros() {
        return daos.listarLivros();
    }

    // atualizar
    public void atualizarLivro(String codigo, String novoTitulo, String novoIsbn, int novoAno, String novaCategoria) {
        try {
            Categoria categoria = Categoria.descricaoCategoria(novaCategoria);
            Livro novoLivro = new Livro(codigo, novoTitulo, novoIsbn, novoAno, categoria);
            boolean atualizado = daos.atualizarLivro(novoLivro);
            if (atualizado) {
                // [bizu] coloquei um sysout pra verificação
                System.out.println("Livro Atualizado com sucesso!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Categoria inválida: " + novaCategoria);
        }
    }

    // delete
    public void deletarLivro(String codigo) {
        boolean deletado = daos.deletarLivro(codigo);
        if (deletado) {
            System.out.println("Livro deletado com sucesso");
        } else {
            System.out.println("Código não encontrado: " + codigo);
        }
    }

    // public boolean GravarDados(){
    // return daos.adicionarLivro(livros);
    // }

}
