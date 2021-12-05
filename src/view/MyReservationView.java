package view;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

<<<<<<< HEAD
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
=======
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.ArrayList;

import model.*;
import model.Property;
>>>>>>> 3cddc989b89604f68b06464f993209ec36aa6a86

import model.*;
//PersonInfo personInfo, GuestInfo guestInfo
public class MyReservationView extends JFrame{
	private JTable table;

<<<<<<< HEAD
	final ReviewClickAction reviewClickAction = new ReviewClickAction() {
		@Override
		public void onClick(int contentId) {
			//open review page so user can write their review
			System.out.println("click " + contentId);
		}
	};

	public MyReservationView() {
=======
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
>>>>>>> 3cddc989b89604f68b06464f993209ec36aa6a86
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
		
<<<<<<< HEAD
		Object[] tableHeader = {"Property Name", "Term", "Status", "Review"};
		int contentSize = 40;
		Object[][] tableContent = new Object[contentSize][tableHeader.length];

		for (int i = 0; i < contentSize; i++) {
			tableContent[i][0] = "Property " + i;
			tableContent[i][1] = "11/11/21 ~ 11/12/21";

			// test only
			String status;
			if (i % 3 == 0) {
				status = "Accepted";
			} else if (i % 3 == 1) {
				status = "Decline";
			} else {
				status = "Not yet";
			}
			tableContent[i][2] = status;

			if (tableContent[i][2] == "Accepted") {
				tableContent[i][3] = new ReviewButton(i, reviewClickAction);
			}
		}

		table = new JTable(tableContent, tableHeader) {
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) {
				return true;
			}
		};
=======
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
>>>>>>> 3cddc989b89604f68b06464f993209ec36aa6a86
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.getColumn("Review").setCellRenderer(new ReviewButtonCellRenderer("Review", tableContent));
		table.getColumn("Review").setCellEditor(new InfoButtonCellEditor());
		table.addMouseListener(new JTableButtonMouseListener(table));

		JScrollPane tableScrollpane = new JScrollPane(table);
		tableScrollpane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		getContentPane().add("Center",tableScrollpane);
		
		JButton btnHome = new JButton("Home");
		getContentPane().add(btnHome, BorderLayout.SOUTH);
		
		btnHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
				//new GuestView(personInfo, guestInfo);
				setVisible(false);
=======
				new GuestView(personInfo, guestInfo).setVisible(true);
				dispose();
>>>>>>> 3cddc989b89604f68b06464f993209ec36aa6a86
			}
		});
		
		setVisible(true);
	}

<<<<<<< HEAD
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

				if (value instanceof ReviewButton) {
					/*perform a click event*/
					ReviewButton button = (ReviewButton) value;
					button.listener.onClick(button.contentId);
				}
			}
		}
	}

	static class ReviewButton {
		private int contentId;
		private ReviewClickAction listener;

		public ReviewButton(int contentId, ReviewClickAction listener) {
			this.contentId = contentId;
			this.listener = listener;
		}
	}

	interface ReviewClickAction {
		void onClick(int contentId);
	}
=======
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
>>>>>>> 3cddc989b89604f68b06464f993209ec36aa6a86
}
