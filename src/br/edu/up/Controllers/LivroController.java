package br.edu.up.Controllers;

import java.util.List;

import br.edu.up.DAO.LivroDAO;
import br.edu.up.Models.Categoria;
import br.edu.up.Models.Livro;

public class LivroController {
    /*LUIS:
     * APENAS NÃO FIZ O MÉTODO, APENOS O CRIEI
     */
    /*
     * @Author: Guilherme:
     *  Estou criando o CRUD da controller, para a utilização da VIEW
     */
    private LivroDAO daos =  new LivroDAO();
    private List<Livro> livros;

    public LivroController(){
        this.livros = daos.listarLivros();
    }

    //Criar
    public void incluirLivro(String codigo, String titulo, String isbn, int ano, String categoriaDescricao){
        try{
            Categoria categoria = Categoria.descricaoCategoria(categoriaDescricao);
            Livro livro = new Livro(codigo, titulo, isbn, ano, categoria);
            livros.add(livro);
            daos.adicionarLivro(livros); 
        }catch(IllegalArgumentException e){
            System.out.println("Categoria inválida: " + categoriaDescricao);
        }
    }
}
