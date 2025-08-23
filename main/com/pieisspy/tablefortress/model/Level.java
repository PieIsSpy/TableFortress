package main.com.pieisspy.tablefortress.model;

public class Level {
    public Level(int l) {
        LEVEL = l;
        board = new Board(10,10);
    }

    private final int LEVEL;
    private final Board board;
}
