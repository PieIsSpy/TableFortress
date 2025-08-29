package main.com.pieisspy.tablefortress.model.pieces;

import main.com.pieisspy.tablefortress.model.components.Cooldown;
import main.com.pieisspy.tablefortress.model.components.Position;
import main.com.pieisspy.tablefortress.model.components.Range;
import main.com.pieisspy.tablefortress.model.components.Stats;
import main.com.pieisspy.tablefortress.model.enumerators.PieceType;
import main.com.pieisspy.tablefortress.model.enumerators.RangeType;

public class Soldier extends Piece{
    public Soldier (Position pos) {
        super(new Stats(6, 5, 3), new Cooldown(1), pos);
        setType(PieceType.Soldier);
        setAttackRange(new Range(RangeType.Manhattan, 3));
        setMovementRange(new Range(RangeType.Manhattan, 5));
    }
}