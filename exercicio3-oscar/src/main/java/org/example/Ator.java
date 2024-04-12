package org.example;

public class Ator implements Indicavel {
    private String nome;
    private String nacionalidade;
    private boolean elegivel;

    public Ator(String nome,String nacionalidade,boolean elegivel){
        this.nome =nome;
        this.nacionalidade = nacionalidade;
        this.elegivel = elegivel;
    }

    @Override
public boolean elegivel() {
    return elegivel;
}

    @Override
    public short numeroDeIndicacoes() {
        return 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
}
