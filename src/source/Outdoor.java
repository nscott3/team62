package source;

import java.sql.*;

public class Outdoor {
	public static void putOutdoorInfo(Connection conn, OutdoorInfo info) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO Outdoor VALUES (?,?,?,?,?,?)");
			pstmt.setByte(0, info.hasFreeOnSiteParking);
			pstmt.setByte(1, info.hasOnRoadParking);
			pstmt.setByte(2, info.hasPaidParking);
			pstmt.setByte(3, info.hasPatio);
			pstmt.setByte(4, info.hasBarbeque);
			pstmt.setInt(5, info.facilityNo);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static OutdoorInfo getOutdoorInfo(Connection conn, int facilityNo) {
		OutdoorInfo info = new OutdoorInfo();
		info.facilityNo = facilityNo;
		
		try {
			String sql = "SELECT * FROM Outdoor WHERE facilityNo =" + info.facilityNo;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				info.hasFreeOnSiteParking = rs.getByte("hasFreeOnSiteParking");
				info.hasOnRoadParking = rs.getByte("hasOnRoadParking");
				info.hasPaidParking = rs.getByte("hasPaidParking");
				info.hasPatio = rs.getByte("hasPatio");
				info.hasBarbeque = rs.getByte("hasBarbeque");
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
