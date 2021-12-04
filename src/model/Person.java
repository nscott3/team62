package model;
import java.sql.*;
import view.GuestView;

public class Person {
    public static void register(Connection conn, PersonInfo pInfo, AddressInfo aInfo) {
        byte[] salt  = Hashing.generateSalt();

        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("INSERT INTO Person (email, title, forename, surname, mobileNumber, password, salt, houseName, postcode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, pInfo.getEmail());
            pstmt.setString(2, pInfo.getTitle());
            pstmt.setString(3, pInfo.getForename());
            pstmt.setString(4, pInfo.getSurname());
            pstmt.setString(5, pInfo.getMobileNumber());
            pstmt.setBytes(6, Hashing.generateHash(pInfo.getPassword(), salt));
            pstmt.setBytes(7, salt);
            pstmt.setString(8, aInfo.getHouseName());
            pstmt.setString(9, aInfo.getPostcode());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static boolean login(Connection conn, String email, String password) {
        byte[] matchedHash = null;
        byte[] matchedSalt = null;

        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("SELECT password, salt FROM Person WHERE email = ?");
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                matchedHash = rs.getBytes("password");
                matchedSalt = rs.getBytes("salt");
            }
            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (matchedHash == null || matchedSalt == null) {
            return false;
        } else {
            return Hashing.compareHashes(matchedHash, Hashing.generateHash(password, matchedSalt));
        }
    }

    public static boolean checkUserExists(Connection conn, String email) {
        PreparedStatement pstmt = null;
        Boolean exists = true;
        try {
            pstmt = conn.prepareStatement("SELECT 1 FROM Person WHERE email = ?");
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

    public static PersonInfo getPerson(Connection conn, String email) {
        PreparedStatement pstmt = null;
        PersonInfo person = null;
        String title = null;
        String forename = null;
        String surname = null;
        String mobileNumber = null;
        try {
            pstmt = conn.prepareStatement("SELECT title, forename, surname, mobileNumber FROM Person WHERE email = ?");
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                title = rs.getString("title");
                forename = rs.getString("forename");
                surname = rs.getString("surname");
                mobileNumber = rs.getString("mobileNumber");
            }
            rs.close();
            pstmt.close();
            person = new PersonInfo(title, forename, surname, email, mobileNumber, "");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return person;
    }
}
