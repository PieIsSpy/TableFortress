package main.com.pieisspy.tablefortress.model.pieces;

import main.com.pieisspy.tablefortress.model.components.Cooldown;
import main.com.pieisspy.tablefortress.model.components.Position;
import main.com.pieisspy.tablefortress.model.components.Range;
import main.com.pieisspy.tablefortress.model.components.Stats;
import main.com.pieisspy.tablefortress.model.enumerators.PieceType;
import main.com.pieisspy.tablefortress.model.enumerators.RangeType;

public class Heavy extends Piece{
    public Heavy (Position pos) {
        super(new Stats(9, 7,6), new Cooldown(1), pos);
        setType(PieceType.Heavy);
        setAttackRange(new Range(RangeType.Square, 1));
        setMovementRange(new Range(RangeType.Manhattan, 2));
    }
}