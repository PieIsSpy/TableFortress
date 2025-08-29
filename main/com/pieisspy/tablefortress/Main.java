package main.com.pieisspy.tablefortress;

import main.com.pieisspy.tablefortress.controller.Controller;
import main.com.pieisspy.tablefortress.controller.GameController;
import main.com.pieisspy.tablefortress.controller.MenuController;
import main.com.pieisspy.tablefortress.model.Model;
import main.com.pieisspy.tablefortress.view.View;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
    }
}
