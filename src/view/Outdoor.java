package view;

import java.sql.*;

public class Outdoor {
	public static void putOutdoorInfo(Connection conn, OutdoorInfo info) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO Outdoor VALUES (default,?,?,?,?,?,?)");
			pstmt.setByte(1, info.hasFreeOnSiteParking);
			pstmt.setByte(2, info.hasOnRoadParking);
			pstmt.setByte(3, info.hasPaidParking);
			pstmt.setByte(4, info.hasPatio);
			pstmt.setByte(5, info.hasBarbeque);
			pstmt.setInt(6, info.propertyID);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static OutdoorInfo getOutdoorInfo(Connection conn, int propertyID) {
		OutdoorInfo info = new OutdoorInfo();
		info.propertyID = propertyID;
		
		try {
			String sql = "SELECT * FROM Outdoor WHERE propertyID =" + info.propertyID;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				info.outdoorID = rs.getInt("outdoorID");
				info.hasFreeOnSiteParking = rs.getByte("hasFreeOnSiteParking");
				info.hasOnRoadParking = rs.getByte("hasOnRoadParking");
				info.hasPaidParking = rs.getByte("hasPaidParking");
				info.hasPatio = rs.getByte("hasPatio");
				info.hasBarbeque = rs.getByte("hasBarbeque");
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return info;
	}
}
