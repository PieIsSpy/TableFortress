package main.com.pieisspy.tablefortress.model.pieces;

import main.com.pieisspy.tablefortress.model.components.Cooldown;
import main.com.pieisspy.tablefortress.model.components.Position;
import main.com.pieisspy.tablefortress.model.components.Stats;
import main.com.pieisspy.tablefortress.model.enumerators.PieceType;
import main.com.pieisspy.tablefortress.model.enumerators.RangeType;

public class Scout extends Piece{
    public Scout (Position pos) {
        super(new Stats(3, 2, 1, 1, 6), new Cooldown(0), pos);
        setType(PieceType.Scout);
        setAttackRangeType(RangeType.Manhattan);
        setMovementRangeType(RangeType.Manhattan);
    }
}