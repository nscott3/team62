package view;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class GuestView extends JFrame {
    private String guestName;
    private JTextField tfSearch;
    private JTextField tfLocation;
    private JTextField tfStartDate;
    private JTextField tfEndDate;
    
    
    public GuestView() {
        setResizable(false);
	    setPreferredSize(new Dimension(1200, 720/12*9));
	    setSize(1200, 720/12*9);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("HomeBreaks Plc");
		
		JLabel lblTitle = new JLabel("Welcome to HomeBreaks Plc!");
		lblTitle.setBounds(26, 98, 1196, 45);
		Font GuestPageTitle = new Font("Arial", Font.BOLD, 38); //font: Arial
		getContentPane().setLayout(null);
		lblTitle.setFont(GuestPageTitle); 
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblTitle);
		
		tfSearch = new JTextField();
		tfSearch.setForeground(Color.BLACK);
		tfSearch.setBounds(238, 260, 750, 30);
		tfSearch.setText("Search keyword...(Property, Host name, ..etc)");
		getContentPane().add(tfSearch);
		tfSearch.setColumns(10);
		
		JButton btnSearchBtn = new JButton("Search");
		btnSearchBtn.setFont(new Font("Calibri", Font.BOLD, 18));
		btnSearchBtn.setBounds(1017, 245, 96, 45);
		getContentPane().add(btnSearchBtn);
		
		JButton btnMyReservation = new JButton("MyReservation");
		btnMyReservation.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnMyReservation.setBounds(960, 61, 114, 23);
		getContentPane().add(btnMyReservation);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnLogOut.setBounds(1084, 61, 89, 23);
		getContentPane().add(btnLogOut);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblLocation.setBounds(238, 219, 65, 19);
		getContentPane().add(lblLocation);
		
		tfLocation = new JTextField();
		tfLocation.setBounds(329, 215, 176, 25);
		getContentPane().add(tfLocation);
		tfLocation.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblDate.setBounds(595, 217, 49, 23);
		getContentPane().add(lblDate);
		
		tfStartDate = new JTextField();
		tfStartDate.setBounds(641, 216, 123, 25);
		getContentPane().add(tfStartDate);
		tfStartDate.setText("DD/MM/YYYY");
		tfStartDate.setColumns(10);
		
		JLabel lblWave = new JLabel("~");
		lblWave.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblWave.setBounds(774, 218, 29, 20);
		getContentPane().add(lblWave);
		
		tfEndDate = new JTextField();
		tfEndDate.setBounds(796, 215, 123, 25);
		getContentPane().add(tfEndDate);
		tfEndDate.setText("DD/MM/YYYY");
		tfEndDate.setColumns(10);
		
		JLabel lblLogInDescription = new JLabel("Logged in as");
		lblLogInDescription.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblLogInDescription.setBounds(960, 11, 82, 14);
		getContentPane().add(lblLogInDescription);
		
		JLabel lblName = new JLabel("User Name");
		lblName.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblName.setBounds(1009, 36, 146, 14);
		getContentPane().add(lblName);
		
		JLabel lblCheckGuest = new JLabel("(Guest)");
		lblCheckGuest.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblCheckGuest.setBounds(960, 36, 49, 14);
		getContentPane().add(lblCheckGuest);
		
		setVisible(true);
		btnLogOut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new MainView();
				JOptionPane.showMessageDialog(null, "Log out!");
				setVisible(false);
			}
		});
		btnMyReservation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new MyReservationView();
				setVisible(false);
			}
		});
		btnSearchBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new SearchView();
				setVisible(false);
			}
		});
    }

    
    public void addGuest(Connection conn) {
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("INSERT INTO Guest (guestName) VALUES (?)");
            pstmt.setString(1, guestName);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Integer lookupID(Connection conn) {
        int guestID = 0;
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("SELECT guestID FROM Guest WHERE guestName = ?");
            pstmt.setString(1, guestName);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                guestID = rs.getInt("guestID");
            }
            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return guestID;
    }
}
