import java.sql.*;

import javax.swing.JFrame;

public class Guest extends JFrame {
    private String guestName;
    
    public Guest(String gName) {
        guestName = gName;
    }

    public void addGuest(Connection conn) {
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("INSERT INTO Guest (guestName) VALUES (?)");
            pstmt.setString(1, guestName);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Integer lookupID(Connection conn) {
        int guestID = 0;
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("SELECT guestID FROM Guest WHERE guestName = ?");
            pstmt.setString(1, guestName);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                guestID = rs.getInt("guestID");
            }
            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return guestID;
    }
}
