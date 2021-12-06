package model;

public class LivingInfo {
	public int livingID;
	public boolean hasWifi;
	public boolean hasTV;
	public boolean hasSatellite;
	public boolean hasStreaming;
	public boolean hasDvdPlayer;
	public boolean hasBoardGames;
	public int propertyID;
    
    public LivingInfo(int livingIDL, boolean hasWifiL, boolean hasTVL, boolean hasSatelliteL, boolean hasStreamingL, boolean hasDvdPlayerL, boolean hasBoardGamesL, int propertyIDL) {
        livingID = livingIDL;
        hasWifi = hasWifiL;
        hasTV = hasTVL;
        hasSatellite = hasSatelliteL;
        hasStreaming = hasStreamingL;
        hasDvdPlayer = hasDvdPlayerL;
        hasBoardGames = hasBoardGamesL;
        propertyID = propertyIDL;
    }

    public LivingInfo(boolean hasWifiL, boolean hasTVL, boolean hasSatelliteL, boolean hasStreamingL, boolean hasDvdPlayerL, boolean hasBoardGamesL) {
        hasWifi = hasWifiL;
        hasTV = hasTVL;
        hasSatellite = hasSatelliteL;
        hasStreaming = hasStreamingL;
        hasDvdPlayer = hasDvdPlayerL;
        hasBoardGames = hasBoardGamesL;
    }

    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }

    public void setLivingID(int livingID) {
        this.livingID = livingID;
    }

    public int getLivingID() {
        return livingID;
    }

    public boolean hasWifi() {
        return hasWifi;
    }

    public boolean hasTV() {
        return hasTV;
    }

    public boolean hasSatellite() {
        return hasSatellite;
    }

    public boolean hasStreaming() {
        return hasStreaming;
    }

    public boolean hasDvdPlayer() {
        return hasDvdPlayer;
    }

    public boolean hasBoardGames() {
        return hasBoardGames;
    }

    public int getPropertyID() {
        return propertyID;
    }
}
