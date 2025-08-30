package main.com.pieisspy.tablefortress.controller;

import main.com.pieisspy.tablefortress.model.Model;
import main.com.pieisspy.tablefortress.view.View;

public class Controller {
    public Controller(Model m, View v) {
        model = m;
        view = v;

        gameController = new GameController(model, view);
        menuController = new MenuController(model, view, gameController);
    }

    private Model model;
    private View view;
    private MenuController menuController;
    private GameController gameController;
}
