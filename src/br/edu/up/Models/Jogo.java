package br.edu.up.Models;

import br.edu.up.Models.Enums.Categoria;

public class Jogo {
    // @athor Luis: foi craida a model como classe mais baixam da Produto .

    int Codigo;
    String Nome;
    Categoria Categoria;
    int Ano;

    public Jogo(int codigo, String nome, Categoria categoria, int ano) {
        Codigo = codigo;
        Nome = nome;
        Categoria = categoria;
        Ano = ano;
    }

    @Override
    public String toString() {
        return "Jogo [id=" + Codigo + ", gereno=" + Categoria + ", nome=" + Nome + ", ano=" + Ano + "]";
    }

    public String toCsv() {
        return Codigo + "," + Nome + "," + Categoria + "," + Ano;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        Codigo = codigo;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Categoria getCategoria() {
        return Categoria;
    }

    public void setCategoria(Categoria categoria) {
        Categoria = categoria;
    }

    public int getAno() {
        return Ano;
    }

    public void setAno(int ano) {
        Ano = ano;
    }

}
