import java.sql.*;

public class DBAccess {
    static String URL = "jdbc:mysql://stusql.dcs.shef.ac.uk/";
    static String DBNAME = "team062";
    static String USER = "team062";
    static String PASSWORD = "10293718";
    static Connection conn = null;

    static public boolean connect() {
        boolean connected = true;
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(URL + DBNAME, USER, PASSWORD);
            } catch (Exception ex) {
                connected = false;
                ex.printStackTrace();
            }
        }
        return connected;
    }

    static public void disconnect() {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            conn = null;
        }
    }
}
