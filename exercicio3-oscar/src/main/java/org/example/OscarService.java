package org.example;

import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class OscarService {
    ArrayList<Indicacao> indicacoes = new ArrayList<Indicacao>();

    public void adicionarIndicacao(Indicacao indicacao){
        indicacoes.add(indicacao);
    }

    public void  mostrarListaIndicados(){
        for (Indicacao indicacao : indicacoes) {
            Indicavel indicavel = indicacao.getIndicavel();
            String textinho = " foi indicado para o oscar de " + indicacao.getCategoria() + ".";

            String mensagem = (indicacao.getIndicavel() instanceof Ator) ? ("O ator " + ((Ator) indicavel).getNome()) : ("O filme " + ((Filme) indicavel).getNome()) + textinho;
            System.out.println(mensagem);

        }
    }
}
