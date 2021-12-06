package model;

public class BathroomInfo {
	private int bathroomID;
    private boolean hasToilet;
    private boolean hasBath;
    private boolean hasShower;
    private boolean isShared;
    private int bathingID;

    public BathroomInfo(int bathroomIDB, boolean hasToiletB, boolean hasBathB, boolean hasShowerB, boolean isSharedB, int bathingIDB) {
        bathroomID = bathroomIDB;
        hasToilet = hasToiletB;
        hasBath = hasBathB;
        hasShower = hasShowerB;
        isShared = isSharedB;
        bathingID = bathingIDB;
    }

    public BathroomInfo(boolean hasToiletB, boolean hasBathB, boolean hasShowerB, boolean isSharedB) {
        hasToilet = hasToiletB;
        hasBath = hasBathB;
        hasShower = hasShowerB;
        isShared = isSharedB;
    }

    public void setBathingID(int bathingID) {
        this.bathingID = bathingID;
    }

    public void setBathroomID(int bathroomID) {
        this.bathroomID = bathroomID;
    }

    public int getBathroomID() {
        return bathroomID;
    }

    public boolean hasToilet() {
        return hasToilet;
    }

    public boolean hasBath() {
        return hasBath;
    }

    public boolean hasShower() {
        return hasShower;
    }

    public boolean isShared() {
        return isShared;
    }

    public int getBathingID() {
        return bathingID;
    }
}
