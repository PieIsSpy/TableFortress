package main.com.pieisspy.tablefortress.model.logics;

import main.com.pieisspy.tablefortress.model.Board;
import main.com.pieisspy.tablefortress.model.components.Position;
import main.com.pieisspy.tablefortress.model.pieces.Piece;

public class PlayerTurn {
    public void attackMove(Board b, Piece p, Position pos) {
        b.getTiles()[pos.getRow()][pos.getCol()].takeDamage(p.getStats().getAttackDamage());
    }

    public void positionMove(Board b, Piece p, Position pos) {
        int oldRow = p.getPosition().getRow();
        int oldCol = p.getPosition().getCol();

        int newRow = pos.getRow();
        int newCol = pos.getCol();

        b.getTiles()[oldRow][oldCol] = null;
        p.setPosition(pos);
        b.getTiles()[newRow][newCol] = p;
    }
}