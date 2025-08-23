package main.com.pieisspy.tablefortress.model.pieces;

import main.com.pieisspy.tablefortress.model.components.Cooldown;
import main.com.pieisspy.tablefortress.model.components.Position;
import main.com.pieisspy.tablefortress.model.components.Stats;
import main.com.pieisspy.tablefortress.model.enumerators.PieceType;

public class Crawler extends Piece{
    public Crawler (Position pos) {
        super(new Stats(5, 3, 1, 2, 6), new Cooldown(0), pos);
        setType(PieceType.Crawler);
    }
}