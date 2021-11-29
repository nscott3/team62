import javax.swing.*;

public class HostProperty extends JFrame {
    String Answers[]={"Yes","No"};

    private JPanel contentPane;
    private JLabel propertyNameLabel=new JLabel("Enter the properties name:");
    private JTextField propertyName = new JTextField();
    private JLabel propertyDescLabel=new JLabel("Enter the properties description:");
    private JTextField propertyDesc = new JTextField();
    private JLabel propertyLocationLabel=new JLabel("Enter the properties location:");
    private JTextField propertyLocation = new JTextField();
    private JLabel hasBreakfastLabel=new JLabel("Does it have breakfast?");
    private JComboBox hasBreakfast= new JComboBox(Answers);
    private JLabel sleepingFacilityLabel= new JLabel("Sleeping Facilities:");
    private JCheckBox hasLinen = new JCheckBox();
    private JCheckBox hasTowel = new JCheckBox();
    private JLabel numberOfBedsLbl = new JLabel("Enter the number of beds:");
    private JTextField numberOfBeds= new JTextField();
    private JLabel bathingFacilities= new JLabel ("Bathing Facilities:");
    private JCheckBox hasHairDryer = new JCheckBox();
    private JCheckBox hasShampoo= new JCheckBox();
    private JCheckBox hasToiletpaper= new JCheckBox();
    private JCheckBox isShared= new JCheckBox();
    private JLabel numberOfBathroomsLbl = new JLabel("Enter the number of bathrooms:");
    private JTextField numberOfBathrooms= new JTextField();
    private JLabel kitchenFacilities= new JLabel("Kitchen Facilities:");
    private JCheckBox hasRefrigerator= new JCheckBox();
    private JCheckBox hasMicrowave= new JCheckBox();
    private JCheckBox hasOven= new JCheckBox();
    private JCheckBox hasStove= new JCheckBox();
    private JCheckBox hasDishwasher= new JCheckBox();
    private JCheckBox hasTableware= new JCheckBox();
    private JCheckBox hasCookware= new JCheckBox();
    private JCheckBox hasBasicProvisions= new JCheckBox();
    private JLabel livingFacilities= new JLabel("Living Facilities:");
    private JCheckBox hasWifi= new JCheckBox();
    private JCheckBox hasTV= new JCheckBox();
    private JCheckBox hasStreaming = new JCheckBox();
    private JCheckBox hasSatellite= new JCheckBox();
    private JCheckBox hasDvdplayer= new JCheckBox();
    private JCheckBox hasBoardgames= new JCheckBox();
    private JLabel utilityFacilities= new JLabel("Utilities:");
    private JCheckBox hasCentralHeating= new JCheckBox();
    private JCheckBox hasWashingMachine= new JCheckBox();
    private JCheckBox hasDryingMachine= new JCheckBox();
    private JCheckBox hasFireExtinguisher= new JCheckBox();
    private JCheckBox hasSmokeAlarm= new JCheckBox();
    private JCheckBox hasFirstAidKit= new JCheckBox();
    private JLabel outdoorFacilities = new JLabel("Outdoor facilities:");
    private JCheckBox hasFreeOnSiteParking= new JCheckBox();
    private JCheckBox hasOnRoadParking= new JCheckBox();
    private JCheckBox hasPaidParking= new JCheckBox();
    private JCheckBox hasPatio= new JCheckBox();
    private JCheckBox hasBBQ= new JCheckBox();





