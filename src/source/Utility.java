package source;

import java.sql.*;

public class Utility {
	public static void putUtilityInfo(Connection conn, UtilityInfo info) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO Utility VALUES (?,?,?,?,?,?,?)");
			pstmt.setByte(0, info.hasCentralHeating);
			pstmt.setByte(1, info.hasWashingMachine);
			pstmt.setByte(2, info.hasDryingMachine);
			pstmt.setByte(3, info.hasFireExtinguisher);
			pstmt.setByte(4, info.hasSmokeAlarm);
			pstmt.setByte(5, info.hasFirstAidKit);
			pstmt.setInt(6, info.facilityNo);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static UtilityInfo getUtilityInfo(Connection conn, int facilityNo) {
		UtilityInfo info = new UtilityInfo();
		info.facilityNo = facilityNo;
		
		try {
			String sql = "SELECT * FROM Utility WHERE facilityNo =" + info.facilityNo;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				info.hasCentralHeating = rs.getByte("hasCentralHeating");
				info.hasWashingMachine = rs.getByte("hasWashingMachine");
				info.hasDryingMachine = rs.getByte("hasDryingMachine");
				info.hasFireExtinguisher = rs.getByte("hasFireExtinguisher");
				info.hasSmokeAlarm = rs.getByte("hasSmokeAlarm");
				info.hasFirstAidKit = rs.getByte("hasFirstAidKit");
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
