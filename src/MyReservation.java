import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyReservation extends JFrame{
	public MyReservation() {
		setResizable(false);
	    setPreferredSize(new Dimension(1200, 720/12*9));
	    setSize(1200, 720/12*9);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("HomeBreaks Plc");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(35, 11, 49, 14);
		getContentPane().add(lblNewLabel);
		
		
	}
}
