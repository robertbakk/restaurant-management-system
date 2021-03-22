package PresentationLayer;

import BusinessLayer.IRestaurantProcessing;
import BusinessLayer.MenuItem;
import BusinessLayer.Order;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observer;

public class ChefGUI extends JFrame implements Observer {
    JTextArea  field = new JTextArea();
    JScrollPane sp = new JScrollPane(field);

    private IRestaurantProcessing m_model;

    ChefGUI(IRestaurantProcessing model) {

        m_model = model;
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        field.setEditable(false);
        panel.add(sp);
        this.add(panel);
        this.setSize(500,300);
        this.setTitle("Chef");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void update(java.util.Observable observable, Object o) {
        String s = "";
        HashMap<Order, ArrayList<MenuItem>> orders = (HashMap<Order, ArrayList<MenuItem>>)((ArrayList<Object>) o).get(0);
        int[] quantities = (int[])((ArrayList<Object>) o).get(1);
        for(HashMap.Entry<Order, ArrayList<MenuItem>> a : orders.entrySet()) {
            int i = 0;
            s = "[ORDER ID " + a.getKey().getOrderID()+"] New order: ";
            for (MenuItem m : a.getValue()) {
                s += quantities[i]+"x " + m.getName() + ",";
                i++;
            }
            s = s.substring(0, s.length()-1);
            s += "\n";
        }
        field.append(s);
    }
}
