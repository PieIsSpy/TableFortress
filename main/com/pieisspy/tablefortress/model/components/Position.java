package main.com.pieisspy.tablefortress.model.components;

public class Position {
    public Position(int r, int c) {
        row = r;
        col = c;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int r) {
        row = r;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int c) {
        col = c;
    }

    public String toString() {
        return "(" + row + ", " + col + ")";
    }

    private int row;
    private int col;
}
