package model;

import java.sql.*;

public class Kitchen {
	public static void putKitchenInfo(Connection conn, KitchenInfo info) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO Kitchen VALUES (default,?,?,?,?,?,?,?,?,?)");
			pstmt.setBoolean(1, info.hasRefrigerator());
			pstmt.setBoolean(2, info.hasMicrowave());
			pstmt.setBoolean(3, info.hasOven());
			pstmt.setBoolean(4, info.hasStove());
			pstmt.setBoolean(5, info.hasDishwasher());
			pstmt.setBoolean(6, info.hasTableware());
			pstmt.setBoolean(7, info.hasCookware());
			pstmt.setBoolean(8, info.hasBasicProvisions());
			pstmt.setInt(9, info.getPropertyID());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static KitchenInfo getKitchenInfo(Connection conn, int propertyID) {
		KitchenInfo info = null;
		
		try {
			String sql = "SELECT * FROM Kitchen WHERE propertyID =" + propertyID;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
                info = new KitchenInfo(
                        rs.getInt("kitchenID"),
                        rs.getBoolean("hasRefrigerator"),
                        rs.getBoolean("hasMicrowave"),
                        rs.getBoolean("hasOven"),
                        rs.getBoolean("hasStove"),
                        rs.getBoolean("hasDishwasher"),
                        rs.getBoolean("hasTableware"),
                        rs.getBoolean("hasCookware"),
                        rs.getBoolean("hasBasicProvisions"),
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
