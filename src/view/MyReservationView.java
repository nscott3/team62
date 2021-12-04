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
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.BorderLayout;

import model.*;

public class MyReservationView extends JFrame{
	private JTable table;
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
		
		Object[] tableHeader = {"Property Name","Status"};
		Object[][] tableContent = {
				{"Property 1","Accepted"},
				{"Property 2","Accepted"},
				{"Property 3","Accepted"},
				{"Property 4","Accepted"},
				{"Property 5","Declined"},
				{"Property 6","Declined"},
				{"Property 7","Declined"},
				{"Property 8","Accepted"},
				{"Property 9","Accepted"},
				{"Property 10","Accepted"},
				{"Property 11","Accepted"},
				{"Property 12","Declined"},
				{"Property 13","Declined"},
				{"Property 14","Declined"},
				{"Property 15","Accepted"},
				{"Property 16","Accepted"},
				{"Property 17","Accepted"},
				{"Property 18","Accepted"},
				{"Property 19","Declined"},
				{"Property 20","Declined"},
				{"Property 11","Accepted"},
				{"Property 12","Declined"},
				{"Property 13","Declined"},
				{"Property 14","Declined"},
				{"Property 15","Accepted"},
				{"Property 16","Accepted"},
				{"Property 17","Accepted"},
				{"Property 18","Accepted"},
				{"Property 19","Declined"},
				{"Property 20","Declined"},
				{"Property 13",""},
		};
		table = new JTable(tableContent, tableHeader) {
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		JScrollPane tableScrollpane = new JScrollPane(table);
		tableScrollpane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		getContentPane().add("Center",tableScrollpane);
		
		JButton btnHome = new JButton("Home");
		getContentPane().add(btnHome, BorderLayout.SOUTH);
		
		btnHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new GuestView(personInfo, guestInfo);
				setVisible(false);
			}
		});
		
		setVisible(true);
	}
}
