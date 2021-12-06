package view;

import model.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class PropertyInformationView extends JDialog {

    private JButton btnBack = new JButton("Go Back");

    public PropertyInformationView(PersonInfo personInfo, GuestInfo guestInfo, PropertyInfo propertyinfo, String startDate, String endDate) {
        setResizable(false);
        setPreferredSize(new Dimension(1200, 1020 / 12 * 9));
        setSize(1200, 1020 / 12 * 9);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("HomeBreaks Plc");
        getContentPane().setLayout(null);

        JPanel PropertyInfoPanel = new JPanel();
        PropertyInfoPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
        PropertyInfoPanel.setBounds(10, 58, 624, 309);
        PropertyInfoPanel.setLayout(new GridBagLayout());
        Insets insets = new Insets(4, 4, 4, 4);
        int y = 0;

        HostInfo hostInfo = null;
        SleepingInfo sleepingInfo = null;
        BathingInfo bathingInfo = null;
        KitchenInfo kitchenInfo = null;
        LivingInfo livingInfo = null;
        UtilityInfo utilityInfo = null;
        OutdoorInfo outdoorInfo = null;
        List<BedroomInfo> bedrooms = new ArrayList<>();
        List<BathroomInfo> bathrooms = new ArrayList<>();
        try {
            Connection conn = DBAccess.connect();
            hostInfo = Host.getHost(conn, propertyinfo.getHostID());
            sleepingInfo = Sleeping.getSleepingInfo(conn, propertyinfo.getPropertyID());
            bathingInfo = Bathing.getBathingInfo(conn, propertyinfo.getPropertyID());
            kitchenInfo = Kitchen.getKitchenInfo(conn, propertyinfo.getPropertyID());
            livingInfo = Living.getLivingInfo(conn, propertyinfo.getPropertyID());
            utilityInfo = Utility.getUtilityInfo(conn, propertyinfo.getPropertyID());
            outdoorInfo = Outdoor.getOutdoorInfo(conn, propertyinfo.getPropertyID());

            bedrooms = Bedroom.getBedroomInfo(conn, sleepingInfo.getSleepingID());
            bathrooms = Bathroom.getBathroomInfo(conn, bathingInfo.getBathingID());
        } finally {
            DBAccess.disconnect();
        }

        PropertyInfoPanel.add(new JLabel("Property Name"), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel(propertyinfo.getName()), new GridBagConstraints(1, y, GridBagConstraints.REMAINDER, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        PropertyInfoPanel.add(new JLabel("Description"), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel(propertyinfo.getDescription()), new GridBagConstraints(1, y, GridBagConstraints.REMAINDER, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        PropertyInfoPanel.add(new JLabel("Host Name"), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel(hostInfo.getHostName()), new GridBagConstraints(1, y, GridBagConstraints.REMAINDER, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        PropertyInfoPanel.add(new JLabel("Super Host"), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel(hostInfo.getSuperHost() ? "True" : "False"), new GridBagConstraints(1, y, GridBagConstraints.REMAINDER, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        PropertyInfoPanel.add(new JLabel("Location"), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel(propertyinfo.getLocation()), new GridBagConstraints(1, y, GridBagConstraints.REMAINDER, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        PropertyInfoPanel.add(new JLabel("Has Breakfast"), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel(propertyinfo.getIsBreakfast() ? "True" : "False"), new GridBagConstraints(1, y, GridBagConstraints.REMAINDER, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        PropertyInfoPanel.add(new JLabel("Max Guests"), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel(String.valueOf(propertyinfo.getMaxGuests())), new GridBagConstraints(1, y, GridBagConstraints.REMAINDER, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        //SLEEPING//
        PropertyInfoPanel.add(new JLabel("Sleeping Facility"), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Has Bed Linen"), new GridBagConstraints(1, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Has Towels"), new GridBagConstraints(2, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Number of Bedrooms"), new GridBagConstraints(3, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Number of Beds"), new GridBagConstraints(4, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Number of Sleepers"), new GridBagConstraints(5, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        PropertyInfoPanel.add(new JLabel(""), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel(sleepingInfo.hasBedLinen() ? "True" : "False"), new GridBagConstraints(1, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel(sleepingInfo.hasTowels() ? "True" : "False"), new GridBagConstraints(2, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel(String.valueOf(sleepingInfo.getNumBedrooms())), new GridBagConstraints(3, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel(String.valueOf(sleepingInfo.getNumBeds())), new GridBagConstraints(4, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel(String.valueOf(sleepingInfo.getNumSleepers())), new GridBagConstraints(5, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        //BEDROOMS
        for (BedroomInfo bedroomInfo : bedrooms) {
            PropertyInfoPanel.add(new JLabel("Bedroom"), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            PropertyInfoPanel.add(new JLabel("Bed Type 1"), new GridBagConstraints(1, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            PropertyInfoPanel.add(new JLabel("Bed Type 2"), new GridBagConstraints(2, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            PropertyInfoPanel.add(new JLabel("Number of Beds"), new GridBagConstraints(3, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            PropertyInfoPanel.add(new JLabel("Number of Sleepers"), new GridBagConstraints(4, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            y++;
            PropertyInfoPanel.add(new JLabel(""), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            PropertyInfoPanel.add(new JLabel(bedroomInfo.getBedType1()), new GridBagConstraints(1, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            PropertyInfoPanel.add(new JLabel(bedroomInfo.getBedType2()), new GridBagConstraints(2, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            PropertyInfoPanel.add(new JLabel(String.valueOf(bedroomInfo.getBedsNum())), new GridBagConstraints(3, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            PropertyInfoPanel.add(new JLabel(String.valueOf(bedroomInfo.getSleepersNum())), new GridBagConstraints(4, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            y++;
        }
        //BATHING//
        PropertyInfoPanel.add(new JLabel("Bathing Facility"), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Has Hair Dryer"), new GridBagConstraints(1, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Has Shampoo"), new GridBagConstraints(2, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Has Toilet Paper"), new GridBagConstraints(3, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Number of Bathrooms"), new GridBagConstraints(4, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        PropertyInfoPanel.add(new JLabel(""), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel(bathingInfo.hasHairDryer() ? "True" : "False"), new GridBagConstraints(1, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel(bathingInfo.hasShampoo() ? "True" : "False"), new GridBagConstraints(2, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel(bathingInfo.hasToiletPaper() ? "True" : "False"), new GridBagConstraints(3, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel(String.valueOf(bathingInfo.getBathroomNum())), new GridBagConstraints(4, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        //BATHROOM
        for (BathroomInfo bathroomInfo : bathrooms) {
            PropertyInfoPanel.add(new JLabel("Bathroom"), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            PropertyInfoPanel.add(new JLabel("Has Toilet"), new GridBagConstraints(1, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            PropertyInfoPanel.add(new JLabel("Has Bath"), new GridBagConstraints(2, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            PropertyInfoPanel.add(new JLabel("Has Shower"), new GridBagConstraints(3, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            PropertyInfoPanel.add(new JLabel("Shared"), new GridBagConstraints(4, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            y++;
            PropertyInfoPanel.add(new JLabel(""), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            PropertyInfoPanel.add(new JLabel(bathroomInfo.hasToilet() ? "True" : "False"), new GridBagConstraints(1, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            PropertyInfoPanel.add(new JLabel(bathroomInfo.hasBath() ? "True" : "False"), new GridBagConstraints(2, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            PropertyInfoPanel.add(new JLabel(bathroomInfo.hasShower() ? "True" : "False"), new GridBagConstraints(3, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            PropertyInfoPanel.add(new JLabel(bathroomInfo.isShared() ? "True" : "False"), new GridBagConstraints(4, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            y++;
        }
        //KITCHEN//
        PropertyInfoPanel.add(new JLabel("Kitchen Facility"), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Has Fridge"), new GridBagConstraints(1, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Has Microwave"), new GridBagConstraints(2, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Has Oven"), new GridBagConstraints(3, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Has Stove"), new GridBagConstraints(4, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Has Dishwasher"), new GridBagConstraints(5, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Has Tableware"), new GridBagConstraints(6, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Has Cookware"), new GridBagConstraints(7, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Has Basic Provisions"), new GridBagConstraints(8, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        PropertyInfoPanel.add(new JLabel(""), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel(kitchenInfo.hasRefrigerator() ? "True" : "False"), new GridBagConstraints(1, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel(kitchenInfo.hasMicrowave() ? "True" : "False"), new GridBagConstraints(2, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel(kitchenInfo.hasOven() ? "True" : "False"), new GridBagConstraints(3, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel(kitchenInfo.hasStove() ? "True" : "False"), new GridBagConstraints(4, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel(kitchenInfo.hasDishwasher() ? "True" : "False"), new GridBagConstraints(5, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel(kitchenInfo.hasTableware() ? "True" : "False"), new GridBagConstraints(6, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel(kitchenInfo.hasCookware() ? "True" : "False"), new GridBagConstraints(7, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel(kitchenInfo.hasBasicProvisions() ? "True" : "False"), new GridBagConstraints(8, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        //LIVING//
        PropertyInfoPanel.add(new JLabel("Living Facility"), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Has Wifi"), new GridBagConstraints(1, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Has TV"), new GridBagConstraints(2, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Has Satellite"), new GridBagConstraints(3, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Has Streaming"), new GridBagConstraints(4, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Has DVD Player"), new GridBagConstraints(5, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Has Board Games"), new GridBagConstraints(6, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        PropertyInfoPanel.add(new JLabel(""), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel(livingInfo.hasWifi() ? "True" : "False"), new GridBagConstraints(1, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel(livingInfo.hasTV() ? "True" : "False"), new GridBagConstraints(2, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel(livingInfo.hasSatellite() ? "True" : "False"), new GridBagConstraints(3, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel(livingInfo.hasStreaming() ? "True" : "False"), new GridBagConstraints(4, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel(livingInfo.hasDvdPlayer() ? "True" : "False"), new GridBagConstraints(5, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel(livingInfo.hasBoardGames() ? "True" : "False"), new GridBagConstraints(6, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        //UTILITY//
        PropertyInfoPanel.add(new JLabel("Utility Facility"), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Has Central Heating"), new GridBagConstraints(1, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Has Washing Machine"), new GridBagConstraints(2, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Has Drying Machine"), new GridBagConstraints(3, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Has Fire Extinguisher"), new GridBagConstraints(4, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Has Smoke Alarm"), new GridBagConstraints(5, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Has First Aid Kit"), new GridBagConstraints(6, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        PropertyInfoPanel.add(new JLabel(""), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel(utilityInfo.hasCentralHeating() ? "True" : "False"), new GridBagConstraints(1, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel(utilityInfo.hasWashingMachine() ? "True" : "False"), new GridBagConstraints(2, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel(utilityInfo.hasDryingMachine() ? "True" : "False"), new GridBagConstraints(3, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel(utilityInfo.hasFireExtinguisher() ? "True" : "False"), new GridBagConstraints(4, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel(utilityInfo.hasSmokeAlarm() ? "True" : "False"), new GridBagConstraints(5, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel(utilityInfo.hasFirstAidKit() ? "True" : "False"), new GridBagConstraints(6, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        //OUTDOOR//
        PropertyInfoPanel.add(new JLabel("Outdoor Facility"), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Has Free Onsite Parking"), new GridBagConstraints(1, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Has On Road Parking"), new GridBagConstraints(2, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Has Paid Parking"), new GridBagConstraints(3, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Has Patio"), new GridBagConstraints(4, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Has BBQ"), new GridBagConstraints(5, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        PropertyInfoPanel.add(new JLabel(""), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel(outdoorInfo.hasFreeOnSiteParking() ? "True" : "False"), new GridBagConstraints(1, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel(outdoorInfo.hasOnRoadParking() ? "True" : "False"), new GridBagConstraints(2, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel(outdoorInfo.hasPaidParking() ? "True" : "False"), new GridBagConstraints(3, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel(outdoorInfo.hasPatio() ? "True" : "False"), new GridBagConstraints(4, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel(outdoorInfo.hasBarbeque() ? "True" : "False"), new GridBagConstraints(5, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 8));
        bottomPanel.add(btnBack);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(PropertyInfoPanel, BorderLayout.CENTER);
        contentPanel.add(bottomPanel, BorderLayout.SOUTH);
        setContentPane(contentPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        btnBack.addActionListener(e -> {
            new SpecificInformationView(personInfo, guestInfo, propertyinfo, startDate, endDate).setVisible(true);
            this.dispose();
        });
    }
}
