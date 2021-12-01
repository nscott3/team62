package model;

public class PersonInfo {
    private String title;
    private String forename;
    private String surname;
    private String email;
    private String mobileNumber;
    private String password;

    public PersonInfo(String t, String fname, String sname, String em, String number, String pword) {
        title = t;
        forename = fname;
        surname = sname;
        email = em;
        mobileNumber = number;
        password = pword;
    }

    public String getTitle() {
        return title;
    }

    public String getForename() {
        return forename;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getPassword() {
        return password;
    }
}
