package PresentationLayer;

import BusinessLayer.IRestaurantProcessing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AdministratorGUI extends JFrame {
    private JButton create = new JButton("Create menu item");
    private JButton delete = new JButton("Delete menu item");
    private JButton edit = new JButton("Edit menu item");
    private JButton show = new JButton("Show menu items");
    private JButton close = new JButton("Close");
    private JRadioButton baseProduct = new JRadioButton("Base product");
    private JRadioButton compositeProduct = new JRadioButton("Composite product");

    private IRestaurantProcessing m_model;

    AdministratorGUI(IRestaurantProcessing model) {

        m_model = model;
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,1));
        ButtonGroup group = new ButtonGroup();
        baseProduct.setSelected(true);
        group.add(baseProduct);
        group.add(compositeProduct);
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout());
        JPanel panel4 = new JPanel();
        panel4.setLayout(new FlowLayout());
        panel1.add(show);
        panel2.add(create);
        panel2.add(delete);
        panel2.add(edit);
        panel3.add(baseProduct);
        panel3.add(compositeProduct);
        panel4.add(close);
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        panel.add(panel4);

        this.add(panel);
        this.pack();


        this.setTitle("Administrator");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    void addShowListener(ActionListener a) {
        show.addActionListener(a);
    }
    void addCreateListener(ActionListener a) {
        create.addActionListener(a);
    }
    void addDeleteListener(ActionListener a) {
        delete.addActionListener(a);
    }
    void addEditListener(ActionListener a) {
        edit.addActionListener(a);
    }
    void addBaseListener(ActionListener a) {
        baseProduct.addActionListener(a);
    }
    void addCompositeListener(ActionListener a) {
        compositeProduct.addActionListener(a);
    }
    void addCloseListener(ActionListener a) {
        close.addActionListener(a);
    }

}
