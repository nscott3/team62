package source;

import java.sql.*;

import source.Facility;

public class Property {
	private int propertyNo;
	private String name;
	private String description;
	private String location;
	private byte isBreakfast;
	private int maxGuests;
	private float reviewRating;
	private int facilityNo;
	private int hostID;
	
	public Property(
			String nameP,
			String descript,
			String locate,
			byte isbreakfast,
			int maxguests,
			int hostid) {
		
		name = nameP;
		description = descript;
		location = locate;
		isBreakfast = isbreakfast;
		maxGuests = maxguests;
		reviewRating = 0;
		hostID = hostid;
	}
	
	public void registerProperty(
			Connection conn,
			SleepingInfo sleepingInfo,
			BedroomInfo bedroomInfo,
			BathingInfo bathingInfo,
			BathroomInfo bathroomInfo,
			KitchenInfo kitchenInfo,
			LivingInfo livingInfo,
			UtilityInfo utilityInfo,
			OutdoorInfo outdoorInfo) {
		Facility.insertFacilityNo(conn, hostID);
		Facility.registerFacilityInfo(conn, sleepingInfo, bedroomInfo, bathingInfo, bathroomInfo, kitchenInfo, livingInfo, utilityInfo, outdoorInfo);
		facilityNo = Facility.lookupFacilityNo(conn, hostID);
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO Property VALUES (default,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, name);
			pstmt.setString(2, description);
			pstmt.setString(3, location);
			pstmt.setByte(4, isBreakfast);
			pstmt.setInt(5, maxGuests);
			pstmt.setFloat(6, reviewRating);
			pstmt.setInt(7, facilityNo);
			pstmt.setInt(8, hostID);
			pstmt.executeUpdate();
            pstmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public int lookupPropertyNo(Connection conn, int hostID) {
		int propertyNo = 0;
		
		try {
			String sql = "SELECT * FROM Property WHERE hostID =" + hostID;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				propertyNo = rs.getInt("propertyNo");
			}	
			
			rs.close();
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return propertyNo;
	}
	
	public void updateReviewRate(Connection conn, int propertyNo, float newRate) {
		try {
			String sql = "UPDATE Propery SET reviewRating = " + newRate + " WHERE propertyNo = " + propertyNo;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			rs.close();
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
}
