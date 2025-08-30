package main.com.pieisspy.tablefortress.controller;

import main.com.pieisspy.tablefortress.model.Model;
import main.com.pieisspy.tablefortress.view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController implements ActionListener {
    public MenuController(Model m, View v, GameController c) {
        model = m;
        view = v;
        gameController = c;
        v.getMenuPanel().setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if (e.getActionCommand().equalsIgnoreCase("start")) {
            model.createLevel();
            /*
            view.getGamePanel().getBoard().drawBoard(model.getLevel().getBoard().convertToTileMatrix(), null);
            view.getGamePanel().drawQueueElements(model.getLevel().getBoard().convertToQueueInfo());

             */
            gameController.update();
            view.changePanel("game");
        }
        else if (e.getActionCommand().equalsIgnoreCase("quit"))
            System.exit(0);

    }

    private Model model;
    private View view;
    private GameController gameController;
}
