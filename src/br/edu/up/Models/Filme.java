package br.edu.up.Models;

import br.edu.up.Models.Enums.Categoria;

public class Filme {
    // @athor João: foi craida a model como classe mais baixam da Biblioteca.

    int Codigo;
    String Nome;
    String Diretor;
    int AnoLancamento;
    Categoria Genero;

    public Filme(int codigo, String nome, String diretor, int anoLancamento, Categoria genero) {
        Codigo = codigo;
        Nome = nome;
        Diretor = diretor;
        AnoLancamento = anoLancamento;
        Genero = genero;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "id='" + Codigo + '\'' +
                ", nome='" + Nome + '\'' +
                ", genero='" + Genero + '\'' +
                ", diretor='" + Diretor + '\'' +
                ", anoLancamento=" + AnoLancamento +
                '}';
    }

    public String toCsv() {
        return Codigo + "," + Nome + "," + Genero + "," + Diretor + "," + AnoLancamento;
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

    public String getDiretor() {
        return Diretor;
    }

    public void setDiretor(String diretor) {
        Diretor = diretor;
    }

    public int getAnoLancamento() {
        return AnoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        AnoLancamento = anoLancamento;
    }

    public Categoria getGenero() {
        return Genero;
    }

    public void setGenero(Categoria genero) {
        Genero = genero;
    }
}
