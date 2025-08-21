package java.com.pieisspy.tablefortress.model;

import java.com.pieisspy.tablefortress.model.pieces.Piece;

public class Board {
    public Board(int r, int c) {
        TILES = new Piece[r][c];
        ROWS = r;
        COLS = c;
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
    private final int ROWS;
    private final int COLS;
}
