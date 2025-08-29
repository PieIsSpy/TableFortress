package main.com.pieisspy.tablefortress.view.components;

import javax.swing.*;

public class TileButton extends JButton {
    public TileButton(int r, int c) {
        ROW = r;
        COL = c;
    }

    public int getRow() {
        return ROW;
    }

    public int getCol() {
        return COL;
    }

    private final int ROW;
    private final int COL;
}
