package view;

import java.sql.*;

public class Living {
	public static void putLivingInfo(Connection conn, LivingInfo info) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO Living VALUES (default,?,?,?,?,?,?,?)");
			pstmt.setByte(1, info.hasWifi);
			pstmt.setByte(2, info.hasTV);
			pstmt.setByte(3, info.hasSatellite);
			pstmt.setByte(4, info.hasStreaming);
			pstmt.setByte(5, info.hasDvdPlayer);
			pstmt.setByte(6, info.hasBoardGames);
			pstmt.setInt(7, info.propertyID);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static LivingInfo getLivingInfo(Connection conn, int propertyID) {
		LivingInfo info = new LivingInfo();
		info.propertyID = propertyID;
		
		try {
			String sql = "SELECT * FROM Living WHERE propertyID =" + info.propertyID;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				info.livingID = rs.getInt("livingID");
				info.hasWifi = rs.getByte("hasWifi");
				info.hasTV = rs.getByte("hasTV");
				info.hasSatellite = rs.getByte("hasSatellite");
				info.hasStreaming = rs.getByte("hasStreaming");
				info.hasDvdPlayer = rs.getByte("hasDvdPlayer");
				info.hasBoardGames = rs.getByte("hasBoardGames");
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return info;
	}
}
