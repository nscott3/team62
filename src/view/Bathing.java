package view;

import java.sql.*;

public class Bathing {
	
	public static void putBathingInfo(Connection conn, BathingInfo info) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO Bathing VALUES (default,?,?,?,?,?)");
			pstmt.setByte(1, info.hasHairDryer);
			pstmt.setByte(2, info.hasShampoo);
			pstmt.setByte(3, info.hasToiletpaper);
			pstmt.setInt(4, info.bathroomNum);
			pstmt.setInt(5, info.propertyID);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static BathingInfo getBathingInfo(Connection conn, int propertyID) {
		BathingInfo info = new BathingInfo();
		info.propertyID = propertyID;
		
		try {
			String sql = "SELECT * FROM Bathing WHERE propertyID =" + info.propertyID;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				info.bathingID = rs.getInt("bathingID");
				info.hasHairDryer = rs.getByte("hasHairDryer");
				info.hasShampoo = rs.getByte("hasShampoo");
				info.hasToiletpaper = rs.getByte("hasToiletpaper");
				info.bathroomNum = rs.getInt("bathroomNum");
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return info;
	}
}
