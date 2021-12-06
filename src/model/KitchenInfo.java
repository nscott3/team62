package model;

public class KitchenInfo {
	public int kitchenID;
	public boolean hasRefrigerator;
	public boolean hasMicrowave;
	public boolean hasOven;
	public boolean hasStove;
	public boolean hasDishwasher;
	public boolean hasTableware;
	public boolean hasCookware;
	public boolean hasBasicProvisions;
	public int propertyID;
    
    public KitchenInfo(int kitchenIDK, boolean hasRefrigeratorK, boolean hasMicrowaveK, boolean hasOvenK, boolean hasStoveK, boolean hasDishwasherK, boolean hasTablewareK, boolean hasCookwareK, boolean hasBasicProvisionsK, int propertyIDK) {
        kitchenID = kitchenIDK;
        hasRefrigerator = hasRefrigeratorK;
        hasMicrowave = hasMicrowaveK;
        hasOven = hasOvenK;
        hasStove = hasStoveK;
        hasDishwasher = hasDishwasherK;
        hasTableware = hasTablewareK;
        hasCookware = hasCookwareK;
        hasBasicProvisions = hasBasicProvisionsK;
        propertyID = propertyIDK;
    }

    public KitchenInfo(boolean hasRefrigeratorK, boolean hasMicrowaveK, boolean hasOvenK, boolean hasStoveK, boolean hasDishwasherK, boolean hasTablewareK, boolean hasCookwareK, boolean hasBasicProvisionsK) {
        hasRefrigerator = hasRefrigeratorK;
        hasMicrowave = hasMicrowaveK;
        hasOven = hasOvenK;
        hasStove = hasStoveK;
        hasDishwasher = hasDishwasherK;
        hasTableware = hasTablewareK;
        hasCookware = hasCookwareK;
        hasBasicProvisions = hasBasicProvisionsK;
    }

    public void setKitchenID(int kitchenID) {
        this.kitchenID = kitchenID;
    }

    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }

    public int getKitchenID() {
        return kitchenID;
    }

    public boolean hasRefrigerator() {
        return hasRefrigerator;
    }

    public boolean hasMicrowave() {
        return hasMicrowave;
    }

    public boolean hasOven() {
        return hasOven;
    }

    public boolean hasStove() {
        return hasStove;
    }

    public boolean hasDishwasher() {
        return hasDishwasher;
    }

    public boolean hasTableware() {
        return hasTableware;
    }

    public boolean hasCookware() {
        return hasCookware;
    }

    public boolean hasBasicProvisions() {
        return hasBasicProvisions;
    }

    public int getPropertyID() {
        return propertyID;
    }
}
