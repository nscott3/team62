import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.awt.event.KeyAdapter;

public class HostPropertyView extends JFrame{
    String Answers[]={"Yes","No"};
    String typesOfBeds1[]={"Single","Double","King-Size","Bunk bed"};
    String typesOfBeds2[]={"Single","Double","King-Size","Bunk bed","No Bed"};
    private JPanel contentPane;
    private JScrollPane scrollPane= new JScrollPane();
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
    private JLabel bedTypeLbl1= new JLabel("Enter the type of the 1st bed:");
    private JComboBox bedType1=new JComboBox(typesOfBeds1);
    private JLabel bedTypeLbl2= new JLabel("Enter the type of the 2nd bed:");
    private JComboBox bedType2=new JComboBox(typesOfBeds2);
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
        propertyNameLabel.setFont(new Font("Calibri", Font.PLAIN, 14));

        propertyDescLabel.setBounds(50,50,250,125);
        propertyDescLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
        propertyDesc.setBounds(250,100,250,100);

        propertyLocationLabel.setBounds(50,225,250,25);
        propertyLocationLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
        propertyLocation.setBounds(250,225,250,25);

        hasBreakfastLabel.setBounds(50,275,250,25);
        hasBreakfastLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
        hasBreakfast.setBounds(250,275,250,25);

        sleepingFacilityLabel.setBounds(50,325,250,25);
        sleepingFacilityLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
        hasLinen.setBounds(250,325,100,25);
        hasLinen.setFont(new Font("Calibri", Font.BOLD, 14));
        hasTowel.setBounds(350,325,100,25);
        hasLinen.setFont(new Font("Calibri", Font.BOLD, 14));
        numberOfBedsLbl.setBounds(50,375,175,25);
        numberOfBedsLbl.setFont(new Font("Calibri", Font.PLAIN, 14));
        numberOfBeds.setBounds(250,375,175,25);

        bedTypeLbl1.setBounds(50,425,165,25);
        bedTypeLbl1.setFont(new Font("Calibri", Font.PLAIN,14));
        bedType1.setBounds(250,425,100,25);
        bedTypeLbl2.setBounds(50,475,175,25);
        bedTypeLbl2.setFont(new Font("Calibri",Font.PLAIN,14));
        bedType2.setBounds(250,475,100,25);

        bathingFacilities.setBounds(50,525,100,25);
        bathingFacilities.setFont(new Font("Calibri", Font.PLAIN, 14));
        hasHairDryer.setBounds(250,525,100,25);
        hasLinen.setFont(new Font("Calibri", Font.BOLD, 14));
        hasToiletpaper.setBounds(350,525,100,25);
        hasToiletpaper.setFont(new Font("Calibri", Font.BOLD, 14));
        hasShampoo.setBounds(450,525,100,25);
        hasShampoo.setFont(new Font("Calibri", Font.BOLD, 14));
        isShared.setBounds(550,525,100,25);
        isShared.setFont(new Font("Calibri", Font.BOLD, 14));
        numberOfBathroomsLbl.setBounds(50,575,195,25);
        numberOfBathroomsLbl.setFont(new Font("Calibri", Font.PLAIN, 14));
        numberOfBathrooms.setBounds(250,575,175,25);

        kitchenFacilities.setBounds(50,625,150,25);
        kitchenFacilities.setFont(new Font("Calibri", Font.PLAIN, 14));
        hasRefrigerator.setBounds(250,625,100,25);
        hasRefrigerator.setFont(new Font("Calibri", Font.BOLD, 14));
        hasMicrowave.setBounds(350,625,100,25);
        hasMicrowave.setFont(new Font("Calibri", Font.BOLD, 14));
        hasOven.setBounds(450,625,100,25);
        hasOven.setFont(new Font("Calibri", Font.BOLD, 14));
        hasStove.setBounds(550,625,100,25);
        hasStove.setFont(new Font("Calibri", Font.BOLD, 14));
        hasDishwasher.setBounds(650,625,100,25);
        hasDishwasher.setFont(new Font("Calibri", Font.BOLD, 14));
        hasTableware.setBounds(750,625,100,25);
        hasTableware.setFont(new Font("Calibri", Font.BOLD, 14));
        hasCookware.setBounds(850,625,100,25);
        hasCookware.setFont(new Font("Calibri", Font.BOLD, 14));
        hasBasicProvisions.setBounds(950,625,125,25);
        hasBasicProvisions.setFont(new Font("Calibri", Font.BOLD, 14));

