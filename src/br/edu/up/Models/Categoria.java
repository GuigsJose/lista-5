package br.edu.up.Models;

public enum Categoria {
    FICCAO("Ficção"),
    RELIGIOSOS("Religiosos"),
    CONTOS("Contos"),
    ROMANCES("Romances"),
    DIDATICOS("Didáticos"),
    INFANTIS("Infantis"),
    QUADRINHOS("Quadrinhos"),
    POESIA("Poesia"),
    BIOGRAFIA("Biografia"),
    FANTASIA("Fantasia"),
    TECNOLOGIA("Técnologia");

    private String descricao;

    Categoria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
