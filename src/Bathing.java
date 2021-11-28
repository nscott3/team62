
import java.sql.*;

public class Bathing {
	
	public static void putBathingInfo(Connection conn, BathingInfo info) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO Bathing VALUES (?,?,?,?,?,?)");
			pstmt.setByte(0, info.hasHairDryer);
			pstmt.setByte(1, info.hasShampoo);
			pstmt.setByte(2, info.hasToiletpaper);
			pstmt.setInt(3, info.bathroomNum);
			pstmt.setInt(4, info.facilityNo);
			pstmt.setInt(5, info.bathroomNo);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static BathingInfo getBathingInfo(Connection conn, int facilityNo) {
		BathingInfo info = new BathingInfo();
		info.facilityNo = facilityNo;
		
		try {
			String sql = "SELECT * FROM Bathing WHERE facilityNo =" + info.facilityNo;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				info.hasHairDryer = rs.getByte("hasHairDryer");
				info.hasShampoo = rs.getByte("hasShampoo");
				info.hasToiletpaper = rs.getByte("hasToiletpaper");
				info.bathroomNum = rs.getInt("bathroomNum");
				info.facilityNo = rs.getInt("facilityNo");
				info.bathroomNo = rs.getInt("bathroomNo");
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return info;
	}
}
