package br.edu.up.DAO;

import java.util.List;

import br.edu.up.Models.Livro;

public interface LivroDaoInterface {
    List<Livro> livros();
    void adicionarLivro(Livro livro);  
    void removerLivro(Livro livro);  
    void atualizarLivro(String codigo);  
    void listarLivros(String codigo);  
}
