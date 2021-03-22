package Main;

import BusinessLayer.Restaurant;
import DataLayer.RestaurantSerializator;
import PresentationLayer.Controller;
import PresentationLayer.GUI;

public class MVC {
    public static void main(String[] args) {
        RestaurantSerializator ser = new RestaurantSerializator(args[0]);
        Restaurant model = new Restaurant(ser);
        GUI view = new GUI(model);
        new Controller(model, view);

        view.setLocationRelativeTo(null);
        view.setVisible(true);
        view.setSize(300,200);
        view.setResizable(false);
    }
}
