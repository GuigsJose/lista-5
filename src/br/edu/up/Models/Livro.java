package br.edu.up.Models;

public class Livro{
// /* @athor João: precisa encaixar a Livro para fazer parte de bilbioteca.
// utilizar ID em vez de código e genero em vez de categoria ( abrange mais
// coisas do que apenas livros)
// - obs: não alterei para não fazer cagada, mas ser quiser eu altero. CMO
// ELMS*/

    public String codigo;
    public String titulo;
    public String isbn;
    public int ano;
    public String categoria;

    public Livro(String codigo,String titulo, String isbn, int ano, String categoria){
        this.codigo = codigo;
        this.titulo = titulo;
        this.isbn = isbn;
        this.ano = ano;
        this.categoria = categoria;
    }

@Override
public String toString() {
return "Livro [codigo=" + codigo + ", titulo=" + titulo + ", isbn=" + isbn +
", ano=" + ano + ", categoria="
+ categoria + "]";
}



public String getCodigo() {
return codigo;
}

public void setCodigo(String codigo) {
this.codigo = codigo;
}

    public String toCsv(){
        return  codigo +";"+ titulo+";" +isbn+";"+ ano+";"+ categoria;
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



    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    
    
}
