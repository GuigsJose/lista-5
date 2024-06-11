package br.edu.up.Controllers;

import java.util.List;
import br.edu.up.DAO.FilmeDAO;
import br.edu.up.Models.Filme;

public class FilmeController {

    private FilmeDAO daos = new FilmeDAO();
    private List<Filme> filmes;

    public FilmeController() {
        this.filmes = daos.listarFilmes();
    }

    // Criar
    public String incluirFilme(Filme filme) {
        daos.adicionarFilme(filme);
    }

    // Listar filmes
    public List<Filme> listarFilmes() {
        return daos.listarFilmes();
    }

    // Atualizar
    public String atualizarFilme(String id, String nome, String genero, String diretor, int anoLancamento) {
        try {
            Filme filme = new Filme(id, nome, genero, diretor, anoLancamento);
            daos.atualizarFilme(filme);
            return "Filme Atualizado com sucesso!";

        } catch (IllegalArgumentException e) {
            return "Gênero inválido: " + e;
        }
    }

    // Deletar
    public String deletarFilme(String id) {
        boolean deletado = daos.deletarFilme(id);
        if (deletado) {
            return "Filme deletado com sucesso";
        } else {
            return "Código não encontrado: " + id;
        }
    }
}
