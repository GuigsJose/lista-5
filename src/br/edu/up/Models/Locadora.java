package br.edu.up.Models;

public class Locadora {
    public String id;
    public String nome;
    public String genero;

    public Locadora(String id, String nome, String genero) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
public String toString() {
    return "Locadora{" +
            "id='" + id + '\'' +
            ", nome='" + nome + '\'' +
            ", genero='" + genero + '\'' +
            '}';
}
}
