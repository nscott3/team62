package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Bedroom {
	public static void putBedroomInfo(Connection conn, BedroomInfo info) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO Bedroom VALUES (default,?,?,?,?,?)");
			pstmt.setString(1, info.getBedType1());
			pstmt.setString(2, info.getBedType2());
			pstmt.setInt(3, info.getBedsNum());
			pstmt.setInt(4, info.getSleepersNum());
			pstmt.setInt(5, info.getSleepingID());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static List<BedroomInfo> getBedroomInfo(Connection conn, int sleepingID) {
        List<BedroomInfo> bedrooms = new ArrayList<>();
		try {
			String sql = "SELECT * FROM Bedroom WHERE sleepingID =" + sleepingID;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
                bedrooms.add(new BedroomInfo(
                        rs.getInt("bedroomID"),
                        rs.getString("bedType1"),
                        rs.getString("bedType2"),
                        rs.getInt("bedsNum"),
                        rs.getInt("sleepersNum"),
                        sleepingID
                ));
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return bedrooms;
	}
}
