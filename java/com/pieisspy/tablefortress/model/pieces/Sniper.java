package java.com.pieisspy.tablefortress.model.pieces;

import java.com.pieisspy.tablefortress.model.components.Position;
import java.com.pieisspy.tablefortress.model.components.Stats;

public class Sniper extends Piece{
    public Sniper (int r, int c) {
        super(new Stats(3, 8, 6, 5, 2, 2), new Position(r, c));
    }
}