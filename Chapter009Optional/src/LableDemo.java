import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LableDemo {

	public static void main(String[] args) 
	{
		JLabel northLabel = new JLabel("North");
		
		ImageIcon labelIcon = new ImageIcon("GUItip.gif");
		JLabel centerLabel = new JLabel (labelIcon);
		
		JLabel southLabel = new JLabel (labelIcon);
		southLabel.setText("South");
		
		JFrame app = new JFrame();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		app.add(northLabel, BorderLayout.NORTH);
		app.add(centerLabel, BorderLayout.CENTER);
		app.add(southLabel, BorderLayout.SOUTH);
	
		app.setSize(300, 300);
		app.setVisible(true);
		
		
		
	}

}
