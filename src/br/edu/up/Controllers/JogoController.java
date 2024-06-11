package br.edu.up.Controllers;

import java.util.List;
import br.edu.up.DAO.JogoDAO;
import br.edu.up.Models.Jogo;

public class JogoController {

    private JogoDAO daos = new JogoDAO();
    private List<Jogo> jogos;

    public JogoController() {
        this.jogos = daos.listarJogos();
    }

    // Criar jogo
    public String adicionar(String id, String nome, String genero, int ano) {
        try{
            Jogo jogo = new Jogo(id, nome, genero, ano);
            jogos.add(jogo);
            daos.adicionarJogos(jogos);
            return "Jogo adicionado com sucesso!";
        } catch (IllegalArgumentException e){
            return "Jogo não adicionado " + e;
        }
    }

    // Listar jogos
    public List<Jogo> listarJogos() {
        return daos.listarJogos();
    }

    // atualizar
    public String atualizarJogo(String id, String nome, String genero, int ano) {
        try {
            Jogo novoJogo = new Jogo(id, nome, genero, ano);
            daos.atualizarJogo(novoJogo);
            return "Livro Atualizado com sucesso!";

        } catch (IllegalArgumentException e) {
            return "Jogo não atualizado" + e;
        }

    }

    // delete
    public String deletarJogo(String id) {
        boolean deletado = daos.deletarJogo(id);
        if (deletado) {
            return "Livro deletado com sucesso";
        } else {
            return "Código não encontrado: " + id;
        }
    }

}
