package view;

import model.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class PropertyEditorView extends JDialog {

    private JButton btnBack = new JButton("Go Back");
    private JButton btnSubmit = new JButton("Submit");

    public PropertyEditorView(int bedroomNum, int bathroomNum, AddressInfo addressInfo, PersonInfo personInfo, List<ChargeBandInfo> chargeBands) {
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

        JTextField propertyName = new JTextField();
        JTextField propertyDescription = new JTextField();
        JTextField propertyLocation = new JTextField();
        JCheckBox propertyBreakfast = new JCheckBox();

        PropertyInfoPanel.add(new JLabel("Property Name"), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(propertyName, new GridBagConstraints(1, y, GridBagConstraints.REMAINDER, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        PropertyInfoPanel.add(new JLabel("Description"), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(propertyDescription, new GridBagConstraints(1, y, GridBagConstraints.REMAINDER, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        PropertyInfoPanel.add(new JLabel("Location"), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(propertyLocation, new GridBagConstraints(1, y, GridBagConstraints.REMAINDER, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        PropertyInfoPanel.add(new JLabel("Has Breakfast"), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(propertyBreakfast, new GridBagConstraints(1, y, GridBagConstraints.REMAINDER, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;

        JCheckBox sleepingBedLinen = new JCheckBox();
        JCheckBox sleepingTowels = new JCheckBox();

        //SLEEPING//
        PropertyInfoPanel.add(new JLabel("Sleeping Facility"), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Has Bed Linen"), new GridBagConstraints(1, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Has Towels"), new GridBagConstraints(2, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        PropertyInfoPanel.add(new JLabel(""), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(sleepingBedLinen, new GridBagConstraints(1, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(sleepingTowels, new GridBagConstraints(2, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        //BEDROOMS
        String[] bedTypes1 = { "Single", "Double", "King", "Bunk"};
        String[] bedTypes2 = { "Null", "Single", "Double", "King", "Bunk"};
        JComboBox[] bedroomFields = new JComboBox[bedroomNum*2];
        for (int i = 0; i < bedroomNum*2; i+=2) {
            JComboBox bedType1 = new JComboBox(bedTypes1);
            JComboBox bedType2 = new JComboBox(bedTypes2);
            bedroomFields[i] = bedType1;
            bedroomFields[i+1] = bedType2;

            PropertyInfoPanel.add(new JLabel("Bedroom"), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            PropertyInfoPanel.add(new JLabel("Bed Type 1"), new GridBagConstraints(1, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            PropertyInfoPanel.add(new JLabel("Bed Type 2"), new GridBagConstraints(2, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            y++;
            PropertyInfoPanel.add(new JLabel(""), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            PropertyInfoPanel.add(bedroomFields[i], new GridBagConstraints(1, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            PropertyInfoPanel.add(bedroomFields[i+1], new GridBagConstraints(2, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            y++;
        }

        JCheckBox bathingHairDryer = new JCheckBox();
        JCheckBox bathingShampoo = new JCheckBox();
        JCheckBox bathingToiletPaper = new JCheckBox();

        //BATHING//
        PropertyInfoPanel.add(new JLabel("Bathing Facility"), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Has Hair Dryer"), new GridBagConstraints(1, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Has Shampoo"), new GridBagConstraints(2, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Has Toilet Paper"), new GridBagConstraints(3, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        PropertyInfoPanel.add(new JLabel(""), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(bathingHairDryer, new GridBagConstraints(1, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(bathingShampoo, new GridBagConstraints(2, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(bathingToiletPaper, new GridBagConstraints(3, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        //BATHROOM
        //List<JCheckBox> bathroomFields = new ArrayList<JCheckBox>();
        JCheckBox[] bathroomFields = new JCheckBox[bathroomNum*4];
        for (int i = 0; i < bathroomNum*4; i+=4) {
            JCheckBox bathroomHasToilet = new JCheckBox();
            JCheckBox bathroomHasBath = new JCheckBox();
            JCheckBox bathroomHasShower = new JCheckBox();
            JCheckBox bathroomIsShared = new JCheckBox();
            bathroomFields[i] = bathroomHasToilet;
            bathroomFields[i+1] = bathroomHasBath;
            bathroomFields[i+2] = bathroomHasShower;
            bathroomFields[i+3] = bathroomIsShared;

            PropertyInfoPanel.add(new JLabel("Bathroom"), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            PropertyInfoPanel.add(new JLabel("Has Toilet"), new GridBagConstraints(1, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            PropertyInfoPanel.add(new JLabel("Has Bath"), new GridBagConstraints(2, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            PropertyInfoPanel.add(new JLabel("Has Shower"), new GridBagConstraints(3, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            PropertyInfoPanel.add(new JLabel("Shared"), new GridBagConstraints(4, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            y++;
            PropertyInfoPanel.add(new JLabel(""), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            PropertyInfoPanel.add(bathroomFields[i], new GridBagConstraints(1, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            PropertyInfoPanel.add(bathroomFields[i+1], new GridBagConstraints(2, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            PropertyInfoPanel.add(bathroomFields[i+2], new GridBagConstraints(3, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            PropertyInfoPanel.add(bathroomFields[i+3], new GridBagConstraints(4, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
            y++;
        }
        JCheckBox kitchenFridge = new JCheckBox();
        JCheckBox kitchenMicrowave = new JCheckBox();
        JCheckBox kitchenOven = new JCheckBox();
        JCheckBox kitchenStove = new JCheckBox();
        JCheckBox kitchenDishwasher = new JCheckBox();
        JCheckBox kitchenTableware = new JCheckBox();
        JCheckBox kitchenCookware = new JCheckBox();
        JCheckBox kitchenBasicProvisions = new JCheckBox();
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
        PropertyInfoPanel.add(kitchenFridge, new GridBagConstraints(1, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(kitchenMicrowave, new GridBagConstraints(2, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(kitchenOven, new GridBagConstraints(3, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(kitchenStove, new GridBagConstraints(4, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(kitchenDishwasher, new GridBagConstraints(5, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(kitchenTableware, new GridBagConstraints(6, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(kitchenCookware, new GridBagConstraints(7, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(kitchenBasicProvisions, new GridBagConstraints(8, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        JCheckBox livingWifi = new JCheckBox();
        JCheckBox livingTV = new JCheckBox();
        JCheckBox livingSatellite = new JCheckBox();
        JCheckBox livingStreaming = new JCheckBox();
        JCheckBox livingDVD = new JCheckBox();
        JCheckBox livingBoardGames = new JCheckBox();
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
        PropertyInfoPanel.add(livingWifi, new GridBagConstraints(1, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(livingTV, new GridBagConstraints(2, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(livingSatellite, new GridBagConstraints(3, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(livingStreaming, new GridBagConstraints(4, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(livingDVD, new GridBagConstraints(5, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(livingBoardGames, new GridBagConstraints(6, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        JCheckBox utilityCentralHeating = new JCheckBox();
        JCheckBox utilityWashingMachine = new JCheckBox();
        JCheckBox utilityDryingMachine = new JCheckBox();
        JCheckBox utilityFireExtinguisher = new JCheckBox();
        JCheckBox utilitySmokeAlarm = new JCheckBox();
        JCheckBox utilityFirstAidKit = new JCheckBox();
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
        PropertyInfoPanel.add(utilityCentralHeating, new GridBagConstraints(1, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(utilityWashingMachine, new GridBagConstraints(2, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(utilityDryingMachine, new GridBagConstraints(3, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(utilityFireExtinguisher, new GridBagConstraints(4, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(utilitySmokeAlarm, new GridBagConstraints(5, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(utilityFirstAidKit, new GridBagConstraints(6, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        JCheckBox outdoorFreeParking = new JCheckBox();
        JCheckBox outdoorRoadParking = new JCheckBox();
        JCheckBox outdoorPaidParking = new JCheckBox();
        JCheckBox outdoorPatio = new JCheckBox();
        JCheckBox outdoorBBQ = new JCheckBox();
        //OUTDOOR//
        PropertyInfoPanel.add(new JLabel("Outdoor Facility"), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Has Free Onsite Parking"), new GridBagConstraints(1, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Has On Road Parking"), new GridBagConstraints(2, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Has Paid Parking"), new GridBagConstraints(3, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Has Patio"), new GridBagConstraints(4, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(new JLabel("Has BBQ"), new GridBagConstraints(5, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        y++;
        PropertyInfoPanel.add(new JLabel(""), new GridBagConstraints(0, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(outdoorFreeParking, new GridBagConstraints(1, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(outdoorRoadParking, new GridBagConstraints(2, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(outdoorPaidParking, new GridBagConstraints(3, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(outdoorPatio, new GridBagConstraints(4, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        PropertyInfoPanel.add(outdoorBBQ, new GridBagConstraints(5, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 8));
        bottomPanel.add(btnBack);
        bottomPanel.add(btnSubmit);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(PropertyInfoPanel, BorderLayout.CENTER);
        contentPanel.add(bottomPanel, BorderLayout.SOUTH);
        setContentPane(contentPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        btnSubmit.addActionListener(e -> {
            String name = propertyName.getText();
            String description = propertyDescription.getText();
            String location = propertyLocation.getText();
            int maxGuests = 0;
            int propertyBedsNum = 0;

            if (name.length() != 0 || description.length() != 0 || location.length() != 0) {
                List<BedroomInfo> bedroomInfos = new ArrayList<>();

                for (int i = 0; i < bedroomNum*2; i+=2) {
                    String bedType1 = (String) bedroomFields[i].getItemAt(bedroomFields[i].getSelectedIndex());
                    String bedType2 = (String) bedroomFields[i+1].getItemAt(bedroomFields[i+1].getSelectedIndex());
                    int bedsNum = 0;
                    int sleepersNum = 0;
                    switch (bedType1) {
                        case "Single":
                            bedsNum++;
                            sleepersNum++;
                            break;
                        default:
                            bedsNum++;
                            sleepersNum+=2;
                    }
                    switch (bedType2) {
                        case "Null":
                            break;
                        case "Single":
                            bedsNum++;
                            sleepersNum++;
                            break;
                        default:
                            bedsNum++;
                            sleepersNum+=2;
                    }
                    bedroomInfos.add(new BedroomInfo(
                            bedType1,
                            bedType2,
                            bedsNum,
                            sleepersNum
                    ));
                    maxGuests+=sleepersNum;
                    propertyBedsNum+=bedsNum;
                }

                List<BathroomInfo> bathroomInfos = new ArrayList<>();
                for (int i = 0; i < bathroomNum*4; i+=4) {
                    boolean toilet = bathroomFields[i].isSelected();
                    boolean bath = bathroomFields[i+1].isSelected();
                    boolean shower = bathroomFields[i+2].isSelected();
                    boolean shared = bathroomFields[i+3].isSelected();

                    bathroomInfos.add(new BathroomInfo(
                            toilet,
                            bath,
                            shower,
                            shared
                    ));
                }

                PropertyInfo propertyInfo = new PropertyInfo(
                        name,
                        description,
                        location,
                        propertyBreakfast.isSelected(),
                        maxGuests,
                        0,
                        personInfo.getEmail(),
                        addressInfo.getHouseName(),
                        addressInfo.getPostcode()
                );
                SleepingInfo sleepingInfo = new SleepingInfo(
                        sleepingBedLinen.isSelected(),
                        sleepingTowels.isSelected(),
                        bedroomNum,
                        propertyBedsNum,
                        maxGuests
                );
                BathingInfo bathingInfo = new BathingInfo(
                        bathingHairDryer.isSelected(),
                        bathingShampoo.isSelected(),
                        bathingToiletPaper.isSelected(),
                        bathroomNum
                );
                KitchenInfo kitchenInfo = new KitchenInfo(
                        kitchenFridge.isSelected(),
                        kitchenMicrowave.isSelected(),
                        kitchenOven.isSelected(),
                        kitchenStove.isSelected(),
                        kitchenDishwasher.isSelected(),
                        kitchenTableware.isSelected(),
                        kitchenCookware.isSelected(),
                        kitchenBasicProvisions.isSelected()
                );
                LivingInfo livingInfo = new LivingInfo(
                        livingWifi.isSelected(),
                        livingTV.isSelected(),
                        livingSatellite.isSelected(),
                        livingStreaming.isSelected(),
                        livingDVD.isSelected(),
                        livingBoardGames.isSelected()
                );
                UtilityInfo utilityInfo = new UtilityInfo(
                        utilityCentralHeating.isSelected(),
                        utilityWashingMachine.isSelected(),
                        utilityDryingMachine.isSelected(),
                        utilityFireExtinguisher.isSelected(),
                        utilitySmokeAlarm.isSelected(),
                        utilityFirstAidKit.isSelected()
                );
                OutdoorInfo outdoorInfo = new OutdoorInfo(
                        outdoorFreeParking.isSelected(),
                        outdoorRoadParking.isSelected(),
                        outdoorPaidParking.isSelected(),
                        outdoorPatio.isSelected(),
                        outdoorBBQ.isSelected()
                );
                try {
                    Connection conn = DBAccess.connect();
                    SubmitProperty.Submit(conn,addressInfo,personInfo,propertyInfo,sleepingInfo,bedroomInfos,bathingInfo,bathroomInfos,kitchenInfo,livingInfo,utilityInfo,outdoorInfo,chargeBands);
                    new HostView(personInfo).setVisible(true);
                    this.dispose();
                } finally {
                    DBAccess.disconnect();
                }
                JOptionPane.showMessageDialog(null, "Registered property.", "Success!", JOptionPane.DEFAULT_OPTION);
            }
            else {
                JOptionPane.showMessageDialog(null, "Required field left blank.", "Error!", JOptionPane.DEFAULT_OPTION);
            }
        });

        btnBack.addActionListener(e -> {
            new HostView(personInfo).setVisible(true);
            this.dispose();
        });
    }
}
