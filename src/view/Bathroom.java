package view;

import java.sql.*;

public class Bathroom {
	public static void putBathroomInfo(Connection conn, BathroomInfo info) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO Bathroom VALUES (default,?,?,?,?,?)");
			pstmt.setByte(1, info.hasToilet);
			pstmt.setByte(2, info.hasBath);
			pstmt.setByte(3, info.hasShower);
			pstmt.setByte(4, info.isShared);
			pstmt.setInt(5, info.bathingID);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static BathroomInfo getBathroomInfo(Connection conn, int bathingID) {
		BathroomInfo info = new BathroomInfo();
		info.bathingID = bathingID;
		
		try {
			String sql = "SELECT * FROM Bathroom WHERE bathingID =" + info.bathingID;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				info.bathroomID = rs.getInt("bathroomID");
				info.hasToilet = rs.getByte("hasToilet");
				info.hasBath = rs.getByte("hasBath");
				info.hasShower = rs.getByte("hasShower");
				info.isShared = rs.getByte("isShared");
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return info;
	}
}
