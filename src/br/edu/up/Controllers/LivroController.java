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

    public LivroController(){
        this.livros = daos.listarLivros();
    }

    //Criar
    public void incluirLivro(Livro livro){
        daos.adicionarLivro(livro);
    }


    // Listar livros
    public List<Livro> listarLivros() {
        return daos.listarLivros();
    }

    // atualizar
    public void atualizarLivro(Livro livro) {
        daos.atualizarLivro(livro);
    }

    // delete
    public void deletarLivro(String codigo) {
        daos.deletarLivro(codigo);
    }

    public void salvarDados(){
        daos.gravaLivro(livros);
    }
}
