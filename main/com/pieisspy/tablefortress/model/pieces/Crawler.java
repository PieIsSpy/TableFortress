package main.com.pieisspy.tablefortress.model.pieces;

import main.com.pieisspy.tablefortress.model.components.Cooldown;
import main.com.pieisspy.tablefortress.model.components.Position;
import main.com.pieisspy.tablefortress.model.components.Range;
import main.com.pieisspy.tablefortress.model.components.Stats;
import main.com.pieisspy.tablefortress.model.enumerators.PieceType;
import main.com.pieisspy.tablefortress.model.enumerators.RangeType;

public class Crawler extends Piece{
    public Crawler (Position pos) {
        super(new Stats(5, 3, 2), new Cooldown(0), pos);
        setType(PieceType.Crawler);
        setAttackRange(new Range(RangeType.Linear, 1));
        setMovementRange(new Range(RangeType.Linear, 6));
    }
}