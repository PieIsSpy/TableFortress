package java.com.pieisspy.tablefortress.model.pieces;

import java.com.pieisspy.tablefortress.model.components.Position;
import java.com.pieisspy.tablefortress.model.components.Stats;

public class Brute extends Piece{
    public Brute (int r, int c) {
        super(new Stats(10, 8, 1, 6, 2, 1), new Position(r, c));
    }
}