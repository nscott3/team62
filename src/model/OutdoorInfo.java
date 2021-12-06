package model;

public class OutdoorInfo {
	public int outdoorID;
	public boolean hasFreeOnSiteParking;
	public boolean hasOnRoadParking;
	public boolean hasPaidParking;
	public boolean hasPatio;
	public boolean hasBarbeque;
	public int propertyID;
    
    public OutdoorInfo(int outdoorIDO, boolean hasFreeOnSiteParkingO, boolean hasOnRoadParkingO, boolean hasPaidParkingO, boolean hasPatioO, boolean hasBarbequeO, int propertyIDO) {
        outdoorID = outdoorIDO;
        hasFreeOnSiteParking = hasFreeOnSiteParkingO;
        hasOnRoadParking = hasOnRoadParkingO;
        hasPaidParking = hasPaidParkingO;
        hasPatio = hasPatioO;
        hasBarbeque = hasBarbequeO;
        propertyID = propertyIDO;
    }

    public OutdoorInfo(boolean hasFreeOnSiteParkingO, boolean hasOnRoadParkingO, boolean hasPaidParkingO, boolean hasPatioO, boolean hasBarbequeO) {
        hasFreeOnSiteParking = hasFreeOnSiteParkingO;
        hasOnRoadParking = hasOnRoadParkingO;
        hasPaidParking = hasPaidParkingO;
        hasPatio = hasPatioO;
        hasBarbeque = hasBarbequeO;
    }

    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }

    public void setOutdoorID(int outdoorID) {
        this.outdoorID = outdoorID;
    }

    public int getOutdoorID() {
        return outdoorID;
    }

    public boolean hasFreeOnSiteParking() {
        return hasFreeOnSiteParking;
    }

    public boolean hasOnRoadParking() {
        return hasOnRoadParking;
    }

    public boolean hasPaidParking() {
        return hasPaidParking;
    }

    public boolean hasPatio() {
        return hasPatio;
    }

    public boolean hasBarbeque() {
        return hasBarbeque;
    }

    public int getPropertyID() {
        return propertyID;
    }
}
