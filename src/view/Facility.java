package view;
import java.sql.*;

import view.Bathing;
import view.Bathroom;
import view.Bedroom;
import view.Kitchen;
import view.Living;
import view.Outdoor;
import view.Sleeping;
import view.Utility;

public class Facility {
	
	public static void registerFacilityInfo(
			Connection conn, 
			SleepingInfo sleepingInfo,
			BedroomInfo bedroomInfo,
			BathingInfo bathingInfo,
			BathroomInfo bathroomInfo,
			KitchenInfo kitchenInfo,
			LivingInfo livingInfo,
			UtilityInfo utilityInfo,
			OutdoorInfo outdoorInfo) {
		
		Sleeping.putSleepingInfo(conn, sleepingInfo);
		Bedroom.putBedroomInfo(conn, bedroomInfo);
		Bathing.putBathingInfo(conn, bathingInfo);
		Bathroom.putBathroomInfo(conn, bathroomInfo);
		Kitchen.putKitchenInfo(conn, kitchenInfo);
		Living.putLivingInfo(conn, livingInfo);
		Utility.putUtilityInfo(conn, utilityInfo);
		Outdoor.putOutdoorInfo(conn, outdoorInfo);
	    
	}
}
