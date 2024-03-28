package org.example;

public class Filme implements Indicavel{
    private String nome;
    private String genero;
    private boolean elegivel;


    public Filme (String nome,String genero,boolean elegivel) {
        this.nome = nome;
        this.genero = genero;
        this.elegivel = elegivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public boolean elegivel() {
        return false;
    }

    @Override
    public short numeroDeIndicacoes() {
        return 0;
    }

}
