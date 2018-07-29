import java.awt.Color;
import java.awt.Graphics;

public class MyLine
{

	private int x1; // x coordinate of first endpoint
	private int y1; // y coordinate of first endpoint
	private int x2; //x coordinate of second endpoint
	private int y2; // y coordinate of second endpoint
	private Color color; // color of this line

	// constructor with input values
	public MyLine(int x1, int y1, int x2, int y2, Color color)
	{
		setX1(x1);
		setY1(y1);
		setX2(x2);
		setY2(y2);
		setColor(color);
	}


	public void setX1(int x1)
	{
		if (x1 >= 0)
			this.x1 = x1;
		else
			this.x1 = 0;
	}

	public void setY1(int y1)
	{
		if (y1 >= 0)
			this.y1 = y1;
		else
			this.y1 = 0;
	}

	public void setX2(int x2)
	{
		if (x2 >= 0)
			this.x2 = x2;
		else
			this.x2 = 0;
	}

	public void setY2(int y2)
	{
		if (y2 >= 0)
			this.y2 = y2;
		else
			this.y2 = 0;
	}

	public void setColor (Color color)
	{
		if (color.getGreen() < 0 || color.getGreen() > 255)
			color = Color.BLACK;
		if (color.getBlue() < 0 || color.getBlue() > 255)
			color = Color.BLACK;
		if (color.getRed() < 0 || color.getRed() > 255)
			color = Color.BLACK;
		this.color = color;
	}

	// draw the line in the specified color
	public void draw(Graphics g)
	{
	g.setColor(color);
	g.drawLine(x1, y1, x2, y2);
	}
} //end class MyLine


