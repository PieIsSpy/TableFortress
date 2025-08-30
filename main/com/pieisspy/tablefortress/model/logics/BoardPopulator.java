package main.com.pieisspy.tablefortress.model.logics;

import main.com.pieisspy.tablefortress.model.levelhandler.Board;
import main.com.pieisspy.tablefortress.model.components.Position;
import main.com.pieisspy.tablefortress.model.enumerators.Owners;
import main.com.pieisspy.tablefortress.model.pieces.*;

public class BoardPopulator {
    public static void populateBoard(Board b) {
        int i;
        b.insertPiece(new Scout(new Position(0,0)));
        b.getPiece(new Position(0,0)).setOwner(Owners.Player);
        b.insertPiece(new Spawn(new Position(11,1)));
        b.getPiece(new Position(11,1)).setOwner(Owners.Enemy);
        /*
        for (i = 0; i < 6; i++)
            placeRandomToySoldier(b);

        for (i = 0; i < 6; i++)
            placeRandomClayMonster(b);

         */
    }

    public static void placeRandomToySoldier(Board b) {
        double x = Math.random();
        Position random;
        Piece piece;
        int rows = b.getRows();
        int cols = b.getCols();

        do {
            random = randomizePosition(rows, cols);
        } while (!b.isValidTile(random) || !b.isEmptyTile(random));

        if (x > .5f)
            piece = new Scout(random);
        else if (x > .3f)
            piece = new Soldier(random);
        else if (x > .1f)
            piece = new Heavy(random);
        else
            piece = new Sniper(random);

        piece.setOwner(Owners.Player);

        b.insertPiece(piece);
    }

    public static void placeRandomClayMonster(Board b) {
        double x = Math.random();
        Position random;
        Piece piece;
        int rows = b.getRows();
        int cols = b.getCols();

        do {
            random = randomizePosition(rows, cols);
        } while (!b.isValidTile(random) || !b.isEmptyTile(random));

        if (x > .5f)
            piece = new Spawn(random);
        else if (x > .3f)
            piece = new Figure(random);
        else if (x > .1f)
            piece = new Crawler(random);
        else
            piece = new Brute(random);

        piece.setOwner(Owners.Enemy);

        b.insertPiece(piece);
    }

    public static Position randomizePosition(int maxRows, int maxCols) {
        int row = (int)(Math.floor(Math.random() * maxRows));
        int col = (int)(Math.floor(Math.random() * maxCols));

        return new Position(row, col);
    }
}