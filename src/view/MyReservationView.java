package view;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import model.*;
//PersonInfo personInfo, GuestInfo guestInfo
public class MyReservationView extends JFrame{
	private JTable table;

	final ReviewClickAction reviewClickAction = new ReviewClickAction() {
		@Override
		public void onClick(int contentId) {
			// 리뷰 작성 페이지로 이동
			System.out.println("click " + contentId);
		}
	};

	public MyReservationView() {
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
				//new GuestView(personInfo, guestInfo);
				setVisible(false);
			}
		});
		
		setVisible(true);
	}

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
}
