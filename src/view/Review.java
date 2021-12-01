package view;

import java.sql.*;

public class Review {
	private int bookingID;
	private String description;
	private int scoreCleanliness;
	private int scoreCommunication;
	private int scoreCheckin;
	private int scoreAccuracy;
	private int scoreLocation;
	private int scoreValue;
	
	public Review(
			int bookingIDR,
			String descriptionR,
			int cleanliness,
			int communication,
			int checkin,
			int accuracy,
			int location,
			int value) {
		bookingID = bookingIDR;
		description = descriptionR;
		scoreCleanliness = cleanliness;
		scoreCommunication = communication;
		scoreCheckin = checkin;
		scoreAccuracy = accuracy;
		scoreLocation = location;
		scoreValue = value;
	}
	
	public void registerReview(Connection conn) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO Review VALUES (?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, bookingID);
			pstmt.setString(2, description);
			pstmt.setInt(3, scoreCleanliness);
			pstmt.setInt(4, scoreCommunication);
			pstmt.setInt(5, scoreCheckin);
			pstmt.setInt(6, scoreAccuracy);
			pstmt.setInt(7, scoreLocation);
			pstmt.setInt(8, scoreValue);
			pstmt.executeUpdate();
            pstmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public float calculateReviewRating(Connection conn, int bookingID) {
		float avg = 0;
		
		try {
			String sql = "SELECT * FROM Review WHERE bookingID =" + bookingID;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				scoreCleanliness = rs.getInt("scoreCleanliness");
				scoreCommunication = rs.getInt("scoreCommunication");
				scoreCheckin = rs.getInt("scoreCheckin");
				scoreAccuracy = rs.getInt("scoreAccuracy");
				scoreLocation = rs.getInt("scoreLocation");
				scoreValue = rs.getInt("scoreValue");
			}
			avg = (scoreCleanliness + scoreCommunication + scoreCheckin + scoreAccuracy + scoreLocation + scoreValue) / 6;
			
			rs.close();
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return avg;
	}
}
