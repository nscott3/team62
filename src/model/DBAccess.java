package model;
import java.sql.*;
import javax.swing.*;

public class DBAccess {
    static String URL = "jdbc:mysql://stusql.dcs.shef.ac.uk/";
    static String DBNAME = "team062";
    static String USER = "team062";
    static String PASSWORD = "10293718";
    static Connection conn = null;

    static public Connection connect() {
        if (conn == null) {
            DriverManager.setLoginTimeout(2);
            try {
                conn = DriverManager.getConnection(URL + DBNAME, USER, PASSWORD);
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, ex.toString() + "\n\nMake sure VPN is active and try again.", "Error!", JOptionPane.DEFAULT_OPTION);
            }
        }
        return conn;
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
