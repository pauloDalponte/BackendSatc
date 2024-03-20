import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        JogadorGera gera = new JogadorGera();

        ArrayList<Jogador> jogadores = gera.GerarJogadores();

        System.out.println(jogadores.get((int) Math.floor(Math.random() * 12)).getDescricao());
        System.out.println(jogadores.get((int) Math.floor(Math.random() * 12)).getDescricao());
        System.out.println(jogadores.get((int) Math.floor(Math.random() * 12)).getDescricao());
    }
}