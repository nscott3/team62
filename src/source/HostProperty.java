package source;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.awt.event.KeyAdapter;

public class HostProperty extends JFrame{
    String Answers[]={"Yes","No"};

    private JPanel contentPane;
    private JLabel propertyNameLabel=new JLabel("Enter the properties name:");
    private JTextField propertyName = new JTextField();
    private JLabel propertyDescLabel=new JLabel("Enter the properties description:");
    private JTextArea propertyDesc = new JTextArea();
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
    private JButton button = new JButton();

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
        hasCookware.setBounds(850,525,100,25);
        hasBasicProvisions.setBounds(950,525,125,25);

        livingFacilities.setBounds(50,575,150,25);
        hasWifi.setBounds(250,575,100,25);
        hasTV.setBounds(350,575,100,25);
        hasSatellite.setBounds(450,575,100,25);
        hasStreaming.setBounds(550,575,100,25);
        hasDvdplayer.setBounds(650,575,100,25);
        hasBoardgames.setBounds(750,575,125,25);

        utilityFacilities.setBounds(50,625,150,25);
        hasCentralHeating.setBounds(250,625,200,25);
        hasWashingMachine.setBounds(450,625,200,25);
        hasDryingMachine.setBounds(650,625,200,25);
        hasFireExtinguisher.setBounds(850,625,200,25);
        hasSmokeAlarm.setBounds(1050,625,200,25);
        hasFirstAidKit.setBounds(1250,625,200,25);

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
        contentPane.add(hasCookware);
        contentPane.add(hasBasicProvisions);
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
        hasCookware = new JCheckBox("Cookware");
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
    public void submitButton ()  {
        button = new JButton("Submit");
        contentPane.add(button);
        button.setBounds(50, 725, 200, 25);
        button.setFocusable(false);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Boolean isCorrectlyRegistered=true;

                if(propertyName.getText().length()==0 ||  propertyDesc.getText().length()==0 || propertyLocation.getText().length()==0  ) {
                    JOptionPane.showMessageDialog(null, "Please check again the details of the property");
                    isCorrectlyRegistered=false;
                }

                if(Integer.parseInt(numberOfBeds.getText())<0){
                    JOptionPane.showMessageDialog(null, "Please enter a correct amount of beds");
                    isCorrectlyRegistered=false;
                }else if(Integer.parseInt(numberOfBathrooms.getText())<0){
                    JOptionPane.showMessageDialog(null, "Please enter a correct amount of bathrooms");
                    isCorrectlyRegistered=false;
                }

                Object source = e.getSource();
                if(source==button && isCorrectlyRegistered) {
                    JOptionPane.showMessageDialog(null, "Congrats you have registered");
                }

            }
        });
    }
    public void checkNr(JTextField nr){
        nr.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    int nrToInt=Integer.parseInt(nr.getText().trim());
                    if(nrToInt<0){
                        JOptionPane.showMessageDialog(null, "Please enter a correct number");
                    }
                }
            }
            public void keyReleased(KeyEvent e){

            }
            public void keyTyped(KeyEvent e){

            }

        });
    }
    public void checkNullTF(JTextField txt){
        txt.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String text=txt.getText();
                    if(text.length()==0){
                        JOptionPane.showMessageDialog(null, "This textfield cannot be empty!");
                    }
                }
            }
            public void keyReleased(KeyEvent e) {

            }
            public void keyTyped(KeyEvent e) {

            }
        });
    }
    public void checkNullTA(JTextArea txt){
        txt.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String text=txt.getText();
                    if(text.length()==0){
                        JOptionPane.showMessageDialog(null, "This textfield cannot be empty!");
                    }
                }
            }
            public void keyReleased(KeyEvent e) {

            }
            public void keyTyped(KeyEvent e) {

            }
        });
    }
    public void checkForm(){

        checkNullTF(propertyName);
        checkNullTF(propertyLocation);
        checkNullTA(propertyDesc);
        checkNullTF(numberOfBeds);
        checkNullTF(numberOfBathrooms);
        checkNr(numberOfBeds);
        checkNr(numberOfBathrooms);
        submitButton();
    }

    public  HostProperty(){

        super("Host");
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);


        checkBoxCreator();
        setLocationAndSize();
        addToContainer();
        checkForm();


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new HostProperty();
    }
}
