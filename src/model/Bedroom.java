package model;

import java.sql.*;

public class Bedroom {
	public static void putBedroomInfo(Connection conn, BedroomInfo info) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO Bedroom VALUES (default,?,?,?,?,?)");
			pstmt.setString(1, info.bedType1);
			pstmt.setString(2, info.bedType2);
			pstmt.setInt(3, info.bedsNum);
			pstmt.setInt(4, info.sleepersNum);
			pstmt.setInt(5, info.sleepingID);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static BedroomInfo getBedroomInfo(Connection conn, int sleepingID) {
		BedroomInfo info = new BedroomInfo();
		info.sleepingID = sleepingID;
		
		try {
			String sql = "SELECT * FROM Bedroom WHERE sleepingID =" + info.sleepingID;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				info.bedroomID = rs.getInt("bedroomID");
				info.bedType1 = rs.getString("bedType1");
				info.bedType2 = rs.getString("bedType2");
				info.bedsNum = rs.getInt("bedsNum");
				info.sleepersNum = rs.getInt("sleepersNum");
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return info;
	}
}
