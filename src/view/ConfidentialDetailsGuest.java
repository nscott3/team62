package view;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class ConfidentialDetailsGuest extends JDialog {

    private JTextField tfEmail = new JTextField();
    private JTextField tfTitle = new JTextField();
    private JTextField tfForeName = new JTextField();
    private JTextField tfSurName = new JTextField();
    private JTextField tfMobileNumber = new JTextField();

    private JTextField tfHouseName = new JTextField();
    private JTextField tfStreetName = new JTextField();
    private JTextField tfPlaceName = new JTextField();
    private JTextField tfPostCode = new JTextField();

    private JButton btnBack = new JButton("Go Back");

    public ConfidentialDetailsGuest(PersonInfo guest, AddressInfo address, PersonInfo person) {

        tfEmail.setColumns(10);
        tfTitle.setColumns(10);
        tfForeName.setColumns(10);
        tfSurName.setColumns(10);
        tfMobileNumber.setColumns(10);

        tfEmail.setText(guest.getEmail());
        tfTitle.setText(guest.getTitle());
        tfForeName.setText(guest.getForename());
        tfSurName.setText(guest.getSurname());
        tfMobileNumber.setText(guest.getMobileNumber());

        Insets insets = new Insets(4, 4, 4, 4);
        JPanel userDetailsPanel = new JPanel();
        userDetailsPanel.setLayout(new GridBagLayout());

        int y = 0;
        userDetailsPanel.add(new JLabel("Personal Details", SwingConstants.CENTER), new GridBagConstraints(0, y, GridBagConstraints.REMAINDER, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        userDetailsPanel.add(new JLabel("Email"), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        userDetailsPanel.add(tfEmail, new GridBagConstraints(1, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        userDetailsPanel.add(new JLabel("Title"), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        userDetailsPanel.add(tfTitle, new GridBagConstraints(1, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        userDetailsPanel.add(new JLabel("Forename"), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        userDetailsPanel.add(tfForeName, new GridBagConstraints(1, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        userDetailsPanel.add(new JLabel("Surname"), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        userDetailsPanel.add(tfSurName, new GridBagConstraints(1, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        userDetailsPanel.add(new JLabel("Mobile Number"), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        userDetailsPanel.add(tfMobileNumber, new GridBagConstraints(1, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));

        tfHouseName.setColumns(10);
        tfStreetName.setColumns(10);
        tfPlaceName.setColumns(10);
        tfPostCode.setColumns(10);

        tfHouseName.setText(address.getHouseName());
        tfStreetName.setText(address.getStreetName());
        tfPlaceName.setText(address.getPlaceName());
        tfPostCode.setText(address.getPostcode());

        JPanel addressPanel = new JPanel();
        addressPanel.setLayout(new GridBagLayout());

        y = 0;
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


        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.add(userDetailsPanel, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        centerPanel.add(addressPanel, new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 8));
        bottomPanel.add(btnBack);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(centerPanel, BorderLayout.CENTER);
        contentPanel.add(bottomPanel, BorderLayout.SOUTH);
        setContentPane(contentPanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        btnBack.addActionListener(e -> {
            new HostView(person).setVisible(true);
            this.dispose();
        });


    }
}
