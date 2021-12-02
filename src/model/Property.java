package model;

import java.sql.*;

import java.sql.*;

public class Property {
	private int propertyID;
	private String name;
	private String description;
	private String location;
	private byte isBreakfast;
	private int maxGuests;
	private float reviewRating;
	private int hostID;
	private String houseName;
	private String postcode;
	
	public Property(
			String nameP,
			String descriptionP,
			String locationP,
			byte isBreakfastP,
			int maxGuestsP,
			int hostIDP,
			String houseNameP,
			String postcodeP) {
		
		name = nameP;
		description = descriptionP;
		location = locationP;
		isBreakfast = isBreakfastP;
		maxGuests = maxGuestsP;
		reviewRating = 0;
		hostID = hostIDP;
		houseName = houseNameP;
		postcode = postcodeP;
	}
	
	public void registerProperty(Connection conn) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO Property VALUES (default,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, name);
			pstmt.setString(2, description);
			pstmt.setString(3, location);
			pstmt.setByte(4, isBreakfast);
			pstmt.setInt(5, maxGuests);
			pstmt.setFloat(6, reviewRating);
			pstmt.setInt(7, hostID);
			pstmt.setString(8, houseName);
			pstmt.setString(9, postcode);
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
			String sql = "UPDATE Propery SET reviewRating = " + newRate + " WHERE propertyID = " + propertyID;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			rs.close();
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
}
