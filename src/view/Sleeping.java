package view;

import java.sql.*;

public class Sleeping {
	public static void putSleepingInfo(Connection conn, SleepingInfo info) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO Sleeping VALUES (default,?,?,?,?,?,?)");
			pstmt.setByte(1, info.hasBedLinen);
			pstmt.setByte(2, info.hasTowel);
			pstmt.setInt(3, info.bedroomsNum);
			pstmt.setInt(4, info.bedsNum);
			pstmt.setInt(5, info.sleepersNum);
			pstmt.setInt(6, info.propertyID);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static SleepingInfo getSleepingInfo(Connection conn, int propertyID) {
		SleepingInfo info = new SleepingInfo();
		info.propertyID = propertyID;
		
		try {
			String sql = "SELECT * FROM Sleeping WHERE propertyID =" + info.propertyID;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				info.sleepingID = rs.getInt("sleepingID");
				info.hasBedLinen = rs.getByte("hasBedLinen");
				info.hasTowel = rs.getByte("hasTowel");
				info.bedroomsNum = rs.getInt("bedroomsNum");
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
