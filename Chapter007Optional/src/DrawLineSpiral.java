import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawLineSpiral extends JPanel
{

	
	public void paintComponent(Graphics g)
	{
		int lenght = 20;
		int startingX, startingY, endingX = 0, endingY = 0, recurence;
		
		startingX = getWidth()/2;
		startingY = getHeight()/2;
		endingX = startingX;
		endingY = startingY;
		recurence = 2 * (getWidth() / lenght ) - 2;
						
		super.paintComponent(g);
	
		for (int i = 0; i < recurence; i++)
		{
			if (i % 2 == 0 && i > 1) 
				lenght += 20;
			
			switch (i % 4)
			{
				case 0:
					endingY = startingY + lenght;
					break;
				case 1:
					endingX = startingX - lenght;
					break;
				case 2:
					endingY = startingY - lenght;
					break;
				case 3:
					endingX = startingX + lenght;
					break;
			}
			
						
			g.drawLine(startingX, startingY, endingX, endingY);
			
			startingX = endingX;
			startingY = endingY;
			
		}
		
		//g.drawLine(startingX, startingY, endingX, endingY);
	}
	
	
}
