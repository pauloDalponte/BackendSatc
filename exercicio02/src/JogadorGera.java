import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class JogadorGera {
    private final String listaDeNomes = retornaListaDaURI("https://venson.net.br/resources/data/nomes.txt");

    private final String listaDeSobrenomes = retornaListaDaURI("https://venson.net.br/resources/data/sobrenomes.txt");

    private final String listaDePosicoes = retornaListaDaURI("https://venson.net.br/resources/data/posicoes.txt");

    private final String listaDeClubes = retornaListaDaURI("https://venson.net.br/resources/data/clubes.txt");

    public JogadorGera() throws Exception {
    }

    private static String retornaListaDaURI(String minhaUri) throws Exception{
        // Puxando o arquivo de texto usando HTTP
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(minhaUri)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    private static String retornaIndiceAleatorio(String stringao) {
        // Quebrando o texto em varias strings (colocando dentro de um vetor)
        String[] listaDeNomes = stringao.split("\n");
        // gera um numero aleatorio entre 0 e o tamanho do meu vetor - 1
        int indiceAleatorio = (int) Math.floor(Math.random() * listaDeNomes.length);
        return listaDeNomes[indiceAleatorio];
    }

    public ArrayList<Jogador> GerarJogadores(){
        ArrayList<Jogador> listaJogadores = new ArrayList<Jogador>();
        for(int i = 0; i < 11; i++){
            String nome = retornaIndiceAleatorio(this.listaDeNomes);
            nome = nome.substring(0, 1) + nome.substring(1).toLowerCase();

            String[] nomes = (nome).split("\\s+");

            StringBuilder nomesCapitalizados = new StringBuilder();
            for (String palavra : nomes) {
                nomesCapitalizados.append(Character.toUpperCase(palavra.charAt(0))).append(palavra.substring(1).toLowerCase()).append(" ");
            }
            nome = nomesCapitalizados.toString().trim();

            String sobrenome = retornaIndiceAleatorio(this.listaDeSobrenomes);
            sobrenome = Character.toUpperCase(sobrenome.charAt(0)) + sobrenome.substring(1).toLowerCase();

            String posicao = retornaIndiceAleatorio(this.listaDePosicoes).replaceAll("[^a-zA-Z\\s-]", "");

            String clube = retornaIndiceAleatorio(this.listaDeClubes);

            int idade = (int) Math.floor(Math.random() * 24) + 17;

            Jogador jogador = new Jogador(
                    nome=nome,
                    sobrenome=sobrenome,
                    posicao=posicao,
                    idade=idade,
                    clube=clube
            );
            listaJogadores.add(jogador);
        }
        return listaJogadores;
    }

}