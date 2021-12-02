package view;
import model.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import javax.swing.*;


public class MainView extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel loginPanel = new JPanel();
	private JLabel idLabel = new JLabel("Email");
	private JLabel pwLabel = new JLabel("Password");
	private JTextField idText = new JTextField();
	private JPasswordField pwText = new JPasswordField();
	private JButton loginBtn = new JButton("Log in ");
	//private JButton idpwSearchBtn = new JButton("Find ID/PW");
	private JButton enquirerButton = new JButton("ENQUIRER");
	private JButton signUp = new JButton("Registration");
	private final JCheckBox guestCheck = new JCheckBox("Guest");
	private final JCheckBox hostCheck = new JCheckBox("Host");
	
	public MainView() {
		//setSize in the middle of the current frame window so that the frame can be aligned in the middle normally
		setResizable(false);
	    setVisible(true);
	    setPreferredSize(new Dimension(1200, 720/12*9));
	    setSize(1200, 720/12*9);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("HomeBreaks Plc");
		
		this.setContentPane(loginPanel);
		loginPanel.setLayout(null);
		idLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		idLabel.setBounds(429, 231, 50, 33);
		loginPanel.add(idLabel);
		pwLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		pwLabel.setBounds(401, 261, 73, 23);
		loginPanel.add(pwLabel);
		idText.setBounds(487, 233, 150, 25);
		loginPanel.add(idText);
		pwText.setBounds(487, 260, 150, 25);
		loginPanel.add(pwText);
		loginBtn.setFont(new Font("Calibri", Font.PLAIN, 16));
		loginBtn.setBounds(647, 231, 130, 35);
		loginPanel.add(loginBtn);
		enquirerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		enquirerButton.setFont(new Font("Calibri", Font.PLAIN, 14));
		enquirerButton.setBounds(647, 277, 130, 33);
		loginPanel.add(enquirerButton);		
		
		//login button
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                try {
                    //id and pw check
                    String id = idText.getText().trim();
                    String pw = pwText.getText().trim();
                    boolean hostSelected = hostCheck.isSelected();
                    boolean guestSelected = guestCheck.isSelected();
                    if(id.length()==0 || pw.length()==0) {
                        JOptionPane.showMessageDialog(null, "Required field left blank.", "Error!", JOptionPane.DEFAULT_OPTION);
                    }
                    else {
                        if (hostSelected ^ guestSelected) {
                            Connection conn = DBAccess.connect();
                            if (Person.checkUserExists(conn, id)) {
                                if (Person.login(conn, id, pw)) {
                                    if (hostSelected) {
                                        if (Host.checkHostExists(conn , id)) {
                                            JOptionPane.showMessageDialog(null, "Logged in as Host!", "Success!", JOptionPane.DEFAULT_OPTION);
                                        }
                                        else {
                                            JOptionPane.showMessageDialog(null, "User is not registered as a Host.", "Error!", JOptionPane.DEFAULT_OPTION);
                                        }
                                    }
                                    else if (guestSelected) {
                                        if (Guest.checkGuestExists(conn , id)) {
                                            JOptionPane.showMessageDialog(null, "Logged in as Guest!", "Success!", JOptionPane.DEFAULT_OPTION);
                                        }
                                        else {
                                            JOptionPane.showMessageDialog(null, "User is not registered as a Guest.", "Error!", JOptionPane.DEFAULT_OPTION);
                                        }
                                    }
                                }
                                else {
                                    JOptionPane.showMessageDialog(null, "Invalid password.", "Error!", JOptionPane.DEFAULT_OPTION);
                                }
                            }
                            else {
                                JOptionPane.showMessageDialog(null, "User does not exist. Please register.", "Error!", JOptionPane.DEFAULT_OPTION);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Select either Guest or Host.", "Error!", JOptionPane.DEFAULT_OPTION);
                        }
                    }

                } finally {
                    DBAccess.disconnect();
                }
            }
		});

		
		//arrange label on the center
		idLabel.setHorizontalAlignment(NORMAL);
		pwLabel.setHorizontalAlignment(NORMAL);
		
		JLabel lblNewLabel = new JLabel("Welcome to HomeBreaks Plc!");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 40));
		lblNewLabel.setBounds(317, 147, 562, 40);
		loginPanel.add(lblNewLabel);
		signUp.setBounds(500, 324, 180, 38);
		loginPanel.add(signUp);
		signUp.setFont(new Font("Calibri", Font.PLAIN, 14));
		guestCheck.setBounds(450, 292, 100, 25);
		loginPanel.add(guestCheck);
		guestCheck.setFont(new Font("Calibri", Font.PLAIN, 14));
		hostCheck.setBounds(550, 292, 100, 25);
		loginPanel.add(hostCheck);
		hostCheck.setFont(new Font("Calibri", Font.PLAIN, 14));
		

		signUp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new RegistrationView();
				setVisible(false);
			}
		});

	}
}

