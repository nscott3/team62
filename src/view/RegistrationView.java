package view;

import model.Person;
import model.PersonInfo;
import model.Address;
import model.AddressInfo;
import model.DBAccess;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class RegistrationView extends JDialog {

    private JTextField tfEmail = new JTextField();
    private JTextField tfTitle = new JTextField();
    private JTextField tfForeName = new JTextField();
    private JTextField tfSurName = new JTextField();
    private JTextField tfMobileNumber = new JTextField();
    private JTextField tfPassword = new JTextField();

    private JTextField tfHouseName = new JTextField();
    private JTextField tfStreetName = new JTextField();
    private JTextField tfPlaceName = new JTextField();
    private JTextField tfPostCode = new JTextField();

    private JTextField tfGuestName = new JTextField();
    private JTextField tfHostName = new JTextField();
    private JCheckBox cbGuest = new JCheckBox("Guest");
    private JCheckBox cbHost = new JCheckBox("Host");

    private JButton btnRegister = new JButton("Register");

    public RegistrationView() {

        tfEmail.setColumns(10);
        tfForeName.setColumns(10);
        tfSurName.setColumns(10);
        tfPassword.setColumns(10);
        tfMobileNumber.setColumns(10);

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
        y++;
        userDetailsPanel.add(new JLabel("Password"), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        userDetailsPanel.add(tfPassword, new GridBagConstraints(1, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));

        tfHouseName.setColumns(10);
        tfStreetName.setColumns(10);
        tfPlaceName.setColumns(10);
        tfPostCode.setColumns(10);

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

        JPanel rolePanel = new JPanel();
        rolePanel.setLayout(new GridBagLayout());
        rolePanel.add(new JLabel("Role", SwingConstants.CENTER), new GridBagConstraints(0, 0, GridBagConstraints.REMAINDER, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        rolePanel.add(cbGuest, new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        rolePanel.add(new JLabel("Guest Name"), new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        rolePanel.add(tfGuestName, new GridBagConstraints(2, 1, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        rolePanel.add(cbHost, new GridBagConstraints(0, 2, 1, 1, 1.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        rolePanel.add(new JLabel("Host Name"), new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        rolePanel.add(tfHostName, new GridBagConstraints(2, 2, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets, 0, 0));


        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.add(userDetailsPanel, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        centerPanel.add(addressPanel, new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        centerPanel.add(rolePanel, new GridBagConstraints(0, 1, GridBagConstraints.REMAINDER, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 8));
        bottomPanel.add(btnRegister);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(centerPanel, BorderLayout.CENTER);
        contentPanel.add(bottomPanel, BorderLayout.SOUTH);
        setContentPane(contentPanel);

        pack();
        setVisible(true);

        btnRegister.addActionListener(e -> {
            try {
                // Person
                String email = tfEmail.getText();
                String title = tfTitle.getText();
                String forename = tfForeName.getText();
                String surname = tfSurName.getText();
                String mobileNumber = tfMobileNumber.getText();
                String password = tfPassword.getText();
                // Address
                String houseName = tfHouseName.getText();
                String streetName = tfStreetName.getText();
                String placeName = tfPlaceName.getText();
                String postcode = tfPostCode.getText();
                // Role
                boolean guest = cbGuest.isSelected();
                String guestName = tfGuestName.getText();
                boolean host = cbHost.isSelected();
                String hostName = tfHostName.getText();


                if (email.length() == 0 || title.length() == 0 || forename.length() == 0 || surname.length() == 0 ||
                        mobileNumber.length() == 0 || password.length() == 0 || houseName.length() == 0 || streetName.length() == 0 ||
                        placeName.length() == 0 || postcode.length() == 0 || (guest && guestName.length() == 0) || (host && hostName.length() == 0)) {
                    JOptionPane.showMessageDialog(null, "Required field left blank.", "Error!", JOptionPane.DEFAULT_OPTION);
                } else if (!guest && !host) {
                    JOptionPane.showMessageDialog(null, "Select Guest or Host or both.", "Error!", JOptionPane.DEFAULT_OPTION);
                } else {
                    Connection conn = DBAccess.connect();
                    AddressInfo address = new AddressInfo(houseName, streetName, placeName, postcode);
                    PersonInfo person = new PersonInfo(title, forename, surname, email, mobileNumber, password);
                    if (!Address.checkAddressExists(conn, address)) {
                        Address.addAddress(conn, address);
                    }
                    if (!Person.checkUserExists(conn, person.getEmail())) {
                        Person.register(conn, person, address);
                    } else {
                        JOptionPane.showMessageDialog(null, "Email already registered.", "Error!", JOptionPane.DEFAULT_OPTION);
                    }
                }
            } finally {
                DBAccess.disconnect();
            }
        });
    }
}
