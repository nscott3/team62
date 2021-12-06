package model;

import java.sql.*; 

public class Bathing {
	
	public static void putBathingInfo(Connection conn, BathingInfo info) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO Bathing VALUES (default,?,?,?,?,?)");
			pstmt.setBoolean(1, info.hasHairDryer());
			pstmt.setBoolean(2, info.hasShampoo());
			pstmt.setBoolean(3, info.hasToiletPaper());
			pstmt.setInt(4, info.getBathroomNum());
			pstmt.setInt(5, info.getPropertyID());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static BathingInfo getBathingInfo(Connection conn, int propertyID) {
		BathingInfo info = null;
		
		try {
			String sql = "SELECT * FROM Bathing WHERE propertyID =" + propertyID;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
                info = new BathingInfo(
                        rs.getInt("bathingID"),
                        rs.getBoolean("hasHairDryer"),
                        rs.getBoolean("hasShampoo"),
                        rs.getBoolean("hasToiletpaper"),
                        rs.getInt("bathroomNum"),
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
