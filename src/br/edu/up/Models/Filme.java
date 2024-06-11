package br.edu.up.Models;

public class Filme extends Locadora{
    // @athor João: foi craida a model como classe mais baixam da Biblioteca.

    public String diretor;

    public int anoLancamento;


    public Filme(String id, String nome, String genero, String diretor, int anoLancamento) {
       super(id,nome,genero);
        this.diretor = diretor;
        this.anoLancamento = anoLancamento;
    }



    public String getDiretor() {
        return diretor;
    }


    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }


    public int getAnoLancamento() {
        return anoLancamento;
    }


    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }


    @Override
    public String toString() {
        return "Filme{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", diretor='" + diretor + '\'' +
                ", anoLancamento=" + anoLancamento +
                '}';
    }

    public String toCsv(){
        return id + "," + nome + "," + genero + "," + diretor + "," + anoLancamento;
    }
    
}
