package model;

public class UtilityInfo {
    private int utilityID;
    private boolean hasCentralHeating;
    private boolean hasWashingMachine;
    private boolean hasDryingMachine;
    private boolean hasFireExtinguisher;
    private boolean hasSmokeAlarm;
    private boolean hasFirstAidKit;
    private int propertyID;

    public UtilityInfo(int utilityIDU, boolean hasCentralHeatingU, boolean hasWashingMachineU, boolean hasDryingMachineU, boolean hasFireExtinguisherU, boolean hasSmokeAlarmU, boolean hasFirstAidKitU, int propertyIDU) {
        utilityID = utilityIDU;
        hasCentralHeating = hasCentralHeatingU;
        hasWashingMachine = hasWashingMachineU;
        hasDryingMachine = hasDryingMachineU;
        hasFireExtinguisher = hasFireExtinguisherU;
        hasSmokeAlarm = hasSmokeAlarmU;
        hasFirstAidKit = hasFirstAidKitU;
        propertyID = propertyIDU;
    }

    public UtilityInfo(boolean hasCentralHeatingU, boolean hasWashingMachineU, boolean hasDryingMachineU, boolean hasFireExtinguisherU, boolean hasSmokeAlarmU, boolean hasFirstAidKitU) {
        hasCentralHeating = hasCentralHeatingU;
        hasWashingMachine = hasWashingMachineU;
        hasDryingMachine = hasDryingMachineU;
        hasFireExtinguisher = hasFireExtinguisherU;
        hasSmokeAlarm = hasSmokeAlarmU;
        hasFirstAidKit = hasFirstAidKitU;
    }

    public void setUtilityID(int utilityID) {
        this.utilityID = utilityID;
    }

    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }

    public int getUtilityID() {
        return utilityID;
    }

    public boolean hasCentralHeating() {
        return hasCentralHeating;
    }

    public boolean hasWashingMachine() {
        return hasWashingMachine;
    }

    public boolean hasDryingMachine() {
        return hasDryingMachine;
    }

    public boolean hasFireExtinguisher() {
        return hasFireExtinguisher;
    }

    public boolean hasSmokeAlarm() {
        return hasSmokeAlarm;
    }

    public boolean hasFirstAidKit() {
        return hasFirstAidKit;
    }

    public int getPropertyID() {
        return propertyID;
    }
}
