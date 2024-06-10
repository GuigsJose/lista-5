package br.edu.up.Controllers;

import java.util.List;
import br.edu.up.DAO.FilmeDAO;
import br.edu.up.Models.Filme;

public class FilmeController {

    private FilmeDAO dao = new FilmeDAO();
    private List<Filme> filmes;

    public FilmeController() {
        this.filmes = dao.listarFilmes();
    }

    // Criar
    public void incluirFilme(String id, String nome, String genero, String diretor, int anoLancamento) {
        try {
            Filme filme = new Filme(id, nome, genero, diretor, anoLancamento);
            filmes.add(filme);
            dao.adicionarFilme(filmes);

        } catch (IllegalArgumentException e) {
            System.out.println("Gênero inválido: " + genero);
        }
    }

    // Listar filmes
    public List<Filme> listarFilmes() {
        return dao.listarFilmes();
    }

    // Atualizar
    public void atualizarFilme(String id, String nome, String genero, String diretor, int anoLancamento) {
        try {
            Filme filme = new Filme(id, nome, genero, diretor, anoLancamento);
            boolean atualizado = dao.atualizarFilme(filme);
            if (atualizado) {
                System.out.println("Filme Atualizado com sucesso!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Gênero inválido: " + genero);
        }
    }

    // Deletar
    public void deletarFilme(String id) {
        boolean deletado = dao.deletarFilme(id);
        if (deletado) {
            System.out.println("Filme deletado com sucesso");
        } else {
            System.out.println("Código não encontrado: " + id);
        }
    }
}
