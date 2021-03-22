package PresentationLayer;

import BusinessLayer.IRestaurantProcessing;
import BusinessLayer.MenuItem;
import BusinessLayer.Order;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WaiterController {


    private IRestaurantProcessing m_model;
    private WaiterGUI m_view;
    private JFrame f;
    private CreateOrderGUI ordergui;


    int table = -1;

    WaiterController(IRestaurantProcessing model, WaiterGUI view) {
        m_model = model;
        m_view = view;

        view.addShowListener(new ShowListener());
        view.addCreateListener(new CreateListener());
        view.addBillListener(new BillListener());
        view.addCloseListener(new CloseListener());

    }

    class ShowListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFrame frame = new JFrame("Lista Menu Items");
            if (f != null)
                f.dispose();
            f = frame;
            HashMap<Order, ArrayList<MenuItem>> orders = m_model.getOrders();
            String data[][] = new String[orders.size()][3];

            int c = 0;
            for (Map.Entry<Order,ArrayList<MenuItem>> o: orders.entrySet()) {
                data[c][0] = o.getKey().getOrderID()+"";
                data[c][1] = o.getKey().getDate()+"";
                data[c][2] = o.getKey().getTable()+"";
                c++;
            }
            String column[]= new String[]{"ID","DATE","TABLE"};
            final JTable jt=new JTable(data,column);
            f.add(new JScrollPane(jt));
            f.setLocationRelativeTo(null);
            f.setVisible(true);
            f.pack();
        }
    }

    class CreateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            CreateOrderGUI create = new CreateOrderGUI(m_model);
            if (ordergui != null)
                ordergui.dispose();
            ordergui = create;
            if (!m_view.getTable().isEmpty()) {
                table = Integer.parseInt(m_view.getTable());
                CreateOrderController controller = new CreateOrderController(m_model, ordergui,table);
                ordergui.setLocationRelativeTo(null);
                ordergui.setVisible(true);
                ordergui.setResizable(false);
            }
        }

    }

    class BillListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (!m_view.getTable().isEmpty()) {
                table = Integer.parseInt(m_view.getTable());
                if (table != -1) {
                    m_model.generateBill(table);
                }
            }
        }
    }

    class CloseListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            m_view.dispose();
        }
    }

}
