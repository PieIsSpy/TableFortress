package main.com.pieisspy.tablefortress.model.levelhandler;

import main.com.pieisspy.tablefortress.model.components.PieceHolder;
import main.com.pieisspy.tablefortress.model.components.PieceInfo;
import main.com.pieisspy.tablefortress.model.components.Position;
import main.com.pieisspy.tablefortress.model.components.TileInfo;
import main.com.pieisspy.tablefortress.model.enumerators.Owners;
import main.com.pieisspy.tablefortress.model.enumerators.PieceType;
import main.com.pieisspy.tablefortress.model.logics.RangeChecker;
import main.com.pieisspy.tablefortress.model.pieces.Piece;

import java.util.ArrayList;

public class Board {
    public Board(int r, int c) {
        TILES = new Piece[r][c];
        ROWS = r;
        COLS = c;
        COOLDOWN_HOLDER = new PieceHolder();
        TURNS = new PieceHolder();
    }

    public Piece[][] getTiles() {
        return TILES;
    }

    public PieceHolder getCooldownHolder() {
        return COOLDOWN_HOLDER;
    }

    public PieceHolder getTurns() {
        return TURNS;
    }

    public int getRows() {
        return ROWS;
    }

    public int getCols() {
        return COLS;
    }

    public boolean isValidTile(Position pos) {
        int r = pos.getRow();
        int c = pos.getCol();

        return r >= 0 && r < ROWS && c >= 0 && c < COLS;
    }

    public boolean isEmptyTile(Position pos) {
        int r = pos.getRow();
        int c = pos.getCol();

        return TILES[r][c] == null;
    }

    public void insertPiece(Piece p) {
        int r = p.getPosition().getRow();
        int c = p.getPosition().getCol();

        TILES[r][c] = p;
        TURNS.getHolder().add(p);
    }

    public int countTeamPieces(Owners owner) {
        int turns = 0;
        int cooldowns = 0;

        for (Piece p : TURNS.getHolder())
            if (p.getOwner() == owner)
                turns++;

        for (Piece p : COOLDOWN_HOLDER.getHolder())
            if (p.getOwner() == owner)
                turns++;

        return turns + cooldowns;
    }

    public void removeDeadPieces() {
        int i, j;

        for (i = 0; i < ROWS; i++)
            for (j = 0; j < COLS; j++)
                if (TILES[i][j] != null && !TILES[i][j].isAlive())
                    TILES[i][j] = null;
    }

    public Piece getPiece(Position pos) {
        return TILES[pos.getRow()][pos.getCol()];
    }

    public TileInfo[][] convertToTileMatrix() {
        TileInfo[][] temp = new TileInfo[ROWS][COLS];
        Piece current = TURNS.getHolder().getFirst();
        int i, j;
        Piece tile;
        PieceType type;
        Position pos;
        boolean isAttackTile;
        boolean isMovementTile;
        boolean isCurrent;

        for (i = 0; i < ROWS; i++) {
            for (j = 0; j < COLS; j++) {
                tile = TILES[i][j];
                pos = new Position(i, j);

                type = null;
                isAttackTile = false;
                isMovementTile = false;
                isCurrent = false;

                if (TILES[i][j] != null)
                    type = tile.getType();

                if (RangeChecker.hybridCheck(current.getPosition(), pos, current.getAttackRange()))
                    isAttackTile = true;

                if (RangeChecker.hybridCheck(current.getPosition(), pos, current.getMovementRange()))
                    isMovementTile = true;

                if (tile == current)
                    isCurrent = true;

                temp[i][j] = new TileInfo(type,isAttackTile,isMovementTile,isCurrent);
            }
        }

        return temp;
    }

    public ArrayList<PieceInfo> convertToQueueInfo() {
        ArrayList<PieceInfo> temp = new ArrayList<>();
        for (Piece p : TURNS.getHolder())
            temp.add(new PieceInfo(p.getType(), p.getStats().getHealth(), p.getStats().getMaxHealth(), p.getCooldown()));

        for (Piece p : COOLDOWN_HOLDER.getHolder())
            temp.add(new PieceInfo(p.getType(), p.getStats().getHealth(), p.getStats().getMaxHealth(), p.getCooldown()));

        return temp;
    }

    private final Piece[][] TILES;
    private final PieceHolder COOLDOWN_HOLDER;
    private final PieceHolder TURNS;
    private final int ROWS;
    private final int COLS;
}
