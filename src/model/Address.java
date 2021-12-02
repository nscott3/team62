package model;

import java.sql.*;

public class Address {

    public static void addAddress(Connection conn, AddressInfo info) {
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("INSERT INTO Address (houseName, streetName, placeName, postcode) VALUES (?, ?, ?, ?)");
            pstmt.setString(1, info.getHouseName());
            pstmt.setString(2, info.getStreetName());
            pstmt.setString(3, info.getPlaceName());
            pstmt.setString(4, info.getPostcode());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static boolean checkAddressExists(Connection conn, AddressInfo info) {
        PreparedStatement pstmt = null;
        Boolean exists = true;
        try {
            pstmt = conn.prepareStatement("SELECT 1 FROM Address WHERE houseName = ? AND postcode = ?");
            pstmt.setString(1, info.getHouseName());
            pstmt.setString(2, info.getPostcode());
            ResultSet rs = pstmt.executeQuery();

            exists = rs.next();
            rs.close();
            pstmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return exists;
    }
}
