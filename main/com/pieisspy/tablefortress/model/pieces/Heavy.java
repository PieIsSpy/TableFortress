package main.com.pieisspy.tablefortress.model.pieces;

import main.com.pieisspy.tablefortress.model.components.Cooldown;
import main.com.pieisspy.tablefortress.model.components.Position;
import main.com.pieisspy.tablefortress.model.components.Stats;
import main.com.pieisspy.tablefortress.model.enumerators.PieceType;

public class Heavy extends Piece{
    public Heavy (Position pos) {
        super(new Stats(9, 7, 1, 6, 2), new Cooldown(1), pos);
        setType(PieceType.Heavy);
    }
}