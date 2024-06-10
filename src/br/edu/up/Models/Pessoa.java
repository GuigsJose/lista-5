package br.edu.up.Models;

public abstract class Pessoa {
    String Documento;
    String Nome;
    int Idade;
    String Endereco;

    public Pessoa(String documento, String nome, int idade, String endereco) {
        Documento = documento;
        Nome = nome;
        Idade = idade;
        Endereco = endereco;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        Codigo = codigo;
    }

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String documento) {
        Documento = documento;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public int getIdade() {
        return Idade;
    }

    public void setIdade(int idade) {
        Idade = idade;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }
}
