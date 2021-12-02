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
		lblPropertyName.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblPropertyName.setBounds(22, 10, 95, 15);
		PropertyInfoPanel.add(lblPropertyName);
		
		JLabel lblPropertyDescription = new JLabel("Property Description");
		lblPropertyDescription.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblPropertyDescription.setBounds(22, 30, 105, 15);
		PropertyInfoPanel.add(lblPropertyDescription);
		
		JLabel lblPropertyLocation = new JLabel("Property Location");
		lblPropertyLocation.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblPropertyLocation.setBounds(22, 50, 95, 14);
		PropertyInfoPanel.add(lblPropertyLocation);
		
		JLabel lblBreakfast = new JLabel("Breakfast");
		lblBreakfast.setBounds(22, 70, 56, 14);
		PropertyInfoPanel.add(lblBreakfast);
		
		JLabel lblSleepingFacilities = new JLabel("Sleeping Facilities");
		lblSleepingFacilities.setBounds(22, 90, 88, 14);
		PropertyInfoPanel.add(lblSleepingFacilities);
		
		JLabel lblBedNum = new JLabel("Number of beds");
		lblBedNum.setBounds(22, 110, 95, 14);
		PropertyInfoPanel.add(lblBedNum);
		
		JLabel lblBathingFacilities = new JLabel("Bathing Facilities");
		lblBathingFacilities.setBounds(22, 130, 88, 14);
		PropertyInfoPanel.add(lblBathingFacilities);
		
		JLabel lblBathroomNum = new JLabel("Number of Bathrooms");
		lblBathroomNum.setBounds(22, 150, 118, 14);
		PropertyInfoPanel.add(lblBathroomNum);
		
		JLabel lblKitchecnFacilities = new JLabel("Kitchen Facilities");
		lblKitchecnFacilities.setBounds(22, 170, 88, 14);
		PropertyInfoPanel.add(lblKitchecnFacilities);
		
		JLabel lblLivingFacilities = new JLabel("Living Facilities");
		lblLivingFacilities.setBounds(22, 190, 88, 14);
		PropertyInfoPanel.add(lblLivingFacilities);
		
		JLabel lblUtilities = new JLabel("Utilities");
		lblUtilities.setBounds(22, 210, 49, 14);
		PropertyInfoPanel.add(lblUtilities);
		
		JLabel lblOutdoorFacilities = new JLabel("Outdoor Facilities");
		lblOutdoorFacilities.setBounds(22, 230, 88, 14);
		PropertyInfoPanel.add(lblOutdoorFacilities);
		
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
