import java.awt.Graphics;
import javax.swing.JPanel;

public class ShapesStudyExercise extends JPanel
{
	private int choice; // choice of shape to draw
	public int startX, startY, lenght, width; // shape characteristics
	private int noShapes; // no. of shapes to draw

	// constructor with choice input

	public ShapesStudyExercise (int choice, int startX, int startY, int lenght, int width,
			int noShapes)
	{
		this.choice = choice;
		this.startX = startX;
		this.startY = startY;
		this.lenght = lenght;
		this.width = width;
		this.noShapes = noShapes;
	}

	// draw multiple shapes starting from given X and Y with given Length and Width
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		for (int i = 1; i <= noShapes; i++ ) // draw the desired no. of shapes
		{
			// pick shape based on user choice
			switch (choice)
			{
				case 1: // draw rectangles
					g.drawRect(startX - lenght/2*i, startY - lenght/2*i, lenght * i, width * i);
					break;

				case 2: // draw ovals
					g.drawOval(startX - lenght/2*i, startY - lenght/2*i, lenght * i, width * i);
					break;
			}
		}
	}

}
