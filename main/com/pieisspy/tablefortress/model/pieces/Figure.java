package main.com.pieisspy.tablefortress.model.pieces;

import main.com.pieisspy.tablefortress.model.components.Cooldown;
import main.com.pieisspy.tablefortress.model.components.Position;
import main.com.pieisspy.tablefortress.model.components.Stats;
import main.com.pieisspy.tablefortress.model.enumerators.PieceType;

public class Figure extends Piece{
    public Figure (Position pos) {
        super(new Stats(6, 5, 3, 3, 4), new Cooldown(1), pos);
        setType(PieceType.Figure);
    }
}