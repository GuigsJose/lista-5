package br.edu.up.Models.Enums;

public enum TipoCargo {
    GERENTE("Gerente"),
    SUBGERENTE("SubGerente"),
    CAIXA("Caixa"),
    ATENDENTE("Atendente");

    private String descricao;

    private TipoCargo(String cargo) {
        this.descricao = cargo;
    }

    public String getDescricao() {
        return this.descricao;
    }
}
