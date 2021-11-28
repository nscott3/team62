import javax.swing.*;
import java.awt.*;

import static sun.plugin.javascript.navig.JSType.Location;

public class HostProperty extends JFrame {
    String Answers[]={"Yes","No"};
    private JPanel HostPropertyPanel = new JPanel();

    private JLabel propertyNameLabel=new JLabel("Enter the properties name:");
    private JTextField propertyName = new JTextField();
    private JLabel propertyDescLabel=new JLabel("Enter the properties description:");
    private JTextField propertyDesc = new JTextField();
    private JLabel propertyLocationLabel=new JLabel("Enter the properties location:");
    private JTextField propertyLocation = new JTextField();
    private JLabel hasBreakfastLabel=new JLabel("Does it have breakfast?");
    private JComboBox hasBreakfast= new JComboBox(Answers);





    public  HostProperty(){

        super("Host");
        Container contentPane=getContentPane();
        contentPane.setLayout(null);



        propertyNameLabel.setBounds(50,50,200,25);
        propertyName.setBounds(250,50,200,25);
        propertyDescLabel.setBounds(50,50,250,125);
        propertyDesc.setBounds(250,100,250,100);
        propertyLocationLabel.setBounds(50,225,250,25);
        propertyLocation.setBounds(250,225,250,25);
        hasBreakfastLabel.setBounds(50,275,250,25);
        hasBreakfast.setBounds(250,275,250,25);

        contentPane.add(propertyNameLabel);
        contentPane.add(propertyName);
        contentPane.add(propertyDescLabel);
        contentPane.add(propertyDesc);
        contentPane.add(propertyLocationLabel);
        contentPane.add(propertyLocation);

        contentPane.add(hasBreakfastLabel);
        contentPane.add(hasBreakfast);


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new HostProperty();
    }
}
