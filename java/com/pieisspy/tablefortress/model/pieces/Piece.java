package java.com.pieisspy.tablefortress.model.pieces;

import java.com.pieisspy.tablefortress.model.components.Cooldown;
import java.com.pieisspy.tablefortress.model.components.Position;
import java.com.pieisspy.tablefortress.model.components.Stats;

public abstract class Piece {
    public Piece(Stats stat, Cooldown cooldown, Position pos) {
        STATS = stat;
        COOLDOWN = cooldown;
        POSITION = pos;
    }

    public Stats getStats() {
        return STATS;
    }

    public Cooldown getCooldown() {
        return COOLDOWN;
    }

    public Position getPosition() {
        return POSITION;
    }

    private final Stats STATS;
    private final Cooldown COOLDOWN;
    private final Position POSITION;
}