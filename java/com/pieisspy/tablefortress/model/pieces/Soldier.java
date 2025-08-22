package java.com.pieisspy.tablefortress.model.pieces;

import java.com.pieisspy.tablefortress.model.components.Cooldown;
import java.com.pieisspy.tablefortress.model.components.Position;
import java.com.pieisspy.tablefortress.model.components.Stats;

public class Soldier extends Piece{
    public Soldier (int r, int c) {
        super(new Stats(6, 5, 3, 3, 5), new Cooldown(1), new Position(r, c));
    }
}