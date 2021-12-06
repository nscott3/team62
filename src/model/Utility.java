package model;

import java.sql.*;

import model.UtilityInfo;

public class Utility {
    public static void putUtilityInfo(Connection conn, UtilityInfo info) {
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("INSERT INTO Utility VALUES (default,?,?,?,?,?,?,?)");
            pstmt.setBoolean(1, info.hasCentralHeating());
            pstmt.setBoolean(2, info.hasWashingMachine());
            pstmt.setBoolean(3, info.hasDryingMachine());
            pstmt.setBoolean(4, info.hasFireExtinguisher());
            pstmt.setBoolean(5, info.hasSmokeAlarm());
            pstmt.setBoolean(6, info.hasFirstAidKit());
            pstmt.setInt(7, info.getPropertyID());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static UtilityInfo getUtilityInfo(Connection conn, int propertyID) {
        UtilityInfo info = null;


        try {
            String sql = "SELECT * FROM Utility WHERE propertyID =" + propertyID;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                info = new UtilityInfo(
                        rs.getInt("utilityID"),
                        rs.getBoolean("hasCentralHeating"),
                        rs.getBoolean("hasWashingMachine"),
                        rs.getBoolean("hasDryingMachine"),
                        rs.getBoolean("hasFireExtinguisher"),
                        rs.getBoolean("hasSmokeAlarm"),
                        rs.getBoolean("hasFirstAidKit"),
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
