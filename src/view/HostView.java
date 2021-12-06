package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.ArrayList;

import model.*;
import model.Property;

public class HostView extends JFrame{
    private JTable table;

    private static class JTableButtonMouseListener extends MouseAdapter {
        private final JTable table;

        public JTableButtonMouseListener(JTable table) {
            this.table = table;
        }

        public void mouseClicked(MouseEvent e) {
            int column = table.getColumnModel().getColumnIndexAtX(e.getX()); // get the column of the button
            int row = e.getY()/table.getRowHeight(); //get the row of the button

            // Checking the row or column is valid or not
            if (row < table.getRowCount() && row >= 0 && column < table.getColumnCount() && column >= 0) {
                Object value = table.getValueAt(row, column);

                if (value instanceof InfoButton) {
                    /*perform a click event*/
                    ((InfoButton)value).jb.doClick();
                }
            }
        }
    }

    public HostView(PersonInfo personInfo) {
        setResizable(false);
        setPreferredSize(new Dimension(1200, 720/12*9));
        setSize(1200, 720/12*9);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("HomeBreaks Plc");

        JLabel lblTitle = new JLabel("  My Bookings");
        lblTitle.setBounds(35, 11, 270, 60);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 28));
        getContentPane().add("North",lblTitle);

        Object[] tableHeader = {"Property Name", "Start Date", "End Date", "Status", "Accept", "Reject", "Guest's Details"};
        Object[][] tableContent;
        Object[][] guestDetails;
        try {
            Connection conn = DBAccess.connect();
            int i = 0;
            ArrayList<BookingInfo> bookings = Booking.getHostsBookings(conn, personInfo.getEmail());
            tableContent = new Object[bookings.size()][tableHeader.length];
            guestDetails = new Object[bookings.size()][2];
            for (BookingInfo booking : bookings) {
                Object[] bookingData = new Object[tableHeader.length];
                Object[] guestData = new Object[2];
                PersonInfo guest = Person.getPerson(conn, booking.getGuestID());
                AddressInfo guestAddress = Person.getAddress(conn, booking.getGuestID());
                guestData[0] = guest;
                guestData[1] = guestAddress;
                guestDetails[i] = guestData;

                bookingData[0] = Property.getPropertyName(conn, booking.getPropertyID());
                bookingData[1] = booking.getStartDate();
                bookingData[2] = booking.getEndDate();
                bookingData[3] = booking.getIsAccepted() ? "Accepted" : (booking.getIsRejected() ? "Rejected" : "Pending");
                bookingData[4] = booking.getIsAccepted() ? null : new InfoButton(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        try {
                            Connection conn = DBAccess.connect();
                            boolean available = false;
                            available = !Property.checkAvailability(conn, booking.getPropertyID(), booking.getStartDate(), booking.getEndDate());
                            if (available) {
                                Booking.acceptBooking(conn, booking);
                                JOptionPane.showMessageDialog(null, "Accepted booking.", "Success!", JOptionPane.DEFAULT_OPTION);
                            }
                            else {
                                JOptionPane.showMessageDialog(null, "Cannot accept overlapping booking.", "Error!", JOptionPane.DEFAULT_OPTION);
                            }
                        } finally {
                            DBAccess.disconnect();
                        }
                        new HostView(personInfo);
                        dispose();
                    }});
                bookingData[5] = booking.getIsAccepted() ? new InfoButton(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            Connection conn = DBAccess.connect();
                            Booking.rejectBooking(conn, booking);
                        } finally {
                            DBAccess.disconnect();
                        }
                        JOptionPane.showMessageDialog(null, "Rejected booking.", "Success!", JOptionPane.DEFAULT_OPTION);
                        new HostView(personInfo);
                        dispose();
                    }}) : null;
                bookingData[6] = booking.getIsAccepted() ? returnDetailsButton(i, guestDetails, personInfo) : null;
                tableContent[i] = bookingData;

                i++;
            }

        } finally {
            DBAccess.disconnect();
        }
        table = new JTable(tableContent, tableHeader) {
            private static final long serialVersionUID = 1L;
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.addMouseListener(new JTableButtonMouseListener(table));

        InfoButtonCellRenderer contactRenderer = new InfoButtonCellRenderer("Guest's Details");
        InfoButtonCellRenderer acceptRenderer = new InfoButtonCellRenderer("Accept");
        InfoButtonCellRenderer rejectRenderer = new InfoButtonCellRenderer("Reject");

        table.getColumn("Guest's Details").setCellRenderer(contactRenderer);
        table.getColumn("Accept").setCellRenderer(acceptRenderer);
        table.getColumn("Reject").setCellRenderer(rejectRenderer);
        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        JScrollPane tableScrollpane = new JScrollPane(table);
        tableScrollpane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        getContentPane().add("Center",tableScrollpane);

        JPanel bottomPanel = new JPanel();
        JButton btnHome = new JButton("Home");
        JButton btnSubmit = new JButton("Register Property");
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 8));
        bottomPanel.add(btnHome);
        bottomPanel.add(btnSubmit);

        getContentPane().add(bottomPanel, BorderLayout.SOUTH);

        btnHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Log out!");
                new MainView().setVisible(true);
                dispose();
            }
        });

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PropertyAddressView(personInfo).setVisible(true);
                dispose();
            }
        });

        pack();
        setVisible(true);
    }

    private InfoButton returnDetailsButton(int i, Object[][] guestDetails, PersonInfo personInfo) {
        InfoButton btn = new InfoButton();
        btn.setActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ConfidentialDetailsGuest((PersonInfo) guestDetails[i][0], (AddressInfo) guestDetails[i][1], personInfo).setVisible(true);
                dispose();
            }});
        return btn;
    }
}
