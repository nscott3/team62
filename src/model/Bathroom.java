package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Bathroom {
	public static void putBathroomInfo(Connection conn, BathroomInfo info) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO Bathroom VALUES (default,?,?,?,?,?)");
			pstmt.setBoolean(1, info.hasToilet());
			pstmt.setBoolean(2, info.hasBath());
			pstmt.setBoolean(3, info.hasShower());
			pstmt.setBoolean(4, info.isShared());
			pstmt.setInt(5, info.getBathingID());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static List<BathroomInfo> getBathroomInfo(Connection conn, int bathingID) {
        List<BathroomInfo> bathrooms = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM Bathroom WHERE bathingID =" + bathingID;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
                bathrooms.add(new BathroomInfo(
                        rs.getInt("bathroomID"),
                        rs.getBoolean("hasToilet"),
                        rs.getBoolean("hasBath"),
                        rs.getBoolean("hasShower"),
                        rs.getBoolean("isShared"),
                        bathingID
                ));
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return bathrooms;
	}
}
