package model;

public class PropertyInfo {
    private int propertyID;
    private String name;
    private String description;
    private String location;
    private boolean isBreakfast;
    private int maxGuests;
    private float reviewRating;
    private String hostID;
    private String houseName;
    private String postcode;

    public PropertyInfo(int propertyIDP, String nameP, String descriptionP, String locationP, boolean isBreakfastP, int maxGuestsP, float reviewRatingP, String hostIDP, String houseNameP, String postcodeP) {
        propertyID = propertyIDP;
        name = nameP;
        description = descriptionP;
        location = locationP;
        isBreakfast = isBreakfastP;
        maxGuests = maxGuestsP;
        reviewRating = reviewRatingP;
        hostID = hostIDP;
        houseName = houseNameP;
        postcode = postcodeP;
    }
    public PropertyInfo(String nameP, String descriptionP, String locationP, boolean isBreakfastP, int maxGuestsP, float reviewRatingP, String hostIDP, String houseNameP, String postcodeP) {
        name = nameP;
        description = descriptionP;
        location = locationP;
        isBreakfast = isBreakfastP;
        maxGuests = maxGuestsP;
        reviewRating = reviewRatingP;
        hostID = hostIDP;
        houseName = houseNameP;
        postcode = postcodeP;
    }

    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }

    public int getPropertyID() {
        return propertyID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public boolean getIsBreakfast() {
        return isBreakfast;
    }

    public int getMaxGuests() {
        return maxGuests;
    }

    public float getReviewRating() {
        return reviewRating;
    }

    public String getHostID() {
        return hostID;
    }

    public String getHouseName() {
        return houseName;
    }

    public String getPostcode() {
        return postcode;
    }
}
