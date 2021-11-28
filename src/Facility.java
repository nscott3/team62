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
	public static void insertFacilityNo(Connection conn, int hostID) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO Facility Values (default,?)");
			pstmt.setInt(1, hostID);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static int lookupFacilityNo(Connection conn, int hostID) {
		int facilityNo = 0;
		
		try {
			String sql = "SELECT * FROM Facility WHERE hostID =" + hostID;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				facilityNo = rs.getInt("facilityNo");
			}	
			
			rs.close();
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return facilityNo;
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
