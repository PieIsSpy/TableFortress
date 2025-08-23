package main.com.pieisspy.tablefortress.model.pieces;

import main.com.pieisspy.tablefortress.model.components.Cooldown;
import main.com.pieisspy.tablefortress.model.components.Position;
import main.com.pieisspy.tablefortress.model.components.Stats;
import main.com.pieisspy.tablefortress.model.enumerators.PieceType;

public class Sniper extends Piece{
    public Sniper (Position pos) {
        super(new Stats(3, 8, 6, 5, 2), new Cooldown(2), pos);
        setType(PieceType.Sniper);
    }
}