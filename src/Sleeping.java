
import java.sql.*;

public class Sleeping {
	public static void putSleepingInfo(Connection conn, SleepingInfo info) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO Sleeping VALUES (?,?,?,?,?)");
			pstmt.setByte(0, info.hasBedLinen);
			pstmt.setByte(1, info.hasTowel);
			pstmt.setInt(2, info.bedroomsNum);
			pstmt.setInt(3, info.facilityNo);
			pstmt.setInt(4, info.bedroomNo);
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static SleepingInfo getSleepingInfo(Connection conn, int facilityNo) {
		SleepingInfo info = new SleepingInfo();
		info.facilityNo = facilityNo;
		
		try {
			String sql = "SELECT * FROM Sleeping WHERE facilityNo =" + info.facilityNo;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				info.hasBedLinen = rs.getByte("hasBedLinen");
				info.hasTowel = rs.getByte("hasTowel");
				info.bedroomsNum = rs.getInt("bedroomsNum");
				info.bedroomNo = rs.getInt("bedroomNo");
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return info;
	}
}
