package PresentationLayer;

import BusinessLayer.IRestaurantProcessing;
import BusinessLayer.MenuItem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdministratorController {


    private IRestaurantProcessing m_model;
    private AdministratorGUI m_view;
    private JFrame f;
    private CreateBaseGUI baseGui;
    private CreateCompGUI compGui;
    private DeleteGUI deleteGui;
    private EditBaseGUI editBaseGui;
    private EditCompGUI editCompGui;

    private boolean base = true;

    AdministratorController(IRestaurantProcessing model, AdministratorGUI view) {
        m_model = model;
        m_view = view;

        view.addShowListener(new ShowListener());
        view.addCreateListener(new CreateListener());
        view.addBaseListener(new BaseListener());
        view.addCompositeListener(new CompositeListener());
        view.addCloseListener(new CloseListener());
        view.addDeleteListener(new DeleteListener());
        view.addEditListener(new EditListener());

    }

    class ShowListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFrame frame = new JFrame("Lista Menu Items");
            if (f != null)
                f.dispose();
            f = frame;
            ArrayList<MenuItem> items = m_model.getMenuItems();
            String data[][] = new String[items.size()][2];

            int c = 0;
            for (MenuItem i: items) {
                data[c][0] = i.getName();
                data[c][1] = i.computePrice()+"";
                c++;
            }
            String column[]= new String[]{"NUME","PRET"};
            final JTable jt = new JTable(data,column);
            f.add(new JScrollPane(jt));
            f.setLocationRelativeTo(null);
            f.setVisible(true);
            f.pack();
        }
    }

    class CreateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (base) {
                CreateBaseGUI create = new CreateBaseGUI(m_model);
                if (baseGui != null)
                    baseGui.dispose();
                baseGui = create;
                CreateBaseController controller = new CreateBaseController(m_model, baseGui);
                baseGui.setLocationRelativeTo(null);
                baseGui.setVisible(true);
                baseGui.setResizable(false);
            } else {
                CreateCompGUI create = new CreateCompGUI(m_model);
                if (compGui != null)
                    compGui.dispose();
                compGui = create;
                CreateCompController controller = new CreateCompController(m_model, compGui);
                compGui.setLocationRelativeTo(null);
                compGui.setVisible(true);
                compGui.setResizable(false);
            }

        }
    }

    class DeleteListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            DeleteGUI delete = new DeleteGUI(m_model);
            if (deleteGui != null)
                deleteGui.dispose();
            deleteGui = delete;
            DeleteController controller = new DeleteController(m_model, deleteGui);
            deleteGui.setLocationRelativeTo(null);
            deleteGui.setVisible(true);
            deleteGui.setResizable(false);

        }
    }

    class EditListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (base) {
                EditBaseGUI edit = new EditBaseGUI(m_model);
                if (editBaseGui != null)
                    editBaseGui.dispose();
                editBaseGui = edit;
                EditBaseController controller = new EditBaseController(m_model, editBaseGui);
                editBaseGui.setLocationRelativeTo(null);
                editBaseGui.setVisible(true);
                editBaseGui.setResizable(false);
            } else {
                EditCompGUI delete = new EditCompGUI(m_model);
                if (editCompGui != null)
                    editCompGui.dispose();
                editCompGui = delete;
                EditCompController controller = new EditCompController(m_model, editCompGui);
                editCompGui.setLocationRelativeTo(null);
                editCompGui.setVisible(true);
                editCompGui.setResizable(false);

            }
        }
    }

    class BaseListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            base = true;
        }
    }
    class CompositeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            base = false;
        }
    }

    class CloseListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            m_view.dispose();
        }
    }


}
