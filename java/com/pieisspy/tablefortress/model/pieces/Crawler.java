package java.com.pieisspy.tablefortress.model.pieces;

import java.com.pieisspy.tablefortress.model.components.Position;
import java.com.pieisspy.tablefortress.model.components.Stats;

public class Crawler extends Piece{
    public Crawler (int r, int c) {
        super(new Stats(5, 3, 1, 2, 6, 0), new Position(r, c));
    }
}