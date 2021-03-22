package PresentationLayer;

import BusinessLayer.IRestaurantProcessing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CreateOrderGUI extends JFrame {

    private JButton add = new JButton("Add to order");
    private JButton ok = new JButton("OK");
    private JLabel numeLabel = new JLabel("Product name:");
    private JLabel cantitateLabel = new JLabel("Quantity:");
    private JLabel info = new JLabel("Click OK after adding items to the order!");
    private JTextField nume = new JTextField(20);
    private JTextField cantitate = new JTextField(20);

    private IRestaurantProcessing m_model;

    CreateOrderGUI(IRestaurantProcessing model) {

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
        panel1.add(numeLabel);
        panel1.add(nume);
        panel2.add(cantitateLabel);
        panel2.add(cantitate);
        panel3.add(info);
        panel4.add(add);
        panel4.add(ok);
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        panel.add(panel4);

        this.add(panel);
        this.pack();


        this.setTitle("Create Order");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }


    public String getNume() {
        return nume.getText();
    }

    public String getCantitate() {
        return cantitate.getText();
    }
    public void reset(){
        nume.setText("");
        cantitate.setText("");
    }


    public void addAddListener(ActionListener a) {
        add.addActionListener(a);
    }
    public void addOkListener(ActionListener a) {
        ok.addActionListener(a);
    }
}
