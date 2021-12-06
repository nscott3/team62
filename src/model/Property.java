package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Property {
	
	public static void registerProperty(Connection conn, PropertyInfo info) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO Property VALUES (default,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, info.getName());
			pstmt.setString(2, info.getDescription());
			pstmt.setString(3, info.getLocation());
			pstmt.setBoolean(4, info.getIsBreakfast());
			pstmt.setInt(5, info.getMaxGuests());
			pstmt.setFloat(6, info.getReviewRating());
			pstmt.setString(7, info.getHostID());
			pstmt.setString(8, info.getHouseName());
			pstmt.setString(9, info.getPostcode());
			pstmt.executeUpdate();
            pstmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static ArrayList<Integer> lookupPropertyIDs(Connection conn, String hostID) {
        ArrayList<Integer> ids = new ArrayList<>();
        PreparedStatement pstmt = null;
		try {
            pstmt = conn.prepareStatement("SELECT * FROM Property WHERE hostID = ?");
            pstmt.setString(1, hostID);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ids.add(rs.getInt("propertyID"));
			}	
			
			rs.close();
			pstmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return ids;
	}

    public static int lookupPropertyID(Connection conn, String houseName, String postcode) {
        int propertyID = 0;
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("SELECT * FROM Property WHERE houseName = ? AND postcode = ?");
            pstmt.setString(1, houseName);
            pstmt.setString(2, postcode);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                propertyID = rs.getInt("propertyID");
            }

            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return propertyID;
    }

    public static boolean checkPropertyExists(Connection conn, String houseName, String postcode) {
        boolean exists = true;
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("SELECT * FROM Property WHERE houseName = ? AND postcode = ?");
            pstmt.setString(1, houseName);
            pstmt.setString(2, postcode);
            ResultSet rs = pstmt.executeQuery();

            exists = rs.next();

            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return exists;
    }

    public static String getPropertyName(Connection conn, int propertyID) {
        PreparedStatement pstmt = null;
        String name = null;
        try {
            pstmt = conn.prepareStatement("SELECT name FROM Property WHERE propertyID = ? ");
            pstmt.setInt(1, propertyID);

            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                name = rs.getString("name");
            }

            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return name;
    }

    public static String getHostID(Connection conn, int propertyID) {
        PreparedStatement pstmt = null;
        String name = null;
        try {
            pstmt = conn.prepareStatement("SELECT hostID FROM Property WHERE propertyID = ? ");
            pstmt.setInt(1, propertyID);

            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                name = rs.getString("hostID");
            }

            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return name;
    }
	
	public static void updateReviewRate(Connection conn, int propertyID, float newRate) {
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("UPDATE Property SET reviewRating = ? WHERE propertyID = ?");
            pstmt.setFloat(1, newRate);
            pstmt.setInt(2, propertyID);
			pstmt.executeUpdate();

            pstmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

    public static List<PropertyInfo> getProperties(Connection conn, String location, Date startDate, Date endDate) {
        PreparedStatement pstmt = null;
        List<PropertyInfo> properties = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement("SELECT * FROM Property WHERE location LIKE ?");
            pstmt.setString(1, "%" + location + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                properties.add(new PropertyInfo(
                        rs.getInt("propertyID"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("location"),
                        rs.getBoolean("isBreakfast"),
                        rs.getInt("maxGuests"),
                        rs.getFloat("reviewRating"),
                        rs.getString("hostID"),
                        rs.getString("houseName"),
                        rs.getString("postCode")
                ));
            }
            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return properties;
    }

    public static boolean checkAvailability(Connection conn, int propertyID, Date startDate, Date endDate) {
        List<List<Date>> bookedDates = Booking.getAcceptedBookings(conn, propertyID);
        boolean overlap = false;
        for (List<Date> dates : bookedDates) {
            if (overlap) {
                break;
            }
            Date startDateP = dates.get(0);
            Date endDateP = dates.get(1);
            overlap = (endDateP.equals(startDate) || endDateP.after(startDate)) && (endDate.equals(startDateP) || endDate.after(startDateP));
        }
        return overlap;
    }
    /*
    System.out.println("Possible start date" + startDate.toString());
    System.out.println("Possible end date" + endDate.toString());
    System.out.println("Actual start date" + startDateP.toString());
    System.out.println("Actual end date" + endDateP.toString());

    System.out.println(endDateP.equals(startDate));
    System.out.println(endDateP.after(startDate));
    System.out.println(endDate.equals(startDateP));
    System.out.println(endDate.after(startDateP));
     */
}
