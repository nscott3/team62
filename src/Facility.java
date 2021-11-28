import java.sql.*;

public class Facility {
	public void insertFacilityNo(Connection conn) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO Facility Values default");
			//auto-increment
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
