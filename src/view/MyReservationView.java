package view;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.ArrayList;

import model.*;
import model.Property;

public class MyReservationView extends JFrame{
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

	public MyReservationView(PersonInfo personInfo, GuestInfo guestInfo) {
		setResizable(false);
	    setPreferredSize(new Dimension(1200, 720/12*9));
	    setSize(1200, 720/12*9);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("HomeBreaks Plc");
		
		JLabel lblTitle = new JLabel("  My Reservation");
		lblTitle.setBounds(35, 11, 270, 60);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 28));
		getContentPane().add("North",lblTitle);
		
		Object[] tableHeader = {"Property Name", "Start Date", "End Date", "Status", "Host's Details", "Review"};
		Object[][] tableContent;
        Object[][] hostDetails;
        try {
            Connection conn = DBAccess.connect();
            int i = 0;
            ArrayList<BookingInfo> bookings = Booking.getGuestsBookings(conn, guestInfo.getGuestID());
            tableContent = new Object[bookings.size()][tableHeader.length];
            hostDetails = new Object[bookings.size()][2];
            for (BookingInfo booking : bookings) {
                Object[] bookingData = new Object[tableHeader.length];
                Object[] hostData = new Object[2];
                PersonInfo host = Person.getPerson(conn, Property.getHostID(conn, booking.getPropertyID()));
                AddressInfo hostAddress = Person.getAddress(conn, host.getEmail());
                hostData[0] = host;
                hostData[1] = hostAddress;
                hostDetails[i] = hostData;

                bookingData[0] = Property.getPropertyName(conn, booking.getPropertyID());
                bookingData[1] = booking.getStartDate();
                bookingData[2] = booking.getEndDate();
                bookingData[3] = booking.getIsAccepted() ? "Accepted" : (booking.getIsRejected() ? "Rejected" : "Pending");
                bookingData[4] = booking.getIsAccepted() ? returnDetailsButton(i, hostDetails, personInfo, guestInfo) : null;
                bookingData[5] = booking.getIsAccepted() ? new InfoButton(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new ReviewView(booking, personInfo, guestInfo).setVisible(true);
                        dispose();
                    }}) : null;
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

        InfoButtonCellRenderer contactRenderer = new InfoButtonCellRenderer("Host's Details");
        InfoButtonCellRenderer reviewRenderer = new InfoButtonCellRenderer("Review");

        table.getColumn("Host's Details").setCellRenderer(contactRenderer);
        table.getColumn("Review").setCellRenderer(reviewRenderer);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		JScrollPane tableScrollpane = new JScrollPane(table);
		tableScrollpane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		getContentPane().add("Center",tableScrollpane);
		
		JButton btnHome = new JButton("Home");
		getContentPane().add(btnHome, BorderLayout.SOUTH);
		
		btnHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new GuestView(personInfo, guestInfo).setVisible(true);
				dispose();
			}
		});
		
		setVisible(true);
	}

    private InfoButton returnDetailsButton(int i, Object[][] hostDetails, PersonInfo personInfo, GuestInfo guestInfo) {
        InfoButton btn = new InfoButton();
        btn.setActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ConfidentialDetails((PersonInfo) hostDetails[i][0], (AddressInfo) hostDetails[i][1], personInfo, guestInfo).setVisible(true);
                dispose();
            }});
        return btn;
    }
}
