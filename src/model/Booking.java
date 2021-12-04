package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Booking {
	private int bookingID;
	private java.sql.Date startDate;
	private java.sql.Date endDate;
	private byte isAccepted;
	private int propertyID;
	private int guestID;
	
	public Booking(
			String startDateB,
			String endDateB,
			byte isAcceptedB,
			int propertyIDB,
			int guestIDB) {
		startDate = java.sql.Date.valueOf(startDateB); // YYYY-MM-DD
		endDate = java.sql.Date.valueOf(endDateB);  // YYYY-MM-DD
		isAccepted = isAcceptedB;
		propertyID = propertyIDB;
		guestID = guestIDB;
	}
	
	public void registerBooking(Connection conn) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO Booking (startDate, endDate, isAccepted, propertyID, guestID) VALUES (?,?,?,?,?)");
			pstmt.setDate(1, startDate);
			pstmt.setDate(2, endDate);
			pstmt.setByte(3, isAccepted);
			pstmt.setInt(4, propertyID);
			pstmt.setInt(5, guestID);
			pstmt.executeUpdate();
            pstmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public ArrayList<Integer> lookupBookingIDs(Connection conn, int guestID) {
		ArrayList<Integer> bookingIDs = new ArrayList<Integer>();
		
		try {
			String sql = "SELECT * FROM Booking WHERE guestID =" + guestID;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				bookingIDs.add(rs.getInt("bookingID"));
			}	
			
			rs.close();
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return bookingIDs;
	}

    public static List<List<Date>> getAcceptedBookings(Connection conn, int propertyID) {
        List<List<Date>> acceptedBookings = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Booking WHERE propertyID =" + propertyID;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                if (rs.getBoolean("isAccepted")) {
                    List<Date> dates = new ArrayList<>();
                    dates.add(rs.getDate("startDate"));
                    dates.add(rs.getDate("endDate"));
                    acceptedBookings.add(dates);
                }
            }

            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return acceptedBookings;
    }
}
