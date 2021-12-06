package model;

public class SleepingInfo {
    private int sleepingID;
    private boolean hasBedLinen;
    private boolean hasTowels;
    private int numBedrooms;
    private int numBeds;
    private int numSleepers;
    private int propertyID;

    public SleepingInfo(int sleepingIDS, boolean hasBedLinenS, boolean hasTowelsS, int numBedroomsS, int numBedsS, int numSleepersS, int propertyIDS) {
        sleepingID = sleepingIDS;
        hasBedLinen = hasBedLinenS;
        hasTowels = hasTowelsS;
        numBedrooms = numBedroomsS;
        numBeds = numBedsS;
        numSleepers = numSleepersS;
        propertyID = propertyIDS;
    }

    public SleepingInfo(boolean hasBedLinenS, boolean hasTowelsS, int numBedroomsS, int numBedsS, int numSleepersS) {
        hasBedLinen = hasBedLinenS;
        hasTowels = hasTowelsS;
        numBedrooms = numBedroomsS;
        numBeds = numBedsS;
        numSleepers = numSleepersS;
    }

    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }

    public void setSleepingID(int sleepingID) {
        this.sleepingID = sleepingID;
    }

    public int getSleepingID() {
        return sleepingID;
    }

    public boolean hasBedLinen() {
        return hasBedLinen;
    }

    public boolean hasTowels() {
        return hasTowels;
    }

    public int getNumBedrooms() {
        return numBedrooms;
    }

    public int getNumBeds() {
        return numBeds;
    }

    public int getNumSleepers() {
        return numSleepers;
    }

    public int getPropertyID() {
        return propertyID;
    }
}
