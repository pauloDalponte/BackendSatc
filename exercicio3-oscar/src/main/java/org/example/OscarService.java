
package org.example;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class OscarService {

    private List<Indicacao> indicacoes = new ArrayList<>();

    public void adicionarIndicacao(Indicacao indicacao) {
        indicacoes.add(indicacao);
    }

    public void mostrarListaIndicados() {
        for (Indicacao indicacao : indicacoes) {
            Indicavel indicavel = indicacao.getIndicavel();
            String textinho = " foi indicado para o oscar de " + indicacao.getCategoria()+".";

            String mensagem = (indicacao.getIndicavel() instanceof Ator) ? ("O ator " + ((Ator) indicavel).getNome())+", "+((Ator) indicavel).getNacionalidade()+ textinho : ("O filme " + ((Filme) indicavel).getNome()+ textinho);
            System.out.println(mensagem);

        }
    }
}