    public void setLocationAndSize(){
        propertyNameLabel.setBounds(50,50,200,25);
        propertyName.setBounds(250,50,200,25);

        propertyDescLabel.setBounds(50,50,250,125);
        propertyDesc.setBounds(250,100,250,100);

        propertyLocationLabel.setBounds(50,225,250,25);
        propertyLocation.setBounds(250,225,250,25);

        hasBreakfastLabel.setBounds(50,275,250,25);
        hasBreakfast.setBounds(250,275,250,25);

        sleepingFacilityLabel.setBounds(50,325,250,25);
        hasLinen.setBounds(250,325,100,25);
        hasTowel.setBounds(350,325,100,25);
        numberOfBedsLbl.setBounds(50,375,175,25);
        numberOfBeds.setBounds(250,375,175,25);

        bathingFacilities.setBounds(50,425,100,25);
        hasHairDryer.setBounds(250,425,100,25);
        hasToiletpaper.setBounds(350,425,100,25);
        hasShampoo.setBounds(450,425,100,25);
        isShared.setBounds(550,425,100,25);
        numberOfBathroomsLbl.setBounds(50,475,195,25);
        numberOfBathrooms.setBounds(250,475,175,25);

        kitchenFacilities.setBounds(50,525,150,25);
        hasRefrigerator.setBounds(250,525,100,25);
        hasMicrowave.setBounds(350,525,100,25);
        hasOven.setBounds(450,525,100,25);
        hasStove.setBounds(550,525,100,25);
        hasDishwasher.setBounds(650,525,100,25);
        hasTableware.setBounds(750,525,100,25);
        hasCookware.setBounds(850,525,125,25);
        hasBasicProvisions.setBounds(950,525,100,25);

        livingFacilities.setBounds(50,575,150,25);
        hasWifi.setBounds(250,575,100,25);
        hasTV.setBounds(350,575,100,25);
        hasSatellite.setBounds(450,575,100,25);
        hasStreaming.setBounds(550,575,100,25);
        hasDvdplayer.setBounds(650,575,100,25);
        hasBoardgames.setBounds(750,575,100,25);

        utilityFacilities.setBounds(50,625,150,25);
        hasCentralHeating.setBounds(250,625,100,25);
        hasWashingMachine.setBounds(350,625,100,25);
        hasDryingMachine.setBounds(450,625,100,25);
        hasFireExtinguisher.setBounds(550,625,100,25);
        hasSmokeAlarm.setBounds(650,625,100,25);
        hasFirstAidKit.setBounds(750,625,100,25);

        outdoorFacilities.setBounds(50,675,150,25);
        hasFreeOnSiteParking.setBounds(250,675,200,25);
        hasOnRoadParking.setBounds(450,675,200,25);
        hasPaidParking.setBounds(650,675,200,25);
        hasPatio.setBounds(850,675,200,25);
        hasBBQ.setBounds(1050,675,200,25);




    }
    public void addToContainer(){
        contentPane.add(propertyNameLabel);
        contentPane.add(propertyName);
        contentPane.add(propertyDescLabel);
        contentPane.add(propertyDesc);
        contentPane.add(propertyLocationLabel);
        contentPane.add(propertyLocation);
        contentPane.add(hasBreakfastLabel);
        contentPane.add(hasBreakfast);
        contentPane.add(sleepingFacilityLabel);
        contentPane.add(hasLinen);
        contentPane.add(hasTowel);
        contentPane.add(numberOfBedsLbl);
        contentPane.add(numberOfBeds);
        contentPane.add(bathingFacilities);
        contentPane.add(hasHairDryer);
        contentPane.add(hasShampoo);
        contentPane.add(hasToiletpaper);
        contentPane.add(isShared);
        contentPane.add(numberOfBathroomsLbl);
        contentPane.add(numberOfBathrooms);
        contentPane.add(kitchenFacilities);
        contentPane.add(hasRefrigerator);
        contentPane.add(hasMicrowave);
        contentPane.add(hasOven);
        contentPane.add(hasStove);
        contentPane.add(hasDishwasher);
        contentPane.add(hasTableware);
        contentPane.add(hasBasicProvisions);
        contentPane.add(hasCookware);
        contentPane.add(livingFacilities);
        contentPane.add(hasWifi);
        contentPane.add(hasTV);
        contentPane.add(hasSatellite);
        contentPane.add(hasStreaming);
        contentPane.add(hasDvdplayer);
        contentPane.add(hasBoardgames);
        contentPane.add(utilityFacilities);
        contentPane.add(hasCentralHeating);
        contentPane.add(hasWashingMachine);
        contentPane.add(hasDryingMachine);
        contentPane.add(hasFireExtinguisher);
        contentPane.add(hasSmokeAlarm);
        contentPane.add(hasFirstAidKit);
        contentPane.add(outdoorFacilities);
        contentPane.add(hasFreeOnSiteParking);
        contentPane.add(hasOnRoadParking);
        contentPane.add(hasPaidParking);
        contentPane.add(hasPatio);
        contentPane.add(hasBBQ);





    }
    public void checkBoxCreator(){
        hasLinen = new JCheckBox("Linen");
        hasTowel = new JCheckBox("Towel");
        hasHairDryer = new JCheckBox("Hairdryer");
        hasShampoo = new JCheckBox("Shampoo");
        hasToiletpaper = new JCheckBox("Toilet paper");
        isShared= new JCheckBox("Shared");
        hasRefrigerator = new JCheckBox("Refrigerator");
        hasMicrowave = new JCheckBox("Microwave");
        hasOven = new JCheckBox("Oven");
        hasStove = new JCheckBox("Stove");
        hasDishwasher = new JCheckBox("Dishashwer");
        hasTableware=new JCheckBox("Tableware");
        hasBasicProvisions = new JCheckBox("Basic Provisions");
        hasWifi= new JCheckBox("Wifi");
        hasTV= new JCheckBox("TV");
        hasSatellite= new JCheckBox("Satellite");
        hasStreaming= new JCheckBox("Streaming");
        hasDvdplayer= new JCheckBox("Dvd");
        hasBoardgames= new JCheckBox("Board games");
        hasCentralHeating= new JCheckBox("Central Heating");
        hasWashingMachine = new JCheckBox("Washing Machine");
        hasDryingMachine = new JCheckBox("Drying Machine");
        hasFireExtinguisher = new JCheckBox("Fire Extinguisher");
        hasSmokeAlarm = new JCheckBox("Smoke Alarm");
        hasFirstAidKit = new JCheckBox("FirstAid Kit");
        hasFreeOnSiteParking = new JCheckBox("Free On Site Parking");
        hasOnRoadParking = new JCheckBox("On road parking");
        hasPaidParking = new JCheckBox("Paid parking");
        hasPatio = new JCheckBox("Patio");
        hasBBQ = new JCheckBox("BBQ");
    }
    public  HostProperty(){

        super("Host");
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        checkBoxCreator();
        setLocationAndSize();
        addToContainer();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new HostProperty();
    }
}
