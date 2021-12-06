package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Review {

    public static void submitReview(Connection conn, ReviewInfo info) {
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("INSERT INTO Review (bookingID, description, scoreCleanliness, scoreCommunication, scoreCheckin, scoreAccuracy, scoreLocation, scoreValue, propertyID) VALUES (?,?,?,?,?,?,?,?,?)");
            pstmt.setInt(1, info.getBookingID());
            pstmt.setString(2, info.getDescription());
            pstmt.setInt(3, info.getScoreCleanliness());
            pstmt.setInt(4, info.getScoreCommunication());
            pstmt.setInt(5, info.getScoreCheckin());
            pstmt.setInt(6, info.getScoreAccuracy());
            pstmt.setInt(7, info.getScoreLocation());
            pstmt.setInt(8, info.getScoreValue());
            pstmt.setInt(9, info.getPropertyID());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static ReviewInfo getBookingReview(Connection conn, int bookingID) {
        ReviewInfo review = null;
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("SELECT * FROM Review WHERE bookingID = ?");
            pstmt.setInt(1, bookingID);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                review = new ReviewInfo(
                    rs.getInt("bookingID"),
                    rs.getString("description"),
                    rs.getInt("scoreCleanliness"),
                    rs.getInt("scoreCommunication"),
                    rs.getInt("scoreCheckin"),
                    rs.getInt("scoreAccuracy"),
                    rs.getInt("scoreLocation"),
                    rs.getInt("scoreValue"),
                    rs.getInt("propertyID")
                );

            }

            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return review;
    }

    public static List<ReviewInfo> getPropertyReviews(Connection conn, int propertyID) {
        PreparedStatement pstmt = null;
        List<ReviewInfo> reviews = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement("SELECT * FROM Review WHERE propertyID = ?");
            pstmt.setInt(1, propertyID);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                reviews.add(new ReviewInfo(
                        rs.getInt("bookingID"),
                        rs.getString("description"),
                        rs.getInt("scoreCleanliness"),
                        rs.getInt("scoreCommunication"),
                        rs.getInt("scoreCheckin"),
                        rs.getInt("scoreAccuracy"),
                        rs.getInt("scoreLocation"),
                        rs.getInt("scoreValue"),
                        rs.getInt("propertyID")
                ));
            }
            rs.close();
            pstmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return reviews;
    }

    public static double[] getAverageReviews(Connection conn, int propertyID) {
        double[] scores = new double[6];
        double cleanlinessAvg = 0;
        double communicationAvg = 0;
        double checkinAvg = 0;
        double accuracyAvg = 0;
        double locationAvg = 0;
        double valueAvg = 0;
        double totalAvg = 0;
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement("SELECT * FROM Review WHERE propertyID = ?");
            pstmt.setInt(1, propertyID);
            ResultSet rs = pstmt.executeQuery();

            int cleanliness = 0;
            int communication = 0;
            int checkin = 0;
            int accuracy = 0;
            int location = 0;
            int value = 0;
            int i = 0;

            while(rs.next()) {
                cleanliness += rs.getInt("scoreCleanliness");
                communication += rs.getInt("scoreCommunication");
                checkin += rs.getInt("scoreCheckin");
                accuracy += rs.getInt("scoreAccuracy");
                location += rs.getInt("scoreLocation");
                value += rs.getInt("scoreValue");
                i++;
            }
            rs.close();
            pstmt.close();

            cleanlinessAvg = (double) cleanliness / i;
            communicationAvg = (double) communication / i;
            checkinAvg = (double) checkin / i;
            accuracyAvg = (double) accuracy / i;
            locationAvg = (double) location / i;
            valueAvg = (double) value / i;
            totalAvg = (cleanlinessAvg + communicationAvg + checkinAvg + accuracyAvg + locationAvg + valueAvg) / 6;

            scores = new double[]{cleanlinessAvg, communicationAvg, checkinAvg, accuracyAvg, locationAvg, valueAvg, totalAvg};
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return scores;
    }


}
