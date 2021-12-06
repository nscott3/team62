package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SubmitProperty {

    public static void Submit(Connection conn, AddressInfo addressInfo, PersonInfo personInfo, PropertyInfo propertyInfo, SleepingInfo sleepingInfo, List<BedroomInfo> bedroomInfos, BathingInfo bathingInfo, List<BathroomInfo> bathroomInfos, KitchenInfo kitchenInfo, LivingInfo livingInfo, UtilityInfo utilityInfo, OutdoorInfo outdoorInfo, List<ChargeBandInfo> chargeBands) {
        if (!Address.checkAddressExists(conn, addressInfo)) {
            Address.addAddress(conn, addressInfo);
        }

        Property.registerProperty(conn, propertyInfo);
        int propertyID = Property.lookupPropertyID(conn, addressInfo.getHouseName(), addressInfo.getPostcode());

        sleepingInfo.setPropertyID(propertyID);
        Sleeping.putSleepingInfo(conn, sleepingInfo);

        int sleepingID = Sleeping.getSleepingInfo(conn, propertyID).getSleepingID();
        for (BedroomInfo bedroomInfo : bedroomInfos) {
            bedroomInfo.setSleepingID(sleepingID);
            Bedroom.putBedroomInfo(conn, bedroomInfo);
        }

        bathingInfo.setPropertyID(propertyID);
        Bathing.putBathingInfo(conn, bathingInfo);

        int bathingID = Bathing.getBathingInfo(conn, propertyID).getBathingID();
        for (BathroomInfo bathroomInfo : bathroomInfos) {
            bathroomInfo.setBathingID(bathingID);
            Bathroom.putBathroomInfo(conn, bathroomInfo);
        }

        kitchenInfo.setPropertyID(propertyID);
        Kitchen.putKitchenInfo(conn, kitchenInfo);

        livingInfo.setPropertyID(propertyID);
        Living.putLivingInfo(conn, livingInfo);

        utilityInfo.setPropertyID(propertyID);
        Utility.putUtilityInfo(conn, utilityInfo);

        outdoorInfo.setPropertyID(propertyID);
        Outdoor.putOutdoorInfo(conn, outdoorInfo);

        for (ChargeBandInfo chargeBandInfo : chargeBands) {
            chargeBandInfo.setPropertyID(propertyID);
            ChargeBand.putChargeBand(conn, chargeBandInfo);
        }
    }
}
