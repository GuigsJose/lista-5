package br.edu.up.Models.Enums;

public enum Categoria {
    FICCAO("Ficção"),
    RELIGIOSOS("Religioso"),
    CONTOS("Contos"),
    ROMANCES("Romances"),
    DIDATICOS("Didáticos"),
    INFANTIS("Infantis"),
    QUADRINHOS("Quadrinhos"),
    POESIA("Poesias"),
    BIOGRAFIA("Biografia"),
    FANTASIA("Fantasia"),
    TECNOLOGIA("Técnologia"),
    ACAO("ACAO"),
    ACAO_E_AVENTURA("ACAO E AVENTURA"),
    RPG("RPG"),
    SIMULACAO("SIMULACAO"),
    PUZZLE_E_PARTY_GAMES("PUZZLE E PARTY GAMES"),
    ESPORTES("ESPORTES"),
    ESTRATEGIA("ESTRATEGIA");

    private String descricao;

    private Categoria(String cate) {
        this.descricao = cate;
    }

    public String getCategoria() {
        return this.descricao;
    }
}
