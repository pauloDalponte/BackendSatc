package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(OscarConfiguration.class);
        OscarService oscarService = context.getBean(OscarService.class);

        Indicavel indicado = new Ator("Paulo Cesar","Brasileiro",false);

        Indicacao indicacao = new Indicacao(indicado,"teste");

        oscarService.adicionarIndicacao(indicacao);

        oscarService.mostrarListaIndicados();
    }
}