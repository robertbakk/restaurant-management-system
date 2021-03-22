package PresentationLayer;

import BusinessLayer.BaseProduct;
import BusinessLayer.IRestaurantProcessing;
import BusinessLayer.MenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditBaseController {


    private IRestaurantProcessing m_model;
    private EditBaseGUI m_view;

    EditBaseController(IRestaurantProcessing model, EditBaseGUI view) {
        m_model = model;
        m_view = view;

        view.addOkListener(new OkListener());
    }


    class OkListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (!m_view.getNume().isEmpty() && (!m_view.getPretNou().isEmpty() || !m_view.getNumeNou().isEmpty())) {
                String nume = m_view.getNume();
                String numeNou = m_view.getNumeNou();
                double pretNou = 0;
                if (!m_view.getPretNou().isEmpty())
                    pretNou = Double.parseDouble(m_view.getPretNou());

                for (MenuItem m : m_model.getMenuItems()) {
                    if (m.getName().equals(nume)) {
                        if (!numeNou.isEmpty())
                            m.setName(numeNou);
                        else {
                            numeNou = nume;
                        }
                        if (pretNou != 0)
                            m.setPrice(pretNou);
                        else {
                            pretNou = m.computePrice();
                        }
                        m_model.editMenuItem(m, new BaseProduct(numeNou, pretNou));
                    }
                }
                m_view.dispose();
            }
        }
    }
}
