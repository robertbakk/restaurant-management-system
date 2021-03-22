package PresentationLayer;

import BusinessLayer.IRestaurantProcessing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DeleteGUI extends JFrame {

    private JButton ok = new JButton("OK");
    private JLabel numeLabel = new JLabel("Name:");
    private JTextField nume = new JTextField(20);

    private IRestaurantProcessing m_model;

    DeleteGUI(IRestaurantProcessing model) {

        m_model = model;
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,1));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        panel1.add(numeLabel);
        panel1.add(nume);
        panel2.add(ok);
        panel.add(panel1);
        panel.add(panel2);

        this.add(panel);
        this.pack();


        this.setTitle("Delete Menu Item");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void addOkListener(ActionListener a) {
        ok.addActionListener(a);
    }

    public String getNume() {
        return nume.getText();
    }

}
