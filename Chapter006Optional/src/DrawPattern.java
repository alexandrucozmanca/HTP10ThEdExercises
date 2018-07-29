// Draw a pattern of 10 by 10 cells with 3 alternating colors
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawPattern extends JPanel
{
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		// set up the printing pattern for squares 10 X 10 in a patern of 10 x 10
		for (int i = 1; i <= 10; i++)
			for (int j = 1; j<= 10; j++)
			{
				// alternate the 3 colors
				switch ((i + j) % 3)
				{
				case 0:
					g.setColor(Color.BLACK);
					break;

				case 1:
					g.setColor(Color.YELLOW);
					break;

				case 2:
					g.setColor(Color.RED);
					break;
				}

				g.fillRect(1 + i * 10, 1+ j * 10, 10, 10);
			} // end of pattern

	}

}// end of DrawPattern class
