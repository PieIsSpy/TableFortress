package main.com.pieisspy.tablefortress.controller;

import main.com.pieisspy.tablefortress.model.Model;
import main.com.pieisspy.tablefortress.view.View;

public class Controller {
    public Controller(Model m, View v) {
        model = m;
        view = v;
    }

    private final Model model;
    private final View view;
}
