package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChargeBand {

    public static void putChargeBand(Connection conn, ChargeBandInfo info) {
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("INSERT INTO ChargeBand VALUES (?,?,?,?,?,?)");
            pstmt.setInt(1, info.getPropertyID());
            pstmt.setDate(2, info.getStartDate());
            pstmt.setDate(3, info.getEndDate());
            pstmt.setFloat(4, (float) info.getPricePerNight());
            pstmt.setFloat(5, (float) info.getServiceCharge());
            pstmt.setFloat(6, (float) info.getCleaningCharge());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static ArrayList<ChargeBandInfo> getChargeBands(Connection conn, int propertyID) {
        ArrayList<ChargeBandInfo> bands = new ArrayList<>();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("SELECT * FROM ChargeBand WHERE propertyID = ?");
            pstmt.setInt(1, propertyID);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                bands.add(new ChargeBandInfo(
                        rs.getInt("PropertyID"),
                        rs.getDate("startDate"),
                        rs.getDate("endDate"),
                        rs.getDouble("pricePerNight"),
                        rs.getDouble("serviceCharge"),
                        rs.getDouble("cleaningCharge")
                        ));
            }

            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return bands;
    }
}
