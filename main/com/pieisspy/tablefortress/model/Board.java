package main.com.pieisspy.tablefortress.model;

import main.com.pieisspy.tablefortress.model.comparators.CooldownComparator;
import main.com.pieisspy.tablefortress.model.components.Position;
import main.com.pieisspy.tablefortress.model.pieces.Piece;
import main.com.pieisspy.tablefortress.model.pieces.Wall;

import java.util.*;

public class Board {
    public Board(int r, int c) {
        TILES = new Piece[r][c];
        ROWS = r;
        COLS = c;
        COOLDOWN_HOLDER = new PriorityQueue<>(new CooldownComparator());
        TURNS = new LinkedList<>();
    }

    public Piece[][] getTiles() {
        return TILES;
    }

    public PriorityQueue<Piece> getCooldownHolder() {
        return COOLDOWN_HOLDER;
    }

    public Queue<Piece> getTurns() {
        return TURNS;
    }

    public int getRows() {
        return ROWS;
    }

    public int getCols() {
        return COLS;
    }

    public boolean isValidTile(Position pos) {
        int r = pos.getRow();
        int c = pos.getCol();

        return r >= 0 && r < ROWS && c >= 0 && c < COLS;
    }

    public boolean isEmptyTile(Position pos) {
        int r = pos.getRow();
        int c = pos.getCol();

        return TILES[r][c] == null;
    }

    public boolean isWallTile(Position pos) {
        int r = pos.getRow();
        int c = pos.getCol();

        return TILES[r][c] instanceof Wall;
    }

    public void insertPiece(Piece p) {
        int r = p.getPosition().getRow();
        int c = p.getPosition().getCol();

        TILES[r][c] = p;
        TURNS.add(p);
    }

    private final Piece[][] TILES;
    private final PriorityQueue<Piece> COOLDOWN_HOLDER;
    private final Queue<Piece> TURNS;
    private final int ROWS;
    private final int COLS;
}
