package org.example;

import org.springframework.stereotype.Component;

@Component
public interface Indicavel {
    boolean elegivel();
    short numeroDeIndicacoes();
    void setNumeroDeIndicacoes(short numeroDeIndicacoes);
}