        livingFacilities.setBounds(50,675,150,25);
        livingFacilities.setFont(new Font("Calibri", Font.PLAIN, 14));
        hasWifi.setBounds(250,675,100,25);
        hasWifi.setFont(new Font("Calibri", Font.BOLD, 14));
        hasTV.setBounds(350,675,100,25);
        hasTV.setFont(new Font("Calibri", Font.BOLD, 14));
        hasSatellite.setBounds(450,675,100,25);
        hasSatellite.setFont(new Font("Calibri", Font.BOLD, 14));
        hasStreaming.setBounds(550,675,100,25);
        hasStreaming.setFont(new Font("Calibri", Font.BOLD, 14));
        hasDvdplayer.setBounds(650,675,100,25);
        hasDvdplayer.setFont(new Font("Calibri", Font.BOLD, 14));
        hasBoardgames.setBounds(750,675,125,25);
        hasBoardgames.setFont(new Font("Calibri", Font.BOLD, 14));

        utilityFacilities.setBounds(50,725,150,25);
        utilityFacilities.setFont(new Font("Calibri", Font.PLAIN, 14));
        hasCentralHeating.setBounds(250,725,200,25);
        hasCentralHeating.setFont(new Font("Calibri", Font.BOLD, 14));
        hasWashingMachine.setBounds(450,725,200,25);
        hasWashingMachine.setFont(new Font("Calibri", Font.BOLD, 14));
        hasDryingMachine.setBounds(650,725,200,25);
        hasDryingMachine.setFont(new Font("Calibri", Font.BOLD, 14));
        hasFireExtinguisher.setBounds(850,725,200,25);
        hasFireExtinguisher.setFont(new Font("Calibri", Font.BOLD, 14));
        hasSmokeAlarm.setBounds(1050,725,200,25);
        hasSmokeAlarm.setFont(new Font("Calibri", Font.BOLD, 14));
        hasFirstAidKit.setBounds(1250,725,200,25);
        hasFirstAidKit.setFont(new Font("Calibri", Font.BOLD, 14));

        outdoorFacilities.setBounds(50,775,150,25);
        outdoorFacilities.setFont(new Font("Calibri", Font.PLAIN, 14));
        hasFreeOnSiteParking.setBounds(250,775,200,25);
        hasFreeOnSiteParking.setFont(new Font("Calibri", Font.BOLD, 14));
        hasOnRoadParking.setBounds(450,775,200,25);
        hasSmokeAlarm.setFont(new Font("Calibri", Font.BOLD, 14));
        hasPaidParking.setBounds(650,775,200,25);
        hasPaidParking.setFont(new Font("Calibri", Font.BOLD, 14));
        hasPatio.setBounds(850,775,200,25);
        hasPatio.setFont(new Font("Calibri", Font.BOLD, 14));
        hasBBQ.setBounds(1050,775,200,25);
        hasBBQ.setFont(new Font("Calibri", Font.BOLD, 14));

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
        contentPane.add(bedType1);
        contentPane.add(bedTypeLbl1);
        contentPane.add(bedType2);
        contentPane.add(bedTypeLbl2);
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
        button.setBounds(50, 825, 200, 25);
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
    public void sleepersNum(){
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s1=(String) bedType1.getSelectedItem();
                String s2=(String) bedType2.getSelectedItem();
                int temp=0;
                if(s1.equals("Single")){
                    temp++;
                }else{
                    temp+=2;
                }
                if(s2.equals("Single")){
                    temp++;
                }else if(s2.equals("No Bed")){
                    temp+=0;
                }else{
                    temp+=2;
                }
            }
        };
    }

    public  HostPropertyView(){

        super("Host");
        contentPane = new JPanel();
        setContentPane(contentPane);
        setResizable(false);
        setPreferredSize(new Dimension(1980, 1280/12*9));
        setSize(2048, 1280/12*9);
        setLocationRelativeTo(null);
        contentPane.setLayout(null);

        checkBoxCreator();
        setLocationAndSize();
        addToContainer();
        checkForm();
        sleepersNum();


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /*public static void main(String[] args) {
        new HostProperty();
    }*/
}
