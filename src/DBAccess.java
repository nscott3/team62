import java.sql.*;

public class DBAccess {
    private static String URL = "jdbc:mysql://stusql.dcs.shef.ac.uk/";
    private static String DBNAME = "team062";
    private static String USER = "team062";
    private static String PASSWORD = "10293718";
    private static Connection conn = null;
	
    static public Connection connect() {
        Statement statement = null;
    	ResultSet resultSet = null;
    	String exquery = "SELECT * FROM Person";
        boolean connected = true;
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(URL + DBNAME, USER, PASSWORD);
                statement = conn.createStatement();
    			resultSet = statement.executeQuery(exquery);
    			String sql = "select * from Person";
    			PreparedStatement pstmt = conn.prepareStatement(sql);
    			ResultSet rs = pstmt.executeQuery();

    			ResultSetMetaData rsmd = rs.getMetaData();
    			int columnCnt = rsmd.getColumnCount();
    			if(rs.next()){
    			  for(int i=1 ; i<=columnCnt ; i++){
    			       System.out.println(rsmd.getColumnName(i)+","+rs.getString(rsmd.getColumnName(i)));  
    			  }
    			}
            } catch (Exception ex) {
                connected = false;
                ex.printStackTrace();
            } finally {
    			if (resultSet != null)
    				try {				
    					resultSet.close();
    				} catch (Exception ex) {
    					ex.printStackTrace();
    				}
    				if (statement != null)
    				try {
    					statement.close();
    				} catch (Exception ex) {
    					ex.printStackTrace();
    				}
    				if (conn != null)
    				try {
    					conn.close();
    				} catch (Exception ex) {
    					ex.printStackTrace();
    				}
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
