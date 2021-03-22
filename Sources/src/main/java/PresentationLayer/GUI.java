package PresentationLayer;

import BusinessLayer.IRestaurantProcessing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private JButton administrator = new JButton("Administrator");
    private JButton waiter = new JButton("Waiter");
    private JButton chef = new JButton("Chef");

    private JButton close = new JButton("Close");

    private IRestaurantProcessing m_model;

    public GUI(IRestaurantProcessing model) {

        m_model = model;


        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,1));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout());
        JPanel blank = new JPanel();
        blank.setLayout(new FlowLayout());
        panel1.add(administrator);
        panel1.add(waiter);
        panel2.add(chef);
        panel3.add(close);
        panel.add(panel1);
        panel.add(panel2);
        panel.add(blank);
        panel.add(panel3);

        this.add(panel);
        this.pack();

        this.setTitle("Restaurant Manager");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    void addAdministratorListener(ActionListener a) {
        administrator.addActionListener(a);
    }

    void addWaiterListener(ActionListener a) {
        waiter.addActionListener(a);
    }

    void addChefListener(ActionListener a) {
        chef.addActionListener(a);
    }

    void addCloseListener(ActionListener a) {
        close.addActionListener(a);
    }
}
