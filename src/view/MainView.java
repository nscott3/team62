package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;


public class MainView extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel loginPanel = new JPanel();
	private JLabel idLabel = new JLabel("ID"); 
	private JLabel pwLabel = new JLabel("Password");
	private JTextField idText = new JTextField();
	private JPasswordField pwText = new JPasswordField();
	private JButton loginBtn = new JButton("Log in ");
	private JButton idpwSearchBtn = new JButton("Find ID/PW");
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
		idLabel.setBounds(439, 231, 29, 33);
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
				//id and pw check
				String id = idText.getText().trim();
				String pw = pwText.getText().trim();
				
				
				if(id.length()==0 || pw.length()==0) {
					JOptionPane.showMessageDialog(null, "put id or pw", "put id or pw", JOptionPane.DEFAULT_OPTION);
					
				}
				
				//checkbox
				if(hostCheck.isSelected() && guestCheck.isSelected()) {
					JOptionPane.showMessageDialog(null, "check only one", "check only one", JOptionPane.DEFAULT_OPTION);

				}else if(hostCheck.isSelected()) {
					if(id.equals("test") && pw.equals("test1")) {
						JOptionPane.showMessageDialog(null, "log in", "log in", JOptionPane.DEFAULT_OPTION);

					}else {
						JOptionPane.showMessageDialog(null, "log in fail", "log in!", JOptionPane.DEFAULT_OPTION);
					}
				}else if(guestCheck.isSelected()) {
					if(id.equals("test2") && pw.equals("test2")) {
						JOptionPane.showMessageDialog(null, "log in", "log in", JOptionPane.DEFAULT_OPTION);
						new GuestView();
						setVisible(false);
					}else {
						JOptionPane.showMessageDialog(null, "log in fail", "log in!", JOptionPane.DEFAULT_OPTION);
					}
				}else {
					JOptionPane.showMessageDialog(null, "log in fail", "log in!", JOptionPane.DEFAULT_OPTION);
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
		idpwSearchBtn.setBounds(591, 324, 186, 38);
		loginPanel.add(idpwSearchBtn);
		idpwSearchBtn.setFont(new Font("Calibri", Font.PLAIN, 14));
		signUp.setBounds(401, 324, 180, 38);
		loginPanel.add(signUp);
		signUp.setFont(new Font("Calibri", Font.PLAIN, 14));
		guestCheck.setBounds(487, 292, 59, 25);
		loginPanel.add(guestCheck);
		guestCheck.setFont(new Font("Calibri", Font.PLAIN, 14));
		hostCheck.setBounds(558, 292, 51, 25);
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
		
		//find id and pw 
		idpwSearchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "find id and pw", "find id or pw", JOptionPane.DEFAULT_OPTION);
			}
		});
	}
}

