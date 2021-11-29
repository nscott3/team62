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


public class Frame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel loginPanel = new JPanel(new GridLayout(0,2));
	private JLabel idLabel = new JLabel("ID"); 
	private JLabel pwLabel = new JLabel("Password");
	private JTextField idText = new JTextField();
	private JPasswordField pwText = new JPasswordField();
	private JButton loginBtn = new JButton("Log in ");
	private JButton idpwSearchBtn = new JButton("Find ID/PW");
	private JButton enquirerButton = new JButton("ENQUIRER");
	private JButton signUp = new JButton("Registration");
	private final JPanel checkPanel = new JPanel(new GridLayout(0,2));
	private final JCheckBox guestCheck = new JCheckBox("Guest");
	private final JCheckBox hostCheck = new JCheckBox("Host");
	private final JPanel splitPanel = new JPanel(new GridLayout(0,2));
	
	public Frame() {
		//setSize in the middle of the current frame window so that the frame can be aligned in the middle normally
		setResizable(false);
	    setVisible(true);
	    setPreferredSize(new Dimension(1200, 720/12*9));
	    setSize(1200, 720/12*9);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("HomeBreaks Plc");
		
		this.setContentPane(loginPanel);
		loginPanel.add(idLabel);
		loginPanel.add(pwLabel);
		loginPanel.add(idText);
		loginPanel.add(pwText);
		
		loginPanel.add(checkPanel);
		checkPanel.add(guestCheck);
		checkPanel.add(hostCheck);
		loginPanel.add(loginBtn);
		loginPanel.add(splitPanel);
		splitPanel.add(signUp);
		splitPanel.add(idpwSearchBtn);
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
						new Guest();
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
		

		
		//find id and pw 
		idpwSearchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "find id and pw", "find id or pw", JOptionPane.DEFAULT_OPTION);
			}
		});
		

		signUp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Registration();
				setVisible(false);
			}
		});
	}
}

