import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SwingLogin extends JFrame{
	private JPanel loginPanel = new JPanel(new GridLayout(3, 2));
	private JLabel idLabel = new JLabel("id"); 
	private JLabel pwLabel = new JLabel("password");
	private JTextField idText = new JTextField();
	private JPasswordField pwText = new JPasswordField();
	private JButton loginBtn = new JButton("log in ");
	private JButton idpwSearchBtn = new JButton("find id/pw");

	public SwingLogin() {
		super("login screen!");
		
		this.setContentPane(loginPanel);
		loginPanel.add(idLabel);
		loginPanel.add(pwLabel);
		loginPanel.add(idText);
		loginPanel.add(pwText);
		loginPanel.add(idpwSearchBtn);
		loginPanel.add(loginBtn);
		
		//arrange label on the center
		idLabel.setHorizontalAlignment(NORMAL);
		pwLabel.setHorizontalAlignment(NORMAL);
		
		//setSize in the middle of the current frame window so that the frame can be aligned in the middle normally
		setSize(350,150);
		this.setLocationRelativeTo(null);		
		
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		//login button
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//id and pw check
				String id = idText.getText().trim();
				String pw = pwText.getText().trim();
				
				if(id.length()==0 || pw.length()==0) {
					JOptionPane.showMessageDialog(null, "put id or pw", "put id or pw!", JOptionPane.DEFAULT_OPTION);
					return;
				}
				
				if(id.equals("test") && pw.equals("test1")) {
					JOptionPane.showMessageDialog(null, "log in", "log in!", JOptionPane.DEFAULT_OPTION);
					return;
				}
				
				JOptionPane.showMessageDialog(null, "log in fail", "log in!", JOptionPane.DEFAULT_OPTION);
				
			}
		});
		
		//find id and pw 
		idpwSearchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "find id and pw", "find id or pw", JOptionPane.DEFAULT_OPTION);
			}
		});
		
	}
	
//	public static void main(String[] args) {
//		new SwingLogin();
//	}
}
