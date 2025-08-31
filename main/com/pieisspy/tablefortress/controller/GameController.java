package main.com.pieisspy.tablefortress.controller;

import main.com.pieisspy.tablefortress.model.Model;
import main.com.pieisspy.tablefortress.model.components.Position;
import main.com.pieisspy.tablefortress.model.components.TileInfo;
import main.com.pieisspy.tablefortress.model.enumerators.Moves;
import main.com.pieisspy.tablefortress.model.enumerators.Owners;
import main.com.pieisspy.tablefortress.model.levelhandler.Board;
import main.com.pieisspy.tablefortress.model.pieces.Piece;
import main.com.pieisspy.tablefortress.view.View;
import main.com.pieisspy.tablefortress.view.components.TileButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController implements ActionListener {
    public GameController(Model m, View v) {
        model = m;
        view = v;
        move = null;
        view.getGamePanel().getBoard().setActionListener(this);
    }

    public void update() {
        updateGraphics();
        promptEnemyMove();
        promptPostGame();
    }

    public void promptPostGame() {
        if (model.getLevel().isLevelOver()) {
            int choice;

            if (model.getLevel().isLevelWon())
                choice = view.getGamePanel().promptGameEndOptions(1);
            else if (model.getLevel().isLevelLost())
                choice = view.getGamePanel().promptGameEndOptions(2);
            else
                choice = view.getGamePanel().promptGameEndOptions(3);

            if (choice == 0) {
                model.destroyLevel();
                model.createLevel();
                update();
            }
            else {
                view.changePanel("menu");
                model.destroyLevel();
            }
        }
    }

    public void updateGraphics() {
        redrawBoard();
        redrawQueue();
    }

    public void promptEnemyMove() {
        view.getGamePanel().getBoard().lockInput();

        Timer enemyTurn = new Timer(500, null);
        enemyTurn.addActionListener(e -> {
            if (model.getLevel() != null && !model.getLevel().isLevelOver() && !model.getLevel().getBoard().getTurns().getHolder().isEmpty()) {
                if (model.getLevel().getBoard().getTurns().getHolder().getFirst().getOwner() == Owners.Enemy) {
                    model.getLevel().promptEnemyTurn();
                    updateGraphics();
                    promptPostGame();
                } else {
                    view.getGamePanel().getBoard().unlockInput();
                    enemyTurn.stop();
                }
            }
        });
        enemyTurn.start();
    }

    public void redrawBoard() {
        view.getGamePanel().getBoard().drawBoard(model.getLevel().getBoard().convertToTileMatrix(), move);
    }

    public void redrawQueue() {
        view.getGamePanel().drawQueueElements(model.getLevel().getBoard().convertToQueueInfo());
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() instanceof TileButton) {
            TileButton button = (TileButton) (event.getSource());
            int row = button.getRow();
            int col = button.getCol();
            TileInfo[][] tileMatrix = model.getLevel().getBoard().convertToTileMatrix();
            Piece piece = model.getLevel().getBoard().getTurns().getHolder().getFirst();
            Board board = model.getLevel().getBoard();
            System.out.println("(" + button.getRow() + ", " + button.getCol() + ")");

            if (board.getPiece(new Position(row, col)) == piece) {
                move = view.getGamePanel().promptMoveOptions();
                updateGraphics();
                System.out.println(move);
            }
            else if (move == Moves.Move && tileMatrix[row][col].type() == null && tileMatrix[row][col].isMovementTile()) {
                model.getLevel().promptPlayerMove(piece, new Position(row, col));
                move = null;
                update();
            }
            else if (move == Moves.Attack && tileMatrix[row][col].type() != null && board.getPiece(new Position(row, col)).getOwner() != piece.getOwner() && tileMatrix[row][col].isAttackTile()) {
                model.getLevel().promptPlayerAttack(piece, board.getPiece(new Position(row, col)));
                move = null;
                update();
            }
        }
    }

    private final Model model;
    private final View view;
    private Moves move;
}
