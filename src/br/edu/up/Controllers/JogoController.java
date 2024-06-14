package br.edu.up.Controllers;

import java.util.ArrayList;
import java.util.List;
import br.edu.up.DAO.JogoDAO;
import br.edu.up.Models.Jogo;
import br.edu.up.Models.Enums.Categoria;

public class JogoController {

    private JogoDAO daos = new JogoDAO();
    private List<Jogo> jogos = new ArrayList<Jogo>();

    public JogoController() {
        this.jogos = daos.listarJogos();
    }

    // Criar jogo
    public void adicionarJogo(Jogo jogo) {
        // try {
        //     Jogo jogo = new Jogo(id, nome, categoria, ano);
        //     jogos.add(jogo);
        //     daos.adicionarJogos(jogos);
        //     return "Jogo adicionado com sucesso!";
        // } catch (IllegalArgumentException e) {
        //     return "Jogo não adicionado " + e;
        // }
        daos.adicionarJogos(jogos);
    }

    // Listar jogos
    public List<Jogo> listarJogos() {
        return daos.listarJogos();
    }

    // atualizar
    public String atualizarJogo(int id, String nome, Categoria categoria, int ano) {
        try {
            Jogo novoJogo = new Jogo(id, nome, categoria, ano);
            daos.atualizarJogo(novoJogo);
            return "Livro Atualizado com sucesso!";

        } catch (IllegalArgumentException e) {
            return "Jogo não atualizado" + e;
        }

    }

    // delete
    public String deletarJogo(int id) {
        boolean deletado = daos.deletarJogo(id);
        if (deletado) {
            return "Livro deletado com sucesso";
        } else {
            return "Código não encontrado: " + id;
        }
    }


    public void salvarDados() {
        daos.gravarJogo(jogos);
    }

}
