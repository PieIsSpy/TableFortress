package java.com.pieisspy.tablefortress.model.pieces;

import java.com.pieisspy.tablefortress.model.components.Position;
import java.com.pieisspy.tablefortress.model.components.Stats;

public class Heavy extends Piece{
    public Heavy (int r, int c) {
        super(new Stats(9, 7, 1, 6, 2, 1), new Position(r, c));
    }
}