package main.com.pieisspy.tablefortress.model.logics;

import main.com.pieisspy.tablefortress.model.components.Position;
import main.com.pieisspy.tablefortress.model.enumerators.RangeType;

public class RangeChecker {
    public boolean manhattanCheck(Position pos, Position target, int range) {
        return (Math.abs(pos.getCol() - target.getCol()) + Math.abs(pos.getRow() - target.getRow())) <= range;
    }

    public boolean linearCheck(Position pos, Position target, int range) {
        boolean colCheck = (pos.getRow() == target.getRow()) && (Math.abs(pos.getCol() - target.getCol()) <= range);
        boolean rowCheck = (pos.getCol() == target.getCol()) && (Math.abs(pos.getRow() - target.getRow()) <= range);

        return rowCheck || colCheck;
    }

    public boolean squareCheck(Position pos, Position target, int range) {
        int row = Math.abs(target.getRow() - pos.getRow());
        int col = Math.abs(target.getCol() - pos.getCol());

        return (row <= range) && (col <= range);
    }

    public boolean hybridCheck(Position pos, Position target, int range, RangeType type) {
        if (type == RangeType.Manhattan)
            return manhattanCheck(pos, target, range);
        else if (type == RangeType.Linear)
            return linearCheck(pos, target, range);
        else
            return squareCheck(pos, target, range);
    }
}
