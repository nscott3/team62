package source;
import java.sql.*;

public class Host {
    private String hostName;
    private boolean isSuperHost;

    public Host(String hName, boolean superHost) {
        hostName = hName;
        isSuperHost = superHost;
    }

    public void addHost(Connection conn) {
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("INSERT INTO Host (hostName, isSuperhost) VALUES (?, ?)");
            pstmt.setString(1, hostName);
            pstmt.setBoolean(2, isSuperHost);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Integer lookupID(Connection conn) {
        int hostID = 0;
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("SELECT hostID FROM Host WHERE hostName = ?");
            pstmt.setString(1, hostName);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                hostID = rs.getInt("hostID");
            }
            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return hostID;
    }

}
