package model;

import java.sql.*;

public class Sleeping {
    public static void putSleepingInfo(Connection conn, SleepingInfo info) {
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("INSERT INTO Sleeping VALUES (default,?,?,?,?,?,?)");
            pstmt.setBoolean(1, info.hasBedLinen());
            pstmt.setBoolean(2, info.hasTowels());
            pstmt.setInt(3, info.getNumBedrooms());
            pstmt.setInt(4, info.getNumBeds());
            pstmt.setInt(5, info.getNumSleepers());
            pstmt.setInt(6, info.getPropertyID());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static SleepingInfo getSleepingInfo(Connection conn, int propertyID) {
        SleepingInfo info = null;

        try {
            String sql = "SELECT * FROM Sleeping WHERE propertyID =" + propertyID;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                info = new SleepingInfo(
                        rs.getInt("sleepingID"),
                        rs.getBoolean("hasBedLinen"),
                        rs.getBoolean("hasTowel"),
                        rs.getInt("bedroomsNum"),
                        rs.getInt("bedsNum"),
                        rs.getInt("sleepersNum"),
                        propertyID
                );
            }

            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return info;
    }
}
