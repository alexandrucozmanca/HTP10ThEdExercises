import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawCurveSpiral extends JPanel
{

	int arc = 0;
	
	public DrawCurveSpiral (int arc)
	{
		this.arc = arc;
	}
	
	public void paintComponent(Graphics g)
	{
		int lenght = 20;
		int startingX, startingY, recurence;

		startingX = getWidth()/2;
		startingY = getHeight()/2;
		
		
		
		recurence = (getWidth() / lenght ) - 2;
		System.out.println(recurence);

		super.paintComponent(g);
					
		for (int i = 0; i < recurence; i++)
		{
			g.drawArc(startingX - (i + 1) / 2 * lenght, startingY - i * lenght/2, lenght * (i + 1) , lenght * (i + 1), (arc % 360), 180);
			
			arc += 180;
			
		}
		
		
	}


}
