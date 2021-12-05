package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Booking {
	
	public void registerBooking(Connection conn, BookingInfo info) {
		PreparedStatement pstmt = null;
		try {
<<<<<<< HEAD
			pstmt = conn.prepareStatement("INSERT INTO Booking (startDate, endDate, isAccepted, propertyID, guestID) VALUES (?,?,?,?,?)");
			pstmt.setDate(1, startDate);
			pstmt.setDate(2, endDate);
			pstmt.setByte(3, isAccepted);
			pstmt.setInt(4, propertyID);
			pstmt.setInt(5, guestID);
=======
			pstmt = conn.prepareStatement("INSERT INTO Booking (startDate, endDate, isAccepted, isRejected, propertyID, guestID) VALUES (?,?,?,?,?,?)");
			pstmt.setDate(1, info.getStartDate());
			pstmt.setDate(2, info.getEndDate());
			pstmt.setBoolean(3, info.getIsAccepted());
            pstmt.setBoolean(4, info.getIsRejected());
			pstmt.setInt(5, info.getPropertyID());
			pstmt.setString(6, info.getGuestID());
>>>>>>> 3cddc989b89604f68b06464f993209ec36aa6a86
			pstmt.executeUpdate();
            pstmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static ArrayList<BookingInfo> getGuestsBookings(Connection conn, String guestID) {
		ArrayList<BookingInfo> bookings = new ArrayList<BookingInfo>();
        PreparedStatement pstmt = null;
		try {
            pstmt = conn.prepareStatement("SELECT * FROM Booking WHERE guestID = ?");
            pstmt.setString(1, guestID);
            ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
                bookings.add(new BookingInfo(
                        rs.getInt("bookingID"),
                        rs.getDate("startDate"),
                        rs.getDate("endDate"),
                        rs.getBoolean("isAccepted"),
                        rs.getBoolean("isRejected"),
                        rs.getInt("propertyID"),
                        rs.getString("guestID")
                ));

			}

            rs.close();
            pstmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return bookings;
	}

    public static List<List<Date>> getAcceptedBookings(Connection conn, int propertyID) {
        List<List<Date>> acceptedBookings = new ArrayList<>();
<<<<<<< HEAD
        try {
            String sql = "SELECT * FROM Booking WHERE propertyID =" + propertyID;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
=======
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("SELECT * FROM Booking WHERE propertyID = ?");
            pstmt.setInt(1, propertyID);
            ResultSet rs = pstmt.executeQuery();
>>>>>>> 3cddc989b89604f68b06464f993209ec36aa6a86

            while(rs.next()) {
                if (rs.getBoolean("isAccepted")) {
                    List<Date> dates = new ArrayList<>();
                    dates.add(rs.getDate("startDate"));
                    dates.add(rs.getDate("endDate"));
                    acceptedBookings.add(dates);
                }
            }

            rs.close();
<<<<<<< HEAD
            stmt.close();
=======
            pstmt.close();
>>>>>>> 3cddc989b89604f68b06464f993209ec36aa6a86
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return acceptedBookings;
    }
}
