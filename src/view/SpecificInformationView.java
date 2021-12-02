package view;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class SpecificInformationView extends JFrame{
	public SpecificInformationView() {
		setResizable(false);
    	setPreferredSize(new Dimension(1200, 720/12*9));
	    setSize(1200, 720/12*9);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("HomeBreaks Plc");
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 1162, 348);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTitle = new JLabel("Specific Information");
		lblTitle.setBounds(12, 10, 123, 15);
		panel.add(lblTitle);
		
		
	}
}
