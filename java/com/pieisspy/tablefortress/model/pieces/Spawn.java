package java.com.pieisspy.tablefortress.model.pieces;

import java.com.pieisspy.tablefortress.model.components.Position;
import java.com.pieisspy.tablefortress.model.components.Stats;

public class Spawn extends Piece{
    public Spawn (int r, int c) {
        super(new Stats(2, 4, 3, 2, 2, 0), new Position(r, c));
    }
}