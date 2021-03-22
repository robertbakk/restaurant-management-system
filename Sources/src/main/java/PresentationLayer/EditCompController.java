package PresentationLayer;

import BusinessLayer.CompositeProduct;
import BusinessLayer.IRestaurantProcessing;
import BusinessLayer.MenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EditCompController {


    private IRestaurantProcessing m_model;
    private EditCompGUI m_view;

    EditCompController(IRestaurantProcessing model, EditCompGUI view) {
        m_model = model;
        m_view = view;

        view.addOkListener(new OkListener());
    }

    class OkListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (!m_view.getNume().isEmpty() && (!m_view.getNumeNou().isEmpty() || !m_view.getNumeAdaugat().isEmpty() || !m_view.getNumeSters().isEmpty())) {
                String nume = m_view.getNume();
                String numeNou = m_view.getNumeNou();
                String numeSters[] = m_view.getNumeSters().split(",");
                String numeAdaugat[] = m_view.getNumeAdaugat().split(",");
                ArrayList<MenuItem> toRemove = new ArrayList<MenuItem>();
                ArrayList<MenuItem> toAdd = new ArrayList<MenuItem>();
                CompositeProduct produs = new CompositeProduct(nume);
                CompositeProduct produsNou = new CompositeProduct(nume);
                for (MenuItem m : m_model.getMenuItems()) {
                    if (m.getName().equals(nume) && (m.getClass().getName()).equals(m.getClass().getPackageName()+".CompositeProduct")) {
                        produs = (CompositeProduct) m;
                        if (!numeNou.isEmpty()) {
                            m.setName(numeNou);
                        } else {
                            m.setName(nume);
                        }
                        for (String sters : numeSters)
                            for (MenuItem product : ((CompositeProduct) m).getProductList()) {
                                if (sters.equals(product.getName())) {
                                    toRemove.add(product);
                                }
                            }
                        ((CompositeProduct) m).getProductList().removeAll(toRemove);
                        for (String adaugat : numeAdaugat)
                            for (MenuItem product : m_model.getMenuItems()) {
                                if (adaugat.equals(product.getName())) {
                                    toAdd.add(product);
                                }
                            }
                        ((CompositeProduct) m).getProductList().addAll(toAdd);
                        produsNou = (CompositeProduct) m;
                    }
                }
                m_model.editMenuItem(produs, produsNou);
                m_view.dispose();
            }
        }
    }
}
