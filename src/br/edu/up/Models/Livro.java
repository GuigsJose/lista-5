package br.edu.up.Models;

import br.edu.up.Models.Enums.Categoria;

public class Livro {
    int Codigo;
    String Titulo;
    String Isbn;
    int Ano;
    Categoria Genero;

    public Livro(int codigo, String titulo, String isbn, int ano, Categoria genero) {
        this.Codigo = codigo;
        this.Titulo = titulo;
        this.Isbn = isbn;
        this.Ano = ano;
        this.Genero = genero;
    }

    @Override
    public String toString() {
        return "Livro [codigo=" + Codigo + ", titulo=" + Titulo + ", isbn=" + Isbn +
                ", ano=" + Ano + ", genero="
                + Genero + "]";
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        this.Codigo = codigo;
    }

    public String toCsv() {
        return Codigo + ";" + Titulo + ";" + Isbn + ";" + Ano + ";" + Genero;
    }

    public void setTitulo(String titulo) {
        this.Titulo = titulo;
    }

    public String getIsbn() {
        return Isbn;
    }

    public void setIsbn(String isbn) {
        this.Isbn = isbn;
    }

    public int getAno() {
        return Ano;
    }

    public void setAno(int ano) {
        this.Ano = ano;
    }

    public Categoria getGenero() {
        return Genero;
    }

    public void setCategoria(Categoria categoria) {
        this.Genero = categoria;
    }

}
