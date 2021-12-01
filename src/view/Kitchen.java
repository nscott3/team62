package view;

import java.sql.*;

public class Kitchen {
	public static void putKitchenInfo(Connection conn, KitchenInfo info) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO Kitchen VALUES (default,?,?,?,?,?,?,?,?,?)");
			pstmt.setByte(1, info.hasRefrigerator);
			pstmt.setByte(2, info.hasMicrowave);
			pstmt.setByte(3, info.hasOven);
			pstmt.setByte(4, info.hasStove);
			pstmt.setByte(5, info.hasDishwasher);
			pstmt.setByte(6, info.hasTableware);
			pstmt.setByte(7, info.hasCookware);
			pstmt.setByte(8, info.hasBasicProvisions);
			pstmt.setInt(9, info.propertyID);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static KitchenInfo getKitchenInfo(Connection conn, int propertyID) {
		KitchenInfo info = new KitchenInfo();
		info.propertyID = propertyID;
		
		try {
			String sql = "SELECT * FROM Kitchen WHERE propertyID =" + info.propertyID;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				info.kitchenID = rs.getInt("kitchenID");
				info.hasRefrigerator = rs.getByte("hasRefrigerator");
				info.hasMicrowave = rs.getByte("hasMicrowave");
				info.hasOven = rs.getByte("hasOven");
				info.hasStove = rs.getByte("hasStove");
				info.hasDishwasher = rs.getByte("hasDishwasher");
				info.hasTableware = rs.getByte("hasTableware");
				info.hasCookware = rs.getByte("hasCookware");
				info.hasBasicProvisions = rs.getByte("hasBasicProvisions");
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return info;
	}
}
