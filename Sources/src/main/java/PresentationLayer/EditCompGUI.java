package PresentationLayer;

import BusinessLayer.IRestaurantProcessing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EditCompGUI extends JFrame {

    private JButton ok = new JButton("OK");
    private JLabel numeLabel = new JLabel("Name:");
    private JLabel numeNouLabel = new JLabel("New name:");
    private JLabel numeStersLabel = new JLabel("Menu items to delete from composition(separated by ,):");
    private JLabel numeAdaugatLabel = new JLabel("Menu items to add in composition(separated by ,):");
    private JTextField nume = new JTextField(20);
    private JTextField numeNou = new JTextField(20);
    private JTextField numeSters = new JTextField(20);
    private JTextField numeAdaugat = new JTextField(20);

    private IRestaurantProcessing m_model;

    EditCompGUI(IRestaurantProcessing model) {

        m_model = model;
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,1));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout());
        JPanel panel4 = new JPanel();
        panel4.setLayout(new FlowLayout());
        JPanel panel5 = new JPanel();
        panel5.setLayout(new FlowLayout());
        panel1.add(numeLabel);
        panel1.add(nume);
        panel2.add(numeNouLabel);
        panel2.add(numeNou);
        panel3.add(numeStersLabel);
        panel3.add(numeSters);
        panel4.add(numeAdaugatLabel);
        panel4.add(numeAdaugat);
        panel5.add(ok);
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        panel.add(panel4);
        panel.add(panel5);

        this.add(panel);
        this.pack();


        this.setTitle("Edit Composite Product");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void addOkListener(ActionListener a) {
        ok.addActionListener(a);
    }

    public String getNume() {
        return nume.getText();
    }

    public String getNumeNou() {
        return numeNou.getText();
    }

    public String getNumeAdaugat() {
        return numeAdaugat.getText();
    }
    public String getNumeSters() {
        return numeSters.getText();
    }


}
