package br.edu.up.Controllers;
import java.util.List;
import br.edu.up.DAO.FilmeDAO;
import br.edu.up.Models.*;


public class filmeController {
    /*LUIS:
     * APENAS NÃO FIZ O MÉTODO, APENOS O CRIEI
     */
    /*
     * @Author: Guilherme:
     *  Estou criando o CRUD da controller, para a utilização da VIEW
     */
    private FilmeDAO daos =  new FilmeDAO();
    private List<Filme> filmes;

    public filmeController(){
        this.filmes = daos.listarFilmes();
    }

    //Criar
    public void incluirFilme(String id, String nome, String diretor, String genero, int anoLancamento){
        try{
            
            Filme filme = new Filme(id, nome, diretor, genero, anoLancamento);
            filmes.add(filme);
            daos.incluirFilme(filme);
            
            
        }catch(IllegalArgumentException e){
            System.out.println("genero inválido: " + genero);
        }
    }

    //Listar filmes
    public List<Filme> listarFilmes(){
        return daos.listarFilmes();
    }

    //atualizar
    public void atualizarFilme(String codigo, String novoTitulo, String novoIsbn, int novoAno, String novaCategoria){
        try{
            Categoria categoria = Categoria.descricaoCategoria(novaCategoria);
            Livro novoLivro = new Livro(codigo, novoTitulo, novoIsbn, novoAno, categoria);
            boolean atualizado = daos.atualizarLivro(novoLivro);
            if (atualizado) {
                //[bizu] coloquei um sysout pra verificação
                System.out.println("Livro Atualizado com sucesso!");
            }
        }catch(IllegalArgumentException e){
            System.out.println("Categoria inválida: " + novaCategoria);
        }
    }

    //delete
    public void deletarLivro(String codigo){
        boolean deletado = daos.deletarLivro(codigo);
        if (deletado) {
            System.out.println("Livro deletado com sucesso");
        }else{
            System.out.println("Código não encontrado: " + codigo);
        }
    }

}
