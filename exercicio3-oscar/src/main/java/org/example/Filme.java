package org.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Filme implements Indicavel{
    private String nome;
    private String genero;
    private boolean elegivel;
    private short numeroDeIndicacoes;


    @Override
    public void setNumeroDeIndicacoes(short numeroDeIndicacoes) {
        this.numeroDeIndicacoes = numeroDeIndicacoes;
    }

    @Override
    public boolean elegivel() {
        return false;
    }

    @Override
    public short numeroDeIndicacoes() {
        return 0;
    }

    public Filme (String nome,String genero){
        this.nome = nome;
        this.genero = genero;
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
}
