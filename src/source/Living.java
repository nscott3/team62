package source;

import java.sql.*;

public class Living {
	public static void putLivingInfo(Connection conn, LivingInfo info) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO Living VALUES (?,?,?,?,?,?,?)");
			pstmt.setByte(0, info.hasWifi);
			pstmt.setByte(1, info.hasTV);
			pstmt.setByte(2, info.hasSatellite);
			pstmt.setByte(3, info.hasStreaming);
			pstmt.setByte(4, info.hasDvdPlayer);
			pstmt.setByte(5, info.hasBoardGames);
			pstmt.setInt(6, info.facilityNo);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static LivingInfo getLivingInfo(Connection conn, int facilityNo) {
		LivingInfo info = new LivingInfo();
		info.facilityNo = facilityNo;
		
		try {
			String sql = "SELECT * FROM Living WHERE facilityNo =" + info.facilityNo;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				info.hasWifi = rs.getByte("hasWifi");
				info.hasTV = rs.getByte("hasTV");
				info.hasSatellite = rs.getByte("hasSatellite");
				info.hasStreaming = rs.getByte("hasStreaming");
				info.hasDvdPlayer = rs.getByte("hasDvdPlayer");
				info.hasBoardGames = rs.getByte("hasBoardGames");
				info.facilityNo = rs.getInt("facilityNo");
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return info;
	}
}
