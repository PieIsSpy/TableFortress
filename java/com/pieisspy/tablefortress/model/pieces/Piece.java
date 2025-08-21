package java.com.pieisspy.tablefortress.model.pieces;

import java.com.pieisspy.tablefortress.model.components.Position;
import java.com.pieisspy.tablefortress.model.components.Stats;

public abstract class Piece {
    public Piece(Stats stat, Position pos) {
        STATS = stat;
        POSITION = pos;
    }

    public Stats getStats() {
        return STATS;
    }

    public Position getPosition() {
        return POSITION;
    }

    private final Stats STATS;
    private final Position POSITION;
}