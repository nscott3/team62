package view;
import model.PersonInfo;
import model.GuestInfo;

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
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EnquirerView extends JFrame {
    private String guestName;
    private JTextField tfSearch;
    private JTextField tfLocation;
    private JTextField tfStartDate;
    private JTextField tfEndDate;


    public EnquirerView() {
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
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 38));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(lblTitle);

        tfSearch = new JTextField();
        tfSearch.setFont(new Font("SansSerif", Font.PLAIN, 12));
        tfSearch.setForeground(Color.BLACK);
        tfSearch.setBounds(238, 260, 750, 30);
        tfSearch.setText(" Search keyword... (Property, Host name, ..etc)");
        getContentPane().add(tfSearch);
        tfSearch.setColumns(10);

        JButton btnSearchBtn = new JButton("Search");
        btnSearchBtn.setFont(new Font("SansSerif", Font.BOLD, 18));
        btnSearchBtn.setBounds(998, 251, 96, 45);
        getContentPane().add(btnSearchBtn);

        JButton btnHome = new JButton("Home");
        btnHome.setFont(new Font("SansSerif", Font.PLAIN, 12));
        btnHome.setBounds(1070, 58, 89, 30);
        getContentPane().add(btnHome);

        JLabel lblLocation = new JLabel("Location");
        lblLocation.setFont(new Font("SansSerif", Font.PLAIN, 18));
        lblLocation.setBounds(238, 219, 82, 19);
        getContentPane().add(lblLocation);

        tfLocation = new JTextField();
        tfLocation.setBounds(313, 215, 176, 25);
        getContentPane().add(tfLocation);
        tfLocation.setColumns(10);

        JLabel lblDate = new JLabel("Date");
        lblDate.setFont(new Font("SansSerif", Font.PLAIN, 18));
        lblDate.setBounds(595, 217, 49, 23);
        getContentPane().add(lblDate);

        tfStartDate = new JTextField();
        tfStartDate.setFont(new Font("SansSerif", Font.PLAIN, 12));
        tfStartDate.setBounds(641, 216, 123, 25);
        getContentPane().add(tfStartDate);
        tfStartDate.setText("YYYY-MM-DD");
        tfStartDate.setColumns(10);

        JLabel lblWave = new JLabel("~");
        lblWave.setFont(new Font("SansSerif", Font.PLAIN, 18));
        lblWave.setBounds(774, 221, 29, 14);
        getContentPane().add(lblWave);

        tfEndDate = new JTextField();
        tfEndDate.setFont(new Font("SansSerif", Font.PLAIN, 12));
        tfEndDate.setBounds(796, 215, 123, 25);
        getContentPane().add(tfEndDate);
        tfEndDate.setText("YYYY-MM-DD");
        tfEndDate.setColumns(10);

        JLabel lblLogInDescription = new JLabel("Logged in as Enquirer");
        lblLogInDescription.setFont(new Font("SansSerif", Font.PLAIN, 12));
        lblLogInDescription.setBounds(1040, 34, 133, 14);
        getContentPane().add(lblLogInDescription);

        setVisible(true);

        btnHome.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                new MainView();
                setVisible(false);
            }
        });
        btnSearchBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                boolean formatted = false;
                try {
                    format.setLenient(false);
                    format.parse(tfStartDate.getText());
                    format.parse(tfEndDate.getText());
                    formatted = true;
                }
                catch(ParseException ex){
                    formatted = false;
                }
                if (formatted) {
                	//todo search
                } else {
                    JOptionPane.showMessageDialog(null, "Please write valid dates in YYYY-MM-DD format!", "Error!", JOptionPane.DEFAULT_OPTION);
                }

            }
        });
    }
}