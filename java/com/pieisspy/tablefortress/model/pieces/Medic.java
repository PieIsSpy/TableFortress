package java.com.pieisspy.tablefortress.model.pieces;

import java.com.pieisspy.tablefortress.model.components.Cooldown;
import java.com.pieisspy.tablefortress.model.components.Position;
import java.com.pieisspy.tablefortress.model.components.Stats;

public class Medic extends Piece{
    public Medic (int r, int c) {
        super(new Stats(5, 0, 1, 4, 3), new Cooldown(1), new Position(r, c));
    }
}