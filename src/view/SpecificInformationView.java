package view;

import view.calendar.BookingDateManager;
import view.calendar.MonthCalendar;
import model.*;

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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SpecificInformationView extends JFrame {
	private JTextField tfStartDay;
	private JTextField tfEndDay;
	private final MonthCalendar currentCalendar;
	private final MonthCalendar nextCalendar;
	private JTextField tfDescription;

	public SpecificInformationView(PersonInfo personInfo, GuestInfo guestInfo, PropertyInfo propertyinfo, String startDate, String endDate) {
		setResizable(false);
		setPreferredSize(new Dimension(1200, 1020 / 12 * 9));
		setSize(1200, 1020 / 12 * 9);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("HomeBreaks Plc");
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(22, 10, 1162, 378);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblTitle = new JLabel("Specific Information");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblTitle.setBounds(14, 0, 514, 57);
		panel.add(lblTitle);

		JPanel PropertyInfoPanel = new JPanel();
		PropertyInfoPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		PropertyInfoPanel.setBounds(10, 58, 624, 309);
		panel.add(PropertyInfoPanel);
		PropertyInfoPanel.setLayout(null);

		JLabel lblPropertyName = new JLabel("Property Name");
		lblPropertyName.setBounds(17, 13, 118, 15);
		PropertyInfoPanel.add(lblPropertyName);

		JLabel lblPropertyDescription = new JLabel("Property Description");
		lblPropertyDescription.setBounds(18, 30, 142, 15);
		PropertyInfoPanel.add(lblPropertyDescription);

		JLabel lblPropertyLocation = new JLabel("Property Location");
		lblPropertyLocation.setBounds(18, 50, 118, 14);
		PropertyInfoPanel.add(lblPropertyLocation);

		JLabel lblBreakfast = new JLabel("Breakfast");
		lblBreakfast.setBounds(18, 70, 95, 14);
		PropertyInfoPanel.add(lblBreakfast);

		JLabel lblSleepingFacilities = new JLabel("Sleeping Facilities");
		lblSleepingFacilities.setBounds(18, 90, 142, 14);
		PropertyInfoPanel.add(lblSleepingFacilities);

		JLabel lblBedNum = new JLabel("Number of beds");
		lblBedNum.setBounds(18, 110, 118, 14);
		PropertyInfoPanel.add(lblBedNum);

		JLabel lblBathingFacilities = new JLabel("Bathing Facilities");
		lblBathingFacilities.setBounds(18, 130, 118, 14);
		PropertyInfoPanel.add(lblBathingFacilities);

		JLabel lblBathroomNum = new JLabel("Number of Bathrooms");
		lblBathroomNum.setBounds(18, 150, 142, 14);
		PropertyInfoPanel.add(lblBathroomNum);

		JLabel lblKitchecnFacilities = new JLabel("Kitchen Facilities");
		lblKitchecnFacilities.setBounds(18, 170, 118, 14);
		PropertyInfoPanel.add(lblKitchecnFacilities);

		JLabel lblLivingFacilities = new JLabel("Living Facilities");
		lblLivingFacilities.setBounds(18, 190, 118, 14);
		PropertyInfoPanel.add(lblLivingFacilities);

		JLabel lblUtilities = new JLabel("Utilities");
		lblUtilities.setBounds(18, 210, 95, 14);
		PropertyInfoPanel.add(lblUtilities);

		JLabel lblOutdoorFacilities = new JLabel("Outdoor Facilities");
		lblOutdoorFacilities.setBounds(18, 230, 118, 14);
		PropertyInfoPanel.add(lblOutdoorFacilities);

		JLabel lblAvailableDate = new JLabel("Available Date");
		lblAvailableDate.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAvailableDate.setBounds(657, 67, 415, 35);
		panel.add(lblAvailableDate);

		JPanel CalandarPanel1 = new JPanel();
		CalandarPanel1.setBounds(656, 110, 184, 143);
		panel.add(CalandarPanel1);

		final BookingDateManager bookingDateManager = new BookingDateManager();
		MonthCalendar.MonthListener listener = new MonthCalendar.MonthListener() {
			@Override
			public void onDayClick() {
				SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
				Calendar startCal = bookingDateManager.getStartDay();
				if (startCal != null) {
					String startDay = dateFormat.format(startCal.getTime());
					tfStartDay.setText(startDay);
				}
				Calendar endCal = bookingDateManager.getEndDay();
				if (endCal != null) {
					String endDay = dateFormat.format(endCal.getTime());
					tfEndDay.setText(endDay);
				}
				currentCalendar.updateDayColor();
				nextCalendar.updateDayColor();
			}

			@Override
			public void resetTextField() {
				tfStartDay.setText("");
				tfEndDay.setText("");
			}
		};

		currentCalendar = new MonthCalendar(bookingDateManager);
		currentCalendar.setOnDayClickListener(listener);
		CalandarPanel1.add(currentCalendar);

		JPanel CalandarPanel2 = new JPanel();
		CalandarPanel2.setBounds(848, 110, 184, 143);
		panel.add(CalandarPanel2);

		nextCalendar = new MonthCalendar(bookingDateManager);
		nextCalendar.setOnDayClickListener(listener);
		Calendar nextMonth = Calendar.getInstance();
		nextMonth.add(Calendar.MONTH, 1);

		nextCalendar.setDate(nextMonth.get(Calendar.YEAR), nextMonth.get(Calendar.MONTH) + 1);
		CalandarPanel2.add(nextCalendar);

		JLabel lblStartDay = new JLabel("Start Day");
		lblStartDay.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStartDay.setBounds(668, 280, 81, 15);
		panel.add(lblStartDay);

		tfStartDay = new JTextField(startDate);
		tfStartDay.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfStartDay.setBounds(665, 305, 140, 23);
		panel.add(tfStartDay);
		tfStartDay.setColumns(10);

		JLabel lblNewLabel = new JLabel("~");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(815, 305, 15, 15);
		panel.add(lblNewLabel);

		tfEndDay = new JTextField(endDate);
		tfEndDay.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfEndDay.setBounds(840, 305, 140, 23);
		panel.add(tfEndDay);
		tfEndDay.setColumns(10);

		JLabel lblEndDay = new JLabel("End Day");
		lblEndDay.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEndDay.setBounds(843, 280, 96, 15);
		panel.add(lblEndDay);

		JButton btnBooking = new JButton("Request Booking");
		btnBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBooking.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBooking.setBounds(993, 284, 148, 48);
		panel.add(btnBooking);

		JPanel reviewPanel = new JPanel();
		reviewPanel.setBounds(22, 387, 1162, 331);
		getContentPane().add(reviewPanel);
		reviewPanel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Review");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_1.setBounds(273, 9, 143, 39);
		reviewPanel.add(lblNewLabel_1);

		JLabel lblOSTitle = new JLabel("Overall Score");
		lblOSTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblOSTitle.setBounds(20, 50, 120, 15);
		reviewPanel.add(lblOSTitle);

		JLabel lblOverallScoreStar = new JLabel("\u2605\u2605\u2605\u2605\u2605");
		lblOverallScoreStar.setBounds(140, 50, 65, 15);
		reviewPanel.add(lblOverallScoreStar);

		JLabel lblCleanliness = new JLabel("Cleanliness");
		lblCleanliness.setBounds(25, 80, 85, 15);
		reviewPanel.add(lblCleanliness);

		JLabel lblCommunication = new JLabel("Communication");
		lblCommunication.setBounds(25, 98, 96, 15);
		reviewPanel.add(lblCommunication);

		JLabel lblCleanlinessStar = new JLabel("\u2605\u2605\u2605\u2605\u2606");
		lblCleanlinessStar.setBounds(130, 80, 65, 15);
		reviewPanel.add(lblCleanlinessStar);

		JLabel lblCommunicationStar = new JLabel("\u2605\u2605\u2605\u2605\u2606");
		lblCommunicationStar.setBounds(130, 98, 65, 15);
		reviewPanel.add(lblCommunicationStar);

		JLabel lblCheckIn = new JLabel("Check-in");
		lblCheckIn.setBounds(25, 116, 96, 15);
		reviewPanel.add(lblCheckIn);

		JLabel lblCheckInStar = new JLabel("\u2605\u2605\u2605\u2605\u2605");
		lblCheckInStar.setBounds(130, 116, 65, 15);
		reviewPanel.add(lblCheckInStar);

		JLabel lblAccuracy = new JLabel("Accuracy");
		lblAccuracy.setBounds(25, 134, 96, 15);
		reviewPanel.add(lblAccuracy);

		JLabel lblAccuracyStar = new JLabel("\u2605\u2605\u2605\u2605\u2606");
		lblAccuracyStar.setBounds(130, 134, 65, 15);
		reviewPanel.add(lblAccuracyStar);

		JLabel lblLocation = new JLabel("Location");
		lblLocation.setBounds(25, 152, 96, 15);
		reviewPanel.add(lblLocation);

		JLabel lblLocationStar = new JLabel("\u2605\u2605\u2605\u2605\u2606");
		lblLocationStar.setBounds(130, 152, 65, 15);
		reviewPanel.add(lblLocationStar);

		JLabel lblValue = new JLabel("Value");
		lblValue.setBounds(25, 170, 96, 15);
		reviewPanel.add(lblValue);

		JLabel lblValueStar = new JLabel("\u2605\u2605\u2605\u2605\u2605");
		lblValueStar.setBounds(130, 170, 65, 15);
		reviewPanel.add(lblValueStar);

		JLabel lblOSTitleSC = new JLabel("(4.7)");
		lblOSTitleSC.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOSTitleSC.setBounds(203, 50, 48, 15);
		reviewPanel.add(lblOSTitleSC);

		JLabel lblCleanlinessSC = new JLabel("(4.2)");
		lblCleanlinessSC.setBounds(205, 80, 34, 15);
		reviewPanel.add(lblCleanlinessSC);

		JLabel lblCommunicationSC = new JLabel("(4.1)");
		lblCommunicationSC.setBounds(205, 98, 34, 15);
		reviewPanel.add(lblCommunicationSC);

		JLabel lblCheckInSC = new JLabel("(5.0)");
		lblCheckInSC.setBounds(205, 116, 34, 15);
		reviewPanel.add(lblCheckInSC);

		JLabel lblAccuracySC = new JLabel("(4.3)");
		lblAccuracySC.setBounds(205, 134, 34, 15);
		reviewPanel.add(lblAccuracySC);

		JLabel lblLocationSC = new JLabel("(4.4)");
		lblLocationSC.setBounds(205, 152, 34, 15);
		reviewPanel.add(lblLocationSC);

		JLabel lblValueSC = new JLabel("(5.0)");
		lblValueSC.setBounds(205, 170, 34, 15);
		reviewPanel.add(lblValueSC);

		tfDescription = new JTextField();
		tfDescription.setBounds(272, 54, 713, 90);
		reviewPanel.add(tfDescription);
		tfDescription.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSubmit.setBounds(1007, 80, 118, 62);
		reviewPanel.add(btnSubmit);

		
		JPanel showReviewPanel = new JPanel();
		JScrollPane reviewPane = new JScrollPane(showReviewPanel);
		reviewPane.setBounds(288, 319, 826, -155);
		reviewPane.getVerticalScrollBar(); 
		reviewPanel.add(reviewPane);
		showReviewPanel.setLayout(new BorderLayout(0, 0));
		JTextArea tfReview = new JTextArea("hello this property", 20, 20);
		showReviewPanel.add(tfReview);
		 

		setVisible(true);
	}
}
