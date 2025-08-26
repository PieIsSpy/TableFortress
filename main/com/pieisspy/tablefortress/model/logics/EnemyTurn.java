package main.com.pieisspy.tablefortress.model.logics;

import main.com.pieisspy.tablefortress.model.enumerators.Moves;
import main.com.pieisspy.tablefortress.model.levelhandler.Board;
import main.com.pieisspy.tablefortress.model.components.Position;
import main.com.pieisspy.tablefortress.model.pieces.Piece;
import main.com.pieisspy.tablefortress.model.pieces.Volatile;

public class EnemyTurn extends PlayerTurn{
    public Moves enemyDecision(Board b, Piece p) {
        RangeChecker rangeChecker = new RangeChecker();
        Piece nearestEnemy = seekNearestEnemy(b, p);
        double x = Math.random();
        Position random;

        // if the piece can find a nearby piece and rng gods allows them to beat up shit
        if (nearestEnemy != null && x > .5f) {
            attackMove(p, nearestEnemy);
            return Moves.Attack;
        }
        // else, move randomly
        else {
            do {
                random = randomizePosition(b.getRows(), b.getCols());
            } while (!b.isEmptyTile(random));

            positionMove(b, p, random);
            return Moves.Move;
        }
    }

    /*
        for finding out which piece is in the attack area
     */
    public Piece seekNearestEnemy(Board b, Piece p) {
        return null;
    }

    public Position randomizePosition(int maxRows, int maxCols) {
        int row = (int)(Math.floor(Math.random() * maxRows));
        int col = (int)(Math.floor(Math.random() * maxCols));

        return new Position(row, col);
    }
}
