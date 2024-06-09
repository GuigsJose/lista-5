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
    public void incluirJogo(String id, String nome, String genero, int ano) {
        Jogo jogo = new Jogo(id, nome, genero, ano);
        jogos.add(jogo);
        daos.adicionarJogos(jogos);
    }

    // Listar jogos
    public List<Jogo> listarJogos() {
        return daos.listarJogos();
    }

    // atualizar
    public void atualizarJogo(String id, String nome, String genero, int ano) {
        try{    
            Jogo novoJogo = new Jogo(id, nome, genero, ano);
            boolean atualizado = daos.atualizarJogo(novoJogo);
            if (atualizado) {
                // [bizu] coloquei um sysout pra verificação
                System.out.println("Livro Atualizado com sucesso!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Jogo não atualizado");
        }
    }

    // delete
    public void deletarJogo(String id) {
        boolean deletado = daos.deletarJogo(id);
        if (deletado) {
            System.out.println("Livro deletado com sucesso");
        } else {
            System.out.println("Código não encontrado: " + id);
        }
    }

}
