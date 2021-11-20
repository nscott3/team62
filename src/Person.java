import java.sql.*;

public class Person {
    private String title;
    private String forename;
    private String surname;
    private String email;
    private String mobileNumber;

    public void register(Connection conn) {
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("INSERT INTO Person (title, forename, surname, email, mobileNumber) VALUES (?, ?, ?, ?, ?)");
            pstmt.setString(1, title);
            pstmt.setString(2, forename);
            pstmt.setString(3, surname);
            pstmt.setString(4, email);
            pstmt.setString(5, mobileNumber);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
