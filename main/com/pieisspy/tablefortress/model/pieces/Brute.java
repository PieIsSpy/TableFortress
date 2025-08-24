package main.com.pieisspy.tablefortress.model.pieces;

import main.com.pieisspy.tablefortress.model.components.Cooldown;
import main.com.pieisspy.tablefortress.model.components.Position;
import main.com.pieisspy.tablefortress.model.components.Stats;
import main.com.pieisspy.tablefortress.model.enumerators.PieceType;
import main.com.pieisspy.tablefortress.model.enumerators.RangeType;

public class Brute extends Piece {
    public Brute (Position pos) {
        super(new Stats(10, 8, 1, 6, 2), new Cooldown(1), pos);
        setType(PieceType.Brute);
        setAttackRangeType(RangeType.Square);
        setMovementRangeType(RangeType.Manhattan);
    }
}