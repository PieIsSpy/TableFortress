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
        board = new Board(10,10);
        init();
    }

    public void init() {
        BoardPopulator boardPopulator = new BoardPopulator();
        boardPopulator.populateBoard(board);
    }

    public int getLevelNum() {
        return LEVEL_NUM;
    }

    public void promptPlayerMove(Piece piece, Position target) {
        PlayerTurn playerTurn = new PlayerTurn();
        TurnHandler turnHandler = new TurnHandler();

        playerTurn.positionMove(board, piece, target);
        turnHandler.rotateTurns(board.getTurns().getHolder());
    }

    public void promptPlayerAttack(Piece piece, Piece target) {
        PlayerTurn playerTurn = new PlayerTurn();
        TurnHandler turnHandler = new TurnHandler();

        playerTurn.attackMove(piece, target);
        turnHandler.placeOnCooldown(board.getTurns().getHolder(), board.getCooldownHolder().getHolder());
    }

    public void promptPlayerHeal(Piece piece, Piece target) {
        PlayerTurn playerTurn = new PlayerTurn();
        TurnHandler turnHandler = new TurnHandler();

        playerTurn.healMove(piece, target);
        turnHandler.placeOnCooldown(board.getTurns().getHolder(), board.getCooldownHolder().getHolder());
    }

    public void promptEnemyTurn() {
        Moves move;
        EnemyTurn enemyTurn = new EnemyTurn();
        TurnHandler turnHandler = new TurnHandler();
        Piece piece = board.getTurns().getHolder().getFirst();
        move = enemyTurn.enemyDecision(board, piece);

        if (move == Moves.Move)
            turnHandler.rotateTurns(board.getTurns().getHolder());
        else
            turnHandler.placeOnCooldown(board.getTurns().getHolder(), board.getCooldownHolder().getHolder());
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

    private final int LEVEL_NUM;
    private final Board board;
}
