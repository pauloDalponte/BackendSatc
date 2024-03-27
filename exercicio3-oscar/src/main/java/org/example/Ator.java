package org.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Ator implements Indicavel {
    private String nome;
    private String nacionalidade;
    private boolean elegivel;
    private short numeroDeIndicacoes = 0;

    public Ator(String nome, String nacionalidade, boolean b) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.elegivel =elegivel();
    }
    @Override
    public boolean elegivel() {
        return false;
    }

    @Override
    public short numeroDeIndicacoes() {
        return 0;
    }
    @Override
    public void setNumeroDeIndicacoes(short numeroDeIndicacoes) {
        this.numeroDeIndicacoes = numeroDeIndicacoes;
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
