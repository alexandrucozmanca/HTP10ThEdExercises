package Exercise013_27;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PieChart 
{
	public static void main (String[] args)
	{
		JFrame app = new JFrame("PieChart");
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(250, 250);
		app.setVisible(true);
		addPie(app);
	}

	
	static void addPie(JFrame frame)
	{
		
		JPanel canvas = new JPanel()
		{
			@Override
			public void paintComponent(Graphics g)
			{
				int no1 = 30, no2 = 60, no3 = 90 , no4 = 180;
				double percentNo1 = (double)no1 / (no1 + no2 + no3 + no4);
				double percentNo2 = (double)no2 / (no1 + no2 + no3 + no4);
				double percentNo3 = (double)no3 / (no1 + no2 + no3 + no4);
				double percentNo4 = (double)no4 / (no1 + no2 + no3 + no4);
				
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;
				g2d.setColor(Color.RED);
				g2d.fill(new Arc2D.Double(20, 20, 150, 150, 0, 360 * percentNo1, Arc2D.PIE));
				g2d.setColor(Color.BLUE);
				g2d.fill(new Arc2D.Double(20, 20, 150, 150, 360 * percentNo1, 360 * percentNo2, Arc2D.PIE));
				g2d.setColor(Color.GREEN);
				g2d.fill(new Arc2D.Double(20, 20, 150, 150, 360 * (percentNo2 + percentNo1), 360 * percentNo3, Arc2D.PIE));
				g2d.setColor(Color.YELLOW);				
				g2d.fill(new Arc2D.Double(20, 20, 150, 150, 360 * (percentNo3 + percentNo2 + percentNo1), 360 * percentNo4, Arc2D.PIE));
			}
		};
		
		canvas.setBackground(Color.WHITE);
		canvas.setBounds(0, 0, 150, 150);
		frame.add(canvas);
	}
	
	
}
