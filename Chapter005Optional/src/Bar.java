import java.awt.Graphics;
import javax.swing.JPanel;

public class Bar extends JPanel
{
	private int noOfBars; // number of bars to display
	int[] lenght = new int[noOfBars];

	// constructor with choice input

	public Bar (int noOfBars, int[] lenght)
	{
		this.noOfBars = noOfBars;
		this.lenght = lenght;
	}

	// draw desired shapes starting from default position (0, 15) and incrementing for each new bar

		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);

			for (int i = 0; i< noOfBars; i++)
				for (int j = 1; j <= lenght[i]; j++) g.drawRect(0, 5 + i * 20 ,j * 15 , 15);


		}

}
