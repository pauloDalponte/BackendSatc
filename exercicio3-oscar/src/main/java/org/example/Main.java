package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
    var context = new AnnotationConfigApplicationContext(OscarConfiguration.class);
    OscarService oscarService = context.getBean(OscarService.class);

    Indicavel indicado = context.getBean(Ator.class,"Paulo", "Brasileiro", true);

    Indicacao indicacao = context.getBean(Indicacao.class, indicado, "O melhor");

    oscarService.adicionarIndicacao(indicacao);

    oscarService.mostrarListaIndicados();
    }
}