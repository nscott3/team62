package model;

public class BathingInfo {
	private int bathingID;
    private boolean hasHairDryer;
    private boolean hasShampoo;
    private boolean hasToiletPaper;
    private int bathroomNum;
    private int propertyID;

    public BathingInfo(int bathingIDB, boolean hasHairDryerB, boolean hasShampooB, boolean hasToiletPaperB, int bathroomNumB, int propertyIDB) {
        bathingID = bathingIDB;
        hasHairDryer = hasHairDryerB;
        hasShampoo = hasShampooB;
        hasToiletPaper = hasToiletPaperB;
        bathroomNum = bathroomNumB;
        propertyID = propertyIDB;
    }

    public BathingInfo(boolean hasHairDryerB, boolean hasShampooB, boolean hasToiletPaperB, int bathroomNumB) {
        hasHairDryer = hasHairDryerB;
        hasShampoo = hasShampooB;
        hasToiletPaper = hasToiletPaperB;
        bathroomNum = bathroomNumB;
    }

    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }

    public void setBathingID(int bathingID) {
        this.bathingID = bathingID;
    }

    public int getBathingID() {
        return bathingID;
    }

    public boolean hasHairDryer() {
        return hasHairDryer;
    }

    public boolean hasShampoo() {
        return hasShampoo;
    }

    public boolean hasToiletPaper() {
        return hasToiletPaper;
    }

    public int getBathroomNum() {
        return bathroomNum;
    }

    public int getPropertyID() {
        return propertyID;
    }
}
