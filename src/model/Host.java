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

    public static HostInfo getHost(Connection conn, String email) {
        PreparedStatement pstmt = null;
        HostInfo host = null;
        String hostName = null;
        boolean isSuperhost = false;
        try {
            pstmt = conn.prepareStatement("SELECT * FROM Host WHERE hostID = ?");
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                hostName = rs.getString("hostName");
                isSuperhost = rs.getBoolean("isSuperhost");
            }
            rs.close();
            pstmt.close();
            host = new HostInfo(email, hostName, isSuperhost);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return host;
    }

    public static void changeSuperHost(Connection conn, String email, boolean isSuperhost) {
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement("UPDATE Host SET isSuperhost = ? WHERE hostID = ?");
            pstmt.setBoolean(1, isSuperhost);
            pstmt.setString(2, email);
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
