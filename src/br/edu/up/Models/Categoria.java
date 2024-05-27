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
    //básicamente converte uma descrição que é uma String, no enum correspondente
    public static Categoria descricaoCategoria(String descricao){
        for (Categoria categoria : Categoria.values()) {
            if (categoria.getDescricao().equalsIgnoreCase(descricao)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Categoria não encontrada para Descricao " + descricao);
    }

}
