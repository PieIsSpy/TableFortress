package main.com.pieisspy.tablefortress.view.panels;

import main.com.pieisspy.tablefortress.view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {
    public MenuPanel(int w, int h) {
        WIDTH = w;
        HEIGHT = h;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        init();
    }

    public void init() {
        add(Box.createRigidArea(new Dimension(0, 100)));
        JLabel title = new JLabel("Table Fortress");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(title);

        add(Box.createRigidArea(new Dimension(0, 100)));

        JPanel buttons = new JPanel(new GridLayout(3,1,5,5));
        buttons.setPreferredSize(new Dimension(100,150));
        buttons.setMaximumSize(new Dimension(100,150));
        buttons.add(start);
        //buttons.add(credits);
        buttons.add(quit);
        add(buttons);
    }

    public void setActionListener(ActionListener listener) {
        start.addActionListener(listener);
        //credits.addActionListener(listener);
        quit.addActionListener(listener);
    }

    private final int WIDTH;
    private final int HEIGHT;
    private JButton start = new JButton("start");
    //private JButton credits = new JButton("credits");
    private JButton quit = new JButton("quit");
}