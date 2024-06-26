package br.edu.up.Models;

import br.edu.up.Models.Enums.TipoCargo;

public class Funcionario extends Pessoa {
    int Codigo;
    TipoCargo Cargo;

    public Funcionario(String documento, String nome, int idade, String endereco, TipoCargo cargo, int codigo) {
        super(documento, nome, idade, endereco);
        Cargo = cargo;
        Codigo = codigo;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        Codigo = codigo;
    }

    public TipoCargo getCargo() {
        return Cargo;
    }

    public void setCargo(TipoCargo cargo) {
        Cargo = cargo;
    }

    public String toCsv() {
        return Codigo + "," + Nome + "," + Documento + "," + Idade + "," + Cargo + "," + Endereco;
    }

}