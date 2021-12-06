package view;

import model.AddressInfo;
import model.DBAccess;
import model.PersonInfo;
import model.Property;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class PropertyAddressView extends JDialog {


    private JTextField tfHouseName = new JTextField();
    private JTextField tfStreetName = new JTextField();
    private JTextField tfPlaceName = new JTextField();
    private JTextField tfPostCode = new JTextField();

    private JTextField tfBedroomNum = new JTextField();
    private JTextField tfBathroomNum = new JTextField();
    private JTextField tfChargeBandNum = new JTextField();

    private JButton btnBack = new JButton("Go Back");
    private JButton btnNext = new JButton("Next");

    public PropertyAddressView(PersonInfo personInfo) {

        Insets insets = new Insets(4, 4, 4, 4);
        tfHouseName.setColumns(10);
        tfStreetName.setColumns(10);
        tfPlaceName.setColumns(10);
        tfPostCode.setColumns(10);

        JPanel addressPanel = new JPanel();
        addressPanel.setLayout(new GridBagLayout());

        int y = 0;
        addressPanel.add(new JLabel("Address Details", SwingConstants.CENTER), new GridBagConstraints(0, y, GridBagConstraints.REMAINDER, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        addressPanel.add(new JLabel("House Name"), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        addressPanel.add(tfHouseName, new GridBagConstraints(1, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        addressPanel.add(new JLabel("Street Name"), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        addressPanel.add(tfStreetName, new GridBagConstraints(1, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        addressPanel.add(new JLabel("Place Name"), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        addressPanel.add(tfPlaceName, new GridBagConstraints(1, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        addressPanel.add(new JLabel("Post Code"), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        addressPanel.add(tfPostCode, new GridBagConstraints(1, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));

        JPanel rolePanel = new JPanel();
        rolePanel.setLayout(new GridBagLayout());
        rolePanel.add(new JLabel("Room Numbers", SwingConstants.CENTER), new GridBagConstraints(0, 0, GridBagConstraints.REMAINDER, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        rolePanel.add(new JLabel("Number of Bedrooms"), new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        rolePanel.add(tfBedroomNum, new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        rolePanel.add(new JLabel("Number of Bathrooms"), new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        rolePanel.add(tfBathroomNum, new GridBagConstraints(1, 2, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        rolePanel.add(new JLabel("Charge Bands", SwingConstants.CENTER), new GridBagConstraints(0, 3, GridBagConstraints.REMAINDER, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        rolePanel.add(new JLabel("Number of Charge Bands"), new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        rolePanel.add(tfChargeBandNum, new GridBagConstraints(1, 4, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets, 0, 0));


        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.add(addressPanel, new GridBagConstraints(0, 0, GridBagConstraints.REMAINDER, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        centerPanel.add(rolePanel, new GridBagConstraints(0, 1, GridBagConstraints.REMAINDER, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 8));
        bottomPanel.add(btnBack);
        bottomPanel.add(btnNext);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(centerPanel, BorderLayout.CENTER);
        contentPanel.add(bottomPanel, BorderLayout.SOUTH);
        setContentPane(contentPanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        btnNext.addActionListener(e -> {
            // Address
            String houseName = tfHouseName.getText().trim();
            String streetName = tfStreetName.getText().trim();
            String placeName = tfPlaceName.getText().trim();
            String postcode = tfPostCode.getText().trim();

            if (houseName.length() != 0 || streetName.length() != 0 || placeName.length() != 0 || postcode.length() != 0) {
                boolean exists = true;
                try {
                    Connection conn = DBAccess.connect();
                    exists = Property.checkPropertyExists(conn, houseName, postcode);
                } finally {
                    DBAccess.disconnect();
                }
                if (!exists) {
                    try {
                        int bedroomNum = Integer.parseInt(tfBedroomNum.getText().trim());
                        int bathroomNum = Integer.parseInt(tfBathroomNum.getText().trim());
                        int numBands = Integer.parseInt(tfChargeBandNum.getText().trim());
                        if (bedroomNum > 0 && bathroomNum > 0) {
                            AddressInfo addressInfo = new AddressInfo(
                                    houseName,
                                    streetName,
                                    placeName,
                                    postcode
                            );
                            new ChargeBandView(numBands, personInfo, bedroomNum, bathroomNum, addressInfo).setVisible(true);
                            this.dispose();

                        } else {
                            JOptionPane.showMessageDialog(null, "Enter an integer greater than 0 for number of bedrooms / bathrooms / charge bands.", "Error!", JOptionPane.DEFAULT_OPTION);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Enter an integer greater than 0 for number of bedrooms / bathrooms / charge bands.", "Error!", JOptionPane.DEFAULT_OPTION);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Property already exists at this address.", "Error!", JOptionPane.DEFAULT_OPTION);
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Required field left blank.", "Error!", JOptionPane.DEFAULT_OPTION);
            }
        });

        btnBack.addActionListener(e -> {
            new HostView(personInfo).setVisible(true);
            this.dispose();
        });
    }
}
