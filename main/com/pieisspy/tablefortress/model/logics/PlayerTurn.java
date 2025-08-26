package main.com.pieisspy.tablefortress.model.logics;

import main.com.pieisspy.tablefortress.model.levelhandler.Board;
import main.com.pieisspy.tablefortress.model.components.Position;
import main.com.pieisspy.tablefortress.model.pieces.Piece;

public class PlayerTurn {
    public void attackMove(Piece piece, Piece target) {
        target.takeDamage(piece.getStats().getAttackDamage());
        piece.getCooldown().setCounter(piece.getCooldown().getCooldown());
    }

    public void healMove(Piece piece, Piece target) {
        target.healHealth(piece.getStats().getAttackDamage());
        piece.getCooldown().setCounter(piece.getCooldown().getCooldown());
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