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
        init();
    }

    public void init() {
        setLayout(null);
        setPreferredSize(new Dimension(170,70));
        setMinimumSize(new Dimension(170,70));
        setMaximumSize(new Dimension(170,70));

        if (cooldown.getValue() == 0)
            setBackground(new Color(0xFFFFA5));
        else
            setBackground(new Color(0x473D36));

        JPanel spritePanel = new JPanel(new BorderLayout());
        spritePanel.setBounds(10,10,50,50);
        spritePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        add(spritePanel);

        JLabel spriteHolder = new JLabel();
        Image scaledImage = sprite.getScaledInstance(50,50,Image.SCALE_REPLICATE);
        spriteHolder.setIcon(new ImageIcon(scaledImage));
        spritePanel.add(spriteHolder, BorderLayout.CENTER);

        health.setBounds(60,10,100,15);
        health.setForeground(Color.RED);
        health.setString("Health");
        health.setStringPainted(true);
        add(health);

        cooldown.setBounds(60,25,100,15);
        cooldown.setString("Cooldown");
        cooldown.setForeground(new Color(0x7171FA));
        cooldown.setStringPainted(true);
        add(cooldown);
    }

    private BufferedImage sprite;
    private JProgressBar health;
    private JProgressBar cooldown;
}
