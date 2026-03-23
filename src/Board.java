import java.util.*;

public class Board {
    private int size;
    private Map<Integer, Jump> jumps = new HashMap<>();

    public Board(int size, int nSnakes, int nLadders) {
        this.size = size;
        initialize(nSnakes, nLadders);
    }

    private void initialize(int nSnakes, int nLadders) {
        Random rand = new Random();

        for (int i = 0; i < nSnakes; i++) {
            int head = rand.nextInt(size * size - 1) + 2;
            int tail = rand.nextInt(head - 1) + 1;
            jumps.put(head, new Snake(head, tail));
        }

        for (int i = 0; i < nLadders; i++) {
            int start = rand.nextInt(size * size - 1) + 1;
            int end = rand.nextInt(size * size - start) + start + 1;
            jumps.put(start, new Ladder(start, end));
        }
    }

    public int getNextPosition(int position) {
        if (jumps.containsKey(position)) {
            return jumps.get(position).getEnd();
        }
        return position;
    }

    public int getSize() {
        return size;
    }
}