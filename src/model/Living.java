package model;

import java.sql.*;

public class Living {
	public static void putLivingInfo(Connection conn, LivingInfo info) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO Living VALUES (default,?,?,?,?,?,?,?)");
			pstmt.setBoolean(1, info.hasWifi());
			pstmt.setBoolean(2, info.hasTV());
			pstmt.setBoolean(3, info.hasSatellite());
			pstmt.setBoolean(4, info.hasStreaming());
			pstmt.setBoolean(5, info.hasDvdPlayer());
			pstmt.setBoolean(6, info.hasBoardGames());
			pstmt.setInt(7, info.getPropertyID());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static LivingInfo getLivingInfo(Connection conn, int propertyID) {
		LivingInfo info = null;
		
		try {
			String sql = "SELECT * FROM Living WHERE propertyID =" + propertyID;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
                info = new LivingInfo(
                        rs.getInt("livingID"),
                        rs.getBoolean("hasWifi"),
                        rs.getBoolean("hasTV"),
                        rs.getBoolean("hasSatellite"),
                        rs.getBoolean("hasStreaming"),
                        rs.getBoolean("hasDvdPlayer"),
                        rs.getBoolean("hasBoardGames"),
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
