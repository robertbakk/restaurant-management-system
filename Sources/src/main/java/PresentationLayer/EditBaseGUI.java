package PresentationLayer;

import BusinessLayer.IRestaurantProcessing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EditBaseGUI extends JFrame {

    private JButton ok = new JButton("OK");
    private JLabel numeLabel = new JLabel("Name:");
    private JLabel numeNouLabel = new JLabel("New name:");
    private JLabel pretNouLabel = new JLabel("New price:");
    private JTextField nume = new JTextField(20);
    private JTextField numenou = new JTextField(20);
    private JTextField pretnou = new JTextField(20);

    private IRestaurantProcessing m_model;

    EditBaseGUI(IRestaurantProcessing model) {

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
        panel2.add(numeNouLabel);
        panel2.add(numenou);
        panel3.add(pretNouLabel);
        panel3.add(pretnou);
        panel4.add(ok);
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        panel.add(panel4);

        this.add(panel);
        this.pack();


        this.setTitle("Edit Base Product");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void addOkListener(ActionListener a) {
        ok.addActionListener(a);
    }

    public String getNume() {
        return nume.getText();
    }
    public String getNumeNou() {
        return numenou.getText();
    }
    public String getPretNou() {
        return pretnou.getText();
    }


}
