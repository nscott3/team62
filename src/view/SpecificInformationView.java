package view;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class SpecificInformationView extends JFrame{
	private JTextField tfStartDay;
	private JTextField tfEndDay;
	public SpecificInformationView() {
		setResizable(false);
    	setPreferredSize(new Dimension(1200, 720/12*9));
	    setSize(1200, 720/12*9);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("HomeBreaks Plc");
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 1162, 348);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTitle = new JLabel("Specific Information");
		lblTitle.setFont(new Font("Calibri", Font.PLAIN, 30));
		lblTitle.setBounds(12, 10, 602, 44);
		panel.add(lblTitle);
		
		JPanel PropertyInfoPanel = new JPanel();
		PropertyInfoPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		PropertyInfoPanel.setBounds(12, 54, 523, 284);
		panel.add(PropertyInfoPanel);
		PropertyInfoPanel.setLayout(null);
		
		JLabel lblPropertyName = new JLabel("Property Name");
		lblPropertyName.setBounds(22, 10, 95, 15);
		PropertyInfoPanel.add(lblPropertyName);
		
		JLabel lblPropertyLocation = new JLabel("Property Location");
		lblPropertyLocation.setBounds(22, 35, 105, 15);
		PropertyInfoPanel.add(lblPropertyLocation);
		
		JLabel lblAvailableDate = new JLabel("Available Date");
		lblAvailableDate.setFont(new Font("±¼¸²", Font.PLAIN, 24));
		lblAvailableDate.setBounds(547, 12, 190, 35);
		panel.add(lblAvailableDate);
		
		JPanel CalandarPanel1 = new JPanel();
		CalandarPanel1.setBounds(547, 54, 275, 241);
		panel.add(CalandarPanel1);
		
		JPanel CalandarPanel2 = new JPanel();
		CalandarPanel2.setBounds(853, 54, 275, 241);
		panel.add(CalandarPanel2);
		
		JLabel lblStartDay = new JLabel("Start Day");
		lblStartDay.setBounds(547, 311, 50, 15);
		panel.add(lblStartDay);
		
		tfStartDay = new JTextField();
		tfStartDay.setBounds(609, 305, 96, 21);
		panel.add(tfStartDay);
		tfStartDay.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("~");
		lblNewLabel.setBounds(717, 311, 15, 15);
		panel.add(lblNewLabel);
		
		tfEndDay = new JTextField();
		tfEndDay.setBounds(809, 305, 96, 21);
		panel.add(tfEndDay);
		tfEndDay.setColumns(10);
		
		JLabel lblEndDay = new JLabel("End Day");
		lblEndDay.setBounds(744, 311, 50, 15);
		panel.add(lblEndDay);
		
		JButton btnBooking = new JButton("Request Booking");
		btnBooking.setBounds(926, 305, 150, 23);
		panel.add(btnBooking);
		
		JPanel reviewPanel = new JPanel();
		reviewPanel.setBounds(12, 368, 1162, 125);
		getContentPane().add(reviewPanel);
		reviewPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Review");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(12, 0, 71, 39);
		reviewPanel.add(lblNewLabel_1);
		
		JLabel lblOverallScore = new JLabel("Overall Score");
		lblOverallScore.setBounds(12, 49, 85, 15);
		reviewPanel.add(lblOverallScore);
		
		
	}
}
