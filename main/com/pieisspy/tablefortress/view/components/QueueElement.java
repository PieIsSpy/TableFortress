package main.com.pieisspy.tablefortress.view.components;

import main.com.pieisspy.tablefortress.model.components.Cooldown;
import main.com.pieisspy.tablefortress.model.enumerators.PieceType;
import main.com.pieisspy.tablefortress.view.ImageHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class QueueElement extends JPanel {
    public QueueElement(PieceType type, int ch, int mx, Cooldown c) {
        sprite = ImageHandler.sprites.get(type.toString());
        health = new JProgressBar(0, mx);
        health.setValue(ch);
        cooldown = new JProgressBar(0, c.getCooldown());
        cooldown.setValue(c.getCounter());
    }

    public void init() {
        setPreferredSize(new Dimension(150,70));
    }

    private BufferedImage sprite;
    private JProgressBar health;
    private JProgressBar cooldown;
}
