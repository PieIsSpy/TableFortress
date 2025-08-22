package java.com.pieisspy.tablefortress.model.pieces;

import java.com.pieisspy.tablefortress.model.components.Cooldown;
import java.com.pieisspy.tablefortress.model.components.Position;
import java.com.pieisspy.tablefortress.model.components.Stats;

public class Scout extends Piece{
    public Scout (int r, int c) {
        super(new Stats(3, 2, 1, 1, 6), new Cooldown(0), new Position(r, c));
    }
}