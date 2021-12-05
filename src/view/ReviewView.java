package view;

import model.*;
import model.Property;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class ReviewView extends JFrame {
    private JTextField tfDescription = new JTextField();

    public ReviewView(BookingInfo bookingInfo, PersonInfo personInfo, GuestInfo guestInfo) {
        setResizable(false);
        setPreferredSize(new Dimension(1200, 720/12*9));
        setSize(1200, 720/12*9);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("HomeBreaks Plc");
        Insets insets = new Insets(4, 4, 4, 4);
        JPanel ratingPanel = new JPanel();
        JButton btnSubmit = new JButton("Submit");
        ratingPanel.setLayout(new GridBagLayout());
        RatingPanel cleanliness;
        RatingPanel communication;
        RatingPanel checkin;
        RatingPanel accuracy;
        RatingPanel location;
        RatingPanel value;

        try {
            Connection conn = DBAccess.connect();
            ReviewInfo review = Review.getBookingReview(conn, bookingInfo.getBookingID());
            cleanliness = new RatingPanel("Cleanliness", review == null ? 1 : review.getScoreCleanliness(), review == null);
            communication = new RatingPanel("Communication", review == null ? 1 : review.getScoreCommunication(),review == null);
            checkin = new RatingPanel("Check-in", review == null ? 1 : review.getScoreCheckin(),review == null);
            accuracy = new RatingPanel("Accuracy", review == null ? 1 : review.getScoreCheckin(),review == null);
            location = new RatingPanel("Location", review == null ? 1 : review.getScoreLocation(),review == null);
            value = new RatingPanel("Value", review == null ? 1 : review.getScoreValue(),review == null);

            if (review != null) {
                btnSubmit.setEnabled(false);
                tfDescription.setText(review.getDescription());
                tfDescription.setEditable(false);
            }

            ratingPanel.add(cleanliness, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            ratingPanel.add(communication, new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            ratingPanel.add(checkin, new GridBagConstraints(2, 0, 1, 1, 1.0, 1.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            ratingPanel.add(accuracy, new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            ratingPanel.add(location, new GridBagConstraints(1, 1, 1, 1, 1.0, 1.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            ratingPanel.add(value, new GridBagConstraints(2, 1, 1, 1, 1.0, 1.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            ratingPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        } finally {
            DBAccess.disconnect();
        }


        JLabel lblTitle = new JLabel("  Review");
        lblTitle.setBounds(35, 11, 270, 60);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 28));
        getContentPane().add("North",lblTitle);


        JPanel descriptionPanel = new JPanel();
        descriptionPanel.setLayout(new GridBagLayout());
        descriptionPanel.add(new JLabel("Description"), new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        descriptionPanel.add(tfDescription, new GridBagConstraints(1, 0, 1, 3, 20.0, 1.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        descriptionPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.add(ratingPanel, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        centerPanel.add(descriptionPanel, new GridBagConstraints(0, 1, 1, 5, 1.0, 5.0, GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL, insets, 0, 0));

        getContentPane().add(centerPanel, BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        JButton btnHome = new JButton("Home");
        btnHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MyReservationView(personInfo, guestInfo).setVisible(true);
                dispose();
            }
        });

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection conn = DBAccess.connect();
                    Review.submitReview(conn, new ReviewInfo(
                            bookingInfo.getBookingID(),
                            tfDescription.getText(),
                            cleanliness.getRating(),
                            communication.getRating(),
                            checkin.getRating(),
                            accuracy.getRating(),
                            location.getRating(),
                            value.getRating(),
                            bookingInfo.getPropertyID()
                    ));
                    float newRate = (float) Review.getAverageReviews(conn, bookingInfo.getPropertyID())[6];
                    Property.updateReviewRate(conn, bookingInfo.getPropertyID(), newRate);
                } finally {
                    DBAccess.disconnect();
                }
                new MyReservationView(personInfo, guestInfo).setVisible(true);
                dispose();
                JOptionPane.showMessageDialog(null, "Review Submitted!", "Error!", JOptionPane.DEFAULT_OPTION);
            }
        });
        southPanel.add(btnHome);
        southPanel.add(btnSubmit);
        getContentPane().add(southPanel, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

}
