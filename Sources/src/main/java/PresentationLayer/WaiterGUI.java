package PresentationLayer;

import BusinessLayer.IRestaurantProcessing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class WaiterGUI extends JFrame {
    private JButton create = new JButton("Create order");
    private JButton show = new JButton("Show orders");
    private JButton bill = new JButton("Create bill");
    private JLabel tableLabel = new JLabel("Table number:");
    private JTextField table = new JTextField(5);
    private JButton close = new JButton("Close");

    private IRestaurantProcessing m_model;

    WaiterGUI(IRestaurantProcessing model) {

        m_model = model;
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,1));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout());
        JPanel panel4 = new JPanel();
        panel4.setLayout(new FlowLayout());
        panel1.add(show);
        panel2.add(tableLabel);
        panel2.add(table);
        panel3.add(create);
        panel3.add(bill);
        panel4.add(close);
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        panel.add(panel4);

        this.add(panel);
        this.pack();


        this.setTitle("Waiter");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    String getTable(){
        return table.getText();
    }
    void addShowListener(ActionListener a) {
        show.addActionListener(a);
    }
    void addCreateListener(ActionListener a) {
        create.addActionListener(a);
    }
    void addBillListener(ActionListener a) {
        bill.addActionListener(a);
    }
    void addCloseListener(ActionListener a) {
        close.addActionListener(a);
    }

}
