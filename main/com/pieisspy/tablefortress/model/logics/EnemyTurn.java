package main.com.pieisspy.tablefortress.model.logics;

import main.com.pieisspy.tablefortress.model.enumerators.Moves;
import main.com.pieisspy.tablefortress.model.levelhandler.Board;
import main.com.pieisspy.tablefortress.model.components.Position;
import main.com.pieisspy.tablefortress.model.pieces.Piece;

import java.util.ArrayList;

public class EnemyTurn extends PlayerTurn{
    public static Moves enemyDecision(Board b, Piece p) {
        Piece nearestEnemy = seekNearestEnemy(b, p);
        Position random;

        // if the piece can find a nearby piece
        if (nearestEnemy != null && RangeChecker.hybridCheck(p.getPosition(), nearestEnemy.getPosition(), p.getAttackRange())) {
            attackMove(p, nearestEnemy);
            System.out.println(p + " attacked " + nearestEnemy);
            return Moves.Attack;
        }
        // else, move randomly
        else {
            do {
                random = randomizePosition(b.getRows(), b.getCols());
            } while (!b.isEmptyTile(random) || !RangeChecker.hybridCheck(p.getPosition(), random, p.getMovementRange()));

            positionMove(b, p, random);
            System.out.println(p + " moved to " + random);
            return Moves.Move;
        }
    }

    /*
        for finding out which piece is in the attack area
     */
    public static Piece seekNearestEnemy(Board b, Piece p) {
        int nearestDistance = 999;
        Piece nearest = null;
        ArrayList<Piece> cooldowns = b.getCooldownHolder().getHolder();
        ArrayList<Piece> turns = b.getTurns().getHolder();

        for (Piece found : cooldowns) {
            if (p != found && found.getOwner() != p.getOwner()) {
                if (nearestDistance > RangeChecker.manhattanDistance(p.getPosition(), found.getPosition())) {
                    nearest = found;
                    nearestDistance = RangeChecker.manhattanDistance(p.getPosition(), found.getPosition());
                }
            }
        }

        for (Piece found : turns) {
            if (p != found && found.getOwner() != p.getOwner()) {
                if (nearestDistance > RangeChecker.manhattanDistance(p.getPosition(), found.getPosition())) {
                    nearest = found;
                    nearestDistance = RangeChecker.manhattanDistance(p.getPosition(), found.getPosition());
                }
            }
        }

        return nearest;
    }

    public static Position randomizePosition(int maxRows, int maxCols) {
        int row = (int)(Math.floor(Math.random() * maxRows));
        int col = (int)(Math.floor(Math.random() * maxCols));

        return new Position(row, col);
    }
}
