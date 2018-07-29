import java.awt.Graphics;
import javax.swing.JPanel;

public class Shapes extends JPanel
{
	private int choice; // choice of shape to draw

	// constructor with choice input

	public Shapes (int userChoice)
	{
		choice = userChoice;
	}

	// draw multiple shapes starting from top-left
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		for (int i = 0; i < 10; i++)
		{
			// pick shape based on user choice
			switch (choice)
			{
			case 1: // draw rectangles
				g.drawRect(10 + i * 10, 10 + i * 10, 50 + i * 10, 50 + i * 10);
				break;

			case 2: // draw ovals
				g.drawRect(10 + i * 10, 10 + i * 10, 50 + i * 10, 50 + i * 10);
				break;
			}
		}
	}

}
