package model;
import java.sql.*;

public class Host {

    public static void addHost(Connection conn, HostInfo info) {
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("INSERT INTO Host (hostID, hostName, isSuperhost) VALUES (?, ?, ?)");
            pstmt.setString(1, info.getHostID());
            pstmt.setString(2, info.getHostName());
            pstmt.setBoolean(3, info.getSuperHost());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static boolean checkHostExists(Connection conn, String email) {
        PreparedStatement pstmt = null;
        Boolean exists = true;
        try {
            pstmt = conn.prepareStatement("SELECT 1 FROM Host WHERE hostID = ?");
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

}
