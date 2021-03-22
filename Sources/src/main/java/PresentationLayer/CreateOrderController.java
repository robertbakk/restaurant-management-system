package PresentationLayer;

import BusinessLayer.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class CreateOrderController {


    private IRestaurantProcessing m_model;
    private CreateOrderGUI m_view;
    private int table;
    private ArrayList<MenuItem> items = new ArrayList<MenuItem>();
    private int[] quantities = new int[50];
    private int noItems;
    CreateOrderController(IRestaurantProcessing model, CreateOrderGUI view, int table) {
        m_model = model;
        m_view = view;
        this.table = table;

        view.addAddListener(new AddListener());
        view.addOkListener(new OkListener());
    }


    class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int cantitate = 0;
            String nume = "";
            if (!m_view.getNume().isEmpty() && !m_view.getCantitate().isEmpty()) {
                nume = m_view.getNume();
                cantitate = Integer.parseInt(m_view.getCantitate());
                m_view.reset();
                for (MenuItem a : m_model.getMenuItems()) {
                    if (a.getName().equals(nume)) {
                        items.add(a);
                        quantities[noItems] = cantitate;
                        noItems++;
                    }
                }
            }
        }
    }
    class OkListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (!items.isEmpty() && quantities[0] != 0) {
                Date d = new Date();
                Order x = new Order(d, table);
                m_model.createOrder(x, items, quantities);
                m_view.dispose();
            }
        }
    }

}
