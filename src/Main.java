import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int playersCount = sc.nextInt();
        int difficulty = sc.nextInt();

        List<Player> players = new ArrayList<>();

        for (int i = 0; i < playersCount; i++) {
            players.add(new Player("Player " + (i + 1)));
        }

        Game game = new Game(players, n, difficulty);
        game.start();
    }
}