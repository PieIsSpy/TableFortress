package main.com.pieisspy.tablefortress.view.panels;

import main.com.pieisspy.tablefortress.model.components.PieceInfo;
import main.com.pieisspy.tablefortress.model.enumerators.Moves;
import main.com.pieisspy.tablefortress.view.components.BoardGUI;
import main.com.pieisspy.tablefortress.view.components.QueueElement;

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
    }

    public void init() {
        JPanel leftPanel = new JPanel(null);
        leftPanel.setBackground(new Color(0x426F3B));
        board.setBounds(30,10, 12 * 45, 12 * 45);
        board.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        leftPanel.add(board);
        leftPanel.setPreferredSize(new Dimension(WIDTH - (int)(WIDTH/4),HEIGHT));
        add(leftPanel, BorderLayout.WEST);

        listContainer = new JPanel();
        listContainer.setLayout(new BoxLayout(listContainer, BoxLayout.Y_AXIS));
        //listContainer.setPreferredSize(new Dimension((int)(WIDTH/4),HEIGHT));
        listContainer.setMaximumSize(new Dimension((int)(WIDTH/4),HEIGHT));
        JScrollPane scrollPane = new JScrollPane(listContainer);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setMaximumSize(new Dimension((int)(WIDTH/4),HEIGHT));
        add(scrollPane, BorderLayout.EAST);
    }

    public void drawQueueElements(ArrayList<PieceInfo> infos) {
        listContainer.removeAll();
        listContainer.setMaximumSize(new Dimension(WIDTH/4, infos.size() * 70));
        for (PieceInfo info : infos) {
            listContainer.add(new QueueElement(info.type(), info.curHealth(), info.maxHealth(), info.cooldown()));
            listContainer.add(Box.createVerticalStrut(5));
        }
        listContainer.revalidate();
        listContainer.repaint();
    }

    public Moves promptMoveOptions() {
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

    public int promptGameEndOptions(int result) {
        Object[] options = {"Retry", "Menu"};
        String message;
        int icon;

        switch (result) {
            case 1:
                message = "You win!";
                icon = JOptionPane.INFORMATION_MESSAGE;
                break;
            case 2:
                message = "You lost!";
                icon = JOptionPane.ERROR_MESSAGE;
                break;
            default:
                message = "It's a draw!";
                icon = JOptionPane.WARNING_MESSAGE;
        }

        int choice = JOptionPane.showOptionDialog(
                null,
                message,
                "Game Ended",
                JOptionPane.YES_NO_OPTION,
                icon,
                null,
                options,
                options[1]
        );

        return choice;
    }

    public BoardGUI getBoard() {
        return board;
    }

    private final int WIDTH;
    private final int HEIGHT;
    private BoardGUI board;
    private ArrayList<QueueElement> queue;
    private JPanel listContainer;
}