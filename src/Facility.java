import Sleeping;
import Bedroom;
import Bathing;
import Bathroom;
import Kitchen;
import Living;
import Utility;
import Outdoor;

import java.sql.*;

public class Facility {
	public static void insertFacilityNo(Connection conn) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO Facility Values default");
			//auto-increment
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
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
