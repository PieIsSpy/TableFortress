package test;

import main.com.pieisspy.tablefortress.model.enumerators.Owners;
import main.com.pieisspy.tablefortress.model.levelhandler.Board;
import main.com.pieisspy.tablefortress.model.components.Position;
import main.com.pieisspy.tablefortress.model.logics.BoardPopulator;
import main.com.pieisspy.tablefortress.model.logics.PlayerTurn;
import main.com.pieisspy.tablefortress.model.logics.RangeChecker;
import main.com.pieisspy.tablefortress.model.logics.TurnHandler;
import main.com.pieisspy.tablefortress.model.pieces.Piece;
import main.com.pieisspy.tablefortress.model.pieces.Scout;
import main.com.pieisspy.tablefortress.model.pieces.Spawn;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.Scanner;

public class PlayerControlTest {
    public static void displayLines(int c) {
        int i;

        System.out.print("    +");
        for (i = 0; i < c; i++)
            System.out.print("---+");

        System.out.println();
    }

    public static void displaySpace(Piece p, Board b, int r) {
        int i;
        int cols = b.getCols();
        RangeChecker range = new RangeChecker();

        if (r < 10)
            System.out.print(r + "   ");
        else
            System.out.print(r + "  ");
        System.out.print("|");
        for (i = 0; i < cols; i++) {
            if (b.getTiles()[r][i] == null) {
                if (range.hybridCheck(p.getPosition(), new Position(r, i), p.getStats().getAttackRange(), p.getAttackRangeType()))
                    System.out.print("( )|");
                else if (range.hybridCheck(p.getPosition(), new Position(r, i), p.getStats().getMovementRange(), p.getMovementRangeType()))
                    System.out.print(" x |");
                else
                    System.out.print("   |");
            }
            else {
                if (b.getTiles()[r][i].getOwner() == Owners.Player)
                    System.out.print(" o |");
                else if (b.getTiles()[r][i].getOwner() == Owners.Enemy)
                    System.out.print(" u |");
                else
                    System.out.print(" * |");
            }
        }

        System.out.println();
    }

    public static void displayBoard(Piece p, Board b) {
        int i;

        System.out.print("   ");
        for (i = 0; i < b.getCols(); i++) {
            if (i < 10) {
                System.out.print("   ");
                System.out.print(i);
            }
            else {
                System.out.print("  ");
                System.out.print(i);
            }
        }
        System.out.println();

        for (i = 0; i < b.getRows(); i++) {
            displayLines(b.getCols());
            displaySpace(p, b, i);
            displayLines(b.getCols());
        }
    }

    public static void viewQueue(ArrayList<Piece> turns, ArrayList<Piece> cooldowns) {
        Iterator<Piece> it = turns.iterator();
        System.out.println("Current: " + it.next().toString());
        System.out.println("Next: " + it.next().toString());

        if (!cooldowns.isEmpty())
            System.out.println("Upcoming cooldown removal: " + cooldowns.getFirst() + " (" + cooldowns.getFirst().getCooldown().getCounter() + ")");
    }

    public static void main(String[] args) {
        Board board = new Board(20,20);

        Piece scout = new Scout(new Position(0,0));
        scout.setOwner(Owners.Player);
        Piece spawn = new Spawn(new Position(0, 1));
        spawn.setOwner(Owners.Enemy);
        board.insertPiece(scout);
        board.insertPiece(spawn);
        BoardPopulator populator = new BoardPopulator();
        populator.populateBoard(board);

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
                viewQueue(board.getTurns().getHolder(), board.getCooldownHolder().getHolder());
                System.out.println("player: " + board.countTeamPieces(Owners.Player));
                System.out.println("enemy: " + board.countTeamPieces(Owners.Enemy));
                System.out.println("pos: " + p.getPosition());
                System.out.println("move or fight");
                System.out.print("command: ");
                command = input.nextLine();

                if (command.equalsIgnoreCase("move")) {
                    System.out.print("new row: ");
                    row = input.nextInt();
                    System.out.print("new col: ");
                    col = input.nextInt();
                    input.nextLine();

                    pos = new Position(row, col);
                    if (board.isValidTile(pos) && board.isEmptyTile(pos) && range.hybridCheck(p.getPosition(), pos, p.getStats().getMovementRange(), p.getMovementRangeType())) {
                        player.positionMove(board, p, pos);
                        System.out.println("moved to " + pos);
                    }
                    else
                        System.out.println("invalid");
                }
                else if (command.equalsIgnoreCase("fight")) {
                    System.out.print("new row: ");
                    row = input.nextInt();
                    System.out.print("new col: ");
                    col = input.nextInt();
                    input.nextLine();

                    pos = new Position(row, col);
                    if (board.isValidTile(pos) && !board.isEmptyTile(pos) && range.hybridCheck(p.getPosition(), pos, p.getStats().getAttackRange(), p.getAttackRangeType())) {
                        player.attackMove(p, board.getTiles()[row][col]);
                        //turnHandler.placeOnCooldown(board.getTurns().getHolder(), board.getCooldownHolder().getHolder());
                        System.out.println("attacked " + board.getTiles()[row][col]);
                    }
                    else
                        System.out.println("invalid");
                }

                board.removeDeadPieces();
                turnHandler.removeDeadPieces(board.getTurns().getHolder(), board.getCooldownHolder().getHolder());
                /*
                if (!board.getCooldownHolder().getHolder().isEmpty()) {
                    turnHandler.decrementCooldowns(board.getCooldownHolder().getHolder());
                    turnHandler.removeCooldown(board.getTurns().getHolder(), board.getCooldownHolder().getHolder());
                }
                if (!board.getTurns().getHolder().isEmpty())
                    turnHandler.rotateTurns(board.getTurns().getHolder());

                 */
            }
        } while (!board.getTurns().getHolder().isEmpty());
    }
}
