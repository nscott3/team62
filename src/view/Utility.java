package view;

import java.sql.*;

public class Utility {
	public static void putUtilityInfo(Connection conn, UtilityInfo info) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO Utility VALUES (default,?,?,?,?,?,?,?)");
			pstmt.setByte(1, info.hasCentralHeating);
			pstmt.setByte(2, info.hasWashingMachine);
			pstmt.setByte(3, info.hasDryingMachine);
			pstmt.setByte(4, info.hasFireExtinguisher);
			pstmt.setByte(5, info.hasSmokeAlarm);
			pstmt.setByte(6, info.hasFirstAidKit);
			pstmt.setInt(7, info.propertyID);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static UtilityInfo getUtilityInfo(Connection conn, int propertyID) {
		UtilityInfo info = new UtilityInfo();
		info.propertyID = propertyID;
		
		try {
			String sql = "SELECT * FROM Utility WHERE propertyID =" + info.propertyID;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				info.utilityID = rs.getInt("utilityID");
				info.hasCentralHeating = rs.getByte("hasCentralHeating");
				info.hasWashingMachine = rs.getByte("hasWashingMachine");
				info.hasDryingMachine = rs.getByte("hasDryingMachine");
				info.hasFireExtinguisher = rs.getByte("hasFireExtinguisher");
				info.hasSmokeAlarm = rs.getByte("hasSmokeAlarm");
				info.hasFirstAidKit = rs.getByte("hasFirstAidKit");
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return info;
	}
}
