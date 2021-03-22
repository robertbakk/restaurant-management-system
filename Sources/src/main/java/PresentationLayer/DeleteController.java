package PresentationLayer;

import BusinessLayer.CompositeProduct;
import BusinessLayer.IRestaurantProcessing;
import BusinessLayer.MenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DeleteController {


    private IRestaurantProcessing m_model;
    private DeleteGUI m_view;

    DeleteController(IRestaurantProcessing model, DeleteGUI view) {
        m_model = model;
        m_view = view;

        view.addOkListener(new OkListener());
    }


    class OkListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String nume = m_view.getNume();
            if (!nume.isEmpty()) {
                ArrayList<MenuItem> toRemove = new ArrayList<MenuItem>();
                for (MenuItem m : m_model.getMenuItems()) {
                    if (m.getName().equals(nume))
                        toRemove.add(m);
                }
                for (MenuItem m : m_model.getMenuItems()) {
                    if (m.getClass().getName().equals(m.getClass().getPackageName() + ".CompositeProduct")) {
                        for (MenuItem a : ((CompositeProduct) m).getProductList())
                            if (a.getName().equals(nume))
                                toRemove.add(m);
                    }
                }
                m_model.getMenuItems().removeAll(toRemove);
                for (MenuItem m : toRemove)
                    m_model.deleteMenuItem(m);
                m_view.dispose();
            }
        }
    }

}
