package br.edu.up.Controllers;

import java.util.List;

import br.edu.up.DAO.LivroDAO;
import br.edu.up.Models.Livro;

public class LivroController {
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
    public void incluirLivro(Livro livro){
        this.livros.add(livro);
    }

    //Listar livros
    public List<Livro> listarLivros(){
        return daos.listarLivros();
    }

    //atualizar
    public void atualizarLivro(Livro livro){
        // try{
        //     Categoria categoria = Categoria.descricaoCategoria(novaCategoria);
        //     Livro novoLivro = new Livro(codigo, novoTitulo, novoIsbn, novoAno, categoria);
        //     boolean atualizado = daos.atualizarLivro(novoLivro);
        //     if (atualizado) {
        //         //[bizu] coloquei um sysout pra verificação
        //         System.out.println("Livro Atualizado com sucesso!");
        //     }
        // }catch(IllegalArgumentException e){
        //     System.out.println("Categoria inválida: " + novaCategoria);
        // }
        daos.atualizarLivro(livro);
    }

    //delete
    public void deletarLivro(String codigo){
    //     boolean deletado = daos.deletarLivro(codigo);
    //     if (deletado) {
    //         System.out.println("Livro deletado com sucesso");
    //     }else{
    //         System.out.println("Código não encontrado: " + codigo);
    //     }
    // }

    // public boolean GravarDados(){
    //     return daos.adicionarLivro(livros);
    // }

        daos.deletarLivro(codigo);
    }
}
