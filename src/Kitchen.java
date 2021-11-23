
import java.sql.*;

public class Kitchen {
	public void putKitchenInfo(Connection conn, KitchenInfo info) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO Kitchen VALUES (?,?,?,?,?,?,?,?,?)");
			pstmt.setByte(0, info.hasRefrigerator);
			pstmt.setByte(1, info.hasMicrowave);
			pstmt.setByte(2, info.hasOven);
			pstmt.setByte(3, info.hasStove);
			pstmt.setByte(4, info.hasDishwasher);
			pstmt.setByte(5, info.hasTableware);
			pstmt.setByte(6, info.hasCookware);
			pstmt.setByte(7, info.hasBasicProvisions);
			pstmt.setInt(8, info.facilityNo);
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public KitchenInfo getKitchenInfo(Connection conn, int facilityNo) {
		KitchenInfo info = new KitchenInfo();
		info.facilityNo = facilityNo;
		
		try {
			String sql = "SELECT * FROM Kitchen WHERE facilityNo =" + info.facilityNo;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				info.hasRefrigerator = rs.getByte("hasRefrigerator");
				info.hasMicrowave = rs.getByte("hasMicrowave");
				info.hasOven = rs.getByte("hasOven");
				info.hasStove = rs.getByte("hasStove");
				info.hasDishwasher = rs.getByte("hasDishwasher");
				info.hasTableware = rs.getByte("hasTableware");
				info.hasCookware = rs.getByte("hasCookware");
				info.hasBasicProvisions = rs.getByte("hasBasicProvisions");
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
