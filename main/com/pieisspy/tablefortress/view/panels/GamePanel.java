package main.com.pieisspy.tablefortress.view.panels;

import main.com.pieisspy.tablefortress.controller.Controller;
import main.com.pieisspy.tablefortress.model.Model;
import main.com.pieisspy.tablefortress.model.components.PieceInfo;
import main.com.pieisspy.tablefortress.view.View;
import main.com.pieisspy.tablefortress.view.components.BoardGUI;
import main.com.pieisspy.tablefortress.view.components.QueueElement;
//import main.com.pieisspy.tablefortress.view.components.Prompt;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {
    public GamePanel(int w, int h) {
        WIDTH = w;
        HEIGHT = h;
        board = new BoardGUI();
        queue = new ArrayList<>();
        setLayout(new BorderLayout());
        init();

        /*
        setLayout(null);
        JPanel rightPanel = new JPanel(null);
        rightPanel.setBackground(Color.red);
        rightPanel.setPreferredSize(new Dimension((int)(WIDTH/5.35),HEIGHT));
        add(rightPanel, BorderLayout.EAST);

        JPanel testBox = new JPanel();
        testBox.setBackground(Color.green);
        testBox.setBounds(0,0,140,70);
        testBox.setVisible(true);
        rightPanel.add(testBox);

         */
    }

    public void init() {
        JPanel leftPanel = new JPanel(null);
        leftPanel.setBackground(new Color(0x426F3B));
        board.setBounds(50,10, 12 * 45, 12 * 45);
        board.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        leftPanel.add(board);
        leftPanel.setPreferredSize(new Dimension(WIDTH - (int)(WIDTH/5.35),HEIGHT));
        add(leftPanel, BorderLayout.WEST);

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(Color.red);
        rightPanel.setPreferredSize(new Dimension((int)(WIDTH/5.35),HEIGHT));
        add(rightPanel, BorderLayout.EAST);
    }

    public void drawQueueElements(ArrayList<PieceInfo> infos) {
        queue.clear();
        for (PieceInfo info : infos) {
            queue.add(new QueueElement(info.type(), info.curHealth(), info.maxHealth(), info.cooldown()));
        }
    }

    public BoardGUI getBoard() {
        return board;
    }

    private final int WIDTH;
    private final int HEIGHT;
    private BoardGUI board;
    private ArrayList<QueueElement> queue;
}

class test {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
    }
}