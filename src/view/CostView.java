package view;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class CostView extends JDialog {

    private JTextField tfEmail = new JTextField();
    private JTextField tfTitle = new JTextField();
    private JTextField tfForeName = new JTextField();
    private JTextField tfSurName = new JTextField();
    private JTextField tfMobileNumber = new JTextField();
    private JTextField tfPassword = new JTextField();

    private JButton btnBack = new JButton("Go Back");
    private JButton btnNext = new JButton("Next");

    public CostView(PersonInfo personInfo, GuestInfo guestInfo, PropertyInfo propertyInfo, Date startDate, Date endDate) {
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
        userDetailsPanel.add(new JLabel("Cost Breakdown", SwingConstants.CENTER), new GridBagConstraints(0, y, GridBagConstraints.REMAINDER, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        userDetailsPanel.add(new JLabel("Start Date"), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        userDetailsPanel.add(new JLabel("End Date"), new GridBagConstraints(1, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        userDetailsPanel.add(new JLabel("Price per Night"), new GridBagConstraints(2, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        userDetailsPanel.add(new JLabel("Service Charge"), new GridBagConstraints(3, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        userDetailsPanel.add(new JLabel("Cleaning Charge"), new GridBagConstraints(4, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        ArrayList<ChargeBandInfo> bands;
        try {
            Connection conn = DBAccess.connect();
            bands = ChargeBand.getChargeBands(conn, propertyInfo.getPropertyID());
        } finally {
            DBAccess.disconnect();
        }

        for (int i = 0; i < bands.size(); i++) {

            userDetailsPanel.add(new JLabel(bands.get(i).getStartDate().toString()), new GridBagConstraints(0, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            userDetailsPanel.add(new JLabel(bands.get(i).getEndDate().toString()), new GridBagConstraints(1, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            userDetailsPanel.add(new JLabel(String.valueOf(bands.get(i).getPricePerNight())), new GridBagConstraints(2, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            userDetailsPanel.add(new JLabel(String.valueOf(bands.get(i).getServiceCharge())), new GridBagConstraints(3, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            userDetailsPanel.add(new JLabel(String.valueOf(bands.get(i).getCleaningCharge())), new GridBagConstraints(4, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            y++;
        }
        double priceNights = 0;
        double priceService = 0;
        double priceCleaning = 0;
        Date date = startDate;
        if (bands.size() != 0) {
            while (!date.equals(endDate)) {
                for (ChargeBandInfo band : bands) {
                    if (!(date.before(band.getStartDate()) || date.after(band.getEndDate()))) {
                        priceNights += band.getPricePerNight();
                        Calendar c = Calendar.getInstance();
                        c.setTime(date);
                        c.add(Calendar.HOUR, 24);
                        date = new Date(c.getTimeInMillis());
                    }
                }
            }
        }
        for (ChargeBandInfo band : bands) {
            if (!(endDate.before(band.getStartDate()) || endDate.after(band.getEndDate()))) {
                priceService = band.getServiceCharge();
                priceCleaning = band.getCleaningCharge();
            }
        }
        userDetailsPanel.add(new JLabel("Start Date"), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        userDetailsPanel.add(new JLabel("End Date"), new GridBagConstraints(1, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        userDetailsPanel.add(new JLabel("Total Nightly Charge"), new GridBagConstraints(2, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        userDetailsPanel.add(new JLabel("Service Charge"), new GridBagConstraints(3, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        userDetailsPanel.add(new JLabel("Cleaning Charge"), new GridBagConstraints(4, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        String pattern = "YYYY-MM-dd";
        DateFormat df = new SimpleDateFormat(pattern);

        userDetailsPanel.add(new JLabel(df.format(startDate)), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        userDetailsPanel.add(new JLabel(df.format(endDate)), new GridBagConstraints(1, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        userDetailsPanel.add(new JLabel(String.valueOf(priceNights)), new GridBagConstraints(2, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        userDetailsPanel.add(new JLabel(String.valueOf(priceService)), new GridBagConstraints(3, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        userDetailsPanel.add(new JLabel(String.valueOf(priceCleaning)), new GridBagConstraints(4, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));

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
            new SpecificInformationView(personInfo, guestInfo, propertyInfo, df.format(startDate), df.format(endDate)).setVisible(true);
            this.dispose();
        });
        btnNext.addActionListener(e -> {
            try {
                Connection conn = DBAccess.connect();
                boolean available = false;
                available = !Property.checkAvailability(conn, propertyInfo.getPropertyID(), startDate, endDate);
                if (available) {
                    BookingInfo bookingInfo = new BookingInfo(
                            startDate,
                            endDate,
                            false,
                            false,
                            propertyInfo.getPropertyID(),
                            guestInfo.getGuestID()
                    );
                    Booking.registerBooking(conn, bookingInfo);
                    JOptionPane.showMessageDialog(null, "Submitted booking.", "Success!", JOptionPane.DEFAULT_OPTION);
                    new GuestView(personInfo, guestInfo).setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Cannot submit due to overlapping booking.", "Error!", JOptionPane.DEFAULT_OPTION);
                }
            } finally {
                DBAccess.disconnect();
            }
        });

    }
}
