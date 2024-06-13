package br.edu.up.Models;

import br.edu.up.Models.Enums.TipoCliente;

public class Cliente extends Pessoa {
    int Codigo;
    TipoCliente Tipo;

    public Cliente(String documento, String nome, int idade, String endereco, TipoCliente tipoCliente, int codigo) {
        super(documento, nome, idade, endereco);
        Tipo = tipoCliente;
        Codigo = codigo;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        Codigo = codigo;
    }

    public TipoCliente getTipo() {
        return Tipo;
    }

    public void setTipo(TipoCliente tipo) {
        Tipo = tipo;
    }

    public String toCsv() {
        return Codigo + "," + Nome + "," + Documento + "," + Idade + "," + Tipo + "," + Endereco;
    }

}
