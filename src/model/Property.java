package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Property {
	
	public void registerProperty(Connection conn, PropertyInfo info) {
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
	
	public int lookupPropertyID(Connection conn, int hostID) {
		int propertyID = 0;
		
		try {
			String sql = "SELECT * FROM Property WHERE hostID =" + hostID;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				propertyID = rs.getInt("propertyID");
			}	
			
			rs.close();
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return propertyID;
	}
	
	public void updateReviewRate(Connection conn, int propertyID, float newRate) {
		try {
			String sql = "UPDATE Property SET reviewRating = " + newRate + " WHERE propertyID = " + propertyID;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			rs.close();
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

    public static List<PropertyInfo> getProperties(Connection conn, String location, Date startDate, Date endDate) {
        String query = "SELECT *"+
                "FROM team062.Property\n" +
                "JOIN team062.Booking\n" +
                "\tON Property.propertyID = Booking.propertyID;";
        PreparedStatement pstmt = null;
        List<PropertyInfo> properties = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement("SELECT * FROM Property WHERE location LIKE ?");
            pstmt.setString(1, "%" + location + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                List<List<Date>> bookedDates = Booking.getAcceptedBookings(conn, rs.getInt("propertyID"));
                String locationP = rs.getString("location");

                boolean overlap = false;
                for (List<Date> dates : bookedDates) {
                    if (overlap) {
                        break;
                    }
                    Date startDateP = dates.get(0);
                    Date endDateP = dates.get(1);
                    overlap = (endDateP.equals(startDate) || endDateP.after(startDate)) && (endDate.equals(startDateP) || endDate.after(startDateP));
                }
                if (!overlap) {
                    properties.add(new PropertyInfo(
                            rs.getString("name"),
                            rs.getString("description"),
                            locationP,
                            rs.getBoolean("isBreakfast"),
                            rs.getInt("maxGuests"),
                            rs.getFloat("reviewRating"),
                            rs.getString("hostID"),
                            rs.getString("houseName"),
                            rs.getString("postCode")
                    ));
                }
            }
            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return properties;
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
