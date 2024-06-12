package br.edu.up.Models.Enums;

public enum TipoCliente {
    FISICA("Fisica"),
    JURIDICA("Juridica");

    private String descricao;

    private TipoCliente(String descr) {
        this.descricao = descr;
    }

    public String getTipoCliente() {
        return descricao;
    }
}
