import java.sql.*;

public class Person {
    private String title;
    private String forename;
    private String surname;
    private String email;
    private String mobileNumber;
    private String password;
    private Host host;
    private Guest guest;
    private Address address;

    public Person(String t, String fname, String sname, String em, String number, String pword, Host hst, Guest gst, Address addr) {
        title = t;
        forename = fname;
        surname = sname;
        email = em;
        mobileNumber = number;
        password = pword;
        host = hst;
        guest = gst;
        address = addr;
    }

    public void register(Connection conn) {
        host.addHost(conn);
        guest.addGuest(conn);
        address.addAddress(conn);

        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("INSERT INTO Person (title, forename, surname, email, mobileNumber, password, hostID, guestID, addressID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, title);
            pstmt.setString(2, forename);
            pstmt.setString(3, surname);
            pstmt.setString(4, email);
            pstmt.setString(5, mobileNumber);
            pstmt.setString(6, password);
            pstmt.setInt(7, host.lookupID(conn));
            pstmt.setInt(8, guest.lookupID(conn));
            pstmt.setInt(9, address.lookupID(conn));
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void login(Connection conn) {

    }
}
