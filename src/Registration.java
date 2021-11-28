import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Registration extends JFrame{
	private JPanel contentPane;
	private JLabel lblJoin;
	private JButton joinCompleteBtn;
	private JTextField tfForeName;
	private JTextField tfSurName;
	private JTextField tfEmail;
	private JTextField tfPassword;
	private JTextField tfMobileNumber;

	public Registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(430, 490);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblJoin = new JLabel("Sign Up");
		Font RegistrationPageTitle = new Font("Arial", Font.BOLD, 18); //font: Arial
		lblJoin.setFont(RegistrationPageTitle); 
		lblJoin.setBounds(159, 41, 101, 20);
		contentPane.add(lblJoin);
		
		JLabel lblForeName = new JLabel("Forename");
		lblForeName.setBounds(69, 163, 69, 20);
		contentPane.add(lblForeName);
		
		JLabel lblSurName = new JLabel("Surname");
		lblSurName.setBounds(69, 113, 69, 20);
		contentPane.add(lblSurName);
		
		JLabel lblEmail = new JLabel("Email (ID)");
		lblEmail.setBounds(69, 210, 69, 20);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(69, 257, 69, 20);
		contentPane.add(lblPassword);
		
		JLabel lblMobileNum = new JLabel("Mobile Number");
		lblMobileNum.setBounds(50, 304, 89, 20);
		contentPane.add(lblMobileNum);
		
		tfForeName = new JTextField();
		tfForeName.setColumns(10);
		tfForeName.setBounds(159, 106, 186, 35);
		contentPane.add(tfForeName);
		
		tfSurName = new JTextField();
		tfSurName.setColumns(10);
		tfSurName.setBounds(159, 156, 186, 35);
		contentPane.add(tfSurName);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(159, 203, 186, 35);
		contentPane.add(tfEmail);
		
		tfPassword = new JTextField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(159, 250, 186, 35);
		contentPane.add(tfPassword);
		
		tfMobileNumber = new JTextField();
		tfMobileNumber.setColumns(10);
		tfMobileNumber.setBounds(159, 297, 186, 35);
		contentPane.add(tfMobileNumber);
		
		joinCompleteBtn = new JButton("Sign Up");
		joinCompleteBtn.setBounds(206, 363, 139, 29);
		contentPane.add(joinCompleteBtn);
		
		setVisible(true);
		//Sign up complete
		joinCompleteBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Signed Up");
				dispose();
				
			}
		});

	}
}
