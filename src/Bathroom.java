
import java.sql.*;

public class Bathroom {
	public void putBathroomInfo(Connection conn, BathroomInfo info) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO Bathroom VALUES (default,?,?,?,?)");
			pstmt.setByte(1, info.hasToilet);
			pstmt.setByte(2, info.hasBath);
			pstmt.setByte(3, info.hasShower);
			pstmt.setByte(4, info.isShared);
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public BathroomInfo getBathroomInfo(Connection conn, int bathroomNo) {
		BathroomInfo info = new BathroomInfo();
		info.bathroomNo = bathroomNo;
		
		try {
			String sql = "SELECT * FROM Bathroom WHERE bathroomNo =" + info.bathroomNo;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				info.hasToilet = rs.getString("hasToilet");
				info.hasBath = rs.getString("hasBath");
				info.hasShower = rs.getInt("hasShower");
				info.isShared = rs.getInt("isShared");
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return info;
	}
}
