package view;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class BathingPanel extends JPanel {

    private JPanel topPanel = new JPanel();
    private JPanel bathroomPanelContainer = new JPanel();

    private JCheckBox cbHairDryer = new JCheckBox("Hair Dryer");
    private JCheckBox cbShampoo = new JCheckBox("Shampoo");
    private JCheckBox cbToiletPaper = new JCheckBox("Toilet Paper");

    private JButton btnAddBathroom = new JButton("Add Bathroom");

    private class BathroomPanel extends JPanel {

        private JCheckBox cbShared = new JCheckBox("Shared");
        private JCheckBox cbToilet = new JCheckBox("Toilet");
        private JCheckBox cbBath = new JCheckBox("Bath");
        private JCheckBox cbShower = new JCheckBox("Shower");
        private JButton btnRemove = new JButton("Remove");

        public BathroomPanel(BathingPanel bathingPanel) {
            btnRemove.addActionListener(e -> bathingPanel.removeBathroomPanel(this));
            setLayout(new FlowLayout(FlowLayout.LEFT, 8, 8));
            add(cbShared);
            add(cbToilet);
            add(cbBath);
            add(cbShower);
            add(btnRemove);
        }
    }

    private List<BathroomPanel> bathroomPanels = new ArrayList<>();

    public BathingPanel() {
        topPanel.setLayout(new GridBagLayout());
        topPanel.add(new JLabel("Bathing"), new GridBagConstraints(0, 0, GridBagConstraints.REMAINDER, 1, 1.0, 1.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(4, 4, 4, 4), 0, 0));
        topPanel.add(cbHairDryer, new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(4, 4, 4, 4), 0, 0));
        topPanel.add(cbShampoo, new GridBagConstraints(1, 1, 1, 1, 1.0, 1.0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(4, 4, 4, 4), 0, 0));
        topPanel.add(cbToiletPaper, new GridBagConstraints(2, 1, 1, 1, 1.0, 1.0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(4, 4, 4, 4), 0, 0));
        topPanel.add(btnAddBathroom, new GridBagConstraints(3, 1, 1, 1, 1.0, 1.0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(4, 4, 4, 4), 0, 0));

        btnAddBathroom.addActionListener(e -> {
            BathroomPanel newBathroomPanel = new BathroomPanel(this);
            bathroomPanelContainer.add(newBathroomPanel);
            bathroomPanelContainer.revalidate();
            bathroomPanelContainer.repaint();
        });

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(bathroomPanelContainer, BorderLayout.CENTER);
    }

    public void removeBathroomPanel(BathroomPanel bathroomPanel) {
        bathroomPanels.remove(bathroomPanel);
        bathroomPanelContainer.remove(bathroomPanel);
        bathroomPanelContainer.revalidate();
        bathroomPanelContainer.repaint();
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            BathingPanel panel = new BathingPanel();
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setContentPane(panel);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

}
