package java.com.pieisspy.tablefortress.model.pieces;

import java.com.pieisspy.tablefortress.model.components.Position;
import java.com.pieisspy.tablefortress.model.components.Stats;

public class Figure extends Piece{
    public Figure (int r, int c) {
        super(new Stats(6, 5, 3, 3, 4, 1), new Position(r, c));
    }
}