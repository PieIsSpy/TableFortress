package main.com.pieisspy.tablefortress.model.pieces;

import main.com.pieisspy.tablefortress.model.components.Cooldown;
import main.com.pieisspy.tablefortress.model.components.Position;
import main.com.pieisspy.tablefortress.model.components.Range;
import main.com.pieisspy.tablefortress.model.components.Stats;
import main.com.pieisspy.tablefortress.model.enumerators.PieceType;
import main.com.pieisspy.tablefortress.model.enumerators.RangeType;

public class Brute extends Piece {
    public Brute (Position pos) {
        super(new Stats(10, 8, 6), new Cooldown(5), pos);
        setType(PieceType.Brute);
        setAttackRange(new Range(RangeType.Square, 2));
        setMovementRange(new Range(RangeType.Manhattan, 2));
    }
}