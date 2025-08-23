package main.com.pieisspy.tablefortress.model.logics;

import main.com.pieisspy.tablefortress.model.components.Position;

public class RangeChecker {
    public boolean manhattanCheck(Position pos, Position target, int range) {
        return (Math.abs(pos.getCol() - target.getCol()) + Math.abs(pos.getRow() - target.getRow())) <= range;
    }

    public boolean linearCheck(Position pos, Position target, int range) {
        boolean colCheck = (pos.getRow() == target.getRow()) && (Math.abs(pos.getCol() - target.getCol()) <= range);
        boolean rowCheck = (pos.getCol() == target.getCol()) && (Math.abs(pos.getRow() - target.getRow()) <= range);

        return rowCheck || colCheck;
    }
}
