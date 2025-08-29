package main.com.pieisspy.tablefortress.view.components;

import main.com.pieisspy.tablefortress.model.components.TileInfo;
import main.com.pieisspy.tablefortress.model.enumerators.Moves;
import main.com.pieisspy.tablefortress.model.enumerators.PieceType;
import main.com.pieisspy.tablefortress.model.enumerators.RangeType;
import main.com.pieisspy.tablefortress.view.ImageHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class BoardGUI extends JPanel {
    public BoardGUI() {
        setLayout(new GridLayout(ROW, COL));
        int i, j;

        for (i = 0; i < ROW; i++) {
            for (j = 0; j < COL; j++) {
                tiles[i][j] = new TileButton(i,j);
                tiles[i][j].setFocusPainted(false);
                tiles[i][j].setBorder(BorderFactory.createLineBorder(Color.black, 2));
                add(tiles[i][j]);
            }
        }
        ImageHandler.initializeSprites("/resources/images");
    }

    public void drawBoard(TileInfo[][] info, Moves moves) {
        int i, j;

        for (i = 0; i < ROW; i++) {
            for (j = 0; j < COL; j++) {
                // display pieces
                if (info[i][j].type() != null) {
                    Image scaledImage = ImageHandler.sprites.get(info[i][j].type().toString()).getScaledInstance(30,30,Image.SCALE_REPLICATE);
                    tiles[i][j].setIcon(new ImageIcon(scaledImage));
                }
                else
                    tiles[i][j].setIcon(null);

                // display tile colors
                if (info[i][j].isCurrent())
                    tiles[i][j].setBackground(currentTile);
                else if (info[i][j].isAttackTile() && moves == Moves.Attack)
                    tiles[i][j].setBackground(attackTile);
                else if (info[i][j].isMovementTile() && moves == Moves.Move)
                    tiles[i][j].setBackground(moveTile);
                else {
                    if ((i + j) % 2 == 0)
                        tiles[i][j].setBackground(tile1);
                    else
                        tiles[i][j].setBackground(tile2);
                }
            }
        }
    }

    public Moves promptOptions() {
        Object[] options = {"Move", "Attack", "Cancel"};

        int choice = JOptionPane.showOptionDialog(
                null,
                "What will this piece do?",
                "Turn Options",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[2]
        );

        if (choice == 0)
            return Moves.Move;
        else if (choice == 1)
            return Moves.Attack;
        else
            return null;
    }

    public void lockInput() {
        int i, j;

        for (i = 0; i < ROW; i++)
            for (j = 0; j < COL; j++)
                tiles[i][j].setEnabled(false);
    }

    public void unlockInput() {
        int i, j;

        for (i = 0; i < ROW; i++)
            for (j = 0; j < COL; j++)
                tiles[i][j].setEnabled(true);
    }

    public void setActionListener(ActionListener listener) {
        int i, j;

        for (i = 0; i < ROW; i++) {
            for (j = 0; j < COL; j++) {
                tiles[i][j].addActionListener(listener);
            }
        }
    }

    private final int ROW = 12;
    private final int COL = 12;
    private TileButton[][] tiles = new TileButton[ROW][COL];
    private final Color tile1 = new Color(255,222,173);
    private final Color tile2 = new Color(218,165,32);
    private final Color attackTile = new Color(220,20,60);
    private final Color moveTile = new Color(135,206,250);
    private final Color currentTile = new Color(0xFFF9F6);
}