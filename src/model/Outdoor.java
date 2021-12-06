package model;

import java.sql.*;

public class Outdoor {
	public static void putOutdoorInfo(Connection conn, OutdoorInfo info) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO Outdoor VALUES (default,?,?,?,?,?,?)");
			pstmt.setBoolean(1, info.hasFreeOnSiteParking());
			pstmt.setBoolean(2, info.hasOnRoadParking());
			pstmt.setBoolean(3, info.hasPaidParking());
			pstmt.setBoolean(4, info.hasPatio());
			pstmt.setBoolean(5, info.hasBarbeque());
			pstmt.setInt(6, info.getPropertyID());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static OutdoorInfo getOutdoorInfo(Connection conn, int propertyID) {
		OutdoorInfo info = null;

		
		try {
			String sql = "SELECT * FROM Outdoor WHERE propertyID =" + propertyID;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
                info = new OutdoorInfo(
                        rs.getInt("outdoorID"),
                        rs.getBoolean("hasFreeOnSiteParking"),
                        rs.getBoolean("hasOnRoadParking"),
                        rs.getBoolean("hasPaidParking"),
                        rs.getBoolean("hasPatio"),
                        rs.getBoolean("hasBarbeque"),
                        propertyID
                );
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return info;
	}
}
