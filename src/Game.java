import java.util.*;

public class Game {
    private Queue<Player> players;
    private Board board;
    private Dice dice;

    public Game(List<Player> players, int size, int difficulty) {
        this.players = new LinkedList<>(players);
        this.board = new Board(size, difficulty, difficulty);
        this.dice = new Dice();
    }

    public void start() {
        while (players.size() > 1) {
            Player current = players.poll();

            int diceValue = dice.roll();
            int newPos = current.getPosition() + diceValue;

            if (newPos <= board.getSize() * board.getSize()) {
                newPos = board.getNextPosition(newPos);
                current.setPosition(newPos);
            }

            System.out.println(current.getName() + " rolled " + diceValue +
                    " and moved to " + current.getPosition());

            if (current.getPosition() == board.getSize() * board.getSize()) {
                System.out.println(current.getName() + " wins!");
            } else {
                players.offer(current);
            }
        }
    }
}