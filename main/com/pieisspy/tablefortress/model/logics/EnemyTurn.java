package main.com.pieisspy.tablefortress.model.logics;

import main.com.pieisspy.tablefortress.model.levelhandler.Board;
import main.com.pieisspy.tablefortress.model.components.Position;
import main.com.pieisspy.tablefortress.model.pieces.Piece;

public class EnemyTurn extends PlayerTurn{
    public void enemyDecision(Board b, Piece p, Position pos) {
        if (p.getStats().getHealth() > (p.getStats().getMaxHealth() / 2)) {

        }
    }

    public Piece seakNearestTeam(Board b, Piece p) {
        Piece nearestPiece = null;
        int nearestDistance;

        return nearestPiece;
    }

    public Piece seekNearestEnemy(Board b, Piece p) {

    }
}
