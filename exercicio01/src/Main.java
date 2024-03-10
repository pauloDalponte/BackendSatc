import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws Exception {
        String textNames = retornaTextoDoServidor("https://venson.net.br/resources/data/nomes.txt");
        String name = retornaElementoAleatorio(textNames);

        String textSurname = retornaTextoDoServidor("https://venson.net.br/resources/data/sobrenomes.txt");
        String surname = retornaElementoAleatorio(textSurname);

        String textposition = retornaTextoDoServidor("https://venson.net.br/resources/data/posicoes.txt");
        String position = retornaElementoAleatorio(textposition);
        position = position.replace(",", "");
        position = position.replace("\"","");

        String textClub = retornaTextoDoServidor("https://venson.net.br/resources/data/clubes.txt");
        String club = retornaElementoAleatorio(textClub);

        short age = geraNumeroAleatorio(17,41);

        System.out.println(name
                +" "
                + surname
                + " é um(a) futebolista brasileiro(a) de "
                + age
                + " anos que atua como "
                + position
                + ". Atualmento defende o "
                + club
        );
    }

    public static String retornaTextoDoServidor(String url) throws Exception {
        // Cria um cliente HTTP
        HttpClient cliente = HttpClient.newHttpClient();
        // Cria uma requisicao HTTP
        HttpRequest requisicao = HttpRequest.newBuilder().uri(URI.create(url)).build();
        // Executa a requisicao e recebe uma resposta
        HttpResponse<String> resposta = cliente.send(requisicao, HttpResponse.BodyHandlers.ofString());
        // Cria uma variavel com a lista em texto
        String texto = resposta.body();
        return texto;
    }

    public static String retornaElementoAleatorio(String texto) {
        // Divide a variavel em varias strings (uma pra cada nome)
        String[] listaDeNomes = texto.split("\n");
        // Cria um numero aleatorio de acordo com o vetor
        int indiceAleatorio = (int) Math.floor(Math.random() * listaDeNomes.length);
        // Retorna uma posicao aleatoria da lista 
        return listaDeNomes[indiceAleatorio];
    }

    public static short geraNumeroAleatorio(int menor, int maior){
        short numeroAleatorio = (short) Math.floor((Math.random() * (maior - menor))+17);
                return numeroAleatorio;
    }
}