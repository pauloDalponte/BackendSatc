import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws Exception {
        String textNames = returnTextServer("https://venson.net.br/resources/data/nomes.txt");
        String name = returnRandomNumber(textNames);

        String textSurname = returnTextServer("https://venson.net.br/resources/data/sobrenomes.txt");
        String surname = returnRandomNumber(textSurname);

        String textposition = returnTextServer("https://venson.net.br/resources/data/posicoes.txt");
        String position = returnRandomNumber(textposition);
        position = position.replace(",", "");
        position = position.replace("\"","");

        String textClub = returnTextServer("https://venson.net.br/resources/data/clubes.txt");
        String club = returnRandomNumber(textClub);

        short age = genereteRandomNumber(17,41);

        System.out.println(name
                +" "
                + surname
                + " é um(a) futebolista brasileiro(a) de "
                + age
                + " anos que atua como "
                + position
                + ". Atualmento defende o "
                + club
                + "."
        );
    }

    public static String returnTextServer(String url) throws Exception {
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

    public static String returnRandomNumber(String texto) {
        // Divide a variavel em varias strings (uma pra cada nome)
        String[] listaDeNomes = texto.split("\n");
        // Cria um numero aleatorio de acordo com o vetor
        int indiceAleatorio = (int) Math.floor(Math.random() * listaDeNomes.length);
        // Retorna uma posicao aleatoria da lista 
        return listaDeNomes[indiceAleatorio];
    }

    public static short genereteRandomNumber(int menor, int maior){
        short numeroAleatorio = (short) Math.floor((Math.random() * (maior - menor))+17);
                return numeroAleatorio;
    }
}