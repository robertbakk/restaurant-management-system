package PresentationLayer;

import BusinessLayer.CompositeProduct;
import BusinessLayer.IRestaurantProcessing;
import BusinessLayer.MenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateCompController {


    private IRestaurantProcessing m_model;
    private CreateCompGUI m_view;

    CreateCompController(IRestaurantProcessing model, CreateCompGUI view) {
        m_model = model;
        m_view = view;

        view.addOkListener(new OkListener());
    }

    class OkListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String nume = m_view.getNume();
            String produse[] = m_view.getCompozitie().split(",");
            if (!nume.isEmpty() && !produse[0].isEmpty()) {
                CompositeProduct pr = new CompositeProduct(nume);
                for (String p : produse) {
                    for (MenuItem m : m_model.getMenuItems()) {
                        if (m.getName().equals(p)) {
                            pr.addProduct(m);
                        }
                    }
                }
                m_model.createMenuItem(pr);
                m_view.dispose();
            }
        }
    }

}
