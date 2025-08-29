package main.com.pieisspy.tablefortress.controller;

import main.com.pieisspy.tablefortress.model.Model;
import main.com.pieisspy.tablefortress.model.components.PieceHolder;
import main.com.pieisspy.tablefortress.model.components.PieceInfo;
import main.com.pieisspy.tablefortress.model.components.Position;
import main.com.pieisspy.tablefortress.model.components.TileInfo;
import main.com.pieisspy.tablefortress.model.enumerators.Moves;
import main.com.pieisspy.tablefortress.model.enumerators.Owners;
import main.com.pieisspy.tablefortress.model.levelhandler.Board;
import main.com.pieisspy.tablefortress.model.logics.RangeChecker;
import main.com.pieisspy.tablefortress.model.pieces.Piece;
import main.com.pieisspy.tablefortress.view.View;
import main.com.pieisspy.tablefortress.view.components.TileButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;

public class GameController implements ActionListener {
    public GameController(Model m, View v) {
        model = m;
        view = v;
        move = null;
        view.getGamePanel().getBoard().setActionListener(this);
    }

    /*
    public void update() {
        view.getGamePanel().getBoard().drawBoard(model.getLevel().getBoard().convertToTileMatrix(), null);
        /*
        while (model.getLevel().getBoard().getTurns().getHolder().getFirst().getOwner() == Owners.Enemy) {
            move = null;
            view.getGamePanel().getBoard().lockInput();

            new Timer(500, e -> {
                model.getLevel().promptEnemyTurn();
                view.getGamePanel().getBoard().drawBoard(model.getLevel().getBoard().convertToTileMatrix(), move);
            }).start();
        }

        view.getGamePanel().getBoard().unlockInput();
    }

    public void enemyTurn() {
        //if (model.getLevel().getBoard().getTurns().getHolder().getFirst().getOwner() == Owners.Enemy)
    }
    */

    /*
    public void highlightMoveTiles() {
        view.getGamePanel().getBoard().drawBoard(model.getLevel().getBoard().convertToTileMatrix(), Moves.Move);
    }

    public void highlightAttackTiles() {
        view.getGamePanel().getBoard().drawBoard(model.getLevel().getBoard().convertToTileMatrix(), Moves.Attack);
    }

     */

    public void update() {
        redrawBoard();
        convertQueueInfo();
    }

    public void redrawBoard() {
        view.getGamePanel().getBoard().drawBoard(model.getLevel().getBoard().convertToTileMatrix(), move);
    }

    public void convertQueueInfo() {
        ArrayList<PieceInfo> converted = model.getLevel().getBoard().convertToQueueInfo();

        for (PieceInfo p : converted)
            System.out.println(p);
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

            if (board.getPiece(new Position(row, col)) == piece)
                move = view.getGamePanel().getBoard().promptOptions();
            else if (move == Moves.Move && board.isEmptyTile(new Position(row, col))) {
                model.getLevel().promptPlayerMove(piece, new Position(row, col));
                move = null;
            }
            else if (move == Moves.Attack && !board.isEmptyTile(new Position(row, col)) && board.getPiece(new Position(row, col)).getOwner() != piece.getOwner()) {
                model.getLevel().promptPlayerAttack(piece, board.getPiece(new Position(row, col)));
                move = null;
            }
        }
        else {
            if (event.getActionCommand().equalsIgnoreCase("move"))
                move = Moves.Move;
            else if (event.getActionCommand().equalsIgnoreCase("attack"))
                move = Moves.Attack;
        }

        update();
    }

    private final Model model;
    private final View view;
    private Moves move;
}
