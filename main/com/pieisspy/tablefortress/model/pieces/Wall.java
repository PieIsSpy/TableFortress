package main.com.pieisspy.tablefortress.model.pieces;

import main.com.pieisspy.tablefortress.model.components.Position;
import main.com.pieisspy.tablefortress.model.enumerators.PieceType;

public class Wall extends Piece{
    public Wall (Position pos) {
        super(null,null, pos);
        setType(PieceType.Wall);
    }
}
