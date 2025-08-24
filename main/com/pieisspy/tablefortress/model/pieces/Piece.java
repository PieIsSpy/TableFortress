package main.com.pieisspy.tablefortress.model.pieces;

import main.com.pieisspy.tablefortress.model.components.Cooldown;
import main.com.pieisspy.tablefortress.model.components.Position;
import main.com.pieisspy.tablefortress.model.components.Stats;
import main.com.pieisspy.tablefortress.model.enumerators.Owners;
import main.com.pieisspy.tablefortress.model.enumerators.PieceType;
import main.com.pieisspy.tablefortress.model.enumerators.RangeType;

public abstract class Piece {
    public Piece(Stats stat, Cooldown cooldown, Position pos) {
        STATS = stat;
        COOLDOWN = cooldown;
        Position = pos;
    }

    public Stats getStats() {
        return STATS;
    }

    public Cooldown getCooldown() {
        return COOLDOWN;
    }

    public Position getPosition() {
        return Position;
    }

    public void setPosition(Position pos) {
        Position = pos;
    }

    public Owners getOwner() {
        return owner;
    }

    public void setOwner(Owners o) {
        owner = o;
    }

    public PieceType getType() {
        return type;
    }

    public void setType(PieceType t) {
        type = t;
    }

    public RangeType getAttackRangeType() {
        return attackRangeType;
    }

    public void setAttackRangeType(RangeType r) {
        attackRangeType = r;
    }

    public RangeType getMovementRangeType() {
        return movementRangeType;
    }

    public void setMovementRangeType(RangeType r) {
        movementRangeType = r;
    }

    public void takeDamage(int d) {
        int cur = STATS.getHealth() - d;

        if (cur < 0)
            cur = 0;

        STATS.setHealth(cur);
    }

    public void healHealth(int h) {
        int cur = STATS.getHealth() + h;
        int extra = 0;

        if (cur > STATS.getMaxHealth()) {
            extra = cur - getStats().getMaxHealth() / 2;
            cur = getStats().getMaxHealth();
        }

        STATS.setHealth(cur + extra);
    }

    public boolean isAlive() {
        return STATS.getHealth() > 0;
    }

    public String toString() {
        return "(" + STATS.getPrecedence() + ")" + type + ": " + owner;
    }

    private final Stats STATS;
    private final Cooldown COOLDOWN;
    private Position Position;
    private Owners owner;
    private PieceType type;
    private RangeType attackRangeType;
    private RangeType movementRangeType;
}