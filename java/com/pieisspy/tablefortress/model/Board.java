package java.com.pieisspy.tablefortress.model;

import java.com.pieisspy.tablefortress.model.pieces.Piece;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Board {
    public Board(int r, int c) {
        TILES = new Piece[r][c];
        ROWS = r;
        COLS = c;
        PLAYER_PIECES = new ArrayList<>();
        ENEMY_PIECES = new ArrayList<>();
        COOLDOWN_HOLDER = PriorityQueue((Integer ));
        TURNS = new LinkedList<>();
    }

    public Piece[][] getTiles() {
        return TILES;
    }

    public int getRows() {
        return ROWS;
    }

    public int getCols() {
        return COLS;
    }

    private final Piece[][] TILES;
    private final ArrayList<Piece> PLAYER_PIECES;
    private final ArrayList<Piece> ENEMY_PIECES;
    private final PriorityQueue<Piece> COOLDOWN_HOLDER;
    private final Queue<Piece> TURNS;
    private final int ROWS;
    private final int COLS;
}
