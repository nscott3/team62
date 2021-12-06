package view;

import view.calendar.BookingDateManager;
import view.calendar.MonthCalendar;
import model.*;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

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


        JLabel lblAvailableDate = new JLabel("Date Selector");
        lblAvailableDate.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblAvailableDate.setBounds(14, 58, 415, 35);
        panel.add(lblAvailableDate);

        JPanel CalandarPanel1 = new JPanel();
        CalandarPanel1.setBounds(73, 94, 184, 143);
        panel.add(CalandarPanel1);

        final BookingDateManager bookingDateManager = new BookingDateManager();
        MonthCalendar.MonthListener listener = new MonthCalendar.MonthListener() {
            @Override
            public void onDayClick() {
                SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
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
        CalandarPanel2.setBounds(469, 94, 184, 143);
        panel.add(CalandarPanel2);

        nextCalendar = new MonthCalendar(bookingDateManager);
        nextCalendar.setOnDayClickListener(listener);
        Calendar nextMonth = Calendar.getInstance();
        nextMonth.add(Calendar.MONTH, 1);

        nextCalendar.setDate(nextMonth.get(Calendar.YEAR), nextMonth.get(Calendar.MONTH) + 1);
        CalandarPanel2.add(nextCalendar);

        JLabel lblStartDay = new JLabel("Start Day");
        lblStartDay.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblStartDay.setBounds(238, 275, 81, 15);
        panel.add(lblStartDay);

        tfStartDay = new JTextField(startDate);
        tfStartDay.setFont(new Font("Tahoma", Font.PLAIN, 12));
        tfStartDay.setBounds(203, 300, 140, 23);
        panel.add(tfStartDay);
        tfStartDay.setColumns(10);

        JLabel lblNewLabel = new JLabel("~");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setBounds(353, 300, 15, 15);
        panel.add(lblNewLabel);

        tfEndDay = new JTextField(endDate);
        tfEndDay.setFont(new Font("Tahoma", Font.PLAIN, 12));
        tfEndDay.setBounds(378, 300, 140, 23);
        panel.add(tfEndDay);
        tfEndDay.setColumns(10);

        JLabel lblEndDay = new JLabel("End Day");
        lblEndDay.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblEndDay.setBounds(419, 275, 96, 15);
        panel.add(lblEndDay);

        JButton btnBooking = new JButton("Request Booking");
        btnBooking.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
                boolean formatted = false;
                try {
                    format.setLenient(false);
                    format.parse(tfStartDay.getText());
                    format.parse(tfEndDay.getText());
                    formatted = true;
                }
                catch(ParseException ex){
                    formatted = false;
                }
                if (formatted) {
                    new CostView(personInfo, guestInfo, propertyinfo, Date.valueOf(tfStartDay.getText()), Date.valueOf(tfEndDay.getText())).setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Please write valid dates in YYYY-MM-DD format!", "Error!", JOptionPane.DEFAULT_OPTION);
                }

            }
        });
        btnBooking.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnBooking.setBounds(997, 296, 132, 48);
        panel.add(btnBooking);

        JButton btnInfo = new JButton("Property Info");
        btnInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PropertyInformationView(personInfo, guestInfo, propertyinfo, startDate, endDate).setVisible(true);
                dispose();
            }
        });
        btnInfo.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnInfo.setBounds(853, 296, 132, 48);
        panel.add(btnInfo);

        String scoreCleanliness;
        String scoreCommunication;
        String scoreCheckin;
        String scoreAccuracy;
        String scoreLocation;
        String scoreValue;
        String scoreAverage;
        double scoreCleanlinessDouble = 0;
        double scoreCommunicationDouble = 0;
        double scoreCheckinDouble = 0;
        double scoreAccuracyDouble = 0;
        double scoreLocationDouble = 0;
        double scoreValueDouble = 0;
        double scoreAverageDouble = 0;

        try {
            Connection conn = DBAccess.connect();
            double[] scores = Review.getAverageReviews(conn,propertyinfo.getPropertyID());
            scoreCleanliness = starResolver((int) scores[0]);
            scoreCommunication = starResolver((int) scores[1]);
            scoreCheckin = starResolver((int) scores[2]);
            scoreAccuracy = starResolver((int) scores[3]);
            scoreLocation = starResolver((int) scores[4]);
            scoreValue = starResolver((int) scores[5]);
            scoreAverage = starResolver((int) scores[6]);
            scoreCleanlinessDouble = scores[0];
            scoreCommunicationDouble = scores[1];
            scoreCheckinDouble = scores[2];
            scoreAccuracyDouble = scores[3];
            scoreLocationDouble = scores[4];
            scoreValueDouble = scores[5];
            scoreAverageDouble = scores[6];

            scoreCleanlinessDouble = Double.isNaN(scoreCleanlinessDouble) ? 0 : round(scores[0],2);
            scoreCommunicationDouble = Double.isNaN(scoreCommunicationDouble) ? 0 : round(scores[1],2);
            scoreCheckinDouble = Double.isNaN(scoreCheckinDouble) ? 0 : round(scores[2],2);
            scoreAccuracyDouble = Double.isNaN(scoreAccuracyDouble) ? 0 : round(scores[3],2);
            scoreLocationDouble = Double.isNaN(scoreLocationDouble) ? 0 : round(scores[4],2);
            scoreValueDouble = Double.isNaN(scoreValueDouble) ? 0 : round(scores[5],2);
            scoreAverageDouble = Double.isNaN(scoreAverageDouble) ? 0 : round(scores[6],2);
        } finally {
            DBAccess.disconnect();
        }

        JLabel lblOSTitle = new JLabel("Overall Score");
        lblOSTitle.setBounds(811, 102, 120, 15);
        panel.add(lblOSTitle);
        lblOSTitle.setFont(new Font("Tahoma", Font.BOLD, 16));

        JLabel lblOverallScoreStar = new JLabel(scoreAverage);
        lblOverallScoreStar.setBounds(931, 102, 65, 15);
        panel.add(lblOverallScoreStar);

        JLabel lblOSTitleSC = new JLabel("("+scoreAverageDouble+")");
        lblOSTitleSC.setBounds(996, 103, 48, 15);
        panel.add(lblOSTitleSC);
        lblOSTitleSC.setFont(new Font("Tahoma", Font.BOLD, 13));

        JLabel lblCleanlinessSC = new JLabel("("+scoreCleanlinessDouble+")");
        lblCleanlinessSC.setBounds(996, 132, 34, 15);
        panel.add(lblCleanlinessSC);

        JLabel lblCleanlinessStar = new JLabel(scoreCleanliness);
        lblCleanlinessStar.setBounds(921, 132, 65, 15);
        panel.add(lblCleanlinessStar);

        JLabel lblCleanliness = new JLabel("Cleanliness");
        lblCleanliness.setBounds(816, 132, 85, 15);
        panel.add(lblCleanliness);

        JLabel lblCommunication = new JLabel("Communication");
        lblCommunication.setBounds(811, 150, 120, 15);
        panel.add(lblCommunication);

        JLabel lblCheckIn = new JLabel("Check-in");
        lblCheckIn.setBounds(816, 168, 96, 15);
        panel.add(lblCheckIn);

        JLabel lblAccuracy = new JLabel("Accuracy");
        lblAccuracy.setBounds(816, 186, 96, 15);
        panel.add(lblAccuracy);

        JLabel lblLocation = new JLabel("Location");
        lblLocation.setBounds(816, 204, 96, 15);
        panel.add(lblLocation);

        JLabel lblValue = new JLabel("Value");
        lblValue.setBounds(816, 222, 96, 15);
        panel.add(lblValue);

        JLabel lblValueStar = new JLabel(scoreValue);
        lblValueStar.setBounds(921, 222, 65, 15);
        panel.add(lblValueStar);

        JLabel lblLocationStar = new JLabel(scoreLocation);
        lblLocationStar.setBounds(921, 204, 65, 15);
        panel.add(lblLocationStar);

        JLabel lblAccuracyStar = new JLabel(scoreAccuracy);
        lblAccuracyStar.setBounds(921, 186, 65, 15);
        panel.add(lblAccuracyStar);

        JLabel lblCheckInStar = new JLabel(scoreCheckin);
        lblCheckInStar.setBounds(921, 168, 65, 15);
        panel.add(lblCheckInStar);

        JLabel lblCommunicationStar = new JLabel(scoreCommunication);
        lblCommunicationStar.setBounds(921, 150, 65, 15);
        panel.add(lblCommunicationStar);

        JLabel lblCommunicationSC = new JLabel("("+scoreCommunicationDouble+")");
        lblCommunicationSC.setBounds(996, 150, 34, 15);
        panel.add(lblCommunicationSC);

        JLabel lblCheckInSC = new JLabel("("+scoreCheckinDouble+")");
        lblCheckInSC.setBounds(996, 168, 34, 15);
        panel.add(lblCheckInSC);

        JLabel lblAccuracySC = new JLabel("("+scoreAccuracyDouble+")");
        lblAccuracySC.setBounds(996, 186, 34, 15);
        panel.add(lblAccuracySC);

        JLabel lblLocationSC = new JLabel("("+scoreLocationDouble+")");
        lblLocationSC.setBounds(996, 204, 34, 15);
        panel.add(lblLocationSC);

        JLabel lblValueSC = new JLabel("("+scoreValueDouble+")");
        lblValueSC.setBounds(996, 222, 34, 15);
        panel.add(lblValueSC);

        JLabel lblNewLabel_1 = new JLabel("Reviews");
        lblNewLabel_1.setBounds(6, 339, 143, 39);
        panel.add(lblNewLabel_1);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 26));

        JButton btnBack = new JButton("Go Back");
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnBack.setBounds(709, 296, 132, 48);
        panel.add(btnBack);

        JPanel reviewPanel = new JPanel();
        reviewPanel.setBounds(22, 387, 1162, 331);
        getContentPane().add(reviewPanel);
        reviewPanel.setLayout(null);

        Insets insets = new Insets(4, 4, 4, 4);
        JPanel reviews = new JPanel();
        reviews.setBounds(0, 0, 1142, 331);
        reviews.setLayout(new GridBagLayout());
        int y = 0;
        reviews.add(new JLabel("Guest Name"), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        reviews.add(new JLabel("Description"), new GridBagConstraints(1, y, 1, 1, 5.0, 0.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        reviews.add(new JLabel("Cleanliness"), new GridBagConstraints(2, y, 1, 1, 1.0, 0.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        reviews.add(new JLabel("Communication"), new GridBagConstraints(3, y, 1, 1, 1.0, 0.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        reviews.add(new JLabel("Checkin"), new GridBagConstraints(4, y, 1, 1, 1.0, 0.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        reviews.add(new JLabel("Accuracy"), new GridBagConstraints(5, y, 1, 1, 1.0, 0.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        reviews.add(new JLabel("Location"), new GridBagConstraints(6, y, 1, 1, 1.0, 0.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        reviews.add(new JLabel("Value"), new GridBagConstraints(7, y, 1, 1, 1.0, 0.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        reviews.add(new JLabel("Average"), new GridBagConstraints(8, y, 1, 1, 1.0, 0.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        List<ReviewInfo> propertyReviews = new ArrayList<>();
        List<String> guestNames = new ArrayList<>();
        try{
            Connection conn = DBAccess.connect();
            propertyReviews = Review.getPropertyReviews(conn, propertyinfo.getPropertyID());
            for (ReviewInfo review : propertyReviews) {
                BookingInfo booking = Booking.getBooking(conn, review.getBookingID());
                GuestInfo guest = Guest.getGuest(conn, booking.getGuestID());
                guestNames.add(guest.getGuestName());
            }
        } finally{
            DBAccess.disconnect();
        }
        for (ReviewInfo review : propertyReviews) {
            int cleanliness = review.getScoreCleanliness();
            int communication = review.getScoreCommunication();
            int checkin = review.getScoreCheckin();
            int accuracy = review.getScoreAccuracy();
            int location = review.getScoreLocation();
            int value = review.getScoreValue();
            double average = (double)(cleanliness + communication + checkin + accuracy + location + value) / 6;
            reviews.add(new JLabel(guestNames.get(y-1)), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            reviews.add(new JLabel(review.getDescription()), new GridBagConstraints(1, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            reviews.add(new JLabel(String.valueOf(cleanliness)), new GridBagConstraints(2, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            reviews.add(new JLabel(String.valueOf(communication)), new GridBagConstraints(3, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            reviews.add(new JLabel(String.valueOf(checkin)), new GridBagConstraints(4, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            reviews.add(new JLabel(String.valueOf(accuracy)), new GridBagConstraints(5, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            reviews.add(new JLabel(String.valueOf(location)), new GridBagConstraints(6, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            reviews.add(new JLabel(String.valueOf(value)), new GridBagConstraints(7, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            reviews.add(new JLabel(String.valueOf(round(average, 2))), new GridBagConstraints(8, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            y++;
        }

        reviewPanel.add(reviews);

        JPanel showReviewPanel = new JPanel();
        JScrollPane reviewPane = new JScrollPane(showReviewPanel);
        reviewPane.setBounds(288, 319, 826, -155);
        reviewPane.getVerticalScrollBar();
        reviewPanel.add(reviewPane);
        showReviewPanel.setLayout(new BorderLayout(0, 0));

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                new GuestView(personInfo, guestInfo);
                setVisible(false);
            }
        });

        pack();
        setVisible(true);
    }

    private String starResolver(int i){
        switch(i) {
            case 1:
                return "\u2605\u2606\u2606\u2606\u2606";
            case 2:
                return "\u2605\u2605\u2606\u2606\u2606";
            case 3:
                return "\u2605\u2605\u2605\u2606\u2606";
            case 4:
                return "\u2605\u2605\u2605\u2605\u2606";
            case 5:
                return "\u2605\u2605\u2605\u2605\u2605";
            default:
                return "\u2606\u2606\u2606\u2606\u2606";
        }
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
