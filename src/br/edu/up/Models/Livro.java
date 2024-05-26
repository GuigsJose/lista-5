package br.edu.up.Models;

public class Livro{
    public String codigo;
    public String titulo;
    public String isbn;
    public int ano;
    public Categoria categoria;

    public Livro(String codigo,String titulo, String isbn, int ano, Categoria categoria){
        this.codigo = codigo;
        this.titulo = titulo;
        this.isbn = isbn;
        this.ano = ano;
        this.categoria = categoria;
    }

    

    @Override
    public String toString() {
        return "Livro [codigo=" + codigo + ", titulo=" + titulo + ", isbn=" + isbn + ", ano=" + ano + ", categoria="
                + categoria + "]";
    }



    public String toCsv(){
        return  codigo +";"+ titulo+";" +isbn+";"+ ano+";"+ categoria.getDescricao();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
    
}