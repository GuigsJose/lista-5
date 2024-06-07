package br.edu.up.Models;

public class Jogo extends Biblioteca {
    
    public String gereno;
    public int ano;

    public Jogo(String id, String nome, String gereno, int ano) {
        super(id, nome);
        this.gereno = gereno;
        this.ano = ano;
    }

}
