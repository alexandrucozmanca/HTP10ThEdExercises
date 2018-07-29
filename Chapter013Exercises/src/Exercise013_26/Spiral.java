package Exercise013_26;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Spiral 
{
	public static void main (String[] args)
	{
		JFrame app = new JFrame("Spirals");
		app.setSize(300, 300);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
		
		placeComponents(app);
		
		
		
	}
	
	private static void placeComponents(JFrame frame)
	{
		frame.setLayout(null);
				
		JPanel panel = new JPanel()
		{
			@Override
			public void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;
				g2d.translate(100, 100);
				
				for (int side = 0; side < 38; side ++)
				{
					g2d.drawLine(0 + 3 * side / 2, 4 + 3 * side / 2, 18 + 3 * side / 2, 0 + 3 * side / 2);
					
					g2d.rotate(-Math.PI / 8);
				}
				
				
			}
		};
		
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 300, 300);
		frame.add(panel);
		
	}
}
