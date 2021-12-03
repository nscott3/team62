package view;

import view.calendar.BookingDateManager;
import view.calendar.MonthCalendar;

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

public class SpecificInformationView extends JFrame {
	private JTextField tfStartDay;
	private JTextField tfEndDay;
	private final MonthCalendar currentCalendar;
	private final MonthCalendar nextCalendar;
	private JTextField tfDescription;

	public SpecificInformationView() {
		setResizable(false);
		setPreferredSize(new Dimension(1200, 1020 / 12 * 9));
		setSize(1200, 1020 / 12 * 9);
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
		lblAvailableDate.setFont(new Font("����", Font.PLAIN, 24));
		lblAvailableDate.setBounds(547, 12, 190, 35);
		panel.add(lblAvailableDate);

		JPanel CalandarPanel1 = new JPanel();
		CalandarPanel1.setBounds(547, 54, 275, 241);
		panel.add(CalandarPanel1);

		final BookingDateManager bookingDateManager = new BookingDateManager();
		MonthCalendar.MonthListener listener = new MonthCalendar.MonthListener() {
			@Override
			public void onDayClick() {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
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
		CalandarPanel2.setBounds(853, 54, 275, 241);
		panel.add(CalandarPanel2);

		nextCalendar = new MonthCalendar(bookingDateManager);
		nextCalendar.setOnDayClickListener(listener);
		Calendar nextMonth = Calendar.getInstance();
		nextMonth.add(Calendar.MONTH, 1);

		nextCalendar.setDate(nextMonth.get(Calendar.YEAR), nextMonth.get(Calendar.MONTH) + 1);
		CalandarPanel2.add(nextCalendar);

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
		reviewPanel.setBounds(12, 368, 1162, 350);
		getContentPane().add(reviewPanel);
		reviewPanel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Review");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(12, 0, 71, 39);
		reviewPanel.add(lblNewLabel_1);

		JLabel lblOSTitle = new JLabel("Overall Score");
		lblOSTitle.setBounds(12, 49, 85, 15);
		reviewPanel.add(lblOSTitle);

		JLabel lblOverallScoreStar = new JLabel("\u2605\u2605\u2605\u2605\u2605");
		lblOverallScoreStar.setBounds(109, 49, 65, 15);
		reviewPanel.add(lblOverallScoreStar);

		JLabel lblCleanliness = new JLabel("Cleanliness");
		lblCleanliness.setBounds(12, 74, 85, 15);
		reviewPanel.add(lblCleanliness);

		JLabel lblCommunication = new JLabel("Communication");
		lblCommunication.setBounds(12, 99, 96, 15);
		reviewPanel.add(lblCommunication);

		JLabel lblCleanlinessStar = new JLabel("\u2605\u2605\u2605\u2605\u2606");
		lblCleanlinessStar.setBounds(109, 74, 65, 15);
		reviewPanel.add(lblCleanlinessStar);

		JLabel lblCommunicationStar = new JLabel("\u2605\u2605\u2605\u2605\u2606");
		lblCommunicationStar.setBounds(109, 99, 65, 15);
		reviewPanel.add(lblCommunicationStar);

		JLabel lblCheckIn = new JLabel("Check-in");
		lblCheckIn.setBounds(12, 124, 96, 15);
		reviewPanel.add(lblCheckIn);

		JLabel lblCheckInStar = new JLabel("\u2605\u2605\u2605\u2605\u2605");
		lblCheckInStar.setBounds(109, 124, 65, 15);
		reviewPanel.add(lblCheckInStar);

		JLabel lblAccuracy = new JLabel("Accuracy");
		lblAccuracy.setBounds(12, 149, 96, 15);
		reviewPanel.add(lblAccuracy);

		JLabel lblAccuracyStar = new JLabel("\u2605\u2605\u2605\u2605\u2606");
		lblAccuracyStar.setBounds(109, 149, 65, 15);
		reviewPanel.add(lblAccuracyStar);

		JLabel lblLocation = new JLabel("Location");
		lblLocation.setBounds(12, 174, 96, 15);
		reviewPanel.add(lblLocation);

		JLabel lblLocationStar = new JLabel("\u2605\u2605\u2605\u2605\u2606");
		lblLocationStar.setBounds(109, 174, 65, 15);
		reviewPanel.add(lblLocationStar);

		JLabel lblValue = new JLabel("Value");
		lblValue.setBounds(12, 199, 96, 15);
		reviewPanel.add(lblValue);

		JLabel lblValueStar = new JLabel("\u2605\u2605\u2605\u2605\u2605");
		lblValueStar.setBounds(109, 199, 65, 15);
		reviewPanel.add(lblValueStar);

		JLabel lblOSTitleSC = new JLabel("(4.7)");
		lblOSTitleSC.setBounds(186, 49, 34, 15);
		reviewPanel.add(lblOSTitleSC);

		JLabel lblCleanlinessSC = new JLabel("(4.2)");
		lblCleanlinessSC.setBounds(186, 74, 34, 15);
		reviewPanel.add(lblCleanlinessSC);

		JLabel lblCommunicationSC = new JLabel("(4.1)");
		lblCommunicationSC.setBounds(186, 99, 34, 15);
		reviewPanel.add(lblCommunicationSC);

		JLabel lblCheckInSC = new JLabel("(5.0)");
		lblCheckInSC.setBounds(186, 124, 34, 15);
		reviewPanel.add(lblCheckInSC);

		JLabel lblAccuracySC = new JLabel("(4.3)");
		lblAccuracySC.setBounds(186, 149, 34, 15);
		reviewPanel.add(lblAccuracySC);

		JLabel lblLocationSC = new JLabel("(4.4)");
		lblLocationSC.setBounds(186, 174, 34, 15);
		reviewPanel.add(lblLocationSC);

		JLabel lblValueSC = new JLabel("(5.0)");
		lblValueSC.setBounds(186, 199, 34, 15);
		reviewPanel.add(lblValueSC);

		tfDescription = new JTextField();
		tfDescription.setBounds(288, 46, 713, 106);
		reviewPanel.add(tfDescription);
		tfDescription.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(1013, 99, 91, 44);
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
