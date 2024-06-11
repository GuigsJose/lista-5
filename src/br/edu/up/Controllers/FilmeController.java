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
    public String incluirFilme(String id, String nome, String genero, String diretor, int anoLancamento) {
        try {
            Filme filme = new Filme(id, nome, genero, diretor, anoLancamento);
            filmes.add(filme);
            dao.adicionarFilme(filmes);
            return "Filme adicionado com sucesso!!!";

        } catch (IllegalArgumentException e) {
            return "Gênero inválido: " + e;
        }
    }

    // Listar filmes
    public List<Filme> listarFilmes() {
        return dao.listarFilmes();
    }

    // Atualizar
    public String atualizarFilme(String id, String nome, String genero, String diretor, int anoLancamento) {
        try {
            Filme filme = new Filme(id, nome, genero, diretor, anoLancamento);
            dao.atualizarFilme(filme);
            return "Filme Atualizado com sucesso!";

        } catch (IllegalArgumentException e) {
            return "Gênero inválido: " + e;
        }
    }

    // Deletar
    public String deletarFilme(String id) {
        boolean deletado = dao.deletarFilme(id);
        if (deletado) {
            return "Filme deletado com sucesso";
        } else {
            return "Código não encontrado: " + id;
        }
    }
}
