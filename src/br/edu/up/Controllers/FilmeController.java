package br.edu.up.Controllers;

import java.util.ArrayList;
import java.util.List;
import br.edu.up.DAO.FilmeDAO;
import br.edu.up.Models.Filme;
import br.edu.up.Models.Enums.Categoria;

public class FilmeController {

    private FilmeDAO daos = new FilmeDAO();
    private List<Filme> filmes = new ArrayList<Filme>();

    public FilmeController() {
        this.filmes = daos.listarFilmes();
    }

    // Criar
    public void incluirFilme(Filme filme) {
        daos.adicionarFilme(filme);
    }

    // Listar filmes
    public List<Filme> listarFilmes() {
        return daos.listarFilmes();
    }

    // Atualizar
    public String atualizarFilme(int id, String nome, Categoria categoria, String diretor, int anoLancamento) {
        try {
            Filme filme = new Filme(id, nome, diretor, anoLancamento, categoria);
            filmes.add(filme);
            daos.atualizarFilme(filme);
            return "Filme Atualizado com sucesso!";

        } catch (IllegalArgumentException e) {
            return "Gênero inválido: " + e;
        }
    }

    // Deletar
    public String deletarFilme(int id) {
        boolean deletado = daos.deletarFilme(id);
        if (deletado) {
            return "Filme deletado com sucesso";
        } else {
            return "Código não encontrado: " + id;
        }
    }
}
