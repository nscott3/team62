package model;

public class ReviewInfo {
    private int bookingID;
    private String description;
    private int scoreCleanliness;
    private int scoreCommunication;
    private int scoreCheckin;
    private int scoreAccuracy;
    private int scoreLocation;
    private int scoreValue;
    private int propertyID;

    public ReviewInfo(int bookingIDB, String descriptionB, int cleanlinessB, int communicationB, int checkinB, int accuracyB, int locationB, int valueB, int propertyIDB) {
        bookingID = bookingIDB;
        description = descriptionB;
        scoreCleanliness = cleanlinessB;
        scoreCommunication = communicationB;
        scoreCheckin = checkinB;
        scoreAccuracy = accuracyB;
        scoreLocation = locationB;
        scoreValue = valueB;
        propertyID = propertyIDB;
    }

    public int getBookingID() {
        return bookingID;
    }

    public String getDescription() {
        return description;
    }

    public int getScoreCleanliness() {
        return scoreCleanliness;
    }

    public int getScoreCommunication() {
        return scoreCommunication;
    }

    public int getScoreCheckin() {
        return scoreCheckin;
    }

    public int getScoreAccuracy() {
        return scoreAccuracy;
    }

    public int getScoreLocation() {
        return scoreLocation;
    }

    public int getScoreValue() {
        return scoreValue;
    }

    public int getPropertyID() {
        return propertyID;
    }
}
