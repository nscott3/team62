package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Booking {

    public static void acceptBooking(Connection conn, BookingInfo info) {
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("UPDATE Booking SET isAccepted = ?, isRejected = ? WHERE bookingID = ?");
            pstmt.setBoolean(1, true);
            pstmt.setBoolean(2, false);
            pstmt.setInt(3, info.getBookingID());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void rejectBooking(Connection conn, BookingInfo info) {
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("UPDATE Booking SET isAccepted = ?, isRejected = ? WHERE bookingID = ?");
            pstmt.setBoolean(1, false);
            pstmt.setBoolean(2, true);
            pstmt.setInt(3, info.getBookingID());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

	public static void registerBooking(Connection conn, BookingInfo info) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO Booking (startDate, endDate, isAccepted, isRejected, propertyID, guestID) VALUES (?,?,?,?,?,?)");
			pstmt.setDate(1, info.getStartDate());
			pstmt.setDate(2, info.getEndDate());
			pstmt.setBoolean(3, info.getIsAccepted());
            pstmt.setBoolean(4, info.getIsRejected());
			pstmt.setInt(5, info.getPropertyID());
			pstmt.setString(6, info.getGuestID());
			pstmt.executeUpdate();
            pstmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

    public static BookingInfo getBooking(Connection conn, int bookingID) {
        BookingInfo booking = null;
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("SELECT * FROM Booking WHERE bookingID = ?");
            pstmt.setInt(1, bookingID);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                booking = new BookingInfo(
                        rs.getInt("bookingID"),
                        rs.getDate("startDate"),
                        rs.getDate("endDate"),
                        rs.getBoolean("isAccepted"),
                        rs.getBoolean("isRejected"),
                        rs.getInt("propertyID"),
                        rs.getString("guestID")
                );

            }

            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return booking;
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

    public static ArrayList<BookingInfo> getHostsBookings(Connection conn, String hostID) {
        ArrayList<BookingInfo> bookings = new ArrayList<BookingInfo>();
        ArrayList<Integer> ids = Property.lookupPropertyIDs(conn, hostID);

        for (int propertyID : ids) {
            PreparedStatement pstmt = null;
            try {
                pstmt = conn.prepareStatement("SELECT * FROM Booking WHERE propertyID = ?");
                pstmt.setInt(1, propertyID);
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
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
        }
        return bookings;
    }

    public static List<List<Date>> getAcceptedBookings(Connection conn, int propertyID) {
        List<List<Date>> acceptedBookings = new ArrayList<>();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("SELECT * FROM Booking WHERE propertyID = ?");
            pstmt.setInt(1, propertyID);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                if (rs.getBoolean("isAccepted")) {
                    List<Date> dates = new ArrayList<>();
                    dates.add(rs.getDate("startDate"));
                    dates.add(rs.getDate("endDate"));
                    acceptedBookings.add(dates);
                }
            }

            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return acceptedBookings;
    }
}
