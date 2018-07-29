import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawPanel extends JPanel
{
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		int width = getWidth();
		int height = getHeight();
		int i=0, j=0;
		System.out.printf("(%d,%d)%n",width,height);

		
		// draw pattern 1
		/*
		while (i <= width && j  <= height)
		{
			g.drawLine(0, 0, i, height-j);
			g.drawLine(i, height-j, width, height);
			g.drawLine(i, j, width, 0);
			g.drawLine(i, j, 0, height);
			
			i += 20; j += 20;
		}*/
		
		//draw pattern 2
		while (i <= width && j<=height)
		{ 	g.drawLine(0, i, j, height);
			g.drawLine(i, 0, width, j);
			g.drawLine(height, height-i, j, width);
			g.drawLine(height-i, 0, 0, j);
		
			i += 20; j += 20;
		}
			
	}

}
