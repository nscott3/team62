package model;

public class AddressInfo {
    private String houseName;
    private String streetName;
    private String placeName;
    private String postcode;

    public AddressInfo(String house, String street, String place, String post) {
        houseName = house;
        streetName = street;
        placeName = place;
        postcode = post;
    }

    public String getHouseName() {
        return houseName;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getPlaceName() {
        return placeName;
    }

    public String getPostcode() {
        return postcode;
    }
}
