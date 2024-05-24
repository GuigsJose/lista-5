package br.edu.up.DAO;

import java.util.List;

import br.edu.up.Models.Categoria;
import br.edu.up.Models.Livro;

public interface LivroDaoInterface {
    List<Livro> listarLivros();
    void adicionarLivro(Livro livro);  
    void removerLivro(String codigo);  
    void atualizarLivro(String codigo, String titulo, String isbn, int ano, Categoria categoria);  
    Livro buscarLivros(String codigo);  
}
