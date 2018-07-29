import java.awt.Color;
import java.awt.Graphics;
import java.security.SecureRandom;
import javax.swing.JPanel;

public class DrawPanel extends JPanel
{

	private SecureRandom randomNumbers = new SecureRandom();
	private MyLine[] lines; // lines array
	private MyOval[] ovals; // lines array
	private MyRectangle[] rectangles;

	public DrawPanel()
	{
		setBackground(Color.WHITE);
		lines = new MyLine[1 + randomNumbers.nextInt(5)];
		ovals = new MyOval[1 + randomNumbers.nextInt(5)];
		rectangles = new MyRectangle[1 + randomNumbers.nextInt(5)];
		boolean filled;

		//create lines

		for (int count = 0; count < 11; count ++)
		{
			filled = false;
			//int x1 = randomNumbers.nextInt(300);
			//int y1 = randomNumbers.nextInt(300);
			//int x2 = randomNumbers.nextInt(300);
			//int y2 = randomNumbers.nextInt(300);

			// generate random color
			Color color = new Color (randomNumbers.nextInt(256),randomNumbers.nextInt(256),
					randomNumbers.nextInt(256));

			// add the line to the line array
			if (randomNumbers.nextInt(300) < 150)
				filled = true;
			try
			{
				lines[count] = new MyLine(randomNumbers.nextInt(300),randomNumbers.nextInt(300),
					randomNumbers.nextInt(300),randomNumbers.nextInt(300), color);
				ovals[count] = new MyOval(randomNumbers.nextInt(300),randomNumbers.nextInt(300),
					randomNumbers.nextInt(300),randomNumbers.nextInt(300), color, filled);
				rectangles[count] = new MyRectangle(randomNumbers.nextInt(300),randomNumbers.nextInt(300),
					randomNumbers.nextInt(300),randomNumbers.nextInt(300), color, filled);
			}
			catch (ArrayIndexOutOfBoundsException e)
			{

			}

		}
	}

	
	public int getLines()
	{
		return lines.length;
	}

	public int getOvals()
	{
		return ovals.length;
	}

	public int getRectangles()
	{
		return rectangles.length;
	}

	
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		// draw the lines
		for (int line = 0; line < 11; line ++)

		try
		{
			lines[line].draw(g);
			ovals[line].draw(g);
			rectangles[line].draw(g);
		}

		catch (ArrayIndexOutOfBoundsException e)
		{

		}
	}

	

}// end class DrawPannel
