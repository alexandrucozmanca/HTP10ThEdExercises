// draw a Bull`s Eye with 2 provided colors, no of circles and step
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class BullsEye extends JPanel
{
	Color color1 = new Color(0,0,0);
	Color color2 = new Color(0,0,0);

	int step, // length of circle
	numberOfCircles; // number of circles

	BullsEye (  Color color1, Color color2, // the two colors
				int step, // length of circle
				int numberOfCircles // number of circles
				)
		{
		this.color1 = color1;
		this.color2 = color2;
		this.step = step;
		this.numberOfCircles = numberOfCircles;

		}


	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		int offset = step * numberOfCircles / 2 + 10;

		// paint the bullseye with provided no. of circles and step
		for (int i = numberOfCircles; i >= 1; i--)
		{
			if (i % 2 == 1)
				g.setColor(color1);
			else
				g.setColor(color2);

			g.fillOval(offset + step/2 * (numberOfCircles - i)  , offset + step/2 * (numberOfCircles - i), i * step, i * step);
		}

	}

}
