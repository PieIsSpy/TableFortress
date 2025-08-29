package main.com.pieisspy.tablefortress.model.levelhandler;

import main.com.pieisspy.tablefortress.model.components.Position;
import main.com.pieisspy.tablefortress.model.enumerators.Moves;
import main.com.pieisspy.tablefortress.model.enumerators.Owners;
import main.com.pieisspy.tablefortress.model.logics.BoardPopulator;
import main.com.pieisspy.tablefortress.model.logics.EnemyTurn;
import main.com.pieisspy.tablefortress.model.logics.PlayerTurn;
import main.com.pieisspy.tablefortress.model.logics.TurnHandler;
import main.com.pieisspy.tablefortress.model.pieces.Piece;

public class Level {
    public Level(int l) {
        LEVEL_NUM = l;
        board = new Board(12,12);
        init();
    }

    public void init() {
        BoardPopulator.populateBoard(board);
        TurnHandler.sortPrecedence(board.getTurns());
    }

    public int getLevelNum() {
        return LEVEL_NUM;
    }

    public Board getBoard() {
        return board;
    }

    public void promptPlayerMove(Piece piece, Position target) {
        PlayerTurn.positionMove(board, piece, target);
        postTurn();
        TurnHandler.rotateTurns(board.getTurns());
    }

    public void promptPlayerAttack(Piece piece, Piece target) {
        PlayerTurn.attackMove(piece, target);
        postTurn();
        if (board.getTurns().getHolder().getFirst().getCooldown().getCooldown() > 0)
            TurnHandler.placeOnCooldown(board.getTurns(), board.getCooldownHolder());
        else
            TurnHandler.rotateTurns(board.getTurns());
    }

    public void promptEnemyTurn() {
        Moves move;
        Piece piece = board.getTurns().getHolder().getFirst();
        move = EnemyTurn.enemyDecision(board, piece);

        if (move == Moves.Move) {
            postTurn();
            TurnHandler.rotateTurns(board.getTurns());
        }
        else {
            postTurn();
            if (board.getTurns().getHolder().getFirst().getCooldown().getCooldown() > 0)
                TurnHandler.placeOnCooldown(board.getTurns(), board.getCooldownHolder());
            else
                TurnHandler.rotateTurns(board.getTurns());
        }
    }

    public void postTurn() {
        TurnHandler.removeDeadPieces(board.getTurns(), board.getCooldownHolder());
        board.removeDeadPieces();
        TurnHandler.decrementCooldowns(board.getCooldownHolder());
        TurnHandler.removeCooldown(board.getTurns(), board.getCooldownHolder());
    }

    public boolean isLevelWon() {
        return board.countTeamPieces(Owners.Player) > 0 && board.countTeamPieces(Owners.Enemy) == 0;
    }

    public boolean isLevelLost() {
        return board.countTeamPieces(Owners.Enemy) > 0 && board.countTeamPieces(Owners.Player) == 0;
    }

    public boolean isLevelDraw() {
        return board.countTeamPieces(Owners.Enemy) == 0 && board.countTeamPieces(Owners.Player) == 0;
    }

    public boolean isLevelOver() {
        return isLevelWon() || isLevelLost() || isLevelDraw();
    }

    private final int LEVEL_NUM;
    private final Board board;
}
