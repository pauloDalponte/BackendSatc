package com.example.demo.services;

import org.springframework.stereotype.Service;


@Service
public class VensonService {

    private static String retornaIndiceAleatorio(String stringao) {
        // Quebrando o texto em varias strings (colocando dentro de um vetor)
        String[] listaDeNomes = stringao.split("\n");
        // gera um numero aleatorio entre 0 e o tamanho do meu vetor - 1
        int indiceAleatorio = (int) Math.floor(Math.random() * listaDeNomes.length);
        return listaDeNomes[indiceAleatorio];
    }
    public String generateMessage(String listaDeNomes, String listaDeSobrenomes, String listaDePosicoes, String listaDeClubes) {
        String nome = retornaIndiceAleatorio(listaDeNomes);
        nome = nome.substring(0, 1) + nome.substring(1).toLowerCase();

        String[] nomes = (nome).split("\\s+");

        StringBuilder nomesCapitalizados = new StringBuilder();
        for (String palavra : nomes) {
            nomesCapitalizados.append(Character.toUpperCase(palavra.charAt(0))).append(palavra.substring(1).toLowerCase()).append(" ");
        }
        nome = nomesCapitalizados.toString().trim();

        String sobrenome = retornaIndiceAleatorio(listaDeSobrenomes);
        sobrenome = Character.toUpperCase(sobrenome.charAt(0)) + sobrenome.substring(1).toLowerCase();

        String posicao = retornaIndiceAleatorio(listaDePosicoes).replaceAll("[^a-zA-Z\\s-]", "");

        String clube = retornaIndiceAleatorio(listaDeClubes);

        int idade = (int) Math.floor(Math.random() * 24) + 17;

        return (
                nome
                +' ' + sobrenome
                +" é um futebolista brasileiro de " + idade + " anos que atua como "
                + posicao
                + ". Atualmente defende o "
                + clube + '.');
    }
}
