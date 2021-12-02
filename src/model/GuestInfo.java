package model;

public class GuestInfo {
    private String guestID;
    private String guestName;

    public GuestInfo(String email, String name) {
        guestID = email;
        guestName = name;
    }

    public String getGuestID() {
        return guestID;
    }

    public String getGuestName() {
        return guestName;
    }

}
