import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Screen extends JFrame {
	private static final long serialVersionUID = 1L;
	public Screen() {
		setSize(1200, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("HomeBreaks Plc");
		
		setLayout(new FlowLayout());
		JButton hostButton = new JButton("HOST");
		
		this.add(hostButton);
		setVisible(true);
		
		setLayout(new FlowLayout());
		JButton guestButton = new JButton("GUEST");
		
		this.add(guestButton);
		setVisible(true);
		
		setLayout(new FlowLayout());
		JButton enquirerButton = new JButton("ENQUIRER");
		
		this.add(enquirerButton);
		setVisible(true);
	}
}

