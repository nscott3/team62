package model;
import java.sql.*;

public class Guest {

    public static void addGuest(Connection conn, GuestInfo info) {
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("INSERT INTO Guest (guestID, guestName) VALUES (?, ?)");
            pstmt.setString(1, info.getGuestID());
            pstmt.setString(2, info.getGuestName());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static boolean checkGuestExists(Connection conn, String email) {
        PreparedStatement pstmt = null;
        Boolean exists = true;
        try {
            pstmt = conn.prepareStatement("SELECT 1 FROM Guest WHERE guestID = ?");
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            exists = rs.next();
            rs.close();
            pstmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return exists;
    }

    public static GuestInfo getGuest(Connection conn, String email) {
        PreparedStatement pstmt = null;
        GuestInfo guest = null;
        String guestName = null;
        try {
            pstmt = conn.prepareStatement("SELECT guestName FROM Guest WHERE guestID = ?");
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                guestName = rs.getString("guestName");
            }
            rs.close();
            pstmt.close();
            guest = new GuestInfo(email, guestName);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return guest;
    }
}
