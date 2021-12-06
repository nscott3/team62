package model;

public class BedroomInfo {
	private int bedroomID;
    private String bedType1;
    private String bedType2;
    private int bedsNum;
    private int sleepersNum;
    private int sleepingID;

    public BedroomInfo(int bedroomIDB, String bedType1B, String bedType2B, int bedsNumB, int sleepersNumB, int sleepingIDB) {
        bedroomID = bedroomIDB;
        bedType1 = bedType1B;
        bedType2 = bedType2B;
        bedsNum = bedsNumB;
        sleepersNum = sleepersNumB;
        sleepingID = sleepingIDB;
    }

    public BedroomInfo(String bedType1B, String bedType2B, int bedsNumB, int sleepersNumB) {
        bedType1 = bedType1B;
        bedType2 = bedType2B;
        bedsNum = bedsNumB;
        sleepersNum = sleepersNumB;
    }

    public void setSleepingID(int sleepingID) {
        this.sleepingID = sleepingID;
    }

    public void setBedroomID(int bedroomID) {
        this.bedroomID = bedroomID;
    }

    public int getBedroomID() {
        return bedroomID;
    }

    public String getBedType1() {
        return bedType1;
    }

    public String getBedType2() {
        return bedType2;
    }

    public int getBedsNum() {
        return bedsNum;
    }

    public int getSleepersNum() {
        return sleepersNum;
    }

    public int getSleepingID() {
        return sleepingID;
    }
}
