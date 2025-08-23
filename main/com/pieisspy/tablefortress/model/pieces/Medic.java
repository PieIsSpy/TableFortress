package main.com.pieisspy.tablefortress.model.pieces;

import main.com.pieisspy.tablefortress.model.components.Cooldown;
import main.com.pieisspy.tablefortress.model.components.Position;
import main.com.pieisspy.tablefortress.model.components.Stats;
import main.com.pieisspy.tablefortress.model.enumerators.PieceType;

public class Medic extends Piece{
    public Medic (Position pos) {
        super(new Stats(5, 0, 1, 4, 3), new Cooldown(1), pos);
        setType(PieceType.Medic);
    }
}