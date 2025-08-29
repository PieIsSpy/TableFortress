package main.com.pieisspy.tablefortress.view;

import main.com.pieisspy.tablefortress.view.panels.GamePanel;
import main.com.pieisspy.tablefortress.view.panels.MenuPanel;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    public View() {
        super("Table Fortress");
        setLayout(null);
        setSize(WIDTH, HEIGHT);

        init();

        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void init() {
        cardLayout = new CardLayout();
        currentPanel = new JPanel(cardLayout);
        menu = new MenuPanel(WIDTH, HEIGHT);
        game = new GamePanel(WIDTH, HEIGHT);

        currentPanel.add(menu, "menu");
        currentPanel.add(game, "game");

        currentPanel.setBounds(0,0,WIDTH,HEIGHT);
        add(currentPanel);
    }

    public void changePanel(String name) {
        if (name.equalsIgnoreCase("menu"))
            cardLayout.show(currentPanel, "menu");
        else if (name.equalsIgnoreCase("game"))
            cardLayout.show(currentPanel, "game");
    }

    public MenuPanel getMenuPanel() {
        return menu;
    }

    public GamePanel getGamePanel() {
        return game;
    }

    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    private JPanel currentPanel;
    private CardLayout cardLayout;
    private MenuPanel menu;
    private GamePanel game;
}
