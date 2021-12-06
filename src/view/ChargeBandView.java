package view;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ChargeBandView extends JDialog {

    private JTextField tfEmail = new JTextField();
    private JTextField tfTitle = new JTextField();
    private JTextField tfForeName = new JTextField();
    private JTextField tfSurName = new JTextField();
    private JTextField tfMobileNumber = new JTextField();
    private JTextField tfPassword = new JTextField();

    private JButton btnBack = new JButton("Go Back");
    private JButton btnNext = new JButton("Next");

    public ChargeBandView(int numBands, PersonInfo personInfo, int bedroomNum, int bathroomNum, AddressInfo addressInfo) {
        setSize(1000, 800);
        tfEmail.setColumns(10);
        tfTitle.setColumns(10);
        tfForeName.setColumns(10);
        tfSurName.setColumns(10);
        tfPassword.setColumns(10);
        tfMobileNumber.setColumns(10);

        Insets insets = new Insets(4, 4, 4, 4);
        JPanel userDetailsPanel = new JPanel();
        userDetailsPanel.setLayout(new GridBagLayout());

        int y = 0;
        userDetailsPanel.add(new JLabel("Charge Bands", SwingConstants.CENTER), new GridBagConstraints(0, y, GridBagConstraints.REMAINDER, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        userDetailsPanel.add(new JLabel("Start Date"), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        userDetailsPanel.add(new JLabel("End Date"), new GridBagConstraints(1, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        userDetailsPanel.add(new JLabel("Price per Night"), new GridBagConstraints(2, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        userDetailsPanel.add(new JLabel("Service Charge"), new GridBagConstraints(3, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        userDetailsPanel.add(new JLabel("Cleaning Charge"), new GridBagConstraints(4, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;

        TextField[] charges = new TextField[numBands*5];
        for (int i = 0; i < numBands*5; i+=5) {
            TextField startDate = new TextField();
            TextField endDate = new TextField();
            TextField priceNight = new TextField();
            TextField priceService = new TextField();
            TextField priceCleaning = new TextField();
            charges[i] = startDate;
            charges[i+1] = endDate;
            charges[i+2] = priceNight;
            charges[i+3] = priceService;
            charges[i+4] = priceCleaning;

            userDetailsPanel.add(charges[i], new GridBagConstraints(0, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            userDetailsPanel.add(charges[i+1], new GridBagConstraints(1, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            userDetailsPanel.add(charges[i+2], new GridBagConstraints(2, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            userDetailsPanel.add(charges[i+3], new GridBagConstraints(3, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            userDetailsPanel.add(charges[i+4], new GridBagConstraints(4, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            y++;
        }

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.add(userDetailsPanel, new GridBagConstraints(0, 0, GridBagConstraints.REMAINDER, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
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

        btnBack.addActionListener(e -> {
            new HostView(personInfo).setVisible(true);
            this.dispose();
        });

        btnNext.addActionListener(e -> {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            List<ChargeBandInfo> chargeBands = new ArrayList<>();
            try {
                for (int i = 0; i < numBands*5; i+=5) {
                    String startDateTF = charges[i].getText();
                    String endDateTF = charges[i+1].getText();

                    format.setLenient(false);
                    format.parse(startDateTF);
                    format.parse(endDateTF);
                    Date startDate = Date.valueOf(startDateTF);
                    Date endDate = Date.valueOf(endDateTF);
                    double priceNight = Double.parseDouble(charges[i+2].getText());
                    double priceService = Double.parseDouble(charges[i+3].getText());
                    double priceCleaning = Double.parseDouble(charges[i+4].getText());
                    chargeBands.add(new ChargeBandInfo(
                            startDate,
                            endDate,
                            priceNight,
                            priceService,
                            priceCleaning
                    ));
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Please write valid dates in YYYY-MM-DD format and valid numbers for charge values!", "Error!", JOptionPane.DEFAULT_OPTION);
            }
            boolean invalid = false;
            Date prevDate = null;
            for (ChargeBandInfo band : chargeBands) {
                if (band.getStartDate().after(band.getEndDate())) {
                    invalid = true;
                    JOptionPane.showMessageDialog(null, "Make sure end date is after start date.", "Error!", JOptionPane.DEFAULT_OPTION);
                }
                else {
                    if (prevDate != null) {
                        Calendar c = Calendar.getInstance();
                        c.setTime(prevDate);
                        c.add(Calendar.HOUR,24);
                        java.sql.Date sqlDate = new java.sql.Date(c.getTimeInMillis());
                        if (!sqlDate.equals(band.getStartDate())) {
                            JOptionPane.showMessageDialog(null, "Make sure dates cover all dates continuously. Set next start date as previous end date plus one day.", "Error!", JOptionPane.DEFAULT_OPTION);
                            invalid = true;
                        }
                    }
                }
                prevDate = band.getEndDate();
            }
            if (prevDate != null && chargeBands.size() == numBands) {
                if (!prevDate.equals(Date.valueOf("2022-12-31"))) {
                    invalid = true;
                    JOptionPane.showMessageDialog(null, "Set last date as 2022-12-31", "Error!", JOptionPane.DEFAULT_OPTION);
                }
            }
            else {
                invalid = true;
            }
            if (!invalid) {
                new PropertyEditorView(bedroomNum, bathroomNum, addressInfo, personInfo, chargeBands).setVisible(true);
                this.dispose();
            }
        });
    }
}
