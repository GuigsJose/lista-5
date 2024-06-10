package br.edu.up.Models;

public class Jogo extends Locadora {
    
    public int ano;

    public Jogo(String id, String nome, String genero, int ano) {
        super(id, nome, genero);
        this.ano = ano;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Jogo [id=" + id + ", gereno=" + genero + ", nome=" + nome + ", ano=" + ano + "]";
    }
    
    public String toCsv(){
        return id + "," + nome + "," + genero + "," + ano;
    }

}
