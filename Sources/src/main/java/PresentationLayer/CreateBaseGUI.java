package PresentationLayer;

import BusinessLayer.IRestaurantProcessing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CreateBaseGUI extends JFrame {

    private JButton ok = new JButton("OK");
    private JLabel numeLabel = new JLabel("Name: ");
    private JLabel pretLabel = new JLabel("Price: ");
    private JTextField nume = new JTextField(20);
    private JTextField pret = new JTextField(20);

    private IRestaurantProcessing m_model;

    CreateBaseGUI(IRestaurantProcessing model) {

        m_model = model;
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,1));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout());
        panel1.add(numeLabel);
        panel1.add(nume);
        panel2.add(pretLabel);
        panel2.add(pret);
        panel3.add(ok);
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);

        this.add(panel);
        this.pack();


        this.setTitle("Create Base Product");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void addOkListener(ActionListener a) {
        ok.addActionListener(a);
    }

    public String getNume() {
        return nume.getText();
    }

    public String getPret() {
        return pret.getText();
    }
}
