package java.com.pieisspy.tablefortress.model.pieces;

import java.com.pieisspy.tablefortress.model.components.Position;
import java.com.pieisspy.tablefortress.model.components.Stats;

public class Volatile extends Piece{
    public Volatile (int r, int c) {
        super(new Stats(3, 9, 1, 4, 2, 2), new Position(r, c));
    }
}