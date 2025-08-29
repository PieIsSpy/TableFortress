package main.com.pieisspy.tablefortress.model.logics;

import main.com.pieisspy.tablefortress.model.components.Position;
import main.com.pieisspy.tablefortress.model.components.Range;
import main.com.pieisspy.tablefortress.model.enumerators.RangeType;

public class RangeChecker {
    public static boolean manhattanCheck(Position pos, Position target, int range) {
        return (Math.abs(pos.getCol() - target.getCol()) + Math.abs(pos.getRow() - target.getRow())) <= range;
    }

    public static boolean linearCheck(Position pos, Position target, int range) {
        boolean colCheck = (pos.getRow() == target.getRow()) && (Math.abs(pos.getCol() - target.getCol()) <= range);
        boolean rowCheck = (pos.getCol() == target.getCol()) && (Math.abs(pos.getRow() - target.getRow()) <= range);

        return rowCheck || colCheck;
    }

    public static boolean squareCheck(Position pos, Position target, int range) {
        int row = Math.abs(target.getRow() - pos.getRow());
        int col = Math.abs(target.getCol() - pos.getCol());

        return (row <= range) && (col <= range);
    }

    public static boolean hybridCheck(Position pos, Position target, Range range) {
        if (range.type() == RangeType.Manhattan)
            return manhattanCheck(pos, target, range.reach());
        else if (range.type() == RangeType.Linear)
            return linearCheck(pos, target, range.reach());
        else
            return squareCheck(pos, target, range.reach());
    }

    public static int manhattanDistance(Position pos, Position target) {
        return Math.abs(pos.getCol() - target.getCol()) + Math.abs(pos.getRow() - target.getRow());
    }
}
