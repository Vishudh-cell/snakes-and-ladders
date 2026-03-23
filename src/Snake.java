public class Snake implements Jump {
    private int head;
    private int tail;

    public Snake(int head, int tail) {
        this.head = head;
        this.tail = tail;
    }

    public int getStart() { return head; }
    public int getEnd() { return tail; }
}