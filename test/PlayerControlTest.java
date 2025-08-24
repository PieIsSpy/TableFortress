package test;

import main.com.pieisspy.tablefortress.model.levelhandler.Board;
import main.com.pieisspy.tablefortress.model.components.Position;
import main.com.pieisspy.tablefortress.model.logics.BoardPopulator;
import main.com.pieisspy.tablefortress.model.logics.PlayerTurn;
import main.com.pieisspy.tablefortress.model.logics.RangeChecker;
import main.com.pieisspy.tablefortress.model.logics.TurnHandler;
import main.com.pieisspy.tablefortress.model.pieces.Piece;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.Scanner;

public class PlayerControlTest {
    public static void displayLines(int c) {
        int i;

        System.out.print("+");
        for (i = 0; i < c; i++)
            System.out.print("---+");

        System.out.println();
    }

    public static void displaySpace(Piece p, Board b, int r) {
        int i;
        int cols = b.getCols();
        RangeChecker range = new RangeChecker();

        System.out.print("|");
        for (i = 0; i < cols; i++) {
            if (b.getTiles()[r][i] == null) {
                if (range.manhattanCheck(p.getPosition(), new Position(r, i), p.getStats().getAttackRange()))
                    System.out.print("( )|");
                else if (range.manhattanCheck(p.getPosition(), new Position(r, i), p.getStats().getMovementRange()))
                    System.out.print(" x |");
                else
                    System.out.print("   |");
            }
            else {
                System.out.print(" o |");
            }
        }

        System.out.println();
    }

    public static void displayBoard(Piece p, Board b) {
        int i;

        for (i = 0; i < b.getRows(); i++) {
            displayLines(b.getCols());
            displaySpace(p, b, i);
            displayLines(b.getCols());
        }
    }

    public static void viewQueue(ArrayList<Piece> turns) {
        Iterator<Piece> it = turns.iterator();
        System.out.println("Current: " + it.next().toString());
        System.out.println("Next: " + it.next().toString());
    }

    public static void main(String[] args) {
        Board board = new Board(20,20);
        BoardPopulator populator = new BoardPopulator();
        populator.populateBoard(board);

        //Piece p = new Scout(new Position(10,10));
        Piece p;
        PlayerTurn player = new PlayerTurn();
        Position pos;
        Scanner input = new Scanner(System.in);
        RangeChecker range = new RangeChecker();
        String command;
        int row, col;

        TurnHandler turnHandler = new TurnHandler();
        turnHandler.sortPrecedence(board.getTurns().getHolder());

        do {
            p = board.getTurns().getHolder().getFirst();

            if (p != null) {
                displayBoard(p, board);
                viewQueue(board.getTurns().getHolder());
                System.out.println("pos: " + p.getPosition());
                System.out.print("command: ");
                command = input.nextLine();

                if (command.equalsIgnoreCase("move")) {
                    System.out.print("new row: ");
                    row = input.nextInt();
                    System.out.print("new col: ");
                    col = input.nextInt();
                    input.nextLine();

                    pos = new Position(row, col);
                    if (board.isValidTile(pos) && board.isEmptyTile(pos) && range.manhattanCheck(p.getPosition(), pos, p.getStats().getMovementRange()))
                        player.positionMove(board, p, new Position(row, col));
                    else
                        System.out.println("invalid");
                }

                if (!board.getTurns().getHolder().isEmpty())
                    turnHandler.rotateTurns(board.getTurns().getHolder());
            }
        } while (!board.getTurns().getHolder().isEmpty());
    }
}
