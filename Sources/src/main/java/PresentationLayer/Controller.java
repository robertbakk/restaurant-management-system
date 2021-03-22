package PresentationLayer;

import BusinessLayer.IRestaurantProcessing;
import BusinessLayer.Restaurant;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {


    private IRestaurantProcessing m_model;
    private GUI m_view;
    private AdministratorGUI administrator;
    private WaiterGUI waiter;
    private ChefGUI chef;

    public Controller(IRestaurantProcessing model, GUI view) {
        m_model = model;
        m_view = view;

        view.addAdministratorListener(new AdministratorListener());
        view.addWaiterListener(new WaiterListener());
        view.addChefListener(new ChefListener());
        view.addCloseListener(new CloseListener());
    }

    class AdministratorListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (administrator != null)
                administrator.setVisible(false);
            if (waiter != null)
                waiter.setVisible(false);
            administrator = new AdministratorGUI(m_model);
            AdministratorController controller = new AdministratorController(m_model, administrator);
            administrator.setLocationRelativeTo(null);
            administrator.setVisible(true);
            administrator.setResizable(false);
        }
    }
    class WaiterListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (administrator != null)
                administrator.setVisible(false);
            if (waiter != null)
                waiter.setVisible(false);
            waiter = new WaiterGUI(m_model);
            WaiterController controller = new WaiterController(m_model, waiter);
            waiter.setLocationRelativeTo(null);
            waiter.setVisible(true);
            waiter.setResizable(false);
        }
    }
    class ChefListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            chef = new ChefGUI(m_model);
            ((Restaurant)m_model).addObserver(chef);
            chef.setLocationRelativeTo(null);
            chef.setVisible(true);
            chef.setResizable(false);;
        }
    }

    class CloseListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            m_view.dispose();
        }
    }


}
