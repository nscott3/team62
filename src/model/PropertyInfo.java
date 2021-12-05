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

<<<<<<< HEAD
    public PropertyInfo(String nameP, String descriptionP, String locationP, boolean isBreakfastP, int maxGuestsP, float reviewRatingP, String hostIDP, String houseNameP, String postcodeP) {
=======
    public PropertyInfo(int propertyIDP, String nameP, String descriptionP, String locationP, boolean isBreakfastP, int maxGuestsP, float reviewRatingP, String hostIDP, String houseNameP, String postcodeP) {
        propertyID = propertyIDP;
>>>>>>> 3cddc989b89604f68b06464f993209ec36aa6a86
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

<<<<<<< HEAD
=======
    public int getPropertyID() {
        return propertyID;
    }

>>>>>>> 3cddc989b89604f68b06464f993209ec36aa6a86
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
