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
}
