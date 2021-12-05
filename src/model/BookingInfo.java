package model;

import java.sql.Date;

public class BookingInfo {
    private int bookingID;
    private Date startDate;
    private Date endDate;
    private boolean isAccepted;
    private boolean isRejected;
    private int propertyID;
    private String guestID;

    public BookingInfo(int bookingIDB, Date startDateB, Date endDateB, boolean isAcceptedB, boolean isRejectedB, int propertyIDB, String guestIDB) {
        bookingID = bookingIDB;
        startDate = startDateB; // YYYY-MM-DD
        endDate = endDateB;  // YYYY-MM-DD
        isAccepted = isAcceptedB;
        isRejected = isRejectedB;
        propertyID = propertyIDB;
        guestID = guestIDB;
    }

    public int getBookingID() {
        return bookingID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public boolean getIsAccepted() {
        return isAccepted;
    }

    public boolean getIsRejected() {
        return isRejected;
    }

    public int getPropertyID() {
        return propertyID;
    }

    public String getGuestID() {
        return guestID;
    }
}
