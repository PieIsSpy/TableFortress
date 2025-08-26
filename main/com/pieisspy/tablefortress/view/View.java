package main.com.pieisspy.tablefortress.view;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    public View() {
        super("Table Fortress");
        setLayout(null);
        setSize(WIDTH, HEIGHT);

        init();

        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void init() {
        cardLayout = new CardLayout();
        currentPanel = new JPanel(cardLayout);

        currentPanel.setBounds(0,0,WIDTH,HEIGHT);
        add(currentPanel);
    }

    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    private JPanel currentPanel;
    private CardLayout cardLayout;
}
