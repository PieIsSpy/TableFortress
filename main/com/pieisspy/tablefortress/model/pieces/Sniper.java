package main.com.pieisspy.tablefortress.model.pieces;

import main.com.pieisspy.tablefortress.model.components.Cooldown;
import main.com.pieisspy.tablefortress.model.components.Position;
import main.com.pieisspy.tablefortress.model.components.Range;
import main.com.pieisspy.tablefortress.model.components.Stats;
import main.com.pieisspy.tablefortress.model.enumerators.PieceType;
import main.com.pieisspy.tablefortress.model.enumerators.RangeType;

public class Sniper extends Piece{
    public Sniper (Position pos) {
        super(new Stats(3, 8, 5), new Cooldown(2), pos);
        setType(PieceType.Sniper);
        setAttackRange(new Range(RangeType.Linear, 6));
        setMovementRange(new Range(RangeType.Manhattan, 2));
    }
}