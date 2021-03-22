package PresentationLayer;

import BusinessLayer.BaseProduct;
import BusinessLayer.IRestaurantProcessing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateBaseController {

    private IRestaurantProcessing m_model;
    private CreateBaseGUI m_view;

    CreateBaseController(IRestaurantProcessing model, CreateBaseGUI view) {
        m_model = model;
        m_view = view;

        view.addOkListener(new OkListener());
    }


    class OkListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = m_view.getNume();
            double price;
            if (!m_view.getPret().isEmpty() && !name.isEmpty()) {
                price = Double.parseDouble(m_view.getPret());
                BaseProduct p = new BaseProduct(name, price);
                m_model.createMenuItem(p);
                m_view.dispose();
            }
        }
    }
}
