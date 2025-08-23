package main.com.pieisspy.tablefortress.model.pieces;

import main.com.pieisspy.tablefortress.model.components.Cooldown;
import main.com.pieisspy.tablefortress.model.components.Position;
import main.com.pieisspy.tablefortress.model.components.Stats;
import main.com.pieisspy.tablefortress.model.enumerators.PieceType;

public class Soldier extends Piece{
    public Soldier (Position pos) {
        super(new Stats(6, 5, 3, 3, 5), new Cooldown(1), pos);
        setType(PieceType.Soldier);
    }
}