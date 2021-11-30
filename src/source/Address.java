package source;
import java.sql.*;

public class Address {
    private String houseName;
    private String streetName;
    private String placeName;
    private String postcode;

    public Address(String house, String street, String place, String post) {
        houseName = house;
        streetName = street;
        placeName = place;
        postcode = post;
    }

    public void addAddress(Connection conn) {
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("INSERT INTO Address (houseName, streetName, placeName, postcode) VALUES (?, ?, ?, ?)");
            pstmt.setString(1, houseName);
            pstmt.setString(2, streetName);
            pstmt.setString(3, placeName);
            pstmt.setString(4, postcode);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Integer lookupID(Connection conn) {
        int addressID = 0;
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("SELECT addressID FROM Address WHERE houseName = ? AND streetName = ? AND placeName = ? AND postcode = ?");
            pstmt.setString(1, houseName);
            pstmt.setString(2, streetName);
            pstmt.setString(3, placeName);
            pstmt.setString(4, postcode);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                addressID = rs.getInt("addressID");
            }
            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return addressID;
    }
}
