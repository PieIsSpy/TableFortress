package test;

import main.com.pieisspy.tablefortress.model.components.Position;
import main.com.pieisspy.tablefortress.model.enumerators.Owners;
import main.com.pieisspy.tablefortress.model.levelhandler.Board;
import main.com.pieisspy.tablefortress.model.logics.EnemyTurn;
import main.com.pieisspy.tablefortress.model.logics.RangeChecker;
import main.com.pieisspy.tablefortress.model.pieces.*;
/*
public class ManhattanDistanceTest {
    public static void main(String[] args) {
        RangeChecker rangeChecker = new RangeChecker();
        EnemyTurn enemyTurn = new EnemyTurn();
        Board board = new Board(10,10);
        Piece scout = new Scout(new Position(5,5));
        scout.setOwner(Owners.Player);
        Piece spawn = new Spawn(new Position(0,0));
        spawn.setOwner(Owners.Enemy);
        Piece brute = new Brute(new Position(5, 1));
        brute.setOwner(Owners.Enemy);
        Piece aVolatile = new Volatile(new Position(5,6));
        aVolatile.setOwner(Owners.Enemy);
        board.insertPiece(scout);
        board.insertPiece(spawn);
        board.insertPiece(brute);
        board.insertPiece(aVolatile);
        Piece nearest = enemyTurn.seekNearestEnemy(board, scout);

        for (Piece p:board.getTurns().getHolder())
            if (p.getOwner() != Owners.Player) {
                System.out.println(p);
                System.out.println(rangeChecker.manhattanDistance(scout.getPosition(), p.getPosition()));
            }

        System.out.println("nearest:");
        System.out.println(nearest);
        System.out.println("in range:");
        System.out.println(rangeChecker.hybridCheck(scout.getPosition(),nearest.getPosition(),scout.getStats().getAttackRange(),scout.getAttackRangeType()));
    }
}
*/