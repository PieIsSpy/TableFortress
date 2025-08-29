package main.com.pieisspy.tablefortress.model.pieces;

import main.com.pieisspy.tablefortress.model.components.Cooldown;
import main.com.pieisspy.tablefortress.model.components.Position;
import main.com.pieisspy.tablefortress.model.components.Range;
import main.com.pieisspy.tablefortress.model.components.Stats;
import main.com.pieisspy.tablefortress.model.enumerators.PieceType;
import main.com.pieisspy.tablefortress.model.enumerators.RangeType;

public class Spawn extends Piece{
    public Spawn (Position pos) {
        super(new Stats(2, 4,2), new Cooldown(0), pos);
        setType(PieceType.Spawn);
        setAttackRange(new Range(RangeType.Manhattan, 1));
        setMovementRange(new Range(RangeType.Manhattan, 2));
    }
}